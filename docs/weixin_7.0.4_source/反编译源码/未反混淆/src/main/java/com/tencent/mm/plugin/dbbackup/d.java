package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.at.o;
import com.tencent.mm.cd.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.j;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d implements at {
    private static final SQLiteCipherSpec kIB = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private boolean jZS = false;
    private boolean jZT = true;
    private BroadcastReceiver jZU;
    private Runnable jZV;
    private c kIA;
    private volatile BackupKit kIn;
    private volatile RecoverKit kIo;
    private volatile RepairKit kIp;
    private volatile boolean kIq = false;
    private boolean kIr = false;
    private boolean kIs = false;
    private long kIt = 0;
    private long kIu = 600000;
    private long kIv = 0;
    private int kIw = 10;
    private boolean kIx = false;
    final SimpleDateFormat kIy = new SimpleDateFormat("HH:mm:ss.SSS");
    private a kIz;

    /* renamed from: com.tencent.mm.plugin.dbbackup.d$5 */
    class AnonymousClass5 implements b {
        final /* synthetic */ b kIC;
        int kIW = 0;
        final /* synthetic */ b kIX;
        final /* synthetic */ WakerLock kIY;

        AnonymousClass5(b bVar, b bVar2, WakerLock wakerLock) {
            this.kIX = bVar;
            this.kIC = bVar2;
            this.kIY = wakerLock;
        }

        public final void tL(int i) {
            AppMethodBeat.i(18974);
            do {
                if (this.kIW > 0) {
                    ab.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", Integer.valueOf(this.kIW), Integer.valueOf(i));
                }
                if (i == 0) {
                    this.kIX.delete();
                    h.pYm.a(181, 29, 1, true);
                    if (this.kIC != null) {
                        this.kIC.tL(i);
                    }
                    this.kIY.unLock();
                    AppMethodBeat.o(18974);
                    return;
                } else if (i == -2) {
                    this.kIX.delete();
                    h.pYm.a(181, 3, 1, true);
                    if (this.kIC != null) {
                        this.kIC.tL(i);
                    }
                    this.kIY.unLock();
                    AppMethodBeat.o(18974);
                    return;
                } else {
                    int i2 = this.kIW + 1;
                    this.kIW = i2;
                    switch (i2) {
                        case 1:
                            ab.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", Integer.valueOf(this.kIW));
                            i = d.this.b(null, (b) this);
                            continue;
                        case 2:
                            ab.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", Integer.valueOf(this.kIW));
                            i = d.this.a(null, (b) this);
                            continue;
                        case 3:
                            ab.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", Integer.valueOf(this.kIW));
                            i = d.this.a((b) this);
                            continue;
                        default:
                            this.kIX.delete();
                            h.pYm.a(181, 30, 1, true);
                            if (this.kIC != null) {
                                this.kIC.tL(i);
                            }
                            this.kIY.unLock();
                            AppMethodBeat.o(18974);
                            return;
                    }
                }
            } while (i != 0);
            AppMethodBeat.o(18974);
        }
    }

    public d() {
        AppMethodBeat.i(18982);
        AppMethodBeat.o(18982);
    }

    static /* synthetic */ void bhU() {
        AppMethodBeat.i(19000);
        bhQ();
        AppMethodBeat.o(19000);
    }

    static {
        AppMethodBeat.i(19001);
        AppMethodBeat.o(19001);
    }

    private static long[] a(SQLiteDatabase sQLiteDatabase) {
        long j;
        long j2;
        long j3;
        long j4 = -1;
        AppMethodBeat.i(18983);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j = rawQueryWithFactory.getLong(0);
        } else {
            j = -1;
        }
        rawQueryWithFactory.close();
        Cursor rawQueryWithFactory2 = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
        if (rawQueryWithFactory2.moveToFirst()) {
            j2 = rawQueryWithFactory2.getLong(0);
        } else {
            j2 = -1;
        }
        rawQueryWithFactory2.close();
        Cursor rawQueryWithFactory3 = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (rawQueryWithFactory3.moveToFirst()) {
            j3 = rawQueryWithFactory3.getLong(0);
        } else {
            j3 = -1;
        }
        rawQueryWithFactory3.close();
        rawQueryWithFactory3 = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
        if (rawQueryWithFactory3.moveToFirst()) {
            j4 = rawQueryWithFactory3.getLong(0);
        }
        rawQueryWithFactory3.close();
        long[] jArr = new long[]{j, j2, j3, j4};
        AppMethodBeat.o(18983);
        return jArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085 A:{SYNTHETIC, Splitter:B:31:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079 A:{SYNTHETIC, Splitter:B:25:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] Ie(String str) {
        Throwable e;
        long j = 0;
        AppMethodBeat.i(18984);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new g(str + ".bcur"));
            try {
                long parseLong;
                long parseLong2;
                long parseLong3;
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong = Long.parseLong(readLine);
                } else {
                    parseLong = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong2 = Long.parseLong(readLine);
                } else {
                    parseLong2 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong3 = Long.parseLong(readLine);
                } else {
                    parseLong3 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = Long.parseLong(readLine);
                }
                long[] jArr = new long[]{parseLong, parseLong2, parseLong3, j};
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.o(18984);
                return jArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.o(18984);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(18984);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(18984);
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(18984);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f A:{SYNTHETIC, Splitter:B:16:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A:{SYNTHETIC, Splitter:B:22:0x006b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(String str, long[] jArr) {
        Throwable e;
        AppMethodBeat.i(18985);
        com.tencent.mm.vfs.h hVar;
        try {
            hVar = new com.tencent.mm.vfs.h(str + ".bcur");
            try {
                for (long l : jArr) {
                    hVar.write(Long.toString(l) + IOUtils.LINE_SEPARATOR_UNIX);
                }
                try {
                    hVar.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.o(18985);
                return true;
            } catch (IOException e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
                    if (hVar != null) {
                        try {
                            hVar.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.o(18985);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (hVar != null) {
                        try {
                            hVar.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.o(18985);
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            hVar = null;
            ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
            if (hVar != null) {
            }
            AppMethodBeat.o(18985);
            return false;
        } catch (Throwable th2) {
            e = th2;
            hVar = null;
            if (hVar != null) {
            }
            AppMethodBeat.o(18985);
            throw e;
        }
    }

    private static String[] a(long[] jArr, long[] jArr2) {
        AppMethodBeat.i(18986);
        String[] strArr;
        if (jArr2 == null || jArr2.length < 4) {
            strArr = new String[]{ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
            AppMethodBeat.o(18986);
            return strArr;
        }
        strArr = new String[12];
        strArr[0] = ShareConstants.WEB_DIALOG_PARAM_MESSAGE;
        strArr[1] = String.format("msgId > %d AND msgId <= %d", new Object[]{Long.valueOf(jArr2[0]), Long.valueOf(jArr[0])});
        strArr[2] = "ImgInfo2";
        strArr[3] = String.format("id > %d AND id <= %d", new Object[]{Long.valueOf(jArr2[1]), Long.valueOf(jArr[1])});
        strArr[4] = "videoinfo2";
        strArr[5] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(jArr2[2]), Long.valueOf(jArr[2])});
        strArr[6] = "EmojiInfo";
        strArr[7] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(jArr2[3]), Long.valueOf(jArr[3])});
        strArr[8] = "conversation";
        strArr[9] = null;
        strArr[10] = "rconversation";
        strArr[11] = null;
        AppMethodBeat.o(18986);
        return strArr;
    }

    private static boolean b(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(18987);
        String str = sQLiteDatabase.getPath() + ".sm";
        String str2 = str + ".tmp";
        z Ry = com.tencent.mm.kernel.g.RP().Ry();
        long Mm = Ry.Mm(237569);
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b(str);
        if (!bVar.exists() || currentTimeMillis - Mm >= 86400000) {
            Mm = System.nanoTime();
            StringBuilder append = new StringBuilder().append(q.LK());
            aw.ZK();
            boolean save = MasterInfo.save(sQLiteDatabase, str2, com.tencent.mm.a.g.y(append.append(com.tencent.mm.model.c.QF()).toString().getBytes()));
            b bVar2 = new b(str2);
            if (save) {
                bVar.delete();
                save = bVar2.o(bVar);
                Ry.setLong(237569, currentTimeMillis);
                Ry.dsb();
            } else {
                bVar2.delete();
            }
            Mm = System.nanoTime() - Mm;
            String str3 = "MicroMsg.SubCoreDBBackup";
            String str4 = "Master table backup %s, elapsed %.3f";
            Object[] objArr = new Object[2];
            objArr[0] = save ? "SUCCEEDED" : "FAILED";
            objArr[1] = Float.valueOf(((float) Mm) / 1.0E9f);
            ab.i(str3, str4, objArr);
            h.pYm.a(181, save ? 24 : 25, 1, false);
            AppMethodBeat.o(18987);
            return save;
        }
        AppMethodBeat.o(18987);
        return true;
    }

    public final boolean a(boolean z, b bVar) {
        AppMethodBeat.i(18988);
        if (this.kIq) {
            ab.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", "backup");
            AppMethodBeat.o(18988);
            return false;
        }
        boolean z2;
        int i;
        final com.tencent.mm.model.c ZK = aw.ZK();
        final String Rw = com.tencent.mm.model.c.Rw();
        final SQLiteDatabase dvx = com.tencent.mm.model.c.Ru().dvx();
        final String str = Rw + ".bak";
        final String str2 = str + ".tmp";
        final String str3 = Rw + ".sm";
        final String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            if (e.ct(str)) {
                i2 = 24;
                e.y(str, str2);
            } else {
                z = false;
            }
        }
        final long[] a = a(dvx);
        final long[] Ie = z ? Ie(Rw) : null;
        final String[] a2 = a(a, Ie);
        if (Ie == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.kIx) {
            i = i2 | 3;
        } else {
            i = i2;
        }
        final b bVar2 = bVar;
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(18969);
                if (d.this.kIq) {
                    d.this.kIn = null;
                    try {
                        String str;
                        int i;
                        int i2;
                        long nanoTime = System.nanoTime();
                        byte[] y = com.tencent.mm.a.g.y((q.LK() + com.tencent.mm.model.c.QF()).getBytes());
                        b bVar = new b(str3);
                        if (!(z2 && bVar.exists())) {
                            boolean o;
                            boolean save = MasterInfo.save(dvx, str4, y);
                            b bVar2 = new b(str4);
                            if (save) {
                                bVar.delete();
                                o = bVar2.o(bVar);
                            } else {
                                bVar2.delete();
                                o = save;
                            }
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Master table backup %s, elapsed %.3f";
                            Object[] objArr = new Object[2];
                            objArr[0] = o ? "SUCCEEDED" : "FAILED";
                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            ab.i(str, str2, objArr);
                            h.pYm.a(181, o ? 24 : 25, 1, false);
                        }
                        long length = new b(Rw).length();
                        long length2 = new b(str2).length();
                        String str3 = "MicroMsg.SubCoreDBBackup";
                        String str4 = "Backup started [%s, cursor: %d ~ %d]";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = z2 ? "incremental" : "new";
                        objArr2[1] = Long.valueOf(Ie != null ? Ie[0] : 0);
                        objArr2[2] = Long.valueOf(a[0]);
                        ab.i(str3, str4, objArr2);
                        int i3 = z2 ? CdnLogic.kMediaTypeBeatificFile : Downloads.MIN_WAIT_FOR_NETWORK;
                        h hVar = h.pYm;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(i3);
                        objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), d.this.kIy.format(new Date())});
                        hVar.e(11098, objArr3);
                        d.this.kIn = new BackupKit(dvx, str2, y, i, a2);
                        int run = d.this.kIn.run();
                        nanoTime = System.nanoTime() - nanoTime;
                        b bVar3 = new b(str2);
                        long length3 = bVar3.length();
                        if (run == 0) {
                            d.b(Rw, a);
                            bVar = new b(str);
                            bVar.delete();
                            bVar3.o(bVar);
                            if (z2) {
                                i = 19;
                                i2 = 10012;
                            } else {
                                i = 16;
                                i2 = 10001;
                            }
                        } else {
                            bVar3.delete();
                            if (run == 1) {
                                if (z2) {
                                    i = 20;
                                    i2 = 10013;
                                } else {
                                    i = 17;
                                    i2 = 10002;
                                }
                            } else if (z2) {
                                i = 21;
                                i2 = 10014;
                            } else {
                                i = 18;
                                i2 = 10003;
                            }
                        }
                        str = "MicroMsg.SubCoreDBBackup";
                        str3 = "Database %s backup %s, elapsed %.2f seconds.";
                        objArr3 = new Object[3];
                        objArr3[0] = z2 ? "incremental" : "new";
                        String str5 = run == 0 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : run == 1 ? "canceled" : "failed";
                        objArr3[1] = str5;
                        objArr3[2] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                        ab.i(str, str3, objArr3);
                        h.pYm.a(181, (long) i, 1, false);
                        h hVar2 = h.pYm;
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = Integer.valueOf(i2);
                        objArr4[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(d.this.kIn.statementCount()), Long.valueOf(nanoTime / 1000000), d.this.kIy.format(new Date())});
                        hVar2.e(11098, objArr4);
                        if (bVar2 != null) {
                            bVar2.tL(run);
                        }
                        d.this.kIn.release();
                        d.this.kIn = null;
                        StringBuilder stringBuilder = new StringBuilder();
                        com.tencent.mm.kernel.g.RQ();
                        e.tf(stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("dbback").toString());
                        str5 = str3;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        com.tencent.mm.kernel.g.RQ();
                        e.y(str5, stringBuilder2.append(com.tencent.mm.kernel.g.RP().eJM).append("dbback/EnMicroMsg.db.sm").toString());
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup, path: %s", Rw);
                        if (bVar2 != null) {
                            bVar2.tL(-1);
                        }
                        h.pYm.a(181, z2 ? 18 : 21, 1, false);
                    } finally {
                        if (d.this.kIn != null) {
                            d.this.kIn.release();
                            d.this.kIn = null;
                        }
                        d.this.kIq = false;
                        AppMethodBeat.o(18969);
                    }
                } else {
                    if (bVar2 != null) {
                        bVar2.tL(1);
                    }
                    AppMethodBeat.o(18969);
                }
            }
        };
        this.kIq = true;
        com.tencent.mm.sdk.g.d.post(anonymousClass1, "DB Backup");
        AppMethodBeat.o(18988);
        return true;
    }

    public final synchronized boolean bhP() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(18989);
            this.kIq = false;
            if (this.kIn == null) {
                AppMethodBeat.o(18989);
            } else {
                this.kIn.onCancel();
                z = true;
                AppMethodBeat.o(18989);
            }
        }
        return z;
    }

    @Deprecated
    public final synchronized int a(String str, b bVar) {
        AppMethodBeat.i(18990);
        final com.tencent.mm.model.c ZK = aw.ZK();
        final long dpD = bo.dpD();
        final String str2 = str;
        final b bVar2 = bVar;
        AnonymousClass2 anonymousClass2 = new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01cf A:{Catch:{ all -> 0x037d }} */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01ec  */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0201  */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01cf A:{Catch:{ all -> 0x037d }} */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01ec  */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0201  */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x01cf A:{Catch:{ all -> 0x037d }} */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01ec  */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0201  */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0388  */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x039d  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Throwable e;
                int i;
                int i2;
                Throwable e2;
                AppMethodBeat.i(18970);
                d.this.kIo = null;
                SQLiteDatabase openDatabase;
                try {
                    com.tencent.mm.model.c.XO();
                    com.tencent.mm.model.c.XR();
                    o.ahl();
                    com.tencent.mm.modelvideo.o.all();
                    long nanoTime = System.nanoTime();
                    byte[] bytes = (q.LK() + com.tencent.mm.model.c.QF()).getBytes();
                    byte[] y = com.tencent.mm.a.g.y(bytes);
                    byte[] bytes2 = com.tencent.mm.a.g.x(bytes).substring(0, 7).getBytes();
                    int i3 = 268435456;
                    if (f.dvt()) {
                        i3 = 805306368;
                    }
                    openDatabase = SQLiteDatabase.openDatabase(com.tencent.mm.model.c.Ru().dvx().getPath(), bytes2, d.kIB, null, i3, null, 0);
                    try {
                        String[] strArr;
                        if (str2 != null) {
                            strArr = new String[]{str2};
                        } else {
                            String[] strArr2 = new String[2];
                            strArr2[0] = com.tencent.mm.model.c.Rs() + ".bak";
                            StringBuilder stringBuilder = new StringBuilder();
                            com.tencent.mm.kernel.g.RQ();
                            strArr2[1] = stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("dbback/EnMicroMsg.db.bak").toString();
                            strArr = strArr2;
                        }
                        try {
                            String str;
                            int length = strArr.length;
                            int i4 = 0;
                            int i5 = -3;
                            long j = 0;
                            while (i4 < length) {
                                try {
                                    str = strArr[i4];
                                    try {
                                        b bVar = new b(str);
                                        if (bVar.canRead()) {
                                            j = bVar.length();
                                            ab.i("MicroMsg.SubCoreDBBackup", "[Recover] backupSize: %d, diskFreeSpace: %d", Long.valueOf(j), Long.valueOf(dpD));
                                            if (dpD >= 10 * j) {
                                                h hVar = h.pYm;
                                                Object[] objArr = new Object[2];
                                                objArr[0] = Integer.valueOf(10004);
                                                objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(dpD)});
                                                hVar.e(11098, objArr);
                                                d.this.kIo = new RecoverKit(openDatabase, str, y);
                                                break;
                                            }
                                            if (bVar2 != null) {
                                                bVar2.tL(-2);
                                            }
                                            if (d.this.kIo != null) {
                                                d.this.kIo.release();
                                                d.this.kIo = null;
                                            }
                                            if (openDatabase != null) {
                                                openDatabase.close();
                                            }
                                            d.this.kIq = false;
                                            aw.RS().doM();
                                            AppMethodBeat.o(18970);
                                            return;
                                        }
                                        continue;
                                        i4++;
                                    } catch (Exception e3) {
                                        ab.e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + e3.getMessage());
                                        i5 = -1;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    i = i5;
                                }
                            }
                            if (d.this.kIo == null) {
                                i2 = -3;
                                try {
                                    h.pYm.a(181, 31, 1, true);
                                    RuntimeException runtimeException = new RuntimeException();
                                    AppMethodBeat.o(18970);
                                    throw runtimeException;
                                } catch (Exception e22) {
                                    e = e22;
                                    i = i2;
                                    try {
                                        ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                                        if (bVar2 != null) {
                                        }
                                        h.pYm.a(181, 23, 1, true);
                                        if (d.this.kIo != null) {
                                        }
                                        if (openDatabase != null) {
                                        }
                                        d.this.kIq = false;
                                        aw.RS().doM();
                                        AppMethodBeat.o(18970);
                                    } catch (Throwable th) {
                                        e22 = th;
                                        if (d.this.kIo != null) {
                                        }
                                        if (openDatabase != null) {
                                        }
                                        d.this.kIq = false;
                                        aw.RS().doM();
                                        AppMethodBeat.o(18970);
                                        throw e22;
                                    }
                                }
                            }
                            int i6;
                            i2 = d.this.kIo.run(false);
                            d.bhR();
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            int successCount = d.this.kIo.successCount();
                            length = d.this.kIo.failureCount();
                            String lastError = d.this.kIo.lastError();
                            d.this.kIo.release();
                            d.this.kIo = null;
                            openDatabase.close();
                            openDatabase = null;
                            str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Database recover %s, elapsed %.2f seconds. [success: %d, failure: %d]";
                            Object[] objArr2 = new Object[4];
                            String str3 = i2 == 0 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : i2 == 1 ? "canceled" : "failed";
                            objArr2[0] = str3;
                            objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            objArr2[2] = Integer.valueOf(successCount);
                            objArr2[3] = Integer.valueOf(length);
                            ab.i(str, str2, objArr2);
                            if (i2 == 0) {
                                i6 = 10005;
                                i5 = 22;
                            } else if (i2 == 1) {
                                i6 = 10006;
                                i5 = -1;
                            } else {
                                i6 = CdnLogic.kMediaTypeFavoriteBigFile;
                                i5 = 23;
                                h.pYm.g("DBRepair", "Backup recover failed: ".concat(String.valueOf(lastError)), null);
                            }
                            h hVar2 = h.pYm;
                            objArr2 = new Object[2];
                            objArr2[0] = Integer.valueOf(i6);
                            objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(nanoTime2 / 1000000), Integer.valueOf(successCount), Integer.valueOf(length)});
                            hVar2.e(11098, objArr2);
                            if (i5 >= 0) {
                                h.pYm.a(181, (long) i5, 1, true);
                            }
                            if (bVar2 != null) {
                                bVar2.tL(i2);
                            }
                            if (d.this.kIo != null) {
                                d.this.kIo.release();
                                d.this.kIo = null;
                            }
                            d.this.kIq = false;
                            aw.RS().doM();
                            AppMethodBeat.o(18970);
                        } catch (Exception e222) {
                            e = e222;
                            i = -3;
                            ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                            if (bVar2 != null) {
                                bVar2.tL(i);
                            }
                            h.pYm.a(181, 23, 1, true);
                            if (d.this.kIo != null) {
                                d.this.kIo.release();
                                d.this.kIo = null;
                            }
                            if (openDatabase != null) {
                                openDatabase.close();
                            }
                            d.this.kIq = false;
                            aw.RS().doM();
                            AppMethodBeat.o(18970);
                        }
                    } catch (Exception e2222) {
                        e = e2222;
                        i = -1;
                        ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                        if (bVar2 != null) {
                        }
                        h.pYm.a(181, 23, 1, true);
                        if (d.this.kIo != null) {
                        }
                        if (openDatabase != null) {
                        }
                        d.this.kIq = false;
                        aw.RS().doM();
                        AppMethodBeat.o(18970);
                    }
                } catch (Exception e22222) {
                    e = e22222;
                    openDatabase = null;
                    i = -1;
                    ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                    if (bVar2 != null) {
                    }
                    h.pYm.a(181, 23, 1, true);
                    if (d.this.kIo != null) {
                    }
                    if (openDatabase != null) {
                    }
                    d.this.kIq = false;
                    aw.RS().doM();
                    AppMethodBeat.o(18970);
                } catch (Throwable th2) {
                    e22222 = th2;
                    openDatabase = null;
                    if (d.this.kIo != null) {
                        d.this.kIo.release();
                        d.this.kIo = null;
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    d.this.kIq = false;
                    aw.RS().doM();
                    AppMethodBeat.o(18970);
                    throw e22222;
                }
            }
        };
        this.kIq = true;
        aw.RS().Bn();
        aw.RS().ae(anonymousClass2);
        AppMethodBeat.o(18990);
        return 0;
    }

    @Deprecated
    public final synchronized int b(String str, final b bVar) {
        int i = 0;
        synchronized (this) {
            b bVar2;
            AppMethodBeat.i(18991);
            final com.tencent.mm.model.c ZK = aw.ZK();
            if (str == null) {
                str = com.tencent.mm.model.c.Rs();
            }
            long dpD = bo.dpD();
            if (str == null) {
                bVar2 = null;
            } else {
                bVar2 = new b(str);
            }
            if (bVar2 == null || !bVar2.canRead()) {
                i = -3;
                AppMethodBeat.o(18991);
            } else {
                ab.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", Long.valueOf(bVar2.length()), Long.valueOf(dpD));
                if (((float) dpD) < ((float) bVar2.length()) * 1.5f) {
                    i = -2;
                    AppMethodBeat.o(18991);
                } else {
                    AnonymousClass3 anonymousClass3 = new Runnable() {
                        final String[] kIR = new String[]{ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};

                        /* JADX WARNING: Removed duplicated region for block: B:78:0x0298  */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x02a9  */
                        /* JADX WARNING: Removed duplicated region for block: B:82:0x02ae  */
                        /* JADX WARNING: Removed duplicated region for block: B:78:0x0298  */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x02a9  */
                        /* JADX WARNING: Removed duplicated region for block: B:82:0x02ae  */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x01f0 A:{Catch:{ all -> 0x02d0 }} */
                        /* JADX WARNING: Removed duplicated region for block: B:59:0x0227  */
                        /* JADX WARNING: Removed duplicated region for block: B:61:0x0238  */
                        /* JADX WARNING: Removed duplicated region for block: B:63:0x023d  */
                        /* JADX WARNING: Removed duplicated region for block: B:78:0x0298  */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x02a9  */
                        /* JADX WARNING: Removed duplicated region for block: B:82:0x02ae  */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x01f0 A:{Catch:{ all -> 0x02d0 }} */
                        /* JADX WARNING: Removed duplicated region for block: B:59:0x0227  */
                        /* JADX WARNING: Removed duplicated region for block: B:61:0x0238  */
                        /* JADX WARNING: Removed duplicated region for block: B:63:0x023d  */
                        /* JADX WARNING: Removed duplicated region for block: B:78:0x0298  */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x02a9  */
                        /* JADX WARNING: Removed duplicated region for block: B:82:0x02ae  */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x01f0 A:{Catch:{ all -> 0x02d0 }} */
                        /* JADX WARNING: Removed duplicated region for block: B:59:0x0227  */
                        /* JADX WARNING: Removed duplicated region for block: B:61:0x0238  */
                        /* JADX WARNING: Removed duplicated region for block: B:63:0x023d  */
                        /* JADX WARNING: Removed duplicated region for block: B:87:0x02c6 A:{Splitter:B:11:0x00af, PHI: r2 , ExcHandler: all (th java.lang.Throwable)} */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x01f0 A:{Catch:{ all -> 0x02d0 }} */
                        /* JADX WARNING: Removed duplicated region for block: B:59:0x0227  */
                        /* JADX WARNING: Removed duplicated region for block: B:61:0x0238  */
                        /* JADX WARNING: Removed duplicated region for block: B:63:0x023d  */
                        /* JADX WARNING: Removed duplicated region for block: B:78:0x0298  */
                        /* JADX WARNING: Removed duplicated region for block: B:80:0x02a9  */
                        /* JADX WARNING: Removed duplicated region for block: B:82:0x02ae  */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Missing block: B:45:0x019f, code skipped:
            r0 = move-exception;
     */
                        /* JADX WARNING: Missing block: B:47:?, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.SubCoreDBBackup", "Failed to load saved master: " + r0.getMessage());
            r3 = r3 + 1;
     */
                        /* JADX WARNING: Missing block: B:87:0x02c6, code skipped:
            r0 = th;
     */
                        /* JADX WARNING: Missing block: B:88:0x02c7, code skipped:
            r10 = r2;
     */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            SQLiteDatabase openDatabase;
                            Throwable e;
                            SQLiteDatabase sQLiteDatabase;
                            MasterInfo masterInfo;
                            AppMethodBeat.i(18972);
                            d.this.kIp = null;
                            try {
                                com.tencent.mm.model.c.XO();
                                com.tencent.mm.model.c.XR();
                                o.ahl();
                                com.tencent.mm.modelvideo.o.all();
                                byte[] bytes = (q.LK() + com.tencent.mm.model.c.QF()).getBytes();
                                byte[] y = com.tencent.mm.a.g.y(bytes);
                                byte[] bytes2 = com.tencent.mm.a.g.x(bytes).substring(0, 7).getBytes();
                                int i = 268435456;
                                if (f.dvt()) {
                                    i = 805306368;
                                }
                                openDatabase = SQLiteDatabase.openDatabase(com.tencent.mm.model.c.Ru().dvx().getPath(), bytes2, d.kIB, null, i, null, 0);
                                try {
                                    long nanoTime = System.nanoTime();
                                    String[] strArr = new String[2];
                                    strArr[0] = str + ".sm";
                                    StringBuilder stringBuilder = new StringBuilder();
                                    com.tencent.mm.kernel.g.RQ();
                                    strArr[1] = stringBuilder.append(com.tencent.mm.kernel.g.RP().eJM).append("dbback/EnMicroMsg.db.sm").toString();
                                    int i2 = 0;
                                    MasterInfo masterInfo2 = null;
                                    while (i2 < 2) {
                                        try {
                                            String str = strArr[i2];
                                            masterInfo2 = MasterInfo.load(str, y, this.kIR);
                                            ab.i("MicroMsg.SubCoreDBBackup", "Loaded saved master: ".concat(String.valueOf(str)));
                                            break;
                                        } catch (Exception e2) {
                                            e = e2;
                                            sQLiteDatabase = openDatabase;
                                            masterInfo = masterInfo2;
                                            try {
                                                ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                                if (bVar != null) {
                                                }
                                                h.pYm.g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                                h.pYm.a(181, 27, 1, true);
                                                if (d.this.kIp != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                if (masterInfo != null) {
                                                }
                                                d.this.kIq = false;
                                                aw.RS().doM();
                                                AppMethodBeat.o(18972);
                                            } catch (Throwable th) {
                                                e = th;
                                                openDatabase = sQLiteDatabase;
                                                if (d.this.kIp != null) {
                                                    d.this.kIp.release();
                                                    d.this.kIp = null;
                                                }
                                                if (openDatabase != null) {
                                                    openDatabase.close();
                                                }
                                                if (masterInfo != null) {
                                                    masterInfo.release();
                                                }
                                                d.this.kIq = false;
                                                aw.RS().doM();
                                                AppMethodBeat.o(18972);
                                                throw e;
                                            }
                                        } catch (Throwable th2) {
                                        }
                                    }
                                    if (masterInfo2 == null) {
                                        masterInfo2 = MasterInfo.make(this.kIR);
                                        ab.w("MicroMsg.SubCoreDBBackup", "Saved master not available.");
                                        h.pYm.a(181, 32, 1, true);
                                    } else if (i2 > 0) {
                                        ab.i("MicroMsg.SubCoreDBBackup", "Use backup saved master.");
                                        h.pYm.a(181, 33, 1, true);
                                    }
                                    d.this.kIp = new RepairKit(str, bytes2, d.kIB, masterInfo2);
                                    int i3 = d.this.kIp.output(openDatabase, 1) == 0 ? 1 : 0;
                                    int i4 = (d.this.kIp.isHeaderCorrupted() && d.this.kIp.isDataCorrupted()) ? 0 : 1;
                                    i3 &= i4;
                                    openDatabase.close();
                                    sQLiteDatabase = null;
                                    try {
                                        masterInfo2.release();
                                        masterInfo = null;
                                        try {
                                            d.this.kIp.release();
                                            d.this.kIp = null;
                                            d.bhR();
                                            long nanoTime2 = System.nanoTime() - nanoTime;
                                            String str2 = "MicroMsg.SubCoreDBBackup";
                                            String str3 = "DB repair %s, elapsed %.2f seconds.";
                                            Object[] objArr = new Object[2];
                                            objArr[0] = i3 != 0 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed";
                                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                                            ab.i(str2, str3, objArr);
                                            if (i3 != 0) {
                                                i4 = 26;
                                                if (bVar != null) {
                                                    bVar.tL(0);
                                                }
                                            } else {
                                                i4 = 27;
                                                if (bVar != null) {
                                                    bVar.tL(-1);
                                                }
                                                h.pYm.g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                            }
                                            h.pYm.a(181, (long) i4, 1, true);
                                            if (d.this.kIp != null) {
                                                d.this.kIp.release();
                                                d.this.kIp = null;
                                            }
                                            d.this.kIq = false;
                                            aw.RS().doM();
                                            AppMethodBeat.o(18972);
                                        } catch (Exception e3) {
                                            e = e3;
                                            ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                            if (bVar != null) {
                                            }
                                            h.pYm.g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                            h.pYm.a(181, 27, 1, true);
                                            if (d.this.kIp != null) {
                                            }
                                            if (sQLiteDatabase != null) {
                                            }
                                            if (masterInfo != null) {
                                            }
                                            d.this.kIq = false;
                                            aw.RS().doM();
                                            AppMethodBeat.o(18972);
                                        } catch (Throwable th3) {
                                            e = th3;
                                            openDatabase = null;
                                            if (d.this.kIp != null) {
                                            }
                                            if (openDatabase != null) {
                                            }
                                            if (masterInfo != null) {
                                            }
                                            d.this.kIq = false;
                                            aw.RS().doM();
                                            AppMethodBeat.o(18972);
                                            throw e;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        masterInfo = masterInfo2;
                                        ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                        if (bVar != null) {
                                        }
                                        h.pYm.g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                        h.pYm.a(181, 27, 1, true);
                                        if (d.this.kIp != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        if (masterInfo != null) {
                                        }
                                        d.this.kIq = false;
                                        aw.RS().doM();
                                        AppMethodBeat.o(18972);
                                    } catch (Throwable th4) {
                                        e = th4;
                                        openDatabase = null;
                                        masterInfo = masterInfo2;
                                        if (d.this.kIp != null) {
                                        }
                                        if (openDatabase != null) {
                                        }
                                        if (masterInfo != null) {
                                        }
                                        d.this.kIq = false;
                                        aw.RS().doM();
                                        AppMethodBeat.o(18972);
                                        throw e;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    sQLiteDatabase = openDatabase;
                                    masterInfo = null;
                                    ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                    if (bVar != null) {
                                        bVar.tL(-1);
                                    }
                                    h.pYm.g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                    h.pYm.a(181, 27, 1, true);
                                    if (d.this.kIp != null) {
                                        d.this.kIp.release();
                                        d.this.kIp = null;
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    if (masterInfo != null) {
                                        masterInfo.release();
                                    }
                                    d.this.kIq = false;
                                    aw.RS().doM();
                                    AppMethodBeat.o(18972);
                                } catch (Throwable th5) {
                                    e = th5;
                                    masterInfo = null;
                                    if (d.this.kIp != null) {
                                    }
                                    if (openDatabase != null) {
                                    }
                                    if (masterInfo != null) {
                                    }
                                    d.this.kIq = false;
                                    aw.RS().doM();
                                    AppMethodBeat.o(18972);
                                    throw e;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                sQLiteDatabase = null;
                                masterInfo = null;
                                ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                if (bVar != null) {
                                }
                                h.pYm.g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                h.pYm.a(181, 27, 1, true);
                                if (d.this.kIp != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                if (masterInfo != null) {
                                }
                                d.this.kIq = false;
                                aw.RS().doM();
                                AppMethodBeat.o(18972);
                            } catch (Throwable th6) {
                                e = th6;
                                openDatabase = null;
                                masterInfo = null;
                                if (d.this.kIp != null) {
                                }
                                if (openDatabase != null) {
                                }
                                if (masterInfo != null) {
                                }
                                d.this.kIq = false;
                                aw.RS().doM();
                                AppMethodBeat.o(18972);
                                throw e;
                            }
                        }
                    };
                    this.kIq = true;
                    aw.RS().Bn();
                    aw.RS().ae(anonymousClass3);
                    AppMethodBeat.o(18991);
                }
            }
        }
        return i;
    }

    @Deprecated
    public final int a(final b bVar) {
        AppMethodBeat.i(18992);
        aw.ZK();
        String Rs = com.tencent.mm.model.c.Rs();
        if (Rs == null || Rs.isEmpty()) {
            AppMethodBeat.o(18992);
            return -3;
        }
        final b bVar2 = new b(Rs);
        if (bVar2.canRead()) {
            StringBuilder append = new StringBuilder().append(q.LK());
            aw.ZK();
            final String substring = com.tencent.mm.a.g.x(append.append(com.tencent.mm.model.c.QF()).toString().getBytes()).substring(0, 7);
            ab.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", Long.valueOf(bVar2.length() * 2), Long.valueOf(bo.dpD()));
            if (bo.dpD() < bVar2.length() * 2) {
                AppMethodBeat.o(18992);
                return -2;
            }
            aw.RS().Bn();
            aw.RS().ae(new Runnable() {
                public final void run() {
                    int i;
                    AppMethodBeat.i(18973);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                    aw.ZK();
                    String Rt = com.tencent.mm.model.c.Rt();
                    String str = Rt + bVar2.getName().replace(".db", "temp.db");
                    ab.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", str);
                    bVar2.o(new b(str));
                    String str2 = Rt + "sqlTemp.sql";
                    List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
                    final int[] iArr = new int[1];
                    long currentTimeMillis = System.currentTimeMillis();
                    aw.ZK();
                    boolean a = com.tencent.mm.model.c.Ru().a(str, substring, str2, asList, new ExecuteSqlCallback() {
                        public final String preExecute(String str) {
                            int[] iArr = iArr;
                            iArr[0] = iArr[0] + 1;
                            return null;
                        }
                    });
                    if (a) {
                        aw.ZK();
                        com.tencent.mm.model.c.XO().bOz();
                        aw.ZK();
                        com.tencent.mm.model.c.XR().dsL();
                        aw.ZK();
                        com.tencent.mm.model.c.XO().bOB();
                        aw.ZK();
                        com.tencent.mm.model.c.XO().bOA();
                        i = 12;
                    } else {
                        i = 15;
                    }
                    h.pYm.a(181, (long) i, 1, true);
                    ab.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    h hVar = h.pYm;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(a ? 1 : 0);
                    objArr[1] = iArr;
                    objArr[2] = Long.valueOf(r2);
                    hVar.e(11224, objArr);
                    aw.RS().doM();
                    if (bVar != null) {
                        bVar.tL(a ? 0 : -1);
                    }
                    AppMethodBeat.o(18973);
                }
            });
            AppMethodBeat.o(18992);
            return 0;
        }
        AppMethodBeat.o(18992);
        return -3;
    }

    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(18993);
        aw.ZK();
        z Ry = com.tencent.mm.model.c.Ry();
        SQLiteDatabase dvx = com.tencent.mm.model.c.Ru().dvx();
        this.kIv = Ry.Mm(237569);
        this.kIw = Ry.getInt(237570, 10);
        this.kIx = Ry.getInt(237571, 0) != 0;
        Context context = ah.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            boolean z2;
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.jZS = z2;
        } else {
            this.jZS = false;
        }
        this.jZT = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.kIz = new a() {
            public final void a(String str, m mVar) {
                AppMethodBeat.i(18976);
                if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                    d.bhU();
                }
                AppMethodBeat.o(18976);
            }
        };
        com.tencent.mm.model.c.c.abi().c(this.kIz);
        bhQ();
        this.kIA = new c<mp>() {
            {
                AppMethodBeat.i(18977);
                this.xxI = mp.class.getName().hashCode();
                AppMethodBeat.o(18977);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(18978);
                com.tencent.mm.m.e Nu = com.tencent.mm.m.g.Nu();
                if (com.tencent.mm.sdk.a.b.dnO()) {
                    d.this.kIs = true;
                    d.this.kIt = Long.MAX_VALUE;
                } else {
                    boolean z;
                    int i = Nu.getInt("AndroidDBBackupPercentage", 0);
                    aw.ZK();
                    int bL = i.bL(com.tencent.mm.model.c.QF(), 100);
                    d dVar = d.this;
                    if (bL < i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dVar.kIs = z;
                    d.this.kIt = (long) Nu.getInt("AndroidDBBackupMaxDBSizeMB", 0);
                    d.this.kIt = d.this.kIt * 1048576;
                }
                d.this.kIu = (long) Nu.getInt("AndroidDBBackupWaitSeconds", 600);
                d.this.kIu = d.this.kIu * 1000;
                String str = "MicroMsg.SubCoreDBBackup";
                String str2 = "Auto backup enabled: %b, max size: %s, debugger: %b";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(d.this.kIs);
                objArr[1] = d.this.kIt == Long.MAX_VALUE ? "not limited" : Long.valueOf(d.this.kIt);
                objArr[2] = Boolean.valueOf(com.tencent.mm.sdk.a.b.dnO());
                ab.d(str, str2, objArr);
                d.this.kIs = false;
                AppMethodBeat.o(18978);
                return true;
            }
        };
        com.tencent.mm.sdk.b.a.xxA.c(this.kIA);
        this.jZU = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(18981);
                String action = intent.getAction();
                int i = -1;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            i = 1;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            i = 3;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            i = 0;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            i = 2;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        d.this.jZT = true;
                        break;
                    case 1:
                        d.this.jZT = false;
                        break;
                    case 2:
                        d.this.jZS = true;
                        break;
                    case 3:
                        d.this.jZS = false;
                        break;
                }
                ab.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", action, Boolean.valueOf(d.this.jZT), Boolean.valueOf(d.this.jZS));
                if (d.this.kIs && d.this.jZV == null && d.this.jZS && !d.this.jZT) {
                    if (System.currentTimeMillis() - d.this.kIv < 86400000) {
                        ab.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                        AppMethodBeat.o(18981);
                        return;
                    }
                    final boolean z = d.this.kIw < 10;
                    final AnonymousClass1 anonymousClass1 = new b() {
                        public final void tL(int i) {
                            AppMethodBeat.i(18979);
                            d.this.kIr = false;
                            aw.ZK();
                            z Ry = com.tencent.mm.model.c.Ry();
                            d.this.kIv = System.currentTimeMillis();
                            if (i == 0) {
                                Ry.setLong(237569, d.this.kIv);
                                if (z) {
                                    d.this.kIw = d.this.kIw + 1;
                                } else {
                                    d.this.kIw = 0;
                                }
                                Ry.setInt(237570, d.this.kIw);
                            } else {
                                if (i != 1) {
                                    Ry.setLong(237569, d.this.kIv);
                                    if (z) {
                                        d.this.kIw = 10;
                                        Ry.setInt(237570, d.this.kIw);
                                    }
                                }
                                AppMethodBeat.o(18979);
                            }
                            Ry.dsb();
                            AppMethodBeat.o(18979);
                        }
                    };
                    d.this.jZV = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(18980);
                            d.this.jZV = null;
                            aw.ZK();
                            long length = new b(com.tencent.mm.model.c.Rw()).length();
                            long dpD = bo.dpD();
                            if (length == 0) {
                                ab.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                                AppMethodBeat.o(18980);
                            } else if (length > d.this.kIt || length > dpD) {
                                ab.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                                h hVar = h.pYm;
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(10008);
                                objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(dpD)});
                                hVar.e(11098, objArr);
                                AppMethodBeat.o(18980);
                            } else {
                                d.this.kIr = d.this.a(z, anonymousClass1);
                                if (d.this.kIr) {
                                    ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                                }
                                AppMethodBeat.o(18980);
                            }
                        }
                    };
                    aw.RS().m(d.this.jZV, d.this.kIu);
                    ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                    h.pYm.e(11098, Integer.valueOf(10009), d.this.kIy.format(new Date()));
                    AppMethodBeat.o(18981);
                } else if (d.this.jZV != null) {
                    aw.RS().doN().removeCallbacks(d.this.jZV);
                    d.this.jZV = null;
                    ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                    h.pYm.e(11098, Integer.valueOf(10010), d.this.kIy.format(new Date()));
                    AppMethodBeat.o(18981);
                } else {
                    if (d.this.kIr) {
                        d.this.bhP();
                        d.this.kIr = false;
                    }
                    AppMethodBeat.o(18981);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.jZU, intentFilter);
        com.tencent.mm.pluginsdk.cmd.b.a(new c(this), "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy");
        String str = "MicroMsg.SubCoreDBBackup";
        String str2 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        Object[] objArr = new Object[3];
        objArr[0] = this.kIs ? "enabled" : "disabled";
        objArr[1] = this.jZT ? "" : " not";
        objArr[2] = this.jZS ? "" : " not";
        ab.i(str, str2, objArr);
        b(dvx);
        com.tencent.mm.plugin.dbbackup.a.b.Ii(q.LK());
        e.deleteFile(com.tencent.mm.kernel.g.RP().eJM + "dbback/EnMicroMsg.db.bak");
        e.deleteFile(com.tencent.mm.kernel.g.RP().eJM + "dbback/corrupted/EnMicroMsg.db.bak");
        e.deleteFile(com.tencent.mm.kernel.g.RP().cachePath + "EnMicroMsg.db.bak");
        e.deleteFile(com.tencent.mm.kernel.g.RP().cachePath + "corrupted/EnMicroMsg.db.bak");
        final String Rt = com.tencent.mm.model.c.Rt();
        aw.RS().m(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18975);
                if (e.ct((Rt + "corrupted/EnMicroMsg.db") + ".corrupt")) {
                    AppMethodBeat.o(18975);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = new b(Rt + "corrupted");
                if (bVar.isDirectory()) {
                    for (b lastModified : bVar.dMF()) {
                        if (currentTimeMillis - lastModified.lastModified() < 7776000000L) {
                            AppMethodBeat.o(18975);
                            return;
                        }
                    }
                    if (e.N(j.w(bVar.mUri), true)) {
                        ab.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
                    }
                    AppMethodBeat.o(18975);
                    return;
                }
                AppMethodBeat.o(18975);
            }
        }, 60000);
        AppMethodBeat.o(18993);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(18994);
        bhP();
        this.kIr = false;
        if (this.jZV != null) {
            aw.RS().doN().removeCallbacks(this.jZV);
            this.jZV = null;
        }
        if (this.kIA != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.kIA);
            this.kIA = null;
        }
        if (this.jZU != null) {
            ah.getContext().unregisterReceiver(this.jZU);
            this.jZU = null;
        }
        com.tencent.mm.pluginsdk.cmd.b.N("//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy");
        AppMethodBeat.o(18994);
    }

    private static void bhQ() {
        AppMethodBeat.i(18995);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100274");
        if (ll.isValid()) {
            Map dru = ll.dru();
            HashMap hashMap = new HashMap();
            hashMap.put("flags", Integer.valueOf(bo.getInt((String) dru.get("flags"), 0)));
            hashMap.put("acp", Integer.valueOf(bo.getInt((String) dru.get("acp"), 100)));
            f.aV(hashMap);
        }
        AppMethodBeat.o(18995);
    }

    static void bhR() {
        AppMethodBeat.i(18996);
        com.tencent.mm.plugin.messenger.foundation.a.a.h XO = com.tencent.mm.model.c.XO();
        XO.bOz();
        XO.bOB();
        XO.bOA();
        com.tencent.mm.model.c.XR().dsL();
        o.ahl().agT();
        z Ry = com.tencent.mm.model.c.Ry();
        Ry.set(ac.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
        Ry.set(ac.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
        Ry.set(ac.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0));
        AppMethodBeat.o(18996);
    }

    public static void dB(Context context) {
        AppMethodBeat.i(18997);
        MMAppMgr.k(context, true);
        AppMethodBeat.o(18997);
    }

    public static void bhS() {
        AppMethodBeat.i(18998);
        MMAppMgr.pQ(true);
        AppMethodBeat.o(18998);
    }
}

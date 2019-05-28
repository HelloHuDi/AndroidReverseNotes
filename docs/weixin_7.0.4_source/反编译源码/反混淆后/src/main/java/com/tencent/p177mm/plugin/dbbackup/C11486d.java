package com.tencent.p177mm.plugin.dbbackup;

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
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p213cd.C6395f;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.p249m.C1767e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.plugin.dbbackup.p938a.C27700b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C6977h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5732g;
import com.tencent.p177mm.vfs.C5733h;
import com.tencent.p177mm.vfs.C5736j;
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

/* renamed from: com.tencent.mm.plugin.dbbackup.d */
public final class C11486d implements C1816at {
    private static final SQLiteCipherSpec kIB = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private boolean jZS = false;
    private boolean jZT = true;
    private BroadcastReceiver jZU;
    private Runnable jZV;
    private C4884c kIA;
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
    private C4931a kIz;

    /* renamed from: com.tencent.mm.plugin.dbbackup.d$5 */
    class C114905 implements C33900b {
        final /* synthetic */ C33900b kIC;
        int kIW = 0;
        final /* synthetic */ C5728b kIX;
        final /* synthetic */ WakerLock kIY;

        C114905(C5728b c5728b, C33900b c33900b, WakerLock wakerLock) {
            this.kIX = c5728b;
            this.kIC = c33900b;
            this.kIY = wakerLock;
        }

        /* renamed from: tL */
        public final void mo23206tL(int i) {
            AppMethodBeat.m2504i(18974);
            do {
                if (this.kIW > 0) {
                    C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", Integer.valueOf(this.kIW), Integer.valueOf(i));
                }
                if (i == 0) {
                    this.kIX.delete();
                    C7060h.pYm.mo8378a(181, 29, 1, true);
                    if (this.kIC != null) {
                        this.kIC.mo23206tL(i);
                    }
                    this.kIY.unLock();
                    AppMethodBeat.m2505o(18974);
                    return;
                } else if (i == -2) {
                    this.kIX.delete();
                    C7060h.pYm.mo8378a(181, 3, 1, true);
                    if (this.kIC != null) {
                        this.kIC.mo23206tL(i);
                    }
                    this.kIY.unLock();
                    AppMethodBeat.m2505o(18974);
                    return;
                } else {
                    int i2 = this.kIW + 1;
                    this.kIW = i2;
                    switch (i2) {
                        case 1:
                            C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", Integer.valueOf(this.kIW));
                            i = C11486d.this.mo23212b(null, (C33900b) this);
                            continue;
                        case 2:
                            C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", Integer.valueOf(this.kIW));
                            i = C11486d.this.mo23210a(null, (C33900b) this);
                            continue;
                        case 3:
                            C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", Integer.valueOf(this.kIW));
                            i = C11486d.this.mo23209a((C33900b) this);
                            continue;
                        default:
                            this.kIX.delete();
                            C7060h.pYm.mo8378a(181, 30, 1, true);
                            if (this.kIC != null) {
                                this.kIC.mo23206tL(i);
                            }
                            this.kIY.unLock();
                            AppMethodBeat.m2505o(18974);
                            return;
                    }
                }
            } while (i != 0);
            AppMethodBeat.m2505o(18974);
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.d$7 */
    class C114927 implements C4931a {
        C114927() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(18976);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                C11486d.bhU();
            }
            AppMethodBeat.m2505o(18976);
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.d$9 */
    class C114939 extends BroadcastReceiver {
        C114939() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(18981);
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
                    C11486d.this.jZT = true;
                    break;
                case 1:
                    C11486d.this.jZT = false;
                    break;
                case 2:
                    C11486d.this.jZS = true;
                    break;
                case 3:
                    C11486d.this.jZS = false;
                    break;
            }
            C4990ab.m7419v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", action, Boolean.valueOf(C11486d.this.jZT), Boolean.valueOf(C11486d.this.jZS));
            if (C11486d.this.kIs && C11486d.this.jZV == null && C11486d.this.jZS && !C11486d.this.jZT) {
                if (System.currentTimeMillis() - C11486d.this.kIv < 86400000) {
                    C4990ab.m7410d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                    AppMethodBeat.m2505o(18981);
                    return;
                }
                final boolean z = C11486d.this.kIw < 10;
                final C114941 c114941 = new C33900b() {
                    /* renamed from: tL */
                    public final void mo23206tL(int i) {
                        AppMethodBeat.m2504i(18979);
                        C11486d.this.kIr = false;
                        C9638aw.m17190ZK();
                        C7580z Ry = C18628c.m29072Ry();
                        C11486d.this.kIv = System.currentTimeMillis();
                        if (i == 0) {
                            Ry.setLong(237569, C11486d.this.kIv);
                            if (z) {
                                C11486d.this.kIw = C11486d.this.kIw + 1;
                            } else {
                                C11486d.this.kIw = 0;
                            }
                            Ry.setInt(237570, C11486d.this.kIw);
                        } else {
                            if (i != 1) {
                                Ry.setLong(237569, C11486d.this.kIv);
                                if (z) {
                                    C11486d.this.kIw = 10;
                                    Ry.setInt(237570, C11486d.this.kIw);
                                }
                            }
                            AppMethodBeat.m2505o(18979);
                        }
                        Ry.dsb();
                        AppMethodBeat.m2505o(18979);
                    }
                };
                C11486d.this.jZV = new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(18980);
                        C11486d.this.jZV = null;
                        C9638aw.m17190ZK();
                        long length = new C5728b(C18628c.m29071Rw()).length();
                        long dpD = C5046bo.dpD();
                        if (length == 0) {
                            C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                            AppMethodBeat.m2505o(18980);
                        } else if (length > C11486d.this.kIt || length > dpD) {
                            C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                            C7060h c7060h = C7060h.pYm;
                            Object[] objArr = new Object[2];
                            objArr[0] = Integer.valueOf(10008);
                            objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(dpD)});
                            c7060h.mo8381e(11098, objArr);
                            AppMethodBeat.m2505o(18980);
                        } else {
                            C11486d.this.kIr = C11486d.this.mo23211a(z, c114941);
                            if (C11486d.this.kIr) {
                                C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                            }
                            AppMethodBeat.m2505o(18980);
                        }
                    }
                };
                C9638aw.m17180RS().mo10310m(C11486d.this.jZV, C11486d.this.kIu);
                C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                C7060h.pYm.mo8381e(11098, Integer.valueOf(10009), C11486d.this.kIy.format(new Date()));
                AppMethodBeat.m2505o(18981);
            } else if (C11486d.this.jZV != null) {
                C9638aw.m17180RS().doN().removeCallbacks(C11486d.this.jZV);
                C11486d.this.jZV = null;
                C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                C7060h.pYm.mo8381e(11098, Integer.valueOf(10010), C11486d.this.kIy.format(new Date()));
                AppMethodBeat.m2505o(18981);
            } else {
                if (C11486d.this.kIr) {
                    C11486d.this.bhP();
                    C11486d.this.kIr = false;
                }
                AppMethodBeat.m2505o(18981);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.d$8 */
    class C114978 extends C4884c<C6523mp> {
        C114978() {
            AppMethodBeat.m2504i(18977);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(18977);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(18978);
            C1767e Nu = C26373g.m41964Nu();
            if (C4872b.dnO()) {
                C11486d.this.kIs = true;
                C11486d.this.kIt = Long.MAX_VALUE;
            } else {
                boolean z;
                int i = Nu.getInt("AndroidDBBackupPercentage", 0);
                C9638aw.m17190ZK();
                int bL = C1179i.m2593bL(C18628c.m29064QF(), 100);
                C11486d c11486d = C11486d.this;
                if (bL < i) {
                    z = true;
                } else {
                    z = false;
                }
                c11486d.kIs = z;
                C11486d.this.kIt = (long) Nu.getInt("AndroidDBBackupMaxDBSizeMB", 0);
                C11486d.this.kIt = C11486d.this.kIt * 1048576;
            }
            C11486d.this.kIu = (long) Nu.getInt("AndroidDBBackupWaitSeconds", 600);
            C11486d.this.kIu = C11486d.this.kIu * 1000;
            String str = "MicroMsg.SubCoreDBBackup";
            String str2 = "Auto backup enabled: %b, max size: %s, debugger: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(C11486d.this.kIs);
            objArr[1] = C11486d.this.kIt == Long.MAX_VALUE ? "not limited" : Long.valueOf(C11486d.this.kIt);
            objArr[2] = Boolean.valueOf(C4872b.dnO());
            C4990ab.m7411d(str, str2, objArr);
            C11486d.this.kIs = false;
            AppMethodBeat.m2505o(18978);
            return true;
        }
    }

    public C11486d() {
        AppMethodBeat.m2504i(18982);
        AppMethodBeat.m2505o(18982);
    }

    static /* synthetic */ void bhU() {
        AppMethodBeat.m2504i(19000);
        C11486d.bhQ();
        AppMethodBeat.m2505o(19000);
    }

    static {
        AppMethodBeat.m2504i(19001);
        AppMethodBeat.m2505o(19001);
    }

    /* renamed from: a */
    private static long[] m19260a(SQLiteDatabase sQLiteDatabase) {
        long j;
        long j2;
        long j3;
        long j4 = -1;
        AppMethodBeat.m2504i(18983);
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
        AppMethodBeat.m2505o(18983);
        return jArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085 A:{SYNTHETIC, Splitter:B:31:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0079 A:{SYNTHETIC, Splitter:B:25:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Ie */
    private static long[] m19250Ie(String str) {
        Throwable e;
        long j = 0;
        AppMethodBeat.m2504i(18984);
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new C5732g(str + ".bcur"));
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
                AppMethodBeat.m2505o(18984);
                return jArr;
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
                    if (bufferedReader != null) {
                    }
                    AppMethodBeat.m2505o(18984);
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(18984);
                    throw e;
                }
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(18984);
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(18984);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f A:{SYNTHETIC, Splitter:B:16:0x005f} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A:{SYNTHETIC, Splitter:B:22:0x006b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m19259a(String str, long[] jArr) {
        Throwable e;
        AppMethodBeat.m2504i(18985);
        C5733h c5733h;
        try {
            c5733h = new C5733h(str + ".bcur");
            try {
                for (long l : jArr) {
                    c5733h.write(Long.toString(l) + IOUtils.LINE_SEPARATOR_UNIX);
                }
                try {
                    c5733h.close();
                } catch (IOException e2) {
                }
                AppMethodBeat.m2505o(18985);
                return true;
            } catch (IOException e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
                    if (c5733h != null) {
                        try {
                            c5733h.close();
                        } catch (IOException e4) {
                        }
                    }
                    AppMethodBeat.m2505o(18985);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (c5733h != null) {
                        try {
                            c5733h.close();
                        } catch (IOException e5) {
                        }
                    }
                    AppMethodBeat.m2505o(18985);
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            c5733h = null;
            C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
            if (c5733h != null) {
            }
            AppMethodBeat.m2505o(18985);
            return false;
        } catch (Throwable th2) {
            e = th2;
            c5733h = null;
            if (c5733h != null) {
            }
            AppMethodBeat.m2505o(18985);
            throw e;
        }
    }

    /* renamed from: a */
    private static String[] m19261a(long[] jArr, long[] jArr2) {
        AppMethodBeat.m2504i(18986);
        String[] strArr;
        if (jArr2 == null || jArr2.length < 4) {
            strArr = new String[]{ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
            AppMethodBeat.m2505o(18986);
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
        AppMethodBeat.m2505o(18986);
        return strArr;
    }

    /* renamed from: b */
    private static boolean m19265b(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.m2504i(18987);
        String str = sQLiteDatabase.getPath() + ".sm";
        String str2 = str + ".tmp";
        C7580z Ry = C1720g.m3536RP().mo5239Ry();
        long Mm = Ry.mo16813Mm(237569);
        long currentTimeMillis = System.currentTimeMillis();
        C5728b c5728b = new C5728b(str);
        if (!c5728b.exists() || currentTimeMillis - Mm >= 86400000) {
            Mm = System.nanoTime();
            StringBuilder append = new StringBuilder().append(C1427q.m3026LK());
            C9638aw.m17190ZK();
            boolean save = MasterInfo.save(sQLiteDatabase, str2, C1178g.m2592y(append.append(C18628c.m29064QF()).toString().getBytes()));
            C5728b c5728b2 = new C5728b(str2);
            if (save) {
                c5728b.delete();
                save = c5728b2.mo11675o(c5728b);
                Ry.setLong(237569, currentTimeMillis);
                Ry.dsb();
            } else {
                c5728b2.delete();
            }
            Mm = System.nanoTime() - Mm;
            String str3 = "MicroMsg.SubCoreDBBackup";
            String str4 = "Master table backup %s, elapsed %.3f";
            Object[] objArr = new Object[2];
            objArr[0] = save ? "SUCCEEDED" : "FAILED";
            objArr[1] = Float.valueOf(((float) Mm) / 1.0E9f);
            C4990ab.m7417i(str3, str4, objArr);
            C7060h.pYm.mo8378a(181, save ? 24 : 25, 1, false);
            AppMethodBeat.m2505o(18987);
            return save;
        }
        AppMethodBeat.m2505o(18987);
        return true;
    }

    /* renamed from: a */
    public final boolean mo23211a(boolean z, C33900b c33900b) {
        AppMethodBeat.m2504i(18988);
        if (this.kIq) {
            C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", "backup");
            AppMethodBeat.m2505o(18988);
            return false;
        }
        boolean z2;
        int i;
        final C18628c ZK = C9638aw.m17190ZK();
        final String Rw = C18628c.m29071Rw();
        final SQLiteDatabase dvx = C18628c.m29069Ru().dvx();
        final String str = Rw + ".bak";
        final String str2 = str + ".tmp";
        final String str3 = Rw + ".sm";
        final String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            if (C5730e.m8628ct(str)) {
                i2 = 24;
                C5730e.m8644y(str, str2);
            } else {
                z = false;
            }
        }
        final long[] a = C11486d.m19260a(dvx);
        final long[] Ie = z ? C11486d.m19250Ie(Rw) : null;
        final String[] a2 = C11486d.m19261a(a, Ie);
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
        final C33900b c33900b2 = c33900b;
        C114951 c114951 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18969);
                if (C11486d.this.kIq) {
                    C11486d.this.kIn = null;
                    try {
                        String str;
                        int i;
                        int i2;
                        long nanoTime = System.nanoTime();
                        byte[] y = C1178g.m2592y((C1427q.m3026LK() + C18628c.m29064QF()).getBytes());
                        C5728b c5728b = new C5728b(str3);
                        if (!(z2 && c5728b.exists())) {
                            boolean o;
                            boolean save = MasterInfo.save(dvx, str4, y);
                            C5728b c5728b2 = new C5728b(str4);
                            if (save) {
                                c5728b.delete();
                                o = c5728b2.mo11675o(c5728b);
                            } else {
                                c5728b2.delete();
                                o = save;
                            }
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Master table backup %s, elapsed %.3f";
                            Object[] objArr = new Object[2];
                            objArr[0] = o ? "SUCCEEDED" : "FAILED";
                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            C4990ab.m7417i(str, str2, objArr);
                            C7060h.pYm.mo8378a(181, o ? 24 : 25, 1, false);
                        }
                        long length = new C5728b(Rw).length();
                        long length2 = new C5728b(str2).length();
                        String str3 = "MicroMsg.SubCoreDBBackup";
                        String str4 = "Backup started [%s, cursor: %d ~ %d]";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = z2 ? "incremental" : "new";
                        objArr2[1] = Long.valueOf(Ie != null ? Ie[0] : 0);
                        objArr2[2] = Long.valueOf(a[0]);
                        C4990ab.m7417i(str3, str4, objArr2);
                        int i3 = z2 ? CdnLogic.kMediaTypeBeatificFile : Downloads.MIN_WAIT_FOR_NETWORK;
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(i3);
                        objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), C11486d.this.kIy.format(new Date())});
                        c7060h.mo8381e(11098, objArr3);
                        C11486d.this.kIn = new BackupKit(dvx, str2, y, i, a2);
                        int run = C11486d.this.kIn.run();
                        nanoTime = System.nanoTime() - nanoTime;
                        C5728b c5728b3 = new C5728b(str2);
                        long length3 = c5728b3.length();
                        if (run == 0) {
                            C11486d.m19266b(Rw, a);
                            c5728b = new C5728b(str);
                            c5728b.delete();
                            c5728b3.mo11675o(c5728b);
                            if (z2) {
                                i = 19;
                                i2 = 10012;
                            } else {
                                i = 16;
                                i2 = 10001;
                            }
                        } else {
                            c5728b3.delete();
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
                        C4990ab.m7417i(str, str3, objArr3);
                        C7060h.pYm.mo8378a(181, (long) i, 1, false);
                        C7060h c7060h2 = C7060h.pYm;
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = Integer.valueOf(i2);
                        objArr4[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(C11486d.this.kIn.statementCount()), Long.valueOf(nanoTime / 1000000), C11486d.this.kIy.format(new Date())});
                        c7060h2.mo8381e(11098, objArr4);
                        if (c33900b2 != null) {
                            c33900b2.mo23206tL(run);
                        }
                        C11486d.this.kIn.release();
                        C11486d.this.kIn = null;
                        StringBuilder stringBuilder = new StringBuilder();
                        C1720g.m3537RQ();
                        C5730e.m8643tf(stringBuilder.append(C1720g.m3536RP().eJM).append("dbback").toString());
                        str5 = str3;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        C1720g.m3537RQ();
                        C5730e.m8644y(str5, stringBuilder2.append(C1720g.m3536RP().eJM).append("dbback/EnMicroMsg.db.sm").toString());
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup, path: %s", Rw);
                        if (c33900b2 != null) {
                            c33900b2.mo23206tL(-1);
                        }
                        C7060h.pYm.mo8378a(181, z2 ? 18 : 21, 1, false);
                    } finally {
                        if (C11486d.this.kIn != null) {
                            C11486d.this.kIn.release();
                            C11486d.this.kIn = null;
                        }
                        C11486d.this.kIq = false;
                        AppMethodBeat.m2505o(18969);
                    }
                } else {
                    if (c33900b2 != null) {
                        c33900b2.mo23206tL(1);
                    }
                    AppMethodBeat.m2505o(18969);
                }
            }
        };
        this.kIq = true;
        C7305d.post(c114951, "DB Backup");
        AppMethodBeat.m2505o(18988);
        return true;
    }

    public final synchronized boolean bhP() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(18989);
            this.kIq = false;
            if (this.kIn == null) {
                AppMethodBeat.m2505o(18989);
            } else {
                this.kIn.onCancel();
                z = true;
                AppMethodBeat.m2505o(18989);
            }
        }
        return z;
    }

    @Deprecated
    /* renamed from: a */
    public final synchronized int mo23210a(String str, C33900b c33900b) {
        AppMethodBeat.m2504i(18990);
        final C18628c ZK = C9638aw.m17190ZK();
        final long dpD = C5046bo.dpD();
        final String str2 = str;
        final C33900b c33900b2 = c33900b;
        C114962 c114962 = new Runnable() {
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
                AppMethodBeat.m2504i(18970);
                C11486d.this.kIo = null;
                SQLiteDatabase openDatabase;
                try {
                    C18628c.m29080XO();
                    C18628c.m29083XR();
                    C32291o.ahl();
                    C37961o.all();
                    long nanoTime = System.nanoTime();
                    byte[] bytes = (C1427q.m3026LK() + C18628c.m29064QF()).getBytes();
                    byte[] y = C1178g.m2592y(bytes);
                    byte[] bytes2 = C1178g.m2591x(bytes).substring(0, 7).getBytes();
                    int i3 = 268435456;
                    if (C6395f.dvt()) {
                        i3 = 805306368;
                    }
                    openDatabase = SQLiteDatabase.openDatabase(C18628c.m29069Ru().dvx().getPath(), bytes2, C11486d.kIB, null, i3, null, 0);
                    try {
                        String[] strArr;
                        if (str2 != null) {
                            strArr = new String[]{str2};
                        } else {
                            String[] strArr2 = new String[2];
                            strArr2[0] = C18628c.m29067Rs() + ".bak";
                            StringBuilder stringBuilder = new StringBuilder();
                            C1720g.m3537RQ();
                            strArr2[1] = stringBuilder.append(C1720g.m3536RP().eJM).append("dbback/EnMicroMsg.db.bak").toString();
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
                                        C5728b c5728b = new C5728b(str);
                                        if (c5728b.canRead()) {
                                            j = c5728b.length();
                                            C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "[Recover] backupSize: %d, diskFreeSpace: %d", Long.valueOf(j), Long.valueOf(dpD));
                                            if (dpD >= 10 * j) {
                                                C7060h c7060h = C7060h.pYm;
                                                Object[] objArr = new Object[2];
                                                objArr[0] = Integer.valueOf(10004);
                                                objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(dpD)});
                                                c7060h.mo8381e(11098, objArr);
                                                C11486d.this.kIo = new RecoverKit(openDatabase, str, y);
                                                break;
                                            }
                                            if (c33900b2 != null) {
                                                c33900b2.mo23206tL(-2);
                                            }
                                            if (C11486d.this.kIo != null) {
                                                C11486d.this.kIo.release();
                                                C11486d.this.kIo = null;
                                            }
                                            if (openDatabase != null) {
                                                openDatabase.close();
                                            }
                                            C11486d.this.kIq = false;
                                            C9638aw.m17180RS().doM();
                                            AppMethodBeat.m2505o(18970);
                                            return;
                                        }
                                        continue;
                                        i4++;
                                    } catch (Exception e3) {
                                        C4990ab.m7412e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + e3.getMessage());
                                        i5 = -1;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    i = i5;
                                }
                            }
                            if (C11486d.this.kIo == null) {
                                i2 = -3;
                                try {
                                    C7060h.pYm.mo8378a(181, 31, 1, true);
                                    RuntimeException runtimeException = new RuntimeException();
                                    AppMethodBeat.m2505o(18970);
                                    throw runtimeException;
                                } catch (Exception e22) {
                                    e = e22;
                                    i = i2;
                                    try {
                                        C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                                        if (c33900b2 != null) {
                                        }
                                        C7060h.pYm.mo8378a(181, 23, 1, true);
                                        if (C11486d.this.kIo != null) {
                                        }
                                        if (openDatabase != null) {
                                        }
                                        C11486d.this.kIq = false;
                                        C9638aw.m17180RS().doM();
                                        AppMethodBeat.m2505o(18970);
                                    } catch (Throwable th) {
                                        e22 = th;
                                        if (C11486d.this.kIo != null) {
                                        }
                                        if (openDatabase != null) {
                                        }
                                        C11486d.this.kIq = false;
                                        C9638aw.m17180RS().doM();
                                        AppMethodBeat.m2505o(18970);
                                        throw e22;
                                    }
                                }
                            }
                            int i6;
                            i2 = C11486d.this.kIo.run(false);
                            C11486d.bhR();
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            int successCount = C11486d.this.kIo.successCount();
                            length = C11486d.this.kIo.failureCount();
                            String lastError = C11486d.this.kIo.lastError();
                            C11486d.this.kIo.release();
                            C11486d.this.kIo = null;
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
                            C4990ab.m7417i(str, str2, objArr2);
                            if (i2 == 0) {
                                i6 = 10005;
                                i5 = 22;
                            } else if (i2 == 1) {
                                i6 = 10006;
                                i5 = -1;
                            } else {
                                i6 = CdnLogic.kMediaTypeFavoriteBigFile;
                                i5 = 23;
                                C7060h.pYm.mo8382g("DBRepair", "Backup recover failed: ".concat(String.valueOf(lastError)), null);
                            }
                            C7060h c7060h2 = C7060h.pYm;
                            objArr2 = new Object[2];
                            objArr2[0] = Integer.valueOf(i6);
                            objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(j), Long.valueOf(nanoTime2 / 1000000), Integer.valueOf(successCount), Integer.valueOf(length)});
                            c7060h2.mo8381e(11098, objArr2);
                            if (i5 >= 0) {
                                C7060h.pYm.mo8378a(181, (long) i5, 1, true);
                            }
                            if (c33900b2 != null) {
                                c33900b2.mo23206tL(i2);
                            }
                            if (C11486d.this.kIo != null) {
                                C11486d.this.kIo.release();
                                C11486d.this.kIo = null;
                            }
                            C11486d.this.kIq = false;
                            C9638aw.m17180RS().doM();
                            AppMethodBeat.m2505o(18970);
                        } catch (Exception e222) {
                            e = e222;
                            i = -3;
                            C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                            if (c33900b2 != null) {
                                c33900b2.mo23206tL(i);
                            }
                            C7060h.pYm.mo8378a(181, 23, 1, true);
                            if (C11486d.this.kIo != null) {
                                C11486d.this.kIo.release();
                                C11486d.this.kIo = null;
                            }
                            if (openDatabase != null) {
                                openDatabase.close();
                            }
                            C11486d.this.kIq = false;
                            C9638aw.m17180RS().doM();
                            AppMethodBeat.m2505o(18970);
                        }
                    } catch (Exception e2222) {
                        e = e2222;
                        i = -1;
                        C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                        if (c33900b2 != null) {
                        }
                        C7060h.pYm.mo8378a(181, 23, 1, true);
                        if (C11486d.this.kIo != null) {
                        }
                        if (openDatabase != null) {
                        }
                        C11486d.this.kIq = false;
                        C9638aw.m17180RS().doM();
                        AppMethodBeat.m2505o(18970);
                    }
                } catch (Exception e22222) {
                    e = e22222;
                    openDatabase = null;
                    i = -1;
                    C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                    if (c33900b2 != null) {
                    }
                    C7060h.pYm.mo8378a(181, 23, 1, true);
                    if (C11486d.this.kIo != null) {
                    }
                    if (openDatabase != null) {
                    }
                    C11486d.this.kIq = false;
                    C9638aw.m17180RS().doM();
                    AppMethodBeat.m2505o(18970);
                } catch (Throwable th2) {
                    e22222 = th2;
                    openDatabase = null;
                    if (C11486d.this.kIo != null) {
                        C11486d.this.kIo.release();
                        C11486d.this.kIo = null;
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    C11486d.this.kIq = false;
                    C9638aw.m17180RS().doM();
                    AppMethodBeat.m2505o(18970);
                    throw e22222;
                }
            }
        };
        this.kIq = true;
        C9638aw.m17180RS().mo10299Bn();
        C9638aw.m17180RS().mo10303ae(c114962);
        AppMethodBeat.m2505o(18990);
        return 0;
    }

    @Deprecated
    /* renamed from: b */
    public final synchronized int mo23212b(String str, final C33900b c33900b) {
        int i = 0;
        synchronized (this) {
            C5728b c5728b;
            AppMethodBeat.m2504i(18991);
            final C18628c ZK = C9638aw.m17190ZK();
            if (str == null) {
                str = C18628c.m29067Rs();
            }
            long dpD = C5046bo.dpD();
            if (str == null) {
                c5728b = null;
            } else {
                c5728b = new C5728b(str);
            }
            if (c5728b == null || !c5728b.canRead()) {
                i = -3;
                AppMethodBeat.m2505o(18991);
            } else {
                C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", Long.valueOf(c5728b.length()), Long.valueOf(dpD));
                if (((float) dpD) < ((float) c5728b.length()) * 1.5f) {
                    i = -2;
                    AppMethodBeat.m2505o(18991);
                } else {
                    C114873 c114873 = new Runnable() {
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
                        /* JADX WARNING: Removed duplicated region for block: B:87:0x02c6 A:{PHI: r2 , Splitter:B:11:0x00af, ExcHandler: all (th java.lang.Throwable)} */
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7412e("MicroMsg.SubCoreDBBackup", "Failed to load saved master: " + r0.getMessage());
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
                            AppMethodBeat.m2504i(18972);
                            C11486d.this.kIp = null;
                            try {
                                C18628c.m29080XO();
                                C18628c.m29083XR();
                                C32291o.ahl();
                                C37961o.all();
                                byte[] bytes = (C1427q.m3026LK() + C18628c.m29064QF()).getBytes();
                                byte[] y = C1178g.m2592y(bytes);
                                byte[] bytes2 = C1178g.m2591x(bytes).substring(0, 7).getBytes();
                                int i = 268435456;
                                if (C6395f.dvt()) {
                                    i = 805306368;
                                }
                                openDatabase = SQLiteDatabase.openDatabase(C18628c.m29069Ru().dvx().getPath(), bytes2, C11486d.kIB, null, i, null, 0);
                                try {
                                    long nanoTime = System.nanoTime();
                                    String[] strArr = new String[2];
                                    strArr[0] = str + ".sm";
                                    StringBuilder stringBuilder = new StringBuilder();
                                    C1720g.m3537RQ();
                                    strArr[1] = stringBuilder.append(C1720g.m3536RP().eJM).append("dbback/EnMicroMsg.db.sm").toString();
                                    int i2 = 0;
                                    MasterInfo masterInfo2 = null;
                                    while (i2 < 2) {
                                        try {
                                            String str = strArr[i2];
                                            masterInfo2 = MasterInfo.load(str, y, this.kIR);
                                            C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Loaded saved master: ".concat(String.valueOf(str)));
                                            break;
                                        } catch (Exception e2) {
                                            e = e2;
                                            sQLiteDatabase = openDatabase;
                                            masterInfo = masterInfo2;
                                            try {
                                                C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                                if (c33900b != null) {
                                                }
                                                C7060h.pYm.mo8382g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                                C7060h.pYm.mo8378a(181, 27, 1, true);
                                                if (C11486d.this.kIp != null) {
                                                }
                                                if (sQLiteDatabase != null) {
                                                }
                                                if (masterInfo != null) {
                                                }
                                                C11486d.this.kIq = false;
                                                C9638aw.m17180RS().doM();
                                                AppMethodBeat.m2505o(18972);
                                            } catch (Throwable th) {
                                                e = th;
                                                openDatabase = sQLiteDatabase;
                                                if (C11486d.this.kIp != null) {
                                                    C11486d.this.kIp.release();
                                                    C11486d.this.kIp = null;
                                                }
                                                if (openDatabase != null) {
                                                    openDatabase.close();
                                                }
                                                if (masterInfo != null) {
                                                    masterInfo.release();
                                                }
                                                C11486d.this.kIq = false;
                                                C9638aw.m17180RS().doM();
                                                AppMethodBeat.m2505o(18972);
                                                throw e;
                                            }
                                        } catch (Throwable th2) {
                                        }
                                    }
                                    if (masterInfo2 == null) {
                                        masterInfo2 = MasterInfo.make(this.kIR);
                                        C4990ab.m7420w("MicroMsg.SubCoreDBBackup", "Saved master not available.");
                                        C7060h.pYm.mo8378a(181, 32, 1, true);
                                    } else if (i2 > 0) {
                                        C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Use backup saved master.");
                                        C7060h.pYm.mo8378a(181, 33, 1, true);
                                    }
                                    C11486d.this.kIp = new RepairKit(str, bytes2, C11486d.kIB, masterInfo2);
                                    int i3 = C11486d.this.kIp.output(openDatabase, 1) == 0 ? 1 : 0;
                                    int i4 = (C11486d.this.kIp.isHeaderCorrupted() && C11486d.this.kIp.isDataCorrupted()) ? 0 : 1;
                                    i3 &= i4;
                                    openDatabase.close();
                                    sQLiteDatabase = null;
                                    try {
                                        masterInfo2.release();
                                        masterInfo = null;
                                        try {
                                            C11486d.this.kIp.release();
                                            C11486d.this.kIp = null;
                                            C11486d.bhR();
                                            long nanoTime2 = System.nanoTime() - nanoTime;
                                            String str2 = "MicroMsg.SubCoreDBBackup";
                                            String str3 = "DB repair %s, elapsed %.2f seconds.";
                                            Object[] objArr = new Object[2];
                                            objArr[0] = i3 != 0 ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed";
                                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                                            C4990ab.m7417i(str2, str3, objArr);
                                            if (i3 != 0) {
                                                i4 = 26;
                                                if (c33900b != null) {
                                                    c33900b.mo23206tL(0);
                                                }
                                            } else {
                                                i4 = 27;
                                                if (c33900b != null) {
                                                    c33900b.mo23206tL(-1);
                                                }
                                                C7060h.pYm.mo8382g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                            }
                                            C7060h.pYm.mo8378a(181, (long) i4, 1, true);
                                            if (C11486d.this.kIp != null) {
                                                C11486d.this.kIp.release();
                                                C11486d.this.kIp = null;
                                            }
                                            C11486d.this.kIq = false;
                                            C9638aw.m17180RS().doM();
                                            AppMethodBeat.m2505o(18972);
                                        } catch (Exception e3) {
                                            e = e3;
                                            C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                            if (c33900b != null) {
                                            }
                                            C7060h.pYm.mo8382g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                            C7060h.pYm.mo8378a(181, 27, 1, true);
                                            if (C11486d.this.kIp != null) {
                                            }
                                            if (sQLiteDatabase != null) {
                                            }
                                            if (masterInfo != null) {
                                            }
                                            C11486d.this.kIq = false;
                                            C9638aw.m17180RS().doM();
                                            AppMethodBeat.m2505o(18972);
                                        } catch (Throwable th3) {
                                            e = th3;
                                            openDatabase = null;
                                            if (C11486d.this.kIp != null) {
                                            }
                                            if (openDatabase != null) {
                                            }
                                            if (masterInfo != null) {
                                            }
                                            C11486d.this.kIq = false;
                                            C9638aw.m17180RS().doM();
                                            AppMethodBeat.m2505o(18972);
                                            throw e;
                                        }
                                    } catch (Exception e4) {
                                        e = e4;
                                        masterInfo = masterInfo2;
                                        C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                        if (c33900b != null) {
                                        }
                                        C7060h.pYm.mo8382g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                        C7060h.pYm.mo8378a(181, 27, 1, true);
                                        if (C11486d.this.kIp != null) {
                                        }
                                        if (sQLiteDatabase != null) {
                                        }
                                        if (masterInfo != null) {
                                        }
                                        C11486d.this.kIq = false;
                                        C9638aw.m17180RS().doM();
                                        AppMethodBeat.m2505o(18972);
                                    } catch (Throwable th4) {
                                        e = th4;
                                        openDatabase = null;
                                        masterInfo = masterInfo2;
                                        if (C11486d.this.kIp != null) {
                                        }
                                        if (openDatabase != null) {
                                        }
                                        if (masterInfo != null) {
                                        }
                                        C11486d.this.kIq = false;
                                        C9638aw.m17180RS().doM();
                                        AppMethodBeat.m2505o(18972);
                                        throw e;
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    sQLiteDatabase = openDatabase;
                                    masterInfo = null;
                                    C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                    if (c33900b != null) {
                                        c33900b.mo23206tL(-1);
                                    }
                                    C7060h.pYm.mo8382g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                    C7060h.pYm.mo8378a(181, 27, 1, true);
                                    if (C11486d.this.kIp != null) {
                                        C11486d.this.kIp.release();
                                        C11486d.this.kIp = null;
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    if (masterInfo != null) {
                                        masterInfo.release();
                                    }
                                    C11486d.this.kIq = false;
                                    C9638aw.m17180RS().doM();
                                    AppMethodBeat.m2505o(18972);
                                } catch (Throwable th5) {
                                    e = th5;
                                    masterInfo = null;
                                    if (C11486d.this.kIp != null) {
                                    }
                                    if (openDatabase != null) {
                                    }
                                    if (masterInfo != null) {
                                    }
                                    C11486d.this.kIq = false;
                                    C9638aw.m17180RS().doM();
                                    AppMethodBeat.m2505o(18972);
                                    throw e;
                                }
                            } catch (Exception e6) {
                                e = e6;
                                sQLiteDatabase = null;
                                masterInfo = null;
                                C4990ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                if (c33900b != null) {
                                }
                                C7060h.pYm.mo8382g("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                C7060h.pYm.mo8378a(181, 27, 1, true);
                                if (C11486d.this.kIp != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                if (masterInfo != null) {
                                }
                                C11486d.this.kIq = false;
                                C9638aw.m17180RS().doM();
                                AppMethodBeat.m2505o(18972);
                            } catch (Throwable th6) {
                                e = th6;
                                openDatabase = null;
                                masterInfo = null;
                                if (C11486d.this.kIp != null) {
                                }
                                if (openDatabase != null) {
                                }
                                if (masterInfo != null) {
                                }
                                C11486d.this.kIq = false;
                                C9638aw.m17180RS().doM();
                                AppMethodBeat.m2505o(18972);
                                throw e;
                            }
                        }
                    };
                    this.kIq = true;
                    C9638aw.m17180RS().mo10299Bn();
                    C9638aw.m17180RS().mo10303ae(c114873);
                    AppMethodBeat.m2505o(18991);
                }
            }
        }
        return i;
    }

    @Deprecated
    /* renamed from: a */
    public final int mo23209a(final C33900b c33900b) {
        AppMethodBeat.m2504i(18992);
        C9638aw.m17190ZK();
        String Rs = C18628c.m29067Rs();
        if (Rs == null || Rs.isEmpty()) {
            AppMethodBeat.m2505o(18992);
            return -3;
        }
        final C5728b c5728b = new C5728b(Rs);
        if (c5728b.canRead()) {
            StringBuilder append = new StringBuilder().append(C1427q.m3026LK());
            C9638aw.m17190ZK();
            final String substring = C1178g.m2591x(append.append(C18628c.m29064QF()).toString().getBytes()).substring(0, 7);
            C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", Long.valueOf(c5728b.length() * 2), Long.valueOf(C5046bo.dpD()));
            if (C5046bo.dpD() < c5728b.length() * 2) {
                AppMethodBeat.m2505o(18992);
                return -2;
            }
            C9638aw.m17180RS().mo10299Bn();
            C9638aw.m17180RS().mo10303ae(new Runnable() {
                public final void run() {
                    int i;
                    AppMethodBeat.m2504i(18973);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                    C9638aw.m17190ZK();
                    String Rt = C18628c.m29068Rt();
                    String str = Rt + c5728b.getName().replace(".db", "temp.db");
                    C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "temp db path is %s", str);
                    c5728b.mo11675o(new C5728b(str));
                    String str2 = Rt + "sqlTemp.sql";
                    List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
                    final int[] iArr = new int[1];
                    long currentTimeMillis = System.currentTimeMillis();
                    C9638aw.m17190ZK();
                    boolean a = C18628c.m29069Ru().mo16658a(str, substring, str2, asList, new ExecuteSqlCallback() {
                        public final String preExecute(String str) {
                            int[] iArr = iArr;
                            iArr[0] = iArr[0] + 1;
                            return null;
                        }
                    });
                    if (a) {
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().bOz();
                        C9638aw.m17190ZK();
                        C18628c.m29083XR().dsL();
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().bOB();
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().bOA();
                        i = 12;
                    } else {
                        i = 15;
                    }
                    C7060h.pYm.mo8378a(181, (long) i, 1, true);
                    C4990ab.m7417i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(a ? 1 : 0);
                    objArr[1] = iArr;
                    objArr[2] = Long.valueOf(r2);
                    c7060h.mo8381e(11224, objArr);
                    C9638aw.m17180RS().doM();
                    if (c33900b != null) {
                        c33900b.mo23206tL(a ? 0 : -1);
                    }
                    AppMethodBeat.m2505o(18973);
                }
            });
            AppMethodBeat.m2505o(18992);
            return 0;
        }
        AppMethodBeat.m2505o(18992);
        return -3;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(18993);
        C9638aw.m17190ZK();
        C7580z Ry = C18628c.m29072Ry();
        SQLiteDatabase dvx = C18628c.m29069Ru().dvx();
        this.kIv = Ry.mo16813Mm(237569);
        this.kIw = Ry.getInt(237570, 10);
        this.kIx = Ry.getInt(237571, 0) != 0;
        Context context = C4996ah.getContext();
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
        this.kIz = new C114927();
        C18624c.abi().mo10116c(this.kIz);
        C11486d.bhQ();
        this.kIA = new C114978();
        C4879a.xxA.mo10052c(this.kIA);
        this.jZU = new C114939();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.jZU, intentFilter);
        C44042b.m79163a(new C11477c(this), "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy");
        String str = "MicroMsg.SubCoreDBBackup";
        String str2 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        Object[] objArr = new Object[3];
        objArr[0] = this.kIs ? "enabled" : "disabled";
        objArr[1] = this.jZT ? "" : " not";
        objArr[2] = this.jZS ? "" : " not";
        C4990ab.m7417i(str, str2, objArr);
        C11486d.m19265b(dvx);
        C27700b.m44016Ii(C1427q.m3026LK());
        C5730e.deleteFile(C1720g.m3536RP().eJM + "dbback/EnMicroMsg.db.bak");
        C5730e.deleteFile(C1720g.m3536RP().eJM + "dbback/corrupted/EnMicroMsg.db.bak");
        C5730e.deleteFile(C1720g.m3536RP().cachePath + "EnMicroMsg.db.bak");
        C5730e.deleteFile(C1720g.m3536RP().cachePath + "corrupted/EnMicroMsg.db.bak");
        final String Rt = C18628c.m29068Rt();
        C9638aw.m17180RS().mo10310m(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(18975);
                if (C5730e.m8628ct((Rt + "corrupted/EnMicroMsg.db") + ".corrupt")) {
                    AppMethodBeat.m2505o(18975);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                C5728b c5728b = new C5728b(Rt + "corrupted");
                if (c5728b.isDirectory()) {
                    for (C5728b lastModified : c5728b.dMF()) {
                        if (currentTimeMillis - lastModified.lastModified() < 7776000000L) {
                            AppMethodBeat.m2505o(18975);
                            return;
                        }
                    }
                    if (C5730e.m8618N(C5736j.m8649w(c5728b.mUri), true)) {
                        C4990ab.m7416i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
                    }
                    AppMethodBeat.m2505o(18975);
                    return;
                }
                AppMethodBeat.m2505o(18975);
            }
        }, 60000);
        AppMethodBeat.m2505o(18993);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(18994);
        bhP();
        this.kIr = false;
        if (this.jZV != null) {
            C9638aw.m17180RS().doN().removeCallbacks(this.jZV);
            this.jZV = null;
        }
        if (this.kIA != null) {
            C4879a.xxA.mo10053d(this.kIA);
            this.kIA = null;
        }
        if (this.jZU != null) {
            C4996ah.getContext().unregisterReceiver(this.jZU);
            this.jZU = null;
        }
        C44042b.m79162N("//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy");
        AppMethodBeat.m2505o(18994);
    }

    private static void bhQ() {
        AppMethodBeat.m2504i(18995);
        C5141c ll = C18624c.abi().mo17131ll("100274");
        if (ll.isValid()) {
            Map dru = ll.dru();
            HashMap hashMap = new HashMap();
            hashMap.put("flags", Integer.valueOf(C5046bo.getInt((String) dru.get("flags"), 0)));
            hashMap.put("acp", Integer.valueOf(C5046bo.getInt((String) dru.get("acp"), 100)));
            C6395f.m10548aV(hashMap);
        }
        AppMethodBeat.m2505o(18995);
    }

    static void bhR() {
        AppMethodBeat.m2504i(18996);
        C6977h XO = C18628c.m29080XO();
        XO.bOz();
        XO.bOB();
        XO.bOA();
        C18628c.m29083XR().dsL();
        C32291o.ahl().agT();
        C7580z Ry = C18628c.m29072Ry();
        Ry.set(C5127a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
        Ry.set(C5127a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
        Ry.set(C5127a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0));
        AppMethodBeat.m2505o(18996);
    }

    /* renamed from: dB */
    public static void m19272dB(Context context) {
        AppMethodBeat.m2504i(18997);
        MMAppMgr.m7913k(context, true);
        AppMethodBeat.m2505o(18997);
    }

    public static void bhS() {
        AppMethodBeat.m2504i(18998);
        MMAppMgr.m7914pQ(true);
        AppMethodBeat.m2505o(18998);
    }
}

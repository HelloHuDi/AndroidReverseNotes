package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.Callback;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import org.json.JSONObject;

public final class a extends AsyncTask<Void, Integer, Integer> {
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE"};
    private static final SQLiteCipherSpec kJb = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private SQLiteDatabase kJc;
    private String kJd;
    private String kJe;
    private String kJf;
    private String kJg;
    private List<String> kJh;
    private List<String> kJi;
    private byte[] kJj;
    private byte[] kJk;
    private List<byte[]> kJl;
    private List<byte[]> kJm;
    private c kJn;
    private boolean kJo;
    private b kJp;
    private boolean kJq;
    private int kJr;
    private long kJs;
    private long kJt;
    private final CancellationSignal mCancellationSignal;

    public static class a {
        private LinkedHashSet<byte[]> kJD = new LinkedHashSet();
        private LinkedHashSet<byte[]> kJE = new LinkedHashSet();
        public String kJd;
        public String kJe;
        public String kJf;
        public String kJg;
        private List<String> kJh = new ArrayList();
        private List<String> kJi = new ArrayList();
        private byte[] kJj;
        private byte[] kJk;
        public c kJn;
        public boolean kJo;
        public b kJp;

        public a() {
            AppMethodBeat.i(19006);
            AppMethodBeat.o(19006);
        }

        public final a bia() {
            AppMethodBeat.i(19007);
            a aVar = new a();
            aVar.kJd = this.kJd;
            aVar.kJe = this.kJe;
            aVar.kJf = this.kJf;
            aVar.kJg = this.kJg;
            aVar.kJh = new ArrayList(this.kJh);
            aVar.kJi = new ArrayList(this.kJi);
            aVar.kJj = this.kJj;
            aVar.kJk = this.kJk;
            aVar.kJn = this.kJn;
            aVar.kJl = new ArrayList(this.kJD);
            aVar.kJm = new ArrayList(this.kJE);
            aVar.kJo = this.kJo;
            aVar.kJp = this.kJp;
            AppMethodBeat.o(19007);
            return aVar;
        }

        public final a Ig(String str) {
            AppMethodBeat.i(19008);
            this.kJh.add(str);
            AppMethodBeat.o(19008);
            return this;
        }

        public final a Ih(String str) {
            AppMethodBeat.i(19009);
            this.kJi.add(str);
            AppMethodBeat.o(19009);
            return this;
        }

        public final a aC(byte[] bArr) {
            AppMethodBeat.i(19010);
            this.kJj = Arrays.copyOf(bArr, bArr.length);
            AppMethodBeat.o(19010);
            return this;
        }

        public final a aD(byte[] bArr) {
            AppMethodBeat.i(19011);
            this.kJk = Arrays.copyOf(bArr, bArr.length);
            AppMethodBeat.o(19011);
            return this;
        }
    }

    public interface b {
        void F(long j, long j2);

        void R(int i, int i2, int i3);

        void onCanceled();

        void onFailure();

        void onSuccess();
    }

    public interface c {
        Collection<byte[]> bhN();

        Collection<byte[]> bhO();
    }

    interface d {
        boolean a(Cursor cursor, SQLiteStatement sQLiteStatement);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.i(19027);
        Integer ot = ot();
        AppMethodBeat.o(19027);
        return ot;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(19026);
        Integer num = (Integer) obj;
        if (this.kJp != null) {
            switch (num.intValue()) {
                case -2:
                    this.kJp.F(this.kJt, this.kJs);
                    AppMethodBeat.o(19026);
                    return;
                case 0:
                    this.kJp.onSuccess();
                    AppMethodBeat.o(19026);
                    return;
                case 1:
                    this.kJp.onCanceled();
                    AppMethodBeat.o(19026);
                    return;
                default:
                    this.kJp.onFailure();
                    break;
            }
        }
        AppMethodBeat.o(19026);
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        int i = 0;
        AppMethodBeat.i(19025);
        Integer[] numArr = (Integer[]) objArr;
        if (this.kJp != null) {
            int intValue;
            int intValue2 = numArr.length > 0 ? numArr[0].intValue() : 0;
            if (numArr.length >= 2) {
                intValue = numArr[1].intValue();
            } else {
                intValue = 0;
            }
            if (numArr.length >= 3) {
                i = numArr[2].intValue();
            }
            this.kJp.R(intValue2, intValue, i);
        }
        AppMethodBeat.o(19025);
    }

    static {
        AppMethodBeat.i(19030);
        AppMethodBeat.o(19030);
    }

    private a() {
        AppMethodBeat.i(19012);
        this.mCancellationSignal = new CancellationSignal();
        AppMethodBeat.o(19012);
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x021e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Integer ot() {
        Integer valueOf;
        int bhW;
        Throwable th;
        Throwable th2;
        int i = 0;
        AppMethodBeat.i(19013);
        tM(54);
        int i2 = -1;
        WakeLock newWakeLock = ((PowerManager) ah.getContext().getSystemService("power")).newWakeLock(1, "DBRecovery");
        long uptimeMillis = SystemClock.uptimeMillis();
        newWakeLock.acquire(1800000);
        try {
            publishProgress(new Integer[]{Integer.valueOf(1)});
            i2 = bhV();
            long uptimeMillis2;
            if (i2 != 0) {
                valueOf = Integer.valueOf(i2);
                switch (i2) {
                    case -2:
                        tM(58);
                        break;
                    case 0:
                        uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                        tM(55);
                        e.pXa.a(181, 60, (uptimeMillis2 / 1000) + 1, true);
                        break;
                    case 1:
                        tM(56);
                        break;
                    default:
                        tM(57);
                        break;
                }
                newWakeLock.release();
                AppMethodBeat.o(19013);
            } else {
                if (this.kJn != null) {
                    ab.i("MicroMsg.DBRecoveryTask", "Load keys from KeyLoader");
                    this.kJl.addAll(this.kJn.bhN());
                    this.kJm.addAll(this.kJn.bhO());
                }
                if (this.kJl.isEmpty()) {
                    this.kJl.add(null);
                }
                if (this.kJm.isEmpty()) {
                    this.kJm.add(null);
                }
                try {
                    bhW = bhW();
                    try {
                        publishProgress(new Integer[]{Integer.valueOf(2)});
                        i2 = bhX();
                        if (i2 == 1) {
                            valueOf = Integer.valueOf(i2);
                            switch (i2) {
                                case -2:
                                    tM(58);
                                    break;
                                case 0:
                                    uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                    tM(55);
                                    e.pXa.a(181, 60, (uptimeMillis2 / 1000) + 1, true);
                                    break;
                                case 1:
                                    tM(56);
                                    break;
                                default:
                                    tM(57);
                                    break;
                            }
                            newWakeLock.release();
                            AppMethodBeat.o(19013);
                        } else {
                            if (i2 == -1) {
                                publishProgress(new Integer[]{Integer.valueOf(4)});
                                i2 = bhY();
                            }
                            if (i2 != 0) {
                                valueOf = Integer.valueOf(i2);
                                switch (i2) {
                                    case -2:
                                        tM(58);
                                        break;
                                    case 0:
                                        uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                        tM(55);
                                        e.pXa.a(181, 60, (uptimeMillis2 / 1000) + 1, true);
                                        break;
                                    case 1:
                                        tM(56);
                                        break;
                                    default:
                                        tM(57);
                                        break;
                                }
                                newWakeLock.release();
                                AppMethodBeat.o(19013);
                            } else {
                                publishProgress(new Integer[]{Integer.valueOf(5)});
                                bhW = bhZ();
                                publishProgress(new Integer[]{Integer.valueOf(6)});
                                i2 = fY(true);
                                valueOf = Integer.valueOf(i2);
                                switch (i2) {
                                    case -2:
                                        tM(58);
                                        break;
                                    case 0:
                                        uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                        tM(55);
                                        e.pXa.a(181, 60, (uptimeMillis2 / 1000) + 1, true);
                                        break;
                                    case 1:
                                        tM(56);
                                        break;
                                    default:
                                        tM(57);
                                        break;
                                }
                                newWakeLock.release();
                                AppMethodBeat.o(19013);
                            }
                        }
                    } catch (OperationCanceledException e) {
                    } catch (Exception e2) {
                        th = e2;
                        i = bhW;
                        try {
                            ab.printErrStackTrace("MicroMsg.DBRecoveryTask", th, "Recovery failed.", new Object[0]);
                            fY(false);
                            try {
                                valueOf = Integer.valueOf(-1);
                                tM(57);
                                newWakeLock.release();
                                AppMethodBeat.o(19013);
                                return valueOf;
                            } catch (Throwable th3) {
                                th2 = th3;
                                i = -1;
                                switch (i) {
                                    case -2:
                                        tM(58);
                                        break;
                                    case 0:
                                        uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                                        tM(55);
                                        e.pXa.a(181, 60, (uptimeMillis2 / 1000) + 1, true);
                                        break;
                                    case 1:
                                        tM(56);
                                        break;
                                    default:
                                        tM(57);
                                        break;
                                }
                                newWakeLock.release();
                                AppMethodBeat.o(19013);
                                throw th2;
                            }
                        } catch (Throwable th32) {
                            th2 = th32;
                            switch (i) {
                                case -2:
                                    break;
                                case 0:
                                    break;
                                case 1:
                                    break;
                                default:
                                    break;
                            }
                            newWakeLock.release();
                            AppMethodBeat.o(19013);
                            throw th2;
                        }
                    }
                } catch (OperationCanceledException e3) {
                    bhW = 0;
                    try {
                        ab.i("MicroMsg.DBRecoveryTask", "Recovery cancelled.");
                        fY(false);
                    } catch (Throwable e22) {
                        th2 = e22;
                        i = bhW;
                        switch (i) {
                            case -2:
                                break;
                            case 0:
                                break;
                            case 1:
                                break;
                            default:
                                break;
                        }
                        newWakeLock.release();
                        AppMethodBeat.o(19013);
                        throw th2;
                    }
                    try {
                        valueOf = Integer.valueOf(1);
                        tM(56);
                        newWakeLock.release();
                        AppMethodBeat.o(19013);
                        return valueOf;
                    } catch (Throwable th322) {
                        th2 = th322;
                        i = 1;
                        switch (i) {
                            case -2:
                                break;
                            case 0:
                                break;
                            case 1:
                                break;
                            default:
                                break;
                        }
                        newWakeLock.release();
                        AppMethodBeat.o(19013);
                        throw th2;
                    }
                } catch (Exception th3222) {
                    th = th3222;
                    ab.printErrStackTrace("MicroMsg.DBRecoveryTask", th, "Recovery failed.", new Object[0]);
                    fY(false);
                    valueOf = Integer.valueOf(-1);
                    tM(57);
                    newWakeLock.release();
                    AppMethodBeat.o(19013);
                    return valueOf;
                }
            }
        } catch (OperationCanceledException e4) {
            bhW = i2;
        } catch (Exception th32222) {
            th = th32222;
            i = i2;
            ab.printErrStackTrace("MicroMsg.DBRecoveryTask", th, "Recovery failed.", new Object[0]);
            fY(false);
            valueOf = Integer.valueOf(-1);
            tM(57);
            newWakeLock.release();
            AppMethodBeat.o(19013);
            return valueOf;
        }
        return valueOf;
    }

    public final void cancel() {
        AppMethodBeat.i(19014);
        this.mCancellationSignal.cancel();
        ab.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
        AppMethodBeat.o(19014);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int bhV() {
        long j = 0;
        AppMethodBeat.i(19015);
        ab.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
        if (this.kJd == null || this.kJd.isEmpty()) {
            AppMethodBeat.o(19015);
            return -1;
        }
        long j2;
        this.kJq = false;
        this.kJr = 300000;
        if (this.kJg != null) {
            try {
                JSONObject jSONObject = new JSONObject(com.tencent.mm.vfs.e.cy(this.kJg));
                this.kJr = jSONObject.getInt(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                this.kJq = true;
                j2 = jSONObject.getLong("dbSize");
            } catch (FileNotFoundException e) {
                ab.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.kJg);
                j2 = 0;
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.DBRecoveryTask", e2, "Cannot read statistics from file.", new Object[0]);
            }
            if (this.kJf != null) {
                j = com.tencent.mm.vfs.e.asZ(this.kJf);
            }
            this.kJs = Math.max(j2, j);
            this.kJs += Math.max(this.kJs / 10, 67108864);
            this.kJt = If(this.kJd);
            if (this.kJs <= this.kJt) {
                ab.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", Long.valueOf(this.kJs), Long.valueOf(this.kJt));
                AppMethodBeat.o(19015);
                return -2;
            }
            ab.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", Long.valueOf(this.kJs), Long.valueOf(this.kJt), Integer.valueOf(this.kJr));
            AppMethodBeat.o(19015);
            return 0;
        }
        j2 = 0;
        if (this.kJf != null) {
        }
        this.kJs = Math.max(j2, j);
        this.kJs += Math.max(this.kJs / 10, 67108864);
        this.kJt = If(this.kJd);
        if (this.kJs <= this.kJt) {
        }
    }

    private int bhW() {
        AppMethodBeat.i(19016);
        if (this.kJc != null) {
            if (this.kJc.isOpen()) {
                this.kJc.close();
            }
            this.kJc = null;
        }
        this.mCancellationSignal.throwIfCanceled();
        String str = this.kJd + '-' + bo.Mb(6);
        ab.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
        try {
            this.kJc = SQLiteDatabase.openOrCreateDatabase(str, this.kJj, kJb, null, null, 1);
            DatabaseUtils.stringForQuery(this.kJc, "PRAGMA journal_mode=OFF;", null);
            this.kJc.execSQL("PRAGMA synchronous=OFF;");
            AppMethodBeat.o(19016);
            return 0;
        } catch (Exception e) {
            ab.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", str, e.getMessage());
            a(1, "Cannot open target database", e);
            AppMethodBeat.o(19016);
            throw e;
        }
    }

    private int fY(boolean z) {
        AppMethodBeat.i(19017);
        ab.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.kJd);
        if (this.kJc == null) {
            AppMethodBeat.o(19017);
            return -1;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.kJc.getPath());
        if (this.kJc.isOpen()) {
            this.kJc.close();
        }
        if (!z) {
            ab.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", bVar);
            bVar.delete();
        } else if (!bVar.o(new com.tencent.mm.vfs.b(this.kJd))) {
            ab.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", bVar, this.kJd);
            AppMethodBeat.o(19017);
            return -1;
        }
        AppMethodBeat.o(19017);
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0245 A:{Splitter:B:16:0x00a4, PHI: r5 , ExcHandler: OperationCanceledException (e com.tencent.wcdb.support.OperationCanceledException)} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:79:0x0230, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:80:0x0231, code skipped:
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:85:0x023c, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:86:0x023d, code skipped:
            r10 = null;
     */
    /* JADX WARNING: Missing block: B:91:0x0245, code skipped:
            r0 = e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int bhX() {
        MasterInfo masterInfo;
        MasterInfo masterInfo2;
        boolean z;
        OperationCanceledException e;
        Throwable th;
        RepairKit repairKit;
        RuntimeException e2;
        RepairKit repairKit2 = null;
        int i = 0;
        AppMethodBeat.i(19018);
        this.mCancellationSignal.throwIfCanceled();
        String[] strArr = new String[]{ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "ImgInfo2", "videoinfo2", "EmojiInfo", "rconversation"};
        MasterInfo masterInfo3 = null;
        loop0:
        for (String str : this.kJh) {
            if (com.tencent.mm.vfs.e.ct(str)) {
                int i2 = 0;
                while (i2 < this.kJl.size()) {
                    try {
                        masterInfo3 = MasterInfo.load(str, (byte[]) this.kJl.get(i2), strArr);
                        ab.i("MicroMsg.DBRecoveryTask", "Loaded saved master: " + str + ", key: #" + i2);
                        masterInfo = masterInfo3;
                        break loop0;
                    } catch (Exception e3) {
                        ab.e("MicroMsg.DBRecoveryTask", "Failed to load saved master: " + e3.getMessage() + ", path: " + str + ", key: #" + i2);
                        i2++;
                    }
                }
                continue;
            } else {
                ab.i("MicroMsg.DBRecoveryTask", "Saved master file not exist: ".concat(String.valueOf(str)));
            }
        }
        masterInfo = masterInfo3;
        if (masterInfo == null) {
            masterInfo = MasterInfo.make(strArr);
            ab.w("MicroMsg.DBRecoveryTask", "Saved master not available.");
            masterInfo2 = masterInfo;
            z = false;
        } else {
            ab.i("MicroMsg.DBRecoveryTask", "Use backup saved master.");
            masterInfo2 = masterInfo;
            z = true;
        }
        final int[] iArr = new int[]{0};
        try {
            ab.i("MicroMsg.DBRecoveryTask", "Begin repair: " + this.kJf);
            while (i < this.kJm.size()) {
                RepairKit repairKit3 = new RepairKit(this.kJf, (byte[]) this.kJm.get(i), kJb, masterInfo2);
                try {
                    if (!repairKit3.isHeaderCorrupted()) {
                        ab.i("MicroMsg.DBRecoveryTask", "Opened corrupted database with key #".concat(String.valueOf(i)));
                        repairKit2 = repairKit3;
                        break;
                    }
                    ab.w("MicroMsg.DBRecoveryTask", "Header check failed with key #".concat(String.valueOf(i)));
                    i++;
                } catch (OperationCanceledException e4) {
                    e = e4;
                    repairKit2 = repairKit3;
                    try {
                        AppMethodBeat.o(19018);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        repairKit = repairKit2;
                        if (repairKit != null) {
                        }
                        AppMethodBeat.o(19018);
                        throw th;
                    }
                } catch (RuntimeException e5) {
                    e2 = e5;
                    repairKit = repairKit3;
                    try {
                        ab.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e2.getMessage());
                        a(2, "Failed to repair database => sm: ".concat(String.valueOf(z)), e2);
                        if (repairKit != null) {
                            repairKit.release();
                        }
                        AppMethodBeat.o(19018);
                        return -1;
                    } catch (Throwable th3) {
                        th = th3;
                        if (repairKit != null) {
                        }
                        AppMethodBeat.o(19018);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    repairKit = repairKit3;
                    if (repairKit != null) {
                        repairKit.release();
                    }
                    AppMethodBeat.o(19018);
                    throw th;
                }
            }
            if (repairKit2 == null) {
                ab.i("MicroMsg.DBRecoveryTask", "No correct key found, assume #0");
                repairKit = new RepairKit(this.kJf, (byte[]) this.kJm.get(0), kJb, masterInfo2);
            } else {
                repairKit = repairKit2;
            }
            try {
                repairKit.setCallback(new Callback() {
                    private int EV = 0;
                    private int kJu = 0;
                    private boolean kJv = false;

                    public final int onProgress(String str, int i, Cursor cursor) {
                        AppMethodBeat.i(19002);
                        if (this.kJu == 0) {
                            if (str.equalsIgnoreCase(ShareConstants.WEB_DIALOG_PARAM_MESSAGE)) {
                                this.kJu = i;
                            } else {
                                AppMethodBeat.o(19002);
                                return 0;
                            }
                        } else if (this.kJu != i) {
                            if (!this.kJv) {
                                this.kJv = true;
                                a.a(a.this, new Integer[]{Integer.valueOf(3)});
                            }
                            AppMethodBeat.o(19002);
                            return 0;
                        }
                        int i2 = this.EV;
                        this.EV = i2 + 1;
                        if (i2 % 1000 == 0) {
                            a.b(a.this, new Integer[]{Integer.valueOf(2), Integer.valueOf(this.EV - 1), Integer.valueOf(a.this.kJr)});
                        }
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + 1;
                        AppMethodBeat.o(19002);
                        return 0;
                    }
                });
                int output = repairKit.output(this.kJc, 0, this.mCancellationSignal);
                if (output == 0) {
                    if (repairKit.isHeaderCorrupted() && repairKit.isDataCorrupted()) {
                        e2 = new RuntimeException("No data is successfully recovered.");
                        AppMethodBeat.o(19018);
                        throw e2;
                    }
                    ab.i("MicroMsg.DBRecoveryTask", "Repair succeeded.");
                } else if (output == 1) {
                    ab.i("MicroMsg.DBRecoveryTask", "Repair cancelled.");
                    this.mCancellationSignal.throwIfCanceled();
                } else {
                    e2 = new RuntimeException("Repair failed.");
                    AppMethodBeat.o(19018);
                    throw e2;
                }
                if (this.kJq && ((float) iArr[0]) / ((float) this.kJr) <= 1.5f) {
                    e.pXa.a(181, 181, 62, 63, this.kJr, iArr[0], true);
                }
                if (repairKit != null) {
                    repairKit.release();
                }
                AppMethodBeat.o(19018);
                return output;
            } catch (OperationCanceledException e6) {
                e = e6;
                repairKit2 = repairKit;
            } catch (RuntimeException e7) {
                e2 = e7;
                ab.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e2.getMessage());
                a(2, "Failed to repair database => sm: ".concat(String.valueOf(z)), e2);
                if (repairKit != null) {
                }
                AppMethodBeat.o(19018);
                return -1;
            }
        } catch (OperationCanceledException e8) {
        } catch (RuntimeException e9) {
            e2 = e9;
            repairKit = repairKit2;
            ab.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e2.getMessage());
            a(2, "Failed to repair database => sm: ".concat(String.valueOf(z)), e2);
            if (repairKit != null) {
            }
            AppMethodBeat.o(19018);
            return -1;
        } catch (Throwable th5) {
            th = th5;
            repairKit = repairKit2;
            if (repairKit != null) {
            }
            AppMethodBeat.o(19018);
            throw th;
        }
    }

    private int bhY() {
        Exception e;
        RecoverKit recoverKit;
        AppMethodBeat.i(19019);
        this.mCancellationSignal.throwIfCanceled();
        ab.i("MicroMsg.DBRecoveryTask", "Begin backup recovery.");
        RecoverKit recoverKit2 = null;
        for (String str : this.kJi) {
            try {
                RecoverKit recoverKit3 = new RecoverKit(this.kJc, str, (byte[]) this.kJl.get(0));
                try {
                    ab.i("MicroMsg.DBRecoveryTask", "Loaded backup data: ".concat(String.valueOf(str)));
                    recoverKit2 = recoverKit3;
                } catch (Exception e2) {
                    e = e2;
                    recoverKit = recoverKit3;
                    ab.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + e.getMessage());
                    recoverKit2 = recoverKit;
                }
            } catch (Exception e3) {
                e = e3;
                recoverKit = recoverKit2;
                ab.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + e.getMessage());
                recoverKit2 = recoverKit;
            }
        }
        if (recoverKit2 == null) {
            AppMethodBeat.o(19019);
            return -1;
        }
        try {
            int run = recoverKit2.run(false, this.mCancellationSignal);
            if (run == 0) {
                ab.i("MicroMsg.DBRecoveryTask", "Backup recovery succeeded.");
            } else if (run == 1) {
                ab.i("MicroMsg.DBRecoveryTask", "Backup recovery cancelled.");
                this.mCancellationSignal.throwIfCanceled();
            } else {
                ab.e("MicroMsg.DBRecoveryTask", "Backup recovery failed.");
            }
            recoverKit2.release();
            AppMethodBeat.o(19019);
            return run;
        } catch (OperationCanceledException e4) {
            AppMethodBeat.o(19019);
            throw e4;
        } catch (Exception e5) {
            ab.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e5.getMessage());
            a(4, "Failed to recover backup database", e5);
            recoverKit2.release();
            AppMethodBeat.o(19019);
            return -1;
        } catch (Throwable th) {
            recoverKit2.release();
            AppMethodBeat.o(19019);
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0222=Splitter:B:37:0x0222, B:54:0x0256=Splitter:B:54:0x0256} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02a0  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x024c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int bhZ() {
        OperationCanceledException e;
        Throwable th;
        Exception e2;
        AppMethodBeat.i(19020);
        if (this.kJe == null || this.kJe.isEmpty()) {
            AppMethodBeat.o(19020);
            return 0;
        }
        ab.i("MicroMsg.DBRecoveryTask", "Begin merging old database.");
        SQLiteDatabase openDatabase;
        Cursor rawQueryWithFactory;
        try {
            int longForQuery = (int) DatabaseUtils.longForQuery(this.kJc, "SELECT count(*) FROM message;", null);
            final long[] jArr = new long[]{DatabaseUtils.longForQuery(this.kJc, "SELECT max(msgId) FROM message;", null) + 1};
            if (jArr[0] > 1000000 && jArr[0] <= 10000000) {
                jArr[0] = 10000001;
            }
            final HashMap hashMap = new HashMap(Math.max(longForQuery + (longForQuery / 2), 10240));
            openDatabase = SQLiteDatabase.openDatabase(this.kJe, this.kJk, kJb, null, 1, new DatabaseErrorHandler() {
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                }
            }, 1);
            try {
                com.tencent.wcdb.Cursor rawQueryWithFactory2;
                a(openDatabase, "userinfo", 0, false, 0, null);
                this.kJc.beginTransaction();
                Object[] objArr = new Object[]{Integer.valueOf(8197), Integer.valueOf(3), ""};
                this.kJc.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                objArr[0] = Integer.valueOf(15);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                this.kJc.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                objArr[0] = Integer.valueOf(89);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "1";
                this.kJc.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                rawQueryWithFactory = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT id,type,value FROM userinfo WHERE id=?", new String[]{"2"}, "userinfo");
                try {
                    if (rawQueryWithFactory.moveToFirst()) {
                        objArr[0] = Integer.valueOf(rawQueryWithFactory.getInt(0));
                        objArr[1] = Integer.valueOf(rawQueryWithFactory.getInt(1));
                        objArr[2] = rawQueryWithFactory.getString(2);
                        this.kJc.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                    }
                    rawQueryWithFactory.close();
                    com.tencent.wcdb.Cursor rawQueryWithFactory3 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT id,type,value FROM userinfo WHERE id=?", new String[]{"9"}, "userinfo");
                    if (rawQueryWithFactory3.moveToFirst()) {
                        objArr[0] = Integer.valueOf(rawQueryWithFactory3.getInt(0));
                        objArr[1] = Integer.valueOf(rawQueryWithFactory3.getInt(1));
                        objArr[2] = rawQueryWithFactory3.getString(2);
                        this.kJc.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                    }
                    rawQueryWithFactory3.close();
                    this.kJc.setTransactionSuccessful();
                    this.kJc.endTransaction();
                    rawQueryWithFactory2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM message LIMIT 0;", null, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                } catch (OperationCanceledException e3) {
                    e = e3;
                    try {
                        ab.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
                        AppMethodBeat.o(19020);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                            rawQueryWithFactory.close();
                        }
                        if (this.kJc.inTransaction()) {
                            this.kJc.endTransaction();
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        AppMethodBeat.o(19020);
                        throw th;
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    ab.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + e2.getMessage());
                    a(5, "Message migration failed, ignorable: " + this.kJo, e2);
                    if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                        rawQueryWithFactory.close();
                    }
                    if (this.kJc.inTransaction()) {
                        this.kJc.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    AppMethodBeat.o(19020);
                    return -1;
                }
                Cursor rawQueryWithFactory4;
                try {
                    longForQuery = rawQueryWithFactory2.getColumnIndexOrThrow("msgId");
                    rawQueryWithFactory2.close();
                    a(openDatabase, ShareConstants.WEB_DIALOG_PARAM_MESSAGE, 4, true, 5, new d() {
                        public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
                            AppMethodBeat.i(19003);
                            long j = cursor.getLong(longForQuery);
                            long[] jArr = jArr;
                            long j2 = jArr[0];
                            jArr[0] = 1 + j2;
                            hashMap.put(Long.valueOf(j), Long.valueOf(j2));
                            sQLiteStatement.bindLong(longForQuery + 1, j2);
                            if (jArr[0] > 1000000 && jArr[0] <= 10000000) {
                                jArr[0] = 10000001;
                            }
                            AppMethodBeat.o(19003);
                            return true;
                        }
                    });
                    a(openDatabase, "rconversation", 5, true, 0, null);
                    rawQueryWithFactory2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM ImgInfo2 LIMIT 0;", null, "ImgInfo2");
                    longForQuery = rawQueryWithFactory2.getColumnIndexOrThrow("msglocalid");
                    rawQueryWithFactory2.close();
                    AnonymousClass4 anonymousClass4 = new d() {
                        public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
                            AppMethodBeat.i(19004);
                            Long l = (Long) hashMap.get(Long.valueOf(cursor.getLong(longForQuery)));
                            if (l != null) {
                                sQLiteStatement.bindLong(longForQuery + 1, l.longValue());
                            }
                            AppMethodBeat.o(19004);
                            return true;
                        }
                    };
                    a(openDatabase, "ImgInfo2", 4, true, 0, anonymousClass4);
                    rawQueryWithFactory4 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM videoinfo2 LIMIT 0;", null, "videoinfo2");
                    longForQuery = rawQueryWithFactory4.getColumnIndexOrThrow("msglocalid");
                    rawQueryWithFactory4.close();
                    AnonymousClass5 anonymousClass5 = new d() {
                        public final boolean a(Cursor cursor, SQLiteStatement sQLiteStatement) {
                            AppMethodBeat.i(19005);
                            Long l = (Long) hashMap.get(Long.valueOf(cursor.getLong(longForQuery)));
                            if (l != null) {
                                sQLiteStatement.bindLong(longForQuery + 1, l.longValue());
                            }
                            AppMethodBeat.o(19005);
                            return true;
                        }
                    };
                    a(openDatabase, "videoinfo2", 4, true, 0, anonymousClass5);
                    if (!(rawQueryWithFactory4 == null || rawQueryWithFactory4.isClosed())) {
                        rawQueryWithFactory4.close();
                    }
                    if (this.kJc.inTransaction()) {
                        this.kJc.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    AppMethodBeat.o(19020);
                    return 0;
                } catch (OperationCanceledException e5) {
                    e = e5;
                    rawQueryWithFactory = rawQueryWithFactory4;
                    ab.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
                    AppMethodBeat.o(19020);
                    throw e;
                } catch (Exception e6) {
                    e2 = e6;
                    rawQueryWithFactory = rawQueryWithFactory4;
                    ab.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + e2.getMessage());
                    a(5, "Message migration failed, ignorable: " + this.kJo, e2);
                    rawQueryWithFactory.close();
                    if (this.kJc.inTransaction()) {
                    }
                    if (openDatabase != null) {
                    }
                    AppMethodBeat.o(19020);
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    rawQueryWithFactory = rawQueryWithFactory4;
                    rawQueryWithFactory.close();
                    if (this.kJc.inTransaction()) {
                    }
                    if (openDatabase != null) {
                    }
                    AppMethodBeat.o(19020);
                    throw th;
                }
            } catch (OperationCanceledException e7) {
                e = e7;
                Object obj = null;
            } catch (Exception e8) {
                e2 = e8;
                rawQueryWithFactory = null;
                ab.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + e2.getMessage());
                a(5, "Message migration failed, ignorable: " + this.kJo, e2);
                rawQueryWithFactory.close();
                if (this.kJc.inTransaction()) {
                }
                if (openDatabase != null) {
                }
                AppMethodBeat.o(19020);
                return -1;
            } catch (Throwable th4) {
                th = th4;
                rawQueryWithFactory = null;
                rawQueryWithFactory.close();
                if (this.kJc.inTransaction()) {
                }
                if (openDatabase != null) {
                }
                AppMethodBeat.o(19020);
                throw th;
            }
        } catch (OperationCanceledException e9) {
            e = e9;
            rawQueryWithFactory = null;
            openDatabase = null;
            ab.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
            AppMethodBeat.o(19020);
            throw e;
        } catch (Exception e10) {
            e2 = e10;
            rawQueryWithFactory = null;
            openDatabase = null;
            ab.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + e2.getMessage());
            a(5, "Message migration failed, ignorable: " + this.kJo, e2);
            rawQueryWithFactory.close();
            if (this.kJc.inTransaction()) {
            }
            if (openDatabase != null) {
            }
            AppMethodBeat.o(19020);
            return -1;
        } catch (Throwable th5) {
            th = th5;
            rawQueryWithFactory = null;
            openDatabase = null;
            rawQueryWithFactory.close();
            if (this.kJc.inTransaction()) {
            }
            if (openDatabase != null) {
            }
            AppMethodBeat.o(19020);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0169  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(SQLiteDatabase sQLiteDatabase, String str, int i, boolean z, int i2, d dVar) {
        Throwable th;
        AppMethodBeat.i(19021);
        Cursor rawQueryWithFactory;
        SQLiteStatement compileStatement;
        try {
            String stringForQuery = DatabaseUtils.stringForQuery(sQLiteDatabase, "SELECT sql FROM sqlite_master WHERE name = ?", new String[]{str});
            if (stringForQuery == null || stringForQuery.isEmpty()) {
                SQLiteDoneException sQLiteDoneException = new SQLiteDoneException();
                AppMethodBeat.o(19021);
                throw sQLiteDoneException;
            }
            this.kJc.execSQL(stringForQuery.replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS "), null, this.mCancellationSignal);
            if (z) {
                int longForQuery = (int) DatabaseUtils.longForQuery(sQLiteDatabase, "SELECT count(*) FROM ".concat(String.valueOf(str)), null);
                rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM ".concat(String.valueOf(str)), null, str, this.mCancellationSignal);
                try {
                    int i3;
                    int i4;
                    String[] columnNames = rawQueryWithFactory.getColumnNames();
                    StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    stringBuilder.append("INSERT").append(CONFLICT_VALUES[i]).append(" INTO ").append(str).append(" (");
                    for (String append : columnNames) {
                        stringBuilder.append(append).append(',');
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    stringBuilder.append(" VALUES (");
                    for (i3 = 0; i3 < columnNames.length; i3++) {
                        stringBuilder.append("?,");
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    compileStatement = this.kJc.compileStatement(stringBuilder.toString());
                    i3 = 0;
                    try {
                        this.kJc.beginTransaction();
                        while (rawQueryWithFactory.moveToNext()) {
                            if (i3 % WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == 0 && i2 != 0) {
                                publishProgress(new Integer[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(longForQuery)});
                            }
                            compileStatement.clearBindings();
                            for (i4 = 0; i4 < columnNames.length; i4++) {
                                switch (rawQueryWithFactory.getType(i4)) {
                                    case 0:
                                        compileStatement.bindNull(i4 + 1);
                                        break;
                                    case 1:
                                        compileStatement.bindLong(i4 + 1, rawQueryWithFactory.getLong(i4));
                                        break;
                                    case 2:
                                        compileStatement.bindDouble(i4 + 1, rawQueryWithFactory.getDouble(i4));
                                        break;
                                    case 3:
                                        compileStatement.bindString(i4 + 1, rawQueryWithFactory.getString(i4));
                                        break;
                                    case 4:
                                        compileStatement.bindBlob(i4 + 1, rawQueryWithFactory.getBlob(i4));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (dVar != null) {
                                dVar.a(rawQueryWithFactory, compileStatement);
                            }
                            compileStatement.executeInsert(this.mCancellationSignal);
                            i3++;
                        }
                        this.kJc.setTransactionSuccessful();
                        if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                            rawQueryWithFactory.close();
                        }
                        if (this.kJc.inTransaction()) {
                            this.kJc.endTransaction();
                        }
                        if (compileStatement != null) {
                            compileStatement.close();
                        }
                        AppMethodBeat.o(19021);
                        return i3;
                    } catch (Throwable th2) {
                        th = th2;
                        rawQueryWithFactory.close();
                        if (this.kJc.inTransaction()) {
                        }
                        if (compileStatement != null) {
                        }
                        AppMethodBeat.o(19021);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    compileStatement = null;
                    if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                        rawQueryWithFactory.close();
                    }
                    if (this.kJc.inTransaction()) {
                        this.kJc.endTransaction();
                    }
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                    AppMethodBeat.o(19021);
                    throw th;
                }
            }
            if (this.kJc.inTransaction()) {
                this.kJc.endTransaction();
            }
            AppMethodBeat.o(19021);
            return 0;
        } catch (SQLiteDoneException e) {
            ab.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", str);
            if (this.kJc.inTransaction()) {
                this.kJc.endTransaction();
            }
            AppMethodBeat.o(19021);
            return -1;
        } catch (Throwable th4) {
            th = th4;
            compileStatement = null;
            rawQueryWithFactory = null;
        }
    }

    private static long If(String str) {
        AppMethodBeat.i(19022);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (!bVar.isDirectory()) {
            bVar = bVar.dMC();
        }
        do {
            long j;
            com.tencent.mm.vfs.FileSystemManager.d dMA = bVar.dMA();
            if (dMA.valid()) {
                com.tencent.mm.vfs.FileSystem.b tn = dMA.zZs.tn(dMA.path);
                j = tn == null ? 0 : tn.zYP;
            } else {
                j = 0;
            }
            if (j > 0) {
                AppMethodBeat.o(19022);
                return j;
            }
            bVar = bVar.dMC();
        } while (bVar != null);
        AppMethodBeat.o(19022);
        return 0;
    }

    private static void tM(int i) {
        AppMethodBeat.i(19023);
        e.pXa.a(181, (long) i, 1, true);
        AppMethodBeat.o(19023);
    }

    @SuppressLint({"DefaultLocale"})
    private static void a(int i, String str, Throwable th) {
        AppMethodBeat.i(19024);
        e.pXa.g("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[]{Integer.valueOf(i), str, new StringBuilder(IOUtils.LINE_SEPARATOR_UNIX).append(bo.l(th)).toString()}), null);
        AppMethodBeat.o(19024);
    }
}

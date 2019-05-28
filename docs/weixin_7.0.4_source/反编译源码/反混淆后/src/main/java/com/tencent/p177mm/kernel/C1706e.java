package com.tencent.p177mm.kernel;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1420l;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.p238a.C6610c;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.model.C1813aj;
import com.tencent.p177mm.model.C1842cf;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p213cd.C1356a;
import com.tencent.p177mm.p213cd.C6395f;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1363a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p213cd.C7480h.C1367e;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p603e.C4894a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5144y;
import com.tencent.p177mm.storage.C7574bs;
import com.tencent.p177mm.storage.C7576bx;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7622by;
import com.tencent.p177mm.vfs.FileSystemManager;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.view.C31128d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.e */
public final class C1706e {
    private static HashMap<Integer, C1366d> eaA;
    public String cachePath;
    public final C5144y eJH = C1706e.m3486Ro();
    private C1673e eJI;
    public C1712b eJJ = new C1712b();
    C1712b eJK = new C1712b();
    public String eJL;
    public String eJM;
    public C7480h eJN = null;
    public C7480h eJO = null;
    C7580z eJP;
    C7574bs eJQ;
    C7622by eJR;
    ConcurrentHashMap<Integer, String> eJS;
    boolean eJT = false;
    C1842cf eJU;
    ConcurrentHashMap<String, SharedPreferences> eJV = new ConcurrentHashMap();
    private long eJW = 0;
    private C7306ak eJX = null;
    private volatile Boolean eJY = null;
    private C1704a eJZ = new C1704a(this, (byte) 0);
    private long eKa = 0;

    /* renamed from: com.tencent.mm.kernel.e$5 */
    class C17035 implements FilenameFilter {
        C17035() {
        }

        public final boolean accept(File file, String str) {
            AppMethodBeat.m2504i(57945);
            boolean startsWith = str.startsWith("EnMicroMsg.dberr");
            AppMethodBeat.m2505o(57945);
            return startsWith;
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$a */
    class C1704a implements Runnable {
        private C1704a() {
        }

        /* synthetic */ C1704a(C1706e c1706e, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(57946);
            C1706e.this.mo5228RA();
            AppMethodBeat.m2505o(57946);
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$c */
    public static class C1705c {
        public boolean eKe = false;
        public int eKf = 0;
    }

    /* renamed from: com.tencent.mm.kernel.e$2 */
    class C17072 implements C1363a {
        C17072() {
        }

        /* renamed from: RF */
        public final void mo4747RF() {
            AppMethodBeat.m2504i(57940);
            if (C1706e.this.eJP != null) {
                C4990ab.m7416i("MMKernel.CoreStorage", "summer preCloseCallback userConfigStg: " + C1706e.this.eJP);
                C1706e.this.eJP.dsb();
                C1706e.this.eJP.mHandlerThread.quitSafely();
            }
            C1706e.this.eJJ.mo4747RF();
            AppMethodBeat.m2505o(57940);
        }

        /* renamed from: RG */
        public final void mo4748RG() {
            AppMethodBeat.m2504i(57941);
            C1706e.this.eJJ.mo4748RG();
            AppMethodBeat.m2505o(57941);
        }

        /* renamed from: RH */
        public final void mo4749RH() {
            AppMethodBeat.m2504i(57942);
            C1706e.this.eJJ.mo4749RH();
            AppMethodBeat.m2505o(57942);
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$3 */
    class C17083 implements C1367e {
        C17083() {
        }

        /* renamed from: RI */
        public final void mo4751RI() {
            AppMethodBeat.m2504i(57943);
            if (C1706e.this.eJR != null) {
                C1706e.this.eJR.fni.mo10108hY("TablesVersion", "delete from TablesVersion");
                AppMethodBeat.m2505o(57943);
                return;
            }
            C4990ab.m7412e("MMKernel.CoreStorage", "tablesVersionStorage is null");
            AppMethodBeat.m2505o(57943);
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$4 */
    class C17094 implements C4931a {
        C17094() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(57944);
            C1427q.m3050ku(str);
            AppMethodBeat.m2505o(57944);
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$6 */
    static class C17106 implements C1366d {
        C17106() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7580z.fnj;
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$7 */
    static class C17117 implements C1366d {
        C17117() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7622by.fnj;
        }
    }

    /* renamed from: com.tencent.mm.kernel.e$b */
    public static class C1712b extends C6454a<C1363a> implements C1363a {

        /* renamed from: com.tencent.mm.kernel.e$b$1 */
        class C17131 implements C1387a<C1363a> {
            C17131() {
            }

            /* renamed from: ax */
            public final /* synthetic */ void mo4769ax(Object obj) {
                AppMethodBeat.m2504i(57947);
                ((C1363a) obj).mo4747RF();
                AppMethodBeat.m2505o(57947);
            }
        }

        /* renamed from: com.tencent.mm.kernel.e$b$2 */
        class C17142 implements C1387a<C1363a> {
            C17142() {
            }

            /* renamed from: ax */
            public final /* synthetic */ void mo4769ax(Object obj) {
                AppMethodBeat.m2504i(57948);
                ((C1363a) obj).mo4748RG();
                AppMethodBeat.m2505o(57948);
            }
        }

        /* renamed from: com.tencent.mm.kernel.e$b$3 */
        class C17153 implements C1387a<C1363a> {
            C17153() {
            }

            /* renamed from: ax */
            public final /* synthetic */ void mo4769ax(Object obj) {
                AppMethodBeat.m2504i(57949);
                ((C1363a) obj).mo4749RH();
                AppMethodBeat.m2505o(57949);
            }
        }

        C1712b() {
        }

        /* renamed from: RF */
        public final void mo4747RF() {
            AppMethodBeat.m2504i(57950);
            mo14669a(new C17131());
            AppMethodBeat.m2505o(57950);
        }

        /* renamed from: RG */
        public final void mo4748RG() {
            AppMethodBeat.m2504i(57951);
            mo14669a(new C17142());
            AppMethodBeat.m2505o(57951);
        }

        /* renamed from: RH */
        public final void mo4749RH() {
            AppMethodBeat.m2504i(57952);
            mo14669a(new C17153());
            AppMethodBeat.m2505o(57952);
        }
    }

    public C1706e(C1673e c1673e) {
        AppMethodBeat.m2504i(57953);
        C1668a.eIM.mo5106a(this.eJH);
        String str = C5128ac.eSj + "alphahold.ini";
        C4990ab.m7417i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(C7243d.vxo), Boolean.valueOf(C7243d.vxr), str);
        if (C7243d.vxr) {
            String value = C4894a.getValue(str, "noneedhold");
            int i = C7243d.vxo;
            try {
                i = Integer.decode(C1760a.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                C4990ab.m7421w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(C7243d.vxr));
                C1668a.m3389QL();
                C4894a.m7286aB(str, "noneedhold", String.valueOf(i));
            }
        } else {
            C1173e.deleteFile(str);
        }
        this.eJL = C1706e.m3487Rx();
        this.eJI = c1673e;
        AppMethodBeat.m2505o(57953);
    }

    /* renamed from: Ro */
    private static C5144y m3486Ro() {
        AppMethodBeat.m2504i(57954);
        C4990ab.m7417i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", C5058f.aZm(), Integer.valueOf(C7243d.vxo));
        File file = new File(C5128ac.eSj);
        if (!file.exists()) {
            file.mkdirs();
        }
        C5144y c5144y = new C5144y(C5128ac.eSj + "systemInfo.cfg");
        String str = (String) c5144y.get(C31128d.MIC_PTU_ZIPAI_SAPPORO);
        if (str != null) {
            C1420l.m3008Lu().set(C31128d.MIC_PTU_ZIPAI_SAPPORO, str);
        }
        try {
            StatFs statFs = new StatFs(C1448h.getDataDirectory().getPath());
            C4990ab.m7417i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            C4990ab.m7413e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        AppMethodBeat.m2505o(57954);
        return c5144y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ba A:{SYNTHETIC, EDGE_INSN: B:56:0x01ba->B:50:0x01ba ?: BREAK  , EDGE_INSN: B:56:0x01ba->B:50:0x01ba ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019b A:{SYNTHETIC, Splitter:B:44:0x019b} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo5242a(C1813aj c1813aj) {
        AppMethodBeat.m2504i(57955);
        if (c1813aj == null) {
            C4990ab.m7412e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
            AppMethodBeat.m2505o(57955);
            return false;
        }
        int h = C5046bo.m7567h((Integer) this.eJP.get(14, null));
        int i = C7243d.vxo;
        C4990ab.m7410d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + h + ", cVer = " + i);
        List<C1812ai> dataTransferList = c1813aj.getDataTransferList();
        if (dataTransferList == null) {
            C4990ab.m7412e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
            AppMethodBeat.m2505o(57955);
            return false;
        }
        C1812ai c1812ai;
        if (C1947ae.gir > 0 && C1947ae.gis > 0) {
            C4990ab.m7420w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
        } else if (h == i) {
            C4990ab.m7416i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + h + ", cVer = " + i);
            AppMethodBeat.m2505o(57955);
            return false;
        } else {
            boolean z = false;
            for (C1812ai c1812ai2 : dataTransferList) {
                z = c1812ai2.mo5386kw(h);
                if (z) {
                    break;
                }
            }
            C4990ab.m7410d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = ".concat(String.valueOf(z)));
            if (!z) {
                AppMethodBeat.m2505o(57955);
                return false;
            }
        }
        C4990ab.m7410d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + dataTransferList.size());
        C4990ab.m7410d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
        long iV = this.eJN.mo15639iV(Thread.currentThread().getId());
        List it;
        try {
            it = dataTransferList.iterator();
            while (it.hasNext()) {
                c1812ai2 = (C1812ai) it.next();
                long currentTimeMillis = System.currentTimeMillis();
                c1812ai2.transfer(h);
                c1812ai2.flt = System.currentTimeMillis() - currentTimeMillis;
                C4990ab.m7410d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + c1812ai2.flt + ", tag = " + c1812ai2.getTag());
            }
            if (C1947ae.gir != 0) {
                i = C1947ae.gis;
                if (i != 0) {
                    while (true) {
                        h = i;
                        if (h < C1947ae.gir) {
                            break;
                        }
                        try {
                            it = (long) C1947ae.gis;
                            Thread.sleep(it);
                        } catch (InterruptedException e) {
                            it = "MMKernel.CoreStorage";
                            C4990ab.m7413e(it, "exception:%s", C5046bo.m7574l(e));
                        }
                        i = h + 1;
                    }
                }
            }
        } catch (Throwable th) {
            i = th;
            if (iV > it) {
                this.eJN.mo15640mB(iV);
            }
            AppMethodBeat.m2505o(57955);
        } finally {
            while (true) {
                AppMethodBeat.m2505o(57955);
            }
            while (true) {
                h = i;
                if (h < C1947ae.gir) {
                }
                i = h + 1;
            }
            if (iV > 0) {
            }
            AppMethodBeat.m2505o(57955);
            return true;
        }
        if (iV > 0) {
            this.eJN.mo15640mB(iV);
        }
        AppMethodBeat.m2505o(57955);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Rp */
    public final void mo5231Rp() {
        AppMethodBeat.m2504i(57956);
        this.eJP.set(14, Integer.valueOf(C7243d.vxo));
        AppMethodBeat.m2505o(57956);
    }

    /* renamed from: lI */
    private void m3492lI(String str) {
        AppMethodBeat.m2504i(57957);
        C4990ab.m7417i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", this.eJL, str, this.eJM, this.cachePath);
        if (!C5046bo.isNullOrNil(str)) {
            this.eJL = str;
            StringBuilder stringBuilder = new StringBuilder("mm");
            C1720g.m3537RQ();
            C1720g.m3534RN();
            String x = C1178g.m2591x(stringBuilder.append(C1668a.m3383QF()).toString().getBytes());
            this.eJM = this.eJL + x + "/";
            FileSystemManager dMy = FileSystemManager.dMy();
            dMy.ens().mo11627ir("account", x).mo11628ri(false);
            dMy.ent();
            C4990ab.m7416i("VFS.Debug", "SetEnv ${account} = " + x + " and broadcast.");
            mo5232Rq();
        }
        AppMethodBeat.m2505o(57957);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Rq */
    public final void mo5232Rq() {
        AppMethodBeat.m2504i(57958);
        C6610c.m10890Sa().mo5175lM(this.eJM);
        File file = new File(this.eJM + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
                AppMethodBeat.m2505o(57958);
                return;
            } catch (IOException e) {
                C4990ab.m7413e("MMKernel.CoreStorage", "exception:%s", C5046bo.m7574l(e));
            }
        }
        AppMethodBeat.m2505o(57958);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: lJ */
    public final void mo5246lJ(String str) {
        AppMethodBeat.m2504i(57959);
        File file = new File(str + "-recovery");
        if (file.isFile()) {
            C4990ab.m7416i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
            new File(str + ".ini").delete();
            File file2 = new File(str);
            file2.delete();
            if (!file.renameTo(file2)) {
                C4990ab.m7412e("MMKernel.CoreStorage", "Rename database file failed!");
            }
        }
        final String name = file.getName();
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.m2504i(57939);
                if (!str.startsWith(name) || str.equals(name)) {
                    AppMethodBeat.m2505o(57939);
                    return false;
                }
                AppMethodBeat.m2505o(57939);
                return true;
            }
        });
        if (listFiles != null) {
            for (File file3 : listFiles) {
                C4990ab.m7416i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + file3.getName());
                file3.delete();
            }
        }
        AppMethodBeat.m2505o(57959);
    }

    /* renamed from: a */
    public final boolean mo5241a(C6395f c6395f, HashMap<Integer, C1366d> hashMap) {
        AppMethodBeat.m2504i(57960);
        String str = "MMKernel.CoreStorage";
        String str2 = "createtables %d %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        objArr[1] = Boolean.FALSE;
        C4990ab.m7417i(str, str2, objArr);
        C1446a c1446a = new C1446a();
        if (hashMap != null && hashMap.size() > 0) {
            int i = 0;
            for (Entry entry : hashMap.entrySet()) {
                Integer num = (Integer) entry.getKey();
                C1366d c1366d = (C1366d) entry.getValue();
                Object obj = null;
                if (!this.eJT) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String hashCode : c1366d.mo4750Af()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                    String x = C1178g.m2591x(stringBuilder.toString().getBytes());
                    if (this.eJS != null) {
                        str = (String) this.eJS.get(num);
                        C4990ab.m7411d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", num, str, x);
                        if (str == null || !x.equals(str)) {
                            obj = x;
                        }
                    } else {
                        if (this.eJR != null) {
                            C7576bx c7576bx = null;
                            Cursor rawQuery = this.eJR.rawQuery("select * from TablesVersion where tableHash = ".concat(String.valueOf(num.intValue())), new String[0]);
                            if (rawQuery != null) {
                                if (rawQuery.moveToFirst()) {
                                    c7576bx = new C7576bx();
                                    c7576bx.mo8995d(rawQuery);
                                }
                                rawQuery.close();
                            }
                            if (c7576bx == null) {
                                obj = null;
                            } else {
                                obj = c7576bx.field_tableSQLMD5;
                            }
                            C4990ab.m7411d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", num, obj, x);
                            if (obj != null && x.equals(obj)) {
                            }
                        }
                        str = x;
                    }
                }
                c6395f.beginTransaction();
                int i2 = i;
                for (String str3 : c1366d.mo4750Af()) {
                    try {
                        c6395f.execSQL(str3);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = C1356a.ybj.matcher(str3);
                        if (matcher == null || !matcher.matches()) {
                            C4990ab.m7420w("MMKernel.CoreStorage", "CreateTable failed:[" + str3 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str3 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                c6395f.endTransaction();
                if (!(this.eJT || this.eJR == null || obj == null)) {
                    C7622by c7622by = this.eJR;
                    int intValue = num.intValue();
                    Assert.assertTrue(intValue != 0);
                    Assert.assertNotNull(obj);
                    C7576bx c7576bx2 = new C7576bx();
                    c7576bx2.field_tableHash = intValue;
                    c7576bx2.field_tableSQLMD5 = obj;
                    c7622by.fni.replace("TablesVersion", "tableHash", c7576bx2.mo10098Hl());
                    if (!(this.eJS == null || obj == null)) {
                        this.eJS.put(num, obj);
                    }
                }
                i = i2;
            }
            C4990ab.m7417i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(c1446a.mo4908Mr()), Long.valueOf(c1446a.mo4908Mr()), Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(57960);
        return true;
    }

    /* renamed from: Rr */
    public final boolean mo5233Rr() {
        AppMethodBeat.m2504i(57961);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        int h = C5046bo.m7567h((Integer) this.eJP.get(89, null));
        if (h != 0) {
            C4990ab.m7416i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(h)));
            AppMethodBeat.m2505o(57961);
            return false;
        }
        boolean z = C5046bo.nullAsNil((String) this.eJP.get(8195, null)).length() <= 0 || C5046bo.m7567h((Integer) this.eJP.get(15, null)) == 0;
        if (!z || mo5234Rs() == null) {
            this.eJP.set(89, Integer.valueOf(1));
            this.eJP.dsb();
            C4990ab.m7416i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(57961);
            return false;
        }
        C4990ab.m7416i("MMKernel.CoreStorage", "isDBCorrupted: true");
        AppMethodBeat.m2505o(57961);
        return true;
    }

    /* renamed from: Rs */
    public final String mo5234Rs() {
        AppMethodBeat.m2504i(57962);
        File file = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
        String absolutePath;
        if (file.isFile()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.m2505o(57962);
            return absolutePath;
        }
        file = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (file.isFile()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.m2505o(57962);
            return absolutePath;
        }
        String[] list = new File(this.cachePath).list(new C17035());
        if (list == null || list.length <= 0) {
            AppMethodBeat.m2505o(57962);
            return null;
        }
        String str = list[0];
        for (int i = 1; i < list.length; i++) {
            String str2 = list[i];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        absolutePath = this.cachePath + IOUtils.DIR_SEPARATOR_UNIX + str;
        AppMethodBeat.m2505o(57962);
        return absolutePath;
    }

    /* renamed from: jC */
    public final void mo5245jC(String str) {
        AppMethodBeat.m2504i(57963);
        if (this.eJO != null) {
            this.eJO.closeDB();
        }
        if (this.eJN != null) {
            this.eJN.mo5708jC(str);
        }
        this.eJI.onDataBaseClosed(this.eJN, this.eJO);
        this.eJT = false;
        AppMethodBeat.m2505o(57963);
    }

    /* renamed from: Rt */
    public final String mo5235Rt() {
        return this.cachePath;
    }

    public final String getAccPath() {
        return this.eJM;
    }

    /* renamed from: Ru */
    public final C7480h mo5236Ru() {
        return this.eJN;
    }

    /* renamed from: Rv */
    public final String mo5237Rv() {
        AppMethodBeat.m2504i(57964);
        String str = this.cachePath + "MicroMsg.db";
        AppMethodBeat.m2505o(57964);
        return str;
    }

    /* renamed from: Rw */
    public final String mo5238Rw() {
        AppMethodBeat.m2504i(57965);
        String str = this.cachePath + "EnMicroMsg.db";
        AppMethodBeat.m2505o(57965);
        return str;
    }

    /* renamed from: lK */
    public final SharedPreferences mo5247lK(String str) {
        AppMethodBeat.m2504i(57966);
        C1720g.m3537RQ();
        C1720g.m3534RN();
        int QF = C1668a.m3383QF();
        SharedPreferences sharedPreferences;
        if (QF == 0) {
            AppMethodBeat.m2505o(57966);
            return null;
        } else if (this.eJV.containsKey(str)) {
            sharedPreferences = (SharedPreferences) this.eJV.get(str);
            AppMethodBeat.m2505o(57966);
            return sharedPreferences;
        } else {
            try {
                String str2 = C4996ah.getContext().getFilesDir().getParent() + "/shared_prefs/";
                String str3 = C4996ah.doA() + str + QF + ".xml";
                String str4 = C4996ah.doA() + str + QF + ".xml.bak";
                File file = new File(str2 + str3);
                if (file.exists()) {
                    file.delete();
                }
                File file2 = new File(str2 + str4);
                if (file2.exists()) {
                    file2.delete();
                }
            } catch (Exception e) {
            }
            sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + str + C4995ag.m7428ck(QF + C4995ag.m7428ck(String.valueOf(QF / 2))), 0);
            this.eJV.put(str, sharedPreferences);
            AppMethodBeat.m2505o(57966);
            return sharedPreferences;
        }
    }

    /* renamed from: Rx */
    private static String m3487Rx() {
        AppMethodBeat.m2504i(57967);
        String str = C5128ac.eSj;
        File file = new File(C6457e.eSl);
        C4990ab.m7416i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + C6457e.eSl + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + C1445f.m3070Mn());
        if (file.exists() && C1445f.m3070Mn()) {
            if (C1706e.m3491cw(C6457e.eSn)) {
                str = C6457e.eSn;
            }
            file = new File(C6457e.euR);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(C6457e.euS);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(C6457e.euT);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(C6457e.euU);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(C6457e.euS + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    C4990ab.m7413e("MMKernel.CoreStorage", "exception:%s", C5046bo.m7574l(e));
                }
            }
            C1706e.m3491cw(C6457e.euQ);
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        C4990ab.m7416i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(57967);
        return str;
    }

    /* renamed from: cw */
    private static final boolean m3491cw(String str) {
        AppMethodBeat.m2504i(57968);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            AppMethodBeat.m2505o(57968);
            return false;
        }
        File file = new File(str);
        C4990ab.m7417i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            C4990ab.m7416i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            AppMethodBeat.m2505o(57968);
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            C4990ab.m7416i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            AppMethodBeat.m2505o(57968);
            return false;
        }
        String str2 = "/";
        C4990ab.m7416i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!C5046bo.isNullOrNil(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    C4990ab.m7417i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    AppMethodBeat.m2505o(57968);
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    C4990ab.m7417i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    AppMethodBeat.m2505o(57968);
                    return false;
                }
            }
        }
        C4990ab.m7416i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        AppMethodBeat.m2505o(57968);
        return true;
    }

    /* renamed from: Ry */
    public final C7580z mo5239Ry() {
        AppMethodBeat.m2504i(57969);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7580z c7580z = this.eJP;
        AppMethodBeat.m2505o(57969);
        return c7580z;
    }

    /* renamed from: Rz */
    public final C7574bs mo5240Rz() {
        AppMethodBeat.m2504i(57970);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C7574bs c7574bs = this.eJQ;
        AppMethodBeat.m2505o(57970);
        return c7574bs;
    }

    /* renamed from: RA */
    public final void mo5228RA() {
        AppMethodBeat.m2504i(57971);
        this.eJY = Boolean.valueOf(isSDCardAvailable());
        AppMethodBeat.m2505o(57971);
    }

    /* renamed from: RB */
    public final boolean mo5229RB() {
        AppMethodBeat.m2504i(57972);
        if (this.eJY == null) {
            this.eJY = Boolean.valueOf(isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.eKa;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                C7305d.xDH.mo10143al(this.eJZ);
                C7305d.xDH.mo10144o(this.eJZ, 1000);
                this.eKa = System.currentTimeMillis();
            }
        }
        boolean booleanValue = this.eJY.booleanValue();
        AppMethodBeat.m2505o(57972);
        return booleanValue;
    }

    public final boolean isSDCardAvailable() {
        AppMethodBeat.m2504i(57973);
        boolean startsWith = this.eJL.startsWith(C6457e.eSl);
        long anU = C5046bo.anU();
        long j = anU - this.eJW;
        if (startsWith) {
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY() && j > 0 && j < FaceGestureDetGLThread.BRIGHTNESS_DURATION && new File(this.eJL).exists()) {
                AppMethodBeat.m2505o(57973);
                return true;
            }
        }
        this.eJW = anU;
        boolean Mn = C1445f.m3070Mn();
        r8 = new Object[6];
        C1720g.m3537RQ();
        C1720g.m3534RN();
        r8[1] = C1183p.getString(C1668a.m3383QF());
        r8[2] = Long.valueOf(j);
        r8[3] = this.eJL;
        r8[4] = C6457e.eSl;
        r8[5] = Boolean.valueOf(C1720g.m3534RN().mo5161QY());
        C4990ab.m7417i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", r8);
        if (!Mn) {
            AppMethodBeat.m2505o(57973);
            return false;
        } else if (startsWith) {
            AppMethodBeat.m2505o(57973);
            return true;
        } else {
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY()) {
                C4990ab.m7416i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
                mo5230RC();
            }
            AppMethodBeat.m2505o(57973);
            return true;
        }
    }

    /* JADX WARNING: Missing block: B:26:0x00eb, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(57974);
     */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: RC */
    public final void mo5230RC() {
        AppMethodBeat.m2504i(57974);
        C1720g.m3537RQ();
        synchronized (C1720g.m3534RN().eIL) {
            try {
                String Rx = C1706e.m3487Rx();
                C4990ab.m7417i("MMKernel.CoreStorage", "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]", Integer.valueOf(C1668a.m3383QF()), this.eJL, Rx, Boolean.valueOf(C1720g.m3534RN().mo5161QY()));
                if (!C5046bo.isNullOrNil(Rx)) {
                    if (Rx.equalsIgnoreCase(this.eJL)) {
                        C4990ab.m7416i("MMKernel.CoreStorage", "testSdcardWritable done ret:" + C1706e.m3484RD());
                        try {
                            C4990ab.m7416i("MMKernel.CoreStorage", "testSdcardReadable done ret:" + C1706e.m3485RE());
                        } catch (Exception e) {
                            C4990ab.m7420w("MMKernel.CoreStorage", "testSdcardReadable Exception e: " + e.getMessage());
                        }
                        AppMethodBeat.m2505o(57974);
                        return;
                    }
                    m3492lI(Rx);
                    C6610c.m10890Sa().eKY.mo5174RV();
                    C4990ab.m7417i("MMKernel.CoreStorage", "remout isSDCardAvail :[%b] done", Boolean.valueOf(C1445f.m3070Mn()));
                }
            } catch (Exception e2) {
                C4990ab.m7420w("MMKernel.CoreStorage", "testSdcardWritable Exception e: " + e2.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(57974);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0124 A:{SYNTHETIC, Splitter:B:29:0x0124} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: RD */
    private static boolean m3484RD() {
        boolean canWrite;
        Exception e;
        Throwable th;
        boolean z = false;
        AppMethodBeat.m2504i(57975);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = C6457e.eSl.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            C4990ab.m7420w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            canWrite = false;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                boolean delete = file.delete();
                try {
                    fileOutputStream.close();
                    z = delete;
                } catch (IOException e3) {
                    C4990ab.m7413e("MMKernel.CoreStorage", "exception:%s", C5046bo.m7574l(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            try {
                C4990ab.m7420w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        C4990ab.m7413e("MMKernel.CoreStorage", "exception:%s", C5046bo.m7574l(e6));
                    }
                }
                C4990ab.m7416i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + C6457e.eSl + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                AppMethodBeat.m2505o(57975);
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(57975);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e62) {
                    C4990ab.m7413e("MMKernel.CoreStorage", "exception:%s", C5046bo.m7574l(e62));
                }
            }
            AppMethodBeat.m2505o(57975);
            throw th;
        }
        C4990ab.m7416i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + C6457e.eSl + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        AppMethodBeat.m2505o(57975);
        return z;
    }

    /* renamed from: RE */
    private static boolean m3485RE() {
        boolean canRead;
        AppMethodBeat.m2504i(57976);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = C6457e.eSl.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            C4990ab.m7420w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(C6457e.eSn);
        boolean exists = file.exists();
        if (exists) {
            C4990ab.m7416i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        C4990ab.m7416i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + C6457e.eSl + " CConstants.DATAROOT_SDCARD_PATH: " + C6457e.eSn + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        AppMethodBeat.m2505o(57976);
        return exists;
    }

    static {
        AppMethodBeat.m2504i(57978);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new C17106());
        eaA.put(Integer.valueOf("TablesVersion".hashCode()), new C17117());
        AppMethodBeat.m2505o(57978);
    }

    /* renamed from: Jx */
    static HashMap<Integer, C1366d> m3483Jx() {
        AppMethodBeat.m2504i(57977);
        HashMap hashMap = new HashMap();
        hashMap.putAll(eaA);
        AppMethodBeat.m2505o(57977);
        return hashMap;
    }
}

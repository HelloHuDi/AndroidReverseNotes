package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.p;
import com.tencent.mm.cd.h;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.cf;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
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

public final class e {
    private static HashMap<Integer, d> eaA;
    public String cachePath;
    public final y eJH = Ro();
    private com.tencent.mm.kernel.api.e eJI;
    public b eJJ = new b();
    b eJK = new b();
    public String eJL;
    public String eJM;
    public h eJN = null;
    public h eJO = null;
    z eJP;
    bs eJQ;
    by eJR;
    ConcurrentHashMap<Integer, String> eJS;
    boolean eJT = false;
    cf eJU;
    ConcurrentHashMap<String, SharedPreferences> eJV = new ConcurrentHashMap();
    private long eJW = 0;
    private ak eJX = null;
    private volatile Boolean eJY = null;
    private a eJZ = new a(this, (byte) 0);
    private long eKa = 0;

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(57946);
            e.this.RA();
            AppMethodBeat.o(57946);
        }
    }

    public static class c {
        public boolean eKe = false;
        public int eKf = 0;
    }

    public static class b extends com.tencent.mm.ci.a<com.tencent.mm.cd.h.a> implements com.tencent.mm.cd.h.a {
        b() {
        }

        public final void RF() {
            AppMethodBeat.i(57950);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.cd.h.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(57947);
                    ((com.tencent.mm.cd.h.a) obj).RF();
                    AppMethodBeat.o(57947);
                }
            });
            AppMethodBeat.o(57950);
        }

        public final void RG() {
            AppMethodBeat.i(57951);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.cd.h.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(57948);
                    ((com.tencent.mm.cd.h.a) obj).RG();
                    AppMethodBeat.o(57948);
                }
            });
            AppMethodBeat.o(57951);
        }

        public final void RH() {
            AppMethodBeat.i(57952);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.cd.h.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(57949);
                    ((com.tencent.mm.cd.h.a) obj).RH();
                    AppMethodBeat.o(57949);
                }
            });
            AppMethodBeat.o(57952);
        }
    }

    public e(com.tencent.mm.kernel.api.e eVar) {
        AppMethodBeat.i(57953);
        a.eIM.a(this.eJH);
        String str = ac.eSj + "alphahold.ini";
        ab.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(com.tencent.mm.protocal.d.vxo), Boolean.valueOf(com.tencent.mm.protocal.d.vxr), str);
        if (com.tencent.mm.protocal.d.vxr) {
            String value = com.tencent.mm.sdk.e.a.getValue(str, "noneedhold");
            int i = com.tencent.mm.protocal.d.vxo;
            try {
                i = Integer.decode(com.tencent.mm.loader.j.a.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                ab.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.vxr));
                a.QL();
                com.tencent.mm.sdk.e.a.aB(str, "noneedhold", String.valueOf(i));
            }
        } else {
            com.tencent.mm.a.e.deleteFile(str);
        }
        this.eJL = Rx();
        this.eJI = eVar;
        AppMethodBeat.o(57953);
    }

    private static y Ro() {
        AppMethodBeat.i(57954);
        ab.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", f.aZm(), Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        File file = new File(ac.eSj);
        if (!file.exists()) {
            file.mkdirs();
        }
        y yVar = new y(ac.eSj + "systemInfo.cfg");
        String str = (String) yVar.get(com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO);
        if (str != null) {
            l.Lu().set(com.tencent.view.d.MIC_PTU_ZIPAI_SAPPORO, str);
        }
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            ab.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            ab.e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        AppMethodBeat.o(57954);
        return yVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ba A:{SYNTHETIC, EDGE_INSN: B:56:0x01ba->B:50:0x01ba ?: BREAK  , EDGE_INSN: B:56:0x01ba->B:50:0x01ba ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019b A:{SYNTHETIC, Splitter:B:44:0x019b} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(aj ajVar) {
        AppMethodBeat.i(57955);
        if (ajVar == null) {
            ab.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
            AppMethodBeat.o(57955);
            return false;
        }
        int h = bo.h((Integer) this.eJP.get(14, null));
        int i = com.tencent.mm.protocal.d.vxo;
        ab.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + h + ", cVer = " + i);
        List<ai> dataTransferList = ajVar.getDataTransferList();
        if (dataTransferList == null) {
            ab.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
            AppMethodBeat.o(57955);
            return false;
        }
        ai aiVar;
        if (ae.gir > 0 && ae.gis > 0) {
            ab.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
        } else if (h == i) {
            ab.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + h + ", cVer = " + i);
            AppMethodBeat.o(57955);
            return false;
        } else {
            boolean z = false;
            for (ai aiVar2 : dataTransferList) {
                z = aiVar2.kw(h);
                if (z) {
                    break;
                }
            }
            ab.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = ".concat(String.valueOf(z)));
            if (!z) {
                AppMethodBeat.o(57955);
                return false;
            }
        }
        ab.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + dataTransferList.size());
        ab.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
        long iV = this.eJN.iV(Thread.currentThread().getId());
        List it;
        try {
            it = dataTransferList.iterator();
            while (it.hasNext()) {
                aiVar2 = (ai) it.next();
                long currentTimeMillis = System.currentTimeMillis();
                aiVar2.transfer(h);
                aiVar2.flt = System.currentTimeMillis() - currentTimeMillis;
                ab.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + aiVar2.flt + ", tag = " + aiVar2.getTag());
            }
            if (ae.gir != 0) {
                i = ae.gis;
                if (i != 0) {
                    while (true) {
                        h = i;
                        if (h < ae.gir) {
                            break;
                        }
                        try {
                            it = (long) ae.gis;
                            Thread.sleep(it);
                        } catch (InterruptedException e) {
                            it = "MMKernel.CoreStorage";
                            ab.e(it, "exception:%s", bo.l(e));
                        }
                        i = h + 1;
                    }
                }
            }
        } catch (Throwable th) {
            i = th;
            if (iV > it) {
                this.eJN.mB(iV);
            }
            AppMethodBeat.o(57955);
        } finally {
            while (true) {
                AppMethodBeat.o(57955);
            }
            while (true) {
                h = i;
                if (h < ae.gir) {
                }
                i = h + 1;
            }
            if (iV > 0) {
            }
            AppMethodBeat.o(57955);
            return true;
        }
        if (iV > 0) {
            this.eJN.mB(iV);
        }
        AppMethodBeat.o(57955);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void Rp() {
        AppMethodBeat.i(57956);
        this.eJP.set(14, Integer.valueOf(com.tencent.mm.protocal.d.vxo));
        AppMethodBeat.o(57956);
    }

    private void lI(String str) {
        AppMethodBeat.i(57957);
        ab.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", this.eJL, str, this.eJM, this.cachePath);
        if (!bo.isNullOrNil(str)) {
            this.eJL = str;
            StringBuilder stringBuilder = new StringBuilder("mm");
            g.RQ();
            g.RN();
            String x = g.x(stringBuilder.append(a.QF()).toString().getBytes());
            this.eJM = this.eJL + x + "/";
            FileSystemManager dMy = FileSystemManager.dMy();
            dMy.ens().ir("account", x).ri(false);
            dMy.ent();
            ab.i("VFS.Debug", "SetEnv ${account} = " + x + " and broadcast.");
            Rq();
        }
        AppMethodBeat.o(57957);
    }

    /* Access modifiers changed, original: final */
    public final void Rq() {
        AppMethodBeat.i(57958);
        com.tencent.mm.kernel.a.c.Sa().lM(this.eJM);
        File file = new File(this.eJM + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
                AppMethodBeat.o(57958);
                return;
            } catch (IOException e) {
                ab.e("MMKernel.CoreStorage", "exception:%s", bo.l(e));
            }
        }
        AppMethodBeat.o(57958);
    }

    /* Access modifiers changed, original: final */
    public final void lJ(String str) {
        AppMethodBeat.i(57959);
        File file = new File(str + "-recovery");
        if (file.isFile()) {
            ab.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
            new File(str + ".ini").delete();
            File file2 = new File(str);
            file2.delete();
            if (!file.renameTo(file2)) {
                ab.e("MMKernel.CoreStorage", "Rename database file failed!");
            }
        }
        final String name = file.getName();
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.i(57939);
                if (!str.startsWith(name) || str.equals(name)) {
                    AppMethodBeat.o(57939);
                    return false;
                }
                AppMethodBeat.o(57939);
                return true;
            }
        });
        if (listFiles != null) {
            for (File file3 : listFiles) {
                ab.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + file3.getName());
                file3.delete();
            }
        }
        AppMethodBeat.o(57959);
    }

    public final boolean a(com.tencent.mm.cd.f fVar, HashMap<Integer, d> hashMap) {
        AppMethodBeat.i(57960);
        String str = "MMKernel.CoreStorage";
        String str2 = "createtables %d %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        objArr[1] = Boolean.FALSE;
        ab.i(str, str2, objArr);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (hashMap != null && hashMap.size() > 0) {
            int i = 0;
            for (Entry entry : hashMap.entrySet()) {
                Integer num = (Integer) entry.getKey();
                d dVar = (d) entry.getValue();
                Object obj = null;
                if (!this.eJT) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String hashCode : dVar.Af()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                    String x = g.x(stringBuilder.toString().getBytes());
                    if (this.eJS != null) {
                        str = (String) this.eJS.get(num);
                        ab.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", num, str, x);
                        if (str == null || !x.equals(str)) {
                            obj = x;
                        }
                    } else {
                        if (this.eJR != null) {
                            bx bxVar = null;
                            Cursor rawQuery = this.eJR.rawQuery("select * from TablesVersion where tableHash = ".concat(String.valueOf(num.intValue())), new String[0]);
                            if (rawQuery != null) {
                                if (rawQuery.moveToFirst()) {
                                    bxVar = new bx();
                                    bxVar.d(rawQuery);
                                }
                                rawQuery.close();
                            }
                            if (bxVar == null) {
                                obj = null;
                            } else {
                                obj = bxVar.field_tableSQLMD5;
                            }
                            ab.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", num, obj, x);
                            if (obj != null && x.equals(obj)) {
                            }
                        }
                        str = x;
                    }
                }
                fVar.beginTransaction();
                int i2 = i;
                for (String str3 : dVar.Af()) {
                    try {
                        fVar.execSQL(str3);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = com.tencent.mm.cd.a.ybj.matcher(str3);
                        if (matcher == null || !matcher.matches()) {
                            ab.w("MMKernel.CoreStorage", "CreateTable failed:[" + str3 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str3 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                fVar.endTransaction();
                if (!(this.eJT || this.eJR == null || obj == null)) {
                    by byVar = this.eJR;
                    int intValue = num.intValue();
                    Assert.assertTrue(intValue != 0);
                    Assert.assertNotNull(obj);
                    bx bxVar2 = new bx();
                    bxVar2.field_tableHash = intValue;
                    bxVar2.field_tableSQLMD5 = obj;
                    byVar.fni.replace("TablesVersion", "tableHash", bxVar2.Hl());
                    if (!(this.eJS == null || obj == null)) {
                        this.eJS.put(num, obj);
                    }
                }
                i = i2;
            }
            ab.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(aVar.Mr()), Long.valueOf(aVar.Mr()), Integer.valueOf(i));
        }
        AppMethodBeat.o(57960);
        return true;
    }

    public final boolean Rr() {
        AppMethodBeat.i(57961);
        g.RQ();
        g.RN().QU();
        int h = bo.h((Integer) this.eJP.get(89, null));
        if (h != 0) {
            ab.i("MMKernel.CoreStorage", "isDBCorrupted: false, recoveryState: ".concat(String.valueOf(h)));
            AppMethodBeat.o(57961);
            return false;
        }
        boolean z = bo.nullAsNil((String) this.eJP.get(8195, null)).length() <= 0 || bo.h((Integer) this.eJP.get(15, null)) == 0;
        if (!z || Rs() == null) {
            this.eJP.set(89, Integer.valueOf(1));
            this.eJP.dsb();
            ab.i("MMKernel.CoreStorage", "isDBCorrupted: false, needInit: ".concat(String.valueOf(z)));
            AppMethodBeat.o(57961);
            return false;
        }
        ab.i("MMKernel.CoreStorage", "isDBCorrupted: true");
        AppMethodBeat.o(57961);
        return true;
    }

    public final String Rs() {
        AppMethodBeat.i(57962);
        File file = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
        String absolutePath;
        if (file.isFile()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(57962);
            return absolutePath;
        }
        file = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (file.isFile()) {
            absolutePath = file.getAbsolutePath();
            AppMethodBeat.o(57962);
            return absolutePath;
        }
        String[] list = new File(this.cachePath).list(new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.i(57945);
                boolean startsWith = str.startsWith("EnMicroMsg.dberr");
                AppMethodBeat.o(57945);
                return startsWith;
            }
        });
        if (list == null || list.length <= 0) {
            AppMethodBeat.o(57962);
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
        AppMethodBeat.o(57962);
        return absolutePath;
    }

    public final void jC(String str) {
        AppMethodBeat.i(57963);
        if (this.eJO != null) {
            this.eJO.closeDB();
        }
        if (this.eJN != null) {
            this.eJN.jC(str);
        }
        this.eJI.onDataBaseClosed(this.eJN, this.eJO);
        this.eJT = false;
        AppMethodBeat.o(57963);
    }

    public final String Rt() {
        return this.cachePath;
    }

    public final String getAccPath() {
        return this.eJM;
    }

    public final h Ru() {
        return this.eJN;
    }

    public final String Rv() {
        AppMethodBeat.i(57964);
        String str = this.cachePath + "MicroMsg.db";
        AppMethodBeat.o(57964);
        return str;
    }

    public final String Rw() {
        AppMethodBeat.i(57965);
        String str = this.cachePath + "EnMicroMsg.db";
        AppMethodBeat.o(57965);
        return str;
    }

    public final SharedPreferences lK(String str) {
        AppMethodBeat.i(57966);
        g.RQ();
        g.RN();
        int QF = a.QF();
        SharedPreferences sharedPreferences;
        if (QF == 0) {
            AppMethodBeat.o(57966);
            return null;
        } else if (this.eJV.containsKey(str)) {
            sharedPreferences = (SharedPreferences) this.eJV.get(str);
            AppMethodBeat.o(57966);
            return sharedPreferences;
        } else {
            try {
                String str2 = ah.getContext().getFilesDir().getParent() + "/shared_prefs/";
                String str3 = ah.doA() + str + QF + ".xml";
                String str4 = ah.doA() + str + QF + ".xml.bak";
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
            sharedPreferences = ah.getContext().getSharedPreferences(ah.doA() + str + ag.ck(QF + ag.ck(String.valueOf(QF / 2))), 0);
            this.eJV.put(str, sharedPreferences);
            AppMethodBeat.o(57966);
            return sharedPreferences;
        }
    }

    private static String Rx() {
        AppMethodBeat.i(57967);
        String str = ac.eSj;
        File file = new File(com.tencent.mm.compatible.util.e.eSl);
        ab.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.eSl + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.Mn());
        if (file.exists() && com.tencent.mm.compatible.util.f.Mn()) {
            if (cw(com.tencent.mm.compatible.util.e.eSn)) {
                str = com.tencent.mm.compatible.util.e.eSn;
            }
            file = new File(com.tencent.mm.compatible.util.e.euR);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.euS);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.euT);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.euU);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.euS + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    ab.e("MMKernel.CoreStorage", "exception:%s", bo.l(e));
                }
            }
            cw(com.tencent.mm.compatible.util.e.euQ);
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ab.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: ".concat(String.valueOf(str)));
        AppMethodBeat.o(57967);
        return str;
    }

    private static final boolean cw(String str) {
        AppMethodBeat.i(57968);
        if (bo.isNullOrNil(str)) {
            ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            AppMethodBeat.o(57968);
            return false;
        }
        File file = new File(str);
        ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            ab.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            AppMethodBeat.o(57968);
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            AppMethodBeat.o(57968);
            return false;
        }
        String str2 = "/";
        ab.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!bo.isNullOrNil(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    ab.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    AppMethodBeat.o(57968);
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    ab.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    AppMethodBeat.o(57968);
                    return false;
                }
            }
        }
        ab.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        AppMethodBeat.o(57968);
        return true;
    }

    public final z Ry() {
        AppMethodBeat.i(57969);
        g.RQ();
        g.RN().QU();
        z zVar = this.eJP;
        AppMethodBeat.o(57969);
        return zVar;
    }

    public final bs Rz() {
        AppMethodBeat.i(57970);
        g.RQ();
        g.RN().QU();
        bs bsVar = this.eJQ;
        AppMethodBeat.o(57970);
        return bsVar;
    }

    public final void RA() {
        AppMethodBeat.i(57971);
        this.eJY = Boolean.valueOf(isSDCardAvailable());
        AppMethodBeat.o(57971);
    }

    public final boolean RB() {
        AppMethodBeat.i(57972);
        if (this.eJY == null) {
            this.eJY = Boolean.valueOf(isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.eKa;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                com.tencent.mm.sdk.g.d.xDH.al(this.eJZ);
                com.tencent.mm.sdk.g.d.xDH.o(this.eJZ, 1000);
                this.eKa = System.currentTimeMillis();
            }
        }
        boolean booleanValue = this.eJY.booleanValue();
        AppMethodBeat.o(57972);
        return booleanValue;
    }

    public final boolean isSDCardAvailable() {
        AppMethodBeat.i(57973);
        boolean startsWith = this.eJL.startsWith(com.tencent.mm.compatible.util.e.eSl);
        long anU = bo.anU();
        long j = anU - this.eJW;
        if (startsWith) {
            g.RQ();
            if (g.RN().QY() && j > 0 && j < FaceGestureDetGLThread.BRIGHTNESS_DURATION && new File(this.eJL).exists()) {
                AppMethodBeat.o(57973);
                return true;
            }
        }
        this.eJW = anU;
        boolean Mn = com.tencent.mm.compatible.util.f.Mn();
        r8 = new Object[6];
        g.RQ();
        g.RN();
        r8[1] = p.getString(a.QF());
        r8[2] = Long.valueOf(j);
        r8[3] = this.eJL;
        r8[4] = com.tencent.mm.compatible.util.e.eSl;
        r8[5] = Boolean.valueOf(g.RN().QY());
        ab.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", r8);
        if (!Mn) {
            AppMethodBeat.o(57973);
            return false;
        } else if (startsWith) {
            AppMethodBeat.o(57973);
            return true;
        } else {
            g.RQ();
            if (g.RN().QY()) {
                ab.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
                RC();
            }
            AppMethodBeat.o(57973);
            return true;
        }
    }

    /* JADX WARNING: Missing block: B:26:0x00eb, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(57974);
     */
    /* JADX WARNING: Missing block: B:28:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void RC() {
        AppMethodBeat.i(57974);
        g.RQ();
        synchronized (g.RN().eIL) {
            try {
                String Rx = Rx();
                ab.i("MMKernel.CoreStorage", "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]", Integer.valueOf(a.QF()), this.eJL, Rx, Boolean.valueOf(g.RN().QY()));
                if (!bo.isNullOrNil(Rx)) {
                    if (Rx.equalsIgnoreCase(this.eJL)) {
                        ab.i("MMKernel.CoreStorage", "testSdcardWritable done ret:" + RD());
                        try {
                            ab.i("MMKernel.CoreStorage", "testSdcardReadable done ret:" + RE());
                        } catch (Exception e) {
                            ab.w("MMKernel.CoreStorage", "testSdcardReadable Exception e: " + e.getMessage());
                        }
                        AppMethodBeat.o(57974);
                        return;
                    }
                    lI(Rx);
                    com.tencent.mm.kernel.a.c.Sa().eKY.RV();
                    ab.i("MMKernel.CoreStorage", "remout isSDCardAvail :[%b] done", Boolean.valueOf(com.tencent.mm.compatible.util.f.Mn()));
                }
            } catch (Exception e2) {
                ab.w("MMKernel.CoreStorage", "testSdcardWritable Exception e: " + e2.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.o(57974);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0124 A:{SYNTHETIC, Splitter:B:29:0x0124} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean RD() {
        boolean canWrite;
        Exception e;
        Throwable th;
        boolean z = false;
        AppMethodBeat.i(57975);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.eSl.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            ab.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
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
                    ab.e("MMKernel.CoreStorage", "exception:%s", bo.l(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            try {
                ab.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        ab.e("MMKernel.CoreStorage", "exception:%s", bo.l(e6));
                    }
                }
                ab.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.eSl + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                AppMethodBeat.o(57975);
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(57975);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e62) {
                    ab.e("MMKernel.CoreStorage", "exception:%s", bo.l(e62));
                }
            }
            AppMethodBeat.o(57975);
            throw th;
        }
        ab.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.eSl + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        AppMethodBeat.o(57975);
        return z;
    }

    private static boolean RE() {
        boolean canRead;
        AppMethodBeat.i(57976);
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.eSl.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            ab.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(com.tencent.mm.compatible.util.e.eSn);
        boolean exists = file.exists();
        if (exists) {
            ab.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        ab.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.eSl + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.eSn + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        AppMethodBeat.o(57976);
        return exists;
    }

    static {
        AppMethodBeat.i(57978);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return z.fnj;
            }
        });
        eaA.put(Integer.valueOf("TablesVersion".hashCode()), new d() {
            public final String[] Af() {
                return by.fnj;
            }
        });
        AppMethodBeat.o(57978);
    }

    static HashMap<Integer, d> Jx() {
        AppMethodBeat.i(57977);
        HashMap hashMap = new HashMap();
        hashMap.putAll(eaA);
        AppMethodBeat.o(57977);
        return hashMap;
    }
}

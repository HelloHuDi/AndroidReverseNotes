package com.tencent.mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.b.a.r;
import com.tencent.mm.g.c.eb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.plugin.scanner.a.n;
import com.tencent.mm.plugin.scanner.a.o;
import com.tencent.mm.plugin.scanner.a.q;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.plugin.u.a.b;
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e implements f, at {
    private static HashMap<Integer, d> eaA;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, d> jZD = new HashMap();
    public String eJM;
    private a jZF;
    public b pYI = new b();
    private k pYJ = new k();
    private o pYK = new o();
    private n pYL = new n();
    public p pYM = new p();
    public com.tencent.mm.plugin.scanner.util.n pYN = new com.tencent.mm.plugin.scanner.util.n();
    private com.tencent.mm.plugin.scanner.b.a pYO;
    private com.tencent.mm.plugin.scanner.b.b pYP;
    private HashMap<Integer, q> pYQ = new HashMap();
    private HashMap<Integer, r> pYR = new HashMap();
    private HashMap<Integer, Long> pYS = new HashMap();
    private com.tencent.mm.plugin.scanner.util.n.b pYT = new com.tencent.mm.plugin.scanner.util.n.b() {
        public final void b(int i, Bitmap bitmap) {
            AppMethodBeat.i(80774);
            if (e.this.pYQ.containsKey(Integer.valueOf(i))) {
                if (e.this.pYR.containsKey(Integer.valueOf(i)) && e.this.pYS.containsKey(Integer.valueOf(i))) {
                    ((r) e.this.pYR.get(Integer.valueOf(i))).cXa = System.currentTimeMillis() - ((Long) e.this.pYS.get(Integer.valueOf(i))).longValue();
                    ((r) e.this.pYR.get(Integer.valueOf(i))).ajK();
                    e.this.pYR.remove(Integer.valueOf(i));
                    e.this.pYS.remove(Integer.valueOf(i));
                    ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(e.this.pYR.size()), Integer.valueOf(e.this.pYS.size()));
                }
                if (g.RK()) {
                    e.cgy();
                    String Wb = e.Wb("jpg");
                    try {
                        com.tencent.mm.sdk.platformtools.d.a(bitmap, 80, CompressFormat.JPEG, Wb, false);
                        com.tencent.mm.plugin.scanner.a.p pVar = new com.tencent.mm.plugin.scanner.a.p();
                        q qVar = (q) e.this.pYQ.get(Integer.valueOf(i));
                        pVar.field_originMD5 = ag.ck(qVar.fWz + com.tencent.mm.vfs.e.ata(qVar.fWz));
                        pVar.field_resultFile = Wb;
                        pVar.field_fromLang = qVar.cMc;
                        pVar.field_toLang = qVar.cMd;
                        ab.i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", Integer.valueOf(i), Wb);
                        e.cgy().cgD().b((c) pVar);
                        pv pvVar = new pv();
                        pvVar.cMa.ctE = i;
                        pvVar.cMa.ctn = true;
                        pvVar.cMa.cMb = Wb;
                        pvVar.cMa.cMc = qVar.cMc;
                        pvVar.cMa.cMd = qVar.cMd;
                        com.tencent.mm.sdk.b.a.xxA.m(pvVar);
                        e.this.pYQ.remove(Integer.valueOf(i));
                        AppMethodBeat.o(80774);
                        return;
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", e, "save translate result file error", new Object[0]);
                        e.a(e.this, i);
                    }
                } else {
                    AppMethodBeat.o(80774);
                    return;
                }
            }
            AppMethodBeat.o(80774);
        }
    };
    private com.tencent.mm.sdk.b.c<ao> pYU = new com.tencent.mm.sdk.b.c<ao>() {
        {
            AppMethodBeat.i(80776);
            this.xxI = ao.class.getName().hashCode();
            AppMethodBeat.o(80776);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(80778);
            ao aoVar = (ao) bVar;
            if (aoVar.ctD.scene == 1 && e.this.pYQ.containsKey(Integer.valueOf(aoVar.ctD.ctE))) {
                ab.i("MicroMsg.scanner.SubCoreScanner", "cancel translate sessionId %d", Integer.valueOf(aoVar.ctD.ctE));
                e.this.pYQ.remove(Integer.valueOf(aoVar.ctD.ctE));
                if (e.this.pYR.containsKey(Integer.valueOf(aoVar.ctD.ctE)) && e.this.pYS.containsKey(Integer.valueOf(aoVar.ctD.ctE))) {
                    ((r) e.this.pYR.get(Integer.valueOf(aoVar.ctD.ctE))).cWX = 2;
                    ((r) e.this.pYR.get(Integer.valueOf(aoVar.ctD.ctE))).cXa = System.currentTimeMillis() - ((Long) e.this.pYS.get(Integer.valueOf(aoVar.ctD.ctE))).longValue();
                    ((r) e.this.pYR.get(Integer.valueOf(aoVar.ctD.ctE))).ajK();
                    e.this.pYR.remove(Integer.valueOf(aoVar.ctD.ctE));
                    e.this.pYS.remove(Integer.valueOf(aoVar.ctD.ctE));
                    ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(e.this.pYR.size()), Integer.valueOf(e.this.pYS.size()));
                }
                AppMethodBeat.o(80778);
                return true;
            }
            AppMethodBeat.o(80778);
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c<pu> pYV = new com.tencent.mm.sdk.b.c<pu>() {
        {
            AppMethodBeat.i(138453);
            this.xxI = pu.class.getName().hashCode();
            AppMethodBeat.o(138453);
        }

        private boolean a(pu puVar) {
            AppMethodBeat.i(138454);
            if (puVar.cLZ.scene == 1 && !bo.isNullOrNil(puVar.cLZ.filePath)) {
                try {
                    ab.i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", puVar.cLZ.filePath, Integer.valueOf(puVar.cLZ.ctE));
                    eb Wf = e.cgy().cgD().Wf(ag.ck(puVar.cLZ.filePath + com.tencent.mm.vfs.e.ata(puVar.cLZ.filePath)));
                    if (Wf != null) {
                        ab.i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
                        String str = Wf.field_resultFile;
                        if (com.tencent.mm.sdk.platformtools.d.decodeFile(str, new Options()) != null) {
                            pv pvVar = new pv();
                            pvVar.cMa.ctE = puVar.cLZ.ctE;
                            pvVar.cMa.ctn = true;
                            pvVar.cMa.cMb = str;
                            pvVar.cMa.cMc = Wf.field_fromLang;
                            pvVar.cMa.cMd = Wf.field_toLang;
                            com.tencent.mm.sdk.b.a.xxA.m(pvVar);
                            e.this.pYQ.remove(Integer.valueOf(puVar.cLZ.ctE));
                            AppMethodBeat.o(138454);
                            return true;
                        }
                        ab.w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
                    }
                    final r rVar = new r();
                    rVar.cWV = 4;
                    e.this.pYR.put(Integer.valueOf(puVar.cLZ.ctE), rVar);
                    q qVar = new q();
                    qVar.fWz = puVar.cLZ.filePath;
                    qVar.qal = puVar.cLZ.filePath;
                    final int orientationInDegree = Exif.fromFile(puVar.cLZ.filePath).getOrientationInDegree();
                    ab.i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", Integer.valueOf(orientationInDegree));
                    String str2 = puVar.cLZ.filePath;
                    final String Wr = p.Wr(puVar.cLZ.filePath);
                    if (orientationInDegree != 0) {
                        Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(puVar.cLZ.filePath, new Options());
                        if (decodeFile != null) {
                            decodeFile = com.tencent.mm.sdk.platformtools.d.b(decodeFile, (float) orientationInDegree);
                            e.cgy();
                            str2 = e.Wc("jpg");
                            com.tencent.mm.sdk.platformtools.d.a(decodeFile, 80, CompressFormat.JPEG, str2, false);
                            qVar.qal = str2;
                        }
                    }
                    e.this.pYQ.put(Integer.valueOf(puVar.cLZ.ctE), qVar);
                    final long currentTimeMillis = System.currentTimeMillis();
                    e.this.pYS.put(Integer.valueOf(puVar.cLZ.ctE), Long.valueOf(currentTimeMillis));
                    final pu puVar2 = puVar;
                    e.cgy().pYM.a(Wr, str2, com.tencent.mm.i.a.MediaType_IMAGE, new p.a() {
                        public final void a(String str, p.b bVar) {
                            AppMethodBeat.i(138452);
                            if (!bo.isNullOrNil(str) && str.equals(Wr)) {
                                rVar.cWY = System.currentTimeMillis() - currentTimeMillis;
                                ab.i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", Long.valueOf(rVar.cWY));
                                switch (bVar.errCode) {
                                    case -21009:
                                    case -21000:
                                        rVar.cWX = 3;
                                        rVar.cXa = System.currentTimeMillis() - currentTimeMillis;
                                        rVar.ajK();
                                        e.this.pYR.remove(Integer.valueOf(puVar2.cLZ.ctE));
                                        e.this.pYS.remove(Integer.valueOf(puVar2.cLZ.ctE));
                                        ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(e.this.pYR.size()), Integer.valueOf(e.this.pYS.size()));
                                        e.a(e.this, puVar2.cLZ.ctE);
                                        break;
                                    case 0:
                                        if (!bo.Q(bVar.fileId, bVar.aeskey)) {
                                            ab.i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", bVar.fileId);
                                            g.Rg().a(new com.tencent.mm.plugin.scanner.a.e(puVar2.cLZ.ctE, com.tencent.mm.a.e.cs(str2), bVar.fileId, bVar.aeskey), 0);
                                            break;
                                        }
                                        rVar.cWX = 3;
                                        rVar.cXa = System.currentTimeMillis() - currentTimeMillis;
                                        rVar.ajK();
                                        e.this.pYR.remove(Integer.valueOf(puVar2.cLZ.ctE));
                                        e.this.pYS.remove(Integer.valueOf(puVar2.cLZ.ctE));
                                        ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(e.this.pYR.size()), Integer.valueOf(e.this.pYS.size()));
                                        e.a(e.this, puVar2.cLZ.ctE);
                                        break;
                                }
                                if (orientationInDegree != 0) {
                                    ab.i("delete tmp path %s", str2);
                                    com.tencent.mm.vfs.e.deleteFile(str2);
                                }
                            }
                            AppMethodBeat.o(138452);
                        }
                    });
                    AppMethodBeat.o(138454);
                    return true;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", e, "", new Object[0]);
                    e.a(e.this, puVar.cLZ.ctE);
                }
            }
            AppMethodBeat.o(138454);
            return false;
        }
    };
    private com.tencent.mm.plugin.scanner.a.b pYW = new com.tencent.mm.plugin.scanner.a.b();

    public e() {
        AppMethodBeat.i(80781);
        AppMethodBeat.o(80781);
    }

    static /* synthetic */ void a(e eVar, int i) {
        AppMethodBeat.i(138458);
        eVar.BS(i);
        AppMethodBeat.o(138458);
    }

    private void BS(int i) {
        AppMethodBeat.i(80782);
        pv pvVar = new pv();
        pvVar.cMa.ctE = i;
        pvVar.cMa.ctn = false;
        com.tencent.mm.sdk.b.a.xxA.m(pvVar);
        this.pYQ.remove(Integer.valueOf(i));
        AppMethodBeat.o(80782);
    }

    static {
        AppMethodBeat.i(80798);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.scanner.b.a.fnj;
            }
        });
        eaA.put(Integer.valueOf("scan_translation_result_table".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.scanner.b.b.fnj;
            }
        });
        AppMethodBeat.o(80798);
    }

    public static synchronized e cgy() {
        e eVar;
        synchronized (e.class) {
            AppMethodBeat.i(80783);
            eVar = (e) com.tencent.mm.model.q.Y(e.class);
            AppMethodBeat.o(80783);
        }
        return eVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(80784);
        com.tencent.mm.sdk.b.a.xxA.d(this.pYJ);
        com.tencent.mm.sdk.b.a.xxA.d(this.pYK.qah);
        com.tencent.mm.sdk.b.a.xxA.d(this.pYK.qai);
        com.tencent.mm.sdk.b.a.xxA.d(this.pYL);
        com.tencent.mm.sdk.b.a.xxA.d(this.pYV);
        com.tencent.mm.sdk.b.a.xxA.d(this.pYU);
        g.Rg().b((int) com.tencent.view.d.MIC_PTU_WU, (f) this);
        com.tencent.mm.plugin.scanner.a.b bVar = this.pYW;
        com.tencent.mm.sdk.b.a.xxA.d(bVar.pZy);
        com.tencent.mm.sdk.b.a.xxA.d(bVar.pZz);
        bVar.cgE();
        b bVar2 = this.pYI;
        bVar2.fGz.clear();
        bVar2.ce.clear();
        bVar2.pAo.clear();
        if (this.jZF != null) {
            this.jZF.mJ(hashCode());
            this.jZF = null;
        }
        this.eJM = "";
        AppMethodBeat.o(80784);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(80785);
        this.jZF = t.a(hashCode(), g.RP().cachePath + "CommonOneMicroMsg.db", jZD, false);
        com.tencent.mm.plugin.scanner.a.b bVar = this.pYW;
        com.tencent.mm.sdk.b.a.xxA.c(bVar.pZy);
        com.tencent.mm.sdk.b.a.xxA.c(bVar.pZz);
        com.tencent.mm.sdk.b.a.xxA.c(this.pYJ);
        com.tencent.mm.sdk.b.a.xxA.c(this.pYK.qah);
        com.tencent.mm.sdk.b.a.xxA.c(this.pYK.qai);
        com.tencent.mm.sdk.b.a.xxA.b(this.pYL);
        com.tencent.mm.sdk.b.a.xxA.b(this.pYV);
        com.tencent.mm.sdk.b.a.xxA.b(this.pYU);
        g.Rg().a((int) com.tencent.view.d.MIC_PTU_WU, (f) this);
        String value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("NewOCRTranslationRedDot");
        ab.i("MicroMsg.scanner.SubCoreScanner", "redDotStr %s", value);
        if (!bo.isNullOrNil(value)) {
            Map z2 = br.z(value, "Id");
            if (z2.containsKey(".Id")) {
                int i = bo.getInt((String) z2.get(".Id"), 0);
                int i2 = g.RP().Ry().getInt(ac.a.USERINFO_TRANSLATION_RED_DOT_ID_INT_SYNC, 0);
                if (!(i == 0 || i2 == i)) {
                    g.RP().Ry().set(ac.a.USERINFO_TRANSLATION_RED_DOT_ID_INT_SYNC, Integer.valueOf(i));
                    com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, true);
                }
            }
        }
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(138456);
                if (!g.RK()) {
                    AppMethodBeat.o(138456);
                } else if (bo.isNullOrNil(e.this.eJM)) {
                    ab.e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                    AppMethodBeat.o(138456);
                } else {
                    bo.o(e.this.eJM + "image/scan/img", "scanbook", 604800000);
                    AppMethodBeat.o(138456);
                }
            }

            public final String toString() {
                AppMethodBeat.i(138457);
                String str = super.toString() + "|onAccountPostReset";
                AppMethodBeat.o(138457);
                return str;
            }
        }, "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
        AppMethodBeat.o(80785);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(80786);
        ab.d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + g.RP().eJM);
        String str = g.RP().eJM;
        ab.d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(str)));
        this.eJM = str;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "image/scan/img");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "image/scan/music");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(cgz());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        cgy();
        com.tencent.mm.vfs.e.ate(cgA());
        cgy();
        com.tencent.mm.vfs.e.ate(cgB());
        AppMethodBeat.o(80786);
    }

    public final String fQ(String str, String str2) {
        AppMethodBeat.i(80787);
        String str3;
        if (!g.RK() || bo.isNullOrNil(str)) {
            str3 = "";
            AppMethodBeat.o(80787);
            return str3;
        }
        str3 = String.format("%s/scanbook%s_%s", new Object[]{this.eJM + "image/scan/img", str2, com.tencent.mm.a.g.x(str.getBytes())});
        AppMethodBeat.o(80787);
        return str3;
    }

    private static String cgz() {
        AppMethodBeat.i(80788);
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        String stringBuilder2 = stringBuilder.append(g.RP().eJM).append("scanner/").toString();
        AppMethodBeat.o(80788);
        return stringBuilder2;
    }

    public static String cgA() {
        AppMethodBeat.i(80789);
        String str = cgz() + "scan_camera/";
        AppMethodBeat.o(80789);
        return str;
    }

    private static String cgB() {
        AppMethodBeat.i(80790);
        String str = cgz() + "scan_result/";
        AppMethodBeat.o(80790);
        return str;
    }

    public static String Wb(String str) {
        AppMethodBeat.i(80791);
        String str2 = cgB() + String.format("%s_%d.%s", new Object[]{"translation", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.o(80791);
        return str2;
    }

    public static String Wc(String str) {
        AppMethodBeat.i(80792);
        String str2 = cgA() + String.format("%s_%d.%s", new Object[]{"tmp", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.o(80792);
        return str2;
    }

    public static String Wd(String str) {
        AppMethodBeat.i(80793);
        String format = String.format("%s.%s", new Object[]{cgA() + "scan_translation_bg", str});
        AppMethodBeat.o(80793);
        return format;
    }

    public final com.tencent.mm.plugin.scanner.b.a cgC() {
        AppMethodBeat.i(80794);
        g.RN().QU();
        if (this.pYO == null) {
            this.pYO = new com.tencent.mm.plugin.scanner.b.a(g.RP().eJN);
        }
        com.tencent.mm.plugin.scanner.b.a aVar = this.pYO;
        AppMethodBeat.o(80794);
        return aVar;
    }

    public final com.tencent.mm.plugin.scanner.b.b cgD() {
        AppMethodBeat.i(80795);
        g.RN().QU();
        if (this.pYP == null) {
            this.pYP = new com.tencent.mm.plugin.scanner.b.b(g.RP().eJN);
        }
        com.tencent.mm.plugin.scanner.b.b bVar = this.pYP;
        AppMethodBeat.o(80795);
        return bVar;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(80796);
        ab.i("MicroMsg.scanner.SubCoreScanner", "onSceneEnd errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (mVar.getType() == com.tencent.view.d.MIC_PTU_WU) {
            int i3 = ((com.tencent.mm.plugin.scanner.a.e) mVar).ctE;
            if (i == 0 && i2 == 0) {
                List list = ((com.tencent.mm.plugin.scanner.a.e) mVar).pZB;
                if (list != null) {
                    ab.i("MicroMsg.scanner.SubCoreScanner", "session %d, angle %f, translationInfos length %d", Integer.valueOf(i3), Float.valueOf(((com.tencent.mm.plugin.scanner.a.e) mVar).angle), Integer.valueOf(list.size()));
                    if (this.pYR.containsKey(Integer.valueOf(i3))) {
                        ((r) this.pYR.get(Integer.valueOf(i3))).cWZ = System.currentTimeMillis() - ((com.tencent.mm.plugin.scanner.a.e) mVar).pZC;
                    }
                    if (list.size() <= 0 || !this.pYQ.containsKey(Integer.valueOf(i3))) {
                        if (this.pYR.containsKey(Integer.valueOf(i3)) && this.pYS.containsKey(Integer.valueOf(i3))) {
                            ((r) this.pYR.get(Integer.valueOf(i3))).cXa = System.currentTimeMillis() - ((Long) this.pYS.get(Integer.valueOf(i3))).longValue();
                        }
                        BS(i3);
                    } else {
                        q qVar = (q) this.pYQ.get(Integer.valueOf(i3));
                        qVar.cMc = ((bef) ((com.tencent.mm.plugin.scanner.a.e) mVar).ehh.fsH.fsP).pZE;
                        qVar.cMd = ((com.tencent.mm.plugin.scanner.a.e) mVar).cgF();
                        if (this.pYR.containsKey(Integer.valueOf(i3))) {
                            ((r) this.pYR.get(Integer.valueOf(i3))).cWX = 1;
                        }
                        com.tencent.mm.plugin.scanner.util.n nVar = cgy().pYN;
                        float f = ((com.tencent.mm.plugin.scanner.a.e) mVar).angle;
                        String str2 = qVar.qal;
                        com.tencent.mm.plugin.scanner.util.n.b bVar = this.pYT;
                        if (!(i3 == 0 || list == null || list.size() <= 0 || bVar == null)) {
                            Bitmap decodeFile = com.tencent.mm.sdk.platformtools.d.decodeFile(str2, new Options());
                            if (decodeFile == null) {
                                bVar.b(i3, null);
                                AppMethodBeat.o(80796);
                                return;
                            }
                            if (!(nVar.qiA == 0 || i3 == nVar.qiA)) {
                                ab.i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", Integer.valueOf(nVar.qiA), Integer.valueOf(i3));
                                nVar.cim();
                            }
                            nVar.qiA = i3;
                            nVar.qiB = bVar;
                            nVar.qiC = new com.tencent.mm.plugin.scanner.util.n.a(i3, list, f, decodeFile);
                            nVar.qiC.u(new Void[0]);
                        }
                        AppMethodBeat.o(80796);
                        return;
                    }
                }
                AppMethodBeat.o(80796);
                return;
            }
            if (this.pYR.containsKey(Integer.valueOf(i3)) && this.pYS.containsKey(Integer.valueOf(i3))) {
                ((r) this.pYR.get(Integer.valueOf(i3))).cXa = System.currentTimeMillis() - ((Long) this.pYS.get(Integer.valueOf(i3))).longValue();
                ((r) this.pYR.get(Integer.valueOf(i3))).cWX = 5;
                ((r) this.pYR.get(Integer.valueOf(i3))).ajK();
                this.pYR.remove(Integer.valueOf(i3));
                this.pYS.remove(Integer.valueOf(i3));
                ab.i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(this.pYR.size()), Integer.valueOf(this.pYS.size()));
            }
            BS(i3);
        }
        AppMethodBeat.o(80796);
    }
}

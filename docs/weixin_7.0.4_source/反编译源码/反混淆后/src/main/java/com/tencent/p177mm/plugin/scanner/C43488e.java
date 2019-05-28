package com.tencent.p177mm.plugin.scanner;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26084ao;
import com.tencent.p177mm.p230g.p231a.C32618pu;
import com.tencent.p177mm.p230g.p231a.C32619pv;
import com.tencent.p177mm.p230g.p232b.p233a.C1600r;
import com.tencent.p177mm.p230g.p711c.C9529eb;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.platformtools.C1952t;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.p543u.p544a.C35336b;
import com.tencent.p177mm.plugin.scanner.p1018b.C13121a;
import com.tencent.p177mm.plugin.scanner.p1018b.C13122b;
import com.tencent.p177mm.plugin.scanner.p740a.C21674b;
import com.tencent.p177mm.plugin.scanner.p740a.C21679e;
import com.tencent.p177mm.plugin.scanner.p740a.C21681k;
import com.tencent.p177mm.plugin.scanner.p740a.C28890n;
import com.tencent.p177mm.plugin.scanner.p740a.C39623o;
import com.tencent.p177mm.plugin.scanner.p740a.C39624q;
import com.tencent.p177mm.plugin.scanner.p740a.C46181p;
import com.tencent.p177mm.plugin.scanner.util.C43497p;
import com.tencent.p177mm.plugin.scanner.util.C43497p.C39642a;
import com.tencent.p177mm.plugin.scanner.util.C43497p.C43496b;
import com.tencent.p177mm.plugin.scanner.util.C46190n;
import com.tencent.p177mm.plugin.scanner.util.C46190n.C24823a;
import com.tencent.p177mm.plugin.scanner.util.C46190n.C34843b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.bef;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.view.C31128d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.e */
public class C43488e implements C1202f, C1816at {
    private static HashMap<Integer, C1366d> eaA;
    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Integer, C1366d> jZD = new HashMap();
    public String eJM;
    private C1953a jZF;
    public C35336b pYI = new C35336b();
    private C21681k pYJ = new C21681k();
    private C39623o pYK = new C39623o();
    private C28890n pYL = new C28890n();
    public C43497p pYM = new C43497p();
    public C46190n pYN = new C46190n();
    private C13121a pYO;
    private C13122b pYP;
    private HashMap<Integer, C39624q> pYQ = new HashMap();
    private HashMap<Integer, C1600r> pYR = new HashMap();
    private HashMap<Integer, Long> pYS = new HashMap();
    private C34843b pYT = new C434891();
    private C4884c<C26084ao> pYU = new C396272();
    private C4884c<C32618pu> pYV = new C348343();
    private C21674b pYW = new C21674b();

    /* renamed from: com.tencent.mm.plugin.scanner.e$4 */
    class C131254 implements Runnable {
        C131254() {
        }

        public final void run() {
            AppMethodBeat.m2504i(138456);
            if (!C1720g.m3531RK()) {
                AppMethodBeat.m2505o(138456);
            } else if (C5046bo.isNullOrNil(C43488e.this.eJM)) {
                C4990ab.m7412e("MicroMsg.scanner.SubCoreScanner", "accPath == null in onAccountPostReset");
                AppMethodBeat.m2505o(138456);
            } else {
                C5046bo.m7583o(C43488e.this.eJM + "image/scan/img", "scanbook", 604800000);
                AppMethodBeat.m2505o(138456);
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(138457);
            String str = super.toString() + "|onAccountPostReset";
            AppMethodBeat.m2505o(138457);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.e$5 */
    static class C131265 implements C1366d {
        C131265() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C13121a.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.e$6 */
    static class C288936 implements C1366d {
        C288936() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C13122b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.e$3 */
    class C348343 extends C4884c<C32618pu> {
        C348343() {
            AppMethodBeat.m2504i(138453);
            this.xxI = C32618pu.class.getName().hashCode();
            AppMethodBeat.m2505o(138453);
        }

        /* renamed from: a */
        private boolean m57201a(C32618pu c32618pu) {
            AppMethodBeat.m2504i(138454);
            if (c32618pu.cLZ.scene == 1 && !C5046bo.isNullOrNil(c32618pu.cLZ.filePath)) {
                try {
                    C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "request to translate img %s, sessionId %d", c32618pu.cLZ.filePath, Integer.valueOf(c32618pu.cLZ.ctE));
                    C9529eb Wf = C43488e.cgy().cgD().mo25148Wf(C4995ag.m7428ck(c32618pu.cLZ.filePath + C5730e.ata(c32618pu.cLZ.filePath)));
                    if (Wf != null) {
                        C4990ab.m7416i("MicroMsg.scanner.SubCoreScanner", "already has translation result");
                        String str = Wf.field_resultFile;
                        if (C5056d.decodeFile(str, new Options()) != null) {
                            C32619pv c32619pv = new C32619pv();
                            c32619pv.cMa.ctE = c32618pu.cLZ.ctE;
                            c32619pv.cMa.ctn = true;
                            c32619pv.cMa.cMb = str;
                            c32619pv.cMa.cMc = Wf.field_fromLang;
                            c32619pv.cMa.cMd = Wf.field_toLang;
                            C4879a.xxA.mo10055m(c32619pv);
                            C43488e.this.pYQ.remove(Integer.valueOf(c32618pu.cLZ.ctE));
                            AppMethodBeat.m2505o(138454);
                            return true;
                        }
                        C4990ab.m7420w("MicroMsg.scanner.SubCoreScanner", "can not find old translation result!");
                    }
                    final C1600r c1600r = new C1600r();
                    c1600r.cWV = 4;
                    C43488e.this.pYR.put(Integer.valueOf(c32618pu.cLZ.ctE), c1600r);
                    C39624q c39624q = new C39624q();
                    c39624q.fWz = c32618pu.cLZ.filePath;
                    c39624q.qal = c32618pu.cLZ.filePath;
                    final int orientationInDegree = Exif.fromFile(c32618pu.cLZ.filePath).getOrientationInDegree();
                    C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "original img degree %s", Integer.valueOf(orientationInDegree));
                    String str2 = c32618pu.cLZ.filePath;
                    final String Wr = C43497p.m77717Wr(c32618pu.cLZ.filePath);
                    if (orientationInDegree != 0) {
                        Bitmap decodeFile = C5056d.decodeFile(c32618pu.cLZ.filePath, new Options());
                        if (decodeFile != null) {
                            decodeFile = C5056d.m7648b(decodeFile, (float) orientationInDegree);
                            C43488e.cgy();
                            str2 = C43488e.m77694Wc("jpg");
                            C5056d.m7625a(decodeFile, 80, CompressFormat.JPEG, str2, false);
                            c39624q.qal = str2;
                        }
                    }
                    C43488e.this.pYQ.put(Integer.valueOf(c32618pu.cLZ.ctE), c39624q);
                    final long currentTimeMillis = System.currentTimeMillis();
                    C43488e.this.pYS.put(Integer.valueOf(c32618pu.cLZ.ctE), Long.valueOf(currentTimeMillis));
                    final C32618pu c32618pu2 = c32618pu;
                    C43488e.cgy().pYM.mo69045a(Wr, str2, C42129a.MediaType_IMAGE, new C39642a() {
                        /* renamed from: a */
                        public final void mo25164a(String str, C43496b c43496b) {
                            AppMethodBeat.m2504i(138452);
                            if (!C5046bo.isNullOrNil(str) && str.equals(Wr)) {
                                c1600r.cWY = System.currentTimeMillis() - currentTimeMillis;
                                C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "upload img cost %d", Long.valueOf(c1600r.cWY));
                                switch (c43496b.errCode) {
                                    case -21009:
                                    case -21000:
                                        c1600r.cWX = 3;
                                        c1600r.cXa = System.currentTimeMillis() - currentTimeMillis;
                                        c1600r.ajK();
                                        C43488e.this.pYR.remove(Integer.valueOf(c32618pu2.cLZ.ctE));
                                        C43488e.this.pYS.remove(Integer.valueOf(c32618pu2.cLZ.ctE));
                                        C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(C43488e.this.pYR.size()), Integer.valueOf(C43488e.this.pYS.size()));
                                        C43488e.m77697a(C43488e.this, c32618pu2.cLZ.ctE);
                                        break;
                                    case 0:
                                        if (!C5046bo.m7510Q(c43496b.fileId, c43496b.aeskey)) {
                                            C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "upload img success, fileId %s", c43496b.fileId);
                                            C1720g.m3540Rg().mo14541a(new C21679e(c32618pu2.cLZ.ctE, C1173e.m2560cs(str2), c43496b.fileId, c43496b.aeskey), 0);
                                            break;
                                        }
                                        c1600r.cWX = 3;
                                        c1600r.cXa = System.currentTimeMillis() - currentTimeMillis;
                                        c1600r.ajK();
                                        C43488e.this.pYR.remove(Integer.valueOf(c32618pu2.cLZ.ctE));
                                        C43488e.this.pYS.remove(Integer.valueOf(c32618pu2.cLZ.ctE));
                                        C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(C43488e.this.pYR.size()), Integer.valueOf(C43488e.this.pYS.size()));
                                        C43488e.m77697a(C43488e.this, c32618pu2.cLZ.ctE);
                                        break;
                                }
                                if (orientationInDegree != 0) {
                                    C4990ab.m7416i("delete tmp path %s", str2);
                                    C5730e.deleteFile(str2);
                                }
                            }
                            AppMethodBeat.m2505o(138452);
                        }
                    });
                    AppMethodBeat.m2505o(138454);
                    return true;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", e, "", new Object[0]);
                    C43488e.m77697a(C43488e.this, c32618pu.cLZ.ctE);
                }
            }
            AppMethodBeat.m2505o(138454);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.e$2 */
    class C396272 extends C4884c<C26084ao> {
        C396272() {
            AppMethodBeat.m2504i(80776);
            this.xxI = C26084ao.class.getName().hashCode();
            AppMethodBeat.m2505o(80776);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(80778);
            C26084ao c26084ao = (C26084ao) c4883b;
            if (c26084ao.ctD.scene == 1 && C43488e.this.pYQ.containsKey(Integer.valueOf(c26084ao.ctD.ctE))) {
                C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "cancel translate sessionId %d", Integer.valueOf(c26084ao.ctD.ctE));
                C43488e.this.pYQ.remove(Integer.valueOf(c26084ao.ctD.ctE));
                if (C43488e.this.pYR.containsKey(Integer.valueOf(c26084ao.ctD.ctE)) && C43488e.this.pYS.containsKey(Integer.valueOf(c26084ao.ctD.ctE))) {
                    ((C1600r) C43488e.this.pYR.get(Integer.valueOf(c26084ao.ctD.ctE))).cWX = 2;
                    ((C1600r) C43488e.this.pYR.get(Integer.valueOf(c26084ao.ctD.ctE))).cXa = System.currentTimeMillis() - ((Long) C43488e.this.pYS.get(Integer.valueOf(c26084ao.ctD.ctE))).longValue();
                    ((C1600r) C43488e.this.pYR.get(Integer.valueOf(c26084ao.ctD.ctE))).ajK();
                    C43488e.this.pYR.remove(Integer.valueOf(c26084ao.ctD.ctE));
                    C43488e.this.pYS.remove(Integer.valueOf(c26084ao.ctD.ctE));
                    C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(C43488e.this.pYR.size()), Integer.valueOf(C43488e.this.pYS.size()));
                }
                AppMethodBeat.m2505o(80778);
                return true;
            }
            AppMethodBeat.m2505o(80778);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.e$1 */
    class C434891 implements C34843b {
        C434891() {
        }

        /* renamed from: b */
        public final void mo37175b(int i, Bitmap bitmap) {
            AppMethodBeat.m2504i(80774);
            if (C43488e.this.pYQ.containsKey(Integer.valueOf(i))) {
                if (C43488e.this.pYR.containsKey(Integer.valueOf(i)) && C43488e.this.pYS.containsKey(Integer.valueOf(i))) {
                    ((C1600r) C43488e.this.pYR.get(Integer.valueOf(i))).cXa = System.currentTimeMillis() - ((Long) C43488e.this.pYS.get(Integer.valueOf(i))).longValue();
                    ((C1600r) C43488e.this.pYR.get(Integer.valueOf(i))).ajK();
                    C43488e.this.pYR.remove(Integer.valueOf(i));
                    C43488e.this.pYS.remove(Integer.valueOf(i));
                    C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(C43488e.this.pYR.size()), Integer.valueOf(C43488e.this.pYS.size()));
                }
                if (C1720g.m3531RK()) {
                    C43488e.cgy();
                    String Wb = C43488e.m77693Wb("jpg");
                    try {
                        C5056d.m7625a(bitmap, 80, CompressFormat.JPEG, Wb, false);
                        C46181p c46181p = new C46181p();
                        C39624q c39624q = (C39624q) C43488e.this.pYQ.get(Integer.valueOf(i));
                        c46181p.field_originMD5 = C4995ag.m7428ck(c39624q.fWz + C5730e.ata(c39624q.fWz));
                        c46181p.field_resultFile = Wb;
                        c46181p.field_fromLang = c39624q.cMc;
                        c46181p.field_toLang = c39624q.cMd;
                        C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "translate %d success, insert translate result %s", Integer.valueOf(i), Wb);
                        C43488e.cgy().cgD().mo10101b((C4925c) c46181p);
                        C32619pv c32619pv = new C32619pv();
                        c32619pv.cMa.ctE = i;
                        c32619pv.cMa.ctn = true;
                        c32619pv.cMa.cMb = Wb;
                        c32619pv.cMa.cMc = c39624q.cMc;
                        c32619pv.cMa.cMd = c39624q.cMd;
                        C4879a.xxA.mo10055m(c32619pv);
                        C43488e.this.pYQ.remove(Integer.valueOf(i));
                        AppMethodBeat.m2505o(80774);
                        return;
                    } catch (IOException e) {
                        C4990ab.printErrStackTrace("MicroMsg.scanner.SubCoreScanner", e, "save translate result file error", new Object[0]);
                        C43488e.m77697a(C43488e.this, i);
                    }
                } else {
                    AppMethodBeat.m2505o(80774);
                    return;
                }
            }
            AppMethodBeat.m2505o(80774);
        }
    }

    public C43488e() {
        AppMethodBeat.m2504i(80781);
        AppMethodBeat.m2505o(80781);
    }

    /* renamed from: a */
    static /* synthetic */ void m77697a(C43488e c43488e, int i) {
        AppMethodBeat.m2504i(138458);
        c43488e.m77692BS(i);
        AppMethodBeat.m2505o(138458);
    }

    /* renamed from: BS */
    private void m77692BS(int i) {
        AppMethodBeat.m2504i(80782);
        C32619pv c32619pv = new C32619pv();
        c32619pv.cMa.ctE = i;
        c32619pv.cMa.ctn = false;
        C4879a.xxA.mo10055m(c32619pv);
        this.pYQ.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(80782);
    }

    static {
        AppMethodBeat.m2504i(80798);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("SCANHISTORY_TABLE".hashCode()), new C131265());
        eaA.put(Integer.valueOf("scan_translation_result_table".hashCode()), new C288936());
        AppMethodBeat.m2505o(80798);
    }

    public static synchronized C43488e cgy() {
        C43488e c43488e;
        synchronized (C43488e.class) {
            AppMethodBeat.m2504i(80783);
            c43488e = (C43488e) C7485q.m12925Y(C43488e.class);
            AppMethodBeat.m2505o(80783);
        }
        return c43488e;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(80784);
        C4879a.xxA.mo10053d(this.pYJ);
        C4879a.xxA.mo10053d(this.pYK.qah);
        C4879a.xxA.mo10053d(this.pYK.qai);
        C4879a.xxA.mo10053d(this.pYL);
        C4879a.xxA.mo10053d(this.pYV);
        C4879a.xxA.mo10053d(this.pYU);
        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_WU, (C1202f) this);
        C21674b c21674b = this.pYW;
        C4879a.xxA.mo10053d(c21674b.pZy);
        C4879a.xxA.mo10053d(c21674b.pZz);
        c21674b.cgE();
        C35336b c35336b = this.pYI;
        c35336b.fGz.clear();
        c35336b.f15068ce.clear();
        c35336b.pAo.clear();
        if (this.jZF != null) {
            this.jZF.mo5709mJ(hashCode());
            this.jZF = null;
        }
        this.eJM = "";
        AppMethodBeat.m2505o(80784);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(80785);
        this.jZF = C1952t.m4171a(hashCode(), C1720g.m3536RP().cachePath + "CommonOneMicroMsg.db", jZD, false);
        C21674b c21674b = this.pYW;
        C4879a.xxA.mo10052c(c21674b.pZy);
        C4879a.xxA.mo10052c(c21674b.pZz);
        C4879a.xxA.mo10052c(this.pYJ);
        C4879a.xxA.mo10052c(this.pYK.qah);
        C4879a.xxA.mo10052c(this.pYK.qai);
        C4879a.xxA.mo10051b(this.pYL);
        C4879a.xxA.mo10051b(this.pYV);
        C4879a.xxA.mo10051b(this.pYU);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_PTU_WU, (C1202f) this);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("NewOCRTranslationRedDot");
        C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "redDotStr %s", value);
        if (!C5046bo.isNullOrNil(value)) {
            Map z2 = C5049br.m7595z(value, "Id");
            if (z2.containsKey(".Id")) {
                int i = C5046bo.getInt((String) z2.get(".Id"), 0);
                int i2 = C1720g.m3536RP().mo5239Ry().getInt(C5127a.USERINFO_TRANSLATION_RED_DOT_ID_INT_SYNC, 0);
                if (!(i == 0 || i2 == i)) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_TRANSLATION_RED_DOT_ID_INT_SYNC, Integer.valueOf(i));
                    C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_TRANSLATION_RED_DOT_STRING_SYNC, true);
                }
            }
        }
        C7305d.post(new C131254(), "MicroMsg.scanner.SubCoreScannerdeleteOutDateImg");
        AppMethodBeat.m2505o(80785);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(80786);
        C4990ab.m7410d("MicroMsg.scanner.SubCoreScanner", "onSdcardMount " + C1720g.m3536RP().eJM);
        String str = C1720g.m3536RP().eJM;
        C4990ab.m7410d("MicroMsg.scanner.SubCoreScanner", "resetAccPath on accPath : ".concat(String.valueOf(str)));
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
        File file2 = new File(C43488e.cgz());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        C43488e.cgy();
        C5730e.ate(C43488e.cgA());
        C43488e.cgy();
        C5730e.ate(C43488e.cgB());
        AppMethodBeat.m2505o(80786);
    }

    /* renamed from: fQ */
    public final String mo69040fQ(String str, String str2) {
        AppMethodBeat.m2504i(80787);
        String str3;
        if (!C1720g.m3531RK() || C5046bo.isNullOrNil(str)) {
            str3 = "";
            AppMethodBeat.m2505o(80787);
            return str3;
        }
        str3 = String.format("%s/scanbook%s_%s", new Object[]{this.eJM + "image/scan/img", str2, C1178g.m2591x(str.getBytes())});
        AppMethodBeat.m2505o(80787);
        return str3;
    }

    private static String cgz() {
        AppMethodBeat.m2504i(80788);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        String stringBuilder2 = stringBuilder.append(C1720g.m3536RP().eJM).append("scanner/").toString();
        AppMethodBeat.m2505o(80788);
        return stringBuilder2;
    }

    public static String cgA() {
        AppMethodBeat.m2504i(80789);
        String str = C43488e.cgz() + "scan_camera/";
        AppMethodBeat.m2505o(80789);
        return str;
    }

    private static String cgB() {
        AppMethodBeat.m2504i(80790);
        String str = C43488e.cgz() + "scan_result/";
        AppMethodBeat.m2505o(80790);
        return str;
    }

    /* renamed from: Wb */
    public static String m77693Wb(String str) {
        AppMethodBeat.m2504i(80791);
        String str2 = C43488e.cgB() + String.format("%s_%d.%s", new Object[]{"translation", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.m2505o(80791);
        return str2;
    }

    /* renamed from: Wc */
    public static String m77694Wc(String str) {
        AppMethodBeat.m2504i(80792);
        String str2 = C43488e.cgA() + String.format("%s_%d.%s", new Object[]{"tmp", Long.valueOf(System.currentTimeMillis()), str});
        AppMethodBeat.m2505o(80792);
        return str2;
    }

    /* renamed from: Wd */
    public static String m77695Wd(String str) {
        AppMethodBeat.m2504i(80793);
        String format = String.format("%s.%s", new Object[]{C43488e.cgA() + "scan_translation_bg", str});
        AppMethodBeat.m2505o(80793);
        return format;
    }

    public final C13121a cgC() {
        AppMethodBeat.m2504i(80794);
        C1720g.m3534RN().mo5159QU();
        if (this.pYO == null) {
            this.pYO = new C13121a(C1720g.m3536RP().eJN);
        }
        C13121a c13121a = this.pYO;
        AppMethodBeat.m2505o(80794);
        return c13121a;
    }

    public final C13122b cgD() {
        AppMethodBeat.m2504i(80795);
        C1720g.m3534RN().mo5159QU();
        if (this.pYP == null) {
            this.pYP = new C13122b(C1720g.m3536RP().eJN);
        }
        C13122b c13122b = this.pYP;
        AppMethodBeat.m2505o(80795);
        return c13122b;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(80796);
        C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "onSceneEnd errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (c1207m.getType() == C31128d.MIC_PTU_WU) {
            int i3 = ((C21679e) c1207m).ctE;
            if (i == 0 && i2 == 0) {
                List list = ((C21679e) c1207m).pZB;
                if (list != null) {
                    C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "session %d, angle %f, translationInfos length %d", Integer.valueOf(i3), Float.valueOf(((C21679e) c1207m).angle), Integer.valueOf(list.size()));
                    if (this.pYR.containsKey(Integer.valueOf(i3))) {
                        ((C1600r) this.pYR.get(Integer.valueOf(i3))).cWZ = System.currentTimeMillis() - ((C21679e) c1207m).pZC;
                    }
                    if (list.size() <= 0 || !this.pYQ.containsKey(Integer.valueOf(i3))) {
                        if (this.pYR.containsKey(Integer.valueOf(i3)) && this.pYS.containsKey(Integer.valueOf(i3))) {
                            ((C1600r) this.pYR.get(Integer.valueOf(i3))).cXa = System.currentTimeMillis() - ((Long) this.pYS.get(Integer.valueOf(i3))).longValue();
                        }
                        m77692BS(i3);
                    } else {
                        C39624q c39624q = (C39624q) this.pYQ.get(Integer.valueOf(i3));
                        c39624q.cMc = ((bef) ((C21679e) c1207m).ehh.fsH.fsP).pZE;
                        c39624q.cMd = ((C21679e) c1207m).cgF();
                        if (this.pYR.containsKey(Integer.valueOf(i3))) {
                            ((C1600r) this.pYR.get(Integer.valueOf(i3))).cWX = 1;
                        }
                        C46190n c46190n = C43488e.cgy().pYN;
                        float f = ((C21679e) c1207m).angle;
                        String str2 = c39624q.qal;
                        C34843b c34843b = this.pYT;
                        if (!(i3 == 0 || list == null || list.size() <= 0 || c34843b == null)) {
                            Bitmap decodeFile = C5056d.decodeFile(str2, new Options());
                            if (decodeFile == null) {
                                c34843b.mo37175b(i3, null);
                                AppMethodBeat.m2505o(80796);
                                return;
                            }
                            if (!(c46190n.qiA == 0 || i3 == c46190n.qiA)) {
                                C4990ab.m7417i("MicroMsg.ScanTranslationRender", "stop current session %d, start new session %d", Integer.valueOf(c46190n.qiA), Integer.valueOf(i3));
                                c46190n.cim();
                            }
                            c46190n.qiA = i3;
                            c46190n.qiB = c34843b;
                            c46190n.qiC = new C24823a(i3, list, f, decodeFile);
                            c46190n.qiC.mo38881u(new Void[0]);
                        }
                        AppMethodBeat.m2505o(80796);
                        return;
                    }
                }
                AppMethodBeat.m2505o(80796);
                return;
            }
            if (this.pYR.containsKey(Integer.valueOf(i3)) && this.pYS.containsKey(Integer.valueOf(i3))) {
                ((C1600r) this.pYR.get(Integer.valueOf(i3))).cXa = System.currentTimeMillis() - ((Long) this.pYS.get(Integer.valueOf(i3))).longValue();
                ((C1600r) this.pYR.get(Integer.valueOf(i3))).cWX = 5;
                ((C1600r) this.pYR.get(Integer.valueOf(i3))).ajK();
                this.pYR.remove(Integer.valueOf(i3));
                this.pYS.remove(Integer.valueOf(i3));
                C4990ab.m7417i("MicroMsg.scanner.SubCoreScanner", "translationReports size %d, translationUpload size %d", Integer.valueOf(this.pYR.size()), Integer.valueOf(this.pYS.size()));
            }
            m77692BS(i3);
        }
        AppMethodBeat.m2505o(80796);
    }
}

package com.tencent.p177mm.plugin.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.facedetect.model.C20638m;
import com.tencent.p177mm.plugin.facedetect.model.C20641o;
import com.tencent.p177mm.plugin.facedetect.model.C39013k;
import com.tencent.p177mm.plugin.facedetect.model.C43034i;
import com.tencent.p177mm.plugin.facedetect.model.C43035j;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45923c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.facedetect.a */
public final class C43023a implements C5681a<Void, Void> {
    private static C43035j lRY = new C43035j();
    private static C20641o lRZ = new C20641o();
    private static C43034i lSa = new C43034i();
    private static C20638m lSb = new C20638m();
    private static C45923c lSc = new C45923c();
    private static C39013k lSd = new C39013k();
    private C5688b glt = null;

    /* renamed from: com.tencent.mm.plugin.facedetect.a$1 */
    class C279151 implements Runnable {
        C279151() {
        }

        public final void run() {
            AppMethodBeat.m2504i(52);
            String bsP = C43036p.bsP();
            String bsQ = C43036p.bsQ();
            String bsR = C43036p.bsR();
            C4990ab.m7417i("MicroMsg.TaskInitFace", "alvinluo detectmodel: %s, exist: %b, alignModel: %s, exist: %b, postDetectModel: %s, exist: %s", bsP, Boolean.valueOf(C40433a.m69345ct(bsP)), bsQ, Boolean.valueOf(C40433a.m69345ct(bsQ)), bsR, Boolean.valueOf(C40433a.m69345ct(bsR)));
            if (C40433a.m69345ct(bsP)) {
                C43023a.m76414ei(bsP, "face_detect" + File.separator + "ufdmtcc.bin");
            } else {
                C4990ab.m7416i("MicroMsg.TaskInitFace", "alvinluo copy detect model file");
                C43036p.m76434p(C4996ah.getContext(), "face_detect" + File.separator + "ufdmtcc.bin", bsP);
            }
            if (r4) {
                C43023a.m76414ei(bsQ, "face_detect" + File.separator + "ufat.bin");
            } else {
                C4990ab.m7416i("MicroMsg.TaskInitFace", "alvinluo copy alignment model file");
                C43036p.m76434p(C4996ah.getContext(), "face_detect" + File.separator + "ufat.bin", bsQ);
            }
            if (r5) {
                C43023a.m76414ei(bsR, "face_detect" + File.separator + "PE.dat");
                AppMethodBeat.m2505o(52);
                return;
            }
            C4990ab.m7416i("MicroMsg.TaskInitFace", "copy post detect model file");
            C43036p.m76434p(C4996ah.getContext(), "face_detect" + File.separator + "PE.dat", bsR);
            AppMethodBeat.m2505o(52);
        }
    }

    static {
        AppMethodBeat.m2504i(56);
        AppMethodBeat.m2505o(56);
    }

    private static void safeAddListener(C4884c c4884c) {
        AppMethodBeat.m2504i(53);
        if (c4884c == null) {
            C4990ab.m7420w("MicroMsg.TaskInitFace", "hy: listener is null or id is invalid");
            AppMethodBeat.m2505o(53);
        } else if (C4879a.xxA.mo10054e(c4884c)) {
            C4990ab.m7420w("MicroMsg.TaskInitFace", "hy: already has listener");
            AppMethodBeat.m2505o(53);
        } else {
            C4879a.xxA.mo10052c(c4884c);
            AppMethodBeat.m2505o(53);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(54);
        C4990ab.m7416i("MicroMsg.TaskInitFace", "hy: TaskInitFace init");
        this.glt = C5698f.dMj();
        C43023a.safeAddListener(lRY);
        C43023a.safeAddListener(lRZ);
        C43023a.safeAddListener(lSa);
        C43023a.safeAddListener(lSc);
        C43023a.safeAddListener(lSd);
        C7305d.post(new C279151(), "FaceDetectCopyModelFile");
        AppMethodBeat.m2505o(54);
        return null;
    }

    /* renamed from: ei */
    static /* synthetic */ void m76414ei(String str, String str2) {
        AppMethodBeat.m2504i(55);
        String atg = C5730e.atg(str);
        String atg2 = C5730e.atg("assets:///".concat(String.valueOf(str2)));
        C4990ab.m7416i("MicroMsg.TaskInitFace", "localMD5 : ".concat(String.valueOf(atg)));
        C4990ab.m7416i("MicroMsg.TaskInitFace", "assetMD5 : ".concat(String.valueOf(atg2)));
        if (atg.equals(atg2)) {
            C4990ab.m7417i("MicroMsg.TaskInitFace", "SDPath:%s   exists ", str);
            AppMethodBeat.m2505o(55);
            return;
        }
        C5730e.deleteFile(str);
        C4990ab.m7416i("MicroMsg.TaskInitFace", str + " md5 is wrong");
        C43036p.m76434p(C4996ah.getContext(), str2, str);
        AppMethodBeat.m2505o(55);
    }
}

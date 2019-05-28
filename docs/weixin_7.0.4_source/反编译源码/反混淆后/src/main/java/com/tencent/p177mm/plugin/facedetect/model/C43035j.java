package com.tencent.p177mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32571ht;
import com.tencent.p177mm.p230g.p231a.C32571ht.C26161a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.model.j */
public final class C43035j extends C4884c<C32571ht> {
    public C43035j() {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_LIGHTWHITE);
        this.xxI = C32571ht.class.getName().hashCode();
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_LIGHTWHITE);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        boolean z = false;
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_FAIRYTALE);
        C32571ht c32571ht = (C32571ht) c4883b;
        if (c32571ht == null) {
            C4990ab.m7412e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_FAIRYTALE);
            return false;
        }
        C11810f c11810f = C11810f.lTL;
        boolean dL = C11810f.m19661dL(C4996ah.getContext());
        C11810f c11810f2 = C11810f.lTL;
        boolean bsB = C11810f.bsB();
        if (!dL) {
            c32571ht.cCH.cCJ = 10001;
            c32571ht.cCH.cCK = "No front camera";
        } else if (bsB) {
            c32571ht.cCH.cCK = "ok";
        } else {
            c32571ht.cCH.cCJ = 10002;
            c32571ht.cCH.cCK = "No necessary model found";
        }
        C26161a c26161a = c32571ht.cCH;
        C11810f c11810f3 = C11810f.lTL;
        c26161a.cCL = C11810f.bsE();
        c26161a = c32571ht.cCH;
        if (dL && bsB) {
            z = true;
        }
        c26161a.cCI = z;
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_FAIRYTALE);
        return true;
    }
}

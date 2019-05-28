package com.tencent.mm.plugin.facedetect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.g.a.ht.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.view.d;

public final class j extends c<ht> {
    public j() {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_LIGHTWHITE);
        this.xxI = ht.class.getName().hashCode();
        AppMethodBeat.o(d.MIC_PTU_ZIPAI_LIGHTWHITE);
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_FAIRYTALE);
        ht htVar = (ht) bVar;
        if (htVar == null) {
            ab.e("MicroMsg.FaceGetIsSupportListener", "hy: event is null");
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_FAIRYTALE);
            return false;
        }
        f fVar = f.lTL;
        boolean dL = f.dL(ah.getContext());
        f fVar2 = f.lTL;
        boolean bsB = f.bsB();
        if (!dL) {
            htVar.cCH.cCJ = 10001;
            htVar.cCH.cCK = "No front camera";
        } else if (bsB) {
            htVar.cCH.cCK = "ok";
        } else {
            htVar.cCH.cCJ = 10002;
            htVar.cCH.cCK = "No necessary model found";
        }
        a aVar = htVar.cCH;
        f fVar3 = f.lTL;
        aVar.cCL = f.bsE();
        aVar = htVar.cCH;
        if (dL && bsB) {
            z = true;
        }
        aVar.cCI = z;
        AppMethodBeat.o(d.MIC_PTU_ZIPAI_FAIRYTALE);
        return true;
    }
}

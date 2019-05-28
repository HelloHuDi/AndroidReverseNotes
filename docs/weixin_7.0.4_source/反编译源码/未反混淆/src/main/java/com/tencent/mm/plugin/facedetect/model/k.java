package com.tencent.mm.plugin.facedetect.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.op;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.view.d;

public final class k extends c<op> {
    public k() {
        AppMethodBeat.i(247);
        this.xxI = op.class.getName().hashCode();
        AppMethodBeat.o(247);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(d.MIC_PTU_ZIPAI_THURSDAY);
        op opVar = (op) bVar;
        if (opVar == null) {
            AppMethodBeat.o(d.MIC_PTU_ZIPAI_THURSDAY);
            return false;
        }
        op.b bVar2 = opVar.cKX;
        f fVar = f.lTL;
        bVar2.cKV = f.a(opVar.cKW.context, opVar.cKW.extras, opVar.cKW.cKY);
        if (!opVar.cKX.cKV) {
            opVar.cKX.extras = new Bundle();
            opVar.cKX.extras.putInt("err_code", 90001);
            opVar.cKX.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.o(d.MIC_PTU_ZIPAI_THURSDAY);
        return true;
    }
}

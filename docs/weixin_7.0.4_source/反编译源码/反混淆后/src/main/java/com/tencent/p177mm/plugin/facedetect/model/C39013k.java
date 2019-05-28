package com.tencent.p177mm.plugin.facedetect.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C9434op;
import com.tencent.p177mm.p230g.p231a.C9434op.C9435b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.facedetect.model.k */
public final class C39013k extends C4884c<C9434op> {
    public C39013k() {
        AppMethodBeat.m2504i(247);
        this.xxI = C9434op.class.getName().hashCode();
        AppMethodBeat.m2505o(247);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(C31128d.MIC_PTU_ZIPAI_THURSDAY);
        C9434op c9434op = (C9434op) c4883b;
        if (c9434op == null) {
            AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_THURSDAY);
            return false;
        }
        C9435b c9435b = c9434op.cKX;
        C11810f c11810f = C11810f.lTL;
        c9435b.cKV = C11810f.m19660a(c9434op.cKW.context, c9434op.cKW.extras, c9434op.cKW.cKY);
        if (!c9434op.cKX.cKV) {
            c9434op.cKX.extras = new Bundle();
            c9434op.cKX.extras.putInt("err_code", 90001);
            c9434op.cKX.extras.putString("err_msg", "face detect not support");
        }
        AppMethodBeat.m2505o(C31128d.MIC_PTU_ZIPAI_THURSDAY);
        return true;
    }
}

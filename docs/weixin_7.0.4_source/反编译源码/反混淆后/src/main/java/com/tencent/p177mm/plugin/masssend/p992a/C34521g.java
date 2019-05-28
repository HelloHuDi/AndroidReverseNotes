package com.tencent.p177mm.plugin.masssend.p992a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.masssend.a.g */
public final class C34521g extends C4884c<C6523mp> {
    public C34521g() {
        AppMethodBeat.m2504i(22741);
        this.xxI = C6523mp.class.getName().hashCode();
        AppMethodBeat.m2505o(22741);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(22743);
        boolean aiv = C34521g.aiv();
        AppMethodBeat.m2505o(22743);
        return aiv;
    }

    private static boolean aiv() {
        AppMethodBeat.m2504i(22742);
        if (C9638aw.m17179RK()) {
            boolean z;
            C21270h.bNF();
            C9638aw.m17190ZK();
            if (C5046bo.m7566gb(C5046bo.m7514a((Long) C18628c.m29072Ry().get(102409, null), 0)) > 900000) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                C21270h.bNF().bNA();
                C21270h.bNF();
                C43293c.m77162je(C5046bo.anU());
                AppMethodBeat.m2505o(22742);
            } else {
                C4990ab.m7410d("MicroMsg.PostTaskMassSendListener", "time limit");
                AppMethodBeat.m2505o(22742);
            }
        } else {
            C4990ab.m7412e("MicroMsg.PostTaskMassSendListener", "has not set uin");
            AppMethodBeat.m2505o(22742);
        }
        return false;
    }
}

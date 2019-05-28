package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C37730hu;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.soter.d.c */
public final class C46262c extends C4884c<C37730hu> {
    public C46262c() {
        AppMethodBeat.m2504i(59331);
        this.xxI = C37730hu.class.getName().hashCode();
        AppMethodBeat.m2505o(59331);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(59332);
        C37730hu c37730hu = (C37730hu) c4883b;
        if (c37730hu instanceof C37730hu) {
            C4990ab.m7416i("MicroMsg.GetSoterSupportEventListener", "hy: request is support soter");
            C4990ab.m7417i("MicroMsg.GetSoterSupportEventListener", "alvinluo isSupportSoter: %b", Boolean.valueOf(C4104m.cvU()));
            if (C4104m.cvU()) {
                c37730hu.cCM.cCN = 1;
            } else {
                c37730hu.cCM.cCN = 0;
            }
        }
        AppMethodBeat.m2505o(59332);
        return true;
    }
}

package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9379ic;
import com.tencent.p177mm.plugin.sns.model.C7108v;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.e */
public final class C34936e extends C4884c<C9379ic> {
    public C34936e() {
        AppMethodBeat.m2504i(35608);
        this.xxI = C9379ic.class.getName().hashCode();
        AppMethodBeat.m2505o(35608);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35609);
        C9379ic c9379ic = (C9379ic) c4883b;
        if (c9379ic instanceof C9379ic) {
            if (c9379ic.cDb.cAd == 0) {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C7108v(1), 0);
            } else {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C7108v(c9379ic.cDb.cAd), 0);
            }
            AppMethodBeat.m2505o(35609);
            return true;
        }
        C4990ab.m7414f("MicroMsg.GetSnsTagListListener", "mismatched event");
        AppMethodBeat.m2505o(35609);
        return false;
    }
}

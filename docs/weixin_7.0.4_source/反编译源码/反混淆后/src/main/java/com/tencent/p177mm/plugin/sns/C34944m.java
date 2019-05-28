package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C45364rv;
import com.tencent.p177mm.plugin.sns.model.C7101u;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.m */
public final class C34944m extends C4884c<C45364rv> {
    public C34944m() {
        AppMethodBeat.m2504i(35633);
        this.xxI = C45364rv.class.getName().hashCode();
        AppMethodBeat.m2505o(35633);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35634);
        C45364rv c45364rv = (C45364rv) c4883b;
        if (c45364rv instanceof C45364rv) {
            if (c45364rv.cNO.cvp == 2) {
                boolean z = C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(68377, null)) && C21877n.qFz.baS() == 0;
                C4990ab.m7417i("MicroMsg.SnsSyncListener", "Strategy 3 isNotExistSnsNew %b", Boolean.valueOf(z));
                if (z) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14541a(new C7101u(), 0);
                }
            } else {
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(new C7101u(), 0);
            }
            AppMethodBeat.m2505o(35634);
            return true;
        }
        C4990ab.m7414f("MicroMsg.SnsSyncListener", "mismatched event");
        AppMethodBeat.m2505o(35634);
        return false;
    }
}

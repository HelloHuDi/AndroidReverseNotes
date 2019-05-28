package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18271fz;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.account.friend.a.e */
public final class C42281e extends C4884c<C18271fz> {
    public C42281e() {
        AppMethodBeat.m2504i(108327);
        this.xxI = C18271fz.class.getName().hashCode();
        AppMethodBeat.m2505o(108327);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(108328);
        C18271fz c18271fz = (C18271fz) c4883b;
        if (c18271fz instanceof C18271fz) {
            c18271fz.cAf.cAi = true;
            if (!C5046bo.isNullOrNil(C38033l.m64351wf(c18271fz.cAe.cAg))) {
                c18271fz.cAf.cAi = false;
                AppMethodBeat.m2505o(108328);
            } else if (C5046bo.isNullOrNil(C38033l.m64351wf(c18271fz.cAe.cAh))) {
                C4990ab.m7416i("MicroMsg.FMessageMobileFilterListenerImpl", "mobile fmessage not found by phonemd5 or fullphonemd5");
                AppMethodBeat.m2505o(108328);
            } else {
                c18271fz.cAf.cAi = false;
                AppMethodBeat.m2505o(108328);
            }
        } else {
            AppMethodBeat.m2505o(108328);
        }
        return false;
    }
}

package com.tencent.p177mm.plugin.soter.p1301e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.soter.p528d.C13722g;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C7583c;

/* renamed from: com.tencent.mm.plugin.soter.e.b */
public final class C22155b {
    /* renamed from: a */
    public static void m33780a(boolean z, boolean z2, final C13722g c13722g) {
        AppMethodBeat.m2504i(59357);
        C4990ab.m7417i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            C5698f.m8551D(Boolean.valueOf(z), Boolean.valueOf(z2)).mo15893d(new C43615a()).mo15893d(new C29256c()).mo15893d(new C22158d()).mo11586a((C5690a) new C5690a<C7583c<Integer, String>>() {
                /* renamed from: bi */
                public final /* synthetic */ void mo9345bi(Object obj) {
                    AppMethodBeat.m2504i(59356);
                    C7583c c7583c = (C7583c) obj;
                    String str = (String) c7583c.get(1);
                    C4990ab.m7413e("MicroMsg.SoterInitManager", "alvinluo onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(((Integer) c7583c.get(0)).intValue()), str);
                    if (c13722g != null) {
                        c13722g.mo25925aC(r1, str);
                    }
                    AppMethodBeat.m2505o(59356);
                }
            }).mo11587a(new C5691b<Boolean>() {
                /* renamed from: az */
                public final /* synthetic */ void mo5270az(Object obj) {
                    AppMethodBeat.m2504i(59355);
                    C4990ab.m7416i("MicroMsg.SoterInitManager", "alvinluo onTerminate");
                    C4990ab.m7417i("MicroMsg.SoterInitManager", "alvinluo init takes %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (c13722g != null) {
                        c13722g.mo25925aC(0, "");
                    }
                    AppMethodBeat.m2505o(59355);
                }
            });
            AppMethodBeat.m2505o(59357);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.SoterInitManager", e, "alvinluo exception when init soter: %s", e.getMessage());
            C46261a.m86642fH(4, 1001);
            if (c13722g != null) {
                c13722g.mo25925aC(-1, "system error");
            }
            AppMethodBeat.m2505o(59357);
        }
    }
}

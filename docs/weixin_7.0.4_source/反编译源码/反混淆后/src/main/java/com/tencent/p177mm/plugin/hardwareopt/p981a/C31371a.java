package com.tencent.p177mm.plugin.hardwareopt.p981a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.hardwareopt.p1486c.C39244b;
import com.tencent.p177mm.plugin.hardwareopt.p1486c.C46019a;
import com.tencent.p177mm.plugin.hardwareopt.p981a.p1404a.C28284a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5692d.C5691b;
import com.tencent.p177mm.vending.p641g.C7582e;

/* renamed from: com.tencent.mm.plugin.hardwareopt.a.a */
public final class C31371a implements C28284a {

    /* renamed from: com.tencent.mm.plugin.hardwareopt.a.a$1 */
    class C122191 implements C5691b<Boolean> {
        C122191() {
        }

        /* renamed from: az */
        public final /* synthetic */ void mo5270az(Object obj) {
            AppMethodBeat.m2504i(59270);
            C4990ab.m7416i("MicroMsg.HardwareProvider", "hy: on terminate");
            AppMethodBeat.m2505o(59270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.hardwareopt.a.a$2 */
    class C282832 implements C5690a {
        C282832() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(59271);
            C4990ab.m7420w("MicroMsg.HardwareProvider", "hy: on interrupt.");
            AppMethodBeat.m2505o(59271);
        }
    }

    /* renamed from: hX */
    public final void mo46215hX(boolean z) {
        AppMethodBeat.m2504i(59272);
        new C7582e().mo16867C(C4996ah.getContext()).mo15895e(new C46019a()).mo15893d(new C39244b(z)).mo11586a((C5690a) new C282832()).mo11587a(new C122191());
        AppMethodBeat.m2505o(59272);
    }
}

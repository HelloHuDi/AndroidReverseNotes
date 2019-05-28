package com.tencent.p177mm.plugin.soter.p1301e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.soter.p528d.C29255h;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16166d;
import com.tencent.soter.p663a.p1106b.C46744e;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tencent.soter.p663a.p664g.C44471e.C44470a;

/* renamed from: com.tencent.mm.plugin.soter.e.a */
public final class C43615a implements C5681a<C7583c<Boolean, Boolean>, C7583c<Boolean, Boolean>> {
    private C5688b glt = null;

    /* renamed from: com.tencent.mm.plugin.soter.e.a$1 */
    class C436161 implements C16164b<C16166d> {
        C436161() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(59353);
            C16166d c16166d = (C16166d) c46744e;
            C4990ab.m7417i("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(c16166d.errCode), c16166d.aIm);
            if (c16166d.isSuccess()) {
                C4990ab.m7419v("MicroMsg.SoterInitFunc", "alvinluo resume %d", Long.valueOf(System.currentTimeMillis()));
                C43615a.this.glt.resume();
                AppMethodBeat.m2505o(59353);
                return;
            }
            C46261a.m86642fH(0, c16166d.errCode);
            C43615a.this.glt.mo11582cR(C5698f.m8552E(Integer.valueOf(c16166d.errCode), c16166d.aIm));
            AppMethodBeat.m2505o(59353);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(59354);
        C7583c c7583c = (C7583c) obj;
        C4990ab.m7418v("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc call");
        C44470a c44470a = new C44470a();
        c44470a.Awt.Awp = C4104m.cvS();
        c44470a.Awt.Aws = "WechatASK";
        c44470a = c44470a.mo70643E(1, 2, 3);
        c44470a.Awt.Awo = null;
        c44470a.Awt.Awr = new C29255h();
        C22159e c22159e = new C22159e(C4996ah.getContext(), c44470a.Awt);
        this.glt = C5698f.dMj();
        this.glt.dMi();
        c22159e.Awl = new C436161();
        if (!C40994f.dRn().mo64934a(c22159e, new C16166d())) {
            C4990ab.m7412e("MicroMsg.SoterInitFunc", "alvinluo: add soterTaskInitForWX failed.");
        }
        C4990ab.m7419v("MicroMsg.SoterInitFunc", "alvinluo pending %d", Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.m2505o(59354);
        return c7583c;
    }
}

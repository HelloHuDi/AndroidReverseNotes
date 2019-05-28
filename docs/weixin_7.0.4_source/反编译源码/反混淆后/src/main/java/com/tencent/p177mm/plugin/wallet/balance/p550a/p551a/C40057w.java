package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C46339v.C354012;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C46339v.C463381;
import com.tencent.p177mm.protocal.protobuf.bae;
import com.tencent.p177mm.protocal.protobuf.bkl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7625d;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.w */
public class C40057w implements C24135b<C46339v> {
    protected C46339v tfQ;
    public final C40056b tfR;
    public final C40058a tfS;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.w$b */
    public class C40056b implements C7368e<bkl, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45292);
            C46339v c46339v = C40057w.this.tfQ;
            C4990ab.m7416i("MicroMsg.LqtPlanHomeInteractor", "do plan index");
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C14106g().acy().mo60487b(new C463381(dMj));
            AppMethodBeat.m2505o(45292);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.w$a */
    public class C40058a implements C7368e<bae, C7625d<Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45291);
            C7625d c7625d = (C7625d) obj;
            C46339v c46339v = C40057w.this.tfQ;
            int intValue = ((Integer) c7625d.get(0)).intValue();
            int intValue2 = ((Integer) c7625d.get(1)).intValue();
            String str = (String) c7625d.get(2);
            C4990ab.m7416i("MicroMsg.LqtPlanHomeInteractor", "do oper plan");
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C43759c(intValue, intValue2, str).acy().mo60487b(new C354012(dMj));
            AppMethodBeat.m2505o(45291);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    public C40057w() {
        this(new C46339v());
        AppMethodBeat.m2504i(45293);
        AppMethodBeat.m2505o(45293);
    }

    private C40057w(C46339v c46339v) {
        AppMethodBeat.m2504i(45294);
        this.tfR = new C40056b();
        this.tfS = new C40058a();
        this.tfQ = c46339v;
        AppMethodBeat.m2505o(45294);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfQ;
    }
}

package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C40054t.C224991;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C40054t.C225002;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C40054t.C400553;
import com.tencent.p177mm.protocal.protobuf.C15328ct;
import com.tencent.p177mm.protocal.protobuf.bdd;
import com.tencent.p177mm.protocal.protobuf.bla;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7649h;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.u */
public class C35400u implements C24135b<C40054t> {
    protected C40054t tfK;
    public final C29532c tfL;
    public final C22501a tfM;
    public final C22502b tfN;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.u$a */
    public class C22501a implements C7368e<C15328ct, C7649h<String, String, String, String, Integer, Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45282);
            C7649h c7649h = (C7649h) obj;
            C40054t c40054t = C35400u.this.tfK;
            String str = (String) c7649h.get(0);
            String str2 = (String) c7649h.get(1);
            String str3 = (String) c7649h.get(2);
            String str4 = (String) c7649h.get(3);
            int intValue = ((Integer) c7649h.get(4)).intValue();
            int intValue2 = ((Integer) c7649h.get(5)).intValue();
            int intValue3 = ((Integer) c7649h.get(6)).intValue();
            C4990ab.m7416i("MicroMsg.LqtPlanAddInteractor", "do add plan");
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C22493a(str, str2, str3, str4, (long) intValue, intValue2, intValue3).acy().mo60487b(new C225002(dMj));
            AppMethodBeat.m2505o(45282);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.u$b */
    public class C22502b implements C7368e<bdd, C7649h<Integer, String, String, String, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45283);
            C7649h c7649h = (C7649h) obj;
            C40054t c40054t = C35400u.this.tfK;
            int intValue = ((Integer) c7649h.get(0)).intValue();
            String str = (String) c7649h.get(1);
            String str2 = (String) c7649h.get(2);
            String str3 = (String) c7649h.get(3);
            int intValue2 = ((Integer) c7649h.get(4)).intValue();
            int intValue3 = ((Integer) c7649h.get(5)).intValue();
            String str4 = (String) c7649h.get(6);
            C4990ab.m7416i("MicroMsg.LqtPlanAddInteractor", "do add plan");
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C43760d(intValue, str, str2, str3, (long) intValue2, intValue3, str4).acy().mo60487b(new C400553(dMj));
            AppMethodBeat.m2505o(45283);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.u$c */
    public class C29532c implements C7368e<bla, C7583c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45284);
            C7583c c7583c = (C7583c) obj;
            C40054t c40054t = C35400u.this.tfK;
            int intValue = ((Integer) c7583c.get(0)).intValue();
            int intValue2 = ((Integer) c7583c.get(1)).intValue();
            C4990ab.m7416i("MicroMsg.LqtPlanAddInteractor", "do pre add plan");
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C29530h(intValue, intValue2).acy().mo60487b(new C224991(dMj));
            AppMethodBeat.m2505o(45284);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    public C35400u() {
        this(new C40054t());
        AppMethodBeat.m2504i(45285);
        AppMethodBeat.m2505o(45285);
    }

    private C35400u(C40054t c40054t) {
        AppMethodBeat.m2504i(45286);
        this.tfL = new C29532c();
        this.tfM = new C22501a();
        this.tfN = new C22502b();
        this.tfK = c40054t;
        AppMethodBeat.m2505o(45286);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfK;
    }
}

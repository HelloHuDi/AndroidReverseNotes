package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4309q.C43104;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4309q.C43111;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4309q.C43123;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4309q.C43132;
import com.tencent.p177mm.protocal.protobuf.C35953sw;
import com.tencent.p177mm.protocal.protobuf.bfg;
import com.tencent.p177mm.protocal.protobuf.bfi;
import com.tencent.p177mm.protocal.protobuf.bnr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7583c;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.r */
public class C4314r implements C24135b<C4309q> {
    protected C4309q tfB;
    public final C4318b tfC;
    public final C4315a tfD;
    public final C4317d tfE;
    public final C4316c tfF;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.r$a */
    public class C4315a implements C7368e<C35953sw, C7583c<String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45269);
            C7583c c7583c = (C7583c) obj;
            C4309q c4309q = C4314r.this.tfB;
            String str = (String) c7583c.get(0);
            int intValue = ((Integer) c7583c.get(1)).intValue();
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "closeAccount, accountType: %s", Integer.valueOf(intValue));
            new C22495b(str, intValue).acy().mo60492h(new C43132(dMj));
            AppMethodBeat.m2505o(45269);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.r$c */
    public class C4316c implements C7368e<bfg, C7583c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45273);
            C7583c c7583c = (C7583c) obj;
            C4309q c4309q = C4314r.this.tfB;
            int intValue = ((Integer) c7583c.get(0)).intValue();
            int intValue2 = ((Integer) c7583c.get(1)).intValue();
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase, accountType: %s", Integer.valueOf(intValue));
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C41320e(intValue, intValue2).acy().mo60487b(new C43104(dMj));
            AppMethodBeat.m2505o(45273);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }

        /* renamed from: ge */
        public final C7361c<bfg> mo9336ge(int i, int i2) {
            AppMethodBeat.m2504i(45272);
            C7361c c = C5698f.m8551D(Integer.valueOf(i), Integer.valueOf(i2)).mo15892c(this);
            AppMethodBeat.m2505o(45272);
            return c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.r$d */
    public class C4317d implements C7368e<bfi, C7583c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45274);
            C7583c c7583c = (C7583c) obj;
            C4309q c4309q = C4314r.this.tfB;
            int intValue = ((Integer) c7583c.get(0)).intValue();
            ((Integer) c7583c.get(1)).intValue();
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem, accountType: %s", Integer.valueOf(intValue));
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C46336f(intValue).acy().mo60487b(new C43123(dMj));
            AppMethodBeat.m2505o(45274);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.r$b */
    public class C4318b implements C7368e<bnr, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }

        public final C7361c<bnr> aor() {
            AppMethodBeat.m2504i(45270);
            C7361c c = C5698f.dMn().mo15892c(this);
            AppMethodBeat.m2505o(45270);
            return c;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45271);
            C4309q c4309q = C4314r.this.tfB;
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            if (!C5023at.isNetworkConnected(C4996ah.getContext())) {
                dMj.mo11582cR(Boolean.FALSE);
            }
            new C35397l().acy().mo60492h(new C43111(dMj));
            AppMethodBeat.m2505o(45271);
            return null;
        }
    }

    public C4314r() {
        this(new C4309q());
        AppMethodBeat.m2504i(45275);
        AppMethodBeat.m2505o(45275);
    }

    private C4314r(C4309q c4309q) {
        AppMethodBeat.m2504i(45276);
        this.tfC = new C4318b();
        this.tfD = new C4315a();
        this.tfE = new C4317d();
        this.tfF = new C4316c();
        this.tfB = c4309q;
        AppMethodBeat.m2505o(45276);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfB;
    }
}

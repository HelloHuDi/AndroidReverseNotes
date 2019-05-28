package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35403x.C141082;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35403x.C141093;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35403x.C295331;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35403x.C354024;
import com.tencent.p177mm.protocal.protobuf.C35921ha;
import com.tencent.p177mm.protocal.protobuf.blh;
import com.tencent.p177mm.protocal.protobuf.bmo;
import com.tencent.p177mm.protocal.protobuf.bnp;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7643f;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.y */
public class C14111y implements C24135b<C35403x> {
    protected C35403x tfV;
    public final C14110d tfW;
    public final C7528b tfX;
    public final C7529c tfY;
    public final C14112a tfZ;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.y$b */
    public class C7528b implements C7368e<bnp, C7643f<String, String, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45301);
            C7643f c7643f = (C7643f) obj;
            C35403x c35403x = C14111y.this.tfV;
            String str = (String) c7643f.get(0);
            String str2 = (String) c7643f.get(1);
            int intValue = ((Integer) c7643f.get(2)).intValue();
            String str3 = (String) c7643f.get(4);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, accountType: %s", str, str2, Integer.valueOf(((Integer) c7643f.get(3)).intValue()));
            C4990ab.m7411d("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, purchaseFee: %s", str, str2, Integer.valueOf(intValue));
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C41321k(str, str2, intValue, r4, str3).acy().mo60487b(new C141082(dMj));
            AppMethodBeat.m2505o(45301);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.y$c */
    public class C7529c implements C7368e<bqq, C7643f<Integer, String, String, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45302);
            C7643f c7643f = (C7643f) obj;
            C35403x c35403x = C14111y.this.tfV;
            int intValue = ((Integer) c7643f.get(0)).intValue();
            String str = (String) c7643f.get(1);
            String str2 = (String) c7643f.get(4);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemListId: %s, accountType: %s", (String) c7643f.get(2), Integer.valueOf(((Integer) c7643f.get(3)).intValue()));
            C4990ab.m7411d("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemFee: %s, payPasswdEnc: %s, redeemListId: %s", Integer.valueOf(intValue), str, r3);
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C35398m(intValue, str, r3, r4, str2).acy().mo60487b(new C141093(dMj));
            AppMethodBeat.m2505o(45302);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.y$d */
    public class C14110d implements C7368e<bmo, C7643f<String, String, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45303);
            C7643f c7643f = (C7643f) obj;
            C35403x c35403x = C14111y.this.tfV;
            String str = (String) c7643f.get(0);
            String str2 = (String) c7643f.get(1);
            int intValue = ((Integer) c7643f.get(2)).intValue();
            String str3 = (String) c7643f.get(4);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, accountType: %s, spid: %s", str, Integer.valueOf(((Integer) c7643f.get(3)).intValue()), str2);
            C4990ab.m7411d("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, purchaseFee: %s", str, Integer.valueOf(intValue));
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C29531j(str, str2, intValue, r4, str3).acy().mo60487b(new C295331(dMj));
            AppMethodBeat.m2505o(45303);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.y$a */
    public class C14112a implements C7368e<blh, C7643f<Integer, C35921ha, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45300);
            C7643f c7643f = (C7643f) obj;
            C35403x c35403x = C14111y.this.tfV;
            int intValue = ((Integer) c7643f.get(0)).intValue();
            C35921ha c35921ha = (C35921ha) c7643f.get(1);
            int intValue2 = ((Integer) c7643f.get(2)).intValue();
            int intValue3 = ((Integer) c7643f.get(3)).intValue();
            String str = (String) c7643f.get(4);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, accountType: %s", Integer.valueOf(intValue2));
            C4990ab.m7411d("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, redeemFee: %s", Integer.valueOf(intValue));
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            new C14107i(intValue, c35921ha, intValue2, intValue3, str).acy().mo60487b(new C354024(dMj));
            AppMethodBeat.m2505o(45300);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    public C14111y() {
        this(new C35403x());
        AppMethodBeat.m2504i(45304);
        AppMethodBeat.m2505o(45304);
    }

    private C14111y(C35403x c35403x) {
        AppMethodBeat.m2504i(45305);
        this.tfW = new C14110d();
        this.tfX = new C7528b();
        this.tfY = new C7529c();
        this.tfZ = new C14112a();
        this.tfV = c35403x;
        AppMethodBeat.m2505o(45305);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfV;
    }
}

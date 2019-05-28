package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C141135;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C2953710;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295391;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295402;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295413;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C29536z.C295424;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.protocal.protobuf.C35921ha;
import com.tencent.p177mm.protocal.protobuf.bnp;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7625d;
import com.tencent.p177mm.vending.p644j.C7641e;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.aa */
public final class C46335aa implements C24135b<C29536z> {
    protected C29536z tgo;
    public final C40053c tgp;
    public final C22494a tgq;
    public final C29529b tgr;
    public final C46334d tgs;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.aa$a */
    public class C22494a implements C7368e<bqq, C7641e<Integer, Integer, Integer, C35921ha>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45321);
            C7641e c7641e = (C7641e) obj;
            C29536z c29536z = C46335aa.this.tgo;
            int intValue = ((Integer) c7641e.get(0)).intValue();
            int intValue2 = ((Integer) c7641e.get(1)).intValue();
            C35921ha c35921ha = (C35921ha) c7641e.get(3);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "fetchLqt, accountType: %s, %s", Integer.valueOf(intValue2), Integer.valueOf(((Integer) c7641e.get(2)).intValue()));
            C4990ab.m7411d("MicroMsg.LqtSaveFetchLogic", "fetchLqt, amount: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            c29536z.tgi = intValue;
            String stringExtra = c29536z.tgf.getIntent().getStringExtra("operate_id");
            c29536z.accountType = intValue2;
            c29536z.tgf.mo56170mS(true);
            C5698f.m8557a(C5698f.m8553a(Integer.valueOf(intValue), c35921ha, Integer.valueOf(intValue2), Integer.valueOf(r4), stringExtra).mo15892c(c29536z.tge.tfZ).mo15892c(new C141135()));
            AppMethodBeat.m2505o(45321);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.aa$b */
    public class C29529b implements C7368e<C35475y, Integer> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            AppMethodBeat.m2504i(45322);
            Integer num = (Integer) obj;
            C29536z c29536z = C46335aa.this.tgo;
            int intValue = num.intValue();
            c29536z.glt = C5698f.dMj();
            c29536z.glt.dMi();
            WalletLqtSaveFetchUI walletLqtSaveFetchUI = c29536z.tgf;
            if (intValue == 1) {
                i = 24;
            } else {
                i = 25;
            }
            walletLqtSaveFetchUI.mo39970a(new C35475y(null, i), true, false);
            AppMethodBeat.m2505o(45322);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.aa$c */
    public class C40053c implements C7368e<bnp, C7625d<Integer, Integer, Bankcard>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45323);
            C7625d c7625d = (C7625d) obj;
            C29536z c29536z = C46335aa.this.tgo;
            int intValue = ((Integer) c7625d.get(0)).intValue();
            int intValue2 = ((Integer) c7625d.get(1)).intValue();
            Bankcard bankcard = (Bankcard) c7625d.get(2);
            String str = "MicroMsg.LqtSaveFetchLogic";
            String str2 = "saveLqt, accountType: %s, bankcard: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(intValue2);
            objArr[1] = bankcard != null ? bankcard.field_bindSerial : "";
            C4990ab.m7417i(str, str2, objArr);
            C4990ab.m7411d("MicroMsg.LqtSaveFetchLogic", "saveLqt, amount: %s", Integer.valueOf(intValue));
            String stringExtra = c29536z.tgf.getIntent().getStringExtra("lqt_save_fund_code");
            str = c29536z.tgf.getIntent().getStringExtra("lqt_fund_spid");
            str2 = c29536z.tgf.getIntent().getStringExtra("operate_id");
            c29536z.tgh = intValue;
            c29536z.accountType = intValue2;
            c29536z.tgf.mo56170mS(true);
            C5698f.m8557a(C5698f.m8553a(stringExtra, str, Integer.valueOf(intValue), Integer.valueOf(intValue2), str2).mo15892c(c29536z.tge.tfW).mo15892c(new C295424()).mo15892c(new C295413(bankcard)).mo11586a((C5690a) new C295391()));
            AppMethodBeat.m2505o(45323);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.aa$d */
    public class C46334d implements C7368e<Void, C7625d<Integer, Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45325);
            C7625d c7625d = (C7625d) obj;
            C29536z c29536z = C46335aa.this.tgo;
            int intValue = ((Integer) c7625d.get(0)).intValue();
            int intValue2 = ((Integer) c7625d.get(1)).intValue();
            int intValue3 = ((Integer) c7625d.get(2)).intValue();
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            c29536z.glt = C5698f.dMj();
            c29536z.glt.dMi();
            if (intValue == 1) {
                new C41320e(intValue2, intValue3).acy().mo60487b(new C2953710());
            } else {
                new C46336f(intValue2).acy().mo60487b(new C295402());
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45325);
            return voidR;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.UI";
        }

        /* renamed from: gf */
        public final C7361c<Void> mo74550gf(int i, int i2) {
            AppMethodBeat.m2504i(45324);
            C7361c c = C5698f.m8561h(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1)).mo15892c(this);
            AppMethodBeat.m2505o(45324);
            return c;
        }
    }

    public C46335aa() {
        this(new C29536z());
        AppMethodBeat.m2504i(45326);
        AppMethodBeat.m2505o(45326);
    }

    public C46335aa(C29536z c29536z) {
        AppMethodBeat.m2504i(45327);
        this.tgp = new C40053c();
        this.tgq = new C22494a();
        this.tgr = new C29529b();
        this.tgs = new C46334d();
        this.tgo = c29536z;
        AppMethodBeat.m2505o(45327);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tgo;
    }
}

package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtCheckPwdInputDialogUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.protocal.protobuf.bfg;
import com.tencent.p177mm.protocal.protobuf.bfi;
import com.tencent.p177mm.protocal.protobuf.blh;
import com.tencent.p177mm.protocal.protobuf.bmo;
import com.tencent.p177mm.protocal.protobuf.bnp;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z */
public final class C29536z {
    public static int tgb = 123;
    public static int tgc = 456;
    public int accountType;
    public String cAa;
    public C5688b glt;
    private C35403x tgd = null;
    public C14111y tge = null;
    public WalletLqtSaveFetchUI tgf = null;
    public String tgg;
    public int tgh;
    public int tgi;
    public String tgj;
    public Bankcard tgk;
    public Map<String, String> tgl = new HashMap();

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$5 */
    class C141135 implements C5681a<Void, blh> {
        C141135() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45311);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s pre redeem finish: %s", Integer.valueOf(C29536z.this.hashCode()), (blh) obj);
            C29536z.this.tgf.aDw();
            C29536z.this.glt = C5698f.dMj();
            C29536z.this.glt.dMi();
            C29536z.this.tgj = r10.wOn;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s pre redeem finish get redeemListId: %s", Integer.valueOf(C29536z.this.hashCode()), C29536z.this.tgj);
            Intent intent = new Intent(C29536z.this.tgf, WalletLqtCheckPwdInputDialogUI.class);
            intent.putExtra("lqt_fetch_pwd_title", C29536z.this.tgf.getString(C25738R.string.fij));
            intent.putExtra("lqt_fetch_pwd_money", (((double) C29536z.this.tgi) / 100.0d));
            intent.putExtra("lqt_redeem_listid", C29536z.this.tgj);
            C29536z.this.tgf.startActivityForResult(intent, C29536z.tgc);
            Void voidR = zXH;
            AppMethodBeat.m2505o(45311);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$7 */
    public class C141147 implements C5681a<Void, bnp> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45313);
            bnp bnp = (bnp) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult finish: %s", bnp);
            C29536z.this.tgf.aDw();
            C29536z.this.tgf.cNq();
            if (C29536z.this.glt != null) {
                C29536z.this.glt.mo11581B(bnp);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45313);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$6 */
    public class C295346 implements C5690a {
        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(45312);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "doQueryPurchaseResult interrupt: %s", obj);
            C29536z.this.tgf.aDw();
            if (C29536z.this.glt != null) {
                C29536z.this.glt.mo11582cR(obj);
            }
            AppMethodBeat.m2505o(45312);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$8 */
    public class C295358 implements C5690a {
        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(45314);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund interrupt: %s", obj);
            C29536z.this.tgf.aDw();
            if (C29536z.this.glt != null) {
                C29536z.this.glt.mo11582cR(obj);
            }
            AppMethodBeat.m2505o(45314);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$10 */
    class C2953710 implements C5681a<Void, C37441a<bfg>> {
        C2953710() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45317);
            Void d = m46890d((C37441a) obj);
            AppMethodBeat.m2505o(45317);
            return d;
        }

        /* renamed from: d */
        private Void m46890d(C37441a<bfg> c37441a) {
            AppMethodBeat.m2504i(45316);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C14103ab.ach(((bfg) c37441a.fsy).tgu);
                C22496p.tfu.mo38047a(((bfg) c37441a.fsy).wJa, true);
                C22496p.tfu.mo38048a((bfg) c37441a.fsy);
            }
            if (C29536z.this.glt != null) {
                C29536z.this.glt.resume();
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45316);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$9 */
    public class C295389 implements C5681a<Void, bqq> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45315);
            bqq bqq = (bqq) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund finish: %s", Integer.valueOf(C29536z.this.hashCode()), bqq);
            C29536z.this.tgf.aDw();
            C29536z.this.tgf.cNq();
            if (C29536z.this.glt != null) {
                C29536z.this.glt.mo11581B(bqq);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45315);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$1 */
    class C295391 implements C5690a {
        C295391() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(45306);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "onInterrupt %s", obj);
            C29536z.this.tgf.aDw();
            C5698f.dMj().mo11582cR(obj);
            AppMethodBeat.m2505o(45306);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$2 */
    class C295402 implements C5681a<Void, C37441a<bfi>> {
        C295402() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45308);
            Void d = m46892d((C37441a) obj);
            AppMethodBeat.m2505o(45308);
            return d;
        }

        /* renamed from: d */
        private Void m46892d(C37441a<bfi> c37441a) {
            AppMethodBeat.m2504i(45307);
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C14103ab.ach(((bfi) c37441a.fsy).tgu);
                C4319s.cMK().mo9338a((bfi) c37441a.fsy);
                C22496p.tfu.mo38047a(((bfi) c37441a.fsy).wJa, false);
            }
            if (C29536z.this.glt != null) {
                C29536z.this.glt.resume();
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45307);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$3 */
    class C295413 implements C5681a<Void, bmo> {
        final /* synthetic */ Bankcard tgn;

        C295413(Bankcard bankcard) {
            this.tgn = bankcard;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45309);
            bmo bmo = (bmo) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "doSaveLqt, prepayid: %s", bmo.wPy);
            C29536z.this.tgl.put(bmo.wPy, C29536z.this.tgg);
            C29536z.m46883a(C29536z.this, bmo.wPy, this.tgn);
            AppMethodBeat.m2505o(45309);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.z$4 */
    class C295424 implements C5681a<bmo, bmo> {
        C295424() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45310);
            bmo bmo = (bmo) obj;
            C29536z.this.tgg = bmo.vAg;
            C29536z.this.tgf.aDw();
            C4990ab.m7417i("MicroMsg.LqtSaveFetchLogic", "get tradeNo: %s", C29536z.this.tgg);
            AppMethodBeat.m2505o(45310);
            return bmo;
        }
    }

    public C29536z() {
        AppMethodBeat.m2504i(45318);
        AppMethodBeat.m2505o(45318);
    }

    public C29536z(C35403x c35403x, C14111y c14111y, WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.m2504i(45319);
        this.tgd = c35403x;
        this.tge = c14111y;
        this.tgf = walletLqtSaveFetchUI;
        AppMethodBeat.m2505o(45319);
    }

    /* renamed from: a */
    static /* synthetic */ void m46883a(C29536z c29536z, String str, Bankcard bankcard) {
        String str2;
        int i;
        AppMethodBeat.m2504i(45320);
        if (bankcard == null) {
            bankcard = c29536z.tgk;
        }
        c29536z.glt = C5698f.dMj();
        c29536z.glt.dMi();
        WalletLqtSaveFetchUI walletLqtSaveFetchUI = c29536z.tgf;
        if (bankcard != null) {
            str2 = bankcard.field_bindSerial;
        } else {
            str2 = "";
        }
        String str3 = "";
        if (c29536z.accountType == 0) {
            i = 45;
        } else {
            i = 52;
        }
        C35899h.m58855a(walletLqtSaveFetchUI, str2, str, str3, i, tgb);
        AppMethodBeat.m2505o(45320);
    }
}

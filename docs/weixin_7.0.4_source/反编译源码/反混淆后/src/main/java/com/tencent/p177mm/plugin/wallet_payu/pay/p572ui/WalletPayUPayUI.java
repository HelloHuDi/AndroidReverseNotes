package com.tencent.p177mm.plugin.wallet_payu.pay.p572ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32651uu;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletPayUI;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.plugin.wallet_payu.balance.p1316a.C22692b;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C22701b;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C22702d;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C36856c;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C43825e;
import com.tencent.p177mm.plugin.wallet_payu.pay.p572ui.C43826b.C14368b;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C14370a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import java.util.LinkedList;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI */
public class WalletPayUPayUI extends WalletPayUI {
    private String tUa = null;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI$4 */
    class C45004 implements OnClickListener {
        C45004() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48486);
            WalletPayUPayUI.this.tpC.putInt("key_pay_flag", 3);
            WalletPayUPayUI.this.mo41717Q(WalletPayUPayUI.this.tpC);
            AppMethodBeat.m2505o(48486);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI$5 */
    class C143675 implements OnClickListener {
        C143675() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(48487);
            if (WalletPayUPayUI.this.bwP()) {
                WalletPayUPayUI.this.finish();
            }
            AppMethodBeat.m2505o(48487);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI$3 */
    class C355313 implements OnCancelListener {
        C355313() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(48485);
            WalletPayUPayUI.this.gHr = null;
            WalletPayUPayUI.this.tpP = null;
            if (WalletPayUPayUI.this.bwP()) {
                WalletPayUPayUI.this.finish();
            }
            AppMethodBeat.m2505o(48485);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI$2 */
    class C401602 implements View.OnClickListener {
        C401602() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48484);
            WalletPayUPayUI.this.toH = (FavorPayInfo) view.getTag();
            if (WalletPayUPayUI.this.toH != null) {
                WalletPayUPayUI.this.toH.tzf = "";
            }
            WalletPayUPayUI.m68870c(WalletPayUPayUI.this, "");
            WalletPayUPayUI.this.tpP.dismiss();
            WalletPayUPayUI.this.gHr = null;
            WalletPayUPayUI.this.tpP = null;
            AppMethodBeat.m2505o(48484);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI$1 */
    class C401611 implements C14368b {
        C401611() {
        }

        /* renamed from: a */
        public final void mo9564a(String str, String str2, FavorPayInfo favorPayInfo) {
            AppMethodBeat.m2504i(48483);
            WalletPayUPayUI.this.aqX();
            WalletPayUPayUI.this.gHr = str;
            WalletPayUPayUI.this.tUa = str2;
            WalletPayUPayUI.this.mo41734na(false);
            C40148d.cSP();
            AppMethodBeat.m2505o(48483);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: c */
    static /* synthetic */ void m68870c(WalletPayUPayUI walletPayUPayUI, String str) {
        AppMethodBeat.m2504i(48495);
        walletPayUPayUI.mo41721c(false, 0, str);
        AppMethodBeat.m2505o(48495);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48488);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(48488);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(48489);
        C4990ab.m7416i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(48489);
    }

    public final void cNX() {
        AppMethodBeat.m2504i(48490);
        mo39970a(new C36856c(cOl().czZ), cOl().vwf, false);
        mo39970a(new C46358a(cOl().czZ), cOl().vwf, false);
        AppMethodBeat.m2505o(48490);
    }

    public final void cNQ() {
        AppMethodBeat.m2504i(48491);
        if (arW()) {
            C4990ab.m7410d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.tpP = C43826b.m78582a(this, this.pWy, this.toH, this.tgC, new C401611(), new C401602(), new C355313(), "CREDITCARD_PAYU".equals(this.tgC.field_bankcardType));
            AppMethodBeat.m2505o(48491);
            return;
        }
        AppMethodBeat.m2505o(48491);
    }

    /* renamed from: Q */
    public final void mo41717Q(Bundle bundle) {
        boolean z = true;
        AppMethodBeat.m2504i(48492);
        this.tpx = true;
        if (this.pWy != null) {
            bundle.putInt("key_support_bankcard", this.pWy.tuo);
        }
        String str = "key_is_oversea";
        if (cOc()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        C24143a.m37105a(this, C43825e.class, bundle);
        AppMethodBeat.m2505o(48492);
    }

    /* renamed from: na */
    public final void mo41734na(boolean z) {
        AppMethodBeat.m2504i(48493);
        if (this.pVL.cIf == 32 || this.pVL.cIf == 31) {
            int i;
            if (this.pVL.cIf == 32) {
                C4990ab.m7410d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            mo39970a(new C14370a(this.pVL.czZ, this.gHr, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), i, this.pVL.vwh.getString("extinfo_key_1"), this.tgC.field_bindSerial, this.pVL.vwh.getString("extinfo_key_4")), true, false);
            AppMethodBeat.m2505o(48493);
        } else if (this.pVL.cIf == 11) {
            String str = this.gHr;
            String str2 = this.tUa;
            String str3 = this.pVL.czZ;
            double d = this.pVL.vwh.getDouble("total_fee");
            String string = this.pVL.vwh.getString("fee_type");
            String str4 = this.tgC.field_bindSerial;
            String str5 = this.tgC.field_bankcardType;
            C46332s.cNC();
            mo39970a(new C22692b(str, str2, str3, d, string, str4, str5, C46332s.cND().thy.field_bindSerial), true, false);
            AppMethodBeat.m2505o(48493);
        } else {
            mo39970a(new C22701b(this.pVL.czZ, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), this.tgC.field_bankcardType, this.tgC.field_bindSerial, this.tUa, this.gHr), true, true);
            AppMethodBeat.m2505o(48493);
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48494);
        C22701b c22701b;
        if (i == 0 && i2 == 0) {
            Bundle bundle;
            if (c1207m instanceof C36856c) {
                this.pWy = ((C36856c) c1207m).pWy;
                this.mCount = this.pWy != null ? this.pWy.tAq.size() : 0;
                C4990ab.m7410d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.pWy != null ? Integer.valueOf(this.pWy.tuo) : ""));
                arW();
                if (!(this.pWy == null || this.pWy.tAq == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.pWy.tAq) {
                        if (C5046bo.isNullOrNil(commodity.cAa)) {
                            commodity.cAa = this.pVL.czZ;
                        }
                        linkedList.add(commodity.cAa);
                    }
                    if (linkedList.size() > 0) {
                        C32651uu c32651uu = new C32651uu();
                        c32651uu.cRC.cRE = linkedList;
                        C4879a.xxA.mo10055m(c32651uu);
                    }
                    bundle = new Bundle();
                    bundle.putDouble("total_fee", this.pWy.pTN);
                    bundle.putString("fee_type", "ZAR");
                    if (this.pVL.vwh == null) {
                        this.pVL.vwh = bundle;
                    } else {
                        this.pVL.vwh.putAll(bundle);
                    }
                }
            } else if (c1207m instanceof C46358a) {
                C46332s.cNC();
                this.tgB = C46332s.cND().mo38172ng(cOk());
                C46332s.cNC();
                this.tgC = C46332s.cND().mo38130a(null, null, cOk(), false);
                this.pTi.setClickable(true);
                if (!(this.pWy == null || this.tgB == null || this.pVL == null)) {
                    C40148d.m68848a(this.pVL, this.pWy);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.pVL.cIf);
                    objArr[1] = Integer.valueOf(0);
                    C46332s.cNC();
                    objArr[2] = Integer.valueOf(C46332s.cND().cQg() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.pWy.pTN * 100.0d));
                    objArr[4] = this.pWy.pcl;
                    c7060h.mo8381e(10690, objArr);
                }
            } else if (c1207m instanceof C22701b) {
                c22701b = (C22701b) c1207m;
                bundle = this.mBundle;
                bundle.putParcelable("key_pay_info", this.pVL);
                bundle.putParcelable("key_bankcard", this.tgC);
                bundle.putString("key_bank_type", this.tgC.field_bankcardType);
                if (!C5046bo.isNullOrNil(this.gHr)) {
                    bundle.putString("key_pwd1", this.gHr);
                }
                bundle.putString("kreq_token", c22701b.getToken());
                bundle.putParcelable("key_authen", cOb());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.tgC.field_mobile);
                if (c22701b.isSuccess()) {
                    bundle.putParcelable("key_orders", C22702d.m34463a(this.pWy, c22701b.tTW, c22701b.tTX, c22701b.timestamp, c22701b.tDT));
                }
                this.mBundle.putBoolean("key_should_redirect", c22701b.tTU);
                this.mBundle.putString("key_gateway_code", c22701b.tSz);
                this.mBundle.putString("key_gateway_reference", c22701b.tSy);
                this.mBundle.putBoolean("key_should_force_adjust", c22701b.tTV);
                this.mBundle.putString("key_force_adjust_code", c22701b.tSB);
                bundle.putInt("key_pay_flag", 3);
                mo41717Q(bundle);
                AppMethodBeat.m2505o(48494);
                return true;
            } else if (c1207m instanceof C14370a) {
                C14370a c14370a = (C14370a) c1207m;
                bundle = this.mBundle;
                bundle.putParcelable("key_pay_info", this.pVL);
                bundle.putParcelable("key_bankcard", this.tgC);
                bundle.putString("key_bank_type", this.tgC.field_bankcardType);
                if (!C5046bo.isNullOrNil(this.gHr)) {
                    bundle.putString("key_pwd1", this.gHr);
                }
                bundle.putString("kreq_token", c14370a.getToken());
                bundle.putParcelable("key_authen", cOb());
                bundle.putBoolean("key_need_verify_sms", false);
                bundle.putString("key_mobile", this.tgC.field_mobile);
                bundle.putParcelable("key_orders", this.pWy);
                bundle.putInt("key_pay_flag", 3);
                mo41717Q(bundle);
                AppMethodBeat.m2505o(48494);
                return true;
            }
            mo41731cu();
            AppMethodBeat.m2505o(48494);
            return true;
        }
        if (c1207m instanceof C22701b) {
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    c22701b = (C22701b) c1207m;
                    this.tpC = this.mBundle;
                    this.tpC.putParcelable("key_pay_info", this.pVL);
                    this.tpC.putParcelable("key_bankcard", this.tgC);
                    if (!C5046bo.isNullOrNil(this.gHr)) {
                        this.tpC.putString("key_pwd1", this.gHr);
                    }
                    this.tpC.putString("kreq_token", c22701b.getToken());
                    this.tpC.putString("key_mobile", this.tgC.field_mobile);
                    this.tpC.putInt("key_err_code", i2);
                    this.tpC.putParcelable("key_orders", this.pWy);
                    if (C5046bo.isNullOrNil(str)) {
                        string = getString(C25738R.string.fp0);
                    } else {
                        string = str;
                    }
                    C30379h.m48466d(this, string, "", getString(C25738R.string.foz), getString(C25738R.string.f9076or), new C45004(), new C143675());
                    AppMethodBeat.m2505o(48494);
                    return true;
                case 404:
                    if (!(this.tgC == null || this.pWy == null)) {
                        this.tgC.twR = this.pWy.czZ;
                        if (this.tgB == null || this.tgB.size() <= 1) {
                            mo41720b(true, 4, str);
                        } else {
                            mo41721c(true, 4, str);
                        }
                        AppMethodBeat.m2505o(48494);
                        return true;
                    }
                    break;
            }
        }
        AppMethodBeat.m2505o(48494);
        return false;
    }
}

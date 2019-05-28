package com.tencent.p177mm.plugin.wallet_payu.pay.p572ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18325mg;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletChangeBankcardUI;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40128i;
import com.tencent.p177mm.plugin.wallet_payu.balance.p1316a.C22692b;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C22701b;
import com.tencent.p177mm.plugin.wallet_payu.pay.p571a.C22702d;
import com.tencent.p177mm.plugin.wallet_payu.pay.p572ui.C43826b.C14368b;
import com.tencent.p177mm.plugin.wallet_payu.remittance.p1055a.C14370a;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI */
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String tUa = null;
    private C4884c tUb = new C227044();

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI$1 */
    class C44981 implements C14368b {
        C44981() {
        }

        /* renamed from: a */
        public final void mo9564a(String str, String str2, FavorPayInfo favorPayInfo) {
            AppMethodBeat.m2504i(48461);
            WalletPayUChangeBankcardUI.this.toH = favorPayInfo;
            WalletPayUChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.toH);
            WalletPayUChangeBankcardUI.this.gHr = str;
            WalletPayUChangeBankcardUI.this.tUa = str2;
            WalletPayUChangeBankcardUI.this.aqX();
            WalletPayUChangeBankcardUI.this.acs(str);
            AppMethodBeat.m2505o(48461);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI$2 */
    class C227032 implements OnClickListener {
        C227032() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(48462);
            if (WalletPayUChangeBankcardUI.this.toD != null) {
                WalletPayUChangeBankcardUI.this.toD.dismiss();
            }
            WalletPayUChangeBankcardUI.this.toF.mo63459f(WalletPayUChangeBankcardUI.this.tgB, true);
            WalletPayUChangeBankcardUI.this.toH = (FavorPayInfo) view.getTag();
            if (WalletPayUChangeBankcardUI.this.toH != null) {
                WalletPayUChangeBankcardUI.this.toH.tzf = "";
            }
            WalletPayUChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.toH);
            WalletPayUChangeBankcardUI.m34476i(WalletPayUChangeBankcardUI.this);
            WalletPayUChangeBankcardUI.this.mo9439AM(0);
            AppMethodBeat.m2505o(48462);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI$4 */
    class C227044 extends C4884c<C18325mg> {
        C227044() {
            AppMethodBeat.m2504i(48464);
            this.xxI = C18325mg.class.getName().hashCode();
            AppMethodBeat.m2505o(48464);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(48465);
            C18325mg c18325mg = (C18325mg) c4883b;
            C4990ab.m7410d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            C40493g c40493g = new C40493g(c18325mg);
            WalletPayUChangeBankcardUI.this.mBundle.putString("app_id", c40493g.appId);
            WalletPayUChangeBankcardUI.this.mBundle.putString("package", c40493g.packageExt);
            WalletPayUChangeBankcardUI.this.mBundle.putString(Param.TIMESTAMP, c40493g.timeStamp);
            WalletPayUChangeBankcardUI.this.mBundle.putString("noncestr", c40493g.nonceStr);
            WalletPayUChangeBankcardUI.this.mBundle.putString("pay_sign", c40493g.cId);
            WalletPayUChangeBankcardUI.this.mBundle.putString("sign_type", c40493g.signType);
            WalletPayUChangeBankcardUI.this.mBundle.putString("url", c40493g.url);
            WalletPayUChangeBankcardUI.this.mBundle.putBoolean("from_jsapi", true);
            WalletPayUChangeBankcardUI.this.mBundle.putString("key_trans_id", ((PayInfo) WalletPayUChangeBankcardUI.this.mBundle.getParcelable("key_pay_info")).czZ);
            WalletPayUChangeBankcardUI.this.mBundle.putBoolean("key_should_redirect", false);
            C24143a.m37116j(WalletPayUChangeBankcardUI.this, WalletPayUChangeBankcardUI.this.mBundle);
            AppMethodBeat.m2505o(48465);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI$3 */
    class C227053 implements OnCancelListener {
        C227053() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(48463);
            WalletPayUChangeBankcardUI.this.gHr = null;
            if (WalletPayUChangeBankcardUI.this.mController.contentView.getVisibility() != 0) {
                WalletPayUChangeBankcardUI.m34479l(WalletPayUChangeBankcardUI.this);
            }
            AppMethodBeat.m2505o(48463);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletPayUChangeBankcardUI() {
        AppMethodBeat.m2504i(48466);
        AppMethodBeat.m2505o(48466);
    }

    /* renamed from: i */
    static /* synthetic */ void m34476i(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.m2504i(48474);
        walletPayUChangeBankcardUI.mo47845cu();
        AppMethodBeat.m2505o(48474);
    }

    /* renamed from: l */
    static /* synthetic */ void m34479l(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.m2504i(48475);
        walletPayUChangeBankcardUI.bwW();
        AppMethodBeat.m2505o(48475);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48467);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.tUb);
        AppMethodBeat.m2505o(48467);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48468);
        super.onDestroy();
        C4879a.xxA.mo10053d(this.tUb);
        AppMethodBeat.m2505o(48468);
    }

    public final C40128i cNP() {
        AppMethodBeat.m2504i(48469);
        C46385a c46385a = new C46385a(this, this.tgB, this.toE, this.pWy);
        AppMethodBeat.m2505o(48469);
        return c46385a;
    }

    public final void cNQ() {
        AppMethodBeat.m2504i(48470);
        C4990ab.m7410d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.mBundle.getString("key_pwd1");
        if (C5046bo.isNullOrNil(string)) {
            mo9439AM(4);
            this.toD = C43826b.m78582a(this, this.pWy, this.toH, this.tgC, new C44981(), new C227032(), new C227053(), "CREDITCARD_PAYU".equals(this.tgC.field_bankcardType));
            AppMethodBeat.m2505o(48470);
            return;
        }
        acs(string);
        AppMethodBeat.m2505o(48470);
    }

    public final void acs(String str) {
        String str2;
        AppMethodBeat.m2504i(48471);
        this.tms.twc = str;
        if (this.tgC != null) {
            this.mBundle.putString("key_mobile", this.tgC.field_mobile);
            this.mBundle.putParcelable("key_bankcard", this.tgC);
            this.tms.pbo = this.tgC.field_bindSerial;
            this.tms.pbn = this.tgC.field_bankcardType;
            if (this.toH != null) {
                this.tms.two = this.toH.tzb;
            } else {
                this.tms.two = null;
            }
            if (!(this.pWy == null || this.pWy.tAr == null)) {
                this.tms.twn = this.pWy.tAr.tmU;
            }
            if (this.pWy != null && this.pWy.tuo == 3) {
                boolean z;
                if (this.tgC.cPf()) {
                    this.tms.bJt = 3;
                } else {
                    this.tms.bJt = 6;
                }
                Bundle bundle = this.mBundle;
                str2 = "key_is_oversea";
                if (this.tgC.cPf()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.mBundle.putParcelable("key_authen", this.tms);
        if (this.pVL.cIf == 32 || this.pVL.cIf == 31) {
            int i;
            if (this.pVL.cIf == 32) {
                C4990ab.m7410d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            mo39970a(new C14370a(this.pVL.czZ, this.gHr, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), i, this.pVL.vwh.getString("extinfo_key_1"), this.tgC.field_bindSerial, this.pVL.vwh.getString("extinfo_key_4")), true, false);
            AppMethodBeat.m2505o(48471);
        } else if (this.pVL.cIf == 11) {
            String str3 = this.gHr;
            str2 = this.tUa;
            String str4 = this.pVL.czZ;
            double d = this.pVL.vwh.getDouble("total_fee");
            String string = this.pVL.vwh.getString("fee_type");
            String str5 = this.tgC.field_bindSerial;
            String str6 = this.tgC.field_bankcardType;
            C46332s.cNC();
            mo39970a(new C22692b(str3, str2, str4, d, string, str5, str6, C46332s.cND().thy.field_bindSerial), true, false);
            AppMethodBeat.m2505o(48471);
        } else {
            mo39970a(new C22701b(this.pVL.czZ, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), this.tgC.field_bankcardType, this.tgC.field_bindSerial, this.tUa, str), true, true);
            AppMethodBeat.m2505o(48471);
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48472);
        if (i == 0 && i2 == 0 && ((c1207m instanceof C22701b) || (c1207m instanceof C14370a) || (c1207m instanceof C22692b))) {
            Bundle bundle = this.mBundle;
            if (!C5046bo.isNullOrNil(this.gHr)) {
                bundle.putString("key_pwd1", this.gHr);
            }
            bundle.putBoolean("key_need_verify_sms", false);
            bundle.putParcelable("key_pay_info", this.pVL);
            bundle.putInt("key_pay_flag", 3);
            if (c1207m instanceof C22701b) {
                C22701b c22701b = (C22701b) c1207m;
                bundle.putString("transid", c22701b.kBE);
                bundle.putBoolean("key_should_redirect", c22701b.tTU);
                bundle.putString("key_gateway_code", c22701b.tSz);
                bundle.putString("key_gateway_reference", c22701b.tSy);
                bundle.putString("key_force_adjust_code", c22701b.tSB);
                bundle.putBoolean("key_should_force_adjust", c22701b.tTV);
                if (c22701b.isSuccess()) {
                    bundle.putParcelable("key_orders", C22702d.m34463a(this.pWy, c22701b.tTW, c22701b.tTX, c22701b.timestamp, c22701b.tDT));
                }
            }
            if (c1207m instanceof C22692b) {
                C22692b c22692b = (C22692b) c1207m;
                bundle.putString("transid", c22692b.kBE);
                bundle.putBoolean("key_should_redirect", c22692b.tSx);
                bundle.putString("key_gateway_code", c22692b.tSz);
                bundle.putString("key_gateway_reference", c22692b.tSy);
                bundle.putString("key_force_adjust_code", c22692b.tSB);
                bundle.putBoolean("key_should_force_adjust", c22692b.tSA);
            }
            C24143a.m37116j(this, bundle);
            AppMethodBeat.m2505o(48472);
            return true;
        }
        AppMethodBeat.m2505o(48472);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48473);
        if (i == 23351) {
            C4990ab.m7411d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", Integer.valueOf(i2));
            if (i2 == -1) {
                this.mBundle.putBoolean("key_should_redirect", false);
                C24143a.m37116j(this, this.mBundle);
            }
            if (i2 == 0) {
                C24143a.m37113b((Activity) this, this.mBundle, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(48473);
    }
}

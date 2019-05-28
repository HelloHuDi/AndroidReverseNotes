package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.i;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String tUa = null;
    private c tUb = new c<mg>() {
        {
            AppMethodBeat.i(48464);
            this.xxI = mg.class.getName().hashCode();
            AppMethodBeat.o(48464);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(48465);
            mg mgVar = (mg) bVar;
            ab.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            g gVar = new g(mgVar);
            WalletPayUChangeBankcardUI.this.mBundle.putString("app_id", gVar.appId);
            WalletPayUChangeBankcardUI.this.mBundle.putString("package", gVar.packageExt);
            WalletPayUChangeBankcardUI.this.mBundle.putString(Param.TIMESTAMP, gVar.timeStamp);
            WalletPayUChangeBankcardUI.this.mBundle.putString("noncestr", gVar.nonceStr);
            WalletPayUChangeBankcardUI.this.mBundle.putString("pay_sign", gVar.cId);
            WalletPayUChangeBankcardUI.this.mBundle.putString("sign_type", gVar.signType);
            WalletPayUChangeBankcardUI.this.mBundle.putString("url", gVar.url);
            WalletPayUChangeBankcardUI.this.mBundle.putBoolean("from_jsapi", true);
            WalletPayUChangeBankcardUI.this.mBundle.putString("key_trans_id", ((PayInfo) WalletPayUChangeBankcardUI.this.mBundle.getParcelable("key_pay_info")).czZ);
            WalletPayUChangeBankcardUI.this.mBundle.putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.j(WalletPayUChangeBankcardUI.this, WalletPayUChangeBankcardUI.this.mBundle);
            AppMethodBeat.o(48465);
            return true;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPayUChangeBankcardUI() {
        AppMethodBeat.i(48466);
        AppMethodBeat.o(48466);
    }

    static /* synthetic */ void i(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.i(48474);
        walletPayUChangeBankcardUI.cu();
        AppMethodBeat.o(48474);
    }

    static /* synthetic */ void l(WalletPayUChangeBankcardUI walletPayUChangeBankcardUI) {
        AppMethodBeat.i(48475);
        walletPayUChangeBankcardUI.bwW();
        AppMethodBeat.o(48475);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48467);
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xxA.c(this.tUb);
        AppMethodBeat.o(48467);
    }

    public void onDestroy() {
        AppMethodBeat.i(48468);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.tUb);
        AppMethodBeat.o(48468);
    }

    public final i cNP() {
        AppMethodBeat.i(48469);
        a aVar = new a(this, this.tgB, this.toE, this.pWy);
        AppMethodBeat.o(48469);
        return aVar;
    }

    public final void cNQ() {
        AppMethodBeat.i(48470);
        ab.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.mBundle.getString("key_pwd1");
        if (bo.isNullOrNil(string)) {
            AM(4);
            this.toD = b.a(this, this.pWy, this.toH, this.tgC, new b.b() {
                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    AppMethodBeat.i(48461);
                    WalletPayUChangeBankcardUI.this.toH = favorPayInfo;
                    WalletPayUChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.toH);
                    WalletPayUChangeBankcardUI.this.gHr = str;
                    WalletPayUChangeBankcardUI.this.tUa = str2;
                    WalletPayUChangeBankcardUI.this.aqX();
                    WalletPayUChangeBankcardUI.this.acs(str);
                    AppMethodBeat.o(48461);
                }
            }, new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(48462);
                    if (WalletPayUChangeBankcardUI.this.toD != null) {
                        WalletPayUChangeBankcardUI.this.toD.dismiss();
                    }
                    WalletPayUChangeBankcardUI.this.toF.f(WalletPayUChangeBankcardUI.this.tgB, true);
                    WalletPayUChangeBankcardUI.this.toH = (FavorPayInfo) view.getTag();
                    if (WalletPayUChangeBankcardUI.this.toH != null) {
                        WalletPayUChangeBankcardUI.this.toH.tzf = "";
                    }
                    WalletPayUChangeBankcardUI.this.mBundle.putParcelable("key_favor_pay_info", WalletPayUChangeBankcardUI.this.toH);
                    WalletPayUChangeBankcardUI.i(WalletPayUChangeBankcardUI.this);
                    WalletPayUChangeBankcardUI.this.AM(0);
                    AppMethodBeat.o(48462);
                }
            }, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(48463);
                    WalletPayUChangeBankcardUI.this.gHr = null;
                    if (WalletPayUChangeBankcardUI.this.mController.contentView.getVisibility() != 0) {
                        WalletPayUChangeBankcardUI.l(WalletPayUChangeBankcardUI.this);
                    }
                    AppMethodBeat.o(48463);
                }
            }, "CREDITCARD_PAYU".equals(this.tgC.field_bankcardType));
            AppMethodBeat.o(48470);
            return;
        }
        acs(string);
        AppMethodBeat.o(48470);
    }

    public final void acs(String str) {
        String str2;
        AppMethodBeat.i(48471);
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
                ab.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            a(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.pVL.czZ, this.gHr, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), i, this.pVL.vwh.getString("extinfo_key_1"), this.tgC.field_bindSerial, this.pVL.vwh.getString("extinfo_key_4")), true, false);
            AppMethodBeat.o(48471);
        } else if (this.pVL.cIf == 11) {
            String str3 = this.gHr;
            str2 = this.tUa;
            String str4 = this.pVL.czZ;
            double d = this.pVL.vwh.getDouble("total_fee");
            String string = this.pVL.vwh.getString("fee_type");
            String str5 = this.tgC.field_bindSerial;
            String str6 = this.tgC.field_bankcardType;
            s.cNC();
            a(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str3, str2, str4, d, string, str5, str6, s.cND().thy.field_bindSerial), true, false);
            AppMethodBeat.o(48471);
        } else {
            a(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.pVL.czZ, this.pVL.vwh.getDouble("total_fee"), this.pVL.vwh.getString("fee_type"), this.tgC.field_bankcardType, this.tgC.field_bindSerial, this.tUa, str), true, true);
            AppMethodBeat.o(48471);
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48472);
        if (i == 0 && i2 == 0 && ((mVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) || (mVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) || (mVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b))) {
            Bundle bundle = this.mBundle;
            if (!bo.isNullOrNil(this.gHr)) {
                bundle.putString("key_pwd1", this.gHr);
            }
            bundle.putBoolean("key_need_verify_sms", false);
            bundle.putParcelable("key_pay_info", this.pVL);
            bundle.putInt("key_pay_flag", 3);
            if (mVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                com.tencent.mm.plugin.wallet_payu.pay.a.b bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) mVar;
                bundle.putString("transid", bVar.kBE);
                bundle.putBoolean("key_should_redirect", bVar.tTU);
                bundle.putString("key_gateway_code", bVar.tSz);
                bundle.putString("key_gateway_reference", bVar.tSy);
                bundle.putString("key_force_adjust_code", bVar.tSB);
                bundle.putBoolean("key_should_force_adjust", bVar.tTV);
                if (bVar.isSuccess()) {
                    bundle.putParcelable("key_orders", d.a(this.pWy, bVar.tTW, bVar.tTX, bVar.timestamp, bVar.tDT));
                }
            }
            if (mVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
                com.tencent.mm.plugin.wallet_payu.balance.a.b bVar2 = (com.tencent.mm.plugin.wallet_payu.balance.a.b) mVar;
                bundle.putString("transid", bVar2.kBE);
                bundle.putBoolean("key_should_redirect", bVar2.tSx);
                bundle.putString("key_gateway_code", bVar2.tSz);
                bundle.putString("key_gateway_reference", bVar2.tSy);
                bundle.putString("key_force_adjust_code", bVar2.tSB);
                bundle.putBoolean("key_should_force_adjust", bVar2.tSA);
            }
            com.tencent.mm.wallet_core.a.j(this, bundle);
            AppMethodBeat.o(48472);
            return true;
        }
        AppMethodBeat.o(48472);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48473);
        if (i == 23351) {
            ab.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", Integer.valueOf(i2));
            if (i2 == -1) {
                this.mBundle.putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.j(this, this.mBundle);
            }
            if (i2 == 0) {
                com.tencent.mm.wallet_core.a.b((Activity) this, this.mBundle, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(48473);
    }
}

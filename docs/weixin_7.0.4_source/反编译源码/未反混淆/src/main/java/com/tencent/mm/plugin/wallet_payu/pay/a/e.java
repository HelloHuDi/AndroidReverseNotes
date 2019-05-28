package com.tencent.mm.plugin.wallet_payu.pay.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.b.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI;
import com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUOrderInfoUI;
import com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUPayUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.ttpic.VError;

public class e extends a {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48449);
        bundle.putInt("key_pay_scene", ((PayInfo) bundle.getParcelable("key_pay_info")).cIf);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
            case VError.ERROR_DETECTOR_INSTANCE_INIT /*-1003*/:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletPayUChangeBankcardUI.class, bundle);
                AppMethodBeat.o(48449);
                break;
            default:
                ab.d("MicroMsg.PayUPayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
                switch (bundle.getInt("key_pay_flag", 0)) {
                    case 3:
                        i(activity, bundle);
                        break;
                }
                AppMethodBeat.o(48449);
                break;
        }
        return this;
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48451);
        ab.d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            AppMethodBeat.o(48451);
            return;
        }
        F(activity);
        AppMethodBeat.o(48451);
    }

    public final void b(Activity activity, Bundle bundle) {
        int i = -1;
        AppMethodBeat.i(48452);
        ab.d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        int i2 = this.mqu.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.mqu.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.mqu.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.mqu.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.mqu.getString("intent_wap_pay_jump_url"));
            intent.putExtras(bundle2);
        }
        uv uvVar = new uv();
        uvVar.cRF.intent = intent;
        uv.a aVar = uvVar.cRF;
        if (!this.mqu.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.result = i;
        com.tencent.mm.sdk.b.a.xxA.m(uvVar);
        a(activity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i2, intent, false);
        AppMethodBeat.o(48452);
    }

    private void i(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48453);
        if (bundle.getBoolean("key_should_redirect", false)) {
            bundle.getString("key_gateway_code");
            b(activity, bundle.getString("key_gateway_reference"), bundle.getBoolean("key_should_force_adjust"), bundle.getString("key_force_adjust_code"));
            AppMethodBeat.o(48453);
            return;
        }
        f(activity, bundle);
        AppMethodBeat.o(48453);
    }

    private static void b(Context context, String str, boolean z, String str2) {
        AppMethodBeat.i(48454);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("shouldForceViewPort", z);
        intent.putExtra("pay_channel", 2);
        intent.putExtra("view_port_code", str2);
        d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 23351);
        AppMethodBeat.o(48454);
    }

    private void f(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48455);
        int i = bundle.getInt("key_pay_scene", 6);
        if (i == 11 || i == 21) {
            b(activity, WalletPayUBalanceResultUI.class, bundle);
            AppMethodBeat.o(48455);
        } else if (i == 31 || i == 32 || i == 33) {
            a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
            AppMethodBeat.o(48455);
        } else {
            b(activity, WalletPayUOrderInfoUI.class, bundle);
            AppMethodBeat.o(48455);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48456);
        ab.d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        switch (this.mqu.getInt("key_pay_flag", 0)) {
            case 3:
                AppMethodBeat.o(48456);
                break;
            default:
                AppMethodBeat.o(48456);
                break;
        }
        return false;
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48457);
        g anonymousClass2;
        if (mMActivity instanceof WalletPayUPayUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(48446);
                    PayInfo payInfo = (PayInfo) this.hwd.getIntent().getParcelableExtra("key_pay_info");
                    if (payInfo == null || bo.isNullOrNil(payInfo.czZ)) {
                        AppMethodBeat.o(48446);
                        return false;
                    }
                    this.Agm.a(new c(payInfo.czZ), payInfo.vwf, 1);
                    this.Agm.a(new com.tencent.mm.plugin.wallet_core.c.b.a(), payInfo.vwf, 1);
                    AppMethodBeat.o(48446);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(48457);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletPayUBalanceResultUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(48447);
                    Orders orders = (Orders) objArr[0];
                    s.cNC();
                    Bankcard bankcard = s.cND().thy;
                    bankcard.twS += orders.pTN;
                    AppMethodBeat.o(48447);
                    return false;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(48448);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.f9n);
                            AppMethodBeat.o(48448);
                            return string;
                        case 1:
                            string = this.hwd.getString(R.string.f9m);
                            AppMethodBeat.o(48448);
                            return string;
                        default:
                            string = super.Au(i);
                            AppMethodBeat.o(48448);
                            return string;
                    }
                }
            };
            AppMethodBeat.o(48457);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(48457);
            return anonymousClass2;
        }
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.fon;
    }

    public final String bxP() {
        return "PayUPayProcess";
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        int i2 = 1;
        AppMethodBeat.i(48450);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletPayUChangeBankcardUI.class, bundle);
                break;
            case VError.ERROR_DETECTOR_INSTANCE_INIT /*-1003*/:
                com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_payu.bind.model.c.class, bundle);
                break;
            case 402:
            case 403:
            case 408:
                b(activity, bundle);
                break;
            default:
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            ab.i("MicroMsg.PayUPayProcess", "deal with the err!");
            AppMethodBeat.o(48450);
            return;
        }
        if (bundle.containsKey("key_pay_flag")) {
            i2 = bundle.getInt("key_pay_flag", 0);
        } else {
            i2 = this.mqu.getInt("key_pay_flag", 0);
        }
        ab.d("MicroMsg.PayUPayProcess", "forward pay_flag : ".concat(String.valueOf(i2)));
        switch (i2) {
            case 3:
                if (!(activity instanceof WalletPayUVerifyCodeUI)) {
                    if (!(activity instanceof WalletPayUChangeBankcardUI)) {
                        if (!(activity instanceof WalletPayUBalanceResultUI)) {
                            super.a(activity, 0, bundle);
                            break;
                        }
                        Intent intent = new Intent(activity, WalletPayUBalanceManagerUI.class);
                        intent.putExtras(new Bundle());
                        intent.getExtras().putAll(bundle);
                        a(activity, WalletPayUBalanceManagerUI.class, intent);
                        AppMethodBeat.o(48450);
                        return;
                    }
                    i(activity, bundle);
                    AppMethodBeat.o(48450);
                    return;
                }
                f(activity, bundle);
                AppMethodBeat.o(48450);
                return;
        }
        AppMethodBeat.o(48450);
    }
}

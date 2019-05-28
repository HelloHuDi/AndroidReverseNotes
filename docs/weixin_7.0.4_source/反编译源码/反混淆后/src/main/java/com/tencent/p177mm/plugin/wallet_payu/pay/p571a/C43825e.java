package com.tencent.p177mm.plugin.wallet_payu.pay.p571a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C32652uv.C18418a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p560b.C22557a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;
import com.tencent.p177mm.plugin.wallet_payu.balance.p567ui.WalletPayUBalanceManagerUI;
import com.tencent.p177mm.plugin.wallet_payu.balance.p567ui.WalletPayUBalanceResultUI;
import com.tencent.p177mm.plugin.wallet_payu.bind.model.C14361c;
import com.tencent.p177mm.plugin.wallet_payu.create.p569ui.WalletPayUVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_payu.pay.p572ui.WalletPayUChangeBankcardUI;
import com.tencent.p177mm.plugin.wallet_payu.pay.p572ui.WalletPayUOrderInfoUI;
import com.tencent.p177mm.plugin.wallet_payu.pay.p572ui.WalletPayUPayUI;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import com.tencent.ttpic.VError;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.a.e */
public class C43825e extends C22557a {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48449);
        bundle.putInt("key_pay_scene", ((PayInfo) bundle.getParcelable("key_pay_info")).cIf);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
            case VError.ERROR_DETECTOR_INSTANCE_INIT /*-1003*/:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                mo64571b(activity, WalletPayUChangeBankcardUI.class, bundle);
                AppMethodBeat.m2505o(48449);
                break;
            default:
                C4990ab.m7410d("MicroMsg.PayUPayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
                switch (bundle.getInt("key_pay_flag", 0)) {
                    case 3:
                        m78573i(activity, bundle);
                        break;
                }
                AppMethodBeat.m2505o(48449);
                break;
        }
        return this;
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48451);
        C4990ab.m7410d("MicroMsg.PayUPayProcess", "bakck pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
            AppMethodBeat.m2505o(48451);
            return;
        }
        mo55241F(activity);
        AppMethodBeat.m2505o(48451);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        int i = -1;
        AppMethodBeat.m2504i(48452);
        C4990ab.m7410d("MicroMsg.PayUPayProcess", "end pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
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
        C32652uv c32652uv = new C32652uv();
        c32652uv.cRF.intent = intent;
        C18418a c18418a = c32652uv.cRF;
        if (!this.mqu.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        c18418a.result = i;
        C4879a.xxA.mo10055m(c32652uv);
        mo64564a(activity, "wallet_payu", ".pay.ui.WalletPayUPayUI", i2, intent, false);
        AppMethodBeat.m2505o(48452);
    }

    /* renamed from: i */
    private void m78573i(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48453);
        if (bundle.getBoolean("key_should_redirect", false)) {
            bundle.getString("key_gateway_code");
            C43825e.m78571b(activity, bundle.getString("key_gateway_reference"), bundle.getBoolean("key_should_force_adjust"), bundle.getString("key_force_adjust_code"));
            AppMethodBeat.m2505o(48453);
            return;
        }
        m78572f(activity, bundle);
        AppMethodBeat.m2505o(48453);
    }

    /* renamed from: b */
    private static void m78571b(Context context, String str, boolean z, String str2) {
        AppMethodBeat.m2504i(48454);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("shouldForceViewPort", z);
        intent.putExtra("pay_channel", 2);
        intent.putExtra("view_port_code", str2);
        C25985d.m41468b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 23351);
        AppMethodBeat.m2505o(48454);
    }

    /* renamed from: f */
    private void m78572f(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48455);
        int i = bundle.getInt("key_pay_scene", 6);
        if (i == 11 || i == 21) {
            mo64571b(activity, WalletPayUBalanceResultUI.class, bundle);
            AppMethodBeat.m2505o(48455);
        } else if (i == 31 || i == 32 || i == 33) {
            mo64566a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
            AppMethodBeat.m2505o(48455);
        } else {
            mo64571b(activity, WalletPayUOrderInfoUI.class, bundle);
            AppMethodBeat.m2505o(48455);
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48456);
        C4990ab.m7410d("MicroMsg.PayUPayProcess", "needupdatebankcardlist pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        switch (this.mqu.getInt("key_pay_flag", 0)) {
            case 3:
                AppMethodBeat.m2505o(48456);
                break;
            default:
                AppMethodBeat.m2505o(48456);
                break;
        }
        return false;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48457);
        C44432g c44972;
        if (mMActivity instanceof WalletPayUPayUI) {
            C143661 c143661 = new C44432g(mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(48446);
                    PayInfo payInfo = (PayInfo) this.hwd.getIntent().getParcelableExtra("key_pay_info");
                    if (payInfo == null || C5046bo.isNullOrNil(payInfo.czZ)) {
                        AppMethodBeat.m2505o(48446);
                        return false;
                    }
                    this.Agm.mo49367a(new C36856c(payInfo.czZ), payInfo.vwf, 1);
                    this.Agm.mo49367a(new C46358a(), payInfo.vwf, 1);
                    AppMethodBeat.m2505o(48446);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(48457);
            return c143661;
        } else if (mMActivity instanceof WalletPayUBalanceResultUI) {
            c44972 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48447);
                    Orders orders = (Orders) objArr[0];
                    C46332s.cNC();
                    Bankcard bankcard = C46332s.cND().thy;
                    bankcard.twS += orders.pTN;
                    AppMethodBeat.m2505o(48447);
                    return false;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(48448);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.f9n);
                            AppMethodBeat.m2505o(48448);
                            return string;
                        case 1:
                            string = this.hwd.getString(C25738R.string.f9m);
                            AppMethodBeat.m2505o(48448);
                            return string;
                        default:
                            string = super.mo9364Au(i);
                            AppMethodBeat.m2505o(48448);
                            return string;
                    }
                }
            };
            AppMethodBeat.m2505o(48457);
            return c44972;
        } else {
            c44972 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48457);
            return c44972;
        }
    }

    /* renamed from: a */
    public final boolean mo26470a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.fon;
    }

    public final String bxP() {
        return "PayUPayProcess";
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        int i2 = 1;
        AppMethodBeat.m2504i(48450);
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                mo64571b(activity, WalletPayUChangeBankcardUI.class, bundle);
                break;
            case VError.ERROR_DETECTOR_INSTANCE_INIT /*-1003*/:
                C24143a.m37105a(activity, C14361c.class, bundle);
                break;
            case 402:
            case 403:
            case 408:
                mo8125b(activity, bundle);
                break;
            default:
                i2 = 0;
                break;
        }
        if (i2 != 0) {
            C4990ab.m7416i("MicroMsg.PayUPayProcess", "deal with the err!");
            AppMethodBeat.m2505o(48450);
            return;
        }
        if (bundle.containsKey("key_pay_flag")) {
            i2 = bundle.getInt("key_pay_flag", 0);
        } else {
            i2 = this.mqu.getInt("key_pay_flag", 0);
        }
        C4990ab.m7410d("MicroMsg.PayUPayProcess", "forward pay_flag : ".concat(String.valueOf(i2)));
        switch (i2) {
            case 3:
                if (!(activity instanceof WalletPayUVerifyCodeUI)) {
                    if (!(activity instanceof WalletPayUChangeBankcardUI)) {
                        if (!(activity instanceof WalletPayUBalanceResultUI)) {
                            super.mo8124a(activity, 0, bundle);
                            break;
                        }
                        Intent intent = new Intent(activity, WalletPayUBalanceManagerUI.class);
                        intent.putExtras(new Bundle());
                        intent.getExtras().putAll(bundle);
                        mo64561a(activity, WalletPayUBalanceManagerUI.class, intent);
                        AppMethodBeat.m2505o(48450);
                        return;
                    }
                    m78573i(activity, bundle);
                    AppMethodBeat.m2505o(48450);
                    return;
                }
                m78572f(activity, bundle);
                AppMethodBeat.m2505o(48450);
                return;
        }
        AppMethodBeat.m2505o(48450);
    }
}

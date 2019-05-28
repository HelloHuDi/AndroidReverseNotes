package com.tencent.p177mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p230g.p231a.C32652uv.C18418a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceManagerUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceResultUI;
import com.tencent.p177mm.plugin.wallet.bind.p553ui.WalletResetInfoUI;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pay.p554a.C40071a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1047b.C43765b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C22531f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C29595b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C14157b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C29593c;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C14160b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C14161c;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C14162d;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C31457j;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C31576i;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C40076f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C40077h;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C4363a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C46351e;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p556e.C46352g;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletChangeBankcardUI;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletPayUI;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p560b.C22557a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardElementUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletOrderInfoUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSelectBankcardUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSwitchVerifyPhoneUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyIdCardUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C23395gz;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p649c.C36379x;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.VError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet.pay.b */
public class C14167b extends C22557a {
    private List<WeakReference<WalletBaseUI>> tnV = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.wallet.pay.b$a */
    abstract class C14168a extends C46353c {
        public C14168a(WalletBaseUI walletBaseUI, C30868i c30868i) {
            super(walletBaseUI, c30868i);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pay.b$1 */
    class C141821 implements Runnable {
        C141821() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45862);
            for (WeakReference weakReference : C14167b.this.tnV) {
                WalletBaseUI walletBaseUI = (WalletBaseUI) weakReference.get();
                if (!(walletBaseUI == null || walletBaseUI.Ahy)) {
                    C4990ab.m7417i("MicroMsg.PayProcess", "do finish activity: %s", walletBaseUI);
                    walletBaseUI.finish();
                }
            }
            C14167b.this.tnV.clear();
            AppMethodBeat.m2505o(45862);
        }
    }

    public C14167b() {
        AppMethodBeat.m2504i(45892);
        AppMethodBeat.m2505o(45892);
    }

    /* renamed from: i */
    static /* synthetic */ String m22340i(C14167b c14167b) {
        AppMethodBeat.m2504i(45906);
        String cNH = c14167b.cNH();
        AppMethodBeat.m2505o(45906);
        return cNH;
    }

    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45893);
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.cIf);
        bundle.putInt("key_pay_channel", payInfo.cIb);
        if (m22335e(activity, bundle)) {
            C4990ab.m7420w("MicroMsg.PayProcess", "hy: has err. return");
            AppMethodBeat.m2505o(45893);
        } else {
            int i = bundle.getInt("key_pay_flag", 0);
            if ((i == 2 || i == 1) && payInfo.cIf == 11) {
                C36379x.m59950QN(13);
            }
            C4990ab.m7416i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    C4990ab.m7416i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    mo64571b(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    C4990ab.m7416i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    mo64571b(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !cRY()) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "domestic and verify sms!");
                        mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    C4990ab.m7416i("MicroMsg.PayProcess", "jump to result ui!");
                    m22337f(activity, bundle);
                    break;
            }
            AppMethodBeat.m2505o(45893);
        }
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(45894);
        if (m22335e(activity, bundle)) {
            C4990ab.m7416i("MicroMsg.PayProcess", "deal with the err!");
            AppMethodBeat.m2505o(45894);
            return;
        }
        int i2;
        if (activity instanceof WalletSwitchVerifyPhoneUI) {
            if (this.mqu.getBoolean("key_forward_to_id_verify", false)) {
                C4990ab.m7416i("MicroMsg.PayProcess", "go to verify id tail");
                mo64571b(activity, WalletVerifyIdCardUI.class, this.mqu);
                AppMethodBeat.m2505o(45894);
                return;
            }
        } else if (activity instanceof WalletVerifyIdCardUI) {
            m22337f(activity, bundle);
        }
        if (bundle.containsKey("key_pay_flag")) {
            i2 = bundle.getInt("key_pay_flag", 0);
        } else {
            i2 = this.mqu.getInt("key_pay_flag", 0);
        }
        C4990ab.m7416i("MicroMsg.PayProcess", "forward pay_flag : ".concat(String.valueOf(i2)));
        switch (i2) {
            case 1:
                C4990ab.m7416i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    mo64571b(activity, WalletPwdConfirmUI.class, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    m22337f(activity, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (cRY()) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "oversea, set pwd");
                        mo64571b(activity, WalletSetPasswordUI.class, bundle);
                        AppMethodBeat.m2505o(45894);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.PayProcess", "domestic, verify code");
                    mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    mo64559a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else {
                    super.mo8124a(activity, 0, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                }
            case 2:
                C4990ab.m7416i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    mo64571b(activity, WalletBankcardIdUI.class, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    m22337f(activity, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (cRY()) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        m22337f(activity, bundle);
                        AppMethodBeat.m2505o(45894);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.PayProcess", "domestic, verify code!");
                    mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    mo64559a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    AppMethodBeat.m2505o(45894);
                    return;
                } else {
                    super.mo8124a(activity, 0, bundle);
                    AppMethodBeat.m2505o(45894);
                    return;
                }
            case 3:
                C4990ab.m7416i("MicroMsg.PayProcess", "forwardBound()");
                if (!(activity instanceof WalletVerifyCodeUI)) {
                    if (!(activity instanceof WalletResetInfoUI) && !(activity instanceof WalletChangeBankcardUI)) {
                        if (!(activity instanceof WalletBalanceResultUI)) {
                            if (!(activity instanceof WalletSelectBankcardUI) && !(activity instanceof WalletSwitchVerifyPhoneUI)) {
                                super.mo8124a(activity, 0, bundle);
                                break;
                            }
                            C4990ab.m7416i("MicroMsg.PayProcess", "need verify code after select bank card!");
                            mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                            AppMethodBeat.m2505o(45894);
                            return;
                        }
                        mo64559a(activity, WalletBalanceManagerUI.class, -1, null, true);
                        AppMethodBeat.m2505o(45894);
                        return;
                    } else if ((!bundle.getBoolean("key_need_verify_sms", false) || cRY()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "jump to result ui!");
                        m22337f(activity, bundle);
                        AppMethodBeat.m2505o(45894);
                        return;
                    } else {
                        C4990ab.m7416i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                        mo64571b(activity, WalletVerifyCodeUI.class, bundle);
                        AppMethodBeat.m2505o(45894);
                        return;
                    }
                }
                m22337f(activity, bundle);
                AppMethodBeat.m2505o(45894);
                return;
                break;
        }
        AppMethodBeat.m2505o(45894);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45895);
        C4990ab.m7416i("MicroMsg.PayProcess", "back pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
            AppMethodBeat.m2505o(45895);
            return;
        }
        C36379x.dNV();
        mo55241F(activity);
        AppMethodBeat.m2505o(45895);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        PayInfo payInfo;
        int i = -1;
        AppMethodBeat.m2504i(45896);
        C4990ab.m7416i("MicroMsg.PayProcess", "end pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        C36379x.dNV();
        int i2 = this.mqu.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            payInfo = (PayInfo) this.mqu.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.mqu.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.mqu.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.mqu.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.mqu.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.mqu.getParcelable("key_realname_guide_helper"));
            if (payInfo != null) {
                bundle2.putInt("pay_channel", payInfo.cIb);
            }
            intent.putExtras(bundle2);
        }
        intent.putExtra("key_orders", this.mqu.getParcelable("key_orders"));
        intent.putExtra("key_is_clear_failure", this.mqu.getInt("key_is_clear_failure", -1));
        C32652uv c32652uv = new C32652uv();
        c32652uv.cRF.intent = intent;
        c32652uv.cRF.czZ = cNH();
        C18418a c18418a = c32652uv.cRF;
        if (!this.mqu.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        c18418a.result = i;
        if (c32652uv.cRF.result == 0 && bundle != null) {
            payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo != null) {
                C43765b.m78447ak(payInfo.czZ, payInfo.cIf, payInfo.cIb);
            }
        }
        C4879a.xxA.mo10055m(c32652uv);
        mo64564a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
        AppMethodBeat.m2505o(45896);
    }

    /* renamed from: a */
    public final void mo26469a(WalletBaseUI walletBaseUI) {
        AppMethodBeat.m2504i(45897);
        this.tnV.add(new WeakReference(walletBaseUI));
        AppMethodBeat.m2505o(45897);
    }

    /* renamed from: b */
    public final void mo26471b(WalletBaseUI walletBaseUI) {
        AppMethodBeat.m2504i(45898);
        for (WeakReference weakReference : this.tnV) {
            if (weakReference.get() == walletBaseUI) {
                this.tnV.remove(weakReference);
                AppMethodBeat.m2505o(45898);
                return;
            }
        }
        AppMethodBeat.m2505o(45898);
    }

    public final void cNF() {
        AppMethodBeat.m2504i(45899);
        C5004al.m7442n(new C141821(), 200);
        AppMethodBeat.m2505o(45899);
    }

    private boolean cNG() {
        boolean z;
        AppMethodBeat.m2504i(138085);
        boolean intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(0))).intValue();
        if (C4872b.dnO() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE) {
            z = true;
        } else {
            z = intValue;
        }
        Orders orders = (Orders) this.mqu.getParcelable("key_orders");
        if (z || (orders != null && orders.tAN == 1)) {
            AppMethodBeat.m2505o(138085);
            return true;
        }
        AppMethodBeat.m2505o(138085);
        return false;
    }

    /* renamed from: e */
    private boolean m22335e(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45900);
        C4990ab.m7417i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", Integer.valueOf(bundle.getInt("key_err_code", 0)));
        Bundle bundle2;
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                this.mqu.putInt("key_pay_flag", 3);
                this.mqu.putInt("key_err_code", 0);
                if (cNG()) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("direc_change_bankcard", true);
                    bundle2.putBoolean("send_cancel_event", false);
                    mo64572b(activity, WalletPayUI.class, bundle2, 0);
                } else {
                    mo64571b(activity, WalletChangeBankcardUI.class, bundle);
                }
                AppMethodBeat.m2505o(45900);
                return true;
            case VError.ERROR_DETECTOR_INSTANCE_INIT /*-1003*/:
                C46332s.cNC();
                if (C46332s.cND().cQg()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    mo64571b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    mo64571b(activity, WalletBankcardIdUI.class, bundle);
                }
                AppMethodBeat.m2505o(45900);
                return true;
            case 402:
            case 403:
            case 408:
                Bankcard bankcard = (Bankcard) this.mqu.get("key_bankcard");
                if (bankcard == null || !bankcard.cPc()) {
                    mo64571b(activity, WalletResetInfoUI.class, bundle);
                } else if (C14241r.cPI().cQB() == null || C14241r.cPI().cQB().size() <= 0) {
                    mo64571b(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    C4990ab.m7416i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", C14241r.cPI().cQB());
                    bundle2.putString("key_top_tips", activity.getString(C25738R.string.fss));
                    mo64571b(activity, WalletSelectBankcardUI.class, bundle2);
                }
                AppMethodBeat.m2505o(45900);
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                mo64571b(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                AppMethodBeat.m2505o(45900);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                mo64571b(activity, WalletResetInfoUI.class, bundle);
                AppMethodBeat.m2505o(45900);
                return true;
            default:
                AppMethodBeat.m2505o(45900);
                return false;
        }
    }

    /* renamed from: f */
    private void m22337f(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45901);
        if (this.mqu != null && this.mqu.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.mqu.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        C4990ab.m7417i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", Integer.valueOf(i));
        if (i == 11 || i == 21) {
            mo64571b(activity, WalletBalanceResultUI.class, bundle);
            AppMethodBeat.m2505o(45901);
        } else if (i == 5 || i == 31 || i == 32 || i == 33 || i == 48) {
            PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo == null || payInfo.pPV != 1) {
                mo64566a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
                AppMethodBeat.m2505o(45901);
                return;
            }
            C4990ab.m7416i("MicroMsg.PayProcess", "is busi f2f");
            mo8125b(activity, bundle);
            AppMethodBeat.m2505o(45901);
        } else if (i == 37 || i == 39 || i == 42 || i == 45 || i == 52 || i == 49) {
            mo8125b(activity, bundle);
            AppMethodBeat.m2505o(45901);
        } else {
            mo64571b(activity, WalletOrderInfoUI.class, bundle);
            AppMethodBeat.m2505o(45901);
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45902);
        C4990ab.m7410d("MicroMsg.PayProcess", "pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        boolean z;
        switch (this.mqu.getInt("key_pay_flag", 0)) {
            case 1:
                z = activity instanceof WalletOrderInfoUI;
                AppMethodBeat.m2505o(45902);
                return z;
            case 2:
                z = activity instanceof WalletOrderInfoUI;
                AppMethodBeat.m2505o(45902);
                return z;
            case 3:
                AppMethodBeat.m2505o(45902);
                return false;
            default:
                AppMethodBeat.m2505o(45902);
                return false;
        }
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(45903);
        C44432g c1416412;
        if (mMActivity instanceof WalletPayUI) {
            C1416911 c1416911 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45876);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45876);
                        return true;
                    }
                    AppMethodBeat.m2505o(45876);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416911;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45877);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45877);
                        return true;
                    }
                    AppMethodBeat.m2505o(45877);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45878);
                    this.Agm.mo49367a(new C29619r((String) objArr[0], 4, (String) objArr[1]), true, 1);
                    AppMethodBeat.m2505o(45878);
                    return true;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletBankcardIdUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    AppMethodBeat.m2504i(45879);
                    if (C14167b.this.mqu.getInt("key_pay_scene", 0) == 11) {
                        C46332s.cNC();
                        C14167b.this.mqu.putParcelable("key_history_bankcard", C46332s.cND().tCU);
                    }
                    boolean w = super.mo9367w(objArr);
                    AppMethodBeat.m2505o(45879);
                    return w;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45880);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45880);
                        return true;
                    }
                    AppMethodBeat.m2505o(45880);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletCardElementUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45881);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45881);
                        return true;
                    } else if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C14157b) {
                            C14157b c14157b = (C14157b) c1207m;
                            C14167b.this.mqu.putString("kreq_token", c14157b.token);
                            if (c14157b.tpw) {
                                C14167b.this.mqu.putParcelable("key_orders", c14157b.tog);
                            }
                            RealnameGuideHelper realnameGuideHelper = c14157b.oYc;
                            if (realnameGuideHelper != null) {
                                C14167b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                        } else if (c1207m instanceof C29593c) {
                            C29593c c29593c = (C29593c) c1207m;
                            C14167b.this.mqu.putString("kreq_token", c29593c.token);
                            if (c29593c.tpw) {
                                C14167b.this.mqu.putParcelable("key_orders", c29593c.tog);
                            }
                        }
                        if (C14167b.this.mo8128c(this.hwd, null)) {
                            this.Agm.mo49367a(new C35475y(C14167b.m22340i(C14167b.this), 13), true, 1);
                            AppMethodBeat.m2505o(45881);
                            return true;
                        }
                        C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                        AppMethodBeat.m2505o(45881);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(45881);
                        return false;
                    }
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45882);
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    C4990ab.m7416i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + C14167b.this.mqu.getInt("key_pay_flag", 0));
                    switch (C14167b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (C14167b.this.cRY()) {
                                authen.bJt = 4;
                            } else {
                                authen.bJt = 1;
                            }
                            this.Agm.mo49367a(new C14157b(authen, orders), true, 1);
                            AppMethodBeat.m2505o(45882);
                            return true;
                        case 2:
                            if (C14167b.this.cRY()) {
                                authen.bJt = 5;
                            } else {
                                authen.bJt = 2;
                            }
                            if (C14167b.this.mqu.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.Agm.mo49367a(C40071a.m68668b(authen, orders, C14167b.this.mqu.getBoolean("key_isbalance", false)), true, 1);
                            } else {
                                this.Agm.mo49367a(new C14157b(authen, orders), true, 1);
                            }
                            AppMethodBeat.m2505o(45882);
                            return true;
                        case 3:
                            if (C14167b.this.cRY()) {
                                authen.bJt = 6;
                            } else {
                                authen.bJt = 3;
                            }
                            this.Agm.mo49367a(new C14157b(authen, orders), true, 1);
                            AppMethodBeat.m2505o(45882);
                            return true;
                        default:
                            AppMethodBeat.m2505o(45882);
                            return false;
                    }
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45883);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45883);
                        return true;
                    }
                    if (i == 0 && i2 == 0) {
                        if ((c1207m instanceof C22531f) || (c1207m instanceof C29595b)) {
                            C22531f c22531f = (C22531f) c1207m;
                            if (c22531f.tpw) {
                                C14167b.this.mqu.putParcelable("key_orders", c22531f.tog);
                            }
                            RealnameGuideHelper realnameGuideHelper = c22531f.oYc;
                            if (realnameGuideHelper != null) {
                                C14167b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            C7060h.pYm.mo8381e(10707, Integer.valueOf(1), Integer.valueOf(C40148d.cSQ()));
                            AppMethodBeat.m2505o(45883);
                            return false;
                        } else if (c1207m instanceof C14157b) {
                            AppMethodBeat.m2505o(45883);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(45883);
                    return false;
                }

                /* JADX WARNING: Missing block: B:10:0x0085, code skipped:
            if (r3.equals(com.tencent.p177mm.plugin.wallet.p748a.C46332s.cND().tCZ.field_bankcardType) != false) goto L_0x0087;
     */
                /* JADX WARNING: Missing block: B:25:0x00d5, code skipped:
            if (r3.equals(com.tencent.p177mm.plugin.wallet.p748a.C46332s.cND().tCZ.field_bankcardType) != false) goto L_0x00d7;
     */
                /* JADX WARNING: Missing block: B:41:0x012c, code skipped:
            if (r3.equals(com.tencent.p177mm.plugin.wallet.p748a.C46332s.cND().tCZ.field_bankcardType) != false) goto L_0x012e;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45884);
                    C14264s c14264s = (C14264s) objArr[1];
                    Orders orders = (Orders) C14167b.this.mqu.getParcelable("key_orders");
                    C4990ab.m7416i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + C14167b.this.mqu.getInt("key_pay_flag", 0));
                    boolean z = C14167b.this.mqu.getBoolean("key_is_changing_balance_phone_num");
                    String str;
                    C22531f a;
                    switch (C14167b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            c14264s.flag = "1";
                            if (!z) {
                                if (!C5046bo.isNullOrNil(c14264s.pbn)) {
                                    C46332s.cNC();
                                    if (C46332s.cND().tCZ != null) {
                                        str = c14264s.pbn;
                                        C46332s.cNC();
                                        break;
                                    }
                                }
                                a = C40071a.m68667a(c14264s, orders);
                                if (a != null) {
                                    this.Agm.mo49367a(a, true, 1);
                                }
                                AppMethodBeat.m2505o(45884);
                                return true;
                            }
                            this.Agm.mo49367a(new C29595b(c14264s, orders), true, 1);
                            AppMethodBeat.m2505o(45884);
                            return true;
                        case 2:
                            if (C14167b.this.cRY()) {
                                c14264s.flag = "5";
                            } else {
                                c14264s.flag = "2";
                            }
                            if (!z) {
                                if (!C5046bo.isNullOrNil(c14264s.pbn)) {
                                    C46332s.cNC();
                                    if (C46332s.cND().tCZ != null) {
                                        str = c14264s.pbn;
                                        C46332s.cNC();
                                        break;
                                    }
                                }
                                a = C40071a.m68667a(c14264s, orders);
                                if (a != null) {
                                    this.Agm.mo49367a(a, true, 1);
                                }
                                AppMethodBeat.m2505o(45884);
                                return true;
                            }
                            this.Agm.mo49367a(new C29595b(c14264s, orders), true, 1);
                            AppMethodBeat.m2505o(45884);
                            return true;
                        case 3:
                            if (C14167b.this.cRY()) {
                                c14264s.flag = "6";
                            } else {
                                c14264s.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                            }
                            if (!z) {
                                if (!C5046bo.isNullOrNil(c14264s.pbn)) {
                                    C46332s.cNC();
                                    if (C46332s.cND().tCZ != null) {
                                        str = c14264s.pbn;
                                        C46332s.cNC();
                                        break;
                                    }
                                }
                                a = C40071a.m68667a(c14264s, orders);
                                if (a != null) {
                                    this.Agm.mo49367a(a, true, 1);
                                }
                                AppMethodBeat.m2505o(45884);
                                return true;
                            }
                            this.Agm.mo49367a(new C29595b(c14264s, orders), true, 1);
                            AppMethodBeat.m2505o(45884);
                            return true;
                        default:
                            AppMethodBeat.m2505o(45884);
                            return false;
                    }
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletBalanceResultUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45885);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45885);
                        return true;
                    }
                    AppMethodBeat.m2505o(45885);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45886);
                    Orders orders = (Orders) objArr[0];
                    C46332s.cNC();
                    Bankcard bankcard = C46332s.cND().thy;
                    bankcard.twS += orders.pTN;
                    AppMethodBeat.m2505o(45886);
                    return false;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(45887);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.f9n);
                            AppMethodBeat.m2505o(45887);
                            return string;
                        case 1:
                            string = this.hwd.getString(C25738R.string.f9m);
                            AppMethodBeat.m2505o(45887);
                            return string;
                        default:
                            string = super.mo9364Au(i);
                            AppMethodBeat.m2505o(45887);
                            return string;
                    }
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45888);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45888);
                        return true;
                    } else if ((c1207m instanceof C31457j) && i == 0 && i2 == 0) {
                        C31457j c31457j = (C31457j) c1207m;
                        if (c31457j.tpw) {
                            C14167b.this.mqu.putParcelable("key_orders", c31457j.tog);
                        }
                        RealnameGuideHelper realnameGuideHelper = c31457j.oYc;
                        if (realnameGuideHelper != null) {
                            C14167b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                        C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                        AppMethodBeat.m2505o(45888);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(45888);
                        return false;
                    }
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    C1207m c1207m;
                    AppMethodBeat.m2504i(45889);
                    C14264s c14264s = (C14264s) objArr[0];
                    Orders orders = (Orders) C14167b.this.mqu.getParcelable("key_orders");
                    if (c14264s == null || orders == null) {
                        C4990ab.m7412e("MicroMsg.CgiManager", "empty verify or orders");
                        c1207m = null;
                    } else {
                        PayInfo payInfo = c14264s.pGr;
                        String str = "";
                        if (payInfo != null) {
                            C4990ab.m7416i("MicroMsg.CgiManager", "get reqKey from payInfo");
                            str = payInfo.czZ;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7416i("MicroMsg.CgiManager", "get reqKey from orders");
                            str = orders.czZ;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7416i("MicroMsg.CgiManager", "empty reqKey!");
                            c1207m = new C31457j(c14264s, orders);
                        } else {
                            if (payInfo != null) {
                                C4990ab.m7411d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.czZ, orders.czZ);
                            }
                            C4990ab.m7417i("MicroMsg.CgiManager", "verifyreg reqKey: %s", str);
                            C4990ab.m7416i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                            if (str.startsWith("sns_aa_")) {
                                c1207m = new C4363a(c14264s, orders);
                            } else if (str.startsWith("sns_tf_")) {
                                c1207m = new C40077h(c14264s, orders);
                            } else if (str.startsWith("sns_ff_")) {
                                c1207m = new C14161c(c14264s, orders);
                            } else if (str.startsWith("ts_")) {
                                c1207m = new C14162d(c14264s, orders);
                            } else if (str.startsWith("sns_")) {
                                c1207m = new C40076f(c14264s, orders);
                            } else if (str.startsWith("up_")) {
                                c1207m = new C31576i(c14264s, orders);
                            } else if (str.startsWith("seb_ff_")) {
                                c1207m = new C46351e(c14264s, orders);
                            } else if (str.startsWith("tax_")) {
                                c1207m = new C46352g(c14264s, orders);
                            } else if (str.startsWith("dc_")) {
                                c1207m = new C14160b(c14264s, orders);
                            } else {
                                c1207m = new C31457j(c14264s, orders);
                            }
                        }
                    }
                    if (c1207m != null) {
                        this.Agm.mo49367a(c1207m, true, 1);
                    }
                    AppMethodBeat.m2505o(45889);
                    return true;
                }

                /* renamed from: Au */
                public final /* synthetic */ CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(45890);
                    String string = this.hwd.getString(C25738R.string.ftd);
                    AppMethodBeat.m2505o(45890);
                    return string;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletChangeBankcardUI) {
            c1416412 = new C46353c((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45891);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45891);
                        return true;
                    }
                    AppMethodBeat.m2505o(45891);
                    return false;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletSelectBankcardUI) {
            c1416412 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45863);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C29593c)) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
                        C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                        AppMethodBeat.m2505o(45863);
                        return true;
                    }
                    if (i == 0 && i2 == 0 && (c1207m instanceof C14225t)) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
                        cNI();
                    }
                    AppMethodBeat.m2505o(45863);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45864);
                    C4990ab.m7416i("MicroMsg.PayProcess", "onNext for select bank card");
                    C14167b.this.mqu.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) C14167b.this.mqu.getParcelable("key_bankcard");
                    if (bankcard == null) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "directToBindNew()");
                        C14167b.this.mqu.putInt("key_pay_flag", 2);
                        C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                    } else if (C14241r.cPQ().acy(bankcard.field_bankcardType) != null) {
                        cNI();
                    } else {
                        this.Agm.mo49367a(new C14225t("", "", null), true, 1);
                    }
                    AppMethodBeat.m2505o(45864);
                    return false;
                }

                private void cNI() {
                    AppMethodBeat.m2504i(45865);
                    C4990ab.m7416i("MicroMsg.PayProcess", "directToNext()");
                    boolean z = C14167b.this.mqu.getBoolean("key_balance_change_phone_need_confirm_phone", false);
                    Authen authen = (Authen) C14167b.this.mqu.getParcelable("key_authen");
                    Orders orders = (Orders) C14167b.this.mqu.getParcelable("key_orders");
                    Bankcard bankcard = (Bankcard) C14167b.this.mqu.getParcelable("key_bankcard");
                    ElementQuery acy = C14241r.cPQ().acy(bankcard.field_bankcardType);
                    C14167b.this.mqu.putParcelable("elemt_query", acy);
                    if (z) {
                        authen.pbn = bankcard.field_bankcardType;
                        authen.pbo = bankcard.field_bindSerial;
                        C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                        AppMethodBeat.m2505o(45865);
                        return;
                    }
                    authen.tuk = "";
                    authen.pbn = bankcard.field_bankcardType;
                    authen.pbo = bankcard.field_bindSerial;
                    C14167b.this.mqu.putString("key_mobile", bankcard.field_mobile);
                    if (acy == null || acy.tyy || acy.tyz) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
                        C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                        AppMethodBeat.m2505o(45865);
                        return;
                    }
                    this.Agm.mo36581a(C40071a.m68668b(authen, orders, C14167b.this.mqu.getBoolean("key_isbalance", false)), true);
                    AppMethodBeat.m2505o(45865);
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletResetInfoUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: w */
                public final boolean mo9367w(Object... objArr) {
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45866);
                    if (super.mo9365c(i, i2, str, c1207m)) {
                        AppMethodBeat.m2505o(45866);
                        return true;
                    }
                    AppMethodBeat.m2505o(45866);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletSwitchVerifyPhoneUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45867);
                    C4990ab.m7416i("MicroMsg.PayProcess", "start do authen");
                    C23395gz c23395gz = (C23395gz) objArr[0];
                    Authen authen = (Authen) C14167b.this.mqu.getParcelable("key_authen");
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bindSerial = c23395gz.pbo;
                    bankcard.field_mobile = c23395gz.tuk;
                    bankcard.field_desc = c23395gz.nuL;
                    bankcard.field_bankcardType = authen.pbn;
                    C4990ab.m7411d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", authen.pbn, c23395gz.pbo, authen.pbo);
                    C14167b.this.mqu.putString("key_mobile", bankcard.field_mobile);
                    C14167b.this.mqu.putParcelable("key_bankcard", bankcard);
                    Orders orders = (Orders) C14167b.this.mqu.getParcelable("key_orders");
                    authen.twp = c23395gz.vJB;
                    authen.twq = c23395gz.pbo;
                    authen.twr = c23395gz.pbn;
                    authen.tws = "1";
                    C14157b a = C40071a.m68666a(authen, orders, false);
                    if (a != null) {
                        this.Agm.mo49367a(a, true, 1);
                    }
                    AppMethodBeat.m2505o(45867);
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45868);
                    if (c1207m instanceof C14157b) {
                        C4990ab.m7416i("MicroMsg.PayProcess", "finish auth");
                        Authen authen = ((C14157b) c1207m).toh;
                        Orders orders = ((C14157b) c1207m).tog;
                        C14167b.this.mqu.putParcelable("key_authen", authen);
                        C14167b.this.mqu.putParcelable("key_orders", orders);
                        C14167b.this.mqu.putString("kreq_token", ((C14157b) c1207m).token);
                        C14167b.this.mqu.putBoolean("key_is_return_from_switch_phone", true);
                        C14167b.this.mqu.putInt("key_err_code", 0);
                        Bankcard bankcard = (Bankcard) C14167b.this.mqu.getParcelable("key_bankcard");
                        bankcard.field_bankcardType = authen.pbn;
                        bankcard.field_bindSerial = authen.pbo;
                        C14167b.this.mo55241F((Activity) this.hwd);
                        AppMethodBeat.m2505o(45868);
                        return true;
                    }
                    AppMethodBeat.m2505o(45868);
                    return false;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else if (mMActivity instanceof WalletVerifyIdCardUI) {
            c1416412 = new C14168a((WalletBaseUI) mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(45869);
                    if (objArr.length > 0) {
                        this.Agm.mo49367a(C40071a.m68667a((C14264s) objArr[0], (Orders) C14167b.this.mqu.getParcelable("key_orders")), true, 1);
                    }
                    AppMethodBeat.m2505o(45869);
                    return false;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(45870);
                    if (!super.mo9365c(i, i2, str, c1207m) && (c1207m instanceof C22531f)) {
                        C22531f c22531f = (C22531f) c1207m;
                        if (i == 0 && i2 == 0) {
                            if (c22531f.tpw) {
                                C14167b.this.mqu.putParcelable("key_orders", c22531f.tog);
                            }
                            RealnameGuideHelper realnameGuideHelper = c22531f.oYc;
                            if (realnameGuideHelper != null) {
                                C14167b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            C14167b.this.mo8124a(this.hwd, 0, C14167b.this.mqu);
                            this.hwd.finish();
                            AppMethodBeat.m2505o(45870);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(45870);
                    return false;
                }
            };
            AppMethodBeat.m2505o(45903);
            return c1416412;
        } else {
            c1416412 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(45903);
            return c1416412;
        }
    }

    /* renamed from: a */
    public final boolean mo26470a(final WalletBaseUI walletBaseUI, final int i, String str) {
        AppMethodBeat.m2504i(45904);
        C4990ab.m7417i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", Integer.valueOf(i));
        switch (i) {
            case 402:
            case 403:
            case 408:
                if (dNH() && this.mqu.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.mqu.getParcelable("key_bankcard");
                    if (C5046bo.isNullOrNil(str)) {
                        string = walletBaseUI.getString(C25738R.string.fp0, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    C30379h.m48466d(walletBaseUI, string, "", walletBaseUI.getString(C25738R.string.foz), walletBaseUI.getString(C25738R.string.f9076or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(45871);
                            C14167b.this.mqu.putInt("key_pay_flag", 3);
                            C14167b.this.mqu.putInt("key_err_code", i);
                            C14167b.this.mo8124a(walletBaseUI, 0, C14167b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(45871);
                        }
                    }, null);
                    AppMethodBeat.m2505o(45904);
                    return true;
                }
            case 404:
                C4990ab.m7416i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                C46332s.cNC();
                ArrayList cQB = C46332s.cND().cQB();
                if (cQB == null || cQB.isEmpty()) {
                    C30379h.m48466d(walletBaseUI, str, "", walletBaseUI.getString(C25738R.string.fnt), walletBaseUI.getString(C25738R.string.fa6), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(45872);
                            C14167b.this.mqu.putInt("key_err_code", VError.ERROR_DETECTOR_INSTANCE_INIT);
                            C14167b.this.mo8124a(walletBaseUI, 0, C14167b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(45872);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(45873);
                            C14167b.this.mo8125b(walletBaseUI, C14167b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(45873);
                        }
                    });
                } else {
                    C30379h.m48466d(walletBaseUI, str, "", walletBaseUI.getString(C25738R.string.fob), walletBaseUI.getString(C25738R.string.fa6), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(45874);
                            Bankcard bankcard = (Bankcard) C14167b.this.mqu.getParcelable("key_bankcard");
                            PayInfo payInfo = (PayInfo) C14167b.this.mqu.getParcelable("key_pay_info");
                            if (!(bankcard == null || payInfo == null)) {
                                bankcard.twR = payInfo.czZ;
                            }
                            C14167b.this.mqu.putInt("key_err_code", -1004);
                            C14167b.this.mo8124a(walletBaseUI, 0, C14167b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(45874);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(45875);
                            C14167b.this.mo8125b(walletBaseUI, C14167b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.m2505o(45875);
                        }
                    });
                }
                AppMethodBeat.m2505o(45904);
                return true;
        }
        AppMethodBeat.m2505o(45904);
        return false;
    }

    private String cNH() {
        AppMethodBeat.m2504i(45905);
        String str;
        if (this.mqu == null) {
            str = "";
            AppMethodBeat.m2505o(45905);
            return str;
        }
        PayInfo payInfo = (PayInfo) this.mqu.getParcelable("key_pay_info");
        if (payInfo != null) {
            str = payInfo.czZ;
            AppMethodBeat.m2505o(45905);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(45905);
        return str;
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.fom;
    }

    public final String bxP() {
        return "PayProcess";
    }
}

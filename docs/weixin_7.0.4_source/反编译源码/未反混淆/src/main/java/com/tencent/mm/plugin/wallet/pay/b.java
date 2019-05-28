package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.a.e.e;
import com.tencent.mm.plugin.wallet.pay.a.e.j;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyIdCardUI;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.VError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class b extends com.tencent.mm.plugin.wallet_core.b.a {
    private List<WeakReference<WalletBaseUI>> tnV = new ArrayList();

    abstract class a extends c {
        public a(WalletBaseUI walletBaseUI, i iVar) {
            super(walletBaseUI, iVar);
        }
    }

    public b() {
        AppMethodBeat.i(45892);
        AppMethodBeat.o(45892);
    }

    static /* synthetic */ String i(b bVar) {
        AppMethodBeat.i(45906);
        String cNH = bVar.cNH();
        AppMethodBeat.o(45906);
        return cNH;
    }

    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45893);
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.cIf);
        bundle.putInt("key_pay_channel", payInfo.cIb);
        if (e(activity, bundle)) {
            ab.w("MicroMsg.PayProcess", "hy: has err. return");
            AppMethodBeat.o(45893);
        } else {
            int i = bundle.getInt("key_pay_flag", 0);
            if ((i == 2 || i == 1) && payInfo.cIf == 11) {
                x.QN(13);
            }
            ab.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    ab.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    b(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    ab.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    b(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !cRY()) {
                        ab.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    ab.i("MicroMsg.PayProcess", "jump to result ui!");
                    f(activity, bundle);
                    break;
            }
            AppMethodBeat.o(45893);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(45894);
        if (e(activity, bundle)) {
            ab.i("MicroMsg.PayProcess", "deal with the err!");
            AppMethodBeat.o(45894);
            return;
        }
        int i2;
        if (activity instanceof WalletSwitchVerifyPhoneUI) {
            if (this.mqu.getBoolean("key_forward_to_id_verify", false)) {
                ab.i("MicroMsg.PayProcess", "go to verify id tail");
                b(activity, WalletVerifyIdCardUI.class, this.mqu);
                AppMethodBeat.o(45894);
                return;
            }
        } else if (activity instanceof WalletVerifyIdCardUI) {
            f(activity, bundle);
        }
        if (bundle.containsKey("key_pay_flag")) {
            i2 = bundle.getInt("key_pay_flag", 0);
        } else {
            i2 = this.mqu.getInt("key_pay_flag", 0);
        }
        ab.i("MicroMsg.PayProcess", "forward pay_flag : ".concat(String.valueOf(i2)));
        switch (i2) {
            case 1:
                ab.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    b(activity, WalletPwdConfirmUI.class, bundle);
                    AppMethodBeat.o(45894);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    f(activity, bundle);
                    AppMethodBeat.o(45894);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (cRY()) {
                        ab.i("MicroMsg.PayProcess", "oversea, set pwd");
                        b(activity, WalletSetPasswordUI.class, bundle);
                        AppMethodBeat.o(45894);
                        return;
                    }
                    ab.i("MicroMsg.PayProcess", "domestic, verify code");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    AppMethodBeat.o(45894);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    AppMethodBeat.o(45894);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    AppMethodBeat.o(45894);
                    return;
                }
            case 2:
                ab.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                    AppMethodBeat.o(45894);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    f(activity, bundle);
                    AppMethodBeat.o(45894);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (cRY()) {
                        ab.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        f(activity, bundle);
                        AppMethodBeat.o(45894);
                        return;
                    }
                    ab.i("MicroMsg.PayProcess", "domestic, verify code!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    AppMethodBeat.o(45894);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    AppMethodBeat.o(45894);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    AppMethodBeat.o(45894);
                    return;
                }
            case 3:
                ab.i("MicroMsg.PayProcess", "forwardBound()");
                if (!(activity instanceof WalletVerifyCodeUI)) {
                    if (!(activity instanceof WalletResetInfoUI) && !(activity instanceof WalletChangeBankcardUI)) {
                        if (!(activity instanceof WalletBalanceResultUI)) {
                            if (!(activity instanceof WalletSelectBankcardUI) && !(activity instanceof WalletSwitchVerifyPhoneUI)) {
                                super.a(activity, 0, bundle);
                                break;
                            }
                            ab.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                            b(activity, WalletVerifyCodeUI.class, bundle);
                            AppMethodBeat.o(45894);
                            return;
                        }
                        a(activity, WalletBalanceManagerUI.class, -1, null, true);
                        AppMethodBeat.o(45894);
                        return;
                    } else if ((!bundle.getBoolean("key_need_verify_sms", false) || cRY()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        ab.i("MicroMsg.PayProcess", "jump to result ui!");
                        f(activity, bundle);
                        AppMethodBeat.o(45894);
                        return;
                    } else {
                        ab.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        AppMethodBeat.o(45894);
                        return;
                    }
                }
                f(activity, bundle);
                AppMethodBeat.o(45894);
                return;
                break;
        }
        AppMethodBeat.o(45894);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45895);
        ab.i("MicroMsg.PayProcess", "back pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            AppMethodBeat.o(45895);
            return;
        }
        x.dNV();
        F(activity);
        AppMethodBeat.o(45895);
    }

    public final void b(Activity activity, Bundle bundle) {
        PayInfo payInfo;
        int i = -1;
        AppMethodBeat.i(45896);
        ab.i("MicroMsg.PayProcess", "end pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        x.dNV();
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
        uv uvVar = new uv();
        uvVar.cRF.intent = intent;
        uvVar.cRF.czZ = cNH();
        com.tencent.mm.g.a.uv.a aVar = uvVar.cRF;
        if (!this.mqu.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.result = i;
        if (uvVar.cRF.result == 0 && bundle != null) {
            payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo != null) {
                com.tencent.mm.plugin.wallet.pay.a.b.b.ak(payInfo.czZ, payInfo.cIf, payInfo.cIb);
            }
        }
        com.tencent.mm.sdk.b.a.xxA.m(uvVar);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
        AppMethodBeat.o(45896);
    }

    public final void a(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(45897);
        this.tnV.add(new WeakReference(walletBaseUI));
        AppMethodBeat.o(45897);
    }

    public final void b(WalletBaseUI walletBaseUI) {
        AppMethodBeat.i(45898);
        for (WeakReference weakReference : this.tnV) {
            if (weakReference.get() == walletBaseUI) {
                this.tnV.remove(weakReference);
                AppMethodBeat.o(45898);
                return;
            }
        }
        AppMethodBeat.o(45898);
    }

    public final void cNF() {
        AppMethodBeat.i(45899);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(45862);
                for (WeakReference weakReference : b.this.tnV) {
                    WalletBaseUI walletBaseUI = (WalletBaseUI) weakReference.get();
                    if (!(walletBaseUI == null || walletBaseUI.Ahy)) {
                        ab.i("MicroMsg.PayProcess", "do finish activity: %s", walletBaseUI);
                        walletBaseUI.finish();
                    }
                }
                b.this.tnV.clear();
                AppMethodBeat.o(45862);
            }
        }, 200);
        AppMethodBeat.o(45899);
    }

    private boolean cNG() {
        boolean z;
        AppMethodBeat.i(138085);
        boolean intValue = ((Integer) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(0))).intValue();
        if (com.tencent.mm.sdk.a.b.dnO() || f.IS_FLAVOR_RED || f.IS_FLAVOR_PURPLE) {
            z = true;
        } else {
            z = intValue;
        }
        Orders orders = (Orders) this.mqu.getParcelable("key_orders");
        if (z || (orders != null && orders.tAN == 1)) {
            AppMethodBeat.o(138085);
            return true;
        }
        AppMethodBeat.o(138085);
        return false;
    }

    private boolean e(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45900);
        ab.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", Integer.valueOf(bundle.getInt("key_err_code", 0)));
        Bundle bundle2;
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                this.mqu.putInt("key_pay_flag", 3);
                this.mqu.putInt("key_err_code", 0);
                if (cNG()) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("direc_change_bankcard", true);
                    bundle2.putBoolean("send_cancel_event", false);
                    b(activity, WalletPayUI.class, bundle2, 0);
                } else {
                    b(activity, WalletChangeBankcardUI.class, bundle);
                }
                AppMethodBeat.o(45900);
                return true;
            case VError.ERROR_DETECTOR_INSTANCE_INIT /*-1003*/:
                s.cNC();
                if (s.cND().cQg()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletBankcardIdUI.class, bundle);
                }
                AppMethodBeat.o(45900);
                return true;
            case 402:
            case 403:
            case 408:
                Bankcard bankcard = (Bankcard) this.mqu.get("key_bankcard");
                if (bankcard == null || !bankcard.cPc()) {
                    b(activity, WalletResetInfoUI.class, bundle);
                } else if (r.cPI().cQB() == null || r.cPI().cQB().size() <= 0) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    ab.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", r.cPI().cQB());
                    bundle2.putString("key_top_tips", activity.getString(R.string.fss));
                    b(activity, WalletSelectBankcardUI.class, bundle2);
                }
                AppMethodBeat.o(45900);
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                AppMethodBeat.o(45900);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletResetInfoUI.class, bundle);
                AppMethodBeat.o(45900);
                return true;
            default:
                AppMethodBeat.o(45900);
                return false;
        }
    }

    private void f(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45901);
        if (this.mqu != null && this.mqu.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.mqu.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        ab.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", Integer.valueOf(i));
        if (i == 11 || i == 21) {
            b(activity, WalletBalanceResultUI.class, bundle);
            AppMethodBeat.o(45901);
        } else if (i == 5 || i == 31 || i == 32 || i == 33 || i == 48) {
            PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
            if (payInfo == null || payInfo.pPV != 1) {
                a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
                AppMethodBeat.o(45901);
                return;
            }
            ab.i("MicroMsg.PayProcess", "is busi f2f");
            b(activity, bundle);
            AppMethodBeat.o(45901);
        } else if (i == 37 || i == 39 || i == 42 || i == 45 || i == 52 || i == 49) {
            b(activity, bundle);
            AppMethodBeat.o(45901);
        } else {
            b(activity, WalletOrderInfoUI.class, bundle);
            AppMethodBeat.o(45901);
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45902);
        ab.d("MicroMsg.PayProcess", "pay_flag : " + this.mqu.getInt("key_pay_flag", 0));
        boolean z;
        switch (this.mqu.getInt("key_pay_flag", 0)) {
            case 1:
                z = activity instanceof WalletOrderInfoUI;
                AppMethodBeat.o(45902);
                return z;
            case 2:
                z = activity instanceof WalletOrderInfoUI;
                AppMethodBeat.o(45902);
                return z;
            case 3:
                AppMethodBeat.o(45902);
                return false;
            default:
                AppMethodBeat.o(45902);
                return false;
        }
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(45903);
        com.tencent.mm.wallet_core.d.g anonymousClass12;
        if (mMActivity instanceof WalletPayUI) {
            AnonymousClass11 anonymousClass11 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45876);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45876);
                        return true;
                    }
                    AppMethodBeat.o(45876);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass11;
        } else if (mMActivity instanceof WalletCheckPwdUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45877);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45877);
                        return true;
                    }
                    AppMethodBeat.o(45877);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45878);
                    this.Agm.a(new com.tencent.mm.plugin.wallet_core.c.r((String) objArr[0], 4, (String) objArr[1]), true, 1);
                    AppMethodBeat.o(45878);
                    return true;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletBankcardIdUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    AppMethodBeat.i(45879);
                    if (b.this.mqu.getInt("key_pay_scene", 0) == 11) {
                        s.cNC();
                        b.this.mqu.putParcelable("key_history_bankcard", s.cND().tCU);
                    }
                    boolean w = super.w(objArr);
                    AppMethodBeat.o(45879);
                    return w;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45880);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45880);
                        return true;
                    }
                    AppMethodBeat.o(45880);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletCardElementUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45881);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45881);
                        return true;
                    } else if (i == 0 && i2 == 0) {
                        if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) mVar;
                            b.this.mqu.putString("kreq_token", bVar.token);
                            if (bVar.tpw) {
                                b.this.mqu.putParcelable("key_orders", bVar.tog);
                            }
                            RealnameGuideHelper realnameGuideHelper = bVar.oYc;
                            if (realnameGuideHelper != null) {
                                b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                        } else if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.c) {
                            com.tencent.mm.plugin.wallet.pay.a.a.c cVar = (com.tencent.mm.plugin.wallet.pay.a.a.c) mVar;
                            b.this.mqu.putString("kreq_token", cVar.token);
                            if (cVar.tpw) {
                                b.this.mqu.putParcelable("key_orders", cVar.tog);
                            }
                        }
                        if (b.this.c(this.hwd, null)) {
                            this.Agm.a(new y(b.i(b.this), 13), true, 1);
                            AppMethodBeat.o(45881);
                            return true;
                        }
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45881);
                        return true;
                    } else {
                        AppMethodBeat.o(45881);
                        return false;
                    }
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45882);
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    ab.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + b.this.mqu.getInt("key_pay_flag", 0));
                    switch (b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (b.this.cRY()) {
                                authen.bJt = 4;
                            } else {
                                authen.bJt = 1;
                            }
                            this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            AppMethodBeat.o(45882);
                            return true;
                        case 2:
                            if (b.this.cRY()) {
                                authen.bJt = 5;
                            } else {
                                authen.bJt = 2;
                            }
                            if (b.this.mqu.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.Agm.a(com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders, b.this.mqu.getBoolean("key_isbalance", false)), true, 1);
                            } else {
                                this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            }
                            AppMethodBeat.o(45882);
                            return true;
                        case 3:
                            if (b.this.cRY()) {
                                authen.bJt = 6;
                            } else {
                                authen.bJt = 3;
                            }
                            this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, 1);
                            AppMethodBeat.o(45882);
                            return true;
                        default:
                            AppMethodBeat.o(45882);
                            return false;
                    }
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45883);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45883);
                        return true;
                    }
                    if (i == 0 && i2 == 0) {
                        if ((mVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.f) || (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.b)) {
                            com.tencent.mm.plugin.wallet.pay.a.d.f fVar = (com.tencent.mm.plugin.wallet.pay.a.d.f) mVar;
                            if (fVar.tpw) {
                                b.this.mqu.putParcelable("key_orders", fVar.tog);
                            }
                            RealnameGuideHelper realnameGuideHelper = fVar.oYc;
                            if (realnameGuideHelper != null) {
                                b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            h.pYm.e(10707, Integer.valueOf(1), Integer.valueOf(d.cSQ()));
                            AppMethodBeat.o(45883);
                            return false;
                        } else if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            AppMethodBeat.o(45883);
                            return true;
                        }
                    }
                    AppMethodBeat.o(45883);
                    return false;
                }

                /* JADX WARNING: Missing block: B:10:0x0085, code skipped:
            if (r3.equals(com.tencent.mm.plugin.wallet.a.s.cND().tCZ.field_bankcardType) != false) goto L_0x0087;
     */
                /* JADX WARNING: Missing block: B:25:0x00d5, code skipped:
            if (r3.equals(com.tencent.mm.plugin.wallet.a.s.cND().tCZ.field_bankcardType) != false) goto L_0x00d7;
     */
                /* JADX WARNING: Missing block: B:41:0x012c, code skipped:
            if (r3.equals(com.tencent.mm.plugin.wallet.a.s.cND().tCZ.field_bankcardType) != false) goto L_0x012e;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45884);
                    com.tencent.mm.plugin.wallet_core.model.s sVar = (com.tencent.mm.plugin.wallet_core.model.s) objArr[1];
                    Orders orders = (Orders) b.this.mqu.getParcelable("key_orders");
                    ab.i("MicroMsg.PayProcess", "WalletVerifyCodeUI onNext pay_flag : " + b.this.mqu.getInt("key_pay_flag", 0));
                    boolean z = b.this.mqu.getBoolean("key_is_changing_balance_phone_num");
                    String str;
                    com.tencent.mm.plugin.wallet.pay.a.d.f a;
                    switch (b.this.mqu.getInt("key_pay_flag", 0)) {
                        case 1:
                            sVar.flag = "1";
                            if (!z) {
                                if (!bo.isNullOrNil(sVar.pbn)) {
                                    s.cNC();
                                    if (s.cND().tCZ != null) {
                                        str = sVar.pbn;
                                        s.cNC();
                                        break;
                                    }
                                }
                                a = com.tencent.mm.plugin.wallet.pay.a.a.a(sVar, orders);
                                if (a != null) {
                                    this.Agm.a(a, true, 1);
                                }
                                AppMethodBeat.o(45884);
                                return true;
                            }
                            this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(sVar, orders), true, 1);
                            AppMethodBeat.o(45884);
                            return true;
                        case 2:
                            if (b.this.cRY()) {
                                sVar.flag = "5";
                            } else {
                                sVar.flag = "2";
                            }
                            if (!z) {
                                if (!bo.isNullOrNil(sVar.pbn)) {
                                    s.cNC();
                                    if (s.cND().tCZ != null) {
                                        str = sVar.pbn;
                                        s.cNC();
                                        break;
                                    }
                                }
                                a = com.tencent.mm.plugin.wallet.pay.a.a.a(sVar, orders);
                                if (a != null) {
                                    this.Agm.a(a, true, 1);
                                }
                                AppMethodBeat.o(45884);
                                return true;
                            }
                            this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(sVar, orders), true, 1);
                            AppMethodBeat.o(45884);
                            return true;
                        case 3:
                            if (b.this.cRY()) {
                                sVar.flag = "6";
                            } else {
                                sVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                            }
                            if (!z) {
                                if (!bo.isNullOrNil(sVar.pbn)) {
                                    s.cNC();
                                    if (s.cND().tCZ != null) {
                                        str = sVar.pbn;
                                        s.cNC();
                                        break;
                                    }
                                }
                                a = com.tencent.mm.plugin.wallet.pay.a.a.a(sVar, orders);
                                if (a != null) {
                                    this.Agm.a(a, true, 1);
                                }
                                AppMethodBeat.o(45884);
                                return true;
                            }
                            this.Agm.a(new com.tencent.mm.plugin.wallet.pay.a.d.b(sVar, orders), true, 1);
                            AppMethodBeat.o(45884);
                            return true;
                        default:
                            AppMethodBeat.o(45884);
                            return false;
                    }
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletBalanceResultUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45885);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45885);
                        return true;
                    }
                    AppMethodBeat.o(45885);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45886);
                    Orders orders = (Orders) objArr[0];
                    s.cNC();
                    Bankcard bankcard = s.cND().thy;
                    bankcard.twS += orders.pTN;
                    AppMethodBeat.o(45886);
                    return false;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(45887);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(R.string.f9n);
                            AppMethodBeat.o(45887);
                            return string;
                        case 1:
                            string = this.hwd.getString(R.string.f9m);
                            AppMethodBeat.o(45887);
                            return string;
                        default:
                            string = super.Au(i);
                            AppMethodBeat.o(45887);
                            return string;
                    }
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45888);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45888);
                        return true;
                    } else if ((mVar instanceof j) && i == 0 && i2 == 0) {
                        j jVar = (j) mVar;
                        if (jVar.tpw) {
                            b.this.mqu.putParcelable("key_orders", jVar.tog);
                        }
                        RealnameGuideHelper realnameGuideHelper = jVar.oYc;
                        if (realnameGuideHelper != null) {
                            b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                        }
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45888);
                        return true;
                    } else {
                        AppMethodBeat.o(45888);
                        return false;
                    }
                }

                public final boolean p(Object... objArr) {
                    m mVar;
                    AppMethodBeat.i(45889);
                    com.tencent.mm.plugin.wallet_core.model.s sVar = (com.tencent.mm.plugin.wallet_core.model.s) objArr[0];
                    Orders orders = (Orders) b.this.mqu.getParcelable("key_orders");
                    if (sVar == null || orders == null) {
                        ab.e("MicroMsg.CgiManager", "empty verify or orders");
                        mVar = null;
                    } else {
                        PayInfo payInfo = sVar.pGr;
                        String str = "";
                        if (payInfo != null) {
                            ab.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                            str = payInfo.czZ;
                        }
                        if (bo.isNullOrNil(str)) {
                            ab.i("MicroMsg.CgiManager", "get reqKey from orders");
                            str = orders.czZ;
                        }
                        if (bo.isNullOrNil(str)) {
                            ab.i("MicroMsg.CgiManager", "empty reqKey!");
                            mVar = new j(sVar, orders);
                        } else {
                            if (payInfo != null) {
                                ab.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.czZ, orders.czZ);
                            }
                            ab.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", str);
                            ab.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                            if (str.startsWith("sns_aa_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.a(sVar, orders);
                            } else if (str.startsWith("sns_tf_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.h(sVar, orders);
                            } else if (str.startsWith("sns_ff_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.c(sVar, orders);
                            } else if (str.startsWith("ts_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.d(sVar, orders);
                            } else if (str.startsWith("sns_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.f(sVar, orders);
                            } else if (str.startsWith("up_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.i(sVar, orders);
                            } else if (str.startsWith("seb_ff_")) {
                                mVar = new e(sVar, orders);
                            } else if (str.startsWith("tax_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.g(sVar, orders);
                            } else if (str.startsWith("dc_")) {
                                mVar = new com.tencent.mm.plugin.wallet.pay.a.e.b(sVar, orders);
                            } else {
                                mVar = new j(sVar, orders);
                            }
                        }
                    }
                    if (mVar != null) {
                        this.Agm.a(mVar, true, 1);
                    }
                    AppMethodBeat.o(45889);
                    return true;
                }

                public final /* synthetic */ CharSequence Au(int i) {
                    AppMethodBeat.i(45890);
                    String string = this.hwd.getString(R.string.ftd);
                    AppMethodBeat.o(45890);
                    return string;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletChangeBankcardUI) {
            anonymousClass12 = new c((WalletBaseUI) mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45891);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45891);
                        return true;
                    }
                    AppMethodBeat.o(45891);
                    return false;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletSelectBankcardUI) {
            anonymousClass12 = new com.tencent.mm.wallet_core.d.g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45863);
                    if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.c)) {
                        ab.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45863);
                        return true;
                    }
                    if (i == 0 && i2 == 0 && (mVar instanceof t)) {
                        ab.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
                        cNI();
                    }
                    AppMethodBeat.o(45863);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45864);
                    ab.i("MicroMsg.PayProcess", "onNext for select bank card");
                    b.this.mqu.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) b.this.mqu.getParcelable("key_bankcard");
                    if (bankcard == null) {
                        ab.i("MicroMsg.PayProcess", "directToBindNew()");
                        b.this.mqu.putInt("key_pay_flag", 2);
                        b.this.a(this.hwd, 0, b.this.mqu);
                    } else if (r.cPQ().acy(bankcard.field_bankcardType) != null) {
                        cNI();
                    } else {
                        this.Agm.a(new t("", "", null), true, 1);
                    }
                    AppMethodBeat.o(45864);
                    return false;
                }

                private void cNI() {
                    AppMethodBeat.i(45865);
                    ab.i("MicroMsg.PayProcess", "directToNext()");
                    boolean z = b.this.mqu.getBoolean("key_balance_change_phone_need_confirm_phone", false);
                    Authen authen = (Authen) b.this.mqu.getParcelable("key_authen");
                    Orders orders = (Orders) b.this.mqu.getParcelable("key_orders");
                    Bankcard bankcard = (Bankcard) b.this.mqu.getParcelable("key_bankcard");
                    ElementQuery acy = r.cPQ().acy(bankcard.field_bankcardType);
                    b.this.mqu.putParcelable("elemt_query", acy);
                    if (z) {
                        authen.pbn = bankcard.field_bankcardType;
                        authen.pbo = bankcard.field_bindSerial;
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45865);
                        return;
                    }
                    authen.tuk = "";
                    authen.pbn = bankcard.field_bankcardType;
                    authen.pbo = bankcard.field_bindSerial;
                    b.this.mqu.putString("key_mobile", bankcard.field_mobile);
                    if (acy == null || acy.tyy || acy.tyz) {
                        ab.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
                        b.this.a(this.hwd, 0, b.this.mqu);
                        AppMethodBeat.o(45865);
                        return;
                    }
                    this.Agm.a(com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders, b.this.mqu.getBoolean("key_isbalance", false)), true);
                    AppMethodBeat.o(45865);
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletResetInfoUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean w(Object... objArr) {
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45866);
                    if (super.c(i, i2, str, mVar)) {
                        AppMethodBeat.o(45866);
                        return true;
                    }
                    AppMethodBeat.o(45866);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletSwitchVerifyPhoneUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45867);
                    ab.i("MicroMsg.PayProcess", "start do authen");
                    gz gzVar = (gz) objArr[0];
                    Authen authen = (Authen) b.this.mqu.getParcelable("key_authen");
                    Bankcard bankcard = new Bankcard();
                    bankcard.field_bindSerial = gzVar.pbo;
                    bankcard.field_mobile = gzVar.tuk;
                    bankcard.field_desc = gzVar.nuL;
                    bankcard.field_bankcardType = authen.pbn;
                    ab.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", authen.pbn, gzVar.pbo, authen.pbo);
                    b.this.mqu.putString("key_mobile", bankcard.field_mobile);
                    b.this.mqu.putParcelable("key_bankcard", bankcard);
                    Orders orders = (Orders) b.this.mqu.getParcelable("key_orders");
                    authen.twp = gzVar.vJB;
                    authen.twq = gzVar.pbo;
                    authen.twr = gzVar.pbn;
                    authen.tws = "1";
                    com.tencent.mm.plugin.wallet.pay.a.a.b a = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, false);
                    if (a != null) {
                        this.Agm.a(a, true, 1);
                    }
                    AppMethodBeat.o(45867);
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45868);
                    if (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        ab.i("MicroMsg.PayProcess", "finish auth");
                        Authen authen = ((com.tencent.mm.plugin.wallet.pay.a.a.b) mVar).toh;
                        Orders orders = ((com.tencent.mm.plugin.wallet.pay.a.a.b) mVar).tog;
                        b.this.mqu.putParcelable("key_authen", authen);
                        b.this.mqu.putParcelable("key_orders", orders);
                        b.this.mqu.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pay.a.a.b) mVar).token);
                        b.this.mqu.putBoolean("key_is_return_from_switch_phone", true);
                        b.this.mqu.putInt("key_err_code", 0);
                        Bankcard bankcard = (Bankcard) b.this.mqu.getParcelable("key_bankcard");
                        bankcard.field_bankcardType = authen.pbn;
                        bankcard.field_bindSerial = authen.pbo;
                        b.this.F((Activity) this.hwd);
                        AppMethodBeat.o(45868);
                        return true;
                    }
                    AppMethodBeat.o(45868);
                    return false;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else if (mMActivity instanceof WalletVerifyIdCardUI) {
            anonymousClass12 = new a((WalletBaseUI) mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(45869);
                    if (objArr.length > 0) {
                        this.Agm.a(com.tencent.mm.plugin.wallet.pay.a.a.a((com.tencent.mm.plugin.wallet_core.model.s) objArr[0], (Orders) b.this.mqu.getParcelable("key_orders")), true, 1);
                    }
                    AppMethodBeat.o(45869);
                    return false;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(45870);
                    if (!super.c(i, i2, str, mVar) && (mVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.f)) {
                        com.tencent.mm.plugin.wallet.pay.a.d.f fVar = (com.tencent.mm.plugin.wallet.pay.a.d.f) mVar;
                        if (i == 0 && i2 == 0) {
                            if (fVar.tpw) {
                                b.this.mqu.putParcelable("key_orders", fVar.tog);
                            }
                            RealnameGuideHelper realnameGuideHelper = fVar.oYc;
                            if (realnameGuideHelper != null) {
                                b.this.mqu.putParcelable("key_realname_guide_helper", realnameGuideHelper);
                            }
                            b.this.a(this.hwd, 0, b.this.mqu);
                            this.hwd.finish();
                            AppMethodBeat.o(45870);
                            return true;
                        }
                    }
                    AppMethodBeat.o(45870);
                    return false;
                }
            };
            AppMethodBeat.o(45903);
            return anonymousClass12;
        } else {
            anonymousClass12 = super.a(mMActivity, iVar);
            AppMethodBeat.o(45903);
            return anonymousClass12;
        }
    }

    public final boolean a(final WalletBaseUI walletBaseUI, final int i, String str) {
        AppMethodBeat.i(45904);
        ab.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", Integer.valueOf(i));
        switch (i) {
            case 402:
            case 403:
            case 408:
                if (dNH() && this.mqu.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.mqu.getParcelable("key_bankcard");
                    if (bo.isNullOrNil(str)) {
                        string = walletBaseUI.getString(R.string.fp0, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.h.d(walletBaseUI, string, "", walletBaseUI.getString(R.string.foz), walletBaseUI.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45871);
                            b.this.mqu.putInt("key_pay_flag", 3);
                            b.this.mqu.putInt("key_err_code", i);
                            b.this.a(walletBaseUI, 0, b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(45871);
                        }
                    }, null);
                    AppMethodBeat.o(45904);
                    return true;
                }
            case 404:
                ab.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                s.cNC();
                ArrayList cQB = s.cND().cQB();
                if (cQB == null || cQB.isEmpty()) {
                    com.tencent.mm.ui.base.h.d(walletBaseUI, str, "", walletBaseUI.getString(R.string.fnt), walletBaseUI.getString(R.string.fa6), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45872);
                            b.this.mqu.putInt("key_err_code", VError.ERROR_DETECTOR_INSTANCE_INIT);
                            b.this.a(walletBaseUI, 0, b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(45872);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45873);
                            b.this.b(walletBaseUI, b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(45873);
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.h.d(walletBaseUI, str, "", walletBaseUI.getString(R.string.fob), walletBaseUI.getString(R.string.fa6), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45874);
                            Bankcard bankcard = (Bankcard) b.this.mqu.getParcelable("key_bankcard");
                            PayInfo payInfo = (PayInfo) b.this.mqu.getParcelable("key_pay_info");
                            if (!(bankcard == null || payInfo == null)) {
                                bankcard.twR = payInfo.czZ;
                            }
                            b.this.mqu.putInt("key_err_code", -1004);
                            b.this.a(walletBaseUI, 0, b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(45874);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(45875);
                            b.this.b(walletBaseUI, b.this.mqu);
                            if (walletBaseUI.bwP()) {
                                walletBaseUI.finish();
                            }
                            AppMethodBeat.o(45875);
                        }
                    });
                }
                AppMethodBeat.o(45904);
                return true;
        }
        AppMethodBeat.o(45904);
        return false;
    }

    private String cNH() {
        AppMethodBeat.i(45905);
        String str;
        if (this.mqu == null) {
            str = "";
            AppMethodBeat.o(45905);
            return str;
        }
        PayInfo payInfo = (PayInfo) this.mqu.getParcelable("key_pay_info");
        if (payInfo != null) {
            str = payInfo.czZ;
            AppMethodBeat.o(45905);
            return str;
        }
        str = "";
        AppMethodBeat.o(45905);
        return str;
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.fom;
    }

    public final String bxP() {
        return "PayProcess";
    }
}

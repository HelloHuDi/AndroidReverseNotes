package com.tencent.p177mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22540o;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C22542q;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C29602g;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C40078l;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C43776m;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletForgotPwdBindNewUI;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletForgotPwdSelectUI;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletForgotPwdUI;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletForgotPwdVerifyIdUI;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.C22586aj;
import com.tencent.p177mm.plugin.wallet_core.p560b.C22557a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletBankcardIdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCardElementUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletConfirmCardIDUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a */
public class C35452a extends C22557a {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46137);
        C4990ab.m7410d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.mqu;
        String str = "key_is_oversea";
        C46332s.cNC();
        bundle2.putBoolean(str, !C46332s.cND().cQp());
        bundle2 = this.mqu;
        str = "key_support_bankcard";
        C46332s.cNC();
        bundle2.putInt(str, C46332s.cND().cQp() ? 1 : 2);
        this.mqu.putBoolean("key_is_forgot_process", true);
        C46332s.cNC();
        if (C46332s.cND().cQp()) {
            mo64571b(activity, WalletForgotPwdVerifyIdUI.class, bundle);
        } else {
            mo64571b(activity, WalletForgotPwdUI.class, bundle);
        }
        AppMethodBeat.m2505o(46137);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(46138);
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                mo64571b(activity, WalletForgotPwdBindNewUI.class, bundle);
                AppMethodBeat.m2505o(46138);
                return;
            }
            mo64571b(activity, WalletCardElementUI.class, bundle);
            AppMethodBeat.m2505o(46138);
        } else if (activity instanceof WalletCardElementUI) {
            if (cRY()) {
                mo64571b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.m2505o(46138);
                return;
            }
            mo64571b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.m2505o(46138);
        } else if (activity instanceof WalletVerifyCodeUI) {
            mo64571b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.m2505o(46138);
        } else if (activity instanceof WalletSetPasswordUI) {
            mo64571b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.m2505o(46138);
        } else if (activity instanceof WalletPwdConfirmUI) {
            mo8125b(activity, bundle);
            AppMethodBeat.m2505o(46138);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            mo64557F("startActivity2", activity, WalletCardElementUI.class, bundle, "flag: 67108864");
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.mqu.putAll(bundle);
            }
            C4990ab.m7410d("MicroMsg.ProcessManager", "bankcard tag :" + dNE());
            AppMethodBeat.m2505o(46138);
        } else if (!(activity instanceof WalletForgotPwdVerifyIdUI)) {
            if (activity instanceof WalletForgotPwdSelectUI) {
                if (bundle.containsKey("key_select_bank_card") && bundle.getBoolean("key_select_bank_card")) {
                    C4990ab.m7416i("MicroMsg.ProcessManager", "forward select bankcard");
                    mo64571b(activity, WalletForgotPwdUI.class, bundle);
                    AppMethodBeat.m2505o(46138);
                    return;
                }
                C4990ab.m7416i("MicroMsg.ProcessManager", "forward after face check");
                mo64571b(activity, WalletSetPasswordUI.class, bundle);
            }
            AppMethodBeat.m2505o(46138);
        } else if (bundle.containsKey("key_is_support_face") && bundle.getInt("key_is_support_face") == 1) {
            C4990ab.m7416i("MicroMsg.ProcessManager", "forward support face");
            C7060h.pYm.mo8381e(15774, Integer.valueOf(this.mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(1));
            mo64571b(activity, WalletForgotPwdSelectUI.class, bundle);
            AppMethodBeat.m2505o(46138);
        } else {
            C4990ab.m7416i("MicroMsg.ProcessManager", "forward not support face");
            mo64571b(activity, WalletForgotPwdUI.class, bundle);
            AppMethodBeat.m2505o(46138);
        }
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46139);
        C46332s.cNC();
        if (C46332s.cND().cQp()) {
            mo64560a(activity, WalletForgotPwdVerifyIdUI.class, -1, false);
            AppMethodBeat.m2505o(46139);
            return;
        }
        mo64560a(activity, WalletForgotPwdUI.class, -1, false);
        AppMethodBeat.m2505o(46139);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(46140);
        C44432g c225372;
        if (mMActivity instanceof WalletForgotPwdUI) {
            C225361 c225361 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46127);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C35475y)) {
                        C22586aj cRh = C14241r.cPE().cRh();
                        C4990ab.m7417i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", cRh.field_reset_passwd_flag, cRh.field_find_passwd_url);
                        String cQu = C14241r.cPI().cQu();
                        if (!C5046bo.isNullOrNil(cQu)) {
                            C4990ab.m7417i("MicroMsg.ProcessManager", "jump to forget url: %s", cQu);
                            C36391e.m60016n(this.hwd, cQu, false);
                            AppMethodBeat.m2505o(46127);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(46127);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(46140);
            return c225361;
        } else if (mMActivity instanceof WalletForgotPwdVerifyIdUI) {
            c225372 = new C44432g(mMActivity, c30868i) {
                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46128);
                    if (objArr.length == 3) {
                        this.Agm.mo36581a(new C22542q(objArr[0].toString(), ((Integer) objArr[1]).intValue(), (String) objArr[2]), true);
                    }
                    AppMethodBeat.m2505o(46128);
                    return true;
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }
            };
            AppMethodBeat.m2505o(46140);
            return c225372;
        } else if (mMActivity instanceof WalletCardElementUI) {
            c225372 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46129);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C43776m)) {
                        C35452a.this.mqu.putString("kreq_token", ((C43776m) c1207m).token);
                        C35452a.this.mo8124a(this.hwd, 0, C35452a.this.mqu);
                        AppMethodBeat.m2505o(46129);
                        return true;
                    }
                    AppMethodBeat.m2505o(46129);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    int i;
                    AppMethodBeat.m2504i(46130);
                    Authen authen = (Authen) objArr[0];
                    if (C35452a.this.cRY()) {
                        authen.bJt = 4;
                    } else {
                        authen.bJt = 1;
                    }
                    if (C35452a.this.mqu.getBoolean("key_is_paymanager")) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.Agm.mo49367a(new C43776m(authen, C35452a.this.mqu.getBoolean("key_is_reset_with_new_card", false), i), true, 1);
                    AppMethodBeat.m2505o(46130);
                    return true;
                }
            };
            AppMethodBeat.m2505o(46140);
            return c225372;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            c225372 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46131);
                    if (i == 0 && i2 == 0 && (c1207m instanceof C43776m)) {
                        C35452a.this.mqu.putString("kreq_token", ((C43776m) c1207m).token);
                        AppMethodBeat.m2505o(46131);
                        return true;
                    }
                    AppMethodBeat.m2505o(46131);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46132);
                    C14264s c14264s = (C14264s) objArr[1];
                    c14264s.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    this.Agm.mo49367a(new C22540o(c14264s), true, 1);
                    AppMethodBeat.m2505o(46132);
                    return true;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(46133);
                    String string = this.hwd.getString(C25738R.string.gau);
                    AppMethodBeat.m2505o(46133);
                    return string;
                }
            };
            AppMethodBeat.m2505o(46140);
            return c225372;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c225372 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46134);
                    if (i == 0 && i2 == 0 && ((c1207m instanceof C40078l) || (c1207m instanceof C29602g))) {
                        C35452a.this.mo8124a(this.hwd, 0, C35452a.this.mqu);
                        AppMethodBeat.m2505o(46134);
                        return true;
                    }
                    AppMethodBeat.m2505o(46134);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46135);
                    C14264s c14264s = (C14264s) objArr[0];
                    if (C35452a.this.mqu.getBoolean("key_is_set_pwd_after_face_action")) {
                        C4990ab.m7416i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
                        this.Agm.mo49367a(new C29602g(C35452a.this.mqu.getString("key_face_action_result_token"), c14264s.guu), true, 1);
                    } else {
                        C4990ab.m7416i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
                        this.Agm.mo49367a(new C40078l(c14264s), true, 1);
                    }
                    AppMethodBeat.m2505o(46135);
                    return true;
                }
            };
            AppMethodBeat.m2505o(46140);
            return c225372;
        } else {
            c225372 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(46140);
            return c225372;
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    /* renamed from: a */
    public final boolean mo26470a(final WalletBaseUI walletBaseUI, int i, String str) {
        AppMethodBeat.m2504i(46141);
        switch (i) {
            case 404:
                C30379h.m48447a((Context) walletBaseUI, str, null, walletBaseUI.getString(C25738R.string.ff_), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46136);
                        C35452a.this.mo8125b(walletBaseUI, C35452a.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.m2505o(46136);
                    }
                });
                AppMethodBeat.m2505o(46141);
                return true;
            default:
                AppMethodBeat.m2505o(46141);
                return false;
        }
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.ff_;
    }

    public final String bxP() {
        return "ForgotPwdProcess";
    }
}

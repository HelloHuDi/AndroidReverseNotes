package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.pwd.a.l;
import com.tencent.mm.plugin.wallet.pwd.a.o;
import com.tencent.mm.plugin.wallet.pwd.a.q;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdSelectUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdVerifyIdUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class a extends com.tencent.mm.plugin.wallet_core.b.a {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46137);
        ab.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.mqu;
        String str = "key_is_oversea";
        s.cNC();
        bundle2.putBoolean(str, !s.cND().cQp());
        bundle2 = this.mqu;
        str = "key_support_bankcard";
        s.cNC();
        bundle2.putInt(str, s.cND().cQp() ? 1 : 2);
        this.mqu.putBoolean("key_is_forgot_process", true);
        s.cNC();
        if (s.cND().cQp()) {
            b(activity, WalletForgotPwdVerifyIdUI.class, bundle);
        } else {
            b(activity, WalletForgotPwdUI.class, bundle);
        }
        AppMethodBeat.o(46137);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(46138);
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                b(activity, WalletForgotPwdBindNewUI.class, bundle);
                AppMethodBeat.o(46138);
                return;
            }
            b(activity, WalletCardElementUI.class, bundle);
            AppMethodBeat.o(46138);
        } else if (activity instanceof WalletCardElementUI) {
            if (cRY()) {
                b(activity, WalletSetPasswordUI.class, bundle);
                AppMethodBeat.o(46138);
                return;
            }
            b(activity, WalletVerifyCodeUI.class, bundle);
            AppMethodBeat.o(46138);
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.o(46138);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.o(46138);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
            AppMethodBeat.o(46138);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            F("startActivity2", activity, WalletCardElementUI.class, bundle, "flag: 67108864");
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.mqu.putAll(bundle);
            }
            ab.d("MicroMsg.ProcessManager", "bankcard tag :" + dNE());
            AppMethodBeat.o(46138);
        } else if (!(activity instanceof WalletForgotPwdVerifyIdUI)) {
            if (activity instanceof WalletForgotPwdSelectUI) {
                if (bundle.containsKey("key_select_bank_card") && bundle.getBoolean("key_select_bank_card")) {
                    ab.i("MicroMsg.ProcessManager", "forward select bankcard");
                    b(activity, WalletForgotPwdUI.class, bundle);
                    AppMethodBeat.o(46138);
                    return;
                }
                ab.i("MicroMsg.ProcessManager", "forward after face check");
                b(activity, WalletSetPasswordUI.class, bundle);
            }
            AppMethodBeat.o(46138);
        } else if (bundle.containsKey("key_is_support_face") && bundle.getInt("key_is_support_face") == 1) {
            ab.i("MicroMsg.ProcessManager", "forward support face");
            h.pYm.e(15774, Integer.valueOf(this.mqu.getInt("key_forgot_scene", 1)), Integer.valueOf(1));
            b(activity, WalletForgotPwdSelectUI.class, bundle);
            AppMethodBeat.o(46138);
        } else {
            ab.i("MicroMsg.ProcessManager", "forward not support face");
            b(activity, WalletForgotPwdUI.class, bundle);
            AppMethodBeat.o(46138);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(46139);
        s.cNC();
        if (s.cND().cQp()) {
            a(activity, WalletForgotPwdVerifyIdUI.class, -1, false);
            AppMethodBeat.o(46139);
            return;
        }
        a(activity, WalletForgotPwdUI.class, -1, false);
        AppMethodBeat.o(46139);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(46140);
        g anonymousClass2;
        if (mMActivity instanceof WalletForgotPwdUI) {
            AnonymousClass1 anonymousClass1 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46127);
                    if (i == 0 && i2 == 0 && (mVar instanceof y)) {
                        aj cRh = r.cPE().cRh();
                        ab.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", cRh.field_reset_passwd_flag, cRh.field_find_passwd_url);
                        String cQu = r.cPI().cQu();
                        if (!bo.isNullOrNil(cQu)) {
                            ab.i("MicroMsg.ProcessManager", "jump to forget url: %s", cQu);
                            e.n(this.hwd, cQu, false);
                            AppMethodBeat.o(46127);
                            return true;
                        }
                    }
                    AppMethodBeat.o(46127);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    return false;
                }
            };
            AppMethodBeat.o(46140);
            return anonymousClass1;
        } else if (mMActivity instanceof WalletForgotPwdVerifyIdUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46128);
                    if (objArr.length == 3) {
                        this.Agm.a(new q(objArr[0].toString(), ((Integer) objArr[1]).intValue(), (String) objArr[2]), true);
                    }
                    AppMethodBeat.o(46128);
                    return true;
                }

                public final boolean c(int i, int i2, String str, m mVar) {
                    return false;
                }
            };
            AppMethodBeat.o(46140);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletCardElementUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46129);
                    if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.m)) {
                        a.this.mqu.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pwd.a.m) mVar).token);
                        a.this.a(this.hwd, 0, a.this.mqu);
                        AppMethodBeat.o(46129);
                        return true;
                    }
                    AppMethodBeat.o(46129);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    int i;
                    AppMethodBeat.i(46130);
                    Authen authen = (Authen) objArr[0];
                    if (a.this.cRY()) {
                        authen.bJt = 4;
                    } else {
                        authen.bJt = 1;
                    }
                    if (a.this.mqu.getBoolean("key_is_paymanager")) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.Agm.a(new com.tencent.mm.plugin.wallet.pwd.a.m(authen, a.this.mqu.getBoolean("key_is_reset_with_new_card", false), i), true, 1);
                    AppMethodBeat.o(46130);
                    return true;
                }
            };
            AppMethodBeat.o(46140);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46131);
                    if (i == 0 && i2 == 0 && (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.m)) {
                        a.this.mqu.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pwd.a.m) mVar).token);
                        AppMethodBeat.o(46131);
                        return true;
                    }
                    AppMethodBeat.o(46131);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46132);
                    com.tencent.mm.plugin.wallet_core.model.s sVar = (com.tencent.mm.plugin.wallet_core.model.s) objArr[1];
                    sVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    this.Agm.a(new o(sVar), true, 1);
                    AppMethodBeat.o(46132);
                    return true;
                }

                public final CharSequence Au(int i) {
                    AppMethodBeat.i(46133);
                    String string = this.hwd.getString(R.string.gau);
                    AppMethodBeat.o(46133);
                    return string;
                }
            };
            AppMethodBeat.o(46140);
            return anonymousClass2;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            anonymousClass2 = new g(mMActivity, iVar) {
                public final boolean c(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(46134);
                    if (i == 0 && i2 == 0 && ((mVar instanceof l) || (mVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g))) {
                        a.this.a(this.hwd, 0, a.this.mqu);
                        AppMethodBeat.o(46134);
                        return true;
                    }
                    AppMethodBeat.o(46134);
                    return false;
                }

                public final boolean p(Object... objArr) {
                    AppMethodBeat.i(46135);
                    com.tencent.mm.plugin.wallet_core.model.s sVar = (com.tencent.mm.plugin.wallet_core.model.s) objArr[0];
                    if (a.this.mqu.getBoolean("key_is_set_pwd_after_face_action")) {
                        ab.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, after face verify, reset pwd by face");
                        this.Agm.a(new com.tencent.mm.plugin.wallet.pwd.a.g(a.this.mqu.getString("key_face_action_result_token"), sVar.guu), true, 1);
                    } else {
                        ab.i("MicroMsg.ProcessManager", "WalletPwdConfirmUI controller onNext, not after face verify, reset pwd normal");
                        this.Agm.a(new l(sVar), true, 1);
                    }
                    AppMethodBeat.o(46135);
                    return true;
                }
            };
            AppMethodBeat.o(46140);
            return anonymousClass2;
        } else {
            anonymousClass2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(46140);
            return anonymousClass2;
        }
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        AppMethodBeat.i(46141);
        switch (i) {
            case 404:
                com.tencent.mm.ui.base.h.a((Context) walletBaseUI, str, null, walletBaseUI.getString(R.string.ff_), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(46136);
                        a.this.b(walletBaseUI, a.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.o(46136);
                    }
                });
                AppMethodBeat.o(46141);
                return true;
            default:
                AppMethodBeat.o(46141);
                return false;
        }
    }

    public final int a(MMActivity mMActivity, int i) {
        return R.string.ff_;
    }

    public final String bxP() {
        return "ForgotPwdProcess";
    }
}

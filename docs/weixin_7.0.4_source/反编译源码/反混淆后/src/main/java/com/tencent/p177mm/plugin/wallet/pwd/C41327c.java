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
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C43777n;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletResetPwdAdapterUI;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C29619r;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.c */
public class C41327c extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46160);
        C4990ab.m7410d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        mo64571b(activity, WalletSetPasswordUI.class, bundle);
        AppMethodBeat.m2505o(46160);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(46161);
        if (activity instanceof WalletSetPasswordUI) {
            mo64571b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.m2505o(46161);
            return;
        }
        if (activity instanceof WalletPwdConfirmUI) {
            mo8125b(activity, bundle);
        }
        AppMethodBeat.m2505o(46161);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(46162);
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
        }
        AppMethodBeat.m2505o(46162);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46163);
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        mo64559a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
        AppMethodBeat.m2505o(46163);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(46164);
        C44432g c400802;
        if (mMActivity instanceof WalletCheckPwdUI) {
            C354571 c354571 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46154);
                    this.Agm.mo49367a(new C29619r((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    AppMethodBeat.m2505o(46154);
                    return true;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(46155);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.fda);
                            AppMethodBeat.m2505o(46155);
                            return string;
                        case 1:
                            string = this.hwd.getString(C25738R.string.fnd);
                            AppMethodBeat.m2505o(46155);
                            return string;
                        default:
                            string = super.mo9364Au(i);
                            AppMethodBeat.m2505o(46155);
                            return string;
                    }
                }
            };
            AppMethodBeat.m2505o(46164);
            return c354571;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c400802 = new C44432g(mMActivity, c30868i) {

                /* renamed from: com.tencent.mm.plugin.wallet.pwd.c$2$1 */
                class C400811 implements OnClickListener {
                    C400811() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46156);
                        C41327c.this.mqu.putInt("RESET_PWD_USER_ACTION", 2);
                        C41327c.this.mo8124a(C400802.this.hwd, 0, C41327c.this.mqu);
                        AppMethodBeat.m2505o(46156);
                    }
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46157);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C43777n) {
                            C41327c.this.mqu.putInt("RESET_PWD_USER_ACTION", 1);
                            C41327c.this.mo8124a(this.hwd, 0, C41327c.this.mqu);
                            C30379h.m48465bQ(this.hwd, this.hwd.getString(C25738R.string.fmw));
                        }
                        AppMethodBeat.m2505o(46157);
                        return true;
                    } else if (c1207m instanceof C43777n) {
                        C30379h.m48448a(this.hwd, str, "", false, new C400811());
                        AppMethodBeat.m2505o(46157);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(46157);
                        return false;
                    }
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46158);
                    C14264s c14264s = (C14264s) objArr[0];
                    C41327c.this.mqu.getString("key_pwd1");
                    this.Agm.mo49367a(new C43777n(c14264s.guu, c14264s.token), true, 1);
                    AppMethodBeat.m2505o(46158);
                    return true;
                }
            };
            AppMethodBeat.m2505o(46164);
            return c400802;
        } else {
            c400802 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(46164);
            return c400802;
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final boolean mo26470a(final WalletBaseUI walletBaseUI, int i, String str) {
        AppMethodBeat.m2504i(46165);
        switch (i) {
            case 404:
                C30379h.m48447a((Context) walletBaseUI, str, null, walletBaseUI.getString(C25738R.string.ft6), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46159);
                        C41327c.this.mo8125b(walletBaseUI, C41327c.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.m2505o(46159);
                    }
                });
                AppMethodBeat.m2505o(46165);
                return true;
            default:
                AppMethodBeat.m2505o(46165);
                return false;
        }
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.ft6;
    }

    public final String bxP() {
        return "ResetPwdProcessByToken";
    }
}

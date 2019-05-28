package com.tencent.p177mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.wallet.pwd.p1049a.C29603i;
import com.tencent.p177mm.plugin.wallet.pwd.p558ui.WalletPasswordSettingUI;
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

/* renamed from: com.tencent.mm.plugin.wallet.pwd.b */
public class C46357b extends C40931c {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46148);
        C4990ab.m7410d("MicroMsg.ProcessManager", "start Process : ModifyPwdProcess");
        mo64571b(activity, WalletCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(46148);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(46149);
        if (activity instanceof WalletCheckPwdUI) {
            mo64571b(activity, WalletSetPasswordUI.class, bundle);
            AppMethodBeat.m2505o(46149);
        } else if (activity instanceof WalletSetPasswordUI) {
            mo64571b(activity, WalletPwdConfirmUI.class, bundle);
            AppMethodBeat.m2505o(46149);
        } else {
            if (activity instanceof WalletPwdConfirmUI) {
                mo8125b(activity, bundle);
            }
            AppMethodBeat.m2505o(46149);
        }
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(46150);
        if (activity instanceof WalletPwdConfirmUI) {
            mo64558a(activity, WalletSetPasswordUI.class, i);
        }
        AppMethodBeat.m2505o(46150);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(46151);
        mo64560a(activity, WalletPasswordSettingUI.class, -1, false);
        AppMethodBeat.m2505o(46151);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(46152);
        C44432g c400792;
        if (mMActivity instanceof WalletCheckPwdUI) {
            C447751 c447751 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46142);
                    this.Agm.mo49367a(new C29619r((String) objArr[0], 3, (String) objArr[1]), true, 1);
                    AppMethodBeat.m2505o(46142);
                    return true;
                }

                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(46143);
                    CharSequence string;
                    switch (i) {
                        case 0:
                            string = this.hwd.getString(C25738R.string.fda);
                            AppMethodBeat.m2505o(46143);
                            return string;
                        case 1:
                            string = this.hwd.getString(C25738R.string.fnd);
                            AppMethodBeat.m2505o(46143);
                            return string;
                        default:
                            string = super.mo9364Au(i);
                            AppMethodBeat.m2505o(46143);
                            return string;
                    }
                }
            };
            AppMethodBeat.m2505o(46152);
            return c447751;
        } else if (mMActivity instanceof WalletPwdConfirmUI) {
            c400792 = new C44432g(mMActivity, c30868i) {

                /* renamed from: com.tencent.mm.plugin.wallet.pwd.b$2$1 */
                class C296041 implements OnClickListener {
                    C296041() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46144);
                        C46357b.this.mo8127c(C400792.this.hwd, 0);
                        AppMethodBeat.m2505o(46144);
                    }
                }

                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(46145);
                    if (i == 0 && i2 == 0) {
                        if (c1207m instanceof C29603i) {
                            C46357b.this.mo8124a(this.hwd, 0, C46357b.this.mqu);
                            C30379h.m48465bQ(this.hwd, this.hwd.getString(C25738R.string.fmw));
                        }
                        AppMethodBeat.m2505o(46145);
                        return true;
                    } else if (c1207m instanceof C29603i) {
                        C30379h.m48448a(this.hwd, str, "", false, new C296041());
                        AppMethodBeat.m2505o(46145);
                        return true;
                    } else {
                        AppMethodBeat.m2505o(46145);
                        return false;
                    }
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(46146);
                    C14264s c14264s = (C14264s) objArr[0];
                    this.Agm.mo49367a(new C29603i(C46357b.this.mqu.getString("key_pwd1"), c14264s.guu), true, 1);
                    AppMethodBeat.m2505o(46146);
                    return true;
                }
            };
            AppMethodBeat.m2505o(46152);
            return c400792;
        } else {
            c400792 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(46152);
            return c400792;
        }
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    /* renamed from: a */
    public final boolean mo26470a(final WalletBaseUI walletBaseUI, int i, String str) {
        AppMethodBeat.m2504i(46153);
        switch (i) {
            case 404:
                C30379h.m48447a((Context) walletBaseUI, str, null, walletBaseUI.getString(C25738R.string.ft6), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46147);
                        C46357b.this.mo8125b(walletBaseUI, C46357b.this.mqu);
                        if (walletBaseUI.bwP()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.dOB();
                        AppMethodBeat.m2505o(46147);
                    }
                });
                AppMethodBeat.m2505o(46153);
                return true;
            default:
                AppMethodBeat.m2505o(46153);
                return false;
        }
    }

    /* renamed from: a */
    public final int mo26468a(MMActivity mMActivity, int i) {
        return C25738R.string.ft6;
    }

    public final String bxP() {
        return "ModifyPwdProcess";
    }
}

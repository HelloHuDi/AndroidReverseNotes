package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUPwdConfirmUI;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUSetPasswordUI;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.g */
public class C40163g extends C29698e {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48516);
        mo64571b(activity, WalletPayUCheckPwdUI.class, bundle);
        AppMethodBeat.m2505o(48516);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48517);
        if (activity instanceof WalletPayUCheckPwdUI) {
            mo64571b(activity, WalletPayUSetPasswordUI.class, bundle);
            AppMethodBeat.m2505o(48517);
            return;
        }
        super.mo8124a(activity, i, bundle);
        AppMethodBeat.m2505o(48517);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48518);
        C44432g c401622;
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            C227081 c227081 = new C44780a(mMActivity, c30868i, this.mqu) {
                /* renamed from: Au */
                public final CharSequence mo9364Au(int i) {
                    AppMethodBeat.m2504i(48513);
                    if (i == 0) {
                        String string = this.hwd.getString(C25738R.string.fdb);
                        AppMethodBeat.m2505o(48513);
                        return string;
                    }
                    CharSequence Au = super.mo9364Au(i);
                    AppMethodBeat.m2505o(48513);
                    return Au;
                }
            };
            AppMethodBeat.m2505o(48518);
            return c227081;
        } else if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            c401622 = new C44432g(mMActivity, c30868i) {
                /* renamed from: c */
                public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(48514);
                    if (c1207m instanceof C14369b) {
                        C4990ab.m7410d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
                        if (i == 0 && i2 == 0) {
                            C40163g.this.mqu.putInt("key_errcode_payu", 0);
                            C24143a.m37113b(this.hwd, C40163g.this.mqu, 0);
                            AppMethodBeat.m2505o(48514);
                            return true;
                        }
                    }
                    AppMethodBeat.m2505o(48514);
                    return false;
                }

                /* renamed from: p */
                public final boolean mo9366p(Object... objArr) {
                    AppMethodBeat.m2504i(48515);
                    C14264s c14264s = (C14264s) objArr[0];
                    this.Agm.mo36581a(new C14369b(C40163g.this.mqu.getString("key_pwd1"), c14264s.guu), true);
                    AppMethodBeat.m2505o(48515);
                    return true;
                }
            };
            AppMethodBeat.m2505o(48518);
            return c401622;
        } else {
            c401622 = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48518);
            return c401622;
        }
    }

    public final String bxP() {
        return "PayUModifyPasswordProcess";
    }
}

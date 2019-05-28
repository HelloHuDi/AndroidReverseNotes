package com.tencent.p177mm.plugin.wallet_payu.pwd.p1054a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.wallet_payu.pwd.p573ui.WalletPayUSetPasswordUI;
import com.tencent.p177mm.plugin.wallet_payu.security_question.model.C22711a;
import com.tencent.p177mm.plugin.wallet_payu.security_question.p574ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pwd.a.f */
public class C31468f extends C29698e {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48510);
        mo64571b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
        C40931c a = super.mo8123a(activity, bundle);
        AppMethodBeat.m2505o(48510);
        return a;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48511);
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            mo64571b(activity, WalletPayUSetPasswordUI.class, bundle);
            AppMethodBeat.m2505o(48511);
            return;
        }
        super.mo8124a(activity, i, bundle);
        AppMethodBeat.m2505o(48511);
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48512);
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            C22711a c22711a = new C22711a(mMActivity, c30868i, this.mqu);
            AppMethodBeat.m2505o(48512);
            return c22711a;
        }
        C44432g a = super.mo24745a(mMActivity, c30868i);
        AppMethodBeat.m2505o(48512);
        return a;
    }

    public final String bxP() {
        return "PayUForgotPwdProcess";
    }
}

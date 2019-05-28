package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.d.i;

public class f extends e {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48510);
        b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
        c a = super.a(activity, bundle);
        AppMethodBeat.o(48510);
        return a;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48511);
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
            AppMethodBeat.o(48511);
            return;
        }
        super.a(activity, i, bundle);
        AppMethodBeat.o(48511);
    }

    public final g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48512);
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            a aVar = new a(mMActivity, iVar, this.mqu);
            AppMethodBeat.o(48512);
            return aVar;
        }
        g a = super.a(mMActivity, iVar);
        AppMethodBeat.o(48512);
        return a;
    }

    public final String bxP() {
        return "PayUForgotPwdProcess";
    }
}

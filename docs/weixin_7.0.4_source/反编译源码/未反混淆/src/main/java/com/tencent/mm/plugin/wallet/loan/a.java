package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.wallet_core.c;

public class a extends b {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45833);
        if (r.cPI().cQg()) {
            b(activity, WalletLoanCheckPwdUI.class, bundle);
        } else {
            super.a(activity, bundle);
        }
        AppMethodBeat.o(45833);
        return this;
    }

    public final void b(Activity activity, Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(45835);
        if (bundle.getBoolean("intent_bind_end", false)) {
            i = -1;
        }
        a(activity, WalletLoanRepaymentUI.class, i, null, true);
        AppMethodBeat.o(45835);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45834);
        b(activity, this.mqu);
        AppMethodBeat.o(45834);
    }
}

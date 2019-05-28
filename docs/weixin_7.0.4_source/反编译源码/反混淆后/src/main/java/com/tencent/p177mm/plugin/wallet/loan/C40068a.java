package com.tencent.p177mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.pay.p557ui.WalletLoanRepaymentUI;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.wallet.loan.a */
public class C40068a extends C29615b {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45833);
        if (C14241r.cPI().cQg()) {
            mo64571b(activity, WalletLoanCheckPwdUI.class, bundle);
        } else {
            super.mo8123a(activity, bundle);
        }
        AppMethodBeat.m2505o(45833);
        return this;
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(45835);
        if (bundle.getBoolean("intent_bind_end", false)) {
            i = -1;
        }
        mo64559a(activity, WalletLoanRepaymentUI.class, i, null, true);
        AppMethodBeat.m2505o(45835);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45834);
        mo8125b(activity, this.mqu);
        AppMethodBeat.m2505o(45834);
    }
}

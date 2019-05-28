package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;
import com.tencent.p177mm.wallet_core.C40931c;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.b */
public class C4349b extends C29615b {
    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45499);
        C40931c a = super.mo8123a(activity, bundle);
        AppMethodBeat.m2505o(45499);
        return a;
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(45500);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.m2505o(45500);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45501);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.m2505o(45501);
            return;
        }
        Activity activity2 = activity;
        mo64564a(activity2, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
        AppMethodBeat.m2505o(45501);
    }

    public final String bxP() {
        return "BalanceFetchCardProcess";
    }
}

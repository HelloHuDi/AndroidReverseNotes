package com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.p560b.C29615b;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.lqt.c */
public class C4350c extends C29615b {
    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(45502);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.m2505o(45502);
            return;
        }
        Activity activity2 = activity;
        mo64564a(activity2, "wallet", ".balance.ui.lqt.WalletLqtPlanAddUI", -1, new Intent(), true);
        AppMethodBeat.m2505o(45502);
    }
}

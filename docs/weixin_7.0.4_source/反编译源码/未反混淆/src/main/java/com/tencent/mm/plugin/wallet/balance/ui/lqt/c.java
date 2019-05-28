package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;

public class c extends b {
    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45502);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.o(45502);
            return;
        }
        Activity activity2 = activity;
        a(activity2, "wallet", ".balance.ui.lqt.WalletLqtPlanAddUI", -1, new Intent(), true);
        AppMethodBeat.o(45502);
    }
}

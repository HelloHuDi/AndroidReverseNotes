package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c;

public class b extends com.tencent.mm.plugin.wallet_core.b.b {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45499);
        c a = super.a(activity, bundle);
        AppMethodBeat.o(45499);
        return a;
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45500);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(45500);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45501);
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.o(45501);
            return;
        }
        Activity activity2 = activity;
        a(activity2, "wallet", ".balance.ui.lqt.WalletLqtSaveFetchUI", -1, new Intent(), true);
        AppMethodBeat.o(45501);
    }

    public final String bxP() {
        return "BalanceFetchCardProcess";
    }
}

package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.x;

public class a extends b {
    public static int teT = 1;
    public static int teU = 2;

    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45196);
        x.QN(14);
        c a = super.a(activity, bundle);
        AppMethodBeat.o(45196);
        return a;
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45197);
        x.dNV();
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(45197);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45198);
        x.dNV();
        if (bundle == null || !bundle.getBoolean("intent_bind_end", false)) {
            activity.finish();
            AppMethodBeat.o(45198);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (bundle.getInt("from_bind_ui", teU) == teT) {
            intent.putExtra("from_bind_ui", teT);
            a(activity, "wallet", ".balance.ui.WalletBalanceManagerUI", -1, intent, true);
            AppMethodBeat.o(45198);
            return;
        }
        intent.putExtra("from_bind_ui", teU);
        a(activity, "wallet", ".balance.ui.ltWalletLqtSaveFetchUI", -1, intent, true);
        AppMethodBeat.o(45198);
    }

    public final String bxP() {
        return "BalanceFetchCardProcess";
    }
}

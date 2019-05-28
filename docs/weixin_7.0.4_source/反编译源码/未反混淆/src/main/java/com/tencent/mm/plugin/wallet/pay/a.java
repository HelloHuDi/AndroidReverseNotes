package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;

public class a extends b {
    public final void c(Activity activity, int i) {
        AppMethodBeat.i(45860);
        if (activity != null) {
            activity.finish();
        }
        AppMethodBeat.o(45860);
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(45861);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".pay.ui.WalletPayUI", -1, intent, false);
        AppMethodBeat.o(45861);
    }

    public final String bxP() {
        return "BindCardForPayProcess";
    }
}

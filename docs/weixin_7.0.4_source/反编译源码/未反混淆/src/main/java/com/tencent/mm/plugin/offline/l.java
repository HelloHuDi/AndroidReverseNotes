package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.wallet_core.c;

public class l extends c {
    public final c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43373);
        b(activity, WalletVerifyCodeUI.class, bundle);
        AppMethodBeat.o(43373);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(43374);
        if (activity instanceof WalletVerifyCodeUI) {
            b(activity, bundle);
        }
        AppMethodBeat.o(43374);
    }

    public final void c(Activity activity, int i) {
    }

    public final void b(Activity activity, Bundle bundle) {
        AppMethodBeat.i(43375);
        Intent intent = new Intent(activity, WalletOfflineCoinPurseUI.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
        AppMethodBeat.o(43375);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "VerifyProcess";
    }
}

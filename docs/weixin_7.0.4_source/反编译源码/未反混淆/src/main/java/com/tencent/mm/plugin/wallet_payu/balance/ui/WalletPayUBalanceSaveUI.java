package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI;
import com.tencent.mm.plugin.wallet_payu.balance.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

public class WalletPayUBalanceSaveUI extends WalletBalanceSaveUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48330);
        super.onCreate(bundle);
        this.tgF.setVisibility(8);
        AppMethodBeat.o(48330);
    }

    public final void cNd() {
        AppMethodBeat.i(48331);
        a(new a(this.pQV, "ZAR"), true, true);
        AppMethodBeat.o(48331);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48332);
        if (i == 0 && i2 == 0 && (mVar instanceof a)) {
            h.a((Context) this, ((a) mVar).czZ, "", 11, 1);
        }
        AppMethodBeat.o(48332);
        return false;
    }
}

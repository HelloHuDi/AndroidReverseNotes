package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet_core.c.b.a;

public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48324);
        super.onCreate(bundle);
        AppMethodBeat.o(48324);
    }

    public final void cMZ() {
        boolean z;
        AppMethodBeat.i(48325);
        s.cNC();
        if (s.cND().thy == null) {
            z = true;
        } else {
            z = false;
        }
        a(new a(), z, false);
        AppMethodBeat.o(48325);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48326);
        if (i == 0 && i2 == 0 && (mVar instanceof a)) {
            cu();
        }
        AppMethodBeat.o(48326);
        return false;
    }

    public final void cNa() {
        AppMethodBeat.i(48327);
        aA(WalletPayUBalanceSaveUI.class);
        AppMethodBeat.o(48327);
    }
}

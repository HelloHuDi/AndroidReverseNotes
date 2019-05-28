package com.tencent.p177mm.plugin.wallet_payu.balance.p567ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.WalletBalanceManagerUI;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.p749c.p1659b.C46358a;

/* renamed from: com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceManagerUI */
public class WalletPayUBalanceManagerUI extends WalletBalanceManagerUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48324);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(48324);
    }

    public final void cMZ() {
        boolean z;
        AppMethodBeat.m2504i(48325);
        C46332s.cNC();
        if (C46332s.cND().thy == null) {
            z = true;
        } else {
            z = false;
        }
        mo39970a(new C46358a(), z, false);
        AppMethodBeat.m2505o(48325);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48326);
        if (i == 0 && i2 == 0 && (c1207m instanceof C46358a)) {
            mo41703cu();
        }
        AppMethodBeat.m2505o(48326);
        return false;
    }

    public final void cNa() {
        AppMethodBeat.m2504i(48327);
        mo17383aA(WalletPayUBalanceSaveUI.class);
        AppMethodBeat.m2505o(48327);
    }
}

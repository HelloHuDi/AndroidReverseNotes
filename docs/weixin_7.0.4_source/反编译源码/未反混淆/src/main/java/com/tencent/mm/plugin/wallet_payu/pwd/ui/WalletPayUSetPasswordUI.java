package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletPayUSetPasswordUI extends WalletSetPasswordUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48524);
        super.onCreate(bundle);
        a.a(this.nrZ, false);
        AppMethodBeat.o(48524);
    }
}

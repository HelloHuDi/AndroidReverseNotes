package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.ui.base.a;

@a(3)
public class WalletPayUCheckPwdUI extends WalletCheckPwdUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48519);
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.ui.formview.a.a(this.nrZ, true);
        AppMethodBeat.o(48519);
    }

    public final boolean cNR() {
        return true;
    }
}

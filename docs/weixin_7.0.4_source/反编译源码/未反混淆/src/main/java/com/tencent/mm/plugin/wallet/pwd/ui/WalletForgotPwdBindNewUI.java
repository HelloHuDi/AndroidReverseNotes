package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WalletForgotPwdBindNewUI extends WalletForgotPwdUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final boolean cNR() {
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(46264);
        super.initView();
        AppMethodBeat.o(46264);
    }
}

package com.tencent.mm.plugin.wallet_payu.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.a;

public class WalletPayUPasswordSettingUI extends WalletPasswordSettingUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void cOH() {
        AppMethodBeat.i(48520);
        ab.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu do forgot pwd");
        a.a(this, f.class, null);
        AppMethodBeat.o(48520);
    }

    public final void cOG() {
        AppMethodBeat.i(48521);
        ab.d("MicroMsg.WalletPayUPasswordSettingUI", "hy: start payu reset pwd");
        a.a(this, g.class, null);
        AppMethodBeat.o(48521);
    }

    public final int cOF() {
        return R.xml.cu;
    }

    public final void cOI() {
        AppMethodBeat.i(48522);
        this.yCw.ce("wallet_modify_gesture_password", true);
        this.yCw.ce("wallet_open_gesture_password", true);
        AppMethodBeat.o(48522);
    }
}

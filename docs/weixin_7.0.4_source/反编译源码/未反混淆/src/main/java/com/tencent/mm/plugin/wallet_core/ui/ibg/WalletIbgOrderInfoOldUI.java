package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.r;

public class WalletIbgOrderInfoOldUI extends WalletOrderInfoOldUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47846);
        this.tog = WalletIbgOrderInfoUI.tog;
        super.onCreate(bundle);
        AppMethodBeat.o(47846);
    }

    public final Orders cRD() {
        return this.tog;
    }

    public final void done() {
        AppMethodBeat.i(47847);
        ab.i("MicroMsg.WalletIbgOrderInfoOldUI", "hy: result is not set manly. set to OK");
        for (String str : this.tIc) {
            if (!bo.isNullOrNil(str)) {
                ab.d("MicroMsg.WalletIbgOrderInfoOldUI", "hy: doing netscene subscribe...appName: %s", str);
                g.RQ();
                g.RO().eJo.a(new r(str), 0);
            }
        }
        setResult(-1);
        finish();
        AppMethodBeat.o(47847);
    }
}

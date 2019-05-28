package com.tencent.mm.plugin.wallet_core.ui.ibg;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.r;

public class WalletIbgOrderInfoNewUI extends WalletOrderInfoNewUI {
    private Orders tog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47844);
        this.tog = WalletIbgOrderInfoUI.tog;
        super.onCreate(bundle);
        iy iyVar = new iy();
        iyVar.cEc.requestCode = 25;
        iyVar.cEc.bFZ = -1;
        iyVar.cEc.cEd = new Intent();
        a.xxA.m(iyVar);
        AppMethodBeat.o(47844);
    }

    public final Orders cRD() {
        return this.tog;
    }

    public final void done() {
        AppMethodBeat.i(47845);
        ab.i("MicroMsg.WalletIbgOrderInfoNewUI", "hy: result is not set manly. set to OK");
        for (String str : this.tIc) {
            if (!bo.isNullOrNil(str)) {
                ab.d("MicroMsg.WalletIbgOrderInfoNewUI", "hy: doing netscene subscribe...appName: %s", str);
                g.RQ();
                g.RO().eJo.a(new r(str), 0);
            }
        }
        setResult(-1);
        finish();
        AppMethodBeat.o(47845);
    }

    public final void cRq() {
    }
}

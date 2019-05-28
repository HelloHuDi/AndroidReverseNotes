package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.r;

public class WalletMixOrderInfoProxyUI extends WalletOrderInfoNewUI {
    private String prepayId = null;
    private Orders tog;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47409);
        this.tog = (Orders) getIntent().getParcelableExtra("key_orders");
        this.prepayId = getIntent().getStringExtra("prepayId");
        super.onCreate(bundle);
        AppMethodBeat.o(47409);
    }

    /* Access modifiers changed, original: protected|final */
    public final Orders cRD() {
        return this.tog;
    }

    public final void done() {
        AppMethodBeat.i(47410);
        for (String str : this.tIc) {
            if (!bo.isNullOrNil(str)) {
                ab.d("MicroMsg.WalletMixOrderInfoProxyUI", "hy: doing netscene subscribe...appName: %s", str);
                g.RQ();
                g.RO().eJo.a(new r(str), 0);
            }
        }
        if (!bo.isNullOrNil(this.prepayId)) {
            uv uvVar = new uv();
            Intent intent = new Intent();
            intent.putExtra("intent_pay_end", true);
            uvVar.cRF.intent = intent;
            uvVar.cRF.czZ = this.prepayId;
            uvVar.cRF.result = -1;
            uvVar.cRF.cRH = 1;
            a.xxA.m(uvVar);
        }
        setResult(-1);
        finish();
        AppMethodBeat.o(47410);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cRq() {
    }
}

package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class h extends b {
    public h(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinepayauthen";
    }

    public final int ZU() {
        return 1972;
    }

    public final boolean bXm() {
        if (this.toh == null || this.toh.pGr.vwn == 1) {
            return true;
        }
        return false;
    }
}

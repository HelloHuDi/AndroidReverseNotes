package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.s;

public final class b extends j {
    public b(s sVar, Orders orders) {
        super(sVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/dc_verifyreg";
    }

    public final int ZU() {
        return 2935;
    }
}

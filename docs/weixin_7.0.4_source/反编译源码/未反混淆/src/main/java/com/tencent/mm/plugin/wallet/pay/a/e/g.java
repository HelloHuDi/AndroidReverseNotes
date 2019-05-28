package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.s;

public final class g extends j {
    public g(s sVar, Orders orders) {
        super(sVar, orders);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/tax_verifyreg";
    }

    public final int ZU() {
        return 2626;
    }
}

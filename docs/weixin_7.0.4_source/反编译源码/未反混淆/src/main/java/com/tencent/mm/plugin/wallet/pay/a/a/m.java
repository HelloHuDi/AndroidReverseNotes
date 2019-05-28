package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class m extends b {
    public m(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_tf_authen";
    }

    public final int ZU() {
        return 1659;
    }
}

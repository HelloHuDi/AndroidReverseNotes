package com.tencent.p177mm.plugin.wallet.pay.p554a.p555a;

import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.a.h */
public final class C16915h extends C14157b {
    public C16915h(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinepayauthen";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 1972;
    }

    public final boolean bXm() {
        if (this.toh == null || this.toh.pGr.vwn == 1) {
            return true;
        }
        return false;
    }
}

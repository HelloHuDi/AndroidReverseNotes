package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    public static Orders a(Orders orders, String str, String str2, int i, String str3) {
        AppMethodBeat.i(48445);
        if (orders == null || orders.tAq == null || orders.tAq.size() <= 0) {
            ab.d("MicroMsg.OrdersWrapper", "hy: params error");
            AppMethodBeat.o(48445);
        } else {
            for (Commodity commodity : orders.tAq) {
                commodity.pch = i;
                commodity.pce = str.equals("1") ? "2" : "1";
                commodity.pcf = str2;
                commodity.pcj = str3;
            }
            AppMethodBeat.o(48445);
        }
        return orders;
    }
}

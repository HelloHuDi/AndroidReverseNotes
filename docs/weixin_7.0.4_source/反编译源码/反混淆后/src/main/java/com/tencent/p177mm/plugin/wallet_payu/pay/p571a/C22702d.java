package com.tencent.p177mm.plugin.wallet_payu.pay.p571a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.a.d */
public final class C22702d {
    /* renamed from: a */
    public static Orders m34463a(Orders orders, String str, String str2, int i, String str3) {
        AppMethodBeat.m2504i(48445);
        if (orders == null || orders.tAq == null || orders.tAq.size() <= 0) {
            C4990ab.m7410d("MicroMsg.OrdersWrapper", "hy: params error");
            AppMethodBeat.m2505o(48445);
        } else {
            for (Commodity commodity : orders.tAq) {
                commodity.pch = i;
                commodity.pce = str.equals("1") ? "2" : "1";
                commodity.pcf = str2;
                commodity.pcj = str3;
            }
            AppMethodBeat.m2505o(48445);
        }
        return orders;
    }
}

package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public enum c {
    ;
    
    private Map<String, WeakReference<b>> tDV;

    private c(String str) {
        AppMethodBeat.i(47121);
        this.tDV = new HashMap();
        AppMethodBeat.o(47121);
    }

    static {
        AppMethodBeat.o(47124);
    }

    public final b a(Orders orders) {
        AppMethodBeat.i(47122);
        String b = b(orders);
        if (bo.isNullOrNil(b)) {
            ab.w("MicroMsg.FavorLogicHelperPool", "get key null");
            AppMethodBeat.o(47122);
            return null;
        }
        b bVar;
        if (this.tDV.containsKey(b)) {
            ab.i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(b)));
            WeakReference weakReference = (WeakReference) this.tDV.get(b);
            if (weakReference != null) {
                bVar = (b) weakReference.get();
                if (bVar != null) {
                    AppMethodBeat.o(47122);
                    return bVar;
                }
                ab.i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                ab.i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.tAr == null) {
            AppMethodBeat.o(47122);
            return null;
        }
        bVar = new b(orders.tAr);
        this.tDV.put(b, new WeakReference(bVar));
        AppMethodBeat.o(47122);
        return bVar;
    }

    private static String b(Orders orders) {
        AppMethodBeat.i(47123);
        if (orders == null || orders.tAq == null) {
            AppMethodBeat.o(47123);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < orders.tAq.size()) {
                stringBuilder.append(((Commodity) orders.tAq.get(i2)).cAa);
                i = i2 + 1;
            } else {
                stringBuilder.append("@");
                stringBuilder.append(orders.tzZ);
                String stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(47123);
                return stringBuilder2;
            }
        }
    }
}

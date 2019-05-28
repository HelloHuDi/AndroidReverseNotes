package com.tencent.p177mm.plugin.wallet_core.p561ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.c */
public enum C29666c {
    ;
    
    private Map<String, WeakReference<C22621b>> tDV;

    private C29666c(String str) {
        AppMethodBeat.m2504i(47121);
        this.tDV = new HashMap();
        AppMethodBeat.m2505o(47121);
    }

    static {
        AppMethodBeat.m2505o(47124);
    }

    /* renamed from: a */
    public final C22621b mo47919a(Orders orders) {
        AppMethodBeat.m2504i(47122);
        String b = C29666c.m47055b(orders);
        if (C5046bo.isNullOrNil(b)) {
            C4990ab.m7420w("MicroMsg.FavorLogicHelperPool", "get key null");
            AppMethodBeat.m2505o(47122);
            return null;
        }
        C22621b c22621b;
        if (this.tDV.containsKey(b)) {
            C4990ab.m7416i("MicroMsg.FavorLogicHelperPool", "hit cache, key:".concat(String.valueOf(b)));
            WeakReference weakReference = (WeakReference) this.tDV.get(b);
            if (weakReference != null) {
                c22621b = (C22621b) weakReference.get();
                if (c22621b != null) {
                    AppMethodBeat.m2505o(47122);
                    return c22621b;
                }
                C4990ab.m7416i("MicroMsg.FavorLogicHelperPool", "helper null");
            } else {
                C4990ab.m7416i("MicroMsg.FavorLogicHelperPool", "weakHelper null");
            }
        }
        if (orders == null || orders.tAr == null) {
            AppMethodBeat.m2505o(47122);
            return null;
        }
        c22621b = new C22621b(orders.tAr);
        this.tDV.put(b, new WeakReference(c22621b));
        AppMethodBeat.m2505o(47122);
        return c22621b;
    }

    /* renamed from: b */
    private static String m47055b(Orders orders) {
        AppMethodBeat.m2504i(47123);
        if (orders == null || orders.tAq == null) {
            AppMethodBeat.m2505o(47123);
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
                AppMethodBeat.m2505o(47123);
                return stringBuilder2;
            }
        }
    }
}

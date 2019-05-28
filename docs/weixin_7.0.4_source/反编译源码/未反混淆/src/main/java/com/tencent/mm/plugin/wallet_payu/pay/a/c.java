package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends a {
    public Orders pWy;
    private String tos;

    public c(String str) {
        this(str, 0);
    }

    public c(String str, int i) {
        AppMethodBeat.i(48443);
        this.pWy = null;
        this.tos = null;
        this.tos = str;
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", this.tos);
        hashMap.put("query_scene", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(48443);
    }

    public final int cOX() {
        return 8;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48444);
        this.pWy = Orders.ap(jSONObject);
        if (this.pWy != null) {
            this.pWy.czZ = this.tos;
        }
        AppMethodBeat.o(48444);
    }
}

package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String cuZ;
    public String czZ;
    public double pTN;

    public a(double d, String str) {
        AppMethodBeat.i(48320);
        this.pTN = d;
        this.cuZ = str;
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str);
        M(hashMap);
        AppMethodBeat.o(48320);
    }

    public final int cOX() {
        return 20;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48321);
        this.czZ = jSONObject.optString("prepayid");
        AppMethodBeat.o(48321);
    }
}

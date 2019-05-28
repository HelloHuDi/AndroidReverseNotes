package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public String cEW;
    public String tTb;
    public String tTc;
    public boolean tTz;

    public b(String str, String str2) {
        AppMethodBeat.i(48408);
        this.tTb = str;
        this.tTc = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("dial_code", str);
        hashMap.put("number", String.valueOf(str2));
        M(hashMap);
        AppMethodBeat.o(48408);
    }

    public final int cOX() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48409);
        ab.d("MicroMsg.NetScenePayUGenerateOtp", "hy: get NetScenePayUGenerateOtp info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.tTz = jSONObject.optBoolean("has_mobile");
        this.cEW = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48409);
    }
}

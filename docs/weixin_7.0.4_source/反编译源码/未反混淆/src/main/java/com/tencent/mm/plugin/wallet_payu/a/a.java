package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String cEW;
    public boolean qnM;
    public String tTx;
    public String tTy;

    public a(String str, String str2) {
        AppMethodBeat.i(48406);
        this.tTx = str;
        this.cEW = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("otp", str);
        hashMap.put("payu_reference", String.valueOf(str2));
        M(hashMap);
        AppMethodBeat.o(48406);
    }

    public final int cOX() {
        return 4;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48407);
        ab.d("MicroMsg.NetScenePayUComfirmOtp", "hy: get NetScenePayUCreateUser info. errCode: %d, errMsg:%s, json:%s", Integer.valueOf(i), str, jSONObject.toString());
        this.qnM = jSONObject.optBoolean("verified");
        this.tTy = jSONObject.optString("payu_reference");
        AppMethodBeat.o(48407);
    }
}

package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends a {
    public String desc;
    public double kCJ;
    public String pPP;
    public String pPQ;
    public int scene;
    public int timestamp;
    public String username;

    public d(String str) {
        AppMethodBeat.i(48531);
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_url", str);
        M(hashMap);
        AppMethodBeat.o(48531);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48532);
        ab.d("MicroMsg.NetScenePayURemittanceGetUsername", "errCode " + i + " errMsg: " + str);
        if (i != 0) {
            AppMethodBeat.o(48532);
            return;
        }
        this.username = jSONObject.optString("user_name");
        this.pPP = jSONObject.optString("true_name");
        this.kCJ = jSONObject.optDouble("fee") / 100.0d;
        this.desc = jSONObject.optString("desc");
        this.scene = jSONObject.optInt("scene");
        this.pPQ = jSONObject.optString("transfer_qrcode_id");
        this.timestamp = jSONObject.optInt("time_stamp");
        AppMethodBeat.o(48532);
    }

    public final int cOX() {
        return 24;
    }
}

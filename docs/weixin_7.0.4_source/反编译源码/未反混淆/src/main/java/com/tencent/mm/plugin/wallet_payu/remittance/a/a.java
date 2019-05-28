package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String cMr;
    public String cuZ;
    public String czZ;
    public double pTN;
    public String pin;
    public int tSw;
    public int tUv;
    public double tUw;
    public String tUx;
    public String tlg;

    public a(String str, String str2, double d, String str3, int i, String str4, String str5, String str6) {
        AppMethodBeat.i(48525);
        this.czZ = str;
        this.pin = str2;
        this.pTN = d;
        this.cuZ = str3;
        this.tUv = i == 2 ? 0 : i;
        this.cMr = str4;
        this.tlg = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("pin", str2);
        hashMap.put("req_key", str);
        hashMap.put("total_fee", Math.round(100.0d * d));
        hashMap.put("fee_type", str3);
        hashMap.put("transfer_type", String.valueOf(i));
        hashMap.put("target_username", str4);
        hashMap.put("bind_serial", str5);
        hashMap.put("transfer_qrcode_id", str6);
        M(hashMap);
        AppMethodBeat.o(48525);
    }

    public final int cOX() {
        return 14;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(48526);
        this.tSw = jSONObject.optInt("response_result");
        this.tUw = bo.getDouble(jSONObject.optString("total_fee"), 0.0d);
        this.tUx = jSONObject.optString("fee_type");
        AppMethodBeat.o(48526);
    }
}

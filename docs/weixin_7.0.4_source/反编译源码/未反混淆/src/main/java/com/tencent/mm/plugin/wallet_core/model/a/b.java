package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public boolean lSP;
    public Bankcard tDH;
    public String tDI;
    public String tDJ;
    public boolean tDK;
    public int tDL;

    public static String aJ(JSONObject jSONObject) {
        AppMethodBeat.i(47045);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cvv_length", jSONObject.optInt("cvv_length"));
            jSONObject2.put("information", jSONObject.optString("information"));
            jSONObject2.put("verified", jSONObject.optBoolean("verified"));
            jSONObject2.put("card_expiry", jSONObject.optString("card_expiry"));
            jSONObject2.put("is_credit", jSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
        String jSONObject3 = jSONObject2.toString();
        AppMethodBeat.o(47045);
        return jSONObject3;
    }

    public b(Bankcard bankcard) {
        AppMethodBeat.i(47046);
        this.tDH = bankcard;
        try {
            JSONObject jSONObject = new JSONObject(this.tDH.field_ext_msg);
            this.tDI = jSONObject.optString("information");
            this.lSP = jSONObject.optBoolean("verified");
            this.tDJ = jSONObject.optString("card_expiry");
            this.tDL = jSONObject.optInt("cvv_length");
            this.tDK = jSONObject.optBoolean("is_credit");
            AppMethodBeat.o(47046);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
            AppMethodBeat.o(47046);
        }
    }
}

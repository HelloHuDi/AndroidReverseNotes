package com.tencent.p177mm.plugin.wallet_core.model.p1314a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.a.b */
public final class C22581b {
    public boolean lSP;
    public Bankcard tDH;
    public String tDI;
    public String tDJ;
    public boolean tDK;
    public int tDL;

    /* renamed from: aJ */
    public static String m34272aJ(JSONObject jSONObject) {
        AppMethodBeat.m2504i(47045);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cvv_length", jSONObject.optInt("cvv_length"));
            jSONObject2.put("information", jSONObject.optString("information"));
            jSONObject2.put("verified", jSONObject.optBoolean("verified"));
            jSONObject2.put("card_expiry", jSONObject.optString("card_expiry"));
            jSONObject2.put("is_credit", jSONObject.optString("bank_type").equals("CREDITCARD_PAYU"));
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
        }
        String jSONObject3 = jSONObject2.toString();
        AppMethodBeat.m2505o(47045);
        return jSONObject3;
    }

    public C22581b(Bankcard bankcard) {
        AppMethodBeat.m2504i(47046);
        this.tDH = bankcard;
        try {
            JSONObject jSONObject = new JSONObject(this.tDH.field_ext_msg);
            this.tDI = jSONObject.optString("information");
            this.lSP = jSONObject.optBoolean("verified");
            this.tDJ = jSONObject.optString("card_expiry");
            this.tDL = jSONObject.optInt("cvv_length");
            this.tDK = jSONObject.optBoolean("is_credit");
            AppMethodBeat.m2505o(47046);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.BankcardPayUWrapper", e, "", new Object[0]);
            AppMethodBeat.m2505o(47046);
        }
    }
}

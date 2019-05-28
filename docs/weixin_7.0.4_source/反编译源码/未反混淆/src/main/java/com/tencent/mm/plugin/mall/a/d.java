package com.tencent.mm.plugin.mall.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class d {
    public String okK = "";
    public int okL = 0;
    public String okM = "";

    public d(String str) {
        AppMethodBeat.i(43095);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.okK = jSONObject.optString("eu_protocol_url");
            this.okL = jSONObject.optInt(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.okM = jSONObject.optString("wxpay_protocol_url");
            AppMethodBeat.o(43095);
        } catch (Exception e) {
            ab.printErrStackTrace("MciroMsg.EUInfo", e, "", new Object[0]);
            AppMethodBeat.o(43095);
        }
    }
}

package com.tencent.p177mm.plugin.mall.p450a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.mall.a.d */
public final class C39350d {
    public String okK = "";
    public int okL = 0;
    public String okM = "";

    public C39350d(String str) {
        AppMethodBeat.m2504i(43095);
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.okK = jSONObject.optString("eu_protocol_url");
            this.okL = jSONObject.optInt(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.okM = jSONObject.optString("wxpay_protocol_url");
            AppMethodBeat.m2505o(43095);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MciroMsg.EUInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(43095);
        }
    }
}

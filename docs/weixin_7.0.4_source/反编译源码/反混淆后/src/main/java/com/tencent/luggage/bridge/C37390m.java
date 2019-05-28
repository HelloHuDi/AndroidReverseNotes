package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.m */
final class C37390m extends C8856a {
    C37390m(JSONObject jSONObject) {
        AppMethodBeat.m2504i(90729);
        this.bOe = C8857b.valueOf(jSONObject.getString("type"));
        this.bOf = jSONObject.optJSONObject("data");
        if (this.bOf == null) {
            this.bOf = new JSONObject();
        }
        AppMethodBeat.m2505o(90729);
    }
}

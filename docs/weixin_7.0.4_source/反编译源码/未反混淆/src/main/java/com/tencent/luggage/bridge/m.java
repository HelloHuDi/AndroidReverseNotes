package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

final class m extends a {
    m(JSONObject jSONObject) {
        AppMethodBeat.i(90729);
        this.bOe = b.valueOf(jSONObject.getString("type"));
        this.bOf = jSONObject.optJSONObject("data");
        if (this.bOf == null) {
            this.bOf = new JSONObject();
        }
        AppMethodBeat.o(90729);
    }
}

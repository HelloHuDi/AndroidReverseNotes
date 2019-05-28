package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

class e extends a {
    protected e(b bVar) {
        AppMethodBeat.i(90717);
        this.bOe = bVar;
        this.bOf = new JSONObject();
        AppMethodBeat.o(90717);
    }

    /* Access modifiers changed, original: final */
    public final void c(JSONObject jSONObject) {
        this.bOf = jSONObject;
    }

    /* Access modifiers changed, original: final */
    public final void c(Map<String, Object> map) {
        AppMethodBeat.i(90718);
        this.bOf = new JSONObject(map);
        AppMethodBeat.o(90718);
    }
}

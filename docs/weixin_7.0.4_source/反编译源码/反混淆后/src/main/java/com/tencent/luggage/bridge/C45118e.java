package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.e */
class C45118e extends C8856a {
    protected C45118e(C8857b c8857b) {
        AppMethodBeat.m2504i(90717);
        this.bOe = c8857b;
        this.bOf = new JSONObject();
        AppMethodBeat.m2505o(90717);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo72929c(JSONObject jSONObject) {
        this.bOf = jSONObject;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo72928c(Map<String, Object> map) {
        AppMethodBeat.m2504i(90718);
        this.bOf = new JSONObject(map);
        AppMethodBeat.m2505o(90718);
    }
}

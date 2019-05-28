package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.i */
public final class C0984i {
    String bOu;
    private JSONObject bOv;

    C0984i(C37390m c37390m) {
        AppMethodBeat.m2504i(90724);
        JSONObject wK = c37390m.mo20029wK();
        this.bOu = wK.getString("event");
        this.bOv = wK.optJSONObject("data");
        if (this.bOv == null) {
            this.bOv = new JSONObject();
        }
        AppMethodBeat.m2505o(90724);
    }
}

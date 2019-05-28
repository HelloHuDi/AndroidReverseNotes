package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class i {
    String bOu;
    private JSONObject bOv;

    i(m mVar) {
        AppMethodBeat.i(90724);
        JSONObject wK = mVar.wK();
        this.bOu = wK.getString("event");
        this.bOv = wK.optJSONObject("data");
        if (this.bOv == null) {
            this.bOv = new JSONObject();
        }
        AppMethodBeat.o(90724);
    }
}

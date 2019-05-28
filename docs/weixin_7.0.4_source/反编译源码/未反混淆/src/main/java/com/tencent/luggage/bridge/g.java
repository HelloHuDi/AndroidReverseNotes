package com.tencent.luggage.bridge;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class g {
    private JSONObject bOf;
    private String bOr;
    int bOs;
    boolean bOt;

    g(m mVar) {
        AppMethodBeat.i(90723);
        JSONObject wK = mVar.wK();
        this.bOr = wK.getString(b.METHOD);
        this.bOf = wK.optJSONObject("data");
        if (this.bOf == null) {
            this.bOf = new JSONObject();
        }
        this.bOs = wK.optInt("callbackId", 0);
        this.bOt = wK.optBoolean("keepCallback", false);
        AppMethodBeat.o(90723);
    }
}

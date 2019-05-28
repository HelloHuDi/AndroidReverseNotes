package com.tencent.luggage.bridge;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.bridge.g */
public final class C32179g {
    private JSONObject bOf;
    private String bOr;
    int bOs;
    boolean bOt;

    C32179g(C37390m c37390m) {
        AppMethodBeat.m2504i(90723);
        JSONObject wK = c37390m.mo20029wK();
        this.bOr = wK.getString(C8741b.METHOD);
        this.bOf = wK.optJSONObject("data");
        if (this.bOf == null) {
            this.bOf = new JSONObject();
        }
        this.bOs = wK.optInt("callbackId", 0);
        this.bOt = wK.optBoolean("keepCallback", false);
        AppMethodBeat.m2505o(90723);
    }
}

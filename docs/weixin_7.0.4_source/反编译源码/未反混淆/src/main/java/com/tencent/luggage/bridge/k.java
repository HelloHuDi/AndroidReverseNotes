package com.tencent.luggage.bridge;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class k {
    public JSONObject bOf;
    String bOr;
    public int bOs;
    private boolean bOt;
    private f bOw;
    boolean bOx;
    public String bOy;
    public JSONObject bOz;

    k(f fVar, m mVar, boolean z) {
        AppMethodBeat.i(90725);
        this.bOw = fVar;
        JSONObject wK = mVar.wK();
        this.bOr = wK.getString(b.METHOD);
        this.bOf = wK.optJSONObject("data");
        if (this.bOf == null) {
            this.bOf = new JSONObject("{}");
        }
        this.bOx = z;
        this.bOs = wK.optInt("callbackId", 0);
        this.bOt = false;
        this.bOz = new JSONObject();
        AppMethodBeat.o(90725);
    }

    public final void a(String str, JSONObject jSONObject) {
        AppMethodBeat.i(90726);
        if (str == null) {
            str = "";
        }
        this.bOy = str;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        this.bOz = jSONObject;
        if (this.bOs != 0) {
            wM();
        }
        AppMethodBeat.o(90726);
    }

    public final void wM() {
        AppMethodBeat.i(90727);
        this.bOw.a(wN());
        AppMethodBeat.o(90727);
    }

    /* Access modifiers changed, original: final */
    public final e wN() {
        AppMethodBeat.i(90728);
        c cVar = new c(this.bOs, this.bOy, this.bOz, this.bOt);
        AppMethodBeat.o(90728);
        return cVar;
    }
}

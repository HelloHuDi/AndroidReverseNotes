package com.tencent.c.a.a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class g {
    String bFQ = null;
    String cbq = null;
    String cbr = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    long cbs = 0;

    g() {
    }

    static g cn(String str) {
        AppMethodBeat.i(125775);
        g gVar = new g();
        if (s.co(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    gVar.bFQ = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    gVar.cbq = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    gVar.cbr = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    gVar.cbs = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                s.zY();
            }
        }
        AppMethodBeat.o(125775);
        return gVar;
    }

    /* Access modifiers changed, original: final */
    public final int a(g gVar) {
        AppMethodBeat.i(125776);
        if (gVar == null) {
            AppMethodBeat.o(125776);
            return 1;
        } else if (s.cp(this.cbr) && s.cp(gVar.cbr)) {
            if (this.cbr.equals(gVar.cbr)) {
                AppMethodBeat.o(125776);
                return 0;
            } else if (this.cbs >= gVar.cbs) {
                AppMethodBeat.o(125776);
                return 1;
            } else {
                AppMethodBeat.o(125776);
                return -1;
            }
        } else if (s.cp(this.cbr)) {
            AppMethodBeat.o(125776);
            return 1;
        } else {
            AppMethodBeat.o(125776);
            return -1;
        }
    }

    public final String toString() {
        AppMethodBeat.i(125777);
        String jSONObject = zQ().toString();
        AppMethodBeat.o(125777);
        return jSONObject;
    }

    private JSONObject zQ() {
        AppMethodBeat.i(125778);
        JSONObject jSONObject = new JSONObject();
        try {
            s.a(jSONObject, "ui", this.bFQ);
            s.a(jSONObject, "mc", this.cbq);
            s.a(jSONObject, "mid", this.cbr);
            jSONObject.put("ts", this.cbs);
        } catch (JSONException e) {
            s.zY();
        }
        AppMethodBeat.o(125778);
        return jSONObject;
    }
}

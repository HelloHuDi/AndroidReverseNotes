package com.tencent.p124c.p125a.p126a;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.c.a.a.g */
final class C37314g {
    String bFQ = null;
    String cbq = null;
    String cbr = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    long cbs = 0;

    C37314g() {
    }

    /* renamed from: cn */
    static C37314g m62714cn(String str) {
        AppMethodBeat.m2504i(125775);
        C37314g c37314g = new C37314g();
        if (C0916s.m2085co(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c37314g.bFQ = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    c37314g.cbq = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    c37314g.cbr = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    c37314g.cbs = jSONObject.getLong("ts");
                }
            } catch (JSONException e) {
                C0916s.m2089zY();
            }
        }
        AppMethodBeat.m2505o(125775);
        return c37314g;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final int mo60049a(C37314g c37314g) {
        AppMethodBeat.m2504i(125776);
        if (c37314g == null) {
            AppMethodBeat.m2505o(125776);
            return 1;
        } else if (C0916s.m2086cp(this.cbr) && C0916s.m2086cp(c37314g.cbr)) {
            if (this.cbr.equals(c37314g.cbr)) {
                AppMethodBeat.m2505o(125776);
                return 0;
            } else if (this.cbs >= c37314g.cbs) {
                AppMethodBeat.m2505o(125776);
                return 1;
            } else {
                AppMethodBeat.m2505o(125776);
                return -1;
            }
        } else if (C0916s.m2086cp(this.cbr)) {
            AppMethodBeat.m2505o(125776);
            return 1;
        } else {
            AppMethodBeat.m2505o(125776);
            return -1;
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(125777);
        String jSONObject = m62715zQ().toString();
        AppMethodBeat.m2505o(125777);
        return jSONObject;
    }

    /* renamed from: zQ */
    private JSONObject m62715zQ() {
        AppMethodBeat.m2504i(125778);
        JSONObject jSONObject = new JSONObject();
        try {
            C0916s.m2076a(jSONObject, "ui", this.bFQ);
            C0916s.m2076a(jSONObject, "mc", this.cbq);
            C0916s.m2076a(jSONObject, "mid", this.cbr);
            jSONObject.put("ts", this.cbs);
        } catch (JSONException e) {
            C0916s.m2089zY();
        }
        AppMethodBeat.m2505o(125778);
        return jSONObject;
    }
}

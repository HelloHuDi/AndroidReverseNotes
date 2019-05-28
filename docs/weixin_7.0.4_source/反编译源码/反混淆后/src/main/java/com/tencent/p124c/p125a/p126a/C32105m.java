package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p124c.p125a.p126a.C8754b.C8755a;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.c.a.a.m */
final class C32105m {
    private int cbC = 0;
    private JSONObject cbD = null;
    protected Context context = null;

    C32105m(Context context, JSONObject jSONObject) {
        AppMethodBeat.m2504i(125779);
        this.context = context;
        this.cbC = (int) (System.currentTimeMillis() / 1000);
        this.cbD = jSONObject;
        AppMethodBeat.m2505o(125779);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject toJSONObject() {
        AppMethodBeat.m2504i(125780);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.cbC);
            jSONObject.put("si", this.cbC);
            C0916s.m2076a(jSONObject, "ui", C0916s.getImei(this.context));
            C0916s.m2076a(jSONObject, "mc", C0916s.m2078aK(this.context));
            String zS = C8756i.m15580aG(this.context).mo19814zS();
            if (C0916s.m2086cp(zS)) {
                jSONObject.put("mid", zS);
            } else {
                jSONObject.put("mid", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            C8754b c8754b = new C8754b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            if (C8754b.cbd != null) {
                C8755a c8755a = C8754b.cbd;
                jSONObject2.put("sr", new StringBuilder(String.valueOf(c8755a.cbh.widthPixels)).append("*").append(c8755a.cbh.heightPixels).toString());
                C0916s.m2076a(jSONObject2, "av", c8755a.appVersion);
                C0916s.m2076a(jSONObject2, "ch", c8755a.channel);
                C0916s.m2076a(jSONObject2, "mf", c8755a.cbj);
                C0916s.m2076a(jSONObject2, "sv", c8755a.cbg);
                C0916s.m2076a(jSONObject2, "ov", Integer.toString(c8755a.cbi));
                jSONObject2.put("os", 1);
                C0916s.m2076a(jSONObject2, "op", c8755a.cbk);
                C0916s.m2076a(jSONObject2, "lg", c8755a.aOt);
                C0916s.m2076a(jSONObject2, "md", c8755a.model);
                C0916s.m2076a(jSONObject2, "tz", c8755a.timezone);
                if (c8755a.cbm != 0) {
                    jSONObject2.put("jb", c8755a.cbm);
                }
                C0916s.m2076a(jSONObject2, "sd", c8755a.cbl);
                C0916s.m2076a(jSONObject2, "apn", c8755a.packageName);
                if (C0916s.m2077aJ(c8755a.ctx)) {
                    JSONObject jSONObject3 = new JSONObject();
                    C0916s.m2076a(jSONObject3, "bs", C0916s.m2079aL(c8755a.ctx));
                    C0916s.m2076a(jSONObject3, "ss", C0916s.m2080aM(c8755a.ctx));
                    if (jSONObject3.length() > 0) {
                        C0916s.m2076a(jSONObject2, "wf", jSONObject3.toString());
                    }
                }
                JSONArray aN = C0916s.m2081aN(c8755a.ctx);
                if (aN != null && aN.length() > 0) {
                    C0916s.m2076a(jSONObject2, "wflist", aN.toString());
                }
                C0916s.m2076a(jSONObject2, "ram", c8755a.cbn);
                C0916s.m2076a(jSONObject2, "rom", c8755a.cbo);
                C0916s.m2076a(jSONObject2, "im", c8755a.imsi);
            }
            C0916s.m2076a(jSONObject2, "cn", c8754b.cbf);
            if (c8754b.cbe != null) {
                jSONObject2.put("tn", c8754b.cbe);
            }
            jSONObject.put("ev", jSONObject2);
        } catch (Throwable th) {
            C0916s.m2089zY();
        }
        if (this.cbD != null) {
            jSONObject.put("ext", this.cbD);
        }
        AppMethodBeat.m2505o(125780);
        return jSONObject;
    }
}

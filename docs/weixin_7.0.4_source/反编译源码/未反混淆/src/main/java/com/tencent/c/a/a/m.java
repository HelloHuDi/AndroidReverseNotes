package com.tencent.c.a.a;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;

final class m {
    private int cbC = 0;
    private JSONObject cbD = null;
    protected Context context = null;

    m(Context context, JSONObject jSONObject) {
        AppMethodBeat.i(125779);
        this.context = context;
        this.cbC = (int) (System.currentTimeMillis() / 1000);
        this.cbD = jSONObject;
        AppMethodBeat.o(125779);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(125780);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ky", "AVF4T76RVR81");
            jSONObject.put("et", 2);
            jSONObject.put("ts", this.cbC);
            jSONObject.put("si", this.cbC);
            s.a(jSONObject, "ui", s.getImei(this.context));
            s.a(jSONObject, "mc", s.aK(this.context));
            String zS = i.aG(this.context).zS();
            if (s.cp(zS)) {
                jSONObject.put("mid", zS);
            } else {
                jSONObject.put("mid", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            b bVar = new b(this.context);
            JSONObject jSONObject2 = new JSONObject();
            if (b.cbd != null) {
                a aVar = b.cbd;
                jSONObject2.put("sr", new StringBuilder(String.valueOf(aVar.cbh.widthPixels)).append("*").append(aVar.cbh.heightPixels).toString());
                s.a(jSONObject2, "av", aVar.appVersion);
                s.a(jSONObject2, "ch", aVar.channel);
                s.a(jSONObject2, "mf", aVar.cbj);
                s.a(jSONObject2, "sv", aVar.cbg);
                s.a(jSONObject2, "ov", Integer.toString(aVar.cbi));
                jSONObject2.put("os", 1);
                s.a(jSONObject2, "op", aVar.cbk);
                s.a(jSONObject2, "lg", aVar.aOt);
                s.a(jSONObject2, "md", aVar.model);
                s.a(jSONObject2, "tz", aVar.timezone);
                if (aVar.cbm != 0) {
                    jSONObject2.put("jb", aVar.cbm);
                }
                s.a(jSONObject2, "sd", aVar.cbl);
                s.a(jSONObject2, "apn", aVar.packageName);
                if (s.aJ(aVar.ctx)) {
                    JSONObject jSONObject3 = new JSONObject();
                    s.a(jSONObject3, "bs", s.aL(aVar.ctx));
                    s.a(jSONObject3, "ss", s.aM(aVar.ctx));
                    if (jSONObject3.length() > 0) {
                        s.a(jSONObject2, "wf", jSONObject3.toString());
                    }
                }
                JSONArray aN = s.aN(aVar.ctx);
                if (aN != null && aN.length() > 0) {
                    s.a(jSONObject2, "wflist", aN.toString());
                }
                s.a(jSONObject2, "ram", aVar.cbn);
                s.a(jSONObject2, "rom", aVar.cbo);
                s.a(jSONObject2, "im", aVar.imsi);
            }
            s.a(jSONObject2, "cn", bVar.cbf);
            if (bVar.cbe != null) {
                jSONObject2.put("tn", bVar.cbe);
            }
            jSONObject.put("ev", jSONObject2);
        } catch (Throwable th) {
            s.zY();
        }
        if (this.cbD != null) {
            jSONObject.put("ext", this.cbD);
        }
        AppMethodBeat.o(125780);
        return jSONObject;
    }
}

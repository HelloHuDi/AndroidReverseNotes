package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10421b;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.b */
public final class C44697b extends C42517a {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93838);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapCircles", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93838);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiAddMapCircles", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93838);
            return;
        }
        try {
            if (jSONObject.has("circles")) {
                f.aDW();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("circles"));
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    float f2 = C5046bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f3 = C5046bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    int by = C42668g.m75559by(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    int by2 = C42668g.m75559by(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int optInt = jSONObject2.optInt("radius");
                    float a = C42668g.m75553a(jSONObject2, "strokeWidth", 0.0f);
                    C10421b c10421b = new C10421b();
                    double d = (double) f2;
                    double d2 = (double) f3;
                    c10421b.latitude = d;
                    c10421b.longitude = d2;
                    c10421b.radius = optInt;
                    c10421b.strokeColor = by;
                    c10421b.strokeWidth = (int) a;
                    c10421b.fillColor = by2;
                    f.mo21884a(c10421b);
                    i2 = i3 + 1;
                }
            }
            mo67989a(c2241c, i, mo73394j("ok", null), true, f.aDU());
            AppMethodBeat.m2505o(93838);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", e);
            mo67989a(c2241c, i, mo73394j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.m2505o(93838);
        }
    }
}

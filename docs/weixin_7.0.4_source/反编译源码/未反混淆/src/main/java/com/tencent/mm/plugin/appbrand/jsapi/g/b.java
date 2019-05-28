package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93838);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiAddMapCircles", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93838);
            return;
        }
        ab.i("MicroMsg.JsApiAddMapCircles", "data:%s", jSONObject);
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93838);
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
                    float f2 = bo.getFloat(jSONObject2.optString("latitude"), 0.0f);
                    float f3 = bo.getFloat(jSONObject2.optString("longitude"), 0.0f);
                    int by = g.by(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    int by2 = g.by(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int optInt = jSONObject2.optInt("radius");
                    float a = g.a(jSONObject2, "strokeWidth", 0.0f);
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.b.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.g.a.b.b();
                    double d = (double) f2;
                    double d2 = (double) f3;
                    bVar.latitude = d;
                    bVar.longitude = d2;
                    bVar.radius = optInt;
                    bVar.strokeColor = by;
                    bVar.strokeWidth = (int) a;
                    bVar.fillColor = by2;
                    f.a(bVar);
                    i2 = i3 + 1;
                }
            }
            a(cVar, i, j("ok", null), true, f.aDU());
            AppMethodBeat.o(93838);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", e);
            a(cVar, i, j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.o(93838);
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "eraseMapLines";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93844);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiEraseMapLines", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93844);
            return;
        }
        ab.i("MicroMsg.JsApiEraseMapLines", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93844);
        } else if (jSONObject.has("lines")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    String optString = jSONObject2.optString("id");
                    if (!bo.isNullOrNil(optString)) {
                        h hVar = null;
                        JSONObject optJSONObject = jSONObject2.optJSONObject("point");
                        if (optJSONObject != null) {
                            hVar = new h((double) bo.getFloat(optJSONObject.optString("latitude"), 0.0f), (double) bo.getFloat(optJSONObject.optString("longitude"), 0.0f));
                        }
                        if (hVar != null) {
                            f.a(optString, jSONObject2.optInt(FirebaseAnalytics.b.INDEX, 0), hVar, jSONObject2.optBoolean("clear", true));
                        }
                    }
                }
                a(cVar, i, j("ok", null), true, f.aDU());
                AppMethodBeat.o(93844);
            } catch (JSONException e) {
                ab.c("MicroMsg.JsApiEraseMapLines", "", e);
                a(cVar, i, j("fail:internal error", null), false, f.aDU());
                AppMethodBeat.o(93844);
            }
        } else {
            ab.e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
            a(cVar, i, j("fail:invalid data", null), false, f.aDU());
            AppMethodBeat.o(93844);
        }
    }
}

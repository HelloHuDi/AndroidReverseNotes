package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93851);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93851);
            return;
        }
        ab.i("MicroMsg.JsApiIncludeMapPoints", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93851);
            return;
        }
        try {
            if (jSONObject.has("points")) {
                ArrayList arrayList = new ArrayList();
                String optString = jSONObject.optString("points");
                if (!bo.isNullOrNil(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        arrayList.add(new h((double) bo.getFloat(jSONObject2.optString("latitude"), 0.0f), (double) bo.getFloat(jSONObject2.optString("longitude"), 0.0f)) {
                        });
                    }
                }
                int i3 = 0;
                String optString2 = jSONObject.optString("padding");
                if (!bo.isNullOrNil(optString2)) {
                    i3 = g.a(new JSONArray(optString2), 0);
                }
                if (arrayList.size() > 0) {
                    f.h(arrayList, i3);
                }
            }
            a(cVar, i, j("ok", null), true, f.aDU());
            AppMethodBeat.o(93851);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", e);
            cVar.M(i, j("fail:internal error", null));
            AppMethodBeat.o(93851);
        }
    }
}

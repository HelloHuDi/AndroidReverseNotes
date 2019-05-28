package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.v;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 492;
    public static final String NAME = "addMapPolygons";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93843);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiAddMapPolygons", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93843);
            return;
        }
        ab.i("MicroMsg.JsApiAddMapPolygons", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93843);
            return;
        }
        try {
            if (jSONObject.has("polygons")) {
                f.aEb();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("polygons"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        arrayList.add(new h((double) bo.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) bo.getFloat(jSONObject3.optString("longitude"), 0.0f)) {
                        });
                    }
                    int by = g.by(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int by2 = g.by(jSONObject2.optString("strokeColor", ""), Color.parseColor("#000000"));
                    int a = g.a(jSONObject2, "strokeWidth", 0);
                    int optInt = jSONObject2.optInt("zIndex", 0);
                    v vVar = new v();
                    vVar.hNV = new ArrayList();
                    vVar.hNV.addAll(arrayList);
                    vVar.fillColor = by;
                    vVar.strokeWidth = a;
                    vVar.strokeColor = by2;
                    vVar.zIndex = optInt;
                    f.a(vVar);
                }
            } else {
                ab.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
            }
            a(cVar, i, j("ok", null), true, f.aDU());
            AppMethodBeat.o(93843);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", e);
            a(cVar, i, j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.o(93843);
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.g;

import android.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.j;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93841);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiAddMapLines", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93841);
            return;
        }
        ab.i("MicroMsg.JsApiAddMapLines", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93841);
            return;
        }
        int optInt;
        c cVar2;
        try {
            if (jSONObject.has("lines")) {
                f.aDY();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    int i3;
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        arrayList.add(new h((double) bo.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) bo.getFloat(jSONObject3.optString("longitude"), 0.0f)) {
                        });
                    }
                    String optString = jSONObject2.optString("id");
                    int by = g.by(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    optInt = jSONObject2.optInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, -1);
                    int a = g.a(jSONObject2, "width", 0);
                    boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                    int by2 = g.by(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                    i3 = g.a(jSONObject2, "borderWidth", 0);
                    boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                    String optString2 = jSONObject2.optString("arrowIconPath", "");
                    int a2 = g.a(jSONObject2, "arrowGap", 0);
                    j jVar = new j();
                    jVar.id = optString;
                    jVar.style = optInt;
                    jVar.hNV = new ArrayList();
                    jVar.hNV.addAll(arrayList);
                    jVar.color = by;
                    jVar.width = a;
                    jVar.hNW = optBoolean;
                    jVar.borderColor = by2;
                    jVar.borderWidth = i3;
                    jVar.hNX = optBoolean2;
                    jVar.hNZ = a2;
                    if (optBoolean2) {
                        jVar.hNY = ((com.tencent.mm.plugin.appbrand.d.b) cVar.B(com.tencent.mm.plugin.appbrand.d.b.class)).b(cVar, optString2);
                    }
                    optString = jSONObject2.optString("buildingId");
                    String optString3 = jSONObject2.optString("floorName");
                    jVar.buildingId = optString;
                    jVar.floorName = optString3;
                    j jVar2 = jVar;
                    f.a(jVar2, (a) cVar.B(a.class));
                }
            } else {
                ab.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
            }
            cVar2 = cVar;
            optInt = i;
            a(cVar2, optInt, j("ok", null), true, f.aDU());
            AppMethodBeat.o(93841);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", e);
            cVar2 = cVar;
            optInt = i;
            a(cVar2, optInt, j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.o(93841);
        }
    }
}

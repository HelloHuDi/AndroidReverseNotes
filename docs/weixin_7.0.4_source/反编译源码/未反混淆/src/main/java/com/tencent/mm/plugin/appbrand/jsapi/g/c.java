package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    static class a extends ah {
        private static final int CTRL_INDEX = 143;
        private static final String NAME = "onMapControlClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93840);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiAddMapControls", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93840);
            return;
        }
        ab.d("MicroMsg.JsApiAddMapControls", "data:%s", jSONObject.toString());
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93840);
            return;
        }
        try {
            if (jSONObject.has("controls")) {
                f.aDX();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("controls"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    com.tencent.mm.plugin.appbrand.jsapi.g.a.b.c cVar2 = new com.tencent.mm.plugin.appbrand.jsapi.g.a.b.c();
                    cVar2.hNN = ((com.tencent.mm.plugin.appbrand.d.b) cVar.B(com.tencent.mm.plugin.appbrand.d.b.class)).b(cVar, jSONObject2.optString("iconPath"));
                    cVar2.hNO = jSONObject2.optBoolean("clickable");
                    cVar2.data = jSONObject2.optString("data");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("position");
                    int a = g.a(jSONObject3, "left", 0);
                    int a2 = g.a(jSONObject3, "top", 0);
                    cVar2.left = a;
                    cVar2.top = a2;
                    if (jSONObject3.has("width")) {
                        cVar2.width = g.a(jSONObject3, "width", 0);
                    }
                    if (jSONObject3.has("height")) {
                        cVar2.height = g.a(jSONObject3, "height", 0);
                    }
                    if (jSONObject2.optBoolean("clickable")) {
                        final int B = f.B(jSONObject);
                        f.a(cVar2, new m() {
                            public final void Bf(String str) {
                                AppMethodBeat.i(93839);
                                a aVar = new a();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("mapId", B);
                                    jSONObject.put("data", str);
                                } catch (JSONException e) {
                                    ab.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", e);
                                }
                                aVar.AM(jSONObject.toString());
                                cVar.b(aVar);
                                AppMethodBeat.o(93839);
                            }
                        }, (com.tencent.mm.plugin.appbrand.d.a) cVar.B(com.tencent.mm.plugin.appbrand.d.a.class));
                    } else {
                        f.a(cVar2, null, (com.tencent.mm.plugin.appbrand.d.a) cVar.B(com.tencent.mm.plugin.appbrand.d.a.class));
                    }
                }
            }
            a(cVar, i, j("ok", null), true, f.aDU());
            AppMethodBeat.o(93840);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", e);
            a(cVar, i, j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.o(93840);
        }
    }
}

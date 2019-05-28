package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class t extends a {
    public static final int CTRL_INDEX = 526;
    public static final String NAME = "setMapIndoorFloor";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93871);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiSetMapIndoorFloor", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93871);
            return;
        }
        ab.i("MicroMsg.JsApiSetMapIndoorFloor", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiSetMapIndoorFloor", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93871);
            return;
        }
        f.ci(jSONObject.optString("buildingId"), jSONObject.optString("floorName"));
        a(cVar, i, j("ok", null), true, f.aDU());
        AppMethodBeat.o(93871);
    }
}

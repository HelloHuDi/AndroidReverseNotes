package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 144;
    public static final String NAME = "getMapCenterLocation";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93845);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetMapCenterLocation", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93845);
            return;
        }
        ab.i("MicroMsg.JsApiGetMapCenterLocation", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiGetMapCenterLocation", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93845);
            return;
        }
        HashMap hashMap = new HashMap();
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h aDV = f.aDV();
        hashMap.put("latitude", Double.valueOf(aDV.latitude));
        hashMap.put("longitude", Double.valueOf(aDV.longitude));
        ab.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", hashMap.toString());
        a(cVar, i, j("ok", hashMap), true, f.aDU());
        AppMethodBeat.o(93845);
    }
}

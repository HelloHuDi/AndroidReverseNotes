package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapSkew";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93850);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetMapSkew", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93850);
            return;
        }
        ab.i("MicroMsg.JsApiGetMapSkew", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiGetMapSkew", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93850);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("skew", Float.valueOf(f.getSkew()));
        ab.i("MicroMsg.JsApiGetMapSkew", "getMapSkew ok, values:%s", hashMap.toString());
        a(cVar, i, j("ok", hashMap), true, f.aDU());
        AppMethodBeat.o(93850);
    }
}

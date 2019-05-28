package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.model.WMElement;
import java.util.HashMap;
import org.json.JSONObject;

public final class l extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapScale";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93849);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetMapScale", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93849);
            return;
        }
        ab.i("MicroMsg.JsApiGetMapScale", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiGetMapScale", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93849);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(WMElement.ANIMATE_TYPE_SCALE, Integer.valueOf(f.getZoomLevel()));
        ab.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", hashMap.toString());
        a(cVar, i, j("ok", hashMap), true, f.aDU());
        AppMethodBeat.o(93849);
    }
}

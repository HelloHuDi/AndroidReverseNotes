package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.x;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRegion";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93847);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetMapRegion", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93847);
            return;
        }
        ab.i("MicroMsg.JsApiGetMapRegion", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiGetMapRegion", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93847);
            return;
        }
        x xVar = f.aDQ().hOo;
        if (xVar == null) {
            ab.e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
            cVar.M(i, j("fail:visibleRegion is null", null));
            AppMethodBeat.o(93847);
            return;
        }
        i iVar = xVar.hOp;
        if (iVar == null) {
            ab.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
            cVar.M(i, j("fail:latLngBounds is null", null));
            AppMethodBeat.o(93847);
            return;
        }
        h hVar = iVar.hNT;
        h hVar2 = iVar.hNU;
        HashMap hashMap = new HashMap();
        if (hVar != null) {
            hashMap.put("latitude", Double.valueOf(hVar.latitude));
            hashMap.put("longitude", Double.valueOf(hVar.longitude));
        }
        HashMap hashMap2 = new HashMap();
        if (hVar2 != null) {
            hashMap2.put("latitude", Double.valueOf(hVar2.latitude));
            hashMap2.put("longitude", Double.valueOf(hVar2.longitude));
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("southwest", hashMap);
        hashMap3.put("northeast", hashMap2);
        ab.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", hashMap3.toString());
        a(cVar, i, j("ok", hashMap3), true, f.aDU());
        AppMethodBeat.o(93847);
    }
}

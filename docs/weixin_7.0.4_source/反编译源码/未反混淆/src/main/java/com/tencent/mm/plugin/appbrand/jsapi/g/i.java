package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_INDEX = 525;
    public static final String NAME = "getMapIndoorFloor";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93846);
        super.a(cVar, jSONObject, i);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiGetMapActiveIndoorInfo", "data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(93846);
            return;
        }
        ab.i("MicroMsg.JsApiGetMapActiveIndoorInfo", "data:%s", jSONObject);
        b f = f(cVar, jSONObject);
        if (f == null) {
            ab.e("MicroMsg.JsApiGetMapActiveIndoorInfo", "mapView is null, return");
            cVar.M(i, j("fail:mapview is null", null));
            AppMethodBeat.o(93846);
            return;
        }
        e aDT = f.aDT();
        HashMap hashMap = new HashMap();
        if (aDT != null) {
            try {
                hashMap.put("buildingId", aDT.buildingId);
                hashMap.put("buildingName", aDT.buildingName);
                if (aDT.hNP != null && aDT.hNP.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (f fVar : aDT.hNP) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", fVar.floorName);
                        jSONArray.put(jSONObject2);
                    }
                    hashMap.put("floorList", jSONArray);
                }
                hashMap.put("floorIndex", Integer.valueOf(aDT.hNQ));
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiGetMapActiveIndoorInfo", "put JSON data error : %s", e);
            }
        }
        ab.i("MicroMsg.JsApiGetMapActiveIndoorInfo", "getMapActiveIndoorInfo ok, values:%s", hashMap.toString());
        a(cVar, i, j("ok", hashMap), true, f.aDU());
        AppMethodBeat.o(93846);
    }
}

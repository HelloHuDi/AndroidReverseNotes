package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 223;
    private static final String NAME = "getBeacons";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94359);
        ab.d("MicroMsg.JsApiGetBeacons", "getBeacons!");
        JSONArray jSONArray = new JSONArray();
        a.a AZ = a.AZ(cVar.getAppId());
        if (AZ != null) {
            Map map = AZ.hJZ;
            if (map != null && map.size() > 0) {
                for (JSONObject put : map.values()) {
                    jSONArray.put(put);
                }
            }
        } else {
            ab.e("MicroMsg.JsApiGetBeacons", "not found device");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("beacons", jSONArray);
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(94359);
    }
}

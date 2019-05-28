package com.tencent.luggage.f.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b implements c {
    public com.tencent.mm.plugin.appbrand.jsapi.g.a.b a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(51147);
        if (cVar == null || jSONObject == null) {
            AppMethodBeat.o(51147);
            return null;
        }
        Context context = cVar.getContext();
        String optString = jSONObject.optString("theme", "");
        int optInt = jSONObject.optInt("mapType", 1);
        String optString2 = jSONObject.optString("subKey", "");
        String appId = cVar.getAppId();
        int optInt2 = jSONObject.optInt("styleId", 0);
        String g = f.g(cVar, jSONObject);
        HashMap hashMap = new HashMap(5);
        hashMap.put("theme", optString);
        hashMap.put("mapType", Integer.valueOf(optInt));
        hashMap.put("subKey", optString2);
        hashMap.put("subId", appId);
        hashMap.put("styleId", Integer.valueOf(optInt2));
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b aVar = new a(context, g, hashMap);
        AppMethodBeat.o(51147);
        return aVar;
    }

    public com.tencent.mm.plugin.appbrand.jsapi.g.a.b a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.i(51148);
        if (context == null) {
            AppMethodBeat.o(51148);
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b aVar = new a(context, str, map);
        AppMethodBeat.o(51148);
        return aVar;
    }
}

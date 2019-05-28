package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public class b extends u<com.tencent.mm.plugin.appbrand.page.u> {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(74752);
        com.tencent.mm.plugin.appbrand.page.u uVar = (com.tencent.mm.plugin.appbrand.page.u) cVar;
        HashMap hashMap = new HashMap();
        hashMap.put(TencentExtraKeys.LOCATION_KEY_ROUTE, uVar.getURL());
        ab.d("MicroMsg.JsApiGetCurrentRoute", "getCurrentRoute : %s", j("ok", hashMap));
        String j = j("ok", hashMap);
        AppMethodBeat.o(74752);
        return j;
    }
}

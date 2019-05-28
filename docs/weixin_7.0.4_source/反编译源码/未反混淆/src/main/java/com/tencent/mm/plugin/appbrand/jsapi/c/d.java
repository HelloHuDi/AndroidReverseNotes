package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    static class a extends ah {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94366);
        com.tencent.luggage.g.d.i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        com.tencent.mm.plugin.appbrand.jsapi.c.a.a AZ = a.AZ(cVar.getAppId());
        HashMap hashMap;
        if (AZ == null) {
            com.tencent.luggage.g.d.e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            cVar.M(i, j("fail:not start", hashMap));
            AppMethodBeat.o(94366);
            return;
        }
        if (AZ.EH()) {
            a.remove(cVar.getAppId());
            new HashMap().put("errCode", Integer.valueOf(0));
            cVar.M(i, j("ok", null));
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            cVar.M(i, j("fail:not start", hashMap));
        }
        a aVar = new a();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", a.hDs);
            jSONObject2.put("discovering", false);
        } catch (JSONException e) {
            com.tencent.luggage.g.d.e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", e);
        }
        com.tencent.luggage.g.d.i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject2.toString());
        aVar.b(cVar, cVar.aBw()).AM(jSONObject2.toString()).aCj();
        AppMethodBeat.o(94366);
    }
}

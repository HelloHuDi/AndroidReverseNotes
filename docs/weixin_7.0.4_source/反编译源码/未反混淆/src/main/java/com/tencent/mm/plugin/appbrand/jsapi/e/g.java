package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.b.a;
import com.tencent.mm.plugin.appbrand.s.b.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public class g<CONTEXT extends c> extends a<CONTEXT> {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";

    public final /* bridge */ /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(93826);
        super.a(cVar, jSONObject, i);
        AppMethodBeat.o(93826);
    }

    public final void c(final CONTEXT context, JSONObject jSONObject, final int i) {
        Object obj;
        AppMethodBeat.i(93825);
        String optString = jSONObject.optString("type", "wgs84");
        if (bo.isNullOrNil(optString)) {
            obj = "wgs84";
        } else {
            String obj2 = optString;
        }
        final boolean optBoolean = jSONObject.optBoolean("altitude", false);
        ab.v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s, needAltitude = %b", obj2, Boolean.valueOf(optBoolean));
        HashMap hashMap;
        if (!"wgs84".equals(obj2) && !"gcj02".equals(obj2)) {
            ab.e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", obj2);
            hashMap = new HashMap(1);
            hashMap.put("errCode", Integer.valueOf(-1));
            context.M(i, j("fail:invalid data", hashMap));
            AppMethodBeat.o(93825);
        } else if (a.o(context)) {
            p(context);
            ((a) e.B(a.class)).a(obj2, new b() {
                public final void a(int i, String str, a.a aVar) {
                    AppMethodBeat.i(93824);
                    ab.i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i), str, aVar);
                    g.this.aDD();
                    HashMap hashMap;
                    if (i == 0) {
                        hashMap = new HashMap(4);
                        hashMap.put("latitude", Double.valueOf(aVar.latitude));
                        hashMap.put("longitude", Double.valueOf(aVar.longitude));
                        hashMap.put("speed", Double.valueOf(aVar.iSf));
                        hashMap.put("accuracy", Double.valueOf(aVar.iSg));
                        if (optBoolean) {
                            hashMap.put("altitude", Double.valueOf(aVar.altitude));
                        }
                        if (com.tencent.mm.sdk.a.b.dnO()) {
                            hashMap.put("provider", aVar.bIy);
                        }
                        hashMap.put("verticalAccuracy", Integer.valueOf(0));
                        hashMap.put("horizontalAccuracy", Double.valueOf(aVar.iSg));
                        if (!bo.isNullOrNil(aVar.buildingId)) {
                            hashMap.put("buildingId", aVar.buildingId);
                            hashMap.put("floorName", aVar.floorName);
                        }
                        context.M(i, g.this.j("ok", hashMap));
                        AppMethodBeat.o(93824);
                        return;
                    }
                    hashMap = new HashMap(1);
                    hashMap.put("errCode", Integer.valueOf(i));
                    context.M(i, g.this.j("fail:".concat(String.valueOf(str)), hashMap));
                    AppMethodBeat.o(93824);
                }
            }, e(context, jSONObject));
            AppMethodBeat.o(93825);
        } else {
            hashMap = new HashMap(1);
            hashMap.put("errCode", Integer.valueOf(-2));
            context.M(i, j("fail:system permission denied", hashMap));
            AppMethodBeat.o(93825);
        }
    }

    /* Access modifiers changed, original: protected */
    public Bundle e(CONTEXT context, JSONObject jSONObject) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void p(CONTEXT context) {
    }

    /* Access modifiers changed, original: protected */
    public void aDD() {
    }
}

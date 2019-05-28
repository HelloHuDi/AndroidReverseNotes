package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.luggage.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class n extends b {
    public static Integer ikm;

    private static int getMapType() {
        AppMethodBeat.i(132110);
        int intValue;
        if (ikm != null) {
            intValue = ikm.intValue();
            AppMethodBeat.o(132110);
            return intValue;
        }
        a aVar = a.b.eGM;
        c ll = a.ll("100487");
        if (ll == null || !ll.isValid()) {
            ab.i("MicroMsg.WxaMapViewFactory", "[sMapType] item is null");
            AppMethodBeat.o(132110);
            return 1;
        }
        ikm = Integer.valueOf(bo.getInt((String) ll.dru().get("MapType"), 1));
        ab.i("MicroMsg.WxaMapViewFactory", "sMapType:%d", ikm);
        intValue = ikm.intValue();
        AppMethodBeat.o(132110);
        return intValue;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.g.a.b a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(132111);
        if (jSONObject != null) {
            try {
                jSONObject.put("mapType", getMapType());
            } catch (JSONException e) {
                ab.c("MicroMsg.WxaMapViewFactory", "", e);
            }
        }
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b a = super.a(cVar, jSONObject);
        AppMethodBeat.o(132111);
        return a;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.g.a.b a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.i(132112);
        com.tencent.mm.plugin.appbrand.jsapi.g.a.b bVar;
        if (context == null) {
            AppMethodBeat.o(132112);
            return null;
        } else if (f.a((Map) map, "mapType", getMapType()) == 2) {
            bVar = new com.tencent.mm.plugin.appbrand.jsapi.u.a.b(context, str, map);
            AppMethodBeat.o(132112);
            return bVar;
        } else {
            bVar = super.a(context, str, map);
            AppMethodBeat.o(132112);
            return bVar;
        }
    }
}

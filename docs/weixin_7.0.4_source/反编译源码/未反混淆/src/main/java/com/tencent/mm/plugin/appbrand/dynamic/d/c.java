package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.d;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.z.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public c(int i) {
        super(d.NAME, i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10829);
        Context context = aVar.getContext();
        HashMap hashMap = new HashMap();
        if (!at.isConnected(context)) {
            hashMap.put("networkType", "none");
        } else if (at.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (at.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (at.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (at.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        aVar2.au(a(true, "", (Map) hashMap));
        AppMethodBeat.o(10829);
    }
}

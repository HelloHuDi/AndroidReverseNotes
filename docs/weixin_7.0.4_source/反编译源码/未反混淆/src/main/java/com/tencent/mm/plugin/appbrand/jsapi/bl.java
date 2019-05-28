package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bl extends a<d> {
    public static final int CTRL_INDEX = 283;
    public static final String NAME = "traceEvent";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101955);
        d dVar = (d) cVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        if (!AppBrandPerformanceManager.b((b) dVar.getRuntime()) || optJSONArray == null) {
            dVar.M(i, j("fail", null));
            AppMethodBeat.o(101955);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("category");
                    String optString2 = optJSONObject.optString("name");
                    long optLong = optJSONObject.optLong("start");
                    long optLong2 = optJSONObject.optLong("end");
                    String optString3 = optJSONObject.optString("phase");
                    String optString4 = optJSONObject.optString("args");
                    if (!bo.isNullOrNil(optString2)) {
                        c.a(dVar.getAppId(), optString, optString2, optString3, optLong, optLong2, optString4);
                    }
                }
                i2 = i3 + 1;
            } else {
                dVar.M(i, j("ok", null));
                AppMethodBeat.o(101955);
                return;
            }
        }
    }
}

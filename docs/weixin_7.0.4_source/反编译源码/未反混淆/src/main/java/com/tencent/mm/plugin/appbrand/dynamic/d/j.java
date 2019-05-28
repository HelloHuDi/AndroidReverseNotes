package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.z.b.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends a {
    public j(int i) {
        super("reportIDKey", i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10851);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.au(a(false, "dataArray is null", null));
            AppMethodBeat.o(10851);
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                h.pYm.a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", e.getMessage());
            }
        }
        aVar2.au(a(true, "", null));
        AppMethodBeat.o(10851);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends a {
    private static final int CTRL_INDEX = 64;
    private static final String NAME = "reportIDKey";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(73182);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(73182);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                h.pYm.a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", e.getMessage());
            }
        }
        cVar.M(i, j("ok", null));
        AppMethodBeat.o(73182);
    }
}

package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.b.b;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends a {
    public k(int i) {
        super(f.NAME, i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10852);
        if (com.tencent.mm.plugin.appbrand.dynamic.k.Aa(aVar.Qy().getString("__page_view_id", null)) == null) {
            aVar2.au(a(false, "JsApi Framework Context is null", null));
            AppMethodBeat.o(10852);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.au(a(false, "dataArray is null", null));
            AppMethodBeat.o(10852);
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt > 0 && !bo.isNullOrNil(optString)) {
                    h.pYm.e(optInt, r2.getAppId(), Integer.valueOf(r2.azH()), Integer.valueOf(com.tencent.mm.plugin.appbrand.dynamic.k.b.nO(r2.avn()) + 1), optString);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", e);
            }
        }
        aVar2.au(a(true, "", null));
        AppMethodBeat.o(10852);
    }
}

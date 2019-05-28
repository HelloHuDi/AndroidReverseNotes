package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public class f extends a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131431);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(131431);
            return;
        }
        int optInt = jSONObject.optInt("version", -1);
        if (((h) cVar.aa(h.class)) == null) {
            ab.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            cVar.M(i, j("fail", null));
            AppMethodBeat.o(131431);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt2 = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt2 > 0 && !bo.isNullOrNil(optString)) {
                    if (optInt >= 2) {
                        if (com.tencent.mm.plugin.appbrand.report.quality.a.DG(cVar.getAppId()) == null) {
                            cVar.M(i, j("fail NULL QualitySystem instance", null));
                            AppMethodBeat.o(131431);
                            return;
                        }
                        ab.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", Integer.valueOf(optInt2), cVar.getAppId(), Integer.valueOf(r0.hhd.gVu), Integer.valueOf(r0.hhd.gVt + 1), optString);
                        com.tencent.mm.plugin.report.service.h.pYm.e(optInt2, r6.igT, r6.appId, Integer.valueOf(r6.iDa), Integer.valueOf(r6.iCZ), Integer.valueOf(r6.apptype), optString);
                    } else {
                        ab.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", Integer.valueOf(optInt2), cVar.getAppId(), Integer.valueOf(r0.hhd.gVu), Integer.valueOf(r0.hhd.gVt + 1), optString);
                        com.tencent.mm.plugin.report.service.h.pYm.e(optInt2, cVar.getAppId(), Integer.valueOf(r0.hhd.gVu), Integer.valueOf(r0.hhd.gVt + 1), optString);
                    }
                }
            } catch (Exception e) {
                ab.e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", e.getMessage());
            }
        }
        cVar.M(i, j("ok", null));
        AppMethodBeat.o(131431);
    }
}

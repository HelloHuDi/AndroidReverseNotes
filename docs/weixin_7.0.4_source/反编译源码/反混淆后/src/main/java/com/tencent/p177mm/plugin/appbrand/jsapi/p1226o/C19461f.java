package com.tencent.p177mm.plugin.appbrand.jsapi.p1226o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.f */
public class C19461f extends C10296a {
    public static final int CTRL_INDEX = 63;
    public static final String NAME = "reportKeyValue";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131431);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(131431);
            return;
        }
        int optInt = jSONObject.optInt("version", -1);
        if (((C16597h) c2241c.mo5937aa(C16597h.class)) == null) {
            C4990ab.m7412e("MicroMsg.JsApiReportKeyValue", "config is Null!");
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131431);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt2 = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt2 > 0 && !C5046bo.isNullOrNil(optString)) {
                    if (optInt >= 2) {
                        if (C27285a.m43319DG(c2241c.getAppId()) == null) {
                            c2241c.mo6107M(i, mo73394j("fail NULL QualitySystem instance", null));
                            AppMethodBeat.m2505o(131431);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", Integer.valueOf(optInt2), c2241c.getAppId(), Integer.valueOf(r0.hhd.gVu), Integer.valueOf(r0.hhd.gVt + 1), optString);
                        C7060h.pYm.mo8381e(optInt2, r6.igT, r6.appId, Integer.valueOf(r6.iDa), Integer.valueOf(r6.iCZ), Integer.valueOf(r6.apptype), optString);
                    } else {
                        C4990ab.m7417i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", Integer.valueOf(optInt2), c2241c.getAppId(), Integer.valueOf(r0.hhd.gVu), Integer.valueOf(r0.hhd.gVt + 1), optString);
                        C7060h.pYm.mo8381e(optInt2, c2241c.getAppId(), Integer.valueOf(r0.hhd.gVu), Integer.valueOf(r0.hhd.gVt + 1), optString);
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", e.getMessage());
            }
        }
        c2241c.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(131431);
    }
}

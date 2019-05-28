package com.tencent.p177mm.plugin.appbrand.jsapi.p1226o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.o.e */
public class C19460e extends C10296a {
    private static final int CTRL_INDEX = 64;
    private static final String NAME = "reportIDKey";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(73182);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(73182);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C7060h.pYm.mo8378a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", e.getMessage());
            }
        }
        c2241c.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(73182);
    }
}

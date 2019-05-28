package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C45548k;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p892k.C33167b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p1226o.C19461f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.k */
public final class C33158k extends C10200a {
    public C33158k(int i) {
        super(C19461f.NAME, i);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10852);
        if (C45548k.m83998Aa(c36405a.mo11733Qy().getString("__page_view_id", null)) == null) {
            c16115a.mo11732au(mo57327a(false, "JsApi Framework Context is null", null));
            AppMethodBeat.m2505o(10852);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            c16115a.mo11732au(mo57327a(false, "dataArray is null", null));
            AppMethodBeat.m2505o(10852);
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt > 0 && !C5046bo.isNullOrNil(optString)) {
                    C7060h.pYm.mo8381e(optInt, r2.getAppId(), Integer.valueOf(r2.azH()), Integer.valueOf(C33167b.m54218nO(r2.avn()) + 1), optString);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", e);
            }
        }
        c16115a.mo11732au(mo57327a(true, "", null));
        AppMethodBeat.m2505o(10852);
    }
}

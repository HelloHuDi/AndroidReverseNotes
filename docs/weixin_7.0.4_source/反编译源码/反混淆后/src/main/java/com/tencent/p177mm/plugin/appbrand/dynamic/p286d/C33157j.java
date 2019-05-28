package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.j */
public final class C33157j extends C10200a {
    public C33157j(int i) {
        super("reportIDKey", i);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10851);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            c16115a.mo11732au(mo57327a(false, "dataArray is null", null));
            AppMethodBeat.m2505o(10851);
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                C7060h.pYm.mo8378a((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", e.getMessage());
            }
        }
        c16115a.mo11732au(mo57327a(true, "", null));
        AppMethodBeat.m2505o(10851);
    }
}

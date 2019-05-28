package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.LogInfo;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.debugger.C19180a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.f */
public final class C2135f extends C10200a {
    public C2135f(int i) {
        super("log", i);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10832);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dataArray");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.f16124ts = jSONObject2.optLong("ts");
                    logInfo.level = jSONObject2.optInt("level") + 1;
                    logInfo.message = jSONObject2.optString("msg");
                    arrayList.add(logInfo);
                    C4990ab.m7411d("MicroMsg.JsApiFunc_Log", "ts : %s, level : %d, msg : %s", Util.m8738nz(logInfo.f16124ts), Integer.valueOf(logInfo.level), logInfo.message);
                }
            }
            C19180a.m29836c(c36405a.mo11733Qy().getString("__page_view_id", null), arrayList);
            c16115a.mo11732au(mo57327a(true, "", null));
            AppMethodBeat.m2505o(10832);
        } catch (JSONException e) {
            c16115a.mo11732au(mo57327a(false, "dataArray is null", null));
            AppMethodBeat.m2505o(10832);
        }
    }
}

package com.tencent.luggage.p815f.p816a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C31303c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C45601a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.luggage.f.a.b */
public class C8868b implements C31303c {
    /* renamed from: a */
    public C10406b mo20061a(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(51147);
        if (c2241c == null || jSONObject == null) {
            AppMethodBeat.m2505o(51147);
            return null;
        }
        Context context = c2241c.getContext();
        String optString = jSONObject.optString("theme", "");
        int optInt = jSONObject.optInt("mapType", 1);
        String optString2 = jSONObject.optString("subKey", "");
        String appId = c2241c.getAppId();
        int optInt2 = jSONObject.optInt("styleId", 0);
        String g = C38303f.m64817g(c2241c, jSONObject);
        HashMap hashMap = new HashMap(5);
        hashMap.put("theme", optString);
        hashMap.put("mapType", Integer.valueOf(optInt));
        hashMap.put("subKey", optString2);
        hashMap.put("subId", appId);
        hashMap.put("styleId", Integer.valueOf(optInt2));
        C10406b c45601a = new C45601a(context, g, hashMap);
        AppMethodBeat.m2505o(51147);
        return c45601a;
    }

    /* renamed from: a */
    public C10406b mo20060a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.m2504i(51148);
        if (context == null) {
            AppMethodBeat.m2505o(51148);
            return null;
        }
        C10406b c45601a = new C45601a(context, str, map);
        AppMethodBeat.m2505o(51148);
        return c45601a;
    }
}

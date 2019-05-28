package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.p177mm.plugin.appbrand.performance.C33487c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bl */
public final class C38274bl extends C10296a<C2119d> {
    public static final int CTRL_INDEX = 283;
    public static final String NAME = "traceEvent";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101955);
        C2119d c2119d = (C2119d) c2241c;
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        if (!AppBrandPerformanceManager.m43291b((C25697b) c2119d.getRuntime()) || optJSONArray == null) {
            c2119d.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(101955);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("category");
                    String optString2 = optJSONObject.optString("name");
                    long optLong = optJSONObject.optLong("start");
                    long optLong2 = optJSONObject.optLong("end");
                    String optString3 = optJSONObject.optString("phase");
                    String optString4 = optJSONObject.optString("args");
                    if (!C5046bo.isNullOrNil(optString2)) {
                        C33487c.m54691a(c2119d.getAppId(), optString, optString2, optString3, optLong, optLong2, optString4);
                    }
                }
                i2 = i3 + 1;
            } else {
                c2119d.mo6107M(i, mo73394j("ok", null));
                AppMethodBeat.m2505o(101955);
                return;
            }
        }
    }
}

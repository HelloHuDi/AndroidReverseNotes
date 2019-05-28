package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10417h;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.n */
public final class C19395n extends C42517a {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93851);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiIncludeMapPoints", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93851);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiIncludeMapPoints", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93851);
            return;
        }
        try {
            if (jSONObject.has("points")) {
                ArrayList arrayList = new ArrayList();
                String optString = jSONObject.optString("points");
                if (!C5046bo.isNullOrNil(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                        arrayList.add(new C10417h((double) C5046bo.getFloat(jSONObject2.optString("latitude"), 0.0f), (double) C5046bo.getFloat(jSONObject2.optString("longitude"), 0.0f)) {
                        });
                    }
                }
                int i3 = 0;
                String optString2 = jSONObject.optString("padding");
                if (!C5046bo.isNullOrNil(optString2)) {
                    i3 = C42668g.m75554a(new JSONArray(optString2), 0);
                }
                if (arrayList.size() > 0) {
                    f.mo21928h(arrayList, i3);
                }
            }
            mo67989a(c2241c, i, mo73394j("ok", null), true, f.aDU());
            AppMethodBeat.m2505o(93851);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", e);
            c2241c.mo6107M(i, mo73394j("fail:internal error", null));
            AppMethodBeat.m2505o(93851);
        }
    }
}

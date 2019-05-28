package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.t */
public final class C2288t extends C42517a {
    public static final int CTRL_INDEX = 526;
    public static final String NAME = "setMapIndoorFloor";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93871);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetMapIndoorFloor", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93871);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiSetMapIndoorFloor", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiSetMapIndoorFloor", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93871);
            return;
        }
        f.mo21913ci(jSONObject.optString("buildingId"), jSONObject.optString("floorName"));
        mo67989a(c2241c, i, mo73394j("ok", null), true, f.aDU());
        AppMethodBeat.m2505o(93871);
    }
}

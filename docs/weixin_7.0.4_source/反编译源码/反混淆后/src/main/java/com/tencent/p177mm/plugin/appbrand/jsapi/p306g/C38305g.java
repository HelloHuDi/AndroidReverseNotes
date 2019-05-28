package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10417h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.g */
public final class C38305g extends C42517a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "eraseMapLines";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93844);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiEraseMapLines", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93844);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiEraseMapLines", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93844);
        } else if (jSONObject.has("lines")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    String optString = jSONObject2.optString("id");
                    if (!C5046bo.isNullOrNil(optString)) {
                        C10417h c10417h = null;
                        JSONObject optJSONObject = jSONObject2.optJSONObject("point");
                        if (optJSONObject != null) {
                            c10417h = new C10417h((double) C5046bo.getFloat(optJSONObject.optString("latitude"), 0.0f), (double) C5046bo.getFloat(optJSONObject.optString("longitude"), 0.0f));
                        }
                        if (c10417h != null) {
                            f.mo21892a(optString, jSONObject2.optInt(C8741b.INDEX, 0), c10417h, jSONObject2.optBoolean("clear", true));
                        }
                    }
                }
                mo67989a(c2241c, i, mo73394j("ok", null), true, f.aDU());
                AppMethodBeat.m2505o(93844);
            } catch (JSONException e) {
                C4990ab.m7409c("MicroMsg.JsApiEraseMapLines", "", e);
                mo67989a(c2241c, i, mo73394j("fail:internal error", null), false, f.aDU());
                AppMethodBeat.m2505o(93844);
            }
        } else {
            C4990ab.m7412e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
            mo67989a(c2241c, i, mo73394j("fail:invalid data", null), false, f.aDU());
            AppMethodBeat.m2505o(93844);
        }
    }
}

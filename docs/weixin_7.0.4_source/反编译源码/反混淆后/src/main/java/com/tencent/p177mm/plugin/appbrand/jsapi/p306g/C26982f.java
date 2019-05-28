package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10405v;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10417h;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.f */
public final class C26982f extends C42517a {
    public static final int CTRL_INDEX = 492;
    public static final String NAME = "addMapPolygons";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93843);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapPolygons", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93843);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiAddMapPolygons", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93843);
            return;
        }
        try {
            if (jSONObject.has("polygons")) {
                f.aEb();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("polygons"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        arrayList.add(new C10417h((double) C5046bo.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) C5046bo.getFloat(jSONObject3.optString("longitude"), 0.0f)) {
                        });
                    }
                    int by = C42668g.m75559by(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int by2 = C42668g.m75559by(jSONObject2.optString("strokeColor", ""), Color.parseColor("#000000"));
                    int a = C42668g.m75555a(jSONObject2, "strokeWidth", 0);
                    int optInt = jSONObject2.optInt("zIndex", 0);
                    C10405v c10405v = new C10405v();
                    c10405v.hNV = new ArrayList();
                    c10405v.hNV.addAll(arrayList);
                    c10405v.fillColor = by;
                    c10405v.strokeWidth = a;
                    c10405v.strokeColor = by2;
                    c10405v.zIndex = optInt;
                    f.mo21897a(c10405v);
                }
            } else {
                C4990ab.m7412e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
            }
            mo67989a(c2241c, i, mo73394j("ok", null), true, f.aDU());
            AppMethodBeat.m2505o(93843);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", e);
            mo67989a(c2241c, i, mo73394j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.m2505o(93843);
        }
    }
}

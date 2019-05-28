package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import android.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10417h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10424j;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.d */
public final class C19392d extends C42517a {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93841);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapLines", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93841);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiAddMapLines", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapLines", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93841);
            return;
        }
        int optInt;
        C2241c c2241c2;
        try {
            if (jSONObject.has("lines")) {
                f.aDY();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    int i3;
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                        arrayList.add(new C10417h((double) C5046bo.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) C5046bo.getFloat(jSONObject3.optString("longitude"), 0.0f)) {
                        });
                    }
                    String optString = jSONObject2.optString("id");
                    int by = C42668g.m75559by(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    optInt = jSONObject2.optInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, -1);
                    int a = C42668g.m75555a(jSONObject2, "width", 0);
                    boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                    int by2 = C42668g.m75559by(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                    i3 = C42668g.m75555a(jSONObject2, "borderWidth", 0);
                    boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                    String optString2 = jSONObject2.optString("arrowIconPath", "");
                    int a2 = C42668g.m75555a(jSONObject2, "arrowGap", 0);
                    C10424j c10424j = new C10424j();
                    c10424j.f2876id = optString;
                    c10424j.style = optInt;
                    c10424j.hNV = new ArrayList();
                    c10424j.hNV.addAll(arrayList);
                    c10424j.color = by;
                    c10424j.width = a;
                    c10424j.hNW = optBoolean;
                    c10424j.borderColor = by2;
                    c10424j.borderWidth = i3;
                    c10424j.hNX = optBoolean2;
                    c10424j.hNZ = a2;
                    if (optBoolean2) {
                        c10424j.hNY = ((C33139b) c2241c.mo5936B(C33139b.class)).mo22120b(c2241c, optString2);
                    }
                    optString = jSONObject2.optString("buildingId");
                    String optString3 = jSONObject2.optString("floorName");
                    c10424j.buildingId = optString;
                    c10424j.floorName = optString3;
                    C10424j c10424j2 = c10424j;
                    f.mo21885a(c10424j2, (C19162a) c2241c.mo5936B(C19162a.class));
                }
            } else {
                C4990ab.m7412e("MicroMsg.JsApiAddMapLines", "data has not lines info");
            }
            c2241c2 = c2241c;
            optInt = i;
            mo67989a(c2241c2, optInt, mo73394j("ok", null), true, f.aDU());
            AppMethodBeat.m2505o(93841);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", e);
            c2241c2 = c2241c;
            optInt = i;
            mo67989a(c2241c2, optInt, mo73394j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.m2505o(93841);
        }
    }
}

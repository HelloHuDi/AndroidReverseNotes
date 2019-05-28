package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10410m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10422c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C38303f;
import com.tencent.p177mm.plugin.appbrand.p1219d.C19162a;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.c */
public final class C19389c extends C42517a {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.c$a */
    static class C19391a extends C42467ah {
        private static final int CTRL_INDEX = 143;
        private static final String NAME = "onMapControlClick";

        private C19391a() {
        }

        /* synthetic */ C19391a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93840);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapControls", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93840);
            return;
        }
        C4990ab.m7411d("MicroMsg.JsApiAddMapControls", "data:%s", jSONObject.toString());
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93840);
            return;
        }
        try {
            if (jSONObject.has("controls")) {
                f.aDX();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("controls"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                    C10422c c10422c = new C10422c();
                    c10422c.hNN = ((C33139b) c2241c.mo5936B(C33139b.class)).mo22120b(c2241c, jSONObject2.optString("iconPath"));
                    c10422c.hNO = jSONObject2.optBoolean("clickable");
                    c10422c.data = jSONObject2.optString("data");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("position");
                    int a = C42668g.m75555a(jSONObject3, "left", 0);
                    int a2 = C42668g.m75555a(jSONObject3, "top", 0);
                    c10422c.left = a;
                    c10422c.top = a2;
                    if (jSONObject3.has("width")) {
                        c10422c.width = C42668g.m75555a(jSONObject3, "width", 0);
                    }
                    if (jSONObject3.has("height")) {
                        c10422c.height = C42668g.m75555a(jSONObject3, "height", 0);
                    }
                    if (jSONObject2.optBoolean("clickable")) {
                        final int B = C38303f.m64811B(jSONObject);
                        f.mo21895a(c10422c, new C10410m() {
                            /* renamed from: Bf */
                            public final void mo21934Bf(String str) {
                                AppMethodBeat.m2504i(93839);
                                C19391a c19391a = new C19391a();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("mapId", B);
                                    jSONObject.put("data", str);
                                } catch (JSONException e) {
                                    C4990ab.m7413e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", e);
                                }
                                c19391a.mo61028AM(jSONObject.toString());
                                c2241c.mo6115b(c19391a);
                                AppMethodBeat.m2505o(93839);
                            }
                        }, (C19162a) c2241c.mo5936B(C19162a.class));
                    } else {
                        f.mo21895a(c10422c, null, (C19162a) c2241c.mo5936B(C19162a.class));
                    }
                }
            }
            mo67989a(c2241c, i, mo73394j("ok", null), true, f.aDU());
            AppMethodBeat.m2505o(93840);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", e);
            mo67989a(c2241c, i, mo73394j("fail:internal error", null), false, f.aDU());
            AppMethodBeat.m2505o(93840);
        }
    }
}

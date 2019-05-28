package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10407e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10408f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.i */
public final class C44699i extends C42517a {
    public static final int CTRL_INDEX = 525;
    public static final String NAME = "getMapIndoorFloor";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93846);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetMapActiveIndoorInfo", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93846);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiGetMapActiveIndoorInfo", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetMapActiveIndoorInfo", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93846);
            return;
        }
        C10407e aDT = f.aDT();
        HashMap hashMap = new HashMap();
        if (aDT != null) {
            try {
                hashMap.put("buildingId", aDT.buildingId);
                hashMap.put("buildingName", aDT.buildingName);
                if (aDT.hNP != null && aDT.hNP.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (C10408f c10408f : aDT.hNP) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", c10408f.floorName);
                        jSONArray.put(jSONObject2);
                    }
                    hashMap.put("floorList", jSONArray);
                }
                hashMap.put("floorIndex", Integer.valueOf(aDT.hNQ));
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiGetMapActiveIndoorInfo", "put JSON data error : %s", e);
            }
        }
        C4990ab.m7417i("MicroMsg.JsApiGetMapActiveIndoorInfo", "getMapActiveIndoorInfo ok, values:%s", hashMap.toString());
        mo67989a(c2241c, i, mo73394j("ok", hashMap), true, f.aDU());
        AppMethodBeat.m2505o(93846);
    }
}

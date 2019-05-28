package com.tencent.p177mm.plugin.appbrand.jsapi.p899c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p899c.C33269a.C10354a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.b */
public final class C16644b extends C10296a {
    private static final int CTRL_INDEX = 223;
    private static final String NAME = "getBeacons";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94359);
        C4990ab.m7410d("MicroMsg.JsApiGetBeacons", "getBeacons!");
        JSONArray jSONArray = new JSONArray();
        C10354a AZ = C33269a.m54418AZ(c2241c.getAppId());
        if (AZ != null) {
            Map map = AZ.hJZ;
            if (map != null && map.size() > 0) {
                for (JSONObject put : map.values()) {
                    jSONArray.put(put);
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.JsApiGetBeacons", "not found device");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("beacons", jSONArray);
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(94359);
    }
}

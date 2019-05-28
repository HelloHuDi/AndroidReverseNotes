package com.tencent.p177mm.plugin.appbrand.jsapi.p899c;

import android.annotation.TargetApi;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p899c.C33269a.C10354a;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.d */
public final class C26949d extends C10296a {
    private static final int CTRL_INDEX = 222;
    private static final String NAME = "stopBeaconDiscovery";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.c.d$a */
    static class C26950a extends C42467ah {
        private static final int CTRL_INDEX = 225;
        private static final String NAME = "onBeaconServiceChanged";

        private C26950a() {
        }

        /* synthetic */ C26950a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94366);
        C45124d.m82929i("MicroMsg.JsApiStopBeaconDiscovery", "stopBeaconDiscovery!");
        C10354a AZ = C33269a.m54418AZ(c2241c.getAppId());
        HashMap hashMap;
        if (AZ == null) {
            C45124d.m82927e("MicroMsg.JsApiStopBeaconDiscovery", "beaconWorker is null");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            c2241c.mo6107M(i, mo73394j("fail:not start", hashMap));
            AppMethodBeat.m2505o(94366);
            return;
        }
        if (AZ.mo21825EH()) {
            C33269a.remove(c2241c.getAppId());
            new HashMap().put("errCode", Integer.valueOf(0));
            c2241c.mo6107M(i, mo73394j("ok", null));
        } else {
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(11004));
            c2241c.mo6107M(i, mo73394j("fail:not start", hashMap));
        }
        C26950a c26950a = new C26950a();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("available", C33269a.hDs);
            jSONObject2.put("discovering", false);
        } catch (JSONException e) {
            C45124d.m82928e("MicroMsg.JsApiStopBeaconDiscovery", "put JSON data error : %s", e);
        }
        C45124d.m82930i("MicroMsg.JsApiStopBeaconDiscovery", "OnBeaconServiceChangedEvent %s", jSONObject2.toString());
        c26950a.mo61030b(c2241c, c2241c.aBw()).mo61028AM(jSONObject2.toString()).aCj();
        AppMethodBeat.m2505o(94366);
    }
}

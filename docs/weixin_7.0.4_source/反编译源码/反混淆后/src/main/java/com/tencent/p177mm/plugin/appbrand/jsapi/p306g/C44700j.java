package com.tencent.p177mm.plugin.appbrand.jsapi.p306g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10411x;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10417h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.p307a.C10406b.C10423i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g.j */
public final class C44700j extends C42517a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRegion";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93847);
        super.mo5994a(c2241c, jSONObject, i);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetMapRegion", "data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(93847);
            return;
        }
        C4990ab.m7417i("MicroMsg.JsApiGetMapRegion", "data:%s", jSONObject);
        C10406b f = mo67990f(c2241c, jSONObject);
        if (f == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetMapRegion", "mapView is null, return");
            c2241c.mo6107M(i, mo73394j("fail:mapview is null", null));
            AppMethodBeat.m2505o(93847);
            return;
        }
        C10411x c10411x = f.aDQ().hOo;
        if (c10411x == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
            c2241c.mo6107M(i, mo73394j("fail:visibleRegion is null", null));
            AppMethodBeat.m2505o(93847);
            return;
        }
        C10423i c10423i = c10411x.hOp;
        if (c10423i == null) {
            C4990ab.m7412e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
            c2241c.mo6107M(i, mo73394j("fail:latLngBounds is null", null));
            AppMethodBeat.m2505o(93847);
            return;
        }
        C10417h c10417h = c10423i.hNT;
        C10417h c10417h2 = c10423i.hNU;
        HashMap hashMap = new HashMap();
        if (c10417h != null) {
            hashMap.put("latitude", Double.valueOf(c10417h.latitude));
            hashMap.put("longitude", Double.valueOf(c10417h.longitude));
        }
        HashMap hashMap2 = new HashMap();
        if (c10417h2 != null) {
            hashMap2.put("latitude", Double.valueOf(c10417h2.latitude));
            hashMap2.put("longitude", Double.valueOf(c10417h2.longitude));
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("southwest", hashMap);
        hashMap3.put("northeast", hashMap2);
        C4990ab.m7417i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", hashMap3.toString());
        mo67989a(c2241c, i, mo73394j("ok", hashMap3), true, f.aDU());
        AppMethodBeat.m2505o(93847);
    }
}

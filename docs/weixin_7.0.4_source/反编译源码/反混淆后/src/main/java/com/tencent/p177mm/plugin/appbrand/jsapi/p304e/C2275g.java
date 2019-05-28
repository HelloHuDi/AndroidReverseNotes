package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.os.Bundle;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C19712a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C2459b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.g */
public class C2275g<CONTEXT extends C2241c> extends C16664a<CONTEXT> {
    public static final int CTRL_INDEX = 37;
    public static final String NAME = "getLocation";

    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(93826);
        super.mo5994a(c2241c, jSONObject, i);
        AppMethodBeat.m2505o(93826);
    }

    /* renamed from: c */
    public final void mo6150c(final CONTEXT context, JSONObject jSONObject, final int i) {
        Object obj;
        AppMethodBeat.m2504i(93825);
        String optString = jSONObject.optString("type", "wgs84");
        if (C5046bo.isNullOrNil(optString)) {
            obj = "wgs84";
        } else {
            String obj2 = optString;
        }
        final boolean optBoolean = jSONObject.optBoolean("altitude", false);
        C4990ab.m7419v("MicroMsg.JsApiGetLocation", "doGeoLocation, geoType = %s, needAltitude = %b", obj2, Boolean.valueOf(optBoolean));
        HashMap hashMap;
        if (!"wgs84".equals(obj2) && !"gcj02".equals(obj2)) {
            C4990ab.m7413e("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", obj2);
            hashMap = new HashMap(1);
            hashMap.put("errCode", Integer.valueOf(-1));
            context.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            AppMethodBeat.m2505o(93825);
        } else if (C16664a.m25670o(context)) {
            mo6152p(context);
            ((C33523a) C37384e.m62985B(C33523a.class)).mo20054a(obj2, new C2459b() {
                /* renamed from: a */
                public final void mo6153a(int i, String str, C19712a c19712a) {
                    AppMethodBeat.m2504i(93824);
                    C4990ab.m7417i("MicroMsg.JsApiGetLocation", "errCode:%d, errStr:%s, location:%s", Integer.valueOf(i), str, c19712a);
                    C2275g.this.aDD();
                    HashMap hashMap;
                    if (i == 0) {
                        hashMap = new HashMap(4);
                        hashMap.put("latitude", Double.valueOf(c19712a.latitude));
                        hashMap.put("longitude", Double.valueOf(c19712a.longitude));
                        hashMap.put("speed", Double.valueOf(c19712a.iSf));
                        hashMap.put("accuracy", Double.valueOf(c19712a.iSg));
                        if (optBoolean) {
                            hashMap.put("altitude", Double.valueOf(c19712a.altitude));
                        }
                        if (C4872b.dnO()) {
                            hashMap.put("provider", c19712a.bIy);
                        }
                        hashMap.put("verticalAccuracy", Integer.valueOf(0));
                        hashMap.put("horizontalAccuracy", Double.valueOf(c19712a.iSg));
                        if (!C5046bo.isNullOrNil(c19712a.buildingId)) {
                            hashMap.put("buildingId", c19712a.buildingId);
                            hashMap.put("floorName", c19712a.floorName);
                        }
                        context.mo6107M(i, C2275g.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(93824);
                        return;
                    }
                    hashMap = new HashMap(1);
                    hashMap.put("errCode", Integer.valueOf(i));
                    context.mo6107M(i, C2275g.this.mo73394j("fail:".concat(String.valueOf(str)), hashMap));
                    AppMethodBeat.m2505o(93824);
                }
            }, mo6151e(context, jSONObject));
            AppMethodBeat.m2505o(93825);
        } else {
            hashMap = new HashMap(1);
            hashMap.put("errCode", Integer.valueOf(-2));
            context.mo6107M(i, mo73394j("fail:system permission denied", hashMap));
            AppMethodBeat.m2505o(93825);
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public Bundle mo6151e(CONTEXT context, JSONObject jSONObject) {
        return null;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: p */
    public void mo6152p(CONTEXT context) {
    }

    /* Access modifiers changed, original: protected */
    public void aDD() {
    }
}

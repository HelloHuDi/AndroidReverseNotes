package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C19712a;
import com.tencent.p177mm.plugin.appbrand.p329s.p331b.C33523a.C2459b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.b */
final class C26967b extends C42467ah implements C2459b {
    private static final int CTRL_INDEX = 341;
    private static final String NAME = "onLocationChange";
    private final C2241c hKI;

    C26967b(C2241c c2241c) {
        this.hKI = c2241c;
    }

    /* renamed from: a */
    public final void mo6153a(int i, String str, C19712a c19712a) {
        AppMethodBeat.m2504i(93821);
        if (i == -1) {
            C4990ab.m7413e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", Integer.valueOf(i), str);
            AppMethodBeat.m2505o(93821);
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("longitude", Double.valueOf(c19712a.longitude));
        hashMap.put("latitude", Double.valueOf(c19712a.latitude));
        hashMap.put("speed", Double.valueOf(c19712a.iSf));
        hashMap.put("accuracy", Double.valueOf(c19712a.iSg));
        hashMap.put("altitude", Double.valueOf(c19712a.altitude));
        hashMap.put("verticalAccuracy", Float.valueOf(0.0f));
        hashMap.put("horizontalAccuracy", Double.valueOf(c19712a.iSg));
        if (!C5046bo.isNullOrNil(c19712a.buildingId)) {
            hashMap.put("buildingId", c19712a.buildingId);
            hashMap.put("floorName", c19712a.floorName);
        }
        C4990ab.m7419v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", this.hKI.getAppId(), c19712a.bIy, new JSONObject(hashMap).toString());
        synchronized (this) {
            try {
                mo61032j(this.hKI).mo61028AM(r0).aCj();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(93821);
            }
        }
    }
}

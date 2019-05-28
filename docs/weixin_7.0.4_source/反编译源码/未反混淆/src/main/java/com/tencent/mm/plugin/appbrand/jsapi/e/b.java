package com.tencent.mm.plugin.appbrand.jsapi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.b.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

final class b extends ah implements com.tencent.mm.plugin.appbrand.s.b.a.b {
    private static final int CTRL_INDEX = 341;
    private static final String NAME = "onLocationChange";
    private final c hKI;

    b(c cVar) {
        this.hKI = cVar;
    }

    public final void a(int i, String str, a aVar) {
        AppMethodBeat.i(93821);
        if (i == -1) {
            ab.e("MicroMsg.AppBrand.EventOnLocationChange", "errCode:%d, errStr:%s", Integer.valueOf(i), str);
            AppMethodBeat.o(93821);
            return;
        }
        HashMap hashMap = new HashMap(7);
        hashMap.put("longitude", Double.valueOf(aVar.longitude));
        hashMap.put("latitude", Double.valueOf(aVar.latitude));
        hashMap.put("speed", Double.valueOf(aVar.iSf));
        hashMap.put("accuracy", Double.valueOf(aVar.iSg));
        hashMap.put("altitude", Double.valueOf(aVar.altitude));
        hashMap.put("verticalAccuracy", Float.valueOf(0.0f));
        hashMap.put("horizontalAccuracy", Double.valueOf(aVar.iSg));
        if (!bo.isNullOrNil(aVar.buildingId)) {
            hashMap.put("buildingId", aVar.buildingId);
            hashMap.put("floorName", aVar.floorName);
        }
        ab.v("MicroMsg.AppBrand.EventOnLocationChange", "onLocationChanged %s, %s, %s", this.hKI.getAppId(), aVar.bIy, new JSONObject(hashMap).toString());
        synchronized (this) {
            try {
                j(this.hKI).AM(r0).aCj();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(93821);
            }
        }
    }
}

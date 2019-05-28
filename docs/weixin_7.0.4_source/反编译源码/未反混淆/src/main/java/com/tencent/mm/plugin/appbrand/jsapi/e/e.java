package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class e extends f {
    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Bundle e(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(131110);
        q qVar = (q) cVar;
        Bundle bundle = new Bundle();
        String optString = jSONObject.optString("subKey", "");
        String appId = qVar.getAppId();
        if (!bo.isNullOrNil(optString)) {
            bundle.putString("smallAppKey", optString + "#" + appId + ";");
        }
        bundle.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        d.v("MicroMsg.AppBrand.JsApiEnableLocationUpdate", "enableLocationUpdate %s", jSONObject);
        AppMethodBeat.o(131110);
        return bundle;
    }
}

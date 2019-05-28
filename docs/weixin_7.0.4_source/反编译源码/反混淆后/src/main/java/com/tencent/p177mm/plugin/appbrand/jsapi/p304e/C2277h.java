package com.tencent.p177mm.plugin.appbrand.jsapi.p304e;

import android.os.Bundle;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.e.h */
public final class C2277h extends C10376i {
    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: e */
    public final /* synthetic */ Bundle mo6151e(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(131111);
        C38492q c38492q = (C38492q) c2241c;
        Bundle bundle = new Bundle();
        String optString = jSONObject.optString("subKey", "");
        String appId = c38492q.getAppId();
        if (!C5046bo.isNullOrNil(optString)) {
            bundle.putString("smallAppKey", optString + "#" + appId + ";");
        }
        bundle.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        C45124d.m82932v("MicroMsg.JsApiGetLocation", "getLocation %s", jSONObject);
        AppMethodBeat.m2505o(131111);
        return bundle;
    }
}

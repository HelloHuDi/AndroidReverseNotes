package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.b */
public class C33335b extends C19497u<C44709u> {
    public static int CTRL_INDEX = 71;
    public static String NAME = "getCurrentRoute";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(74752);
        C44709u c44709u = (C44709u) c2241c;
        HashMap hashMap = new HashMap();
        hashMap.put(TencentExtraKeys.LOCATION_KEY_ROUTE, c44709u.getURL());
        C4990ab.m7411d("MicroMsg.JsApiGetCurrentRoute", "getCurrentRoute : %s", mo73394j("ok", hashMap));
        String j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(74752);
        return j;
    }
}

package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.j */
public final class C33340j extends C19497u<C2119d> {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(86974);
        C2119d c2119d = (C2119d) c2241c;
        String optString = jSONObject.optString("url");
        if (c2119d.getRuntime().getAppConfig().heV.mo60906yU(optString)) {
            optString = mo73394j("fail:can not redirect to a tab bar page", null);
            AppMethodBeat.m2505o(86974);
            return optString;
        }
        c2119d.getRuntime().asV().mo61155Da(optString);
        optString = mo73394j("ok", null);
        AppMethodBeat.m2505o(86974);
        return optString;
    }
}

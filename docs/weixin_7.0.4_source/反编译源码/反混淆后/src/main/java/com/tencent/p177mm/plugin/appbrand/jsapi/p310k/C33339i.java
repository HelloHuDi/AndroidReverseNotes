package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.i */
public final class C33339i extends C19497u<C2119d> {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(86973);
        C2119d c2119d = (C2119d) c2241c;
        c2119d.getRuntime().asV().mo21671af(jSONObject.optString("url"), false);
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(86973);
        return j;
    }
}

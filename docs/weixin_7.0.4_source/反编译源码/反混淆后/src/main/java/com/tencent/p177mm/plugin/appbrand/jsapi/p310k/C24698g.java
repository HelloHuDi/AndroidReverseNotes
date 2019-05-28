package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.g */
public final class C24698g extends C19497u<C2119d> {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(74755);
        C2119d c2119d = (C2119d) c2241c;
        c2119d.getRuntime().asV().mo21677nU(jSONObject.optInt("delta", 1));
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(74755);
        return j;
    }
}

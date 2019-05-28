package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.ab */
public final class C42522ab extends C19497u<C2119d> {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(86975);
        C2119d c2119d = (C2119d) c2241c;
        String optString = jSONObject.optString("url");
        if (c2119d.getRuntime().getAppConfig().heV.mo60906yU(optString)) {
            c2119d.getRuntime().asV().mo61156Db(optString);
            optString = mo73394j("ok", null);
            AppMethodBeat.m2505o(86975);
            return optString;
        }
        optString = mo73394j("fail:can not switch to non-TabBar page", null);
        AppMethodBeat.m2505o(86975);
        return optString;
    }
}

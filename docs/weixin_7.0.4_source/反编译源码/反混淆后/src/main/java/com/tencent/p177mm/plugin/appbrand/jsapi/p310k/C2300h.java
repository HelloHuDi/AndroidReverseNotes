package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.h */
public final class C2300h extends C19497u<C2119d> {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(86972);
        C2119d c2119d = (C2119d) c2241c;
        int i = c2119d.getRuntime().mo15034ye().hgX;
        String j;
        if (c2119d.getRuntime().asV().getPageCount() >= i) {
            C4990ab.m7412e("MicroMsg.JsApiNavigateTo", "page limit exceeded: ".concat(String.valueOf(i)));
            j = mo73394j("fail:page limit exceeded: ".concat(String.valueOf(i)), null);
            AppMethodBeat.m2505o(86972);
            return j;
        }
        j = jSONObject.optString("url");
        if (c2119d.getRuntime().getAppConfig().heV.mo60906yU(j)) {
            j = mo73394j("fail:can not navigate to a tab bar page", null);
            AppMethodBeat.m2505o(86972);
            return j;
        }
        c2119d.getRuntime().asV().mo61154CZ(j);
        j = mo73394j("ok", null);
        AppMethodBeat.m2505o(86972);
        return j;
    }
}

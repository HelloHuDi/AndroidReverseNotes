package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.a */
public final class C33333a extends C10296a<C44709u> {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74751);
        C44709u c44709u = (C44709u) c2241c;
        if (jSONObject.has("disable")) {
            if (jSONObject.optBoolean("disable", false)) {
                c44709u.mo53748dO(false);
            } else {
                c44709u.mo53748dO(c44709u.getPageConfig().hfA);
            }
        }
        c44709u.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(74751);
    }
}

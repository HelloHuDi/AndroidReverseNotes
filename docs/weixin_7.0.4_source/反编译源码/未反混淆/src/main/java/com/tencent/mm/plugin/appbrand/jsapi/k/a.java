package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<u> {
    public static final int CTRL_INDEX = 139;
    public static final String NAME = "disableScrollBounce";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74751);
        u uVar = (u) cVar;
        if (jSONObject.has("disable")) {
            if (jSONObject.optBoolean("disable", false)) {
                uVar.dO(false);
            } else {
                uVar.dO(uVar.getPageConfig().hfA);
            }
        }
        uVar.M(i, j("ok", null));
        AppMethodBeat.o(74751);
    }
}

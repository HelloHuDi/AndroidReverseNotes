package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class j extends u<d> {
    public static final int CTRL_INDEX = 13;
    public static final String NAME = "redirectTo";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(86974);
        d dVar = (d) cVar;
        String optString = jSONObject.optString("url");
        if (dVar.getRuntime().getAppConfig().heV.yU(optString)) {
            optString = j("fail:can not redirect to a tab bar page", null);
            AppMethodBeat.o(86974);
            return optString;
        }
        dVar.getRuntime().asV().Da(optString);
        optString = j("ok", null);
        AppMethodBeat.o(86974);
        return optString;
    }
}

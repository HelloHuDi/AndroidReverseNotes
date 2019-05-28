package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class i extends u<d> {
    private static final int CTRL_INDEX = 170;
    private static final String NAME = "reLaunch";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(86973);
        d dVar = (d) cVar;
        dVar.getRuntime().asV().af(jSONObject.optString("url"), false);
        String j = j("ok", null);
        AppMethodBeat.o(86973);
        return j;
    }
}

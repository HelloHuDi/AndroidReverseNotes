package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class g extends u<d> {
    public static final int CTRL_INDEX = 15;
    public static final String NAME = "navigateBack";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(74755);
        d dVar = (d) cVar;
        dVar.getRuntime().asV().nU(jSONObject.optInt("delta", 1));
        String j = j("ok", null);
        AppMethodBeat.o(74755);
        return j;
    }
}

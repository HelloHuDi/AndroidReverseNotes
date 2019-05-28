package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class e extends u<h> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "remoteDebugInfo";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(101822);
        h hVar = (h) cVar;
        String j;
        if (hVar.getRuntime().xT() instanceof i) {
            ((i) hVar.getRuntime().xT()).zH(jSONObject.toString());
            j = j("ok", null);
            AppMethodBeat.o(101822);
            return j;
        }
        j = j("fail:not debug", null);
        AppMethodBeat.o(101822);
        return j;
    }
}

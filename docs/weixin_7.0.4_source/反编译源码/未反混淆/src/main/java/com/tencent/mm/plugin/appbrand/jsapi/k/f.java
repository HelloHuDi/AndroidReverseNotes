package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class f extends u<com.tencent.mm.plugin.appbrand.page.u> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "initReady";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(86971);
        ((com.tencent.mm.plugin.appbrand.page.u) cVar).onReady();
        String j = j("ok", null);
        AppMethodBeat.o(86971);
        return j;
    }
}

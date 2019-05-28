package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class d extends u<q> {
    static final int CTRL_INDEX = 191;
    public static final String NAME = "exitMiniProgram";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(101980);
        String c = c((q) cVar);
        AppMethodBeat.o(101980);
        return c;
    }

    public final String c(q qVar) {
        AppMethodBeat.i(101979);
        qVar.getRuntime().finish();
        String j = j("ok", null);
        AppMethodBeat.o(101979);
        return j;
    }
}

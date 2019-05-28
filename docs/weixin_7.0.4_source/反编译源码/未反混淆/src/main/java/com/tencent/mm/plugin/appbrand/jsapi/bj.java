package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_EnableDebug;
import org.json.JSONObject;

public final class bj extends a<b> {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101954);
        b bVar = (b) cVar;
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (bVar.xL().xZ().bQp == optBoolean) {
            bVar.M(i, j("ok", null));
            AppMethodBeat.o(101954);
            return;
        }
        MenuDelegate_EnableDebug.f(bVar.getContext(), bVar.getAppId(), optBoolean);
        bVar.M(i, j("ok", null));
        AppMethodBeat.o(101954);
    }
}

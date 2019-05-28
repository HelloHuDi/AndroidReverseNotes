package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class h extends u<d> {
    public static final int CTRL_INDEX = 14;
    public static final String NAME = "navigateTo";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(86972);
        d dVar = (d) cVar;
        int i = dVar.getRuntime().ye().hgX;
        String j;
        if (dVar.getRuntime().asV().getPageCount() >= i) {
            ab.e("MicroMsg.JsApiNavigateTo", "page limit exceeded: ".concat(String.valueOf(i)));
            j = j("fail:page limit exceeded: ".concat(String.valueOf(i)), null);
            AppMethodBeat.o(86972);
            return j;
        }
        j = jSONObject.optString("url");
        if (dVar.getRuntime().getAppConfig().heV.yU(j)) {
            j = j("fail:can not navigate to a tab bar page", null);
            AppMethodBeat.o(86972);
            return j;
        }
        dVar.getRuntime().asV().CZ(j);
        j = j("ok", null);
        AppMethodBeat.o(86972);
        return j;
    }
}

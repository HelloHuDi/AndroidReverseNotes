package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import org.json.JSONObject;

public final class ab extends u<d> {
    public static final int CTRL_INDEX = 150;
    public static final String NAME = "switchTab";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(86975);
        d dVar = (d) cVar;
        String optString = jSONObject.optString("url");
        if (dVar.getRuntime().getAppConfig().heV.yU(optString)) {
            dVar.getRuntime().asV().Db(optString);
            optString = j("ok", null);
            AppMethodBeat.o(86975);
            return optString;
        }
        optString = j("fail:can not switch to non-TabBar page", null);
        AppMethodBeat.o(86975);
        return optString;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public final class q extends a<com.tencent.mm.plugin.appbrand.q> {
    public static final int CTRL_INDEX = 8;
    public static final String NAME = "setNavigationBarTitle";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74768);
        com.tencent.mm.plugin.appbrand.q qVar = (com.tencent.mm.plugin.appbrand.q) cVar;
        if (jSONObject.has("title")) {
            String optString = jSONObject.optString("title");
            u pageView = qVar.getRuntime().asV().getPageView();
            if (pageView == null) {
                qVar.M(i, j("fail", null));
                AppMethodBeat.o(74768);
                return;
            }
            pageView.AB(optString);
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(74768);
            return;
        }
        qVar.M(i, j("fail:invalid data", null));
        AppMethodBeat.o(74768);
    }
}

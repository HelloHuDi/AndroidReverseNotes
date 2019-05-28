package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class n extends a<q> {
    public static final int CTRL_INDEX = 388;
    public static final String NAME = "setMenuStyle";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74763);
        q qVar = (q) cVar;
        ab.d("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
        if (jSONObject == null) {
            qVar.M(i, j("fail:data is null", null));
            ab.e("MicroMsg.JsApiSetMenuStyle", "data is null");
            AppMethodBeat.o(74763);
            return;
        }
        String optString = jSONObject.optString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        u pageView = qVar.getRuntime().asV().getPageView();
        if (pageView == null) {
            qVar.M(i, j("fail view is null", null));
            AppMethodBeat.o(74763);
            return;
        }
        if (optString.equalsIgnoreCase("dark")) {
            pageView.Dh("dark");
        } else if (optString.equalsIgnoreCase("light")) {
            pageView.Dh("light");
        } else {
            qVar.M(i, j("fail invalid style ".concat(String.valueOf(optString)), null));
            ab.e("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", optString);
            AppMethodBeat.o(74763);
            return;
        }
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(74763);
    }
}

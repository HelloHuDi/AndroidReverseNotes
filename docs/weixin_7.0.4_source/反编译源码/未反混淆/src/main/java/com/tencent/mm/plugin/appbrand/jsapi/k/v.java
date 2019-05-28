package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.g;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class v extends a<q> {
    public static final int CTRL_INDEX = 417;
    public static final String NAME = "setTabBarStyle";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74774);
        q qVar = (q) cVar;
        f fVar = qVar.getRuntime().getAppConfig().heV;
        String optString = jSONObject.optString("color", fVar.color);
        String optString2 = jSONObject.optString("selectedColor", fVar.hfn);
        String optString3 = jSONObject.optString("backgroundColor", fVar.hfo);
        String optString4 = jSONObject.optString("borderStyle", fVar.hfp);
        n currentPage = qVar.getRuntime().asV().getCurrentPage();
        if (currentPage instanceof g) {
            ((g) currentPage).getTabBar().g(optString, optString2, optString3, optString4);
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(74774);
            return;
        }
        qVar.M(i, j("fail:not TabBar page", null));
        AppMethodBeat.o(74774);
    }
}

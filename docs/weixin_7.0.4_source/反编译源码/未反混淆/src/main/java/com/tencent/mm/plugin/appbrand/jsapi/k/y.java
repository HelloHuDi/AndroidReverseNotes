package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.g;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class y extends a<q> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74776);
        q qVar = (q) cVar;
        n currentPage = qVar.getRuntime().asV().getCurrentPage();
        if (currentPage instanceof g) {
            ((g) currentPage).getTabBar().av(jSONObject.optBoolean("animation", true));
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(74776);
            return;
        }
        qVar.M(i, j("fail:not TabBar page", null));
        AppMethodBeat.o(74776);
    }
}

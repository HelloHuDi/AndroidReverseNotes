package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class x extends a<q> {
    public static final int CTRL_INDEX = 9;
    public static final String NAME = "showNavigationBarLoading";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74775);
        q qVar = (q) cVar;
        u pageView = qVar.getRuntime().asV().getPageView();
        if (pageView == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74775);
            return;
        }
        pageView.dN(true);
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(74775);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class s extends a<q> {
    private static final int CTRL_INDEX = 197;
    private static final String NAME = "setStatusBarStyle";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74769);
        q qVar = (q) cVar;
        String optString = jSONObject.optString("color", "");
        u pageView = qVar.getRuntime().asV().getPageView();
        if (pageView == null) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74769);
            return;
        }
        if (optString.equals("white") || optString.equals("black")) {
            pageView.AC(optString);
        }
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(74769);
    }
}

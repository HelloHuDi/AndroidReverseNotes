package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class g extends a<q> {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102010);
        q qVar = (q) cVar;
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.H(o.ShareAppMsg.ordinal(), false);
        }
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(102010);
    }
}

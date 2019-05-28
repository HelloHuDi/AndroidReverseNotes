package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import org.json.JSONObject;

public final class g extends a<q> {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(123544);
        q qVar = (q) cVar;
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView == null || !currentPageView.isRunning()) {
            qVar.M(i, j("fail current page not available", null));
            AppMethodBeat.o(123544);
            return;
        }
        try {
            Integer valueOf;
            String string = jSONObject.getString("value");
            try {
                valueOf = Integer.valueOf(jSONObject.getInt("cursor"));
            } catch (Exception e) {
                valueOf = null;
            }
            o.a(currentPageView, string, valueOf);
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(123544);
        } catch (Exception e2) {
            qVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(123544);
        }
    }
}

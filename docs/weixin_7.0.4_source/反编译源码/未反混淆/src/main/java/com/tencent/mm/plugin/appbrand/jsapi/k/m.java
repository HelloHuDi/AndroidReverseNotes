package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import org.json.JSONObject;

public final class m extends a<q> {
    public static final int CTRL_INDEX = 454;
    public static final String NAME = "setBackgroundTextStyle";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74762);
        q qVar = (q) cVar;
        final u pageView = qVar.getRuntime().asV().getPageView();
        if (pageView == null) {
            qVar.M(i, "fail");
            AppMethodBeat.o(74762);
            return;
        }
        final String optString = jSONObject.optString("textStyle", "ignore");
        pageView.getContentView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74761);
                pageView.isK.setBackgroundTextStyle(optString);
                AppMethodBeat.o(74761);
            }
        });
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(74762);
    }
}

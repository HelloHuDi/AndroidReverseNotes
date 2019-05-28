package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONObject;

public final class l extends a<q> {
    public static final int CTRL_INDEX = 453;
    public static final String NAME = "setBackgroundColor";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74760);
        q qVar = (q) cVar;
        final u pageView = qVar.getRuntime().asV().getPageView();
        if (pageView == null) {
            qVar.M(i, "fail:page don't exist");
            AppMethodBeat.o(74760);
            return;
        }
        try {
            final long Ef = (long) g.Ef(jSONObject.optString("backgroundColor", ""));
            pageView.getContentView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(74759);
                    pageView.isK.setPullDownBackgroundColor((int) Ef);
                    AppMethodBeat.o(74759);
                }
            });
            qVar.M(i, j("ok", null));
            AppMethodBeat.o(74760);
        } catch (Exception e) {
            qVar.M(i, j("fail:invalid color", null));
            AppMethodBeat.o(74760);
        }
    }
}

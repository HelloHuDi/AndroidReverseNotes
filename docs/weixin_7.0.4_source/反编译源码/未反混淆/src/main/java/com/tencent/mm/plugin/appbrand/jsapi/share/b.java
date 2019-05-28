package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b extends a<q> {
    public static final int CTRL_INDEX = 203;
    public static final String NAME = "hideShareMenu";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102009);
        q qVar = (q) cVar;
        ab.i("MicroMsg.JsApiHideShareMenu", "invoke");
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.H(o.ShareAppMsg.ordinal(), true);
        }
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(102009);
    }
}

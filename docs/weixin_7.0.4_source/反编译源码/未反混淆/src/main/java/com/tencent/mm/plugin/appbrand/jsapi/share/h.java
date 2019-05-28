package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class h extends a<q> {
    public static final int CTRL_INDEX = 202;
    public static final String NAME = "showShareMenuWithShareTicket";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102011);
        q qVar = (q) cVar;
        ab.i("MicroMsg.JsApiShowShareMenuWithShareTicket", "invoke");
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.H(o.ShareAppMsg.ordinal(), false);
            n ps = currentPageView.ps(o.ShareAppMsg.ordinal());
            if (ps == null) {
                qVar.M(i, j("fail:menu item do not exist", null));
                AppMethodBeat.o(102011);
                return;
            }
            ps.hAx.j("enable_share_with_share_ticket", Boolean.TRUE);
        }
        qVar.M(i, j("ok", null));
        AppMethodBeat.o(102011);
    }
}

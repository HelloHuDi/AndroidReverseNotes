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

public final class j extends a<q> {
    public static final int CTRL_INDEX = 210;
    public static final String NAME = "updateShareMenuShareTicket";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102013);
        q qVar = (q) cVar;
        ab.i("MicroMsg.JsApiUpdateShareMenuShareTicket", "invoke");
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            n ps = currentPageView.ps(o.ShareAppMsg.ordinal());
            if (ps == null) {
                qVar.M(i, j("fail:menu item do not exist", null));
                AppMethodBeat.o(102013);
                return;
            }
            ps.hAx.j("enable_share_with_share_ticket", Boolean.valueOf(jSONObject.optBoolean("withShareTicket", false)));
            qVar.M(i, j("ok", null));
            ab.i("MicroMsg.JsApiUpdateShareMenuShareTicket", "update share menu withShareTicket(%s)", Boolean.valueOf(r1));
            AppMethodBeat.o(102013);
            return;
        }
        qVar.M(i, j("fail", null));
        AppMethodBeat.o(102013);
    }
}

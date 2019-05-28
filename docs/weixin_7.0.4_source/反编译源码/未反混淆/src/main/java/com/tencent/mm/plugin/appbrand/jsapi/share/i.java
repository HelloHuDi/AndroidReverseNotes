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

public final class i extends a<q> {
    public static final int CTRL_INDEX = 211;
    public static final String NAME = "updateShareMenuDynamic";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102012);
        q qVar = (q) cVar;
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            n ps = currentPageView.ps(o.ShareAppMsg.ordinal());
            if (ps == null) {
                qVar.M(i, j("fail:menu item do not exist", null));
                AppMethodBeat.o(102012);
                return;
            }
            ps.hAx.j("enable_share_dynamic", Boolean.valueOf(jSONObject.optBoolean("isDynamic", false)));
            qVar.M(i, j("ok", null));
            ab.i("MicroMsg.JsApiUpdateShareMenuDynamic", "update share menu dynamic(%s)", Boolean.valueOf(r1));
            AppMethodBeat.o(102012);
            return;
        }
        qVar.M(i, j("fail", null));
        AppMethodBeat.o(102012);
    }
}

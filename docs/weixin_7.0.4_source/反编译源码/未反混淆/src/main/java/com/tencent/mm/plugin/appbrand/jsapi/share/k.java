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

public final class k extends a<q> {
    public static final int CTRL_INDEX = 464;
    public static final String NAME = "updateShareMenuUpdatable";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102014);
        q qVar = (q) cVar;
        u currentPageView = qVar.getCurrentPageView();
        if (currentPageView != null) {
            n ps = currentPageView.ps(o.ShareAppMsg.ordinal());
            if (ps == null) {
                qVar.M(i, j("fail:menu item do not exist", null));
                AppMethodBeat.o(102014);
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("updatable", false);
            String optString = jSONObject.optString("templateId", "");
            ps.hAx.j("enable_share_with_updateable_msg", Boolean.valueOf(optBoolean));
            ps.hAx.j("enable_share_with_updateable_msg_template_id", optString);
            qVar.M(i, j("ok", null));
            ab.i("MicroMsg.JsApiUpdateShareMenuUpdatable", "update share menu updatable(%s)", Boolean.valueOf(optBoolean));
            AppMethodBeat.o(102014);
            return;
        }
        qVar.M(i, j("fail", null));
        AppMethodBeat.o(102014);
    }
}

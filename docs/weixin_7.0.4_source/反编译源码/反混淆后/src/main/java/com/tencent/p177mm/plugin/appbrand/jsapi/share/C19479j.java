package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.menu.C38449o;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.j */
public final class C19479j extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 210;
    public static final String NAME = "updateShareMenuShareTicket";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102013);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiUpdateShareMenuShareTicket", "invoke");
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView != null) {
            C42636n ps = currentPageView.mo71769ps(C38449o.ShareAppMsg.ordinal());
            if (ps == null) {
                c38492q.mo6107M(i, mo73394j("fail:menu item do not exist", null));
                AppMethodBeat.m2505o(102013);
                return;
            }
            ps.hAx.mo53356j("enable_share_with_share_ticket", Boolean.valueOf(jSONObject.optBoolean("withShareTicket", false)));
            c38492q.mo6107M(i, mo73394j("ok", null));
            C4990ab.m7417i("MicroMsg.JsApiUpdateShareMenuShareTicket", "update share menu withShareTicket(%s)", Boolean.valueOf(r1));
            AppMethodBeat.m2505o(102013);
            return;
        }
        c38492q.mo6107M(i, mo73394j("fail", null));
        AppMethodBeat.m2505o(102013);
    }
}

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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.h */
public final class C38383h extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 202;
    public static final String NAME = "showShareMenuWithShareTicket";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102011);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiShowShareMenuWithShareTicket", "invoke");
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.mo71747H(C38449o.ShareAppMsg.ordinal(), false);
            C42636n ps = currentPageView.mo71769ps(C38449o.ShareAppMsg.ordinal());
            if (ps == null) {
                c38492q.mo6107M(i, mo73394j("fail:menu item do not exist", null));
                AppMethodBeat.m2505o(102011);
                return;
            }
            ps.hAx.mo53356j("enable_share_with_share_ticket", Boolean.TRUE);
        }
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(102011);
    }
}

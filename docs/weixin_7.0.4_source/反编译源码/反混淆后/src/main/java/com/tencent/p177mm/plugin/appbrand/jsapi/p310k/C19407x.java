package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.x */
public final class C19407x extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 9;
    public static final String NAME = "showNavigationBarLoading";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74775);
        C38492q c38492q = (C38492q) c2241c;
        C44709u pageView = c38492q.getRuntime().asV().getPageView();
        if (pageView == null) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74775);
            return;
        }
        pageView.mo53747dN(true);
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(74775);
    }
}

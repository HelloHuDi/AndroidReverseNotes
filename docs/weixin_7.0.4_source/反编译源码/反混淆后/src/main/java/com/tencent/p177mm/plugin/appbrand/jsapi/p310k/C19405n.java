package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.n */
public final class C19405n extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 388;
    public static final String NAME = "setMenuStyle";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74763);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7410d("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
        if (jSONObject == null) {
            c38492q.mo6107M(i, mo73394j("fail:data is null", null));
            C4990ab.m7412e("MicroMsg.JsApiSetMenuStyle", "data is null");
            AppMethodBeat.m2505o(74763);
            return;
        }
        String optString = jSONObject.optString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        C44709u pageView = c38492q.getRuntime().asV().getPageView();
        if (pageView == null) {
            c38492q.mo6107M(i, mo73394j("fail view is null", null));
            AppMethodBeat.m2505o(74763);
            return;
        }
        if (optString.equalsIgnoreCase("dark")) {
            pageView.mo71745Dh("dark");
        } else if (optString.equalsIgnoreCase("light")) {
            pageView.mo71745Dh("light");
        } else {
            c38492q.mo6107M(i, mo73394j("fail invalid style ".concat(String.valueOf(optString)), null));
            C4990ab.m7413e("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", optString);
            AppMethodBeat.m2505o(74763);
            return;
        }
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(74763);
    }
}

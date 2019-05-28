package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C38166f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C27224g;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.v */
public final class C33343v extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 417;
    public static final String NAME = "setTabBarStyle";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74774);
        C38492q c38492q = (C38492q) c2241c;
        C38166f c38166f = c38492q.getRuntime().getAppConfig().heV;
        String optString = jSONObject.optString("color", c38166f.color);
        String optString2 = jSONObject.optString("selectedColor", c38166f.hfn);
        String optString3 = jSONObject.optString("backgroundColor", c38166f.hfo);
        String optString4 = jSONObject.optString("borderStyle", c38166f.hfp);
        C19640n currentPage = c38492q.getRuntime().asV().getCurrentPage();
        if (currentPage instanceof C27224g) {
            ((C27224g) currentPage).getTabBar().mo22646g(optString, optString2, optString3, optString4);
            c38492q.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74774);
            return;
        }
        c38492q.mo6107M(i, mo73394j("fail:not TabBar page", null));
        AppMethodBeat.m2505o(74774);
    }
}

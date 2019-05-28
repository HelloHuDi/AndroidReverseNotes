package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C27224g;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.y */
public final class C19408y extends C10296a<C38492q> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74776);
        C38492q c38492q = (C38492q) c2241c;
        C19640n currentPage = c38492q.getRuntime().asV().getCurrentPage();
        if (currentPage instanceof C27224g) {
            ((C27224g) currentPage).getTabBar().mo22642av(jSONObject.optBoolean("animation", true));
            c38492q.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74776);
            return;
        }
        c38492q.mo6107M(i, mo73394j("fail:not TabBar page", null));
        AppMethodBeat.m2505o(74776);
    }
}

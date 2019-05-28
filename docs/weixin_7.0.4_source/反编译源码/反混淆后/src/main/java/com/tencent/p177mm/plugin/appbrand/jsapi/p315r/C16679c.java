package com.tencent.p177mm.plugin.appbrand.jsapi.p315r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19773a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.r.c */
public final class C16679c extends C10296a {
    private static final int CTRL_INDEX = 241;
    private static final String NAME = "setTopBarText";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131485);
        C19773a.m30607cQ(c2241c.getAppId(), jSONObject.optString("text"));
        c2241c.mo6107M(i, mo73394j("ok", null));
        C33183g.m54274a(c2241c.getAppId(), new C33186c() {
            public final void onDestroy() {
                AppMethodBeat.m2504i(131484);
                C19773a.m30607cQ(c2241c.getAppId(), "");
                AppMethodBeat.m2505o(131484);
            }
        });
        AppMethodBeat.m2505o(131485);
    }
}

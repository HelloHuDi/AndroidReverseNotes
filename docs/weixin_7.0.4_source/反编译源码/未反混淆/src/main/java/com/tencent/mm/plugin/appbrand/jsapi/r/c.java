package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import org.json.JSONObject;

public final class c extends a {
    private static final int CTRL_INDEX = 241;
    private static final String NAME = "setTopBarText";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131485);
        AppBrandStickyBannerLogic.a.cQ(cVar.getAppId(), jSONObject.optString("text"));
        cVar.M(i, j("ok", null));
        g.a(cVar.getAppId(), new com.tencent.mm.plugin.appbrand.g.c() {
            public final void onDestroy() {
                AppMethodBeat.i(131484);
                AppBrandStickyBannerLogic.a.cQ(cVar.getAppId(), "");
                AppMethodBeat.o(131484);
            }
        });
        AppMethodBeat.o(131485);
    }
}

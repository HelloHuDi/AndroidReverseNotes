package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.g;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.widget.i.d;
import org.json.JSONObject;

public final class u extends a<q> {
    public static final int CTRL_INDEX = 418;
    public static final String NAME = "setTabBarItem";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74773);
        q qVar = (q) cVar;
        try {
            final int i2 = jSONObject.getInt(b.INDEX);
            final String optString = jSONObject.optString("text", null);
            String optString2 = jSONObject.optString("iconPath", "");
            String optString3 = jSONObject.optString("selectedIconPath", "");
            n currentPage = qVar.getRuntime().asV().getCurrentPage();
            if (currentPage instanceof g) {
                final com.tencent.mm.plugin.appbrand.widget.i.a tabBar = ((g) currentPage).getTabBar();
                tabBar.a(i2, optString, tabBar.joU.a(optString2, new com.tencent.mm.plugin.appbrand.widget.i.c() {
                    public final void a(String str, d dVar) {
                        AppMethodBeat.i(74771);
                        super.a(str, dVar);
                        tabBar.a(i2, optString, (d) ((Pair) tabBar.jpb.get(i2)).first, null);
                        AppMethodBeat.o(74771);
                    }
                }, qVar, i2), tabBar.joU.a(optString3, new com.tencent.mm.plugin.appbrand.widget.i.c() {
                    public final void a(String str, d dVar) {
                        AppMethodBeat.i(74772);
                        super.a(str, dVar);
                        tabBar.a(i2, optString, null, (d) ((Pair) tabBar.jpb.get(i2)).second);
                        AppMethodBeat.o(74772);
                    }
                }, qVar, i2));
                qVar.M(i, j("ok", null));
                AppMethodBeat.o(74773);
                return;
            }
            qVar.M(i, j("fail:not TabBar page", null));
            AppMethodBeat.o(74773);
        } catch (Exception e) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74773);
        }
    }
}

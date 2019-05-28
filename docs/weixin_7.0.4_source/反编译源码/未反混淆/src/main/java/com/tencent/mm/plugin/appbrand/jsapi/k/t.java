package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.g;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.ui.tools.f;
import org.json.JSONObject;

public final class t extends a<q> {
    public static final int CTRL_INDEX = 389;
    public static final String NAME = "setTabBarBadge";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74770);
        q qVar = (q) cVar;
        try {
            int i2 = jSONObject.getInt(b.INDEX);
            String optString = jSONObject.optString("type", "none");
            String optString2 = jSONObject.optString("badgeValue", "");
            String optString3 = jSONObject.optString("badgeColor", "");
            String optString4 = jSONObject.optString("badgeTextColor", "");
            final PBool pBool = new PBool();
            pBool.value = false;
            com.tencent.mm.ui.tools.b.c cVar2 = new com.tencent.mm.ui.tools.b.c(optString2);
            cVar2.jeZ = f.a.MODE_CHINESE_AS_2;
            cVar2 = cVar2.PM(4);
            cVar2.zIx = true;
            cVar2.a(new com.tencent.mm.ui.tools.b.c.a() {
                public final void ki(String str) {
                }

                public final void JW() {
                }

                public final void JX() {
                    pBool.value = true;
                }
            });
            if (pBool.value) {
                optString2 = "...";
            }
            n currentPage = qVar.getRuntime().asV().getCurrentPage();
            if (currentPage instanceof g) {
                ((g) currentPage).getTabBar().c(i2, optString, optString2, optString3, optString4);
                qVar.M(i, j("ok", null));
                AppMethodBeat.o(74770);
                return;
            }
            qVar.M(i, j("fail:not TabBar page", null));
            AppMethodBeat.o(74770);
        } catch (Exception e) {
            qVar.M(i, j("fail", null));
            AppMethodBeat.o(74770);
        }
    }
}

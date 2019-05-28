package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.tools.C5584f.C5583a;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c;
import com.tencent.p177mm.p612ui.tools.p632b.C7357c.C5581a;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C27224g;
import com.tencent.p177mm.pointers.PBool;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.t */
public final class C42528t extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 389;
    public static final String NAME = "setTabBarBadge";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74770);
        C38492q c38492q = (C38492q) c2241c;
        try {
            int i2 = jSONObject.getInt(C8741b.INDEX);
            String optString = jSONObject.optString("type", "none");
            String optString2 = jSONObject.optString("badgeValue", "");
            String optString3 = jSONObject.optString("badgeColor", "");
            String optString4 = jSONObject.optString("badgeTextColor", "");
            final PBool pBool = new PBool();
            pBool.value = false;
            C7357c c7357c = new C7357c(optString2);
            c7357c.jeZ = C5583a.MODE_CHINESE_AS_2;
            c7357c = c7357c.mo15877PM(4);
            c7357c.zIx = true;
            c7357c.mo15879a(new C5581a() {
                /* renamed from: ki */
                public final void mo11317ki(String str) {
                }

                /* renamed from: JW */
                public final void mo11315JW() {
                }

                /* renamed from: JX */
                public final void mo11316JX() {
                    pBool.value = true;
                }
            });
            if (pBool.value) {
                optString2 = "...";
            }
            C19640n currentPage = c38492q.getRuntime().asV().getCurrentPage();
            if (currentPage instanceof C27224g) {
                ((C27224g) currentPage).getTabBar().mo22644c(i2, optString, optString2, optString3, optString4);
                c38492q.mo6107M(i, mo73394j("ok", null));
                AppMethodBeat.m2505o(74770);
                return;
            }
            c38492q.mo6107M(i, mo73394j("fail:not TabBar page", null));
            AppMethodBeat.m2505o(74770);
        } catch (Exception e) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74770);
        }
    }
}

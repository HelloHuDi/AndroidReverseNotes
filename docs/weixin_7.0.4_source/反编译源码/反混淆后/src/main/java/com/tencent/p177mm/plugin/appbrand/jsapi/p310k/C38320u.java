package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import android.util.Pair;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C19640n;
import com.tencent.p177mm.plugin.appbrand.page.C27224g;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C10989a;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C33611c;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C33612d;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.u */
public final class C38320u extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 418;
    public static final String NAME = "setTabBarItem";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74773);
        C38492q c38492q = (C38492q) c2241c;
        try {
            final int i2 = jSONObject.getInt(C8741b.INDEX);
            final String optString = jSONObject.optString("text", null);
            String optString2 = jSONObject.optString("iconPath", "");
            String optString3 = jSONObject.optString("selectedIconPath", "");
            C19640n currentPage = c38492q.getRuntime().asV().getCurrentPage();
            if (currentPage instanceof C27224g) {
                final C10989a tabBar = ((C27224g) currentPage).getTabBar();
                tabBar.mo22639a(i2, optString, tabBar.joU.mo54189a(optString2, new C33611c() {
                    /* renamed from: a */
                    public final void mo6339a(String str, C33612d c33612d) {
                        AppMethodBeat.m2504i(74771);
                        super.mo6339a(str, c33612d);
                        tabBar.mo22639a(i2, optString, (C33612d) ((Pair) tabBar.jpb.get(i2)).first, null);
                        AppMethodBeat.m2505o(74771);
                    }
                }, c38492q, i2), tabBar.joU.mo54189a(optString3, new C33611c() {
                    /* renamed from: a */
                    public final void mo6339a(String str, C33612d c33612d) {
                        AppMethodBeat.m2504i(74772);
                        super.mo6339a(str, c33612d);
                        tabBar.mo22639a(i2, optString, null, (C33612d) ((Pair) tabBar.jpb.get(i2)).second);
                        AppMethodBeat.m2505o(74772);
                    }
                }, c38492q, i2));
                c38492q.mo6107M(i, mo73394j("ok", null));
                AppMethodBeat.m2505o(74773);
                return;
            }
            c38492q.mo6107M(i, mo73394j("fail:not TabBar page", null));
            AppMethodBeat.m2505o(74773);
        } catch (Exception e) {
            c38492q.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(74773);
        }
    }
}

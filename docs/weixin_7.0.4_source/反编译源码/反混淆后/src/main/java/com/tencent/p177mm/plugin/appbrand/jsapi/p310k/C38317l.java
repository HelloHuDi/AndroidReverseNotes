package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.l */
public final class C38317l extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 453;
    public static final String NAME = "setBackgroundColor";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74760);
        C38492q c38492q = (C38492q) c2241c;
        final C44709u pageView = c38492q.getRuntime().asV().getPageView();
        if (pageView == null) {
            c38492q.mo6107M(i, "fail:page don't exist");
            AppMethodBeat.m2505o(74760);
            return;
        }
        try {
            final long Ef = (long) C42668g.m75552Ef(jSONObject.optString("backgroundColor", ""));
            pageView.getContentView().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(74759);
                    pageView.isK.setPullDownBackgroundColor((int) Ef);
                    AppMethodBeat.m2505o(74759);
                }
            });
            c38492q.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74760);
        } catch (Exception e) {
            c38492q.mo6107M(i, mo73394j("fail:invalid color", null));
            AppMethodBeat.m2505o(74760);
        }
    }
}

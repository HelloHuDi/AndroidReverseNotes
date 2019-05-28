package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.m */
public final class C27009m extends C10296a<C38492q> {
    public static final int CTRL_INDEX = 454;
    public static final String NAME = "setBackgroundTextStyle";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74762);
        C38492q c38492q = (C38492q) c2241c;
        final C44709u pageView = c38492q.getRuntime().asV().getPageView();
        if (pageView == null) {
            c38492q.mo6107M(i, "fail");
            AppMethodBeat.m2505o(74762);
            return;
        }
        final String optString = jSONObject.optString("textStyle", "ignore");
        pageView.getContentView().post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74761);
                pageView.isK.setBackgroundTextStyle(optString);
                AppMethodBeat.m2505o(74761);
            }
        });
        c38492q.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(74762);
    }
}

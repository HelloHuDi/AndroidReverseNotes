package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42743o;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.g */
public final class C33288g extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 77;
    private static final String NAME = "setKeyboardValue";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(123544);
        C38492q c38492q = (C38492q) c2241c;
        C44709u currentPageView = c38492q.getCurrentPageView();
        if (currentPageView == null || !currentPageView.isRunning()) {
            c38492q.mo6107M(i, mo73394j("fail current page not available", null));
            AppMethodBeat.m2505o(123544);
            return;
        }
        try {
            Integer valueOf;
            String string = jSONObject.getString("value");
            try {
                valueOf = Integer.valueOf(jSONObject.getInt("cursor"));
            } catch (Exception e) {
                valueOf = null;
            }
            C42743o.m75751a(currentPageView, string, valueOf);
            c38492q.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(123544);
        } catch (Exception e2) {
            c38492q.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(123544);
        }
    }
}

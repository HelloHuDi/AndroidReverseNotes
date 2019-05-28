package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42743o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.c */
public final class C2272c extends C10296a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(123527);
        Integer num = null;
        try {
            num = Integer.valueOf(jSONObject.getInt("inputId"));
        } catch (JSONException e) {
        }
        C45673m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(123526);
                if (c2241c.isRunning()) {
                    C44709u c44709u;
                    C2241c c2241c = c2241c;
                    if (c2241c instanceof C44709u) {
                        c44709u = (C44709u) c2241c;
                    } else if (c2241c instanceof C38492q) {
                        c44709u = ((C38492q) c2241c).getRuntime().asV().getCurrentPage().getCurrentPageView();
                    } else {
                        C4990ab.m7412e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
                        c44709u = null;
                    }
                    c2241c.mo6107M(i, C2272c.this.mo73394j(C42743o.m75753a(c44709u, num) ? "ok" : "fail:input not exists", null));
                    AppMethodBeat.m2505o(123526);
                    return;
                }
                AppMethodBeat.m2505o(123526);
            }
        });
        AppMethodBeat.m2505o(123527);
    }
}

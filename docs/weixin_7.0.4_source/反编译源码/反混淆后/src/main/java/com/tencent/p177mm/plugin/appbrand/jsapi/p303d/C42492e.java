package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42743o;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.e */
public final class C42492e extends C10296a<C44709u> {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(123541);
        C44709u c44709u = (C44709u) c2241c;
        try {
            final int i2 = jSONObject.getInt("inputId");
            final WeakReference weakReference = new WeakReference(c44709u);
            C45673m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(123540);
                    C44709u c44709u = (C44709u) weakReference.get();
                    if (c44709u == null) {
                        AppMethodBeat.m2505o(123540);
                        return;
                    }
                    if (c44709u.aJw() != null) {
                        c44709u.aJw().aqX();
                    }
                    c44709u.mo6107M(i, C42492e.this.mo73394j(C42743o.m75755b(c44709u, i2) ? "ok" : "fail", null));
                    AppMethodBeat.m2505o(123540);
                }
            });
            AppMethodBeat.m2505o(123541);
        } catch (JSONException e) {
            c44709u.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(123541);
        }
    }
}

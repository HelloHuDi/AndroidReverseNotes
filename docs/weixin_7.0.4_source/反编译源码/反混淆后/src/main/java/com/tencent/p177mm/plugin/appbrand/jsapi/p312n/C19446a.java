package com.tencent.p177mm.plugin.appbrand.jsapi.p312n;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.a */
public final class C19446a extends C10296a<C38492q> {
    private static final int CTRL_INDEX = 106;
    private static final String NAME = "hideToast";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(74780);
        final C38492q c38492q = (C38492q) c2241c;
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74779);
                C19446a c19446a = C19446a.this;
                C38492q c38492q = c38492q;
                int i = i;
                C32800b nV = C37922v.m64076Zp().mo60674nV(c38492q.hashCode() + "toast_name");
                if (nV != null) {
                    View view = (View) nV.get("toast_view", null);
                    if (view != null) {
                        view.setVisibility(8);
                        c38492q.mo6107M(i, c19446a.mo73394j("ok", null));
                        AppMethodBeat.m2505o(74779);
                        return;
                    }
                }
                c38492q.mo6107M(i, c19446a.mo73394j("fail:toast can't be found", null));
                AppMethodBeat.m2505o(74779);
            }
        });
        AppMethodBeat.m2505o(74780);
    }
}

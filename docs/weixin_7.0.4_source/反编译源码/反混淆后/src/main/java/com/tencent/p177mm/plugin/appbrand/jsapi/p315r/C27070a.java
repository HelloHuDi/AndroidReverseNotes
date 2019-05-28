package com.tencent.p177mm.plugin.appbrand.jsapi.p315r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.r.a */
public final class C27070a extends C10296a {
    private static final int CTRL_INDEX = 471;
    private static final String NAME = "hideStatusBar";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        C44709u currentPageView;
        AppMethodBeat.m2504i(74804);
        if (c2241c instanceof C38492q) {
            currentPageView = ((C38492q) c2241c).getCurrentPageView();
        } else {
            currentPageView = (C44709u) c2241c;
        }
        mo44741a(currentPageView.isT, c2241c, i);
        AppMethodBeat.m2505o(74804);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo44741a(final C19627c c19627c, final C2241c c2241c, final int i) {
        AppMethodBeat.m2504i(74805);
        if (C5004al.isMainThread()) {
            c19627c.aBs();
            c2241c.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74805);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74803);
                C27070a.this.mo44741a(c19627c, c2241c, i);
                AppMethodBeat.m2505o(74803);
            }
        });
        AppMethodBeat.m2505o(74805);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 471;
    private static final String NAME = "hideStatusBar";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        u currentPageView;
        AppMethodBeat.i(74804);
        if (cVar instanceof q) {
            currentPageView = ((q) cVar).getCurrentPageView();
        } else {
            currentPageView = (u) cVar;
        }
        a(currentPageView.isT, cVar, i);
        AppMethodBeat.o(74804);
    }

    /* Access modifiers changed, original: final */
    public final void a(final com.tencent.mm.plugin.appbrand.page.b.c cVar, final c cVar2, final int i) {
        AppMethodBeat.i(74805);
        if (al.isMainThread()) {
            cVar.aBs();
            cVar2.M(i, j("ok", null));
            AppMethodBeat.o(74805);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74803);
                a.this.a(cVar, cVar2, i);
                AppMethodBeat.o(74803);
            }
        });
        AppMethodBeat.o(74805);
    }
}

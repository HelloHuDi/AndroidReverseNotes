package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.weishi.e;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public final class p extends o {
    p(w wVar, List<n> list) {
        super(wVar, list);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(d dVar) {
        boolean z = false;
        AppMethodBeat.i(132338);
        super.a(dVar);
        final w wVar = (w) this.hTn;
        if (e.E(wVar.getRuntime())) {
            dVar.uEO = true;
            dVar.uEP = true;
        } else if (wVar.getRuntime().xy()) {
            boolean z2;
            if (wVar.isFullScreen() || wVar.aJQ()) {
                z2 = true;
            } else {
                z2 = false;
            }
            dVar.uEO = z2;
            if (wVar.isFullScreen() || wVar.aJQ()) {
                z = true;
            }
            dVar.uEP = z;
        } else {
            dVar.uEO = wVar.isFullScreen();
            dVar.uEP = wVar.isFullScreen();
        }
        wVar.a((b) new b() {
            public final void wW() {
                AppMethodBeat.i(132336);
                wVar.b((b) this);
                p.this.aJn();
                AppMethodBeat.o(132336);
            }
        });
        wVar.a((c) new c() {
            public final void onDestroy() {
                AppMethodBeat.i(132337);
                wVar.b((c) this);
                p.this.aJn();
                AppMethodBeat.o(132337);
            }
        });
        AppMethodBeat.o(132338);
    }
}

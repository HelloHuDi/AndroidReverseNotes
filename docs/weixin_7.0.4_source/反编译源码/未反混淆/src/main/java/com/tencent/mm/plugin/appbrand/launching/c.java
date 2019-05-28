package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.boots.a.b;

public final class c extends b {
    public static void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(131717);
        appBrandInitConfigWC.resetSession();
        appBrandInitConfigWC.resetSession();
        g.RN();
        appBrandInitConfigWC.uin = a.QF();
        boolean aI = f.auT().aI(appBrandInitConfigWC.username, appBrandInitConfigWC.gVs);
        if (f.auU().aF(appBrandInitConfigWC.username, appBrandInitConfigWC.gVs)) {
            appBrandStatObject.iAo = 1;
        } else if (aI) {
            appBrandStatObject.iAo = 2;
        } else {
            appBrandStatObject.iAo = 3;
        }
        if (appBrandInitConfigWC.xy()) {
            ((com.tencent.mm.plugin.boots.a.c) g.K(com.tencent.mm.plugin.boots.a.c.class)).rT(b.jJv);
        }
        if (!appBrandInitConfigWC.hgJ) {
            ((com.tencent.mm.plugin.boots.a.c) g.K(com.tencent.mm.plugin.boots.a.c.class)).rT(b.jJx);
            if (!appBrandInitConfigWC.xy()) {
                ((com.tencent.mm.plugin.boots.a.c) g.K(com.tencent.mm.plugin.boots.a.c.class)).rT(b.jJy);
            }
        }
        AppMethodBeat.o(131717);
    }
}

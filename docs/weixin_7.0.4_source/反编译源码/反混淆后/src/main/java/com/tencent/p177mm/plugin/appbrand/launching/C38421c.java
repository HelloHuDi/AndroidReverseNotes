package com.tencent.p177mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.boots.p348a.C20015c;
import com.tencent.p177mm.plugin.boots.p348a.C27502b;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.c */
public final class C38421c extends C45637b {
    /* renamed from: a */
    public static void m65007a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(131717);
        appBrandInitConfigWC.resetSession();
        appBrandInitConfigWC.resetSession();
        C1720g.m3534RN();
        appBrandInitConfigWC.uin = C1668a.m3383QF();
        boolean aI = C42340f.auT().mo73331aI(appBrandInitConfigWC.username, appBrandInitConfigWC.gVs);
        if (C42340f.auU().mo44551aF(appBrandInitConfigWC.username, appBrandInitConfigWC.gVs)) {
            appBrandStatObject.iAo = 1;
        } else if (aI) {
            appBrandStatObject.iAo = 2;
        } else {
            appBrandStatObject.iAo = 3;
        }
        if (appBrandInitConfigWC.mo32992xy()) {
            ((C20015c) C1720g.m3528K(C20015c.class)).mo6743rT(C27502b.jJv);
        }
        if (!appBrandInitConfigWC.hgJ) {
            ((C20015c) C1720g.m3528K(C20015c.class)).mo6743rT(C27502b.jJx);
            if (!appBrandInitConfigWC.mo32992xy()) {
                ((C20015c) C1720g.m3528K(C20015c.class)).mo6743rT(C27502b.jJy);
            }
        }
        AppMethodBeat.m2505o(131717);
    }
}

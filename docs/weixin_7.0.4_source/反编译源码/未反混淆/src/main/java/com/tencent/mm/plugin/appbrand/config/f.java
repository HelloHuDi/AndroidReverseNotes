package com.tencent.mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends a {
    private final String[] hgH = new String[]{"wx308bd2aeb83d3345"};

    public final /* synthetic */ AppBrandInitConfigLU a(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(129832);
        AppBrandInitConfigWC b = b(wxaAttributes);
        AppMethodBeat.o(129832);
        return b;
    }

    public final /* synthetic */ AppBrandInitConfigLU bM(String str) {
        AppMethodBeat.i(129831);
        AppBrandInitConfigWC yY = yY(str);
        AppMethodBeat.o(129831);
        return yY;
    }

    private f() {
        AppMethodBeat.i(129827);
        AppMethodBeat.o(129827);
    }

    public static void init() {
        AppMethodBeat.i(129828);
        synchronized (a.class) {
            try {
                bPZ = new f();
                p.ayH().c(bPZ);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(129828);
            }
        }
    }

    public static f ayD() {
        f fVar;
        synchronized (a.class) {
            fVar = (f) bPZ;
        }
        return fVar;
    }

    public final AppBrandInitConfigWC yY(String str) {
        AppMethodBeat.i(129829);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.bM(str);
        AppMethodBeat.o(129829);
        return appBrandInitConfigWC;
    }

    public final AppBrandInitConfigWC b(WxaAttributes wxaAttributes) {
        AppBrandInitConfigWC appBrandInitConfigWC;
        boolean z = true;
        AppMethodBeat.i(129830);
        AppBrandInitConfigLU a = super.a(wxaAttributes);
        if (a != null) {
            boolean z2;
            AppBrandInitConfigWC appBrandInitConfigWC2 = new AppBrandInitConfigWC(a.xD());
            if (wxaAttributes.ayJ().hhS > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(z2 || wxaAttributes.ayJ().fmr == 7) || org.apache.commons.b.a.contains(this.hgH, appBrandInitConfigWC2.appId)) {
                z = false;
            }
            appBrandInitConfigWC2.hgJ = z;
            appBrandInitConfigWC = appBrandInitConfigWC2;
        } else {
            appBrandInitConfigWC = null;
        }
        AppMethodBeat.o(129830);
        return appBrandInitConfigWC;
    }
}

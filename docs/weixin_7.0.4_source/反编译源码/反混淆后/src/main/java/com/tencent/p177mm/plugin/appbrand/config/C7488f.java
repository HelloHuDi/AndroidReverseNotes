package com.tencent.p177mm.plugin.appbrand.config;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.C6276a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.apache.commons.p703b.C16470a;

/* renamed from: com.tencent.mm.plugin.appbrand.config.f */
public final class C7488f extends C6276a {
    private final String[] hgH = new String[]{"wx308bd2aeb83d3345"};

    /* renamed from: a */
    public final /* synthetic */ AppBrandInitConfigLU mo14505a(WxaAttributes wxaAttributes) {
        AppMethodBeat.m2504i(129832);
        AppBrandInitConfigWC b = mo16715b(wxaAttributes);
        AppMethodBeat.m2505o(129832);
        return b;
    }

    /* renamed from: bM */
    public final /* synthetic */ AppBrandInitConfigLU mo14508bM(String str) {
        AppMethodBeat.m2504i(129831);
        AppBrandInitConfigWC yY = mo16716yY(str);
        AppMethodBeat.m2505o(129831);
        return yY;
    }

    private C7488f() {
        AppMethodBeat.m2504i(129827);
        AppMethodBeat.m2505o(129827);
    }

    public static void init() {
        AppMethodBeat.m2504i(129828);
        synchronized (C6276a.class) {
            try {
                bPZ = new C7488f();
                C26842p.ayH().mo10116c(bPZ);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(129828);
            }
        }
    }

    public static C7488f ayD() {
        C7488f c7488f;
        synchronized (C6276a.class) {
            c7488f = (C7488f) bPZ;
        }
        return c7488f;
    }

    /* renamed from: yY */
    public final AppBrandInitConfigWC mo16716yY(String str) {
        AppMethodBeat.m2504i(129829);
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) super.mo14508bM(str);
        AppMethodBeat.m2505o(129829);
        return appBrandInitConfigWC;
    }

    /* renamed from: b */
    public final AppBrandInitConfigWC mo16715b(WxaAttributes wxaAttributes) {
        AppBrandInitConfigWC appBrandInitConfigWC;
        boolean z = true;
        AppMethodBeat.m2504i(129830);
        AppBrandInitConfigLU a = super.mo14505a(wxaAttributes);
        if (a != null) {
            boolean z2;
            AppBrandInitConfigWC appBrandInitConfigWC2 = new AppBrandInitConfigWC(a.mo32990xD());
            if (wxaAttributes.ayJ().hhS > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!(z2 || wxaAttributes.ayJ().fmr == 7) || C16470a.contains(this.hgH, appBrandInitConfigWC2.appId)) {
                z = false;
            }
            appBrandInitConfigWC2.hgJ = z;
            appBrandInitConfigWC = appBrandInitConfigWC2;
        } else {
            appBrandInitConfigWC = null;
        }
        AppMethodBeat.m2505o(129830);
        return appBrandInitConfigWC;
    }
}

package com.tencent.p177mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33327h;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCAccessible;", "", "()V", "getUsername", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.p */
public final class C42641p {
    public static final C42641p gPG = new C42641p();

    static {
        AppMethodBeat.m2504i(134453);
        AppMethodBeat.m2505o(134453);
    }

    private C42641p() {
    }

    /* renamed from: a */
    public static final String m75509a(C2241c c2241c) {
        String str;
        AppMethodBeat.m2504i(134448);
        if (c2241c instanceof C33327h) {
            Object str2 = c2241c;
        } else {
            str2 = null;
        }
        C33327h c33327h = (C33327h) str2;
        C6750i runtime = c33327h != null ? c33327h.getRuntime() : null;
        if (!(runtime instanceof C41243o)) {
            runtime = null;
        }
        C41243o c41243o = (C41243o) runtime;
        if (c41243o != null) {
            AppBrandInitConfigWC atI = c41243o.atI();
            if (atI != null) {
                String str3 = atI.username;
                AppMethodBeat.m2505o(134448);
                return str3;
            }
        }
        AppMethodBeat.m2505o(134448);
        return null;
    }

    /* renamed from: k */
    public static final boolean m75512k(C6750i c6750i) {
        AppMethodBeat.m2504i(134449);
        C41243o c41243o = (C41243o) (!(c6750i instanceof C41243o) ? null : c6750i);
        if (c41243o != null) {
            boolean xy = c41243o.mo65903xy();
            AppMethodBeat.m2505o(134449);
            return xy;
        }
        AppMethodBeat.m2505o(134449);
        return false;
    }

    /* renamed from: f */
    public static final boolean m75511f(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(134450);
        C25052j.m39376p(appBrandInitConfig, "initConfig");
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) (!(appBrandInitConfig instanceof AppBrandInitConfigWC) ? null : appBrandInitConfig);
        if (appBrandInitConfigWC != null) {
            boolean xy = appBrandInitConfigWC.mo32992xy();
            AppMethodBeat.m2505o(134450);
            return xy;
        }
        AppMethodBeat.m2505o(134450);
        return false;
    }

    /* renamed from: b */
    public static final boolean m75510b(C2241c c2241c) {
        C6750i c6750i;
        C6750i c6750i2 = null;
        AppMethodBeat.m2504i(134451);
        if (c2241c instanceof C33327h) {
            Object c6750i3 = c2241c;
        } else {
            c6750i3 = null;
        }
        C33327h c33327h = (C33327h) c6750i3;
        if (c33327h != null) {
            c6750i2 = c33327h.getRuntime();
        }
        boolean k = C42641p.m75512k(c6750i2);
        AppMethodBeat.m2505o(134451);
        return k;
    }

    /* renamed from: l */
    public static final boolean m75513l(C6750i c6750i) {
        AppMethodBeat.m2504i(134452);
        C41243o c41243o = (C41243o) (!(c6750i instanceof C41243o) ? null : c6750i);
        if (c41243o != null) {
            boolean atD = c41243o.atD();
            AppMethodBeat.m2505o(134452);
            return atD;
        }
        AppMethodBeat.m2505o(134452);
        return false;
    }
}

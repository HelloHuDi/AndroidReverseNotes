package com.tencent.mm.plugin.appbrand;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;

@l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWCAccessible;", "", "()V", "getUsername", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isGame", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "isPluginApp", "plugin-appbrand-integration_release"})
public final class p {
    public static final p gPG = new p();

    static {
        AppMethodBeat.i(134453);
        AppMethodBeat.o(134453);
    }

    private p() {
    }

    public static final String a(c cVar) {
        String str;
        AppMethodBeat.i(134448);
        if (cVar instanceof h) {
            Object str2 = cVar;
        } else {
            str2 = null;
        }
        h hVar = (h) str2;
        i runtime = hVar != null ? hVar.getRuntime() : null;
        if (!(runtime instanceof o)) {
            runtime = null;
        }
        o oVar = (o) runtime;
        if (oVar != null) {
            AppBrandInitConfigWC atI = oVar.atI();
            if (atI != null) {
                String str3 = atI.username;
                AppMethodBeat.o(134448);
                return str3;
            }
        }
        AppMethodBeat.o(134448);
        return null;
    }

    public static final boolean k(i iVar) {
        AppMethodBeat.i(134449);
        o oVar = (o) (!(iVar instanceof o) ? null : iVar);
        if (oVar != null) {
            boolean xy = oVar.xy();
            AppMethodBeat.o(134449);
            return xy;
        }
        AppMethodBeat.o(134449);
        return false;
    }

    public static final boolean f(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(134450);
        j.p(appBrandInitConfig, "initConfig");
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) (!(appBrandInitConfig instanceof AppBrandInitConfigWC) ? null : appBrandInitConfig);
        if (appBrandInitConfigWC != null) {
            boolean xy = appBrandInitConfigWC.xy();
            AppMethodBeat.o(134450);
            return xy;
        }
        AppMethodBeat.o(134450);
        return false;
    }

    public static final boolean b(c cVar) {
        i iVar;
        i iVar2 = null;
        AppMethodBeat.i(134451);
        if (cVar instanceof h) {
            Object iVar3 = cVar;
        } else {
            iVar3 = null;
        }
        h hVar = (h) iVar3;
        if (hVar != null) {
            iVar2 = hVar.getRuntime();
        }
        boolean k = k(iVar2);
        AppMethodBeat.o(134451);
        return k;
    }

    public static final boolean l(i iVar) {
        AppMethodBeat.i(134452);
        o oVar = (o) (!(iVar instanceof o) ? null : iVar);
        if (oVar != null) {
            boolean atD = oVar.atD();
            AppMethodBeat.o(134452);
            return atD;
        }
        AppMethodBeat.o(134452);
        return false;
    }
}

package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.a;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
public final class e {
    public static final e iks = new e();

    static {
        AppMethodBeat.i(134737);
        AppMethodBeat.o(134737);
    }

    private e() {
    }

    public static final AppBrandSysConfigWC a(j jVar) {
        AppMethodBeat.i(134735);
        j.p(jVar, "runtime");
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) XIPCInvoker.a("com.tencent.mm", new IPCString(jVar.getAppId()), l.class);
        if (appBrandSysConfigWC != null) {
            appBrandSysConfigWC.hhd.gVt = jVar.atI().gVs;
            appBrandSysConfigWC.hhd.gVu = jVar.atI().axy;
            appBrandSysConfigWC.hhd.gVw = true;
            AppMethodBeat.o(134735);
            return appBrandSysConfigWC;
        }
        AppMethodBeat.o(134735);
        return null;
    }

    public static final a b(j jVar) {
        AppMethodBeat.i(134736);
        j.p(jVar, "runtime");
        a yT = a.yT("{}");
        yT.hfg = jVar.atI().hgC;
        j.o(yT, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
        AppMethodBeat.o(134736);
        return yT;
    }
}

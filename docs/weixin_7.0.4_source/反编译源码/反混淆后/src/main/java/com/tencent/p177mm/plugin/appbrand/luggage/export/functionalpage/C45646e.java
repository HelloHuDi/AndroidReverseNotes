package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C38163a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalConfigAssembler;", "", "()V", "assembleAppConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "runtime", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalRuntime;", "assembleSysConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandSysConfigWC;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e */
public final class C45646e {
    public static final C45646e iks = new C45646e();

    static {
        AppMethodBeat.m2504i(134737);
        AppMethodBeat.m2505o(134737);
    }

    private C45646e() {
    }

    /* renamed from: a */
    public static final AppBrandSysConfigWC m84290a(C27187j c27187j) {
        AppMethodBeat.m2504i(134735);
        C25052j.m39376p(c27187j, "runtime");
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) XIPCInvoker.m83628a("com.tencent.mm", new IPCString(c27187j.getAppId()), C46896l.class);
        if (appBrandSysConfigWC != null) {
            appBrandSysConfigWC.hhd.gVt = c27187j.atI().gVs;
            appBrandSysConfigWC.hhd.gVu = c27187j.atI().axy;
            appBrandSysConfigWC.hhd.gVw = true;
            AppMethodBeat.m2505o(134735);
            return appBrandSysConfigWC;
        }
        AppMethodBeat.m2505o(134735);
        return null;
    }

    /* renamed from: b */
    public static final C38163a m84291b(C27187j c27187j) {
        AppMethodBeat.m2504i(134736);
        C25052j.m39376p(c27187j, "runtime");
        C38163a yT = C38163a.m64596yT("{}");
        yT.hfg = c27187j.atI().hgC;
        C25052j.m39375o(yT, "AppBrandAppConfig.parse(…onfig.enterPath\n        }");
        AppMethodBeat.m2505o(134736);
        return yT;
    }
}

package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "navigateToStandaloneActivity", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.j */
public final class C10489j {
    public static final C10489j hRc = new C10489j();

    static {
        AppMethodBeat.m2504i(134683);
        AppMethodBeat.m2505o(134683);
    }

    private C10489j() {
    }

    /* renamed from: a */
    public static final boolean m18204a(C41243o c41243o, C41243o c41243o2, AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.m2504i(134682);
        C25052j.m39376p(c41243o, "from");
        C25052j.m39376p(c41243o2, "to");
        C25052j.m39376p(appBrandInitConfigWC, "config");
        if (c41243o.mo65903xy() && appBrandInitConfigWC.mo32992xy()) {
            C10600f.ijT.mo33003a(c41243o.atM(), null, appBrandInitConfigWC.appId, appBrandInitConfigWC.hgC, appBrandInitConfigWC.gVs, appBrandInitConfigWC.axy, appBrandInitConfigWC.mo32991xx(), appBrandInitConfigWC.hgF, null);
            AppMethodBeat.m2505o(134682);
            return true;
        }
        AppMethodBeat.m2505o(134682);
        return false;
    }
}

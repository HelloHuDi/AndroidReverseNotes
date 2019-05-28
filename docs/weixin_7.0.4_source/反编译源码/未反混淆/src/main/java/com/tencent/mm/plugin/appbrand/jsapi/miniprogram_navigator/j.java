package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.o;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/MiniProgramNavigatorUglyLogic;", "", "()V", "loadNewRuntimeUglyMaybe", "", "from", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "to", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "navigateToStandaloneActivity", "", "plugin-appbrand-integration_release"})
public final class j {
    public static final j hRc = new j();

    static {
        AppMethodBeat.i(134683);
        AppMethodBeat.o(134683);
    }

    private j() {
    }

    public static final boolean a(o oVar, o oVar2, AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(134682);
        a.f.b.j.p(oVar, "from");
        a.f.b.j.p(oVar2, "to");
        a.f.b.j.p(appBrandInitConfigWC, "config");
        if (oVar.xy() && appBrandInitConfigWC.xy()) {
            f.ijT.a(oVar.atM(), null, appBrandInitConfigWC.appId, appBrandInitConfigWC.hgC, appBrandInitConfigWC.gVs, appBrandInitConfigWC.axy, appBrandInitConfigWC.xx(), appBrandInitConfigWC.hgF, null);
            AppMethodBeat.o(134682);
            return true;
        }
        AppMethodBeat.o(134682);
        return false;
    }
}

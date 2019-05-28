package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class f {
    public static void a(final Context context, final AppBrandInitConfigWC appBrandInitConfigWC, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(131771);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(131770);
                Context context = context;
                AppBrandInitConfig appBrandInitConfig = appBrandInitConfigWC;
                AppBrandStatObject appBrandStatObject = appBrandStatObject;
                int d = h.d(context, appBrandInitConfig, appBrandStatObject);
                if (context instanceof Activity) {
                    appBrandInitConfig.bQn = appBrandStatObject;
                    ((u) e.B(u.class)).a((Activity) context, appBrandInitConfig);
                }
                ab.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", appBrandInitConfig);
                if (d == 1 && !com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f.d(appBrandInitConfig, appBrandStatObject)) {
                    new g(appBrandInitConfig, appBrandStatObject).aHd();
                    com.tencent.mm.plugin.report.service.h.pYm.k(369, 21, 1);
                }
                AppMethodBeat.o(131770);
            }
        };
        if (al.isMainThread()) {
            anonymousClass1.run();
            AppMethodBeat.o(131771);
            return;
        }
        al.d(anonymousClass1);
        AppMethodBeat.o(131771);
    }
}

package com.tencent.p177mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C38435f;
import com.tencent.p177mm.plugin.appbrand.p336ui.C38565u;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.f */
public final class C10596f {
    /* renamed from: a */
    public static void m18275a(final Context context, final AppBrandInitConfigWC appBrandInitConfigWC, final AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(131771);
        C105971 c105971 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(131770);
                Context context = context;
                AppBrandInitConfig appBrandInitConfig = appBrandInitConfigWC;
                AppBrandStatObject appBrandStatObject = appBrandStatObject;
                int d = C45694h.m84427d(context, appBrandInitConfig, appBrandStatObject);
                if (context instanceof Activity) {
                    appBrandInitConfig.bQn = appBrandStatObject;
                    ((C38565u) C37384e.m62985B(C38565u.class)).mo32996a((Activity) context, appBrandInitConfig);
                }
                C4990ab.m7417i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", appBrandInitConfig);
                if (d == 1 && !C38435f.m65032d(appBrandInitConfig, appBrandStatObject)) {
                    new C27165g(appBrandInitConfig, appBrandStatObject).aHd();
                    C7060h.pYm.mo15419k(369, 21, 1);
                }
                AppMethodBeat.m2505o(131770);
            }
        };
        if (C5004al.isMainThread()) {
            c105971.run();
            AppMethodBeat.m2505o(131771);
            return;
        }
        C5004al.m7441d(c105971);
        AppMethodBeat.m2505o(131771);
    }
}

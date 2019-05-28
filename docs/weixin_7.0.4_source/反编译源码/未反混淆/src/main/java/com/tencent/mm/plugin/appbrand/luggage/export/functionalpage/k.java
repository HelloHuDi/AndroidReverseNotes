package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalUIAnimationStyle;", "", "()V", "setOpenAnimation", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"})
public final class k {
    public static final k ikD = new k();

    static {
        AppMethodBeat.i(134748);
        AppMethodBeat.o(134748);
    }

    private k() {
    }

    public static final boolean a(Activity activity, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        boolean z = false;
        AppMethodBeat.i(134747);
        j.p(activity, "activity");
        j.p(appBrandInitConfig, "config");
        j.p(appBrandStatObject, "stat");
        if (appBrandInitConfig instanceof AppBrandInitConfigWC) {
            try {
                if (f.d((AppBrandInitConfigWC) appBrandInitConfig, appBrandStatObject)) {
                    activity.overridePendingTransition(0, 0);
                    z = true;
                }
            } catch (Exception e) {
            }
            AppMethodBeat.o(134747);
        } else {
            AppMethodBeat.o(134747);
        }
        return z;
    }
}

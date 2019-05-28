package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalUIAnimationStyle;", "", "()V", "setOpenAnimation", "", "activity", "Landroid/app/Activity;", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k */
public final class C42625k {
    public static final C42625k ikD = new C42625k();

    static {
        AppMethodBeat.m2504i(134748);
        AppMethodBeat.m2505o(134748);
    }

    private C42625k() {
    }

    /* renamed from: a */
    public static final boolean m75487a(Activity activity, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        boolean z = false;
        AppMethodBeat.m2504i(134747);
        C25052j.m39376p(activity, "activity");
        C25052j.m39376p(appBrandInitConfig, "config");
        C25052j.m39376p(appBrandStatObject, "stat");
        if (appBrandInitConfig instanceof AppBrandInitConfigWC) {
            try {
                if (C38435f.m65032d((AppBrandInitConfigWC) appBrandInitConfig, appBrandStatObject)) {
                    activity.overridePendingTransition(0, 0);
                    z = true;
                }
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(134747);
        } else {
            AppMethodBeat.m2505o(134747);
        }
        return z;
    }
}

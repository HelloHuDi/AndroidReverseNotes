package com.tencent.p177mm.plugin.appbrand.weishi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;

/* renamed from: com.tencent.mm.plugin.appbrand.weishi.d */
public final class C33570d {
    /* renamed from: b */
    public static boolean m54820b(Activity activity, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(133640);
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appBrandInitConfig.appId)) {
            activity.overridePendingTransition(0, 0);
            AppMethodBeat.m2505o(133640);
            return true;
        }
        AppMethodBeat.m2505o(133640);
        return false;
    }
}

package com.tencent.mm.plugin.appbrand.weishi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

public final class d {
    public static boolean b(Activity activity, AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(133640);
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appBrandInitConfig.appId)) {
            activity.overridePendingTransition(0, 0);
            AppMethodBeat.o(133640);
            return true;
        }
        AppMethodBeat.o(133640);
        return false;
    }
}

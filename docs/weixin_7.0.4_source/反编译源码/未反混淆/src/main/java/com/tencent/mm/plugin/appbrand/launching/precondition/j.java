package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundfetch.b;
import com.tencent.mm.plugin.appbrand.backgroundfetch.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.c;
import com.tencent.mm.plugin.appbrand.launching.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

final class j {
    static String Co(String str) {
        AppMethodBeat.i(132082);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(132082);
            return str2;
        }
        ComponentName componentName = new ComponentName(ah.getContext(), str);
        PackageManager packageManager = ah.getContext().getPackageManager();
        if (packageManager == null) {
            str2 = "";
            AppMethodBeat.o(132082);
            return str2;
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (activityInfo == null) {
                str2 = "";
                AppMethodBeat.o(132082);
                return str2;
            }
            str2 = activityInfo.processName;
            AppMethodBeat.o(132082);
            return str2;
        } catch (NameNotFoundException e) {
            try {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, 128);
                if (serviceInfo == null) {
                    str2 = "";
                    AppMethodBeat.o(132082);
                    return str2;
                }
                str2 = serviceInfo.processName;
                AppMethodBeat.o(132082);
                return str2;
            } catch (NameNotFoundException e2) {
                str2 = "";
                AppMethodBeat.o(132082);
                return str2;
            }
        }
    }

    static void b(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(132083);
        ab.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", appBrandInitConfigWC);
        if (b.a(appBrandInitConfigWC)) {
            b.a(appBrandInitConfigWC.appId, appBrandInitConfigWC.username, appBrandInitConfigWC.gVs, appBrandInitConfigWC.hgC, appBrandStatObject.scene, new g());
        }
        c.a(appBrandInitConfigWC, appBrandStatObject);
        f.a(context, appBrandInitConfigWC, appBrandStatObject);
        com.tencent.mm.plugin.appbrand.config.f.ayD().a(appBrandInitConfigWC.username, (AppBrandInitConfigLU) appBrandInitConfigWC);
        AppMethodBeat.o(132083);
    }
}

package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C19126g;
import com.tencent.p177mm.plugin.appbrand.backgroundfetch.C42385b;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C7488f;
import com.tencent.p177mm.plugin.appbrand.launching.C10596f;
import com.tencent.p177mm.plugin.appbrand.launching.C38421c;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.j */
final class C42615j {
    /* renamed from: Co */
    static String m75456Co(String str) {
        AppMethodBeat.m2504i(132082);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(132082);
            return str2;
        }
        ComponentName componentName = new ComponentName(C4996ah.getContext(), str);
        PackageManager packageManager = C4996ah.getContext().getPackageManager();
        if (packageManager == null) {
            str2 = "";
            AppMethodBeat.m2505o(132082);
            return str2;
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (activityInfo == null) {
                str2 = "";
                AppMethodBeat.m2505o(132082);
                return str2;
            }
            str2 = activityInfo.processName;
            AppMethodBeat.m2505o(132082);
            return str2;
        } catch (NameNotFoundException e) {
            try {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(componentName, 128);
                if (serviceInfo == null) {
                    str2 = "";
                    AppMethodBeat.m2505o(132082);
                    return str2;
                }
                str2 = serviceInfo.processName;
                AppMethodBeat.m2505o(132082);
                return str2;
            } catch (NameNotFoundException e2) {
                str2 = "";
                AppMethodBeat.m2505o(132082);
                return str2;
            }
        }
    }

    /* renamed from: b */
    static void m75457b(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(132083);
        C4990ab.m7417i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", appBrandInitConfigWC);
        if (C42385b.m74999a(appBrandInitConfigWC)) {
            C42385b.m74997a(appBrandInitConfigWC.appId, appBrandInitConfigWC.username, appBrandInitConfigWC.gVs, appBrandInitConfigWC.hgC, appBrandStatObject.scene, new C19126g());
        }
        C38421c.m65007a(appBrandInitConfigWC, appBrandStatObject);
        C10596f.m18275a(context, appBrandInitConfigWC, appBrandStatObject);
        C7488f.ayD().mo14506a(appBrandInitConfigWC.username, (AppBrandInitConfigLU) appBrandInitConfigWC);
        AppMethodBeat.m2505o(132083);
    }
}

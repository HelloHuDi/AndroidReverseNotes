package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.soter.core.biometric.FaceManager;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
public final class f {
    public static final f ikt = new f();

    static {
        AppMethodBeat.i(134741);
        AppMethodBeat.o(134741);
    }

    private f() {
    }

    public static final boolean c(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(134738);
        j.p(appBrandInitConfigWC, "config");
        j.p(appBrandStatObject, "stat");
        if (d(appBrandInitConfigWC, appBrandStatObject)) {
            Context context2;
            h.DN(appBrandInitConfigWC.appId);
            if (context == null) {
                context = ah.getContext();
            }
            Intent intent = new Intent();
            intent.setClass(context, AppBrandPluginUI.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
            intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
            context.startActivity(intent);
            if (context instanceof Activity) {
                context2 = context;
            } else {
                context2 = null;
            }
            Activity activity = (Activity) context2;
            if (activity != null) {
                activity.overridePendingTransition(0, 0);
            }
            AppMethodBeat.o(134738);
            return true;
        }
        AppMethodBeat.o(134738);
        return false;
    }

    public static final o a(AppBrandInitConfigWC appBrandInitConfigWC, com.tencent.mm.plugin.appbrand.l lVar) {
        AppMethodBeat.i(134739);
        j.p(appBrandInitConfigWC, "config");
        j.p(lVar, "container");
        AppBrandStatObject xx = appBrandInitConfigWC.xx();
        j.o(xx, "config.statObject");
        if (d(appBrandInitConfigWC, xx)) {
            o jVar = new j(lVar.getContext(), lVar);
            AppMethodBeat.o(134739);
            return jVar;
        }
        AppMethodBeat.o(134739);
        return null;
    }

    public static final boolean d(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(134740);
        j.p(appBrandInitConfigWC, "config");
        j.p(appBrandStatObject, "stat");
        if (FaceManager.FACE_ACQUIRED_HACKER == appBrandStatObject.scene) {
            AppMethodBeat.o(134740);
            return true;
        }
        AppMethodBeat.o(134740);
        return false;
    }

    public static final boolean pf(int i) {
        return FaceManager.FACE_ACQUIRED_HACKER == i;
    }
}

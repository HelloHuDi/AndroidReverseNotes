package com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19553l;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandPluginUI;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.soter.core.biometric.FaceManager;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/FunctionalLaunchInterceptor;", "", "()V", "matchLaunchScene", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "scene", "", "shouldInterceptLaunch", "_context", "Landroid/content/Context;", "shouldOverrideRuntimeInitialization", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "container", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeContainerWC;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f */
public final class C38435f {
    public static final C38435f ikt = new C38435f();

    static {
        AppMethodBeat.m2504i(134741);
        AppMethodBeat.m2505o(134741);
    }

    private C38435f() {
    }

    /* renamed from: c */
    public static final boolean m65031c(Context context, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(134738);
        C25052j.m39376p(appBrandInitConfigWC, "config");
        C25052j.m39376p(appBrandStatObject, "stat");
        if (C38435f.m65032d(appBrandInitConfigWC, appBrandStatObject)) {
            Context context2;
            C45694h.m84411DN(appBrandInitConfigWC.appId);
            if (context == null) {
                context = C4996ah.getContext();
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
            AppMethodBeat.m2505o(134738);
            return true;
        }
        AppMethodBeat.m2505o(134738);
        return false;
    }

    /* renamed from: a */
    public static final C41243o m65030a(AppBrandInitConfigWC appBrandInitConfigWC, C19553l c19553l) {
        AppMethodBeat.m2504i(134739);
        C25052j.m39376p(appBrandInitConfigWC, "config");
        C25052j.m39376p(c19553l, "container");
        AppBrandStatObject xx = appBrandInitConfigWC.mo32991xx();
        C25052j.m39375o(xx, "config.statObject");
        if (C38435f.m65032d(appBrandInitConfigWC, xx)) {
            C41243o c27187j = new C27187j(c19553l.getContext(), c19553l);
            AppMethodBeat.m2505o(134739);
            return c27187j;
        }
        AppMethodBeat.m2505o(134739);
        return null;
    }

    /* renamed from: d */
    public static final boolean m65032d(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(134740);
        C25052j.m39376p(appBrandInitConfigWC, "config");
        C25052j.m39376p(appBrandStatObject, "stat");
        if (FaceManager.FACE_ACQUIRED_HACKER == appBrandStatObject.scene) {
            AppMethodBeat.m2505o(134740);
            return true;
        }
        AppMethodBeat.m2505o(134740);
        return false;
    }

    /* renamed from: pf */
    public static final boolean m65033pf(int i) {
        return FaceManager.FACE_ACQUIRED_HACKER == i;
    }
}

package com.tencent.luggage.sdk.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.ab;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.permission.j;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.sdk.platformtools.bo;

public class b extends i {
    public k bRn;
    private Boolean bRo = null;

    public /* synthetic */ h ye() {
        AppMethodBeat.i(101698);
        AppBrandSysConfigLU xZ = xZ();
        AppMethodBeat.o(101698);
        return xZ;
    }

    public /* synthetic */ AppBrandInitConfig yf() {
        AppMethodBeat.i(101699);
        AppBrandInitConfigLU ya = ya();
        AppMethodBeat.o(101699);
        return ya;
    }

    public b(Activity activity, ab abVar) {
        super(activity, abVar);
    }

    public e xY() {
        AppMethodBeat.i(101685);
        e eVar = new e(this, -1, true);
        AppMethodBeat.o(101685);
        return eVar;
    }

    public AppBrandSysConfigLU xZ() {
        AppMethodBeat.i(101687);
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) c(AppBrandSysConfigLU.class, false);
        AppMethodBeat.o(101687);
        return appBrandSysConfigLU;
    }

    public AppBrandInitConfigLU ya() {
        AppMethodBeat.i(101688);
        AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) super.yf();
        AppMethodBeat.o(101688);
        return appBrandInitConfigLU;
    }

    public final AppBrandStatObject xx() {
        AppMethodBeat.i(101689);
        AppBrandStatObject appBrandStatObject = ya().bQn;
        AppMethodBeat.o(101689);
        return appBrandStatObject;
    }

    public final void b(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(101690);
        AppBrandInitConfig xC = ya().xC();
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1038;
        if (appBrandInitConfig instanceof AppBrandInitConfigLU) {
            appBrandStatObject.cst = appBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU) appBrandInitConfig).xz() + ':' + (((AppBrandInitConfigLU) appBrandInitConfig).bQe + 1000);
        }
        xC.startTime = bo.anU();
        xC.hgC = null;
        xC.resetSession();
        xC.bQn = appBrandStatObject;
        a(xC);
        AppMethodBeat.o(101690);
    }

    public void onCreate() {
        AppMethodBeat.i(101692);
        super.onCreate();
        a(g.class, (a) j.iwZ);
        a(f.class, (a) new com.tencent.mm.plugin.appbrand.permission.h(this));
        AppMethodBeat.o(101692);
    }

    public final void yb() {
        AppMethodBeat.i(101693);
        super.yb();
        aw.a((i) this, (o) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.appstorage.o.class));
        AppMethodBeat.o(101693);
    }

    public void onDestroy() {
        AppMethodBeat.i(101694);
        super.onDestroy();
        if (this.bRn != null) {
            if (this.bRn.getParent() instanceof ViewGroup) {
                k kVar = this.bRn;
                AppBrandPerformanceManager.Dl(kVar.ivC.mAppId);
                kVar.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListener() {
                    public final void onAnimationStart(Animator animator) {
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(102333);
                        k.this.setVisibility(8);
                        AppMethodBeat.o(102333);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ((ViewGroup) this.bRn.getParent()).removeView(this.bRn);
            }
            this.bRn = null;
        }
        AppMethodBeat.o(101694);
    }

    /* Access modifiers changed, original: protected */
    public k yc() {
        AppMethodBeat.i(101695);
        k kVar = new k(getContext(), this);
        AppMethodBeat.o(101695);
        return kVar;
    }

    public boolean yd() {
        AppMethodBeat.i(101696);
        boolean booleanValue;
        if (this.bRo != null) {
            booleanValue = this.bRo.booleanValue();
            AppMethodBeat.o(101696);
            return booleanValue;
        }
        Boolean valueOf = Boolean.valueOf(a(ya()));
        this.bRo = valueOf;
        booleanValue = valueOf.booleanValue();
        AppMethodBeat.o(101696);
        return booleanValue;
    }

    private static boolean a(AppBrandInitConfigLU appBrandInitConfigLU) {
        AppMethodBeat.i(101697);
        if (appBrandInitConfigLU.bQf && b(appBrandInitConfigLU)) {
            AppMethodBeat.o(101697);
            return true;
        }
        AppMethodBeat.o(101697);
        return false;
    }

    public void a(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.i(101686);
        if (this.eMP) {
            boolean yd = yd();
            boolean a = a((AppBrandInitConfigLU) appBrandInitConfig);
            Object obj = ((yd || !a) && !(yd && !a && b((AppBrandInitConfigLU) appBrandInitConfig))) ? null : 1;
            if (obj != null) {
                this.bRo = null;
                atn();
            }
            super.a(appBrandInitConfig);
            AppMethodBeat.o(101686);
            return;
        }
        AppMethodBeat.o(101686);
    }

    public void onReady() {
        AppMethodBeat.i(101691);
        if (AppBrandPerformanceManager.b(this) && this.bRn == null) {
            AppBrandPerformanceManager.a(this);
            this.bRn = yc();
            if (this.bRn != null) {
                this.gNE.addView(this.bRn);
                k kVar = this.bRn;
                AppBrandPerformanceManager.c(kVar.ivC);
                kVar.setVisibility(0);
                kVar.setAlpha(0.0f);
                kVar.animate().alpha(1.0f).setDuration(500).setStartDelay(500).setListener(null);
            }
        }
        AppMethodBeat.o(101691);
    }

    private static boolean b(AppBrandInitConfigLU appBrandInitConfigLU) {
        AppBrandStatObject appBrandStatObject = appBrandInitConfigLU.bQn;
        return appBrandStatObject.scene == 1011 || appBrandStatObject.scene == 1012 || appBrandStatObject.scene == 1013;
    }
}

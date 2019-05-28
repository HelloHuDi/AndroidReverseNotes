package com.tencent.luggage.sdk.p148b;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.plugin.appbrand.C26719ab;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C19062o;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appstorage.C31282o;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19789k;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19789k.C197871;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.p177mm.plugin.appbrand.permission.C19661f;
import com.tencent.p177mm.plugin.appbrand.permission.C24706h;
import com.tencent.p177mm.plugin.appbrand.permission.C31331g;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.plugin.appbrand.permission.C42655j;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.luggage.sdk.b.b */
public class C25697b extends C6750i {
    public C19789k bRn;
    private Boolean bRo = null;

    /* renamed from: ye */
    public /* synthetic */ C16597h mo15034ye() {
        AppMethodBeat.m2504i(101698);
        AppBrandSysConfigLU xZ = mo43489xZ();
        AppMethodBeat.m2505o(101698);
        return xZ;
    }

    /* renamed from: yf */
    public /* synthetic */ AppBrandInitConfig mo15035yf() {
        AppMethodBeat.m2504i(101699);
        AppBrandInitConfigLU ya = mo43491ya();
        AppMethodBeat.m2505o(101699);
        return ya;
    }

    public C25697b(Activity activity, C26719ab c26719ab) {
        super(activity, c26719ab);
    }

    /* renamed from: xY */
    public C33491e mo43488xY() {
        AppMethodBeat.m2504i(101685);
        C33491e c33491e = new C33491e(this, -1, true);
        AppMethodBeat.m2505o(101685);
        return c33491e;
    }

    /* renamed from: xZ */
    public AppBrandSysConfigLU mo43489xZ() {
        AppMethodBeat.m2504i(101687);
        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) mo15016c(AppBrandSysConfigLU.class, false);
        AppMethodBeat.m2505o(101687);
        return appBrandSysConfigLU;
    }

    /* renamed from: ya */
    public AppBrandInitConfigLU mo43491ya() {
        AppMethodBeat.m2504i(101688);
        AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) super.mo15035yf();
        AppMethodBeat.m2505o(101688);
        return appBrandInitConfigLU;
    }

    /* renamed from: xx */
    public final AppBrandStatObject mo43490xx() {
        AppMethodBeat.m2504i(101689);
        AppBrandStatObject appBrandStatObject = mo43491ya().bQn;
        AppMethodBeat.m2505o(101689);
        return appBrandStatObject;
    }

    /* renamed from: b */
    public final void mo15015b(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(101690);
        AppBrandInitConfig xC = mo43491ya().mo32989xC();
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1038;
        if (appBrandInitConfig instanceof AppBrandInitConfigLU) {
            appBrandStatObject.cst = appBrandInitConfig.appId + ':' + ((AppBrandInitConfigLU) appBrandInitConfig).mo32993xz() + ':' + (((AppBrandInitConfigLU) appBrandInitConfig).bQe + 1000);
        }
        xC.startTime = C5046bo.anU();
        xC.hgC = null;
        xC.resetSession();
        xC.bQn = appBrandStatObject;
        mo14980a(xC);
        AppMethodBeat.m2505o(101690);
    }

    public void onCreate() {
        AppMethodBeat.m2504i(101692);
        super.onCreate();
        mo14984a(C31331g.class, (C1694a) C42655j.iwZ);
        mo14984a(C19661f.class, (C1694a) new C24706h(this));
        AppMethodBeat.m2505o(101692);
    }

    /* renamed from: yb */
    public final void mo15033yb() {
        AppMethodBeat.m2504i(101693);
        super.mo15033yb();
        C33082aw.m54069a((C6750i) this, (C19062o) C37384e.m62985B(C31282o.class));
        AppMethodBeat.m2505o(101693);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(101694);
        super.onDestroy();
        if (this.bRn != null) {
            if (this.bRn.getParent() instanceof ViewGroup) {
                C19789k c19789k = this.bRn;
                AppBrandPerformanceManager.m43283Dl(c19789k.ivC.mAppId);
                c19789k.animate().alpha(0.0f).setDuration(500).setListener(new C197871());
                ((ViewGroup) this.bRn.getParent()).removeView(this.bRn);
            }
            this.bRn = null;
        }
        AppMethodBeat.m2505o(101694);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: yc */
    public C19789k mo43492yc() {
        AppMethodBeat.m2504i(101695);
        C19789k c19789k = new C19789k(getContext(), this);
        AppMethodBeat.m2505o(101695);
        return c19789k;
    }

    /* renamed from: yd */
    public boolean mo43493yd() {
        AppMethodBeat.m2504i(101696);
        boolean booleanValue;
        if (this.bRo != null) {
            booleanValue = this.bRo.booleanValue();
            AppMethodBeat.m2505o(101696);
            return booleanValue;
        }
        Boolean valueOf = Boolean.valueOf(C25697b.m40787a(mo43491ya()));
        this.bRo = valueOf;
        booleanValue = valueOf.booleanValue();
        AppMethodBeat.m2505o(101696);
        return booleanValue;
    }

    /* renamed from: a */
    private static boolean m40787a(AppBrandInitConfigLU appBrandInitConfigLU) {
        AppMethodBeat.m2504i(101697);
        if (appBrandInitConfigLU.bQf && C25697b.m40788b(appBrandInitConfigLU)) {
            AppMethodBeat.m2505o(101697);
            return true;
        }
        AppMethodBeat.m2505o(101697);
        return false;
    }

    /* renamed from: a */
    public void mo14980a(AppBrandInitConfig appBrandInitConfig) {
        AppMethodBeat.m2504i(101686);
        if (this.eMP) {
            boolean yd = mo43493yd();
            boolean a = C25697b.m40787a((AppBrandInitConfigLU) appBrandInitConfig);
            Object obj = ((yd || !a) && !(yd && !a && C25697b.m40788b((AppBrandInitConfigLU) appBrandInitConfig))) ? null : 1;
            if (obj != null) {
                this.bRo = null;
                atn();
            }
            super.mo14980a(appBrandInitConfig);
            AppMethodBeat.m2505o(101686);
            return;
        }
        AppMethodBeat.m2505o(101686);
    }

    public void onReady() {
        AppMethodBeat.m2504i(101691);
        if (AppBrandPerformanceManager.m43291b(this) && this.bRn == null) {
            AppBrandPerformanceManager.m43286a(this);
            this.bRn = mo43492yc();
            if (this.bRn != null) {
                this.gNE.addView(this.bRn);
                C19789k c19789k = this.bRn;
                AppBrandPerformanceManager.m43292c(c19789k.ivC);
                c19789k.setVisibility(0);
                c19789k.setAlpha(0.0f);
                c19789k.animate().alpha(1.0f).setDuration(500).setStartDelay(500).setListener(null);
            }
        }
        AppMethodBeat.m2505o(101691);
    }

    /* renamed from: b */
    private static boolean m40788b(AppBrandInitConfigLU appBrandInitConfigLU) {
        AppBrandStatObject appBrandStatObject = appBrandInitConfigLU.bQn;
        return appBrandStatObject.scene == 1011 || appBrandStatObject.scene == 1012 || appBrandStatObject.scene == 1013;
    }
}

package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.support.p057v4.app.C6184a.C0315a;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C0990c;
import com.tencent.luggage.p147g.C8870e.C8871d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.p238a.C1651a;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p232b.p233a.C1589bu;
import com.tencent.p177mm.p230g.p232b.p233a.C1589bu.C1590a;
import com.tencent.p177mm.p230g.p232b.p233a.C32666bq;
import com.tencent.p177mm.p230g.p232b.p233a.C32666bq.C32667a;
import com.tencent.p177mm.p230g.p232b.p233a.C32671bt;
import com.tencent.p177mm.p230g.p232b.p233a.C32671bt.C9507a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.appbrand.C19553l;
import com.tencent.p177mm.plugin.appbrand.C31311k.C313153;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C42641p;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.p177mm.plugin.appbrand.app.C19015b;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C21131;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C38162b.C268402;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.p1468a.C38094a;
import com.tencent.p177mm.plugin.appbrand.p281b.C10140e;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.permission.C19663n;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.task.C38520i;
import com.tencent.p177mm.plugin.appbrand.task.C38520i.C38521a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C11006a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C11006a.C110071;
import com.tencent.p177mm.plugin.appbrand.widget.input.C2560am;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C44761d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.sdk.p609h.C4972c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.WebView;
import java.util.Iterator;
import java.util.LinkedList;

@C5271a(1)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandUI */
public class AppBrandUI extends MMActivity implements C0315a, C19808s, C27350t {
    private C38520i gOD = new C335435();
    private final C11006a iIN = new C11006a(this);
    private boolean iIO = false;
    C19553l iIP;
    private C42695m iIQ;
    private C10140e iIR;
    private Intent iIS = null;
    private boolean iIT = false;
    private boolean iIU = false;
    private boolean iIV = false;
    private Configuration iIW = null;
    public boolean iIX = false;
    private Boolean iIY;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandUI$5 */
    class C335435 implements C38520i {
        C335435() {
        }

        public final Activity getContext() {
            return AppBrandUI.this;
        }

        public final FrameLayout aLY() {
            AppMethodBeat.m2504i(138139);
            FrameLayout frameLayout = (FrameLayout) AppBrandUI.this.mController.contentView;
            AppMethodBeat.m2505o(138139);
            return frameLayout;
        }

        /* renamed from: a */
        public final void mo54022a(C38521a c38521a) {
            AppMethodBeat.m2504i(138141);
            C27329h c27329h = C27329h.iJc;
            C27329h.m43383a(AppBrandUI.this, c38521a);
            AppMethodBeat.m2505o(138141);
        }

        public final boolean aLZ() {
            AppMethodBeat.m2504i(138142);
            boolean aLZ = AppBrandUI.this.aLZ();
            AppMethodBeat.m2505o(138142);
            return aLZ;
        }

        public final void finish() {
            AppMethodBeat.m2504i(138140);
            AppBrandUI.this.finish();
            AppMethodBeat.m2505o(138140);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandUI$4 */
    class C385234 implements OnClickListener {
        C385234() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandUI$3 */
    class C385243 implements OnPreDrawListener {
        C385243() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(133120);
            try {
                AppBrandUI.this.mController.contentView.getViewTreeObserver().removeOnPreDrawListener(this);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.AppBrandUI", "first onPreDraw after onResume, remove listener failed, e=%s", e);
            }
            AppBrandUI.this.onEnterAnimationComplete();
            AppMethodBeat.m2505o(133120);
            return true;
        }
    }

    public AppBrandUI() {
        AppMethodBeat.m2504i(133126);
        AppMethodBeat.m2505o(133126);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133127);
        C19015b.auF();
        this.iIT = !C19015b.auE();
        try {
            super.onCreate(bundle);
            if (getIntent() == null) {
                C4990ab.m7413e("MicroMsg.AppBrandUI", "onCreate %d, null intent", Integer.valueOf(hashCode()));
                finish();
                AppMethodBeat.m2505o(133127);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrandUI", "onCreate %d, intent.flags = %d", Integer.valueOf(hashCode()), Integer.valueOf(getIntent().getFlags()));
            this.iIW = new Configuration(getResources().getConfiguration());
            C11006a c11006a = this.iIN;
            FrameLayout aLY = this.gOD.aLY();
            if (!(c11006a.activity == null || c11006a.activity.getWindow() == null || aLY == null || aLY.getParent() == null || !(aLY.getParent() instanceof ViewGroup))) {
                c11006a.jde = true;
                ViewGroup viewGroup = (ViewGroup) aLY.getParent();
                viewGroup.removeView(aLY);
                C42740n c42740n = new C42740n(c11006a.activity, aLY);
                viewGroup.addView(c42740n, new LayoutParams(-1, -1));
                if (VERSION.SDK_INT < 20) {
                    Activity activity = c11006a.activity;
                    if (C4972c.dqy() && activity.getResources().getConfiguration().orientation != 2) {
                        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        activity.getWindow().addFlags(2048);
                        viewGroup.setPadding(0, C5222ae.getStatusBarHeight(activity), 0, 0);
                    }
                    c11006a.mo22664a(c42740n);
                }
                if (C11006a.jdd && C11006a.m18750dp(c11006a.activity)) {
                    C2560am.m4804a(viewGroup, new C110071());
                }
            }
            this.iIP = new C19553l(this.gOD);
            this.iIQ = new C42695m(this, this.iIP) {
                public final void awE() {
                    AppMethodBeat.m2504i(133117);
                    super.awE();
                    AppBrandUI.this.iIO = true;
                    AppMethodBeat.m2505o(133117);
                }
            };
            C42695m c42695m = this.iIQ;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                C4996ah.getContext().registerReceiver(c42695m.gWT, intentFilter);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = ".concat(String.valueOf(e)));
            }
            this.iIR = new C10140e(this) {
                public final void awC() {
                    AppMethodBeat.m2504i(133118);
                    C6750i atv = AppBrandUI.this.iIP.atv();
                    if (atv == null) {
                        AppMethodBeat.m2505o(133118);
                        return;
                    }
                    C33183g.m54275a(atv.mAppId, C33184d.HOME_PRESSED);
                    AppMethodBeat.m2505o(133118);
                }

                public final void awD() {
                    AppMethodBeat.m2504i(133119);
                    C6750i atv = AppBrandUI.this.iIP.atv();
                    if (atv == null) {
                        AppMethodBeat.m2505o(133119);
                        return;
                    }
                    C33183g.m54275a(atv.mAppId, C33184d.RECENT_APPS_PRESSED);
                    AppMethodBeat.m2505o(133119);
                }
            };
            C10140e c10140e = this.iIR;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            try {
                C4996ah.getContext().registerReceiver(c10140e.receiver, intentFilter);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = ".concat(String.valueOf(e2)));
            }
            C5222ae.m7950hD(this);
            C26835a t = C26835a.m42717t((Activity) this);
            C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
            synchronized (t) {
                try {
                    t.mFinished = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(133127);
                }
            }
            this.iIS = getIntent();
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandUI", th, "%s.onCreate", getLocalClassName());
            finish();
            AppMethodBeat.m2505o(133127);
        }
    }

    private void aMs() {
        AppMethodBeat.m2504i(133128);
        C4990ab.m7417i("MicroMsg.AppBrandUI", "%s.closeIfNoActiveRuntimes %d,", getLocalClassName(), Integer.valueOf(this.iIP == null ? -1 : this.iIP.atw()));
        if (this.iIP instanceof C19553l) {
            this.iIP.atC();
            AppMethodBeat.m2505o(133128);
            return;
        }
        if (r0 <= 0) {
            finish();
        }
        AppMethodBeat.m2505o(133128);
    }

    public void onNewIntent(Intent intent) {
        int i = 1;
        AppMethodBeat.m2504i(133129);
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onNewIntent %s, %d", intent, Integer.valueOf(hashCode()));
        try {
            super.onNewIntent(intent);
            this.iIX = true;
            if (intent != null && intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
                aMs();
                AppMethodBeat.m2505o(133129);
            } else if (intent == null) {
                AppMethodBeat.m2505o(133129);
            } else {
                if (intent.getParcelableExtra("key_appbrand_init_config") == null) {
                    i = 0;
                }
                if (i == 0) {
                    C6750i atv = this.iIP == null ? null : this.iIP.atv();
                    if (atv == null || !C33183g.m54283wS(atv.mAppId)) {
                        AppMethodBeat.m2505o(133129);
                        return;
                    } else {
                        AppMethodBeat.m2505o(133129);
                        return;
                    }
                }
                this.iIS = intent;
                AppMethodBeat.m2505o(133129);
            }
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandUI", th, "%s.onNewIntent", getLocalClassName());
            aMs();
            AppMethodBeat.m2505o(133129);
        }
    }

    public final void aBS() {
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018 A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: J */
    public void mo34979J(Intent intent) {
        AppBrandStatObject appBrandStatObject;
        AppBrandInitConfigWC appBrandInitConfigWC;
        Exception e;
        AppMethodBeat.m2504i(133130);
        try {
            Pair K = AppBrandUI.m65232K(intent);
            AppBrandInitConfigWC appBrandInitConfigWC2 = (AppBrandInitConfigWC) K.first;
            try {
                appBrandStatObject = (AppBrandStatObject) K.second;
                appBrandInitConfigWC = appBrandInitConfigWC2;
            } catch (Exception e2) {
                e = e2;
                appBrandInitConfigWC = appBrandInitConfigWC2;
                C4990ab.m7413e("MicroMsg.AppBrandUI", "getParcelable: %s", e);
                appBrandStatObject = null;
                if (appBrandInitConfigWC != null) {
                }
                finish();
                AppMethodBeat.m2505o(133130);
                return;
            }
        } catch (Exception e3) {
            e = e3;
            appBrandInitConfigWC = null;
            C4990ab.m7413e("MicroMsg.AppBrandUI", "getParcelable: %s", e);
            appBrandStatObject = null;
            if (appBrandInitConfigWC != null) {
            }
            finish();
            AppMethodBeat.m2505o(133130);
            return;
        }
        if (appBrandInitConfigWC != null || appBrandStatObject == null || appBrandInitConfigWC.hgF == null) {
            if (this.iIP == null || this.iIP.atv() == null) {
                finish();
            }
            AppMethodBeat.m2505o(133130);
            return;
        }
        if ((intent.getFlags() & 1048576) > 0) {
            appBrandInitConfigWC.startTime = C5046bo.anU();
            appBrandInitConfigWC.hgP = 1;
        } else {
            appBrandInitConfigWC.hgP = 0;
        }
        try {
            if (this.iIT && !this.iIU) {
                if (appBrandInitConfigWC.hgN != null) {
                    this.iIU = true;
                    C32671bt c32671bt = new C32671bt();
                    c32671bt.mo53204gt(appBrandInitConfigWC.hgN.igT);
                    c32671bt.mo53205gu(appBrandInitConfigWC.appId);
                    c32671bt.ddd = (long) appBrandInitConfigWC.axy;
                    c32671bt.ddS = C9507a.m16930gU(appBrandInitConfigWC.gVs + 1);
                    c32671bt.ddz = (long) (appBrandInitConfigWC.bQe + 1000);
                    c32671bt.cVR = (long) appBrandStatObject.scene;
                    c32671bt.mo53202dF(appBrandInitConfigWC.hgK);
                    c32671bt.mo53203dG(C1651a.eKO);
                    c32671bt.mo53201dE(c32671bt.ddC - c32671bt.ddB);
                    c32671bt.ddT = (long) appBrandInitConfigWC.hgP;
                    c32671bt.ajK();
                    C1589bu c1589bu = new C1589bu();
                    c1589bu.mo5020gv(appBrandInitConfigWC.hgN.igT);
                    c1589bu.mo5021gw(appBrandInitConfigWC.appId);
                    c1589bu.ddd = (long) appBrandInitConfigWC.axy;
                    c1589bu.ddY = C1590a.m3215gV(appBrandInitConfigWC.gVs + 1);
                    c1589bu.ddz = (long) (appBrandInitConfigWC.bQe + 1000);
                    c1589bu.cVR = (long) appBrandStatObject.scene;
                    c1589bu.mo5018dI(C38094a.gQJ);
                    c1589bu.mo5019dJ(C38094a.gQK);
                    c1589bu.mo5017dH(c1589bu.ddC - c1589bu.ddB);
                    switch (WebView.getCurWebType()) {
                        case WV_KIND_CW:
                            c1589bu.dbX = 3;
                            break;
                        case WV_KIND_SYS:
                            c1589bu.dbX = 4;
                            break;
                        case WV_KIND_X5:
                            c1589bu.dbX = 2;
                            break;
                    }
                    c1589bu.ajK();
                    C32666bq c32666bq = new C32666bq();
                    c32666bq.mo53189gn(appBrandInitConfigWC.hgN.igT);
                    c32666bq.mo53190go(appBrandInitConfigWC.appId);
                    c32666bq.ddd = (long) appBrandInitConfigWC.axy;
                    c32666bq.ddy = C32667a.m53281gR(appBrandInitConfigWC.gVs + 1);
                    c32666bq.ddz = (long) (appBrandInitConfigWC.bQe + 1000);
                    c32666bq.cVR = (long) appBrandStatObject.scene;
                    c32666bq.mo53187dx(C1651a.eKO);
                    c32666bq.mo53188dy(C38094a.gQI);
                    c32666bq.mo53186dw(c32666bq.ddC - c32666bq.ddB);
                    c32666bq.ajK();
                }
            }
        } catch (Throwable th) {
            C4990ab.m7421w("MicroMsg.AppBrandUI", "reportProcessColdStart %s", th);
        }
        C4990ab.m7417i("MicroMsg.AppBrandUI", "load() config %s , stat %s", appBrandInitConfigWC, appBrandStatObject);
        if (appBrandInitConfigWC.mo32992xy()) {
            C29970o.m47417JV(1);
        }
        this.iIP.mo3964a(null, appBrandInitConfigWC, appBrandStatObject);
        initActivityOpenAnimation(getIntent());
        AppMethodBeat.m2505o(133130);
    }

    /* renamed from: K */
    private static Pair<AppBrandInitConfigWC, AppBrandStatObject> m65232K(Intent intent) {
        AppMethodBeat.m2504i(138698);
        Bundle extras = intent.getExtras();
        NullPointerException nullPointerException;
        if (extras == null) {
            nullPointerException = new NullPointerException("intent.getExtras() returns NULL");
            AppMethodBeat.m2505o(138698);
            throw nullPointerException;
        }
        extras.setClassLoader(AppBrandInitConfigWC.class.getClassLoader());
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) extras.getParcelable("key_appbrand_init_config");
        extras.setClassLoader(AppBrandStatObject.class.getClassLoader());
        AppBrandStatObject appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
        if (appBrandInitConfigWC == null) {
            nullPointerException = new NullPointerException("config is NULL");
            AppMethodBeat.m2505o(138698);
            throw nullPointerException;
        } else if (appBrandStatObject == null) {
            nullPointerException = new NullPointerException("stat is NULL");
            AppMethodBeat.m2505o(138698);
            throw nullPointerException;
        } else {
            Pair create = Pair.create(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.m2505o(138698);
            return create;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(133131);
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onConfigurationChanged newConfig: %s", Integer.valueOf(configuration.orientation));
        super.onConfigurationChanged(configuration);
        if (configuration.smallestScreenWidthDp != this.iIW.smallestScreenWidthDp) {
            C4990ab.m7417i("MicroMsg.AppBrandUI", "onConfigurationChanged by fold or unfold, last.smallestScreenWidthDp[%d], new.smallestScreenWidthDp[%d]", Integer.valueOf(this.iIW.smallestScreenWidthDp), Integer.valueOf(configuration.smallestScreenWidthDp));
            try {
                Pair K = AppBrandUI.m65232K(getIntent());
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) K.first;
                AppBrandStatObject appBrandStatObject = (AppBrandStatObject) K.second;
                appBrandInitConfigWC.hgK = C5046bo.anU();
                appBrandInitConfigWC.startTime = C5046bo.anU();
                Intent intent = getIntent();
                intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
                intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
                AppBrandProcessSuicideLogic.auG();
                recreate();
                AppMethodBeat.m2505o(133131);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandUI", e, "onConfigurationChanged by fold or unfold", new Object[0]);
                finish();
                AppMethodBeat.m2505o(133131);
                return;
            }
        }
        this.iIW = new Configuration(configuration);
        C11006a c11006a = this.iIN;
        if (configuration != null) {
            C4990ab.m7417i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", Integer.valueOf(configuration.orientation));
            c11006a.aQi();
        }
        this.iIP.onConfigurationChanged(configuration);
        C26835a t = C26835a.m42717t((Activity) this);
        if (t.hiH != null) {
            C5004al.m7441d(new C268402());
            t.hiH = null;
        }
        t.hiG = configuration.orientation;
        C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + t.hiG);
        t.mo44608a(t.mo44607G(t.hiG, C26835a.ayQ()));
        C6750i atv = this.iIP.atv();
        if (atv != null) {
            try {
                atv.asV().getCurrentPage().onConfigurationChanged(configuration);
                AppMethodBeat.m2505o(133131);
                return;
            } catch (NullPointerException e2) {
            }
        }
        AppMethodBeat.m2505o(133131);
    }

    public void onEnterAnimationComplete() {
        AppMethodBeat.m2504i(133132);
        C4990ab.m7416i("MicroMsg.AppBrandUI", "onEnterAnimationComplete");
        this.iIV = false;
        AppMethodBeat.m2505o(133132);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(133133);
        super.onWindowAttributesChanged(layoutParams);
        C11006a c11006a = this.iIN;
        if (layoutParams == null) {
            AppMethodBeat.m2505o(133133);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", Integer.valueOf(c11006a.jdf), Integer.valueOf(layoutParams.flags));
        if (layoutParams.flags != c11006a.jdf) {
            c11006a.jdf = layoutParams.flags;
            c11006a.aQi();
        }
        AppMethodBeat.m2505o(133133);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Object obj = 1;
        AppMethodBeat.m2504i(133134);
        Object obj2 = (intent == null || (intent.getFlags() & 268435456) <= 0) ? null : 1;
        if (intent == null || !C42677e.m75582c(intent.getComponent()).equals(C42677e.m75582c(getComponentName()))) {
            obj = null;
        }
        boolean B = AppBrandProcessProxyUI.m64712B(intent);
        boolean D = AppBrandLaunchProxyUI.m25692D(intent);
        boolean I = AppBrandEmbedUI.m30570I(intent);
        if (this.iIP.atv() != null) {
            String str = this.iIP.atv().mAppId;
            if (D || I) {
                C33183g.m54275a(str, C33184d.LAUNCH_MINI_PROGRAM);
            } else if ((obj2 == null || obj != null || B) && C33184d.HIDE == C33183g.m54286wV(str)) {
                C33183g.m54275a(str, C33184d.LAUNCH_NATIVE_PAGE);
            }
        }
        try {
            ((C41243o) this.iIP.atv()).atJ().getReporter().mo22127F(intent);
        } catch (Exception e) {
        }
        super.startActivityForResult(intent, i, bundle);
        AppMethodBeat.m2505o(133134);
    }

    public void onStart() {
        AppMethodBeat.m2504i(133135);
        super.onStart();
        C4990ab.m7416i("MicroMsg.AppBrandUI", "onStart");
        AppMethodBeat.m2505o(133135);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.m2504i(133136);
        super.onWindowFocusChanged(z);
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", Boolean.valueOf(z));
        if (!z) {
            this.iIX = false;
        }
        AppMethodBeat.m2503at(this, z);
        AppMethodBeat.m2505o(133136);
    }

    public void onResume() {
        AppMethodBeat.m2504i(133137);
        super.onResume();
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onResume %d", Integer.valueOf(hashCode()));
        if (VERSION.SDK_INT < 21) {
            try {
                this.mController.contentView.getViewTreeObserver().addOnPreDrawListener(new C385243());
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.AppBrandUI", "onResume addOnPreDrawListener failed, invoke onEnterAnimationComplete() directly");
                onEnterAnimationComplete();
            }
        }
        boolean z = this.iIO;
        this.iIO = false;
        if (this.iIS != null) {
            setIntent(this.iIS);
            mo34979J(this.iIS);
            this.iIS = null;
        } else {
            int i;
            if (!aLZ() || z) {
                i = 0;
            } else {
                i = 2;
            }
            C41243o c41243o = (C41243o) this.iIP.atv();
            if (c41243o != null) {
                C4990ab.m7417i("MicroMsg.AppBrandUI", "onResume, appId = %s, systemRecentsReason = %d", c41243o.mAppId, Integer.valueOf(i));
                c41243o.atI().hgP = i;
            }
        }
        this.iIP.onResume();
        C26835a t = C26835a.m42717t((Activity) this);
        t.mo44609a(t.hiE, null);
        ContentResolver contentResolver = C4996ah.getContext().getApplicationContext().getContentResolver();
        Uri uriFor = System.getUriFor("accelerometer_rotation");
        t.hiD = new C21131(new Handler());
        try {
            contentResolver.registerContentObserver(uriFor, false, t.hiD);
        } catch (Throwable th) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", th, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
        }
        try {
            if (this.iIP.atv() != null) {
                C26483d.m42196b(3, "AppBrandUI_" + this.iIP.atv().mAppId, hashCode());
            }
        } catch (Throwable th2) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandUI", th2, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
        if (C42641p.m75512k(this.iIP.atv())) {
            C29970o.m47417JV(1);
            C6998b.oTO.mo8107fu("ce_mg", this.iIP.atv().mAppId);
        }
        AppMethodBeat.m2505o(133137);
    }

    public void onPause() {
        AppMethodBeat.m2504i(133138);
        super.onPause();
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onPause %d", Integer.valueOf(hashCode()));
        this.iIV = true;
        C19553l c19553l = this.iIP;
        C45124d.m82930i("MicroMsg.AppBrandRuntimeContainer", "onPause tid = %d", Long.valueOf(Thread.currentThread().getId()));
        c19553l.gNy.runOnUiThread(new C313153());
        C26835a t = C26835a.m42717t((Activity) this);
        if (t.hiD != null) {
            try {
                C4996ah.getContext().getContentResolver().unregisterContentObserver(t.hiD);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", th, "unregisterContentObserver", new Object[0]);
            }
        }
        try {
            if (this.iIP.atv() != null) {
                C26483d.m42196b(4, "AppBrandUI_" + this.iIP.atv().mAppId, hashCode());
            }
        } catch (Throwable th2) {
            C4990ab.printErrStackTrace("MicroMsg.AppBrandUI", th2, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
        if (C42641p.m75512k(this.iIP.atv())) {
            C29970o.m47417JV(2);
            if (C6998b.oTO.mo8091TO("ce_mg")) {
                C6998b.oTO.mo8090TN("ce_mg");
            }
            byte[] TP = C6998b.oTO.mo8092TP("ce_mg");
            if (TP != null) {
                C44761d.qjp.mo8449o(540999682, TP);
            }
        }
        AppMethodBeat.m2505o(133138);
    }

    public boolean initNavigationSwipeBack() {
        return false;
    }

    public final void initActivityOpenAnimation(Intent intent) {
        AppBrandInitConfigWC appBrandInitConfigWC;
        AppBrandStatObject appBrandStatObject;
        AppMethodBeat.m2504i(133139);
        if (intent != null && intent.getComponent() != null && intent.getComponent().getClassName().endsWith(getLocalClassName())) {
            try {
                appBrandInitConfigWC = (AppBrandInitConfigWC) intent.getParcelableExtra("key_appbrand_init_config");
                try {
                    appBrandStatObject = (AppBrandStatObject) intent.getParcelableExtra("key_appbrand_stat_object");
                } catch (Exception e) {
                    appBrandStatObject = null;
                    try {
                        mo34978e(appBrandInitConfigWC, appBrandStatObject);
                        AppMethodBeat.m2505o(133139);
                        return;
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.AppBrandUI", "initAppBrandUIOpenAnimation, e = %s", e2);
                    }
                }
            } catch (Exception e3) {
                appBrandInitConfigWC = null;
                appBrandStatObject = null;
                mo34978e(appBrandInitConfigWC, appBrandStatObject);
                AppMethodBeat.m2505o(133139);
                return;
            }
            if (!(appBrandStatObject == null || appBrandInitConfigWC == null)) {
                mo34978e(appBrandInitConfigWC, appBrandStatObject);
            }
            AppMethodBeat.m2505o(133139);
            return;
        } else if (!(intent == null || intent.getComponent() == null || !C5274b.aqN(C5274b.m8051d(intent.getComponent())))) {
            C5274b.m8055hN(this);
            AppMethodBeat.m2505o(133139);
            return;
        }
        super.initActivityOpenAnimation(intent);
        AppMethodBeat.m2505o(133139);
    }

    public void initActivityCloseAnimation() {
        AppMethodBeat.m2504i(133140);
        ((C38565u) C37384e.m62985B(C38565u.class)).mo32999k(this);
        AppMethodBeat.m2505o(133140);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aMt() {
        AppMethodBeat.m2504i(133142);
        super.finish();
        AppMethodBeat.m2505o(133142);
    }

    public void finish() {
        AppMethodBeat.m2504i(133143);
        if (isFinishing() || this.uiu) {
            AppMethodBeat.m2505o(133143);
            return;
        }
        try {
            if (VERSION.SDK_INT >= 21) {
                super.finishAndRemoveTask();
            } else {
                super.finish();
            }
            initActivityCloseAnimation();
            AppMethodBeat.m2505o(133143);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandUI", "finish e = %s", e);
            getIntent().removeExtra("android.view.autofill.extra.RESTORE_SESSION_TOKEN");
            super.finishAndRemoveTask();
            AppMethodBeat.m2505o(133143);
        } catch (Throwable th) {
            C4990ab.m7413e("MicroMsg.AppBrandUI", "finish api27 fallback, thr = %s", th);
            AppMethodBeat.m2505o(133143);
        }
    }

    public boolean moveTaskToBack(boolean z) {
        AppMethodBeat.m2504i(133144);
        try {
            boolean moveTaskToBack = super.moveTaskToBack(z);
            initActivityCloseAnimation();
            AppMethodBeat.m2505o(133144);
            return moveTaskToBack;
        } catch (NullPointerException e) {
            finish();
            AppMethodBeat.m2505o(133144);
            return true;
        }
    }

    /* JADX WARNING: Missing block: B:49:?, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:50:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        int i = 133145;
        AppMethodBeat.m2504i(133145);
        super.onDestroy();
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onDestroy %d", Integer.valueOf(hashCode()));
        C19553l c19553l = this.iIP;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(c19553l.gOB);
        linkedList.addAll(c19553l.gOC.values());
        c19553l.atx();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C6750i c6750i = (C6750i) it.next();
            c6750i.gNT = false;
            c19553l.mo44514f(c6750i);
        }
        C45124d.m82929i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
        if (this.iIR != null) {
            try {
                C4996ah.getContext().unregisterReceiver(this.iIR.receiver);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = ".concat(String.valueOf(e)));
            }
        }
        if (this.iIQ != null) {
            try {
                C4996ah.getContext().unregisterReceiver(this.iIQ.gWT);
            } catch (Exception e2) {
                C4990ab.m7412e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "unregister screen off receiver e = ".concat(String.valueOf(e2)));
            }
        }
        C26835a t = C26835a.m42717t((Activity) this);
        int i2 = "release";
        C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", i2);
        synchronized (t) {
            try {
                if (t.hiA == null && t.hiB == null) {
                    i2 = "Every request is executed well";
                    C4990ab.m7416i("MicroMsg.AppBrandDeviceOrientationHandler", i2);
                } else {
                    C4990ab.m7417i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", t.hiA, t.hiB);
                    t.hiA = null;
                    t.hiB = null;
                    t.mFinished = true;
                    i2 = C26835a.hiz;
                    synchronized (i2) {
                        int indexOfValue = C26835a.hiz.indexOfValue(t);
                        if (indexOfValue >= 0) {
                            C26835a.hiz.removeAt(indexOfValue);
                        }
                    }
                }
            } catch (Throwable th) {
                while (true) {
                }
                i2 = 133145;
            } finally {
                AppMethodBeat.m2505o(
/*
Method generation error in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onDestroy():void, dex: classes6.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ff: INVOKE  (wrap: int
  ?: MERGE  (r6_1 int) = (r6_0 'i' int), (r2_14 'i2' int)) com.tencent.matrix.trace.core.AppMethodBeat.o(int):void type: STATIC in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onDestroy():void, dex: classes6.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:205)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:102)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:52)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:300)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:230)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r6_1 int) = (r6_0 'i' int), (r2_14 'i2' int) in method: com.tencent.mm.plugin.appbrand.ui.AppBrandUI.onDestroy():void, dex: classes6.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:688)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:658)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:340)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:213)
	... 32 more

*/

    public void onBackPressed() {
        AppMethodBeat.m2504i(133146);
        C4990ab.m7417i("MicroMsg.AppBrandUI", "onBackPressed %d, mEatOnBackPressed[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.iIV));
        if (this.iIV) {
            AppMethodBeat.m2505o(133146);
            return;
        }
        this.iIP.onBackPressed();
        AppMethodBeat.m2505o(133146);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.m2504i(133147);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        C11006a c11006a = this.iIN;
        if (c11006a.activity == null || c11006a.activity.getWindow() == null) {
            AppMethodBeat.m2505o(133147);
            return;
        }
        c11006a.activity.getWindow().setSoftInputMode(16);
        AppMethodBeat.m2505o(133147);
    }

    public final boolean noActionBar() {
        return true;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final boolean needShowIdcError() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(133148);
        Iterator it = this.iIP.gOB.iterator();
        while (it.hasNext()) {
            C19663n.m30461a(((C6750i) it.next()).mAppId, i, strArr, iArr);
        }
        C8870e ax = C8870e.m15839ax(this);
        C0990c c0990c = (C0990c) ax.bRD.get(i);
        ax.bRD.delete(i);
        if (c0990c != null) {
            ((C8871d) c0990c).mo20071l(iArr);
        }
        AppMethodBeat.m2505o(133148);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(133149);
        super.onActivityResult(i, i2, intent);
        C8870e.m15839ax(this).onActivityResult(i, i2, intent);
        if (i2 == 5) {
            C30379h.m48447a((Context) this, intent.getStringExtra("key_jsapi_pay_err_msg"), "", getString(C25738R.string.f8863hg), false, new C385234());
        }
        AppMethodBeat.m2505o(133149);
    }

    public final boolean aLZ() {
        boolean z = true;
        AppMethodBeat.m2504i(133150);
        if (this.iIY != null) {
            z = this.iIY.booleanValue();
            AppMethodBeat.m2505o(133150);
            return z;
        }
        ActivityInfo activityInfo;
        try {
            activityInfo = C4996ah.getContext().getPackageManager().getActivityInfo(getComponentName(), 128);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", e);
            activityInfo = null;
        }
        if (activityInfo == null) {
            AppMethodBeat.m2505o(133150);
            return true;
        }
        if (C4996ah.getPackageName().equals(activityInfo.taskAffinity)) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.iIY = valueOf;
        z = valueOf.booleanValue();
        AppMethodBeat.m2505o(133150);
        return z;
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        AppMethodBeat.m2504i(133151);
        if (aLZ()) {
            try {
                super.setTaskDescription(taskDescription);
                AppMethodBeat.m2505o(133151);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.AppBrandUI", e, "setTaskDescription ", new Object[0]);
                if (taskDescription != null) {
                    try {
                        super.setTaskDescription(new TaskDescription(taskDescription.getLabel(), null, taskDescription.getPrimaryColor()));
                        AppMethodBeat.m2505o(133151);
                        return;
                    } catch (Exception e2) {
                    }
                }
            }
        }
        AppMethodBeat.m2505o(133151);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public void mo34978e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(133141);
        appBrandInitConfigWC.bQn = appBrandStatObject;
        ((C38565u) C37384e.m62985B(C38565u.class)).mo32996a((Activity) this, (AppBrandInitConfig) appBrandInitConfigWC);
        AppMethodBeat.m2505o(133141);
    }
}

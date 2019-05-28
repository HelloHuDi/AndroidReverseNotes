package com.tencent.mm.plugin.appbrand.ui;

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
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.bq;
import com.tencent.mm.g.b.a.bt;
import com.tencent.mm.g.b.a.bu;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.widget.input.am;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.xweb.WebView;
import java.util.Iterator;
import java.util.LinkedList;

@a(1)
public class AppBrandUI extends MMActivity implements android.support.v4.app.a.a, s, t {
    private i gOD = new i() {
        public final Activity getContext() {
            return AppBrandUI.this;
        }

        public final FrameLayout aLY() {
            AppMethodBeat.i(138139);
            FrameLayout frameLayout = (FrameLayout) AppBrandUI.this.mController.contentView;
            AppMethodBeat.o(138139);
            return frameLayout;
        }

        public final void a(i.a aVar) {
            AppMethodBeat.i(138141);
            h hVar = h.iJc;
            h.a(AppBrandUI.this, aVar);
            AppMethodBeat.o(138141);
        }

        public final boolean aLZ() {
            AppMethodBeat.i(138142);
            boolean aLZ = AppBrandUI.this.aLZ();
            AppMethodBeat.o(138142);
            return aLZ;
        }

        public final void finish() {
            AppMethodBeat.i(138140);
            AppBrandUI.this.finish();
            AppMethodBeat.o(138140);
        }
    };
    private final com.tencent.mm.plugin.appbrand.widget.input.a iIN = new com.tencent.mm.plugin.appbrand.widget.input.a(this);
    private boolean iIO = false;
    l iIP;
    private m iIQ;
    private e iIR;
    private Intent iIS = null;
    private boolean iIT = false;
    private boolean iIU = false;
    private boolean iIV = false;
    private Configuration iIW = null;
    public boolean iIX = false;
    private Boolean iIY;

    public AppBrandUI() {
        AppMethodBeat.i(133126);
        AppMethodBeat.o(133126);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133127);
        b.auF();
        this.iIT = !b.auE();
        try {
            super.onCreate(bundle);
            if (getIntent() == null) {
                ab.e("MicroMsg.AppBrandUI", "onCreate %d, null intent", Integer.valueOf(hashCode()));
                finish();
                AppMethodBeat.o(133127);
                return;
            }
            ab.i("MicroMsg.AppBrandUI", "onCreate %d, intent.flags = %d", Integer.valueOf(hashCode()), Integer.valueOf(getIntent().getFlags()));
            this.iIW = new Configuration(getResources().getConfiguration());
            com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.iIN;
            FrameLayout aLY = this.gOD.aLY();
            if (!(aVar.activity == null || aVar.activity.getWindow() == null || aLY == null || aLY.getParent() == null || !(aLY.getParent() instanceof ViewGroup))) {
                aVar.jde = true;
                ViewGroup viewGroup = (ViewGroup) aLY.getParent();
                viewGroup.removeView(aLY);
                n nVar = new n(aVar.activity, aLY);
                viewGroup.addView(nVar, new LayoutParams(-1, -1));
                if (VERSION.SDK_INT < 20) {
                    Activity activity = aVar.activity;
                    if (c.dqy() && activity.getResources().getConfiguration().orientation != 2) {
                        activity.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        activity.getWindow().addFlags(2048);
                        viewGroup.setPadding(0, ae.getStatusBarHeight(activity), 0, 0);
                    }
                    aVar.a(nVar);
                }
                if (com.tencent.mm.plugin.appbrand.widget.input.a.jdd && com.tencent.mm.plugin.appbrand.widget.input.a.dp(aVar.activity)) {
                    am.a(viewGroup, new am.a() {
                        public final void aQk() {
                            AppMethodBeat.i(123567);
                            ab.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onRootViewResized");
                            a.a(a.this);
                            AppMethodBeat.o(123567);
                        }
                    });
                }
            }
            this.iIP = new l(this.gOD);
            this.iIQ = new m(this, this.iIP) {
                public final void awE() {
                    AppMethodBeat.i(133117);
                    super.awE();
                    AppBrandUI.this.iIO = true;
                    AppMethodBeat.o(133117);
                }
            };
            m mVar = this.iIQ;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            try {
                ah.getContext().registerReceiver(mVar.gWT, intentFilter);
            } catch (Exception e) {
                ab.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "register screen off receiver e = ".concat(String.valueOf(e)));
            }
            this.iIR = new e(this) {
                public final void awC() {
                    AppMethodBeat.i(133118);
                    com.tencent.mm.plugin.appbrand.i atv = AppBrandUI.this.iIP.atv();
                    if (atv == null) {
                        AppMethodBeat.o(133118);
                        return;
                    }
                    g.a(atv.mAppId, d.HOME_PRESSED);
                    AppMethodBeat.o(133118);
                }

                public final void awD() {
                    AppMethodBeat.i(133119);
                    com.tencent.mm.plugin.appbrand.i atv = AppBrandUI.this.iIP.atv();
                    if (atv == null) {
                        AppMethodBeat.o(133119);
                        return;
                    }
                    g.a(atv.mAppId, d.RECENT_APPS_PRESSED);
                    AppMethodBeat.o(133119);
                }
            };
            e eVar = this.iIR;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            try {
                ah.getContext().registerReceiver(eVar.receiver, intentFilter);
            } catch (Exception e2) {
                ab.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "register screen off receiver e = ".concat(String.valueOf(e2)));
            }
            ae.hD(this);
            com.tencent.mm.plugin.appbrand.config.a.a t = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this);
            ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "init");
            synchronized (t) {
                try {
                    t.mFinished = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(133127);
                }
            }
            this.iIS = getIntent();
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandUI", th, "%s.onCreate", getLocalClassName());
            finish();
            AppMethodBeat.o(133127);
        }
    }

    private void aMs() {
        AppMethodBeat.i(133128);
        ab.i("MicroMsg.AppBrandUI", "%s.closeIfNoActiveRuntimes %d,", getLocalClassName(), Integer.valueOf(this.iIP == null ? -1 : this.iIP.atw()));
        if (this.iIP instanceof l) {
            this.iIP.atC();
            AppMethodBeat.o(133128);
            return;
        }
        if (r0 <= 0) {
            finish();
        }
        AppMethodBeat.o(133128);
    }

    public void onNewIntent(Intent intent) {
        int i = 1;
        AppMethodBeat.i(133129);
        ab.i("MicroMsg.AppBrandUI", "onNewIntent %s, %d", intent, Integer.valueOf(hashCode()));
        try {
            super.onNewIntent(intent);
            this.iIX = true;
            if (intent != null && intent.getBooleanExtra("key_appbrand_bring_ui_to_front", false)) {
                aMs();
                AppMethodBeat.o(133129);
            } else if (intent == null) {
                AppMethodBeat.o(133129);
            } else {
                if (intent.getParcelableExtra("key_appbrand_init_config") == null) {
                    i = 0;
                }
                if (i == 0) {
                    com.tencent.mm.plugin.appbrand.i atv = this.iIP == null ? null : this.iIP.atv();
                    if (atv == null || !g.wS(atv.mAppId)) {
                        AppMethodBeat.o(133129);
                        return;
                    } else {
                        AppMethodBeat.o(133129);
                        return;
                    }
                }
                this.iIS = intent;
                AppMethodBeat.o(133129);
            }
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandUI", th, "%s.onNewIntent", getLocalClassName());
            aMs();
            AppMethodBeat.o(133129);
        }
    }

    public final void aBS() {
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018 A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void J(Intent intent) {
        AppBrandStatObject appBrandStatObject;
        AppBrandInitConfigWC appBrandInitConfigWC;
        Exception e;
        AppMethodBeat.i(133130);
        try {
            Pair K = K(intent);
            AppBrandInitConfigWC appBrandInitConfigWC2 = (AppBrandInitConfigWC) K.first;
            try {
                appBrandStatObject = (AppBrandStatObject) K.second;
                appBrandInitConfigWC = appBrandInitConfigWC2;
            } catch (Exception e2) {
                e = e2;
                appBrandInitConfigWC = appBrandInitConfigWC2;
                ab.e("MicroMsg.AppBrandUI", "getParcelable: %s", e);
                appBrandStatObject = null;
                if (appBrandInitConfigWC != null) {
                }
                finish();
                AppMethodBeat.o(133130);
                return;
            }
        } catch (Exception e3) {
            e = e3;
            appBrandInitConfigWC = null;
            ab.e("MicroMsg.AppBrandUI", "getParcelable: %s", e);
            appBrandStatObject = null;
            if (appBrandInitConfigWC != null) {
            }
            finish();
            AppMethodBeat.o(133130);
            return;
        }
        if (appBrandInitConfigWC != null || appBrandStatObject == null || appBrandInitConfigWC.hgF == null) {
            if (this.iIP == null || this.iIP.atv() == null) {
                finish();
            }
            AppMethodBeat.o(133130);
            return;
        }
        if ((intent.getFlags() & 1048576) > 0) {
            appBrandInitConfigWC.startTime = bo.anU();
            appBrandInitConfigWC.hgP = 1;
        } else {
            appBrandInitConfigWC.hgP = 0;
        }
        try {
            if (this.iIT && !this.iIU) {
                if (appBrandInitConfigWC.hgN != null) {
                    this.iIU = true;
                    bt btVar = new bt();
                    btVar.gt(appBrandInitConfigWC.hgN.igT);
                    btVar.gu(appBrandInitConfigWC.appId);
                    btVar.ddd = (long) appBrandInitConfigWC.axy;
                    btVar.ddS = bt.a.gU(appBrandInitConfigWC.gVs + 1);
                    btVar.ddz = (long) (appBrandInitConfigWC.bQe + 1000);
                    btVar.cVR = (long) appBrandStatObject.scene;
                    btVar.dF(appBrandInitConfigWC.hgK);
                    btVar.dG(com.tencent.mm.kernel.a.a.eKO);
                    btVar.dE(btVar.ddC - btVar.ddB);
                    btVar.ddT = (long) appBrandInitConfigWC.hgP;
                    btVar.ajK();
                    bu buVar = new bu();
                    buVar.gv(appBrandInitConfigWC.hgN.igT);
                    buVar.gw(appBrandInitConfigWC.appId);
                    buVar.ddd = (long) appBrandInitConfigWC.axy;
                    buVar.ddY = bu.a.gV(appBrandInitConfigWC.gVs + 1);
                    buVar.ddz = (long) (appBrandInitConfigWC.bQe + 1000);
                    buVar.cVR = (long) appBrandStatObject.scene;
                    buVar.dI(com.tencent.mm.plugin.appbrand.a.a.gQJ);
                    buVar.dJ(com.tencent.mm.plugin.appbrand.a.a.gQK);
                    buVar.dH(buVar.ddC - buVar.ddB);
                    switch (WebView.getCurWebType()) {
                        case WV_KIND_CW:
                            buVar.dbX = 3;
                            break;
                        case WV_KIND_SYS:
                            buVar.dbX = 4;
                            break;
                        case WV_KIND_X5:
                            buVar.dbX = 2;
                            break;
                    }
                    buVar.ajK();
                    bq bqVar = new bq();
                    bqVar.gn(appBrandInitConfigWC.hgN.igT);
                    bqVar.go(appBrandInitConfigWC.appId);
                    bqVar.ddd = (long) appBrandInitConfigWC.axy;
                    bqVar.ddy = bq.a.gR(appBrandInitConfigWC.gVs + 1);
                    bqVar.ddz = (long) (appBrandInitConfigWC.bQe + 1000);
                    bqVar.cVR = (long) appBrandStatObject.scene;
                    bqVar.dx(com.tencent.mm.kernel.a.a.eKO);
                    bqVar.dy(com.tencent.mm.plugin.appbrand.a.a.gQI);
                    bqVar.dw(bqVar.ddC - bqVar.ddB);
                    bqVar.ajK();
                }
            }
        } catch (Throwable th) {
            ab.w("MicroMsg.AppBrandUI", "reportProcessColdStart %s", th);
        }
        ab.i("MicroMsg.AppBrandUI", "load() config %s , stat %s", appBrandInitConfigWC, appBrandStatObject);
        if (appBrandInitConfigWC.xy()) {
            o.JV(1);
        }
        this.iIP.a(null, appBrandInitConfigWC, appBrandStatObject);
        initActivityOpenAnimation(getIntent());
        AppMethodBeat.o(133130);
    }

    private static Pair<AppBrandInitConfigWC, AppBrandStatObject> K(Intent intent) {
        AppMethodBeat.i(138698);
        Bundle extras = intent.getExtras();
        NullPointerException nullPointerException;
        if (extras == null) {
            nullPointerException = new NullPointerException("intent.getExtras() returns NULL");
            AppMethodBeat.o(138698);
            throw nullPointerException;
        }
        extras.setClassLoader(AppBrandInitConfigWC.class.getClassLoader());
        AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) extras.getParcelable("key_appbrand_init_config");
        extras.setClassLoader(AppBrandStatObject.class.getClassLoader());
        AppBrandStatObject appBrandStatObject = (AppBrandStatObject) extras.getParcelable("key_appbrand_stat_object");
        if (appBrandInitConfigWC == null) {
            nullPointerException = new NullPointerException("config is NULL");
            AppMethodBeat.o(138698);
            throw nullPointerException;
        } else if (appBrandStatObject == null) {
            nullPointerException = new NullPointerException("stat is NULL");
            AppMethodBeat.o(138698);
            throw nullPointerException;
        } else {
            Pair create = Pair.create(appBrandInitConfigWC, appBrandStatObject);
            AppMethodBeat.o(138698);
            return create;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(133131);
        ab.i("MicroMsg.AppBrandUI", "onConfigurationChanged newConfig: %s", Integer.valueOf(configuration.orientation));
        super.onConfigurationChanged(configuration);
        if (configuration.smallestScreenWidthDp != this.iIW.smallestScreenWidthDp) {
            ab.i("MicroMsg.AppBrandUI", "onConfigurationChanged by fold or unfold, last.smallestScreenWidthDp[%d], new.smallestScreenWidthDp[%d]", Integer.valueOf(this.iIW.smallestScreenWidthDp), Integer.valueOf(configuration.smallestScreenWidthDp));
            try {
                Pair K = K(getIntent());
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) K.first;
                AppBrandStatObject appBrandStatObject = (AppBrandStatObject) K.second;
                appBrandInitConfigWC.hgK = bo.anU();
                appBrandInitConfigWC.startTime = bo.anU();
                Intent intent = getIntent();
                intent.putExtra("key_appbrand_init_config", appBrandInitConfigWC);
                intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
                AppBrandProcessSuicideLogic.auG();
                recreate();
                AppMethodBeat.o(133131);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandUI", e, "onConfigurationChanged by fold or unfold", new Object[0]);
                finish();
                AppMethodBeat.o(133131);
                return;
            }
        }
        this.iIW = new Configuration(configuration);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.iIN;
        if (configuration != null) {
            ab.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", Integer.valueOf(configuration.orientation));
            aVar.aQi();
        }
        this.iIP.onConfigurationChanged(configuration);
        com.tencent.mm.plugin.appbrand.config.a.a t = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this);
        if (t.hiH != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(86933);
                    ab.i("MicroMsg.AppBrandDeviceOrientationRetrier", "hy: stop count fail");
                    b.a(b.this);
                    AppMethodBeat.o(86933);
                }
            });
            t.hiH = null;
        }
        t.hiG = configuration.orientation;
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "onConfigurationChanged  " + t.hiG);
        t.a(t.G(t.hiG, com.tencent.mm.plugin.appbrand.config.a.a.ayQ()));
        com.tencent.mm.plugin.appbrand.i atv = this.iIP.atv();
        if (atv != null) {
            try {
                atv.asV().getCurrentPage().onConfigurationChanged(configuration);
                AppMethodBeat.o(133131);
                return;
            } catch (NullPointerException e2) {
            }
        }
        AppMethodBeat.o(133131);
    }

    public void onEnterAnimationComplete() {
        AppMethodBeat.i(133132);
        ab.i("MicroMsg.AppBrandUI", "onEnterAnimationComplete");
        this.iIV = false;
        AppMethodBeat.o(133132);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        AppMethodBeat.i(133133);
        super.onWindowAttributesChanged(layoutParams);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.iIN;
        if (layoutParams == null) {
            AppMethodBeat.o(133133);
            return;
        }
        ab.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", Integer.valueOf(aVar.jdf), Integer.valueOf(layoutParams.flags));
        if (layoutParams.flags != aVar.jdf) {
            aVar.jdf = layoutParams.flags;
            aVar.aQi();
        }
        AppMethodBeat.o(133133);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        Object obj = 1;
        AppMethodBeat.i(133134);
        Object obj2 = (intent == null || (intent.getFlags() & 268435456) <= 0) ? null : 1;
        if (intent == null || !com.tencent.mm.plugin.appbrand.s.e.c(intent.getComponent()).equals(com.tencent.mm.plugin.appbrand.s.e.c(getComponentName()))) {
            obj = null;
        }
        boolean B = AppBrandProcessProxyUI.B(intent);
        boolean D = AppBrandLaunchProxyUI.D(intent);
        boolean I = AppBrandEmbedUI.I(intent);
        if (this.iIP.atv() != null) {
            String str = this.iIP.atv().mAppId;
            if (D || I) {
                g.a(str, d.LAUNCH_MINI_PROGRAM);
            } else if ((obj2 == null || obj != null || B) && d.HIDE == g.wV(str)) {
                g.a(str, d.LAUNCH_NATIVE_PAGE);
            }
        }
        try {
            ((com.tencent.mm.plugin.appbrand.o) this.iIP.atv()).atJ().getReporter().F(intent);
        } catch (Exception e) {
        }
        super.startActivityForResult(intent, i, bundle);
        AppMethodBeat.o(133134);
    }

    public void onStart() {
        AppMethodBeat.i(133135);
        super.onStart();
        ab.i("MicroMsg.AppBrandUI", "onStart");
        AppMethodBeat.o(133135);
    }

    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(133136);
        super.onWindowFocusChanged(z);
        ab.i("MicroMsg.AppBrandUI", "onWindowFocusChanged %b", Boolean.valueOf(z));
        if (!z) {
            this.iIX = false;
        }
        AppMethodBeat.at(this, z);
        AppMethodBeat.o(133136);
    }

    public void onResume() {
        AppMethodBeat.i(133137);
        super.onResume();
        ab.i("MicroMsg.AppBrandUI", "onResume %d", Integer.valueOf(hashCode()));
        if (VERSION.SDK_INT < 21) {
            try {
                this.mController.contentView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        AppMethodBeat.i(133120);
                        try {
                            AppBrandUI.this.mController.contentView.getViewTreeObserver().removeOnPreDrawListener(this);
                        } catch (Exception e) {
                            ab.w("MicroMsg.AppBrandUI", "first onPreDraw after onResume, remove listener failed, e=%s", e);
                        }
                        AppBrandUI.this.onEnterAnimationComplete();
                        AppMethodBeat.o(133120);
                        return true;
                    }
                });
            } catch (Exception e) {
                ab.w("MicroMsg.AppBrandUI", "onResume addOnPreDrawListener failed, invoke onEnterAnimationComplete() directly");
                onEnterAnimationComplete();
            }
        }
        boolean z = this.iIO;
        this.iIO = false;
        if (this.iIS != null) {
            setIntent(this.iIS);
            J(this.iIS);
            this.iIS = null;
        } else {
            int i;
            if (!aLZ() || z) {
                i = 0;
            } else {
                i = 2;
            }
            com.tencent.mm.plugin.appbrand.o oVar = (com.tencent.mm.plugin.appbrand.o) this.iIP.atv();
            if (oVar != null) {
                ab.i("MicroMsg.AppBrandUI", "onResume, appId = %s, systemRecentsReason = %d", oVar.mAppId, Integer.valueOf(i));
                oVar.atI().hgP = i;
            }
        }
        this.iIP.onResume();
        com.tencent.mm.plugin.appbrand.config.a.a t = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this);
        t.a(t.hiE, null);
        ContentResolver contentResolver = ah.getContext().getApplicationContext().getContentResolver();
        Uri uriFor = System.getUriFor("accelerometer_rotation");
        t.hiD = new com.tencent.mm.plugin.appbrand.config.a.a.AnonymousClass1(new Handler());
        try {
            contentResolver.registerContentObserver(uriFor, false, t.hiD);
        } catch (Throwable th) {
            ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", th, "registerContentObserver [Settings.System.ACCELEROMETER_ROTATION] ", new Object[0]);
        }
        try {
            if (this.iIP.atv() != null) {
                com.tencent.mm.modelstat.d.b(3, "AppBrandUI_" + this.iIP.atv().mAppId, hashCode());
            }
        } catch (Throwable th2) {
            ab.printErrStackTrace("MicroMsg.AppBrandUI", th2, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
        if (p.k(this.iIP.atv())) {
            o.JV(1);
            com.tencent.mm.plugin.normsg.a.b.oTO.fu("ce_mg", this.iIP.atv().mAppId);
        }
        AppMethodBeat.o(133137);
    }

    public void onPause() {
        AppMethodBeat.i(133138);
        super.onPause();
        ab.i("MicroMsg.AppBrandUI", "onPause %d", Integer.valueOf(hashCode()));
        this.iIV = true;
        l lVar = this.iIP;
        com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntimeContainer", "onPause tid = %d", Long.valueOf(Thread.currentThread().getId()));
        lVar.gNy.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(86713);
                i atv = k.this.atv();
                if (atv != null) {
                    atv.atk();
                }
                AppMethodBeat.o(86713);
            }
        });
        com.tencent.mm.plugin.appbrand.config.a.a t = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this);
        if (t.hiD != null) {
            try {
                ah.getContext().getContentResolver().unregisterContentObserver(t.hiD);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.AppBrandDeviceOrientationHandler", th, "unregisterContentObserver", new Object[0]);
            }
        }
        try {
            if (this.iIP.atv() != null) {
                com.tencent.mm.modelstat.d.b(4, "AppBrandUI_" + this.iIP.atv().mAppId, hashCode());
            }
        } catch (Throwable th2) {
            ab.printErrStackTrace("MicroMsg.AppBrandUI", th2, "[oneliang]AppBrandUI click flow exception.", new Object[0]);
        }
        if (p.k(this.iIP.atv())) {
            o.JV(2);
            if (com.tencent.mm.plugin.normsg.a.b.oTO.TO("ce_mg")) {
                com.tencent.mm.plugin.normsg.a.b.oTO.TN("ce_mg");
            }
            byte[] TP = com.tencent.mm.plugin.normsg.a.b.oTO.TP("ce_mg");
            if (TP != null) {
                com.tencent.mm.plugin.secinforeport.a.d.qjp.o(540999682, TP);
            }
        }
        AppMethodBeat.o(133138);
    }

    public boolean initNavigationSwipeBack() {
        return false;
    }

    public final void initActivityOpenAnimation(Intent intent) {
        AppBrandInitConfigWC appBrandInitConfigWC;
        AppBrandStatObject appBrandStatObject;
        AppMethodBeat.i(133139);
        if (intent != null && intent.getComponent() != null && intent.getComponent().getClassName().endsWith(getLocalClassName())) {
            try {
                appBrandInitConfigWC = (AppBrandInitConfigWC) intent.getParcelableExtra("key_appbrand_init_config");
                try {
                    appBrandStatObject = (AppBrandStatObject) intent.getParcelableExtra("key_appbrand_stat_object");
                } catch (Exception e) {
                    appBrandStatObject = null;
                    try {
                        e(appBrandInitConfigWC, appBrandStatObject);
                        AppMethodBeat.o(133139);
                        return;
                    } catch (Exception e2) {
                        ab.e("MicroMsg.AppBrandUI", "initAppBrandUIOpenAnimation, e = %s", e2);
                    }
                }
            } catch (Exception e3) {
                appBrandInitConfigWC = null;
                appBrandStatObject = null;
                e(appBrandInitConfigWC, appBrandStatObject);
                AppMethodBeat.o(133139);
                return;
            }
            if (!(appBrandStatObject == null || appBrandInitConfigWC == null)) {
                e(appBrandInitConfigWC, appBrandStatObject);
            }
            AppMethodBeat.o(133139);
            return;
        } else if (!(intent == null || intent.getComponent() == null || !com.tencent.mm.ui.base.b.aqN(com.tencent.mm.ui.base.b.d(intent.getComponent())))) {
            com.tencent.mm.ui.base.b.hN(this);
            AppMethodBeat.o(133139);
            return;
        }
        super.initActivityOpenAnimation(intent);
        AppMethodBeat.o(133139);
    }

    public void initActivityCloseAnimation() {
        AppMethodBeat.i(133140);
        ((u) com.tencent.luggage.a.e.B(u.class)).k(this);
        AppMethodBeat.o(133140);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aMt() {
        AppMethodBeat.i(133142);
        super.finish();
        AppMethodBeat.o(133142);
    }

    public void finish() {
        AppMethodBeat.i(133143);
        if (isFinishing() || this.uiu) {
            AppMethodBeat.o(133143);
            return;
        }
        try {
            if (VERSION.SDK_INT >= 21) {
                super.finishAndRemoveTask();
            } else {
                super.finish();
            }
            initActivityCloseAnimation();
            AppMethodBeat.o(133143);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandUI", "finish e = %s", e);
            getIntent().removeExtra("android.view.autofill.extra.RESTORE_SESSION_TOKEN");
            super.finishAndRemoveTask();
            AppMethodBeat.o(133143);
        } catch (Throwable th) {
            ab.e("MicroMsg.AppBrandUI", "finish api27 fallback, thr = %s", th);
            AppMethodBeat.o(133143);
        }
    }

    public boolean moveTaskToBack(boolean z) {
        AppMethodBeat.i(133144);
        try {
            boolean moveTaskToBack = super.moveTaskToBack(z);
            initActivityCloseAnimation();
            AppMethodBeat.o(133144);
            return moveTaskToBack;
        } catch (NullPointerException e) {
            finish();
            AppMethodBeat.o(133144);
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
        AppMethodBeat.i(133145);
        super.onDestroy();
        ab.i("MicroMsg.AppBrandUI", "onDestroy %d", Integer.valueOf(hashCode()));
        l lVar = this.iIP;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(lVar.gOB);
        linkedList.addAll(lVar.gOC.values());
        lVar.atx();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.appbrand.i iVar = (com.tencent.mm.plugin.appbrand.i) it.next();
            iVar.gNT = false;
            lVar.f(iVar);
        }
        com.tencent.luggage.g.d.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
        if (this.iIR != null) {
            try {
                ah.getContext().unregisterReceiver(this.iIR.receiver);
            } catch (Exception e) {
                ab.e("MicroMsg.BaseAppBrandUIHomePressReceiver", "unregister screen off receiver e = ".concat(String.valueOf(e)));
            }
        }
        if (this.iIQ != null) {
            try {
                ah.getContext().unregisterReceiver(this.iIQ.gWT);
            } catch (Exception e2) {
                ab.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "unregister screen off receiver e = ".concat(String.valueOf(e2)));
            }
        }
        com.tencent.mm.plugin.appbrand.config.a.a t = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this);
        int i2 = "release";
        ab.i("MicroMsg.AppBrandDeviceOrientationHandler", i2);
        synchronized (t) {
            try {
                if (t.hiA == null && t.hiB == null) {
                    i2 = "Every request is executed well";
                    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", i2);
                } else {
                    ab.i("MicroMsg.AppBrandDeviceOrientationHandler", "Still has request not executed current[%s] pending[%s]", t.hiA, t.hiB);
                    t.hiA = null;
                    t.hiB = null;
                    t.mFinished = true;
                    i2 = com.tencent.mm.plugin.appbrand.config.a.a.hiz;
                    synchronized (i2) {
                        int indexOfValue = com.tencent.mm.plugin.appbrand.config.a.a.hiz.indexOfValue(t);
                        if (indexOfValue >= 0) {
                            com.tencent.mm.plugin.appbrand.config.a.a.hiz.removeAt(indexOfValue);
                        }
                    }
                }
            } catch (Throwable th) {
                while (true) {
                }
                i2 = 133145;
            } finally {
                AppMethodBeat.o(
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
        AppMethodBeat.i(133146);
        ab.i("MicroMsg.AppBrandUI", "onBackPressed %d, mEatOnBackPressed[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.iIV));
        if (this.iIV) {
            AppMethodBeat.o(133146);
            return;
        }
        this.iIP.onBackPressed();
        AppMethodBeat.o(133146);
    }

    public final void onCreateBeforeSetContentView() {
        AppMethodBeat.i(133147);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
        com.tencent.mm.plugin.appbrand.widget.input.a aVar = this.iIN;
        if (aVar.activity == null || aVar.activity.getWindow() == null) {
            AppMethodBeat.o(133147);
            return;
        }
        aVar.activity.getWindow().setSoftInputMode(16);
        AppMethodBeat.o(133147);
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
        AppMethodBeat.i(133148);
        Iterator it = this.iIP.gOB.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.appbrand.permission.n.a(((com.tencent.mm.plugin.appbrand.i) it.next()).mAppId, i, strArr, iArr);
        }
        com.tencent.luggage.g.e ax = com.tencent.luggage.g.e.ax(this);
        com.tencent.luggage.g.e.c cVar = (com.tencent.luggage.g.e.c) ax.bRD.get(i);
        ax.bRD.delete(i);
        if (cVar != null) {
            ((com.tencent.luggage.g.e.d) cVar).l(iArr);
        }
        AppMethodBeat.o(133148);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(133149);
        super.onActivityResult(i, i2, intent);
        com.tencent.luggage.g.e.ax(this).onActivityResult(i, i2, intent);
        if (i2 == 5) {
            h.a((Context) this, intent.getStringExtra("key_jsapi_pay_err_msg"), "", getString(R.string.hg), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        AppMethodBeat.o(133149);
    }

    public final boolean aLZ() {
        boolean z = true;
        AppMethodBeat.i(133150);
        if (this.iIY != null) {
            z = this.iIY.booleanValue();
            AppMethodBeat.o(133150);
            return z;
        }
        ActivityInfo activityInfo;
        try {
            activityInfo = ah.getContext().getPackageManager().getActivityInfo(getComponentName(), 128);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandUI", "runInStandaloneTask, resolve info e = %s", e);
            activityInfo = null;
        }
        if (activityInfo == null) {
            AppMethodBeat.o(133150);
            return true;
        }
        if (ah.getPackageName().equals(activityInfo.taskAffinity)) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.iIY = valueOf;
        z = valueOf.booleanValue();
        AppMethodBeat.o(133150);
        return z;
    }

    public void setTaskDescription(TaskDescription taskDescription) {
        AppMethodBeat.i(133151);
        if (aLZ()) {
            try {
                super.setTaskDescription(taskDescription);
                AppMethodBeat.o(133151);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.AppBrandUI", e, "setTaskDescription ", new Object[0]);
                if (taskDescription != null) {
                    try {
                        super.setTaskDescription(new TaskDescription(taskDescription.getLabel(), null, taskDescription.getPrimaryColor()));
                        AppMethodBeat.o(133151);
                        return;
                    } catch (Exception e2) {
                    }
                }
            }
        }
        AppMethodBeat.o(133151);
    }

    /* Access modifiers changed, original: protected */
    public void e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(133141);
        appBrandInitConfigWC.bQn = appBrandStatObject;
        ((u) com.tencent.luggage.a.e.B(u.class)).a((Activity) this, (AppBrandInitConfig) appBrandInitConfigWC);
        AppMethodBeat.o(133141);
    }
}

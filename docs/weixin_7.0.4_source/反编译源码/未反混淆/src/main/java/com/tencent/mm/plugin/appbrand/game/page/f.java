package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.luggage.g.h;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ci.g;
import com.tencent.mm.plugin.appbrand.game.d.c;
import com.tencent.mm.plugin.appbrand.game.d.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.ak;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.Collections;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public final class f extends w {
    public static final /* synthetic */ boolean $assertionsDisabled = (!f.class.desiredAssertionStatus());
    private boolean apg = true;
    WAGamePageViewContainerLayout hsL;
    public b hsM;
    private ImageView hsN;
    private Bitmap hsO;
    private boolean hsP = false;
    private boolean hsQ = false;
    private ac hsR;
    private b hsS;
    private Bitmap hsT = null;
    private final Object hsU = new Object();
    private String hsV;
    private String mUrl;

    class a extends com.tencent.magicbrush.MBRuntime.a {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void onFirstFrameRendered() {
            AppMethodBeat.i(130246);
            ab.i("AppBrandGame.WAGamePageView", "MagicBrush.onFirstFrameRendered");
            f.this.onReady();
            AppMethodBeat.o(130246);
        }
    }

    static {
        AppMethodBeat.i(130274);
        AppMethodBeat.o(130274);
    }

    f(Context context, i iVar) {
        AppMethodBeat.i(130247);
        long yz = bo.yz();
        this.irO = iVar.asV().getDecorWidgetFactory();
        super.a(context, iVar);
        ab.i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView cost [%d]ms", Long.valueOf(bo.az(yz)));
        AppMethodBeat.o(130247);
    }

    public final void initView() {
        AppMethodBeat.i(130248);
        ab.i("AppBrandGame.WAGamePageView", "new Rendder GameView");
        initActionBar();
        this.hsL = new WAGamePageViewContainerLayout(this.mContext);
        aAZ();
        this.hsS = new b(this.mContext);
        this.hsL.addView(this.hsS, new LayoutParams(-1, -1));
        this.hsR = new c(this.hsS);
        this.hsR.setFullscreenImpl(aJy());
        this.hsR.a(new ak() {
            public final void a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
                AppMethodBeat.i(138124);
                if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null) {
                    f.this.hsL.addView(appBrandPageFullScreenView, new ViewGroup.LayoutParams(-1, -1));
                }
                AppMethodBeat.o(138124);
            }
        });
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.rightMargin = com.tencent.mm.bz.a.am(this.mContext, R.dimen.ra);
        layoutParams.topMargin = com.tencent.mm.bz.a.am(this.mContext, R.dimen.rb);
        this.hsL.addView(this.isF, layoutParams);
        boolean z = com.tencent.mm.sdk.platformtools.f.DEBUG || getRuntime().atH().bQp;
        boolean z2 = getRuntime().atH().bQp;
        if (z || z2) {
            d aAI = d.aAI();
            MBRuntime mBRuntime = ((com.tencent.mm.plugin.appbrand.game.b) atK()).getMBRuntime();
            WAGamePageViewContainerLayout wAGamePageViewContainerLayout = this.hsL;
            aAI.bSv = mBRuntime;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                IllegalStateException illegalStateException = new IllegalStateException("You can only init GameInspector in main thread.");
                AppMethodBeat.o(130248);
                throw illegalStateException;
            } else if (aAI.mState == 0) {
                aAI.mContext = wAGamePageViewContainerLayout.getContext();
                if (z) {
                    aAI.hrH = new c(aAI.mContext, aAI.bSv);
                    aAI.hrH.setBackground(aAI.mContext.getResources().getDrawable(R.drawable.br));
                }
                if (z2) {
                    aAI.hrI = new com.tencent.mm.plugin.appbrand.game.d.b(aAI.bSv, aAI.mContext);
                }
                wAGamePageViewContainerLayout.setClipChildren(false);
                float f = aAI.mContext.getResources().getDisplayMetrics().density;
                if (aAI.hrI != null) {
                    wAGamePageViewContainerLayout.addView(aAI.hrI, new LayoutParams(-1, -1));
                    layoutParams = new LayoutParams(-2, -2);
                    layoutParams.gravity = 8388693;
                    layoutParams.bottomMargin = (int) (25.0f * f);
                    int i = (int) (f * 15.0f);
                    layoutParams.rightMargin = i;
                    layoutParams.leftMargin = i;
                    wAGamePageViewContainerLayout.addView(aAI.hrI.hrB, layoutParams);
                }
                if (aAI.hrH != null) {
                    wAGamePageViewContainerLayout.addView(aAI.hrH, new LayoutParams(-2, -2));
                }
                synchronized (aAI.hrK) {
                    try {
                        aAI.mState = 1;
                        if (z2 && aAI.hrI != null) {
                            aAI.hrI.post(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(130173);
                                    for (String log : d.this.hrK) {
                                        d.this.hrI.log(log);
                                    }
                                    d.this.hrK.clear();
                                    AppMethodBeat.o(130173);
                                }
                            });
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(130248);
                        }
                    }
                }
            }
        }
        this.hsN = new ImageView(this.mContext);
        this.hsL.addView(this.hsN, new LayoutParams(-1, -1));
        AppMethodBeat.o(130248);
    }

    public final void initActionBar() {
        AppMethodBeat.i(130249);
        super.initActionBar();
        getActionBar().setFullscreenMode(true);
        AppMethodBeat.o(130249);
    }

    public final al aAX() {
        return this.hsS;
    }

    public final ViewGroup aAY() {
        return this.hsS;
    }

    private void aAZ() {
        AppMethodBeat.i(130250);
        if (com.tencent.mm.sdk.platformtools.al.isMainThread()) {
            this.hsM = new b(this.mContext);
            this.hsM.setMBRuntime(((com.tencent.mm.plugin.appbrand.game.b) atK()).getMBRuntime());
            this.hsM.registerEventListener(new a(this, (byte) 0));
            this.hsM.setId(R.id.m);
            this.hsL.addView(this.hsM, 0, new LayoutParams(-1, -1));
            AppMethodBeat.o(130250);
            return;
        }
        com.tencent.mm.sdk.platformtools.al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130241);
                f.b(f.this);
                AppMethodBeat.o(130241);
            }
        });
        AppMethodBeat.o(130250);
    }

    public final Map<String, m> aub() {
        AppMethodBeat.i(130251);
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.o(130251);
        return emptyMap;
    }

    public final void h(String str, String str2, int i) {
        AppMethodBeat.i(130252);
        ab.e("AppBrandGame.WAGamePageView", "dispatch not support");
        AppMethodBeat.o(130252);
    }

    public final void a(ah ahVar) {
        AppMethodBeat.i(130253);
        ab.e("AppBrandGame.WAGamePageView", "dispatch not support");
        AppMethodBeat.o(130253);
    }

    public final View getContentView() {
        return this.hsL;
    }

    public final void a(String str, String str2, int[] iArr) {
        AppMethodBeat.i(130255);
        getRuntime().atK().h(str, str2, hashCode());
        AppMethodBeat.o(130255);
    }

    public final void aBb() {
        AppMethodBeat.i(130257);
        ab.i("AppBrandGame.WAGamePageView", "hy: on perform foreground");
        this.ito.wU();
        if (this.isF != null) {
            this.isF.setActuallyVisible(true);
        }
        aBe();
        this.hsM.bSv.resume();
        this.isT.aAS();
        aBn();
        AppMethodBeat.o(130257);
    }

    public final void aBc() {
        AppMethodBeat.i(130258);
        ab.i("AppBrandGame.WAGamePageView", "hy: on perform background");
        this.ito.wW();
        if (this.isF != null) {
            this.isF.setActuallyVisible(false);
        }
        this.hsM.bSv.pause();
        if (this.itm != null) {
            this.itm.dismiss();
        }
        AppMethodBeat.o(130258);
    }

    public final void aBd() {
        AppMethodBeat.i(130259);
        super.aBd();
        ab.i("AppBrandGame.WAGamePageView", "performPageDestroy");
        aBe();
        d.release();
        AppMethodBeat.o(130259);
    }

    private void aBe() {
        AppMethodBeat.i(130260);
        synchronized (this.hsU) {
            try {
                if (!(this.hsT == null || this.hsT.isRecycled())) {
                    ab.i("AppBrandGame.WAGamePageView", "hy: recycling captured screen");
                    this.hsT.recycle();
                    this.hsT = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130260);
            }
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public final void xN() {
    }

    public final ac aBf() {
        return this.hsR;
    }

    public final boolean wY() {
        return false;
    }

    public final void nV(int i) {
    }

    public final void AB(String str) {
    }

    public final String aBg() {
        return null;
    }

    public final void nW(int i) {
    }

    public final void dN(boolean z) {
    }

    public final void aBh() {
    }

    public final void aBi() {
    }

    public final void dO(boolean z) {
    }

    public final void bV(String str, String str2) {
    }

    public final void AC(final String str) {
        AppMethodBeat.i(130261);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130242);
                f.this.hsQ = com.tencent.mm.plugin.appbrand.page.a.d.a.Dk(str) == com.tencent.mm.plugin.appbrand.page.a.d.a.BLACK;
                if (f.this.mContext instanceof Activity) {
                    Window window = ((Activity) f.this.mContext).getWindow();
                    if (window != null) {
                        n.a(window, f.this.hsQ);
                    }
                }
                AppMethodBeat.o(130242);
            }
        });
        AppMethodBeat.o(130261);
    }

    public final void aBj() {
        AppMethodBeat.i(130262);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(130243);
                if (f.this.mContext instanceof Activity) {
                    Window window = ((Activity) f.this.mContext).getWindow();
                    if (window != null) {
                        n.a(window, f.this.hsQ);
                    }
                }
                AppMethodBeat.o(130243);
            }
        });
        AppMethodBeat.o(130262);
    }

    public final FrameLayout aBk() {
        return this.hsL;
    }

    public final View aBl() {
        AppMethodBeat.i(130263);
        View appBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
        appBrandActionHeaderLayout.setAppId(getAppId());
        appBrandActionHeaderLayout.setActionHeaderStyle(this.isO);
        ab.w("AppBrandGame.WAGamePageView", "getActionSheetHeader orientation:%d, mActionSheetTitle:%s", Integer.valueOf(((MMActivity) this.mContext).getRequestedOrientation()), this.isP);
        if (aJQ()) {
            if (!TextUtils.isEmpty(this.isP)) {
                appBrandActionHeaderLayout.setStatusDescription(this.isP);
            }
            appBrandActionHeaderLayout.cI(getRuntime().atI().iconUrl, getRuntime().atI().cwz);
            AppMethodBeat.o(130263);
            return appBrandActionHeaderLayout;
        } else if (TextUtils.isEmpty(this.isP)) {
            AppMethodBeat.o(130263);
            return null;
        } else {
            appBrandActionHeaderLayout.setStatusDescription(this.isP);
            AppMethodBeat.o(130263);
            return appBrandActionHeaderLayout;
        }
    }

    public final String getURL() {
        return this.hsV;
    }

    public final String aBm() {
        return this.mUrl;
    }

    public final <T> T a(int i, Bundle bundle, Object... objArr) {
        int i2 = 0;
        AppMethodBeat.i(130264);
        switch (i) {
            case 1:
                AppMethodBeat.o(130264);
                return null;
            case 2:
                if (bundle != null) {
                    i2 = bundle.getBoolean("needPortraitSnapshot", false);
                }
                if (this.hsO != null) {
                    this.hsO.recycle();
                    this.hsO = null;
                }
                if (this.hsN == null) {
                    this.hsN = new ImageView(this.mContext);
                }
                com.tencent.mm.plugin.appbrand.config.a.a.b dI = com.tencent.mm.plugin.appbrand.config.a.a.t(getRuntime().atM()).dI(com.tencent.mm.plugin.appbrand.config.a.a.ayQ());
                if (com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_SENSOR == dI || com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED == dI || com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT == dI || com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_RIGHT == dI) {
                    this.hsO = aBp();
                    this.hsL.setOnConfigurationChangedListener(new a() {
                        public final void a(WAGamePageViewContainerLayout.b bVar, WAGamePageViewContainerLayout.b bVar2) {
                            AppMethodBeat.i(130244);
                            ab.v("AppBrandGame.WAGamePageView", "hy: after change. old direction:%s, new direction: %s", bVar, bVar2);
                            if (f.this.hsO == null) {
                                ab.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
                                AppMethodBeat.o(130244);
                            } else if ((f.a(bVar) && f.a(bVar2)) || (f.b(bVar) && f.b(bVar2))) {
                                AppMethodBeat.o(130244);
                            } else if (f.a(bVar2)) {
                                Matrix matrix = new Matrix();
                                if ((bVar2 == WAGamePageViewContainerLayout.b.PORTRAIT && bVar == WAGamePageViewContainerLayout.b.LANDSCAPE) || (bVar2 == WAGamePageViewContainerLayout.b.PORTRAIT_REVERSE && bVar == WAGamePageViewContainerLayout.b.LANDSCAPE_REVERSE)) {
                                    matrix.postRotate(90.0f);
                                } else {
                                    matrix.postRotate(270.0f);
                                }
                                f.this.hsN.setVisibility(0);
                                f.this.hsN.setImageBitmap(Bitmap.createBitmap(f.this.hsO, 0, 0, f.this.hsO.getWidth(), f.this.hsO.getHeight(), matrix, true));
                                f.this.hsP = true;
                                AppMethodBeat.o(130244);
                            } else {
                                f.g(f.this);
                                f.this.hsL.setOnConfigurationChangedListener(null);
                                AppMethodBeat.o(130244);
                            }
                        }
                    });
                } else if (i2 != 0) {
                    this.hsO = aBp();
                    if (this.hsO == null) {
                        ab.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
                    } else {
                        com.tencent.mm.sdk.platformtools.al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(130245);
                                f.this.hsN.setVisibility(0);
                                f.this.hsN.setImageBitmap(f.this.hsO);
                                AppMethodBeat.o(130245);
                            }
                        });
                        this.hsP = true;
                        ab.i("AppBrandGame.WAGamePageView", "hy: vertical game. isRedpackge isPortrait screenshot");
                    }
                } else {
                    ab.i("AppBrandGame.WAGamePageView", "hy: vertical game. not need screenshot");
                }
                AppMethodBeat.o(130264);
                return null;
            default:
                ab.w("AppBrandGame.WAGamePageView", "hy: not support this command!! %d", Integer.valueOf(i));
                Object a = super.a(i, bundle, objArr);
                AppMethodBeat.o(130264);
                return a;
        }
    }

    private void aBn() {
        AppMethodBeat.i(130265);
        if (this.hsP) {
            this.hsP = false;
            this.hsN.setVisibility(8);
            if (this.hsO != null) {
                this.hsO.recycle();
                this.hsO = null;
            }
        }
        AppMethodBeat.o(130265);
    }

    public final com.tencent.mm.vending.g.c<Bitmap> xR() {
        AppMethodBeat.i(130266);
        com.tencent.mm.ci.f da = g.da(null);
        AppMethodBeat.o(130266);
        return da;
    }

    public final Bitmap aBo() {
        Bitmap bitmap;
        AppMethodBeat.i(130267);
        ab.i("AppBrandGame.WAGamePageView", "hy: jsapi enter wait");
        synchronized (this.hsU) {
            try {
                ab.i("AppBrandGame.WAGamePageView", "hy: jsapi enter");
                if (this.hsT == null || this.hsT.isRecycled()) {
                    ab.e("AppBrandGame.WAGamePageView", "hy: already background and not triggered by transmit. abort");
                    bitmap = null;
                    AppMethodBeat.o(130267);
                } else {
                    bitmap = this.hsT;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130267);
            }
        }
        return bitmap;
    }

    public final boolean g(Canvas canvas) {
        return true;
    }

    private Bitmap aBp() {
        AppMethodBeat.i(130268);
        if (this.hsM == null) {
            ab.e("AppBrandGame.WAGamePageView", "captureScreen, view == null");
            AppMethodBeat.o(130268);
            return null;
        } else if ($assertionsDisabled || this.hsM.getMBRuntime() != null) {
            Bitmap a = this.hsM.getMBRuntime().getCanvasHandler().a(null, true);
            AppMethodBeat.o(130268);
            return a;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(130268);
            throw assertionError;
        }
    }

    public final com.tencent.mm.plugin.appbrand.page.b.c aBq() {
        AppMethodBeat.i(130270);
        com.tencent.mm.plugin.appbrand.game.page.a.a aVar = new com.tencent.mm.plugin.appbrand.game.page.a.a(this);
        AppMethodBeat.o(130270);
        return aVar;
    }

    public final aj cF(Context context) {
        AppMethodBeat.i(130271);
        a aVar = new a();
        AppMethodBeat.o(130271);
        return aVar;
    }

    public final am cG(Context context) {
        return am.iuX;
    }

    @SuppressLint({"MissingSuperCall"})
    public final boolean AA(String str) {
        AppMethodBeat.i(130254);
        this.ito.DB(str);
        this.mUrl = str;
        this.hsV = h.bO(str);
        ab.i("AppBrandGame.WAGamePageView", "loadURL url : ".concat(String.valueOf(str)));
        AppMethodBeat.o(130254);
        return true;
    }

    public final void aBa() {
        AppMethodBeat.i(130256);
        this.ito.aLj();
        AppMethodBeat.o(130256);
    }

    public final boolean isFullScreen() {
        AppMethodBeat.i(130269);
        if (this.isT.aBt() == com.tencent.mm.plugin.appbrand.page.b.c.b.HIDDEN) {
            AppMethodBeat.o(130269);
            return true;
        }
        AppMethodBeat.o(130269);
        return false;
    }
}

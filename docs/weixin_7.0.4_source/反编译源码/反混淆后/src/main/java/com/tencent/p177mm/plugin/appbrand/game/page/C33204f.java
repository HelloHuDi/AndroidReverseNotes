package com.tencent.p177mm.plugin.appbrand.game.page;

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
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.magicbrush.C32197b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.MBRuntime.C25712a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C33198b;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C38219c;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C45558d.C424411;
import com.tencent.p177mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout.C10239a;
import com.tencent.p177mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout.C10240b;
import com.tencent.p177mm.plugin.appbrand.game.page.p1536a.C42447a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.page.AppBrandActionHeaderLayout;
import com.tencent.p177mm.plugin.appbrand.page.AppBrandPageFullScreenView;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C33467al;
import com.tencent.p177mm.plugin.appbrand.page.C38460ak;
import com.tencent.p177mm.plugin.appbrand.page.C38461am;
import com.tencent.p177mm.plugin.appbrand.page.C45663ac;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C27217d.C10657a;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c.C19628b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.vending.p641g.C7361c;
import java.util.Collections;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.tencent.mm.plugin.appbrand.game.page.f */
public final class C33204f extends C27242w {
    public static final /* synthetic */ boolean $assertionsDisabled = (!C33204f.class.desiredAssertionStatus());
    private boolean apg = true;
    WAGamePageViewContainerLayout hsL;
    public C32197b hsM;
    private ImageView hsN;
    private Bitmap hsO;
    private boolean hsP = false;
    private boolean hsQ = false;
    private C45663ac hsR;
    private C10241b hsS;
    private Bitmap hsT = null;
    private final Object hsU = new Object();
    private String hsV;
    private String mUrl;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.f$4 */
    class C102484 implements Runnable {
        C102484() {
        }

        public final void run() {
            AppMethodBeat.m2504i(130243);
            if (C33204f.this.mContext instanceof Activity) {
                Window window = ((Activity) C33204f.this.mContext).getWindow();
                if (window != null) {
                    C42696n.m75616a(window, C33204f.this.hsQ);
                }
            }
            AppMethodBeat.m2505o(130243);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.f$5 */
    class C102495 implements C10239a {
        C102495() {
        }

        /* renamed from: a */
        public final void mo21648a(C10240b c10240b, C10240b c10240b2) {
            AppMethodBeat.m2504i(130244);
            C4990ab.m7419v("AppBrandGame.WAGamePageView", "hy: after change. old direction:%s, new direction: %s", c10240b, c10240b2);
            if (C33204f.this.hsO == null) {
                C4990ab.m7412e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
                AppMethodBeat.m2505o(130244);
            } else if ((C33204f.m54306a(c10240b) && C33204f.m54306a(c10240b2)) || (C33204f.m54309b(c10240b) && C33204f.m54309b(c10240b2))) {
                AppMethodBeat.m2505o(130244);
            } else if (C33204f.m54306a(c10240b2)) {
                Matrix matrix = new Matrix();
                if ((c10240b2 == C10240b.PORTRAIT && c10240b == C10240b.LANDSCAPE) || (c10240b2 == C10240b.PORTRAIT_REVERSE && c10240b == C10240b.LANDSCAPE_REVERSE)) {
                    matrix.postRotate(90.0f);
                } else {
                    matrix.postRotate(270.0f);
                }
                C33204f.this.hsN.setVisibility(0);
                C33204f.this.hsN.setImageBitmap(Bitmap.createBitmap(C33204f.this.hsO, 0, 0, C33204f.this.hsO.getWidth(), C33204f.this.hsO.getHeight(), matrix, true));
                C33204f.this.hsP = true;
                AppMethodBeat.m2505o(130244);
            } else {
                C33204f.m54314g(C33204f.this);
                C33204f.this.hsL.setOnConfigurationChangedListener(null);
                AppMethodBeat.m2505o(130244);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.f$6 */
    class C102506 implements Runnable {
        C102506() {
        }

        public final void run() {
            AppMethodBeat.m2504i(130245);
            C33204f.this.hsN.setVisibility(0);
            C33204f.this.hsN.setImageBitmap(C33204f.this.hsO);
            AppMethodBeat.m2505o(130245);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.f$a */
    class C19242a extends C25712a {
        private C19242a() {
        }

        /* synthetic */ C19242a(C33204f c33204f, byte b) {
            this();
        }

        public final void onFirstFrameRendered() {
            AppMethodBeat.m2504i(130246);
            C4990ab.m7416i("AppBrandGame.WAGamePageView", "MagicBrush.onFirstFrameRendered");
            C33204f.this.onReady();
            AppMethodBeat.m2505o(130246);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.f$2 */
    class C268952 implements Runnable {
        C268952() {
        }

        public final void run() {
            AppMethodBeat.m2504i(130241);
            C33204f.m54308b(C33204f.this);
            AppMethodBeat.m2505o(130241);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.f$1 */
    class C332051 implements C38460ak {
        C332051() {
        }

        /* renamed from: a */
        public final void mo22214a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
            AppMethodBeat.m2504i(138124);
            if (appBrandPageFullScreenView != null && appBrandPageFullScreenView.getParent() == null) {
                C33204f.this.hsL.addView(appBrandPageFullScreenView, new LayoutParams(-1, -1));
            }
            AppMethodBeat.m2505o(138124);
        }
    }

    static {
        AppMethodBeat.m2504i(130274);
        AppMethodBeat.m2505o(130274);
    }

    C33204f(Context context, C6750i c6750i) {
        AppMethodBeat.m2504i(130247);
        long yz = C5046bo.m7588yz();
        this.irO = c6750i.asV().getDecorWidgetFactory();
        super.mo44895a(context, c6750i);
        C4990ab.m7417i("AppBrandGame.WAGamePageView", "[damonlei] WAGamePageView cost [%d]ms", Long.valueOf(C5046bo.m7525az(yz)));
        AppMethodBeat.m2505o(130247);
    }

    public final void initView() {
        AppMethodBeat.m2504i(130248);
        C4990ab.m7416i("AppBrandGame.WAGamePageView", "new Rendder GameView");
        initActionBar();
        this.hsL = new WAGamePageViewContainerLayout(this.mContext);
        aAZ();
        this.hsS = new C10241b(this.mContext);
        this.hsL.addView(this.hsS, new FrameLayout.LayoutParams(-1, -1));
        this.hsR = new C26894c(this.hsS);
        this.hsR.setFullscreenImpl(aJy());
        this.hsR.mo73440a(new C332051());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.rightMargin = C1338a.m2857am(this.mContext, C25738R.dimen.f10139ra);
        layoutParams.topMargin = C1338a.m2857am(this.mContext, C25738R.dimen.f10140rb);
        this.hsL.addView(this.isF, layoutParams);
        boolean z = C5058f.DEBUG || getRuntime().atH().bQp;
        boolean z2 = getRuntime().atH().bQp;
        if (z || z2) {
            C45558d aAI = C45558d.aAI();
            MBRuntime mBRuntime = ((C42439b) atK()).getMBRuntime();
            WAGamePageViewContainerLayout wAGamePageViewContainerLayout = this.hsL;
            aAI.bSv = mBRuntime;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                IllegalStateException illegalStateException = new IllegalStateException("You can only init GameInspector in main thread.");
                AppMethodBeat.m2505o(130248);
                throw illegalStateException;
            } else if (aAI.mState == 0) {
                aAI.mContext = wAGamePageViewContainerLayout.getContext();
                if (z) {
                    aAI.hrH = new C38219c(aAI.mContext, aAI.bSv);
                    aAI.hrH.setBackground(aAI.mContext.getResources().getDrawable(C25738R.drawable.f6364br));
                }
                if (z2) {
                    aAI.hrI = new C33198b(aAI.bSv, aAI.mContext);
                }
                wAGamePageViewContainerLayout.setClipChildren(false);
                float f = aAI.mContext.getResources().getDisplayMetrics().density;
                if (aAI.hrI != null) {
                    wAGamePageViewContainerLayout.addView(aAI.hrI, new FrameLayout.LayoutParams(-1, -1));
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 8388693;
                    layoutParams.bottomMargin = (int) (25.0f * f);
                    int i = (int) (f * 15.0f);
                    layoutParams.rightMargin = i;
                    layoutParams.leftMargin = i;
                    wAGamePageViewContainerLayout.addView(aAI.hrI.hrB, layoutParams);
                }
                if (aAI.hrH != null) {
                    wAGamePageViewContainerLayout.addView(aAI.hrH, new FrameLayout.LayoutParams(-2, -2));
                }
                synchronized (aAI.hrK) {
                    try {
                        aAI.mState = 1;
                        if (z2 && aAI.hrI != null) {
                            aAI.hrI.post(new C424411());
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(130248);
                        }
                    }
                }
            }
        }
        this.hsN = new ImageView(this.mContext);
        this.hsL.addView(this.hsN, new FrameLayout.LayoutParams(-1, -1));
        AppMethodBeat.m2505o(130248);
    }

    public final void initActionBar() {
        AppMethodBeat.m2504i(130249);
        super.initActionBar();
        getActionBar().setFullscreenMode(true);
        AppMethodBeat.m2505o(130249);
    }

    public final C33467al aAX() {
        return this.hsS;
    }

    public final ViewGroup aAY() {
        return this.hsS;
    }

    private void aAZ() {
        AppMethodBeat.m2504i(130250);
        if (C5004al.isMainThread()) {
            this.hsM = new C32197b(this.mContext);
            this.hsM.setMBRuntime(((C42439b) atK()).getMBRuntime());
            this.hsM.registerEventListener(new C19242a(this, (byte) 0));
            this.hsM.setId(2131820556);
            this.hsL.addView(this.hsM, 0, new FrameLayout.LayoutParams(-1, -1));
            AppMethodBeat.m2505o(130250);
            return;
        }
        C5004al.m7441d(new C268952());
        AppMethodBeat.m2505o(130250);
    }

    public final Map<String, C45608m> aub() {
        AppMethodBeat.m2504i(130251);
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.m2505o(130251);
        return emptyMap;
    }

    /* renamed from: h */
    public final void mo51255h(String str, String str2, int i) {
        AppMethodBeat.m2504i(130252);
        C4990ab.m7412e("AppBrandGame.WAGamePageView", "dispatch not support");
        AppMethodBeat.m2505o(130252);
    }

    /* renamed from: a */
    public final void mo6108a(C42467ah c42467ah) {
        AppMethodBeat.m2504i(130253);
        C4990ab.m7412e("AppBrandGame.WAGamePageView", "dispatch not support");
        AppMethodBeat.m2505o(130253);
    }

    public final View getContentView() {
        return this.hsL;
    }

    /* renamed from: a */
    public final void mo6109a(String str, String str2, int[] iArr) {
        AppMethodBeat.m2504i(130255);
        getRuntime().atK().mo51255h(str, str2, hashCode());
        AppMethodBeat.m2505o(130255);
    }

    public final void aBb() {
        AppMethodBeat.m2504i(130257);
        C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: on perform foreground");
        this.ito.mo22271wU();
        if (this.isF != null) {
            this.isF.setActuallyVisible(true);
        }
        aBe();
        this.hsM.bSv.resume();
        this.isT.aAS();
        aBn();
        AppMethodBeat.m2505o(130257);
    }

    public final void aBc() {
        AppMethodBeat.m2504i(130258);
        C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: on perform background");
        this.ito.mo22272wW();
        if (this.isF != null) {
            this.isF.setActuallyVisible(false);
        }
        this.hsM.bSv.pause();
        if (this.itm != null) {
            this.itm.dismiss();
        }
        AppMethodBeat.m2505o(130258);
    }

    public final void aBd() {
        AppMethodBeat.m2504i(130259);
        super.aBd();
        C4990ab.m7416i("AppBrandGame.WAGamePageView", "performPageDestroy");
        aBe();
        C45558d.release();
        AppMethodBeat.m2505o(130259);
    }

    private void aBe() {
        AppMethodBeat.m2504i(130260);
        synchronized (this.hsU) {
            try {
                if (!(this.hsT == null || this.hsT.isRecycled())) {
                    C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: recycling captured screen");
                    this.hsT.recycle();
                    this.hsT = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130260);
            }
        }
    }

    @SuppressLint({"MissingSuperCall"})
    /* renamed from: xN */
    public final void mo44924xN() {
    }

    public final C45663ac aBf() {
        return this.hsR;
    }

    /* renamed from: wY */
    public final boolean mo53753wY() {
        return false;
    }

    /* renamed from: nV */
    public final void mo53751nV(int i) {
    }

    /* renamed from: AB */
    public final void mo53734AB(String str) {
    }

    public final String aBg() {
        return null;
    }

    /* renamed from: nW */
    public final void mo53752nW(int i) {
    }

    /* renamed from: dN */
    public final void mo53747dN(boolean z) {
    }

    public final void aBh() {
    }

    public final void aBi() {
    }

    /* renamed from: dO */
    public final void mo53748dO(boolean z) {
    }

    /* renamed from: bV */
    public final void mo53746bV(String str, String str2) {
    }

    /* renamed from: AC */
    public final void mo53735AC(final String str) {
        AppMethodBeat.m2504i(130261);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(130242);
                C33204f.this.hsQ = C10657a.m18353Dk(str) == C10657a.BLACK;
                if (C33204f.this.mContext instanceof Activity) {
                    Window window = ((Activity) C33204f.this.mContext).getWindow();
                    if (window != null) {
                        C42696n.m75616a(window, C33204f.this.hsQ);
                    }
                }
                AppMethodBeat.m2505o(130242);
            }
        });
        AppMethodBeat.m2505o(130261);
    }

    public final void aBj() {
        AppMethodBeat.m2504i(130262);
        runOnUiThread(new C102484());
        AppMethodBeat.m2505o(130262);
    }

    public final FrameLayout aBk() {
        return this.hsL;
    }

    public final View aBl() {
        AppMethodBeat.m2504i(130263);
        View appBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
        appBrandActionHeaderLayout.setAppId(getAppId());
        appBrandActionHeaderLayout.setActionHeaderStyle(this.isO);
        C4990ab.m7421w("AppBrandGame.WAGamePageView", "getActionSheetHeader orientation:%d, mActionSheetTitle:%s", Integer.valueOf(((MMActivity) this.mContext).getRequestedOrientation()), this.isP);
        if (aJQ()) {
            if (!TextUtils.isEmpty(this.isP)) {
                appBrandActionHeaderLayout.setStatusDescription(this.isP);
            }
            appBrandActionHeaderLayout.mo34821cI(getRuntime().atI().iconUrl, getRuntime().atI().cwz);
            AppMethodBeat.m2505o(130263);
            return appBrandActionHeaderLayout;
        } else if (TextUtils.isEmpty(this.isP)) {
            AppMethodBeat.m2505o(130263);
            return null;
        } else {
            appBrandActionHeaderLayout.setStatusDescription(this.isP);
            AppMethodBeat.m2505o(130263);
            return appBrandActionHeaderLayout;
        }
    }

    public final String getURL() {
        return this.hsV;
    }

    public final String aBm() {
        return this.mUrl;
    }

    /* renamed from: a */
    public final <T> T mo53736a(int i, Bundle bundle, Object... objArr) {
        int i2 = 0;
        AppMethodBeat.m2504i(130264);
        switch (i) {
            case 1:
                AppMethodBeat.m2505o(130264);
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
                C26839b dI = C26835a.m42717t(getRuntime().atM()).mo44610dI(C26835a.ayQ());
                if (C26839b.LANDSCAPE_SENSOR == dI || C26839b.LANDSCAPE_LOCKED == dI || C26839b.LANDSCAPE_LEFT == dI || C26839b.LANDSCAPE_RIGHT == dI) {
                    this.hsO = aBp();
                    this.hsL.setOnConfigurationChangedListener(new C102495());
                } else if (i2 != 0) {
                    this.hsO = aBp();
                    if (this.hsO == null) {
                        C4990ab.m7412e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
                    } else {
                        C5004al.m7441d(new C102506());
                        this.hsP = true;
                        C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: vertical game. isRedpackge isPortrait screenshot");
                    }
                } else {
                    C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: vertical game. not need screenshot");
                }
                AppMethodBeat.m2505o(130264);
                return null;
            default:
                C4990ab.m7421w("AppBrandGame.WAGamePageView", "hy: not support this command!! %d", Integer.valueOf(i));
                Object a = super.mo53736a(i, bundle, objArr);
                AppMethodBeat.m2505o(130264);
                return a;
        }
    }

    private void aBn() {
        AppMethodBeat.m2504i(130265);
        if (this.hsP) {
            this.hsP = false;
            this.hsN.setVisibility(8);
            if (this.hsO != null) {
                this.hsO.recycle();
                this.hsO = null;
            }
        }
        AppMethodBeat.m2505o(130265);
    }

    /* renamed from: xR */
    public final C7361c<Bitmap> mo53754xR() {
        AppMethodBeat.m2504i(130266);
        C37654f da = C41930g.m74067da(null);
        AppMethodBeat.m2505o(130266);
        return da;
    }

    public final Bitmap aBo() {
        Bitmap bitmap;
        AppMethodBeat.m2504i(130267);
        C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: jsapi enter wait");
        synchronized (this.hsU) {
            try {
                C4990ab.m7416i("AppBrandGame.WAGamePageView", "hy: jsapi enter");
                if (this.hsT == null || this.hsT.isRecycled()) {
                    C4990ab.m7412e("AppBrandGame.WAGamePageView", "hy: already background and not triggered by transmit. abort");
                    bitmap = null;
                    AppMethodBeat.m2505o(130267);
                } else {
                    bitmap = this.hsT;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(130267);
            }
        }
        return bitmap;
    }

    /* renamed from: g */
    public final boolean mo22183g(Canvas canvas) {
        return true;
    }

    private Bitmap aBp() {
        AppMethodBeat.m2504i(130268);
        if (this.hsM == null) {
            C4990ab.m7412e("AppBrandGame.WAGamePageView", "captureScreen, view == null");
            AppMethodBeat.m2505o(130268);
            return null;
        } else if ($assertionsDisabled || this.hsM.getMBRuntime() != null) {
            Bitmap a = this.hsM.getMBRuntime().getCanvasHandler().mo4006a(null, true);
            AppMethodBeat.m2505o(130268);
            return a;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.m2505o(130268);
            throw assertionError;
        }
    }

    public final C19627c aBq() {
        AppMethodBeat.m2504i(130270);
        C42447a c42447a = new C42447a(this);
        AppMethodBeat.m2505o(130270);
        return c42447a;
    }

    /* renamed from: cF */
    public final C27221aj mo44915cF(Context context) {
        AppMethodBeat.m2504i(130271);
        C42448a c42448a = new C42448a();
        AppMethodBeat.m2505o(130271);
        return c42448a;
    }

    /* renamed from: cG */
    public final C38461am mo44916cG(Context context) {
        return C38461am.iuX;
    }

    @SuppressLint({"MissingSuperCall"})
    /* renamed from: AA */
    public final boolean mo44893AA(String str) {
        AppMethodBeat.m2504i(130254);
        this.ito.mo22264DB(str);
        this.mUrl = str;
        this.hsV = C8874h.m15847bO(str);
        C4990ab.m7416i("AppBrandGame.WAGamePageView", "loadURL url : ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(130254);
        return true;
    }

    public final void aBa() {
        AppMethodBeat.m2504i(130256);
        this.ito.aLj();
        AppMethodBeat.m2505o(130256);
    }

    public final boolean isFullScreen() {
        AppMethodBeat.m2504i(130269);
        if (this.isT.aBt() == C19628b.HIDDEN) {
            AppMethodBeat.m2505o(130269);
            return true;
        }
        AppMethodBeat.m2505o(130269);
        return false;
    }
}

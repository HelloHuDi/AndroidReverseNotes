package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.s;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.s.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
public class u extends b implements e, ar {
    protected static final int isC = R.id.f;
    private volatile boolean apg = false;
    private volatile boolean fCY = false;
    public volatile boolean gPH = false;
    private volatile i gPI;
    private String hsV;
    private com.tencent.mm.plugin.appbrand.widget.input.u ico = null;
    private final c icp = new c() {
        private int ict = 0;
        private final v isZ = new v();

        {
            AppMethodBeat.i(87157);
            AppMethodBeat.o(87157);
        }

        public final void oD(int i) {
            this.ict = i;
        }

        public final void et(boolean z) {
            AppMethodBeat.i(87158);
            this.isZ.a(z ? this.ict : 0, u.this.xT(), u.this, null);
            AppMethodBeat.o(87158);
        }

        public final int getHeight() {
            return this.ict;
        }
    };
    private final ConcurrentLinkedQueue<Runnable> ies = new ConcurrentLinkedQueue();
    private String ikx;
    protected List<n> irD;
    protected ap irO = null;
    private FrameLayout irj;
    protected int isD = R.id.e;
    private RelativeLayout isE;
    protected d isF;
    protected com.tencent.mm.plugin.appbrand.widget.actionbar.b isG;
    private ac isH;
    private al isI;
    protected aj isJ;
    public y isK;
    private volatile boolean isL = false;
    private volatile boolean isM = false;
    private boolean isN = false;
    public boolean isO = false;
    protected CharSequence isP = null;
    public String isQ = null;
    private c isR;
    public final com.tencent.mm.plugin.appbrand.widget.f.b isS = new com.tencent.mm.plugin.appbrand.widget.f.b(this);
    public com.tencent.mm.plugin.appbrand.page.b.c isT;
    am isU;
    private OnGlobalLayoutListener isV;
    private n isW;
    ab isX = new ab(this);
    private boolean isY = false;
    public Context mContext;

    class b {
        private b() {
        }

        /* synthetic */ b(u uVar, byte b) {
            this();
        }

        @JavascriptInterface
        public final float getPixelRatio() {
            AppMethodBeat.i(87196);
            float f = u.this.mContext.getResources().getDisplayMetrics().density;
            AppMethodBeat.o(87196);
            return f;
        }

        @JavascriptInterface
        public final float getWidth() {
            AppMethodBeat.i(87197);
            com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "DeviceInfoForSDK.getWidth %d", Integer.valueOf(u.this.getContentView().getWidth()));
            float pixelRatio = ((float) u.this.mContext.getResources().getDisplayMetrics().widthPixels) / getPixelRatio();
            AppMethodBeat.o(87197);
            return pixelRatio;
        }
    }

    class a extends RelativeLayout implements ar {
        public a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDetachedFromWindow() {
            AppMethodBeat.i(87194);
            super.onDetachedFromWindow();
            if (u.this.isH != null) {
                ac f = u.this.isH;
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                obtain.setSource(4098);
                for (com.tencent.mm.plugin.appbrand.page.ac.b bVar : f.iut) {
                    View view = (View) bVar.iuM.get();
                    if (view != null) {
                        view.dispatchTouchEvent(obtain);
                    }
                }
                obtain.recycle();
            }
            AppMethodBeat.o(87194);
        }

        public final boolean g(Canvas canvas) {
            AppMethodBeat.i(87195);
            boolean g = u.this.g(canvas);
            AppMethodBeat.o(87195);
            return g;
        }
    }

    static /* synthetic */ void a(u uVar, String str, String str2, int i) {
        AppMethodBeat.i(87272);
        super.h(str, str2, i);
        AppMethodBeat.o(87272);
    }

    static /* synthetic */ void o(u uVar) {
        AppMethodBeat.i(87274);
        uVar.aJL();
        AppMethodBeat.o(87274);
    }

    public final boolean aJt() {
        return this.fCY;
    }

    public u() {
        AppMethodBeat.i(87198);
        AppMethodBeat.o(87198);
    }

    public void a(Context context, i iVar) {
        AppMethodBeat.i(87199);
        this.mContext = context;
        this.gPI = iVar;
        this.apg = true;
        this.irD = aJx();
        e(iVar.gNI);
        super.init();
        initView();
        aJN();
        this.isU = cG(this.mContext);
        this.isT = aBq();
        AppMethodBeat.o(87199);
    }

    /* Access modifiers changed, original: protected|final */
    public final void k(n nVar) {
        AppMethodBeat.i(138232);
        this.isW = nVar;
        aJu();
        AppMethodBeat.o(138232);
    }

    private void aJu() {
        AppMethodBeat.i(138233);
        if (this.isH == null) {
            com.tencent.luggage.g.d.e("MicroMsg.AppBrandPageView", "mCustomViewContainer is null, err, return");
            AppMethodBeat.o(138233);
            return;
        }
        this.isH.a(new ak() {
            public final void a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
                AppMethodBeat.i(138231);
                if (u.this.isW == null) {
                    com.tencent.luggage.g.d.e("MicroMsg.AppBrandPageView", "mContainerPage is null, check time sequence, err");
                    AppMethodBeat.o(138231);
                    return;
                }
                u.this.isW.a(u.this, appBrandPageFullScreenView);
                AppMethodBeat.o(138231);
            }
        });
        AppMethodBeat.o(138233);
    }

    public final n aJv() {
        return this.isW;
    }

    public final void Dw() {
        AppMethodBeat.i(87200);
        aCd();
        this.gPH = true;
        aJO();
        L(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87185);
                u.this.q(u.this.aue());
                u.p(u.this);
                u.this.atV();
                AppMethodBeat.o(87185);
            }
        });
        AppMethodBeat.o(87200);
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.page.b.c aBq() {
        AppMethodBeat.i(87201);
        com.tencent.mm.plugin.appbrand.page.b.c r = com.tencent.mm.plugin.appbrand.page.b.c.a.r(this);
        AppMethodBeat.o(87201);
        return r;
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        AppMethodBeat.i(87202);
        initActionBar();
        if (this.isJ == null) {
            aCd();
        }
        this.isJ.cE(this.mContext);
        this.isJ.setFullscreenImpl(aJy());
        this.isK = new y(this.mContext, this.isJ);
        this.isK.setOnPullDownListener(new com.tencent.mm.plugin.appbrand.page.y.a() {
            public final void aJR() {
                AppMethodBeat.i(87192);
                u.this.a("onPullDownRefresh", null, null);
                AppMethodBeat.o(87192);
            }
        });
        this.isK.setOnPullDownOffsetListener(new com.tencent.mm.plugin.appbrand.page.y.b() {
            public final void nT(int i) {
                AppMethodBeat.i(87193);
                u.this.isI.nT(i);
                AppMethodBeat.o(87193);
            }
        });
        this.irj = new FrameLayout(this.mContext);
        this.irj.setId(R.id.x);
        this.irj.addView(this.isK);
        y yVar = this.isK;
        al q = ((com.tencent.mm.plugin.appbrand.page.al.a) com.tencent.luggage.a.e.B(com.tencent.mm.plugin.appbrand.page.al.a.class)).q(this);
        this.isI = q;
        yVar.addView(q.getContainer());
        this.isK.setOnPullDownOffsetListener(this.isI);
        this.isJ.setOnScrollChangedListener(this.isI);
        this.isJ.setWebViewLayoutListener(this.isI);
        this.isI.setupWebViewTouchInterceptor(this.isJ);
        this.isE = new a(this.mContext);
        this.isE.setLayoutParams(new LayoutParams(-1, -1));
        this.isE.addView(this.irj, new LayoutParams(-1, -1));
        this.isE.addView(this.isF);
        this.isH = new ac(this.isI.getContainer());
        this.isH.setFullscreenImpl(aJy());
        aBk().addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(87182);
                if (TextUtils.isEmpty(u.this.getURL())) {
                    AppMethodBeat.o(87182);
                } else if (u.this.apg) {
                    com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "pageArea onLayoutChange appId[%s], url[%s]", u.this.getAppId(), u.this.getURL());
                    if (u.this.xT() == null) {
                        AppMethodBeat.o(87182);
                        return;
                    }
                    u.this.isU.aJW();
                    AppMethodBeat.o(87182);
                } else {
                    try {
                        u.this.aBk().removeOnLayoutChangeListener(this);
                        AppMethodBeat.o(87182);
                    } catch (ConcurrentModificationException e) {
                        u.this.f(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(87181);
                                u.this.aBk().removeOnLayoutChangeListener(this);
                                AppMethodBeat.o(87181);
                            }
                        });
                        AppMethodBeat.o(87182);
                    }
                }
            }
        });
        AppMethodBeat.o(87202);
    }

    public final Context getContext() {
        return this.mContext;
    }

    public Map<String, m> aub() {
        AppMethodBeat.i(87203);
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.o(87203);
        return emptyMap;
    }

    public i getRuntime() {
        return this.gPI;
    }

    public q xT() {
        AppMethodBeat.i(87204);
        q xT = getRuntime().xT();
        AppMethodBeat.o(87204);
        return xT;
    }

    public View getContentView() {
        return this.isE;
    }

    public ViewGroup aAY() {
        AppMethodBeat.i(87205);
        ViewGroup container = this.isI.getContainer();
        AppMethodBeat.o(87205);
        return container;
    }

    public al aAX() {
        return this.isI;
    }

    /* Access modifiers changed, original: protected */
    public void aL(List<n> list) {
        AppMethodBeat.i(87207);
        new o(this, new LinkedList(this.irD)).aJm();
        AppMethodBeat.o(87207);
    }

    public aj cF(Context context) {
        AppMethodBeat.i(87208);
        if (context == null) {
            context = ah.getContext();
        }
        ag agVar = new ag(context, this.isX);
        AppMethodBeat.o(87208);
        return agVar;
    }

    public boolean g(Canvas canvas) {
        AppMethodBeat.i(87209);
        this.isF.draw(canvas);
        Bitmap aBo = aBo();
        if (aBo != null) {
            canvas.drawBitmap(aBo, 0.0f, (float) this.irj.getTop(), null);
        }
        AppMethodBeat.o(87209);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public List<n> aJx() {
        AppMethodBeat.i(87210);
        LinkedList linkedList = new LinkedList();
        AppMethodBeat.o(87210);
        return linkedList;
    }

    /* Access modifiers changed, original: protected|final */
    public final c aJy() {
        AppMethodBeat.i(87211);
        c cVar;
        if (this.isR != null) {
            cVar = this.isR;
            AppMethodBeat.o(87211);
            return cVar;
        }
        this.isR = new c(this.mContext);
        this.isR.a(new ai() {
            /* Access modifiers changed, original: final */
            public final void aDI() {
                AppMethodBeat.i(87159);
                u.this.aBj();
                AppMethodBeat.o(87159);
            }
        });
        cVar = this.isR;
        AppMethodBeat.o(87211);
        return cVar;
    }

    public FrameLayout aBk() {
        return this.irj;
    }

    /* Access modifiers changed, original: final */
    public final void pr(int i) {
        AppMethodBeat.i(87212);
        if (this.isY) {
            AppMethodBeat.o(87212);
            return;
        }
        if (this.isF.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.isF.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                this.isF.setLayoutParams(marginLayoutParams);
            }
        }
        AppMethodBeat.o(87212);
    }

    public final com.tencent.mm.plugin.appbrand.widget.actionbar.b getActionBar() {
        return this.isG;
    }

    public final aj aJz() {
        return this.isJ;
    }

    public ac aBf() {
        return this.isH;
    }

    public String aJA() {
        return "https://servicewechat.com/";
    }

    /* Access modifiers changed, original: protected|final */
    public final String aJB() {
        AppMethodBeat.i(87213);
        String aJA = aJA();
        if (!aJA.endsWith("/")) {
            aJA = aJA + "/";
        }
        aJA = aJA + "page-frame.html";
        AppMethodBeat.o(87213);
        return aJA;
    }

    public final com.tencent.mm.plugin.appbrand.config.a.d getPageConfig() {
        AppMethodBeat.i(87214);
        if (isRunning()) {
            com.tencent.mm.plugin.appbrand.config.a.d yR = getRuntime().getAppConfig().yR(getURL());
            AppMethodBeat.o(87214);
            return yR;
        }
        AppMethodBeat.o(87214);
        return null;
    }

    public String getURL() {
        return this.hsV;
    }

    public String aBm() {
        return this.ikx;
    }

    public boolean AA(final String str) {
        AppMethodBeat.i(87215);
        this.hsV = h.bO(str);
        this.ikx = str;
        aJC();
        if (aw.b(this.gPI, this.hsV)) {
            L(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87161);
                    if (s.av(u.this.getContentView())) {
                        u.this.getContentView().post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(87160);
                                if (!s.as(u.this.getContentView())) {
                                    com.tencent.luggage.g.d.d("MicroMsg.AppBrandPageView", "loadURL[page], PageView(%s) not laid out, forceLayout", u.this.getURL());
                                    u.this.getContentView().forceLayout();
                                    ViewParent parent = u.this.getContentView().getParent();
                                    do {
                                        ((View) parent).forceLayout();
                                        parent = parent.getParent();
                                    } while (parent instanceof View);
                                    if (parent != null) {
                                        parent.requestLayout();
                                    }
                                }
                                AppMethodBeat.o(87160);
                            }
                        });
                    }
                    u.b(u.this, str);
                    AppMethodBeat.o(87161);
                }
            });
            AppMethodBeat.o(87215);
            return true;
        }
        bN(str);
        onReady();
        AppMethodBeat.o(87215);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void aJC() {
        AppMethodBeat.i(87216);
        com.tencent.mm.plugin.appbrand.config.a.d pageConfig = getPageConfig();
        AB(pageConfig.hfs);
        u(pageConfig.hfu);
        nV(g.Ee(pageConfig.hfw));
        final String str = pageConfig.hft;
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87169);
                u.this.getActionBar().setForegroundStyle(str);
                u.this.AC(str);
                AppMethodBeat.o(87169);
            }
        });
        ex(pageConfig.ayx());
        dO(pageConfig.hfA);
        bV(pageConfig.hfC, pageConfig.hfo);
        this.isQ = pageConfig.hfD;
        AppMethodBeat.o(87216);
    }

    public void a(String str, String str2, int[] iArr) {
        AppMethodBeat.i(87217);
        if (this.gPI == null) {
            com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "publish runtime is null, event %s", str);
            AppMethodBeat.o(87217);
            return;
        }
        this.gPI.xT().h(str, str2, hashCode());
        AppMethodBeat.o(87217);
    }

    public void h(final String str, final String str2, final int i) {
        AppMethodBeat.i(87218);
        L(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87162);
                u.a(u.this, str, str2, i);
                AppMethodBeat.o(87162);
            }
        });
        AppMethodBeat.o(87218);
    }

    public final boolean isRunning() {
        AppMethodBeat.i(87219);
        if (this.apg && super.isRunning()) {
            AppMethodBeat.o(87219);
            return true;
        }
        AppMethodBeat.o(87219);
        return false;
    }

    public boolean isFullScreen() {
        return this.isN;
    }

    public final void cleanup() {
        AppMethodBeat.i(87220);
        super.cleanup();
        xN();
        com.tencent.mm.plugin.appbrand.jsapi.g gVar = this.iqN;
        gVar.hvU.clear();
        gVar.hvX.clear();
        gVar.hvV.clear();
        gVar.hvW.clear();
        gVar.hvY.clear();
        gVar.hvZ.clear();
        AppMethodBeat.o(87220);
    }

    /* Access modifiers changed, original: protected */
    public void xN() {
        AppMethodBeat.i(87221);
        this.isJ.destroy();
        aBf().removeAll();
        com.tencent.mm.plugin.appbrand.widget.actionbar.b bVar = this.isG;
        bVar.removeAllViews();
        bVar.getCapsuleBar().destroy();
        this.isE.removeAllViews();
        synchronized (this.ies) {
            try {
                this.ies.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87221);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(87222);
        if (al.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(87222);
            return;
        }
        getContentView().post(runnable);
        AppMethodBeat.o(87222);
    }

    public final void aJD() {
        AppMethodBeat.i(87223);
        this.isF.setActuallyVisible(true);
        AppMethodBeat.o(87223);
    }

    public final void onReady() {
        AppMethodBeat.i(87224);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87163);
                u.this.aBa();
                for (f.e onReady : u.this.iqN.hvU) {
                    onReady.onReady();
                }
                AppMethodBeat.o(87163);
            }
        });
        AppMethodBeat.o(87224);
    }

    /* Access modifiers changed, original: protected */
    public void aBa() {
        AppMethodBeat.i(87225);
        getContentView().invalidate();
        AppMethodBeat.o(87225);
    }

    public final void wU() {
        AppMethodBeat.i(87226);
        this.fCY = true;
        aBb();
        for (f.d wU : this.iqN.hvW) {
            wU.wU();
        }
        AppMethodBeat.o(87226);
    }

    /* Access modifiers changed, original: protected */
    public void aBb() {
        AppMethodBeat.i(87227);
        this.isJ.wU();
        aJH();
        aJL();
        this.isT.aAS();
        this.isU.aAS();
        if (this.isG.aOI()) {
            a.b(this);
            this.isG.getCapsuleBar().resume();
        }
        xP();
        this.isJ.setTitle(Df("VISIBLE"));
        if (getContentView() != null) {
            this.ico = com.tencent.mm.plugin.appbrand.widget.input.n.cI(getContentView());
            if (this.ico != null) {
                this.ico.a(this.icp);
            }
        }
        AppMethodBeat.o(87227);
    }

    public final void wW() {
        AppMethodBeat.i(87228);
        this.fCY = false;
        aBc();
        for (com.tencent.mm.plugin.appbrand.jsapi.f.b wW : this.iqN.hvV) {
            wW.wW();
        }
        AppMethodBeat.o(87228);
    }

    /* Access modifiers changed, original: protected */
    public void aBc() {
        AppMethodBeat.i(87229);
        this.isJ.wW();
        this.isJ.setTitle(Df("INVISIBLE"));
        this.isR.aIZ();
        this.isF.setActuallyVisible(false);
        this.isU.aAT();
        this.isG.getCapsuleBar().pause();
        if (this.ico != null) {
            this.ico.b(this.icp);
        }
        AppMethodBeat.o(87229);
    }

    public boolean wY() {
        AppMethodBeat.i(87230);
        if (this.isR.aIZ()) {
            AppMethodBeat.o(87230);
            return true;
        }
        boolean z = false;
        Iterator it = this.iqN.hvY.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                AppMethodBeat.o(87230);
                return z2;
            } else if (((com.tencent.mm.plugin.appbrand.jsapi.f.a) it.next()).wY()) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public final void onDestroy() {
        AppMethodBeat.i(87231);
        aBd();
        for (f.c onDestroy : this.iqN.hvX) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.o(87231);
    }

    /* Access modifiers changed, original: protected */
    public void aBd() {
        AppMethodBeat.i(87232);
        this.apg = false;
        if (this.irj != null) {
            ViewTreeObserver viewTreeObserver = this.irj.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.isV);
            }
        }
        AppMethodBeat.o(87232);
    }

    public final void aJE() {
        AppMethodBeat.i(87233);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87164);
                u.a(u.this, false);
                u.this.getActionBar().setFullscreenMode(false);
                AppMethodBeat.o(87164);
            }
        });
        AppMethodBeat.o(87233);
    }

    public final void aJF() {
        AppMethodBeat.i(87234);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87165);
                u.a(u.this, true);
                u.this.getActionBar().setFullscreenMode(true);
                AppMethodBeat.o(87165);
            }
        });
        AppMethodBeat.o(87234);
    }

    public final void u(final double d) {
        AppMethodBeat.i(87235);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87166);
                u.this.getActionBar().setBackgroundAlpha(d);
                AppMethodBeat.o(87166);
            }
        });
        AppMethodBeat.o(87235);
    }

    public void nV(final int i) {
        AppMethodBeat.i(87236);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87167);
                u.this.getActionBar().setBackgroundColor(i);
                AppMethodBeat.o(87167);
            }
        });
        AppMethodBeat.o(87236);
    }

    public void AB(final String str) {
        AppMethodBeat.i(87237);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87168);
                u.this.getActionBar().setMainTitle(str);
                AppMethodBeat.o(87168);
            }
        });
        AppMethodBeat.o(87237);
    }

    public void nW(final int i) {
        AppMethodBeat.i(87239);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87171);
                u.this.getActionBar().setForegroundColor(i);
                AppMethodBeat.o(87171);
            }
        });
        AppMethodBeat.o(87239);
    }

    public void dN(final boolean z) {
        AppMethodBeat.i(87240);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87172);
                u.this.getActionBar().setLoadingIconVisibility(z);
                AppMethodBeat.o(87172);
            }
        });
        AppMethodBeat.o(87240);
    }

    public void ew(final boolean z) {
        AppMethodBeat.i(87241);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87173);
                u.this.getActionBar().eP(z);
                AppMethodBeat.o(87173);
            }
        });
        AppMethodBeat.o(87241);
    }

    private void ex(boolean z) {
        AppMethodBeat.i(87242);
        this.isY = z;
        LayoutParams layoutParams = this.isF.getLayoutParams();
        LayoutParams layoutParams2 = this.irj.getLayoutParams();
        if ((layoutParams instanceof RelativeLayout.LayoutParams) && (layoutParams2 instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(10);
            if (z) {
                ((RelativeLayout.LayoutParams) layoutParams2).removeRule(3);
            } else {
                ((RelativeLayout.LayoutParams) layoutParams2).addRule(3, isC);
            }
            this.isE.requestLayout();
            this.isG.setFullscreenMode(this.isY);
            AppMethodBeat.o(87242);
            return;
        }
        AppMethodBeat.o(87242);
    }

    public void aBh() {
        AppMethodBeat.i(87243);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87174);
                u.this.isK.dO(true);
                u.this.isK.aKa();
                AppMethodBeat.o(87174);
            }
        });
        AppMethodBeat.o(87243);
    }

    public void aBi() {
        AppMethodBeat.i(87244);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87175);
                u.this.isK.aKe();
                AppMethodBeat.o(87175);
            }
        });
        AppMethodBeat.o(87244);
    }

    public void dO(final boolean z) {
        AppMethodBeat.i(87245);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87176);
                u.this.isK.setPullDownEnabled(z);
                u.this.isK.dO(z);
                AppMethodBeat.o(87176);
            }
        });
        AppMethodBeat.o(87245);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJG() {
        AppMethodBeat.i(87246);
        runOnUiThread(new Runnable() {
            final /* synthetic */ boolean ith = false;

            public final void run() {
                AppMethodBeat.i(87177);
                u.this.isK.setPullDownEnabled(this.ith);
                AppMethodBeat.o(87177);
            }
        });
        AppMethodBeat.o(87246);
    }

    public void bV(final String str, final String str2) {
        AppMethodBeat.i(87247);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87178);
                int bx = w.bx(str2, -1);
                u.this.isK.bq(str, bx);
                u.this.isE.setBackgroundColor(bx);
                AppMethodBeat.o(87178);
            }
        });
        AppMethodBeat.o(87247);
    }

    public final void H(int i, boolean z) {
        AppMethodBeat.i(87248);
        for (n nVar : this.irD) {
            if (nVar != null && nVar.id == i) {
                nVar.imK = z;
                AppMethodBeat.o(87248);
                return;
            }
        }
        AppMethodBeat.o(87248);
    }

    public final n ps(int i) {
        AppMethodBeat.i(87249);
        for (n nVar : this.irD) {
            if (nVar != null && nVar.id == i) {
                AppMethodBeat.o(87249);
                return nVar;
            }
        }
        AppMethodBeat.o(87249);
        return null;
    }

    public void aBj() {
        AppMethodBeat.i(87250);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87179);
                u.this.isF.aOO();
                AppMethodBeat.o(87179);
            }
        });
        AppMethodBeat.o(87250);
    }

    public void AC(final String str) {
        AppMethodBeat.i(87251);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87180);
                u.this.isF.setStatusBarForegroundStyle(com.tencent.mm.plugin.appbrand.page.a.d.a.Dk(str) == com.tencent.mm.plugin.appbrand.page.a.d.a.BLACK);
                AppMethodBeat.o(87180);
            }
        });
        AppMethodBeat.o(87251);
    }

    /* Access modifiers changed, original: protected */
    public void De(String str) {
    }

    /* Access modifiers changed, original: protected */
    public void bN(String str) {
    }

    private String Df(String str) {
        AppMethodBeat.i(87252);
        String str2 = getAppId() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + getURL() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str;
        AppMethodBeat.o(87252);
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public void aJH() {
        AppMethodBeat.i(87253);
        aJI();
        AppMethodBeat.o(87253);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJJ() {
        AppMethodBeat.i(87255);
        if (this.gPI.asV().getPageCount() == 1) {
            this.isG.setNavHidden(true);
            AppMethodBeat.o(87255);
            return;
        }
        this.isG.setNavHidden(false);
        this.isG.setNavBackOrClose(true);
        AppMethodBeat.o(87255);
    }

    public final void Dg(final String str) {
        AppMethodBeat.i(87256);
        com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "updatePageOrientation appId[%s], url[%s], orientation[%s]", getAppId(), getURL(), str);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(87256);
            return;
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87183);
                u.this.isQ = str;
                if (u.this.fCY) {
                    u.o(u.this);
                }
                AppMethodBeat.o(87183);
            }
        });
        AppMethodBeat.o(87256);
    }

    private void aJL() {
        AppMethodBeat.i(87258);
        String bc = bo.bc(this.isQ, "portrait");
        int i = -1;
        switch (bc.hashCode()) {
            case -2022952606:
                if (bc.equals("landscapeLeft")) {
                    i = 3;
                    break;
                }
                break;
            case 3005871:
                if (bc.equals("auto")) {
                    i = 0;
                    break;
                }
                break;
            case 729267099:
                if (bc.equals("portrait")) {
                    i = 2;
                    break;
                }
                break;
            case 1430647483:
                if (bc.equals("landscape")) {
                    i = 1;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this.mContext).a(com.tencent.mm.plugin.appbrand.config.a.a.b.UNSPECIFIED, null);
                AppMethodBeat.o(87258);
                return;
            case 1:
                com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this.mContext).a(com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED, null);
                AppMethodBeat.o(87258);
                return;
            case 2:
                com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this.mContext).a(com.tencent.mm.plugin.appbrand.config.a.a.b.PORTRAIT, null);
                AppMethodBeat.o(87258);
                return;
            case 3:
                com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this.mContext).a(com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT, null);
                AppMethodBeat.o(87258);
                return;
            default:
                String format = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[]{getAppId(), getURL(), this.isQ});
                if (this.gNV) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(format);
                    AppMethodBeat.o(87258);
                    throw illegalArgumentException;
                }
                com.tencent.luggage.g.d.e("MicroMsg.AppBrandPageView", format);
                AppMethodBeat.o(87258);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean xP() {
        AppMethodBeat.i(87259);
        if (this.isJ.aAN()) {
            this.isL = false;
            this.isM = false;
            com.tencent.luggage.g.d.i("MicroMsg.AppBrandPageView", "[wxa_reload]reload page %s %s", getAppId(), this.ikx);
            aJN();
            AA(this.ikx);
            L(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(87184);
                    k kVar = new k();
                    u uVar = u.this;
                    q xT = u.this.gPI.xT();
                    HashMap hashMap = new HashMap();
                    hashMap.put("path", uVar.getURL());
                    kVar.t(hashMap).b(xT, uVar.hashCode()).aCj();
                    AppMethodBeat.o(87184);
                }
            });
            AppMethodBeat.o(87259);
            return true;
        }
        AppMethodBeat.o(87259);
        return false;
    }

    public final void Dh(String str) {
        AppMethodBeat.i(87260);
        if (str.equalsIgnoreCase("dark")) {
            this.isO = true;
            AppMethodBeat.o(87260);
            return;
        }
        this.isO = false;
        AppMethodBeat.o(87260);
    }

    public View aBl() {
        AppMethodBeat.i(87261);
        if (TextUtils.isEmpty(this.isP)) {
            AppMethodBeat.o(87261);
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.e9, null);
        ((TextView) inflate.findViewById(R.id.yb)).setText(this.isP);
        AppMethodBeat.o(87261);
        return inflate;
    }

    public final void z(CharSequence charSequence) {
        this.isP = charSequence;
    }

    public <T> T a(int i, Bundle bundle, Object... objArr) {
        return null;
    }

    public final void aJM() {
        AppMethodBeat.i(87262);
        this.isM = true;
        LinkedList linkedList = new LinkedList();
        synchronized (this.ies) {
            try {
                linkedList.addAll(this.ies);
                this.ies.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87262);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final boolean atU() {
        AppMethodBeat.i(87263);
        if (getRuntime() == null) {
            AppMethodBeat.o(87263);
            return true;
        }
        AppMethodBeat.o(87263);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void atV() {
    }

    private void aJN() {
        AppMethodBeat.i(87264);
        aJO();
        L(new Runnable() {
            public final void run() {
                AppMethodBeat.i(87186);
                u.this.q(u.this.xW());
                u.p(u.this);
                u.this.onCreate();
                u.this.h("onWxConfigReady", "", 0);
                AppMethodBeat.o(87186);
            }
        });
        AppMethodBeat.o(87264);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
    }

    private void aJO() {
        AppMethodBeat.i(87265);
        if (this.isL) {
            AppMethodBeat.o(87265);
            return;
        }
        this.isL = true;
        String aJP = aJP();
        if (!TextUtils.isEmpty(aJP)) {
            this.isJ.bU(aJB(), aJP);
        }
        AppMethodBeat.o(87265);
    }

    /* Access modifiers changed, original: protected */
    public String aJP() {
        return "<html></html>";
    }

    private void L(Runnable runnable) {
        AppMethodBeat.i(87266);
        synchronized (this.ies) {
            try {
                if (this.isM) {
                    runnable.run();
                } else {
                    this.ies.offer(runnable);
                    AppMethodBeat.o(87266);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(87266);
            }
        }
    }

    public final JSONObject xW() {
        AppMethodBeat.i(87267);
        JSONObject xW = getRuntime().xT().xW();
        AppMethodBeat.o(87267);
        return xW;
    }

    /* Access modifiers changed, original: protected */
    public am cG(Context context) {
        return am.iuX;
    }

    public final String auc() {
        return "AppBrandPageView";
    }

    public final ad aJw() {
        if (this.mContext instanceof ad) {
            return (ad) this.mContext;
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void initActionBar() {
        AppMethodBeat.i(87206);
        this.isG = (com.tencent.mm.plugin.appbrand.widget.actionbar.b) this.irO.b(this.mContext, com.tencent.mm.plugin.appbrand.widget.actionbar.b.class);
        this.isG.getActionView().setId(this.isD);
        this.isG.setBackButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(87187);
                if (!u.this.wY()) {
                    u.this.gPI.asV().aAU();
                }
                AppMethodBeat.o(87187);
            }
        });
        this.isG.setCloseButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(87188);
                com.tencent.mm.plugin.appbrand.g.a(u.this.getAppId(), com.tencent.mm.plugin.appbrand.g.d.CLOSE);
                u.this.gPI.close();
                AppMethodBeat.o(87188);
            }
        });
        this.isG.a(new com.tencent.mm.plugin.appbrand.widget.actionbar.a() {
            public final void aGw() {
                AppMethodBeat.i(87189);
                u.this.isJ.aAM();
                l.c(u.this);
                AppMethodBeat.o(87189);
            }
        });
        this.isG.setOptionButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i;
                AppMethodBeat.i(87191);
                boolean az = com.tencent.luggage.g.f.az(u.this.mContext);
                AnonymousClass1 anonymousClass1 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87190);
                        u.this.aL(u.this.irD);
                        AppMethodBeat.o(87190);
                    }
                };
                if (az) {
                    i = 100;
                } else {
                    i = 0;
                }
                al.n(anonymousClass1, (long) i);
                AppMethodBeat.o(87191);
            }
        });
        this.isG.aOJ();
        this.isF = new d(this.mContext);
        this.isF.setId(isC);
        this.isF.setActuallyVisible(false);
        this.isF.setDeferStatusBarHeightChange(false);
        this.isF.addView(this.isG, new LayoutParams(-1, -1));
        AppMethodBeat.o(87206);
    }

    public String aBg() {
        AppMethodBeat.i(87238);
        CharSequence mainTitle = this.isG.getMainTitle();
        String charSequence;
        if (mainTitle != null) {
            charSequence = mainTitle.toString();
            AppMethodBeat.o(87238);
            return charSequence;
        }
        charSequence = "";
        AppMethodBeat.o(87238);
        return charSequence;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJI() {
        AppMethodBeat.i(87254);
        this.isG.setNavHidden(false);
        this.isG.setNavBackOrClose(true);
        AppMethodBeat.o(87254);
    }

    /* Access modifiers changed, original: protected */
    public boolean aJK() {
        AppMethodBeat.i(87257);
        if (this.mContext instanceof Activity) {
            com.tencent.mm.plugin.appbrand.config.a.a.b dI = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this.mContext).dI(com.tencent.mm.plugin.appbrand.config.a.a.ayQ());
            com.tencent.mm.plugin.appbrand.config.a.a.b yV = com.tencent.mm.plugin.appbrand.config.a.a.yV(this.isQ);
            if (com.tencent.mm.plugin.appbrand.config.a.a.b.UNSPECIFIED == yV) {
                AppMethodBeat.o(87257);
                return false;
            }
            if (yV == null) {
                yV = com.tencent.mm.plugin.appbrand.config.a.a.b.PORTRAIT;
            }
            if (dI.c(yV)) {
                AppMethodBeat.o(87257);
                return false;
            }
            AppMethodBeat.o(87257);
            return true;
        }
        AppMethodBeat.o(87257);
        return false;
    }

    public final boolean aJQ() {
        AppMethodBeat.i(87268);
        com.tencent.mm.plugin.appbrand.config.a.a.b dI = com.tencent.mm.plugin.appbrand.config.a.a.t((Activity) this.mContext).dI(com.tencent.mm.plugin.appbrand.config.a.a.ayQ());
        if (dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_SENSOR || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LOCKED || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_LEFT || dI == com.tencent.mm.plugin.appbrand.config.a.a.b.LANDSCAPE_RIGHT) {
            AppMethodBeat.o(87268);
            return true;
        }
        AppMethodBeat.o(87268);
        return false;
    }

    public Bitmap aBo() {
        AppMethodBeat.i(87269);
        Bitmap cq = as.cq(this.isJ.getWrapperView());
        if (cq != null) {
            as.a(aAY(), new Canvas(cq));
        }
        AppMethodBeat.o(87269);
        return cq;
    }

    public final /* synthetic */ com.tencent.mm.plugin.appbrand.h.i aua() {
        AppMethodBeat.i(87270);
        this.isJ = cF(this.mContext);
        this.isJ.addJavascriptInterface(new b(this, (byte) 0), "__deviceInfo");
        aj ajVar = this.isJ;
        AppMethodBeat.o(87270);
        return ajVar;
    }

    static /* synthetic */ void b(u uVar, final String str) {
        AppMethodBeat.i(87271);
        String a = aw.a(uVar.gPI, h.bO(str));
        if (bo.isNullOrNil(a)) {
            com.tencent.luggage.g.d.e("MicroMsg.AppBrandPageView", "Empty page content, abort inject");
            AppMethodBeat.o(87271);
            return;
        }
        uVar.De(str);
        if (uVar.isJ.aAP()) {
            String str2;
            int indexOf = a.indexOf("<style>");
            int indexOf2 = a.indexOf("</style>");
            if (indexOf == -1 || indexOf2 == (-indexOf)) {
                str2 = "";
            } else {
                str2 = a.substring(indexOf + 7, indexOf2);
            }
            String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
            indexOf = a.indexOf("<page>");
            int indexOf3 = a.indexOf("</page>");
            if (indexOf == -1 || indexOf3 == (-indexOf)) {
                str2 = "";
            } else {
                str2 = a.substring(indexOf + 6, indexOf3);
            }
            str2 = Base64.encodeToString(str2.getBytes(), 2);
            a = v.Di(a);
            uVar.aBx().evaluateJavascript(String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", new Object[]{encodeToString, str2, a}), new ValueCallback<String>() {
                public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                }
            });
        }
        AppMethodBeat.o(87271);
    }

    static /* synthetic */ void p(u uVar) {
        AppMethodBeat.i(87275);
        Context context = uVar.mContext == null ? ah.getContext() : uVar.mContext;
        JSONObject jSONObject = new JSONObject();
        uVar.b(jSONObject, "width", Float.valueOf(((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density));
        uVar.b(jSONObject, "pixelRatio", Float.valueOf(context.getResources().getDisplayMetrics().density));
        uVar.aBx().evaluateJavascript(String.format("var __deviceInfo__ = %s;", new Object[]{jSONObject.toString()}), null);
        AppMethodBeat.o(87275);
    }
}

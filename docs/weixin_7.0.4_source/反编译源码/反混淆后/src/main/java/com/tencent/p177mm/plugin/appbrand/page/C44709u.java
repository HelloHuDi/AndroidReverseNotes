package com.tencent.p177mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.p057v4.view.C0477s;
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
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.luggage.p147g.C8873f;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C33131d;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33326g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10378a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C45595e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45628v;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.plugin.appbrand.p297h.C6747i;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.plugin.appbrand.page.C33467al.C31329a;
import com.tencent.p177mm.plugin.appbrand.page.C33481y.C33482a;
import com.tencent.p177mm.plugin.appbrand.page.C33481y.C33484b;
import com.tencent.p177mm.plugin.appbrand.page.C45663ac.C33466b;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C27217d.C10657a;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c.C19626a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C27354a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C38570d;
import com.tencent.p177mm.plugin.appbrand.widget.input.C2559ad;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38606u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38606u.C11042c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;
import com.tencent.p177mm.plugin.appbrand.widget.p1236f.C42728b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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
/* renamed from: com.tencent.mm.plugin.appbrand.page.u */
public class C44709u extends C42645b implements C33303e, C19625ar {
    protected static final int isC = 2131820549;
    private volatile boolean apg = false;
    private volatile boolean fCY = false;
    public volatile boolean gPH = false;
    private volatile C6750i gPI;
    private String hsV;
    private C38606u ico = null;
    private final C11042c icp = new C24211();
    private final ConcurrentLinkedQueue<Runnable> ies = new ConcurrentLinkedQueue();
    private String ikx;
    protected List<C42636n> irD;
    protected C2410ap irO = null;
    private FrameLayout irj;
    protected int isD = 2131820548;
    private RelativeLayout isE;
    protected C38570d isF;
    protected C10933b isG;
    private C45663ac isH;
    private C33467al isI;
    protected C27221aj isJ;
    public C33481y isK;
    private volatile boolean isL = false;
    private volatile boolean isM = false;
    private boolean isN = false;
    public boolean isO = false;
    protected CharSequence isP = null;
    public String isQ = null;
    private C38464c isR;
    public final C42728b isS = new C42728b(this);
    public C19627c isT;
    C38461am isU;
    private OnGlobalLayoutListener isV;
    private C19640n isW;
    C38458ab isX = new C38458ab(this);
    private boolean isY = false;
    public Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$19 */
    class C242019 implements Runnable {
        final /* synthetic */ boolean ith = false;

        C242019() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87177);
            C44709u.this.isK.setPullDownEnabled(this.ith);
            AppMethodBeat.m2505o(87177);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$1 */
    class C24211 implements C11042c {
        private int ict = 0;
        private final C45628v isZ = new C45628v();

        C24211() {
            AppMethodBeat.m2504i(87157);
            AppMethodBeat.m2505o(87157);
        }

        /* renamed from: oD */
        public final void mo6334oD(int i) {
            this.ict = i;
        }

        /* renamed from: et */
        public final void mo6332et(boolean z) {
            AppMethodBeat.m2504i(87158);
            this.isZ.mo73408a(z ? this.ict : 0, C44709u.this.mo44926xT(), C44709u.this, null);
            AppMethodBeat.m2505o(87158);
        }

        public final int getHeight() {
            return this.ict;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$2 */
    class C24222 extends C19623ai {
        C24222() {
        }

        /* Access modifiers changed, original: final */
        public final void aDI() {
            AppMethodBeat.m2504i(87159);
            C44709u.this.aBj();
            AppMethodBeat.m2505o(87159);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$12 */
    class C1067212 implements C38460ak {
        C1067212() {
        }

        /* renamed from: a */
        public final void mo22214a(AppBrandPageFullScreenView appBrandPageFullScreenView) {
            AppMethodBeat.m2504i(138231);
            if (C44709u.this.isW == null) {
                C45124d.m82927e("MicroMsg.AppBrandPageView", "mContainerPage is null, check time sequence, err");
                AppMethodBeat.m2505o(138231);
                return;
            }
            C44709u.this.isW.mo34866a(C44709u.this, appBrandPageFullScreenView);
            AppMethodBeat.m2505o(138231);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$23 */
    class C1965323 implements OnLayoutChangeListener {
        C1965323() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(87182);
            if (TextUtils.isEmpty(C44709u.this.getURL())) {
                AppMethodBeat.m2505o(87182);
            } else if (C44709u.this.apg) {
                C45124d.m82930i("MicroMsg.AppBrandPageView", "pageArea onLayoutChange appId[%s], url[%s]", C44709u.this.getAppId(), C44709u.this.getURL());
                if (C44709u.this.mo44926xT() == null) {
                    AppMethodBeat.m2505o(87182);
                    return;
                }
                C44709u.this.isU.aJW();
                AppMethodBeat.m2505o(87182);
            } else {
                try {
                    C44709u.this.aBk().removeOnLayoutChangeListener(this);
                    AppMethodBeat.m2505o(87182);
                } catch (ConcurrentModificationException e) {
                    C44709u.this.mo68076f(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(87181);
                            C44709u.this.aBk().removeOnLayoutChangeListener(this);
                            AppMethodBeat.m2505o(87181);
                        }
                    });
                    AppMethodBeat.m2505o(87182);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$31 */
    class C1965531 implements C27354a {
        C1965531() {
        }

        public final void aGw() {
            AppMethodBeat.m2504i(87189);
            C44709u.this.isJ.aAM();
            C42649l.m75524c(C44709u.this);
            AppMethodBeat.m2505o(87189);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$25 */
    class C2723725 implements Runnable {
        C2723725() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87184);
            C42648k c42648k = new C42648k();
            C44709u c44709u = C44709u.this;
            C38492q xT = C44709u.this.gPI.mo15032xT();
            HashMap hashMap = new HashMap();
            hashMap.put("path", c44709u.getURL());
            c42648k.mo34958t(hashMap).mo61030b(xT, c44709u.hashCode()).aCj();
            AppMethodBeat.m2505o(87184);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$26 */
    class C2723826 implements Runnable {
        C2723826() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87185);
            C44709u.this.mo21958q(C44709u.this.aue());
            C44709u.m81369p(C44709u.this);
            C44709u.this.atV();
            AppMethodBeat.m2505o(87185);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$30 */
    class C2723930 implements OnClickListener {
        C2723930() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(87188);
            C33183g.m54275a(C44709u.this.getAppId(), C33184d.CLOSE);
            C44709u.this.gPI.close();
            AppMethodBeat.m2505o(87188);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$16 */
    class C3347816 implements Runnable {
        C3347816() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87174);
            C44709u.this.isK.mo53966dO(true);
            C44709u.this.isK.aKa();
            AppMethodBeat.m2505o(87174);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$5 */
    class C334795 implements Runnable {
        C334795() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87163);
            C44709u.this.aBa();
            for (C45595e onReady : C44709u.this.iqN.hvU) {
                onReady.onReady();
            }
            AppMethodBeat.m2505o(87163);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$b */
    class C33480b {
        private C33480b() {
        }

        /* synthetic */ C33480b(C44709u c44709u, byte b) {
            this();
        }

        @JavascriptInterface
        public final float getPixelRatio() {
            AppMethodBeat.m2504i(87196);
            float f = C44709u.this.mContext.getResources().getDisplayMetrics().density;
            AppMethodBeat.m2505o(87196);
            return f;
        }

        @JavascriptInterface
        public final float getWidth() {
            AppMethodBeat.m2504i(87197);
            C45124d.m82930i("MicroMsg.AppBrandPageView", "DeviceInfoForSDK.getWidth %d", Integer.valueOf(C44709u.this.getContentView().getWidth()));
            float pixelRatio = ((float) C44709u.this.mContext.getResources().getDisplayMetrics().widthPixels) / getPixelRatio();
            AppMethodBeat.m2505o(87197);
            return pixelRatio;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$27 */
    class C3847727 implements Runnable {
        C3847727() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87186);
            C44709u.this.mo21958q(C44709u.this.mo21959xW());
            C44709u.m81369p(C44709u.this);
            C44709u.this.onCreate();
            C44709u.this.mo51255h("onWxConfigReady", "", 0);
            AppMethodBeat.m2505o(87186);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$29 */
    class C3847829 implements OnClickListener {
        C3847829() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(87187);
            if (!C44709u.this.mo53753wY()) {
                C44709u.this.gPI.asV().aAU();
            }
            AppMethodBeat.m2505o(87187);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$6 */
    class C384796 implements Runnable {
        C384796() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87164);
            C44709u.m81355a(C44709u.this, false);
            C44709u.this.getActionBar().setFullscreenMode(false);
            AppMethodBeat.m2505o(87164);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$a */
    class C38481a extends RelativeLayout implements C19625ar {
        public C38481a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onDetachedFromWindow() {
            AppMethodBeat.m2504i(87194);
            super.onDetachedFromWindow();
            if (C44709u.this.isH != null) {
                C45663ac f = C44709u.this.isH;
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                obtain.setSource(4098);
                for (C33466b c33466b : f.iut) {
                    View view = (View) c33466b.iuM.get();
                    if (view != null) {
                        view.dispatchTouchEvent(obtain);
                    }
                }
                obtain.recycle();
            }
            AppMethodBeat.m2505o(87194);
        }

        /* renamed from: g */
        public final boolean mo22183g(Canvas canvas) {
            AppMethodBeat.m2504i(87195);
            boolean g = C44709u.this.mo22183g(canvas);
            AppMethodBeat.m2505o(87195);
            return g;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$33 */
    class C4124833 implements C33482a {
        C4124833() {
        }

        public final void aJR() {
            AppMethodBeat.m2504i(87192);
            C44709u.this.mo6109a("onPullDownRefresh", null, null);
            AppMethodBeat.m2505o(87192);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$34 */
    class C4470834 implements C33484b {
        C4470834() {
        }

        /* renamed from: nT */
        public final void mo21652nT(int i) {
            AppMethodBeat.m2504i(87193);
            C44709u.this.isI.mo21652nT(i);
            AppMethodBeat.m2505o(87193);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$17 */
    class C4471017 implements Runnable {
        C4471017() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87175);
            C44709u.this.isK.aKe();
            AppMethodBeat.m2505o(87175);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$21 */
    class C4471121 implements Runnable {
        C4471121() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87179);
            C44709u.this.isF.aOO();
            AppMethodBeat.m2505o(87179);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$32 */
    class C4471332 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.page.u$32$1 */
        class C106741 implements Runnable {
            C106741() {
            }

            public final void run() {
                AppMethodBeat.m2504i(87190);
                C44709u.this.mo44911aL(C44709u.this.irD);
                AppMethodBeat.m2505o(87190);
            }
        }

        C4471332() {
        }

        public final void onClick(View view) {
            int i;
            AppMethodBeat.m2504i(87191);
            boolean az = C8873f.m15846az(C44709u.this.mContext);
            C106741 c106741 = new C106741();
            if (az) {
                i = 100;
            } else {
                i = 0;
            }
            C5004al.m7442n(c106741, (long) i);
            AppMethodBeat.m2505o(87191);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.u$7 */
    class C447147 implements Runnable {
        C447147() {
        }

        public final void run() {
            AppMethodBeat.m2504i(87165);
            C44709u.m81355a(C44709u.this, true);
            C44709u.this.getActionBar().setFullscreenMode(true);
            AppMethodBeat.m2505o(87165);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m81354a(C44709u c44709u, String str, String str2, int i) {
        AppMethodBeat.m2504i(87272);
        super.mo51255h(str, str2, i);
        AppMethodBeat.m2505o(87272);
    }

    /* renamed from: o */
    static /* synthetic */ void m81368o(C44709u c44709u) {
        AppMethodBeat.m2504i(87274);
        c44709u.aJL();
        AppMethodBeat.m2505o(87274);
    }

    public final boolean aJt() {
        return this.fCY;
    }

    public C44709u() {
        AppMethodBeat.m2504i(87198);
        AppMethodBeat.m2505o(87198);
    }

    /* renamed from: a */
    public void mo44895a(Context context, C6750i c6750i) {
        AppMethodBeat.m2504i(87199);
        this.mContext = context;
        this.gPI = c6750i;
        this.apg = true;
        this.irD = aJx();
        mo53812e(c6750i.gNI);
        super.init();
        initView();
        aJN();
        this.isU = mo44916cG(this.mContext);
        this.isT = aBq();
        AppMethodBeat.m2505o(87199);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: k */
    public final void mo71765k(C19640n c19640n) {
        AppMethodBeat.m2504i(138232);
        this.isW = c19640n;
        aJu();
        AppMethodBeat.m2505o(138232);
    }

    private void aJu() {
        AppMethodBeat.m2504i(138233);
        if (this.isH == null) {
            C45124d.m82927e("MicroMsg.AppBrandPageView", "mCustomViewContainer is null, err, return");
            AppMethodBeat.m2505o(138233);
            return;
        }
        this.isH.mo73440a(new C1067212());
        AppMethodBeat.m2505o(138233);
    }

    public final C19640n aJv() {
        return this.isW;
    }

    /* renamed from: Dw */
    public final void mo71746Dw() {
        AppMethodBeat.m2504i(87200);
        aCd();
        this.gPH = true;
        aJO();
        m81353L(new C2723826());
        AppMethodBeat.m2505o(87200);
    }

    /* Access modifiers changed, original: protected */
    public C19627c aBq() {
        AppMethodBeat.m2504i(87201);
        C19627c r = C19626a.m30426r(this);
        AppMethodBeat.m2505o(87201);
        return r;
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        AppMethodBeat.m2504i(87202);
        initActionBar();
        if (this.isJ == null) {
            aCd();
        }
        this.isJ.mo22182cE(this.mContext);
        this.isJ.setFullscreenImpl(aJy());
        this.isK = new C33481y(this.mContext, this.isJ);
        this.isK.setOnPullDownListener(new C4124833());
        this.isK.setOnPullDownOffsetListener(new C4470834());
        this.irj = new FrameLayout(this.mContext);
        this.irj.setId(2131820567);
        this.irj.addView(this.isK);
        C33481y c33481y = this.isK;
        C33467al q = ((C31329a) C37384e.m62985B(C31329a.class)).mo51293q(this);
        this.isI = q;
        c33481y.addView(q.getContainer());
        this.isK.setOnPullDownOffsetListener(this.isI);
        this.isJ.setOnScrollChangedListener(this.isI);
        this.isJ.setWebViewLayoutListener(this.isI);
        this.isI.setupWebViewTouchInterceptor(this.isJ);
        this.isE = new C38481a(this.mContext);
        this.isE.setLayoutParams(new LayoutParams(-1, -1));
        this.isE.addView(this.irj, new LayoutParams(-1, -1));
        this.isE.addView(this.isF);
        this.isH = new C45663ac(this.isI.getContainer());
        this.isH.setFullscreenImpl(aJy());
        aBk().addOnLayoutChangeListener(new C1965323());
        AppMethodBeat.m2505o(87202);
    }

    public final Context getContext() {
        return this.mContext;
    }

    public Map<String, C45608m> aub() {
        AppMethodBeat.m2504i(87203);
        Map emptyMap = Collections.emptyMap();
        AppMethodBeat.m2505o(87203);
        return emptyMap;
    }

    public C6750i getRuntime() {
        return this.gPI;
    }

    /* renamed from: xT */
    public C38492q mo44926xT() {
        AppMethodBeat.m2504i(87204);
        C38492q xT = getRuntime().mo15032xT();
        AppMethodBeat.m2505o(87204);
        return xT;
    }

    public View getContentView() {
        return this.isE;
    }

    public ViewGroup aAY() {
        AppMethodBeat.m2504i(87205);
        ViewGroup container = this.isI.getContainer();
        AppMethodBeat.m2505o(87205);
        return container;
    }

    public C33467al aAX() {
        return this.isI;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aL */
    public void mo44911aL(List<C42636n> list) {
        AppMethodBeat.m2504i(87207);
        new C19643o(this, new LinkedList(this.irD)).aJm();
        AppMethodBeat.m2505o(87207);
    }

    /* renamed from: cF */
    public C27221aj mo44915cF(Context context) {
        AppMethodBeat.m2504i(87208);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C10661ag c10661ag = new C10661ag(context, this.isX);
        AppMethodBeat.m2505o(87208);
        return c10661ag;
    }

    /* renamed from: g */
    public boolean mo22183g(Canvas canvas) {
        AppMethodBeat.m2504i(87209);
        this.isF.draw(canvas);
        Bitmap aBo = aBo();
        if (aBo != null) {
            canvas.drawBitmap(aBo, 0.0f, (float) this.irj.getTop(), null);
        }
        AppMethodBeat.m2505o(87209);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public List<C42636n> aJx() {
        AppMethodBeat.m2504i(87210);
        LinkedList linkedList = new LinkedList();
        AppMethodBeat.m2505o(87210);
        return linkedList;
    }

    /* Access modifiers changed, original: protected|final */
    public final C38464c aJy() {
        AppMethodBeat.m2504i(87211);
        C38464c c38464c;
        if (this.isR != null) {
            c38464c = this.isR;
            AppMethodBeat.m2505o(87211);
            return c38464c;
        }
        this.isR = new C38464c(this.mContext);
        this.isR.mo61149a(new C24222());
        c38464c = this.isR;
        AppMethodBeat.m2505o(87211);
        return c38464c;
    }

    public FrameLayout aBk() {
        return this.irj;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pr */
    public final void mo71768pr(int i) {
        AppMethodBeat.m2504i(87212);
        if (this.isY) {
            AppMethodBeat.m2505o(87212);
            return;
        }
        if (this.isF.getLayoutParams() instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.isF.getLayoutParams();
            if (marginLayoutParams.bottomMargin != i) {
                marginLayoutParams.bottomMargin = i;
                this.isF.setLayoutParams(marginLayoutParams);
            }
        }
        AppMethodBeat.m2505o(87212);
    }

    public final C10933b getActionBar() {
        return this.isG;
    }

    public final C27221aj aJz() {
        return this.isJ;
    }

    public C45663ac aBf() {
        return this.isH;
    }

    public String aJA() {
        return "https://servicewechat.com/";
    }

    /* Access modifiers changed, original: protected|final */
    public final String aJB() {
        AppMethodBeat.m2504i(87213);
        String aJA = aJA();
        if (!aJA.endsWith("/")) {
            aJA = aJA + "/";
        }
        aJA = aJA + "page-frame.html";
        AppMethodBeat.m2505o(87213);
        return aJA;
    }

    public final C33131d getPageConfig() {
        AppMethodBeat.m2504i(87214);
        if (isRunning()) {
            C33131d yR = getRuntime().getAppConfig().mo60903yR(getURL());
            AppMethodBeat.m2505o(87214);
            return yR;
        }
        AppMethodBeat.m2505o(87214);
        return null;
    }

    public String getURL() {
        return this.hsV;
    }

    public String aBm() {
        return this.ikx;
    }

    /* renamed from: AA */
    public boolean mo44893AA(final String str) {
        AppMethodBeat.m2504i(87215);
        this.hsV = C8874h.m15847bO(str);
        this.ikx = str;
        aJC();
        if (C33082aw.m54071b(this.gPI, this.hsV)) {
            m81353L(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.appbrand.page.u$3$1 */
                class C24241 implements Runnable {
                    C24241() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(87160);
                        if (!C0477s.m927as(C44709u.this.getContentView())) {
                            C45124d.m82926d("MicroMsg.AppBrandPageView", "loadURL[page], PageView(%s) not laid out, forceLayout", C44709u.this.getURL());
                            C44709u.this.getContentView().forceLayout();
                            ViewParent parent = C44709u.this.getContentView().getParent();
                            do {
                                ((View) parent).forceLayout();
                                parent = parent.getParent();
                            } while (parent instanceof View);
                            if (parent != null) {
                                parent.requestLayout();
                            }
                        }
                        AppMethodBeat.m2505o(87160);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(87161);
                    if (C0477s.m930av(C44709u.this.getContentView())) {
                        C44709u.this.getContentView().post(new C24241());
                    }
                    C44709u.m81356b(C44709u.this, str);
                    AppMethodBeat.m2505o(87161);
                }
            });
            AppMethodBeat.m2505o(87215);
            return true;
        }
        mo44914bN(str);
        onReady();
        AppMethodBeat.m2505o(87215);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void aJC() {
        AppMethodBeat.m2504i(87216);
        C33131d pageConfig = getPageConfig();
        mo53734AB(pageConfig.hfs);
        mo71771u(pageConfig.hfu);
        mo53751nV(C42668g.m75551Ee(pageConfig.hfw));
        final String str = pageConfig.hft;
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87169);
                C44709u.this.getActionBar().setForegroundStyle(str);
                C44709u.this.mo53735AC(str);
                AppMethodBeat.m2505o(87169);
            }
        });
        m81358ex(pageConfig.ayx());
        mo53748dO(pageConfig.hfA);
        mo53746bV(pageConfig.hfC, pageConfig.hfo);
        this.isQ = pageConfig.hfD;
        AppMethodBeat.m2505o(87216);
    }

    /* renamed from: a */
    public void mo6109a(String str, String str2, int[] iArr) {
        AppMethodBeat.m2504i(87217);
        if (this.gPI == null) {
            C45124d.m82930i("MicroMsg.AppBrandPageView", "publish runtime is null, event %s", str);
            AppMethodBeat.m2505o(87217);
            return;
        }
        this.gPI.mo15032xT().mo51255h(str, str2, hashCode());
        AppMethodBeat.m2505o(87217);
    }

    /* renamed from: h */
    public void mo51255h(final String str, final String str2, final int i) {
        AppMethodBeat.m2504i(87218);
        m81353L(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87162);
                C44709u.m81354a(C44709u.this, str, str2, i);
                AppMethodBeat.m2505o(87162);
            }
        });
        AppMethodBeat.m2505o(87218);
    }

    public final boolean isRunning() {
        AppMethodBeat.m2504i(87219);
        if (this.apg && super.isRunning()) {
            AppMethodBeat.m2505o(87219);
            return true;
        }
        AppMethodBeat.m2505o(87219);
        return false;
    }

    public boolean isFullScreen() {
        return this.isN;
    }

    public final void cleanup() {
        AppMethodBeat.m2504i(87220);
        super.cleanup();
        mo44924xN();
        C33326g c33326g = this.iqN;
        c33326g.hvU.clear();
        c33326g.hvX.clear();
        c33326g.hvV.clear();
        c33326g.hvW.clear();
        c33326g.hvY.clear();
        c33326g.hvZ.clear();
        AppMethodBeat.m2505o(87220);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xN */
    public void mo44924xN() {
        AppMethodBeat.m2504i(87221);
        this.isJ.destroy();
        aBf().removeAll();
        C10933b c10933b = this.isG;
        c10933b.removeAllViews();
        c10933b.getCapsuleBar().destroy();
        this.isE.removeAllViews();
        synchronized (this.ies) {
            try {
                this.ies.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87221);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(87222);
        if (C5004al.isMainThread()) {
            runnable.run();
            AppMethodBeat.m2505o(87222);
            return;
        }
        getContentView().post(runnable);
        AppMethodBeat.m2505o(87222);
    }

    public final void aJD() {
        AppMethodBeat.m2504i(87223);
        this.isF.setActuallyVisible(true);
        AppMethodBeat.m2505o(87223);
    }

    public final void onReady() {
        AppMethodBeat.m2504i(87224);
        runOnUiThread(new C334795());
        AppMethodBeat.m2505o(87224);
    }

    /* Access modifiers changed, original: protected */
    public void aBa() {
        AppMethodBeat.m2504i(87225);
        getContentView().invalidate();
        AppMethodBeat.m2505o(87225);
    }

    /* renamed from: wU */
    public final void mo71772wU() {
        AppMethodBeat.m2504i(87226);
        this.fCY = true;
        aBb();
        for (C10381d wU : this.iqN.hvW) {
            wU.mo6095wU();
        }
        AppMethodBeat.m2505o(87226);
    }

    /* Access modifiers changed, original: protected */
    public void aBb() {
        AppMethodBeat.m2504i(87227);
        this.isJ.mo22196wU();
        aJH();
        aJL();
        this.isT.aAS();
        this.isU.aAS();
        if (this.isG.aOI()) {
            C38456a.m65056b(this);
            this.isG.getCapsuleBar().resume();
        }
        mo60249xP();
        this.isJ.setTitle(m81352Df("VISIBLE"));
        if (getContentView() != null) {
            this.ico = C42740n.m75741cI(getContentView());
            if (this.ico != null) {
                this.ico.mo61402a(this.icp);
            }
        }
        AppMethodBeat.m2505o(87227);
    }

    /* renamed from: wW */
    public final void mo71773wW() {
        AppMethodBeat.m2504i(87228);
        this.fCY = false;
        aBc();
        for (C10379b wW : this.iqN.hvV) {
            wW.mo21857wW();
        }
        AppMethodBeat.m2505o(87228);
    }

    /* Access modifiers changed, original: protected */
    public void aBc() {
        AppMethodBeat.m2504i(87229);
        this.isJ.mo22197wW();
        this.isJ.setTitle(m81352Df("INVISIBLE"));
        this.isR.aIZ();
        this.isF.setActuallyVisible(false);
        this.isU.aAT();
        this.isG.getCapsuleBar().pause();
        if (this.ico != null) {
            this.ico.mo61403b(this.icp);
        }
        AppMethodBeat.m2505o(87229);
    }

    /* renamed from: wY */
    public boolean mo53753wY() {
        AppMethodBeat.m2504i(87230);
        if (this.isR.aIZ()) {
            AppMethodBeat.m2505o(87230);
            return true;
        }
        boolean z = false;
        Iterator it = this.iqN.hvY.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                AppMethodBeat.m2505o(87230);
                return z2;
            } else if (((C10378a) it.next()).mo21856wY()) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(87231);
        aBd();
        for (C10380c onDestroy : this.iqN.hvX) {
            onDestroy.onDestroy();
        }
        AppMethodBeat.m2505o(87231);
    }

    /* Access modifiers changed, original: protected */
    public void aBd() {
        AppMethodBeat.m2504i(87232);
        this.apg = false;
        if (this.irj != null) {
            ViewTreeObserver viewTreeObserver = this.irj.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnGlobalLayoutListener(this.isV);
            }
        }
        AppMethodBeat.m2505o(87232);
    }

    public final void aJE() {
        AppMethodBeat.m2504i(87233);
        runOnUiThread(new C384796());
        AppMethodBeat.m2505o(87233);
    }

    public final void aJF() {
        AppMethodBeat.m2504i(87234);
        runOnUiThread(new C447147());
        AppMethodBeat.m2505o(87234);
    }

    /* renamed from: u */
    public final void mo71771u(final double d) {
        AppMethodBeat.m2504i(87235);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87166);
                C44709u.this.getActionBar().setBackgroundAlpha(d);
                AppMethodBeat.m2505o(87166);
            }
        });
        AppMethodBeat.m2505o(87235);
    }

    /* renamed from: nV */
    public void mo53751nV(final int i) {
        AppMethodBeat.m2504i(87236);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87167);
                C44709u.this.getActionBar().setBackgroundColor(i);
                AppMethodBeat.m2505o(87167);
            }
        });
        AppMethodBeat.m2505o(87236);
    }

    /* renamed from: AB */
    public void mo53734AB(final String str) {
        AppMethodBeat.m2504i(87237);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87168);
                C44709u.this.getActionBar().setMainTitle(str);
                AppMethodBeat.m2505o(87168);
            }
        });
        AppMethodBeat.m2505o(87237);
    }

    /* renamed from: nW */
    public void mo53752nW(final int i) {
        AppMethodBeat.m2504i(87239);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87171);
                C44709u.this.getActionBar().setForegroundColor(i);
                AppMethodBeat.m2505o(87171);
            }
        });
        AppMethodBeat.m2505o(87239);
    }

    /* renamed from: dN */
    public void mo53747dN(final boolean z) {
        AppMethodBeat.m2504i(87240);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87172);
                C44709u.this.getActionBar().setLoadingIconVisibility(z);
                AppMethodBeat.m2505o(87172);
            }
        });
        AppMethodBeat.m2505o(87240);
    }

    /* renamed from: ew */
    public void mo44917ew(final boolean z) {
        AppMethodBeat.m2504i(87241);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87173);
                C44709u.this.getActionBar().mo22482eP(z);
                AppMethodBeat.m2505o(87173);
            }
        });
        AppMethodBeat.m2505o(87241);
    }

    /* renamed from: ex */
    private void m81358ex(boolean z) {
        AppMethodBeat.m2504i(87242);
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
            AppMethodBeat.m2505o(87242);
            return;
        }
        AppMethodBeat.m2505o(87242);
    }

    public void aBh() {
        AppMethodBeat.m2504i(87243);
        runOnUiThread(new C3347816());
        AppMethodBeat.m2505o(87243);
    }

    public void aBi() {
        AppMethodBeat.m2504i(87244);
        runOnUiThread(new C4471017());
        AppMethodBeat.m2505o(87244);
    }

    /* renamed from: dO */
    public void mo53748dO(final boolean z) {
        AppMethodBeat.m2504i(87245);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87176);
                C44709u.this.isK.setPullDownEnabled(z);
                C44709u.this.isK.mo53966dO(z);
                AppMethodBeat.m2505o(87176);
            }
        });
        AppMethodBeat.m2505o(87245);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJG() {
        AppMethodBeat.m2504i(87246);
        runOnUiThread(new C242019());
        AppMethodBeat.m2505o(87246);
    }

    /* renamed from: bV */
    public void mo53746bV(final String str, final String str2) {
        AppMethodBeat.m2504i(87247);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87178);
                int bx = C10732w.m18401bx(str2, -1);
                C44709u.this.isK.mo53965bq(str, bx);
                C44709u.this.isE.setBackgroundColor(bx);
                AppMethodBeat.m2505o(87178);
            }
        });
        AppMethodBeat.m2505o(87247);
    }

    /* renamed from: H */
    public final void mo71747H(int i, boolean z) {
        AppMethodBeat.m2504i(87248);
        for (C42636n c42636n : this.irD) {
            if (c42636n != null && c42636n.f17185id == i) {
                c42636n.imK = z;
                AppMethodBeat.m2505o(87248);
                return;
            }
        }
        AppMethodBeat.m2505o(87248);
    }

    /* renamed from: ps */
    public final C42636n mo71769ps(int i) {
        AppMethodBeat.m2504i(87249);
        for (C42636n c42636n : this.irD) {
            if (c42636n != null && c42636n.f17185id == i) {
                AppMethodBeat.m2505o(87249);
                return c42636n;
            }
        }
        AppMethodBeat.m2505o(87249);
        return null;
    }

    public void aBj() {
        AppMethodBeat.m2504i(87250);
        runOnUiThread(new C4471121());
        AppMethodBeat.m2505o(87250);
    }

    /* renamed from: AC */
    public void mo53735AC(final String str) {
        AppMethodBeat.m2504i(87251);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87180);
                C44709u.this.isF.setStatusBarForegroundStyle(C10657a.m18353Dk(str) == C10657a.BLACK);
                AppMethodBeat.m2505o(87180);
            }
        });
        AppMethodBeat.m2505o(87251);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: De */
    public void mo44894De(String str) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: bN */
    public void mo44914bN(String str) {
    }

    /* renamed from: Df */
    private String m81352Df(String str) {
        AppMethodBeat.m2504i(87252);
        String str2 = getAppId() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + getURL() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str;
        AppMethodBeat.m2505o(87252);
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public void aJH() {
        AppMethodBeat.m2504i(87253);
        aJI();
        AppMethodBeat.m2505o(87253);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJJ() {
        AppMethodBeat.m2504i(87255);
        if (this.gPI.asV().getPageCount() == 1) {
            this.isG.setNavHidden(true);
            AppMethodBeat.m2505o(87255);
            return;
        }
        this.isG.setNavHidden(false);
        this.isG.setNavBackOrClose(true);
        AppMethodBeat.m2505o(87255);
    }

    /* renamed from: Dg */
    public final void mo71744Dg(final String str) {
        AppMethodBeat.m2504i(87256);
        C45124d.m82930i("MicroMsg.AppBrandPageView", "updatePageOrientation appId[%s], url[%s], orientation[%s]", getAppId(), getURL(), str);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(87256);
            return;
        }
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87183);
                C44709u.this.isQ = str;
                if (C44709u.this.fCY) {
                    C44709u.m81368o(C44709u.this);
                }
                AppMethodBeat.m2505o(87183);
            }
        });
        AppMethodBeat.m2505o(87256);
    }

    private void aJL() {
        AppMethodBeat.m2504i(87258);
        String bc = C5046bo.m7532bc(this.isQ, "portrait");
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
                C26835a.m42717t((Activity) this.mContext).mo44609a(C26839b.UNSPECIFIED, null);
                AppMethodBeat.m2505o(87258);
                return;
            case 1:
                C26835a.m42717t((Activity) this.mContext).mo44609a(C26839b.LANDSCAPE_LOCKED, null);
                AppMethodBeat.m2505o(87258);
                return;
            case 2:
                C26835a.m42717t((Activity) this.mContext).mo44609a(C26839b.PORTRAIT, null);
                AppMethodBeat.m2505o(87258);
                return;
            case 3:
                C26835a.m42717t((Activity) this.mContext).mo44609a(C26839b.LANDSCAPE_LEFT, null);
                AppMethodBeat.m2505o(87258);
                return;
            default:
                String format = String.format(Locale.US, "resetPageOrientation get invalid value, appId[%s], url[%s], orientation[%s]", new Object[]{getAppId(), getURL(), this.isQ});
                if (this.gNV) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(format);
                    AppMethodBeat.m2505o(87258);
                    throw illegalArgumentException;
                }
                C45124d.m82927e("MicroMsg.AppBrandPageView", format);
                AppMethodBeat.m2505o(87258);
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: xP */
    public boolean mo60249xP() {
        AppMethodBeat.m2504i(87259);
        if (this.isJ.aAN()) {
            this.isL = false;
            this.isM = false;
            C45124d.m82930i("MicroMsg.AppBrandPageView", "[wxa_reload]reload page %s %s", getAppId(), this.ikx);
            aJN();
            mo44893AA(this.ikx);
            m81353L(new C2723725());
            AppMethodBeat.m2505o(87259);
            return true;
        }
        AppMethodBeat.m2505o(87259);
        return false;
    }

    /* renamed from: Dh */
    public final void mo71745Dh(String str) {
        AppMethodBeat.m2504i(87260);
        if (str.equalsIgnoreCase("dark")) {
            this.isO = true;
            AppMethodBeat.m2505o(87260);
            return;
        }
        this.isO = false;
        AppMethodBeat.m2505o(87260);
    }

    public View aBl() {
        AppMethodBeat.m2504i(87261);
        if (TextUtils.isEmpty(this.isP)) {
            AppMethodBeat.m2505o(87261);
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(2130968759, null);
        ((TextView) inflate.findViewById(2131821470)).setText(this.isP);
        AppMethodBeat.m2505o(87261);
        return inflate;
    }

    /* renamed from: z */
    public final void mo71774z(CharSequence charSequence) {
        this.isP = charSequence;
    }

    /* renamed from: a */
    public <T> T mo53736a(int i, Bundle bundle, Object... objArr) {
        return null;
    }

    public final void aJM() {
        AppMethodBeat.m2504i(87262);
        this.isM = true;
        LinkedList linkedList = new LinkedList();
        synchronized (this.ies) {
            try {
                linkedList.addAll(this.ies);
                this.ies.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87262);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final boolean atU() {
        AppMethodBeat.m2504i(87263);
        if (getRuntime() == null) {
            AppMethodBeat.m2505o(87263);
            return true;
        }
        AppMethodBeat.m2505o(87263);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public void atV() {
    }

    private void aJN() {
        AppMethodBeat.m2504i(87264);
        aJO();
        m81353L(new C3847727());
        AppMethodBeat.m2505o(87264);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
    }

    private void aJO() {
        AppMethodBeat.m2504i(87265);
        if (this.isL) {
            AppMethodBeat.m2505o(87265);
            return;
        }
        this.isL = true;
        String aJP = aJP();
        if (!TextUtils.isEmpty(aJP)) {
            this.isJ.mo22181bU(aJB(), aJP);
        }
        AppMethodBeat.m2505o(87265);
    }

    /* Access modifiers changed, original: protected */
    public String aJP() {
        return "<html></html>";
    }

    /* renamed from: L */
    private void m81353L(Runnable runnable) {
        AppMethodBeat.m2504i(87266);
        synchronized (this.ies) {
            try {
                if (this.isM) {
                    runnable.run();
                } else {
                    this.ies.offer(runnable);
                    AppMethodBeat.m2505o(87266);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(87266);
            }
        }
    }

    /* renamed from: xW */
    public final JSONObject mo21959xW() {
        AppMethodBeat.m2504i(87267);
        JSONObject xW = getRuntime().mo15032xT().mo21959xW();
        AppMethodBeat.m2505o(87267);
        return xW;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cG */
    public C38461am mo44916cG(Context context) {
        return C38461am.iuX;
    }

    public final String auc() {
        return "AppBrandPageView";
    }

    public final C2559ad aJw() {
        if (this.mContext instanceof C2559ad) {
            return (C2559ad) this.mContext;
        }
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void initActionBar() {
        AppMethodBeat.m2504i(87206);
        this.isG = (C10933b) this.irO.mo6322b(this.mContext, C10933b.class);
        this.isG.getActionView().setId(this.isD);
        this.isG.setBackButtonClickListener(new C3847829());
        this.isG.setCloseButtonClickListener(new C2723930());
        this.isG.mo22478a(new C1965531());
        this.isG.setOptionButtonClickListener(new C4471332());
        this.isG.aOJ();
        this.isF = new C38570d(this.mContext);
        this.isF.setId(isC);
        this.isF.setActuallyVisible(false);
        this.isF.setDeferStatusBarHeightChange(false);
        this.isF.addView(this.isG, new LayoutParams(-1, -1));
        AppMethodBeat.m2505o(87206);
    }

    public String aBg() {
        AppMethodBeat.m2504i(87238);
        CharSequence mainTitle = this.isG.getMainTitle();
        String charSequence;
        if (mainTitle != null) {
            charSequence = mainTitle.toString();
            AppMethodBeat.m2505o(87238);
            return charSequence;
        }
        charSequence = "";
        AppMethodBeat.m2505o(87238);
        return charSequence;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJI() {
        AppMethodBeat.m2504i(87254);
        this.isG.setNavHidden(false);
        this.isG.setNavBackOrClose(true);
        AppMethodBeat.m2505o(87254);
    }

    /* Access modifiers changed, original: protected */
    public boolean aJK() {
        AppMethodBeat.m2504i(87257);
        if (this.mContext instanceof Activity) {
            C26839b dI = C26835a.m42717t((Activity) this.mContext).mo44610dI(C26835a.ayQ());
            C26839b yV = C26835a.m42719yV(this.isQ);
            if (C26839b.UNSPECIFIED == yV) {
                AppMethodBeat.m2505o(87257);
                return false;
            }
            if (yV == null) {
                yV = C26839b.PORTRAIT;
            }
            if (dI.mo44613c(yV)) {
                AppMethodBeat.m2505o(87257);
                return false;
            }
            AppMethodBeat.m2505o(87257);
            return true;
        }
        AppMethodBeat.m2505o(87257);
        return false;
    }

    public final boolean aJQ() {
        AppMethodBeat.m2504i(87268);
        C26839b dI = C26835a.m42717t((Activity) this.mContext).mo44610dI(C26835a.ayQ());
        if (dI == C26839b.LANDSCAPE_SENSOR || dI == C26839b.LANDSCAPE_LOCKED || dI == C26839b.LANDSCAPE_LEFT || dI == C26839b.LANDSCAPE_RIGHT) {
            AppMethodBeat.m2505o(87268);
            return true;
        }
        AppMethodBeat.m2505o(87268);
        return false;
    }

    public Bitmap aBo() {
        AppMethodBeat.m2504i(87269);
        Bitmap cq = C2413as.m4666cq(this.isJ.getWrapperView());
        if (cq != null) {
            C2413as.m4665a(aAY(), new Canvas(cq));
        }
        AppMethodBeat.m2505o(87269);
        return cq;
    }

    public final /* synthetic */ C6747i aua() {
        AppMethodBeat.m2504i(87270);
        this.isJ = mo44915cF(this.mContext);
        this.isJ.addJavascriptInterface(new C33480b(this, (byte) 0), "__deviceInfo");
        C27221aj c27221aj = this.isJ;
        AppMethodBeat.m2505o(87270);
        return c27221aj;
    }

    /* renamed from: b */
    static /* synthetic */ void m81356b(C44709u c44709u, final String str) {
        AppMethodBeat.m2504i(87271);
        String a = C33082aw.m54068a(c44709u.gPI, C8874h.m15847bO(str));
        if (C5046bo.isNullOrNil(a)) {
            C45124d.m82927e("MicroMsg.AppBrandPageView", "Empty page content, abort inject");
            AppMethodBeat.m2505o(87271);
            return;
        }
        c44709u.mo44894De(str);
        if (c44709u.isJ.aAP()) {
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
            a = C10675v.m18368Di(a);
            c44709u.aBx().evaluateJavascript(String.format("var style = document.createElement('style');style.innerHTML = atob(\"%s\");document.head.appendChild(style);var page = document.createElement('page');page.innerHTML = atob(\"%s\");document.body.appendChild(page);%s;", new Object[]{encodeToString, str2, a}), new ValueCallback<String>() {
                public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                }
            });
        }
        AppMethodBeat.m2505o(87271);
    }

    /* renamed from: p */
    static /* synthetic */ void m81369p(C44709u c44709u) {
        AppMethodBeat.m2504i(87275);
        Context context = c44709u.mContext == null ? C4996ah.getContext() : c44709u.mContext;
        JSONObject jSONObject = new JSONObject();
        c44709u.mo21956b(jSONObject, "width", Float.valueOf(((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density));
        c44709u.mo21956b(jSONObject, "pixelRatio", Float.valueOf(context.getResources().getDisplayMetrics().density));
        c44709u.aBx().evaluateJavascript(String.format("var __deviceInfo__ = %s;", new Object[]{jSONObject.toString()}), null);
        AppMethodBeat.m2505o(87275);
    }
}

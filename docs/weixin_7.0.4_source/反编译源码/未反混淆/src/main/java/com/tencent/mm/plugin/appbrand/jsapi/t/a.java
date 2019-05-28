package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.support.v4.widget.j;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.r;
import org.json.JSONObject;

public final class a extends FrameLayout implements com.tencent.mm.plugin.appbrand.jsapi.t.c.c {
    private int eO = 0;
    private MMFalseProgressBar fou;
    MMWebView fow;
    w hyU;
    private b icj;
    private final com.tencent.mm.plugin.appbrand.jsapi.t.c.b ick;
    private String icl = "";
    private boolean icm = true;
    boolean icn = false;
    private u ico = null;
    private final com.tencent.mm.plugin.appbrand.widget.input.u.c icp = new com.tencent.mm.plugin.appbrand.widget.input.u.c() {
        private int ict = 0;

        public final void oD(int i) {
            this.ict = i;
        }

        public final void et(boolean z) {
            AppMethodBeat.i(131631);
            a.this.ick.k(z, this.ict);
            AppMethodBeat.o(131631);
        }

        public final int getHeight() {
            return this.ict;
        }
    };
    private c icq;
    private r icr = new r() {
        public final boolean A(MotionEvent motionEvent) {
            AppMethodBeat.i(131633);
            boolean Q = a.this.fow.Q(motionEvent);
            AppMethodBeat.o(131633);
            return Q;
        }

        public final boolean b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.i(131634);
            boolean c = a.this.fow.c(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.o(131634);
            return c;
        }

        public final void aGs() {
            AppMethodBeat.i(131635);
            a.this.fow.dKK();
            AppMethodBeat.o(131635);
        }

        @TargetApi(9)
        public final void d(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.i(131636);
            a.this.fow.e(i, i2, z, z2);
            AppMethodBeat.o(131636);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.i(131637);
            a.this.fow.M(i, i2, i3, i4);
            AppMethodBeat.o(131637);
        }

        public final boolean B(MotionEvent motionEvent) {
            AppMethodBeat.i(131638);
            boolean R = a.this.fow.R(motionEvent);
            AppMethodBeat.o(131638);
            return R;
        }

        public final boolean C(MotionEvent motionEvent) {
            AppMethodBeat.i(131639);
            boolean S = a.this.fow.S(motionEvent);
            AppMethodBeat.o(131639);
            return S;
        }
    };
    private com.tencent.xweb.x5.a.a.a.a.b ics = new com.tencent.xweb.x5.a.a.a.a.b() {
        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(131640);
            boolean A = a.this.icr.A(motionEvent);
            AppMethodBeat.o(131640);
            return A;
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(131641);
            boolean C = a.this.icr.C(motionEvent);
            AppMethodBeat.o(131641);
            return C;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(131642);
            boolean B = a.this.icr.B(motionEvent);
            AppMethodBeat.o(131642);
            return B;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            AppMethodBeat.i(131643);
            boolean b = a.this.icr.b(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.o(131643);
            return b;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.i(131644);
            a.this.icr.onScrollChanged(i, i2, i3, i4, view);
            AppMethodBeat.o(131644);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            AppMethodBeat.i(131645);
            a.this.icr.d(i, i2, z, z2);
            AppMethodBeat.o(131645);
        }

        public final void computeScroll(View view) {
            AppMethodBeat.i(131646);
            a.this.icr.aGs();
            AppMethodBeat.o(131646);
        }

        public final void invalidate() {
        }
    };
    private String mAppId;

    static final class a extends p {
        public static final int CTRL_INDEX = 505;
        public static final String NAME = "onWebviewFinishLoad";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class d extends p {
        public static final int CTRL_INDEX = 506;
        public static final String NAME = "onWebviewError";

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    final class c implements com.tencent.mm.plugin.appbrand.jsapi.f.b, com.tencent.mm.plugin.appbrand.jsapi.f.d {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final void wW() {
            AppMethodBeat.i(131648);
            a.this.ick.wW();
            AppMethodBeat.o(131648);
        }

        public final void wU() {
            AppMethodBeat.i(131649);
            a.this.ick.wU();
            AppMethodBeat.o(131649);
        }
    }

    static final class b extends p {
        public static final int CTRL_INDEX = 504;
        public static final String NAME = "onWebviewStartLoad";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public a(Context context, i iVar, w wVar) {
        super(context);
        AppMethodBeat.i(131650);
        this.mAppId = iVar.mAppId;
        this.icj = new b();
        this.icj.i(wVar);
        this.hyU = wVar;
        this.fow = com.tencent.mm.plugin.webview.ui.tools.widget.f.a.uJi.du(context);
        this.fow.getSettings().dUh();
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.fow.getSettings().dUj();
        String userAgentString = this.fow.getSettings().getUserAgentString();
        if (!com.tencent.mm.pluginsdk.ui.tools.u.akj(userAgentString)) {
            userAgentString = com.tencent.mm.pluginsdk.ui.tools.u.bh(getContext(), userAgentString);
        }
        this.fow.getSettings().setUserAgentString(userAgentString + " miniProgram");
        this.fow.getView().setHorizontalScrollBarEnabled(false);
        this.fow.getView().setVerticalScrollBarEnabled(false);
        this.fow.getSettings().setBuiltInZoomControls(true);
        this.fow.getSettings().setUseWideViewPort(true);
        this.fow.getSettings().setLoadWithOverviewMode(true);
        this.fow.getSettings().dUc();
        this.fow.getSettings().dUb();
        this.fow.getSettings().setGeolocationEnabled(true);
        this.fow.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.fow.getSettings().dUf();
        this.fow.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.fow.getSettings().dUe();
        this.fow.getSettings().dUg();
        this.fow.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.eSi + "databases/");
        this.fow.setWebViewCallbackClient(this.icr);
        if (this.fow.getIsX5Kernel()) {
            this.fow.setWebViewClientExtension(this.ics);
        }
        this.fow.getSettings().setUsingForAppBrand(2);
        addView(this.fow, new LayoutParams(-1, -1));
        this.fou = new MMFalseProgressBar(context);
        this.fou.setProgressDrawable(com.tencent.mm.bz.a.g(context, R.drawable.uw));
        addView(this.fou, new LayoutParams(-1, com.tencent.mm.bz.a.fromDPToPix(context, 3)));
        this.ick = ((com.tencent.mm.plugin.appbrand.jsapi.t.c.a) e.B(com.tencent.mm.plugin.appbrand.jsapi.t.c.a.class)).a(this);
        this.hyU.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) new com.tencent.mm.plugin.appbrand.jsapi.f.c() {
            public final void onDestroy() {
                AppMethodBeat.i(131632);
                a.this.ick.cleanup();
                AppMethodBeat.o(131632);
            }
        });
        getReporter().iCA = true;
        AppMethodBeat.o(131650);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(131651);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.hyU.isK.requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
            case 3:
                this.hyU.isK.requestDisallowInterceptTouchEvent(false);
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent) {
            this.hyU.isK.requestDisallowInterceptTouchEvent(false);
        }
        AppMethodBeat.o(131651);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.i(131652);
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            switch (MeasureSpec.getMode(i2)) {
                case j.INVALID_ID /*-2147483648*/:
                    i2 = MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(viewGroup.getMeasuredHeight(), MeasureSpec.getSize(i2))), j.INVALID_ID);
                    break;
                case 0:
                    i2 = MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), j.INVALID_ID);
                    break;
                case ErrorDialogData.SUPPRESSED /*1073741824*/:
                    if (MeasureSpec.getSize(i2) > viewGroup.getMeasuredHeight()) {
                        i2 = MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), ErrorDialogData.SUPPRESSED);
                        break;
                    }
                    break;
            }
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(131652);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(131653);
        super.onAttachedToWindow();
        this.ico = n.cI(this);
        if (this.ico != null) {
            this.ico.a(this.icp);
        }
        this.icq = new c(this, (byte) 0);
        c cVar = this.icq;
        a.this.hyU.a((com.tencent.mm.plugin.appbrand.jsapi.f.d) cVar);
        a.this.hyU.a((com.tencent.mm.plugin.appbrand.jsapi.f.b) cVar);
        this.icq.wU();
        AppMethodBeat.o(131653);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(131654);
        super.onDetachedFromWindow();
        if (!this.hyU.isRunning()) {
            getWebView().destroy();
        }
        if (this.ico != null) {
            this.ico.b(this.icp);
        }
        if (this.icq != null) {
            this.icq.wW();
            c cVar = this.icq;
            a.this.hyU.b((com.tencent.mm.plugin.appbrand.jsapi.f.b) cVar);
            a.this.hyU.b((com.tencent.mm.plugin.appbrand.jsapi.f.d) cVar);
            this.icq = null;
        }
        AppMethodBeat.o(131654);
    }

    public final void setViewId(int i) {
        this.eO = i;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final MMWebView getWebView() {
        return this.fow;
    }

    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(131655);
        if (al.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(131655);
            return;
        }
        post(runnable);
        AppMethodBeat.o(131655);
    }

    public final void D(JSONObject jSONObject) {
        AppMethodBeat.i(131656);
        this.icj.b(this.hyU.getRuntime().atK(), this.hyU.hashCode()).AL(jSONObject.toString()).aCj();
        AppMethodBeat.o(131656);
    }

    public final void BV(String str) {
        AppMethodBeat.i(131657);
        if (TextUtils.isEmpty(str) || URLUtil.isValidUrl(str)) {
            AppMethodBeat.o(131657);
            return;
        }
        this.hyU.AB(str);
        AppMethodBeat.o(131657);
    }

    public final void BW(String str) {
        AppMethodBeat.i(131658);
        aGq();
        this.fou.start();
        new b().i(this.hyU).n("src", str).n("htmlId", Integer.valueOf(this.eO)).aCj();
        AppMethodBeat.o(131658);
    }

    public final void bF(String str) {
        AppMethodBeat.i(131659);
        aGq();
        this.fou.finish();
        if (!(this.icm || this.icn)) {
            com.tencent.mm.plugin.appbrand.report.model.p reporter = getReporter();
            w wVar = this.hyU;
            String str2 = this.icl;
            reporter.iBB = (String) reporter.iCy.peekFirst();
            reporter.iBC = 2;
            reporter.iBD = str;
            reporter.iCy.push(str2);
            reporter.q(wVar);
        }
        this.icm = false;
        this.icn = false;
        setCurrentURL(str);
        new a().i(this.hyU).n("src", str).n("htmlId", Integer.valueOf(this.eO)).aCj();
        AppMethodBeat.o(131659);
    }

    public final void m(String str, int i, String str2) {
        AppMethodBeat.i(131660);
        new d().i(this.hyU).n("htmlId", Integer.valueOf(this.eO)).n(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(i)).n("description", str2).n("src", str).aCj();
        AppMethodBeat.o(131660);
    }

    public final void aGp() {
        AppMethodBeat.i(131661);
        this.hyU.getRuntime().atJ().aAU();
        AppMethodBeat.o(131661);
    }

    private void aGq() {
        AppMethodBeat.i(131662);
        this.fow.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
        AppMethodBeat.o(131662);
    }

    /* Access modifiers changed, original: final */
    public final com.tencent.mm.plugin.appbrand.report.model.p getReporter() {
        AppMethodBeat.i(131663);
        com.tencent.mm.plugin.appbrand.report.model.p aHZ = this.hyU.getRuntime().atJ().getReporter().aHZ();
        AppMethodBeat.o(131663);
        return aHZ;
    }

    private void setCurrentURL(String str) {
        AppMethodBeat.i(131664);
        this.icl = str;
        if (!bo.isNullOrNil(str)) {
            if (!bo.isNullOrNil(Uri.parse(str).getHost())) {
                a(this.hyU, getContext().getString(R.string.fyz, new Object[]{r0}));
                AppMethodBeat.o(131664);
                return;
            }
        }
        a(this.hyU, "");
        AppMethodBeat.o(131664);
    }

    private void a(final com.tencent.mm.plugin.appbrand.page.u uVar, final String str) {
        AppMethodBeat.i(131665);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131647);
                uVar.isK.setPullDownText(str);
                AppMethodBeat.o(131647);
            }
        });
        AppMethodBeat.o(131665);
    }

    public final String[] getJsApiReportArgs() {
        String str;
        AppMethodBeat.i(131666);
        w wVar = this.hyU;
        o runtime = wVar.getRuntime();
        AppBrandStatObject appBrandStatObject = runtime.ya().bQn;
        AppBrandInitConfigWC atI = runtime.atI();
        a aJS = wVar.aJS();
        String[] strArr = new String[19];
        strArr[0] = appBrandStatObject.scene;
        strArr[1] = appBrandStatObject.cst;
        strArr[2] = runtime.mAppId;
        strArr[3] = runtime.atH().hhd.gVu;
        strArr[4] = atI.xz();
        strArr[5] = (runtime.atH().hhd.gVt + 1);
        strArr[6] = appBrandStatObject.iAo;
        strArr[7] = wVar.getURL();
        if (aJS == null) {
            str = "";
        } else {
            str = aJS.getWebView().getUrl();
        }
        strArr[8] = str;
        strArr[9] = com.tencent.mm.plugin.appbrand.report.c.cV(wVar.mContext);
        strArr[10] = "";
        strArr[11] = "";
        strArr[12] = "";
        strArr[13] = "";
        strArr[14] = "";
        strArr[15] = "";
        strArr[16] = appBrandStatObject.cOq;
        strArr[17] = appBrandStatObject.cOr;
        strArr[18] = (runtime.atI().bQe + 1000);
        AppMethodBeat.o(131666);
        return strArr;
    }

    public final boolean aGr() {
        AppMethodBeat.i(131667);
        try {
            boolean z;
            if (this.hyU.getRuntime().atH().bQf) {
                z = this.hyU.getRuntime().atH().bQs;
                AppMethodBeat.o(131667);
                return z;
            }
            z = this.hyU.getRuntime().atH().bQp;
            AppMethodBeat.o(131667);
            return z;
        } catch (NullPointerException e) {
            AppMethodBeat.o(131667);
            return false;
        }
    }
}

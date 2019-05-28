package com.tencent.p177mm.plugin.appbrand.jsapi.p316t;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.support.p057v4.widget.C8415j;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMFalseProgressBar;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42583c.C19489a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42583c.C42581b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C42583c.C42582c;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.model.C38499p;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38606u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38606u.C11042c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C42740n;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29959f.C23152a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a */
public final class C45622a extends FrameLayout implements C42582c {
    /* renamed from: eO */
    private int f17884eO = 0;
    private MMFalseProgressBar fou;
    MMWebView fow;
    C27242w hyU;
    private C42580b icj;
    private final C42581b ick;
    private String icl = "";
    private boolean icm = true;
    boolean icn = false;
    private C38606u ico = null;
    private final C11042c icp = new C383871();
    private C16680c icq;
    private C36591r icr = new C425773();
    private C16404b ics = new C425784();
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$a */
    static final class C10519a extends C38369p {
        public static final int CTRL_INDEX = 505;
        public static final String NAME = "onWebviewFinishLoad";

        private C10519a() {
        }

        /* synthetic */ C10519a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$d */
    static final class C10520d extends C38369p {
        public static final int CTRL_INDEX = 506;
        public static final String NAME = "onWebviewError";

        private C10520d() {
        }

        /* synthetic */ C10520d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$c */
    final class C16680c implements C10379b, C10381d {
        private C16680c() {
        }

        /* synthetic */ C16680c(C45622a c45622a, byte b) {
            this();
        }

        /* renamed from: wW */
        public final void mo21857wW() {
            AppMethodBeat.m2504i(131648);
            C45622a.this.ick.mo44758wW();
            AppMethodBeat.m2505o(131648);
        }

        /* renamed from: wU */
        public final void mo6095wU() {
            AppMethodBeat.m2504i(131649);
            C45622a.this.ick.mo44757wU();
            AppMethodBeat.m2505o(131649);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$b */
    static final class C27089b extends C38369p {
        public static final int CTRL_INDEX = 504;
        public static final String NAME = "onWebviewStartLoad";

        private C27089b() {
        }

        /* synthetic */ C27089b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$1 */
    class C383871 implements C11042c {
        private int ict = 0;

        C383871() {
        }

        /* renamed from: oD */
        public final void mo6334oD(int i) {
            this.ict = i;
        }

        /* renamed from: et */
        public final void mo6332et(boolean z) {
            AppMethodBeat.m2504i(131631);
            C45622a.this.ick.mo44755k(z, this.ict);
            AppMethodBeat.m2505o(131631);
        }

        public final int getHeight() {
            return this.ict;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$2 */
    class C425762 implements C10380c {
        C425762() {
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(131632);
            C45622a.this.ick.cleanup();
            AppMethodBeat.m2505o(131632);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$3 */
    class C425773 implements C36591r {
        C425773() {
        }

        /* renamed from: A */
        public final boolean mo31055A(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(131633);
            boolean Q = C45622a.this.fow.mo49216Q(motionEvent);
            AppMethodBeat.m2505o(131633);
            return Q;
        }

        /* renamed from: b */
        public final boolean mo31059b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.m2504i(131634);
            boolean c = C45622a.this.fow.mo49221c(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.m2505o(131634);
            return c;
        }

        public final void aGs() {
            AppMethodBeat.m2504i(131635);
            C45622a.this.fow.dKK();
            AppMethodBeat.m2505o(131635);
        }

        @TargetApi(9)
        /* renamed from: d */
        public final void mo31060d(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(131636);
            C45622a.this.fow.mo49227e(i, i2, z, z2);
            AppMethodBeat.m2505o(131636);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(131637);
            C45622a.this.fow.mo49215M(i, i2, i3, i4);
            AppMethodBeat.m2505o(131637);
        }

        /* renamed from: B */
        public final boolean mo31056B(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(131638);
            boolean R = C45622a.this.fow.mo49217R(motionEvent);
            AppMethodBeat.m2505o(131638);
            return R;
        }

        /* renamed from: C */
        public final boolean mo31057C(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(131639);
            boolean S = C45622a.this.fow.mo49218S(motionEvent);
            AppMethodBeat.m2505o(131639);
            return S;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.t.a$4 */
    class C425784 extends C16404b {
        C425784() {
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(131640);
            boolean A = C45622a.this.icr.mo31055A(motionEvent);
            AppMethodBeat.m2505o(131640);
            return A;
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(131641);
            boolean C = C45622a.this.icr.mo31057C(motionEvent);
            AppMethodBeat.m2505o(131641);
            return C;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(131642);
            boolean B = C45622a.this.icr.mo31056B(motionEvent);
            AppMethodBeat.m2505o(131642);
            return B;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            AppMethodBeat.m2504i(131643);
            boolean b = C45622a.this.icr.mo31059b(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.m2505o(131643);
            return b;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(131644);
            C45622a.this.icr.onScrollChanged(i, i2, i3, i4, view);
            AppMethodBeat.m2505o(131644);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            AppMethodBeat.m2504i(131645);
            C45622a.this.icr.mo31060d(i, i2, z, z2);
            AppMethodBeat.m2505o(131645);
        }

        public final void computeScroll(View view) {
            AppMethodBeat.m2504i(131646);
            C45622a.this.icr.aGs();
            AppMethodBeat.m2505o(131646);
        }

        public final void invalidate() {
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public C45622a(Context context, C6750i c6750i, C27242w c27242w) {
        super(context);
        AppMethodBeat.m2504i(131650);
        this.mAppId = c6750i.mAppId;
        this.icj = new C42580b();
        this.icj.mo61031i(c27242w);
        this.hyU = c27242w;
        this.fow = C23152a.uJi.mo30691du(context);
        this.fow.getSettings().dUh();
        this.fow.getSettings().setJavaScriptEnabled(true);
        this.fow.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.fow.getSettings().dUj();
        String userAgentString = this.fow.getSettings().getUserAgentString();
        if (!C30152u.akj(userAgentString)) {
            userAgentString = C30152u.m47747bh(getContext(), userAgentString);
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
        this.fow.getSettings().setDatabasePath(C1761b.eSi + "databases/");
        this.fow.setWebViewCallbackClient(this.icr);
        if (this.fow.getIsX5Kernel()) {
            this.fow.setWebViewClientExtension(this.ics);
        }
        this.fow.getSettings().setUsingForAppBrand(2);
        addView(this.fow, new LayoutParams(-1, -1));
        this.fou = new MMFalseProgressBar(context);
        this.fou.setProgressDrawable(C1338a.m2864g(context, C25738R.drawable.f6901uw));
        addView(this.fou, new LayoutParams(-1, C1338a.fromDPToPix(context, 3)));
        this.ick = ((C19489a) C37384e.m62985B(C19489a.class)).mo34612a(this);
        this.hyU.mo53828a((C10380c) new C425762());
        getReporter().iCA = true;
        AppMethodBeat.m2505o(131650);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(131651);
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
        AppMethodBeat.m2505o(131651);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(131652);
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            switch (MeasureSpec.getMode(i2)) {
                case C8415j.INVALID_ID /*-2147483648*/:
                    i2 = MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(viewGroup.getMeasuredHeight(), MeasureSpec.getSize(i2))), C8415j.INVALID_ID);
                    break;
                case 0:
                    i2 = MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), C8415j.INVALID_ID);
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
        AppMethodBeat.m2505o(131652);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(131653);
        super.onAttachedToWindow();
        this.ico = C42740n.m75741cI(this);
        if (this.ico != null) {
            this.ico.mo61402a(this.icp);
        }
        this.icq = new C16680c(this, (byte) 0);
        C16680c c16680c = this.icq;
        C45622a.this.hyU.mo53829a((C10381d) c16680c);
        C45622a.this.hyU.mo53827a((C10379b) c16680c);
        this.icq.mo6095wU();
        AppMethodBeat.m2505o(131653);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(131654);
        super.onDetachedFromWindow();
        if (!this.hyU.isRunning()) {
            getWebView().destroy();
        }
        if (this.ico != null) {
            this.ico.mo61403b(this.icp);
        }
        if (this.icq != null) {
            this.icq.mo21857wW();
            C16680c c16680c = this.icq;
            C45622a.this.hyU.mo53832b((C10379b) c16680c);
            C45622a.this.hyU.mo53834b((C10381d) c16680c);
            this.icq = null;
        }
        AppMethodBeat.m2505o(131654);
    }

    public final void setViewId(int i) {
        this.f17884eO = i;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final MMWebView getWebView() {
        return this.fow;
    }

    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(131655);
        if (C5004al.isMainThread()) {
            runnable.run();
            AppMethodBeat.m2505o(131655);
            return;
        }
        post(runnable);
        AppMethodBeat.m2505o(131655);
    }

    /* renamed from: D */
    public final void mo68015D(JSONObject jSONObject) {
        AppMethodBeat.m2504i(131656);
        this.icj.mo61030b(this.hyU.getRuntime().atK(), this.hyU.hashCode()).mo61027AL(jSONObject.toString()).aCj();
        AppMethodBeat.m2505o(131656);
    }

    /* renamed from: BV */
    public final void mo68013BV(String str) {
        AppMethodBeat.m2504i(131657);
        if (TextUtils.isEmpty(str) || URLUtil.isValidUrl(str)) {
            AppMethodBeat.m2505o(131657);
            return;
        }
        this.hyU.mo53734AB(str);
        AppMethodBeat.m2505o(131657);
    }

    /* renamed from: BW */
    public final void mo68014BW(String str) {
        AppMethodBeat.m2504i(131658);
        aGq();
        this.fou.start();
        new C27089b().mo61031i(this.hyU).mo67975n("src", str).mo67975n("htmlId", Integer.valueOf(this.f17884eO)).aCj();
        AppMethodBeat.m2505o(131658);
    }

    /* renamed from: bF */
    public final void mo68018bF(String str) {
        AppMethodBeat.m2504i(131659);
        aGq();
        this.fou.finish();
        if (!(this.icm || this.icn)) {
            C38499p reporter = getReporter();
            C27242w c27242w = this.hyU;
            String str2 = this.icl;
            reporter.iBB = (String) reporter.iCy.peekFirst();
            reporter.iBC = 2;
            reporter.iBD = str;
            reporter.iCy.push(str2);
            reporter.mo61211q(c27242w);
        }
        this.icm = false;
        this.icn = false;
        setCurrentURL(str);
        new C10519a().mo61031i(this.hyU).mo67975n("src", str).mo67975n("htmlId", Integer.valueOf(this.f17884eO)).aCj();
        AppMethodBeat.m2505o(131659);
    }

    /* renamed from: m */
    public final void mo68022m(String str, int i, String str2) {
        AppMethodBeat.m2504i(131660);
        new C10520d().mo61031i(this.hyU).mo67975n("htmlId", Integer.valueOf(this.f17884eO)).mo67975n(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(i)).mo67975n("description", str2).mo67975n("src", str).aCj();
        AppMethodBeat.m2505o(131660);
    }

    public final void aGp() {
        AppMethodBeat.m2504i(131661);
        this.hyU.getRuntime().atJ().aAU();
        AppMethodBeat.m2505o(131661);
    }

    private void aGq() {
        AppMethodBeat.m2504i(131662);
        this.fow.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
        AppMethodBeat.m2505o(131662);
    }

    /* Access modifiers changed, original: final */
    public final C38499p getReporter() {
        AppMethodBeat.m2504i(131663);
        C38499p aHZ = this.hyU.getRuntime().atJ().getReporter().aHZ();
        AppMethodBeat.m2505o(131663);
        return aHZ;
    }

    private void setCurrentURL(String str) {
        AppMethodBeat.m2504i(131664);
        this.icl = str;
        if (!C5046bo.isNullOrNil(str)) {
            if (!C5046bo.isNullOrNil(Uri.parse(str).getHost())) {
                m84210a(this.hyU, getContext().getString(C25738R.string.fyz, new Object[]{r0}));
                AppMethodBeat.m2505o(131664);
                return;
            }
        }
        m84210a(this.hyU, "");
        AppMethodBeat.m2505o(131664);
    }

    /* renamed from: a */
    private void m84210a(final C44709u c44709u, final String str) {
        AppMethodBeat.m2504i(131665);
        runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(131647);
                c44709u.isK.setPullDownText(str);
                AppMethodBeat.m2505o(131647);
            }
        });
        AppMethodBeat.m2505o(131665);
    }

    public final String[] getJsApiReportArgs() {
        String str;
        AppMethodBeat.m2504i(131666);
        C27242w c27242w = this.hyU;
        C41243o runtime = c27242w.getRuntime();
        AppBrandStatObject appBrandStatObject = runtime.mo43491ya().bQn;
        AppBrandInitConfigWC atI = runtime.atI();
        C45622a aJS = c27242w.aJS();
        String[] strArr = new String[19];
        strArr[0] = appBrandStatObject.scene;
        strArr[1] = appBrandStatObject.cst;
        strArr[2] = runtime.mAppId;
        strArr[3] = runtime.atH().hhd.gVu;
        strArr[4] = atI.mo32993xz();
        strArr[5] = (runtime.atH().hhd.gVt + 1);
        strArr[6] = appBrandStatObject.iAo;
        strArr[7] = c27242w.getURL();
        if (aJS == null) {
            str = "";
        } else {
            str = aJS.getWebView().getUrl();
        }
        strArr[8] = str;
        strArr[9] = C19690c.m30503cV(c27242w.mContext);
        strArr[10] = "";
        strArr[11] = "";
        strArr[12] = "";
        strArr[13] = "";
        strArr[14] = "";
        strArr[15] = "";
        strArr[16] = appBrandStatObject.cOq;
        strArr[17] = appBrandStatObject.cOr;
        strArr[18] = (runtime.atI().bQe + 1000);
        AppMethodBeat.m2505o(131666);
        return strArr;
    }

    public final boolean aGr() {
        AppMethodBeat.m2504i(131667);
        try {
            boolean z;
            if (this.hyU.getRuntime().atH().bQf) {
                z = this.hyU.getRuntime().atH().bQs;
                AppMethodBeat.m2505o(131667);
                return z;
            }
            z = this.hyU.getRuntime().atH().bQp;
            AppMethodBeat.m2505o(131667);
            return z;
        } catch (NullPointerException e) {
            AppMethodBeat.m2505o(131667);
            return false;
        }
    }
}

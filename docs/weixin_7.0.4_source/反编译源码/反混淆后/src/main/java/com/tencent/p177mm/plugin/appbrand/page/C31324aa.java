package com.tencent.p177mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.luggage.p817i.p818a.C37401e;
import com.tencent.luggage.p817i.p818a.C8875a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C10503e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p317u.C19496c;
import com.tencent.p177mm.plugin.appbrand.p297h.C2169j;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.p893e.C19213f;
import com.tencent.p177mm.plugin.appbrand.p893e.C38209c;
import com.tencent.p177mm.plugin.appbrand.p893e.C45550b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import java.net.URL;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkView;

@SuppressLint({"ViewConstructor"})
@JgClassChecked(author = 10000, fComment = "checked", lastDate = "20180919", reviewer = 10000, vComment = {EType.HTTPSCHECK})
/* renamed from: com.tencent.mm.plugin.appbrand.page.aa */
public final class C31324aa extends MMWebView implements C19496c, C27221aj {
    private C36591r icr;
    private C16404b ics;
    private C38464c isR;
    private C42644af iug;
    private C38459ad iuh;
    private C42643ae iui;
    private C38458ab iuj;
    private Animator iuk;
    private boolean iul;
    private String ium;
    private C19213f iun;
    private C36592s iuo;
    private C6031l iup;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$1 */
    class C106591 implements OnLongClickListener {
        C106591() {
        }

        public final boolean onLongClick(View view) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$7 */
    class C196217 implements C36591r {
        C196217() {
        }

        /* renamed from: A */
        public final boolean mo31055A(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(132454);
            boolean Q = C31324aa.this.mo49216Q(motionEvent);
            AppMethodBeat.m2505o(132454);
            return Q;
        }

        /* renamed from: b */
        public final boolean mo31059b(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            AppMethodBeat.m2504i(132455);
            boolean c = C31324aa.this.mo49221c(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.m2505o(132455);
            return c;
        }

        public final void aGs() {
            AppMethodBeat.m2504i(132456);
            C31324aa.this.dKK();
            AppMethodBeat.m2505o(132456);
        }

        @TargetApi(9)
        /* renamed from: d */
        public final void mo31060d(int i, int i2, boolean z, boolean z2) {
            AppMethodBeat.m2504i(132457);
            C31324aa.this.mo49227e(i, i2, z, z2);
            AppMethodBeat.m2505o(132457);
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(132458);
            if (C31324aa.this.iug != null) {
                C31324aa.this.iug.onScrollChanged(i, i2, i3, i4, view);
            }
            C31324aa.this.iuj;
            C31324aa.this.mo49215M(i, i2, i3, i4);
            AppMethodBeat.m2505o(132458);
        }

        /* renamed from: B */
        public final boolean mo31056B(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(132459);
            boolean R = C31324aa.this.mo49217R(motionEvent);
            AppMethodBeat.m2505o(132459);
            return R;
        }

        /* renamed from: C */
        public final boolean mo31057C(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(132460);
            boolean S = C31324aa.this.mo49218S(motionEvent);
            AppMethodBeat.m2505o(132460);
            return S;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$8 */
    class C196228 extends C16404b {
        C196228() {
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(132461);
            boolean A = C31324aa.this.icr.mo31055A(motionEvent);
            AppMethodBeat.m2505o(132461);
            return A;
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(132462);
            boolean C = C31324aa.this.icr.mo31057C(motionEvent);
            AppMethodBeat.m2505o(132462);
            return C;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.m2504i(132463);
            boolean B = C31324aa.this.icr.mo31056B(motionEvent);
            AppMethodBeat.m2505o(132463);
            return B;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            AppMethodBeat.m2504i(132464);
            boolean b = C31324aa.this.icr.mo31059b(i, i2, i3, i4, i5, i6, i7, i8, z);
            AppMethodBeat.m2505o(132464);
            return b;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            AppMethodBeat.m2504i(132465);
            C31324aa.this.icr.onScrollChanged(i, i2, i3, i4, view);
            AppMethodBeat.m2505o(132465);
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            AppMethodBeat.m2504i(132466);
            C31324aa.this.icr.mo31060d(i, i2, z, z2);
            AppMethodBeat.m2505o(132466);
        }

        public final void computeScroll(View view) {
            AppMethodBeat.m2504i(132467);
            C31324aa.this.icr.aGs();
            AppMethodBeat.m2505o(132467);
        }

        public final boolean onShowLongClickPopupMenu() {
            AppMethodBeat.m2504i(132468);
            if (WebView.getUsingTbsCoreVersion(C31324aa.this.getContext()) >= 43011) {
                AppMethodBeat.m2505o(132468);
                return false;
            }
            AppMethodBeat.m2505o(132468);
            return true;
        }

        public final void invalidate() {
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.m2504i(132469);
            if (C5046bo.isNullOrNil(str) || bundle == null) {
                AppMethodBeat.m2505o(132469);
            } else {
                C4990ab.m7417i("MicroMsg.AppBrandWebView", "method = %s", str);
                AppMethodBeat.m2505o(132469);
            }
            return null;
        }

        public final boolean shouldDiscardCurrentPage() {
            AppMethodBeat.m2504i(132470);
            if (C31324aa.this.iui == null) {
                AppMethodBeat.m2505o(132470);
                return false;
            }
            boolean z;
            boolean xU = C31324aa.this.iui.mo43486xU();
            String str = "MicroMsg.AppBrandWebView";
            String str2 = "shouldTrimCurrentPage: %b";
            Object[] objArr = new Object[1];
            if (!xU || C31324aa.this.iul) {
                z = false;
            } else {
                z = true;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str, str2, objArr);
            if (!xU || C31324aa.this.iul) {
                AppMethodBeat.m2505o(132470);
                return false;
            }
            AppMethodBeat.m2505o(132470);
            return true;
        }

        public final void hasDiscardCurrentPage(boolean z) {
            AppMethodBeat.m2504i(132471);
            C31324aa.this.iul = z;
            AppMethodBeat.m2505o(132471);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$6 */
    class C272196 extends C6031l {
        C272196() {
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.m2504i(132452);
            try {
                if (C31324aa.this.isR != null) {
                    C31324aa.this.isR.mo61148G(view, 90);
                    C31324aa.this.isR.iqP = customViewCallback;
                }
                AppMethodBeat.m2505o(132452);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppBrandWebView", "onShowCustomView error " + e.getMessage());
                AppMethodBeat.m2505o(132452);
            }
        }

        public final void onHideCustomView() {
            AppMethodBeat.m2504i(132453);
            try {
                if (C31324aa.this.isR != null) {
                    C31324aa.this.isR.aIZ();
                }
                AppMethodBeat.m2505o(132453);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppBrandWebView", "onHideCustomView error " + e.getMessage());
                AppMethodBeat.m2505o(132453);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$5 */
    class C313265 extends C36592s {
        C313265() {
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(132443);
            C31324aa.this.iuj;
            AppMethodBeat.m2505o(132443);
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(132444);
            C31324aa.this.iuj.hTn.aJM();
            AppMethodBeat.m2505o(132444);
        }

        /* renamed from: a */
        public final boolean mo4762a(WebView webView, String str) {
            AppMethodBeat.m2504i(132445);
            C4990ab.m7417i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", str);
            AppMethodBeat.m2505o(132445);
            return true;
        }

        /* renamed from: a */
        public final void mo7560a(WebView webView, C36588j c36588j, SslError sslError) {
            AppMethodBeat.m2504i(132446);
            if (sslError.getPrimaryError() != 3) {
                c36588j.cancel();
                AppMethodBeat.m2505o(132446);
            } else if (C31324aa.this.iuj.mo61147a(sslError.getCertificate())) {
                c36588j.proceed();
                AppMethodBeat.m2505o(132446);
            } else {
                c36588j.cancel();
                AppMethodBeat.m2505o(132446);
            }
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(132447);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(132447);
                return null;
            }
            C31147o a = C31324aa.m50600a(C31324aa.this, str);
            AppMethodBeat.m2505o(132447);
            return a;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(132448);
            if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
                AppMethodBeat.m2505o(132448);
                return null;
            }
            C31147o a = C31324aa.m50600a(C31324aa.this, c24530n.getUrl().toString());
            AppMethodBeat.m2505o(132448);
            return a;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(132449);
            if (c24530n == null || c24530n.getUrl() == null || C5046bo.isNullOrNil(c24530n.getUrl().toString())) {
                AppMethodBeat.m2505o(132449);
                return null;
            }
            C31147o a = C31324aa.m50600a(C31324aa.this, c24530n.getUrl().toString());
            AppMethodBeat.m2505o(132449);
            return a;
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(132450);
            C4990ab.m7413e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i), str, str2);
            AppMethodBeat.m2505o(132450);
        }

        /* renamed from: a */
        public final void mo7561a(WebView webView, C24530n c24530n, C31147o c31147o) {
            AppMethodBeat.m2504i(132451);
            Uri url = c24530n.getUrl();
            String uri = url == null ? BuildConfig.COMMAND : url.toString();
            C4990ab.m7413e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", uri, c31147o.mMimeType, Integer.valueOf(c31147o.mStatusCode));
            AppMethodBeat.m2505o(132451);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$4 */
    class C313274 implements AnimatorUpdateListener {
        C313274() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(132442);
            C31324aa.this.getView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            AppMethodBeat.m2505o(132442);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.aa$2 */
    class C313282 implements DownloadListener {
        C313282() {
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            AppMethodBeat.m2504i(132440);
            C4990ab.m7417i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", str, str4, str2);
            AppMethodBeat.m2505o(132440);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C31324aa(Context context, C38458ab c38458ab) {
        super(new MutableContextWrapper(context));
        AppMethodBeat.m2504i(132472);
        this.iuh = null;
        this.iul = false;
        this.iuo = new C313265();
        this.iup = new C272196();
        this.icr = new C196217();
        this.ics = new C196228();
        this.inited = true;
        this.iuj = c38458ab;
        getSettings().dUh();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().dUj();
        getSettings().setUserAgentString(C30152u.m47747bh(getContext(), getSettings().getUserAgentString()));
        this.ium = getSettings().getUserAgentString();
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.iuo);
        setWebChromeClient(this.iup);
        setWebViewCallbackClient(this.icr);
        setWebViewClientExtension(this.ics);
        getIsX5Kernel();
        getSettings().setUsingForAppBrand(1);
        C4990ab.m7416i("MicroMsg.AppBrandWebView", "Is the current browser kernel X5, " + getIsX5Kernel());
        if (C45550b.hpK == null) {
            C45550b.hpK = new C45550b();
        }
        C45550b c45550b = C45550b.hpK;
        if (!XWalkEnvironment.isCurrentVersionSupportExtendPluginForAppbrand()) {
            C4990ab.m7420w("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current version not support extend plugin");
        } else if (isXWalkKernel()) {
            C4990ab.m7417i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, webview(%s) is xweb kernel", Integer.valueOf(hashCode()));
            View webViewUI = getWebViewUI();
            if (webViewUI == null || !(webViewUI instanceof XWalkView) || c45550b == null) {
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client fail");
            } else {
                XWalkView xWalkView = (XWalkView) webViewUI;
                C8875a yq = c45550b.mo43485yq();
                C37401e c37401e = new C37401e(xWalkView);
                c37401e.bSf = yq;
                yq.mo20072a(c37401e);
                xWalkView.setExtendPluginClient(c37401e);
                C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, set extend plugin client success");
                Object obj = yq;
                this.iun = (C19213f) obj;
                if (this.iun != null) {
                    C19213f c19213f = this.iun;
                    if (C38209c.hpL == null) {
                        C38209c.hpL = new C38209c();
                    }
                    c19213f.mo21634a(C38209c.hpL);
                }
                setBackgroundColor(-1);
                setLayoutParams(new LayoutParams(-1, -1));
                setOnLongClickListener(new C106591());
                setDownloadListener(new C313282());
                AppMethodBeat.m2505o(132472);
            }
        } else {
            C4990ab.m7416i("MicroMsg.AppBrand.SameLayer.WebViewExtendPluginUtil", "applyExtendPluginClientIfNeed, current webview is not xweb kernel");
        }
        C38459ad obj2 = null;
        this.iun = (C19213f) obj2;
        if (this.iun != null) {
        }
        setBackgroundColor(-1);
        setLayoutParams(new LayoutParams(-1, -1));
        setOnLongClickListener(new C106591());
        setDownloadListener(new C313282());
        AppMethodBeat.m2505o(132472);
    }

    public final C19213f getWebViewPluginClientProxy() {
        return this.iun;
    }

    /* renamed from: cE */
    public final void mo22182cE(Context context) {
        AppMethodBeat.m2504i(132473);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
            AppMethodBeat.m2505o(132473);
            return;
        }
        AppMethodBeat.m2505o(132473);
    }

    public final View getWrapperView() {
        return this;
    }

    public final View getContentView() {
        AppMethodBeat.m2504i(132474);
        View view = super.getView();
        AppMethodBeat.m2505o(132474);
        return view;
    }

    /* renamed from: g */
    public final boolean mo22183g(Canvas canvas) {
        AppMethodBeat.m2504i(132475);
        if (isXWalkKernel()) {
            drawCanvas(canvas);
        } else {
            draw(canvas);
        }
        AppMethodBeat.m2505o(132475);
        return true;
    }

    /* renamed from: H */
    public final void mo22176H(Runnable runnable) {
        AppMethodBeat.m2504i(132476);
        if (isXWalkKernel()) {
            postDelayed(runnable, 200);
            AppMethodBeat.m2505o(132476);
            return;
        }
        postOnAnimation(runnable);
        AppMethodBeat.m2505o(132476);
    }

    /* renamed from: bU */
    public final void mo22181bU(String str, String str2) {
        AppMethodBeat.m2504i(132477);
        this.iul = false;
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        AppMethodBeat.m2505o(132477);
    }

    public final void setTitle(String str) {
        AppMethodBeat.m2504i(132478);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(132478);
            return;
        }
        evaluateJavascript("document.title=\"" + str + "\"", null);
        AppMethodBeat.m2505o(132478);
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(132479);
        C313253 c313253 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132441);
                C31324aa.m50601a(C31324aa.this, str, valueCallback);
                AppMethodBeat.m2505o(132441);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c313253.run();
            AppMethodBeat.m2505o(132479);
            return;
        }
        C5004al.m7441d(c313253);
        AppMethodBeat.m2505o(132479);
    }

    /* renamed from: a */
    public final void mo49219a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(132480);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(132480);
    }

    /* renamed from: a */
    public final void mo49220a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(132481);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.m2505o(132481);
    }

    public final void setJsExceptionHandler(C33211h c33211h) {
    }

    /* renamed from: af */
    public final <T extends C2169j> T mo14970af(Class<T> cls) {
        return null;
    }

    public final String getUserAgentString() {
        return this.ium;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAttachedToWindow() {
        AppMethodBeat.m2504i(132482);
        try {
            super.onAttachedToWindow();
            AppMethodBeat.m2505o(132482);
        } catch (SecurityException e) {
            AppMethodBeat.m2505o(132482);
        }
    }

    public final void destroy() {
        AppMethodBeat.m2504i(132483);
        super.destroy();
        if (this.iuk != null) {
            this.iuk.cancel();
            this.iuk = null;
        }
        if (this.isR != null) {
            this.isR.iqR.clear();
        }
        this.isR = null;
        mo22182cE(getContext().getApplicationContext());
        AppMethodBeat.m2505o(132483);
    }

    /* renamed from: wU */
    public final void mo22196wU() {
        AppMethodBeat.m2504i(132484);
        onResume();
        AppMethodBeat.m2505o(132484);
    }

    /* renamed from: wW */
    public final void mo22197wW() {
        AppMethodBeat.m2504i(132485);
        onPause();
        AppMethodBeat.m2505o(132485);
    }

    public final void setOnScrollChangedListener(C42644af c42644af) {
        this.iug = c42644af;
    }

    public final void setWebViewLayoutListener(C38459ad c38459ad) {
        this.iuh = c38459ad;
    }

    public final void setOnTrimListener(C42643ae c42643ae) {
        this.iui = c42643ae;
    }

    public final void aAM() {
        AppMethodBeat.m2504i(132486);
        getView().scrollTo(getWebScrollX(), 0);
        AppMethodBeat.m2505o(132486);
    }

    /* renamed from: z */
    public final void mo22198z(int i, long j) {
        AppMethodBeat.m2504i(132487);
        if (this.iuk != null) {
            this.iuk.cancel();
            this.iuk = null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getWebScrollY(), i});
        ofInt.addUpdateListener(new C313274());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.start();
        this.iuk = ofInt;
        AppMethodBeat.m2505o(132487);
    }

    public final void setFullscreenImpl(C38464c c38464c) {
        this.isR = c38464c;
    }

    public final boolean aAN() {
        return this.iul;
    }

    public final boolean aAO() {
        AppMethodBeat.m2504i(132488);
        if (isXWalkKernel() && XWalkEnvironment.getAvailableVersion() >= C10503e.CTRL_INDEX) {
            boolean isOverScrollStart = isOverScrollStart();
            AppMethodBeat.m2505o(132488);
            return isOverScrollStart;
        } else if (getWebScrollY() == 0) {
            AppMethodBeat.m2505o(132488);
            return true;
        } else {
            AppMethodBeat.m2505o(132488);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(132489);
        super.onLayout(z, i, i2, i3, i4);
        if (this.iuh != null) {
            this.iuh.mo21650c(z, i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(132489);
    }

    public final boolean aAP() {
        return true;
    }
}

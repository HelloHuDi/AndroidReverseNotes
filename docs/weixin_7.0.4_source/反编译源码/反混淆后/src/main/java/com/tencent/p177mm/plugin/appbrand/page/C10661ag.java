package com.tencent.p177mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C2169j;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URL;

@JgClassChecked(author = 10, fComment = "checked", lastDate = "20180817", reviewer = 10, vComment = {EType.HTTPSCHECK})
/* renamed from: com.tencent.mm.plugin.appbrand.page.ag */
public final class C10661ag extends WebView implements C27221aj {
    private WebViewClient bOQ = new C106623();
    private WebChromeClient bOR = new DefaultWebViewImpl$4(this);
    private C42644af iuQ;
    private C38459ad iuR;
    private C38458ab iuj;
    private Animator iuk;
    private String ium;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.ag$3 */
    class C106623 extends WebViewClient {
        C106623() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(87316);
            C10661ag.this.iuj;
            AppMethodBeat.m2505o(87316);
        }

        public final void onPageFinished(WebView webView, String str) {
            AppMethodBeat.m2504i(87317);
            C10661ag.this.iuj.hTn.aJM();
            AppMethodBeat.m2505o(87317);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.m2504i(87318);
            if (sslError.getPrimaryError() != 3) {
                sslErrorHandler.cancel();
                AppMethodBeat.m2505o(87318);
            } else if (C10661ag.this.iuj.mo61147a(sslError.getCertificate())) {
                sslErrorHandler.proceed();
                AppMethodBeat.m2505o(87318);
            } else {
                sslErrorHandler.cancel();
                AppMethodBeat.m2505o(87318);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            AppMethodBeat.m2504i(87319);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(87319);
                return null;
            }
            WebResourceResponse Dj = C10661ag.this.iuj.mo61146Dj(str);
            AppMethodBeat.m2505o(87319);
            return Dj;
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.m2504i(87320);
            if (VERSION.SDK_INT < 21) {
                AppMethodBeat.m2505o(87320);
                return null;
            } else if (webResourceRequest == null || webResourceRequest.getUrl() == null || C5046bo.isNullOrNil(webResourceRequest.getUrl().toString())) {
                AppMethodBeat.m2505o(87320);
                return null;
            } else {
                WebResourceResponse Dj = C10661ag.this.iuj.mo61146Dj(webResourceRequest.getUrl().toString());
                AppMethodBeat.m2505o(87320);
                return Dj;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.ag$2 */
    class C106642 implements AnimatorUpdateListener {
        C106642() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(87315);
            C10661ag.this.getContentView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            AppMethodBeat.m2505o(87315);
        }
    }

    public C10661ag(Context context, C38458ab c38458ab) {
        super(context);
        AppMethodBeat.m2504i(87321);
        this.iuj = c38458ab;
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        if (VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + "/ DEMO");
        this.ium = getSettings().getUserAgentString();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWebViewClient(this.bOQ);
        setWebChromeClient(this.bOR);
        setLayoutParams(new LayoutParams(-1, -1));
        AppMethodBeat.m2505o(87321);
    }

    /* renamed from: cE */
    public final void mo22182cE(Context context) {
        AppMethodBeat.m2504i(87322);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
            AppMethodBeat.m2505o(87322);
            return;
        }
        AppMethodBeat.m2505o(87322);
    }

    public final View getWrapperView() {
        return this;
    }

    public final View getContentView() {
        return this;
    }

    /* renamed from: g */
    public final boolean mo22183g(Canvas canvas) {
        AppMethodBeat.m2504i(87323);
        draw(canvas);
        AppMethodBeat.m2505o(87323);
        return true;
    }

    /* renamed from: H */
    public final void mo22176H(Runnable runnable) {
        AppMethodBeat.m2504i(87324);
        postOnAnimation(runnable);
        AppMethodBeat.m2505o(87324);
    }

    public final boolean aAP() {
        return true;
    }

    /* renamed from: bU */
    public final void mo22181bU(String str, String str2) {
        AppMethodBeat.m2504i(87325);
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        AppMethodBeat.m2505o(87325);
    }

    public final String getUserAgentString() {
        return this.ium;
    }

    public final int getWebScrollX() {
        AppMethodBeat.m2504i(87326);
        int scrollX = getScrollX();
        AppMethodBeat.m2505o(87326);
        return scrollX;
    }

    public final int getWebScrollY() {
        AppMethodBeat.m2504i(87327);
        int scrollY = getScrollY();
        AppMethodBeat.m2505o(87327);
        return scrollY;
    }

    public final void setTitle(String str) {
        AppMethodBeat.m2504i(87328);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(87328);
            return;
        }
        evaluateJavascript("document.title=\"" + str + "\"", null);
        AppMethodBeat.m2505o(87328);
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(87329);
        C106631 c106631 = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(87314);
                C10661ag.m18356a(C10661ag.this, str, valueCallback);
                AppMethodBeat.m2505o(87314);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c106631.run();
            AppMethodBeat.m2505o(87329);
            return;
        }
        C5004al.m7441d(c106631);
        AppMethodBeat.m2505o(87329);
    }

    /* renamed from: a */
    public final void mo14967a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(87330);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.m2505o(87330);
    }

    /* renamed from: a */
    public final void mo14968a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(87331);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.m2505o(87331);
    }

    public final void setJsExceptionHandler(C33211h c33211h) {
    }

    public final void destroy() {
        AppMethodBeat.m2504i(87332);
        super.destroy();
        AppMethodBeat.m2505o(87332);
    }

    /* renamed from: af */
    public final <T extends C2169j> T mo14970af(Class<T> cls) {
        return null;
    }

    /* renamed from: wU */
    public final void mo22196wU() {
        AppMethodBeat.m2504i(87333);
        super.onResume();
        AppMethodBeat.m2505o(87333);
    }

    /* renamed from: wW */
    public final void mo22197wW() {
        AppMethodBeat.m2504i(87334);
        super.onPause();
        AppMethodBeat.m2505o(87334);
    }

    public final void setOnScrollChangedListener(C42644af c42644af) {
        this.iuQ = c42644af;
    }

    public final void setWebViewLayoutListener(C38459ad c38459ad) {
        this.iuR = c38459ad;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(87335);
        super.onLayout(z, i, i2, i3, i4);
        if (this.iuR != null) {
            this.iuR.mo21650c(z, i, i2, i3, i4);
        }
        AppMethodBeat.m2505o(87335);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(87336);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iuQ != null) {
            this.iuQ.onScrollChanged(i, i2, i3, i4, this);
        }
        AppMethodBeat.m2505o(87336);
    }

    public final void setOnTrimListener(C42643ae c42643ae) {
    }

    public final void aAM() {
        AppMethodBeat.m2504i(87337);
        super.scrollTo(getScrollX(), 0);
        AppMethodBeat.m2505o(87337);
    }

    /* renamed from: z */
    public final void mo22198z(int i, long j) {
        AppMethodBeat.m2504i(87338);
        if (this.iuk != null) {
            this.iuk.cancel();
            this.iuk = null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getContentView().getScrollY(), i});
        ofInt.addUpdateListener(new C106642());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.start();
        this.iuk = ofInt;
        AppMethodBeat.m2505o(87338);
    }

    public final void setFullscreenImpl(C38464c c38464c) {
    }

    public final boolean aAN() {
        return false;
    }

    public final boolean aAO() {
        AppMethodBeat.m2504i(87339);
        if (getWebScrollY() == 0) {
            AppMethodBeat.m2505o(87339);
            return true;
        }
        AppMethodBeat.m2505o(87339);
        return false;
    }
}

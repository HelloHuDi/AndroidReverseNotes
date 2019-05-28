package com.tencent.mm.plugin.appbrand.page;

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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.h.j;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URL;

@JgClassChecked(author = 10, fComment = "checked", lastDate = "20180817", reviewer = 10, vComment = {EType.HTTPSCHECK})
public final class ag extends WebView implements aj {
    private WebViewClient bOQ = new WebViewClient() {
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(87316);
            ag.this.iuj;
            AppMethodBeat.o(87316);
        }

        public final void onPageFinished(WebView webView, String str) {
            AppMethodBeat.i(87317);
            ag.this.iuj.hTn.aJM();
            AppMethodBeat.o(87317);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return true;
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.i(87318);
            if (sslError.getPrimaryError() != 3) {
                sslErrorHandler.cancel();
                AppMethodBeat.o(87318);
            } else if (ag.this.iuj.a(sslError.getCertificate())) {
                sslErrorHandler.proceed();
                AppMethodBeat.o(87318);
            } else {
                sslErrorHandler.cancel();
                AppMethodBeat.o(87318);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            AppMethodBeat.i(87319);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(87319);
                return null;
            }
            WebResourceResponse Dj = ag.this.iuj.Dj(str);
            AppMethodBeat.o(87319);
            return Dj;
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(87320);
            if (VERSION.SDK_INT < 21) {
                AppMethodBeat.o(87320);
                return null;
            } else if (webResourceRequest == null || webResourceRequest.getUrl() == null || bo.isNullOrNil(webResourceRequest.getUrl().toString())) {
                AppMethodBeat.o(87320);
                return null;
            } else {
                WebResourceResponse Dj = ag.this.iuj.Dj(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(87320);
                return Dj;
            }
        }
    };
    private WebChromeClient bOR = new DefaultWebViewImpl$4(this);
    private af iuQ;
    private ad iuR;
    private ab iuj;
    private Animator iuk;
    private String ium;

    public ag(Context context, ab abVar) {
        super(context);
        AppMethodBeat.i(87321);
        this.iuj = abVar;
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
        AppMethodBeat.o(87321);
    }

    public final void cE(Context context) {
        AppMethodBeat.i(87322);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
            AppMethodBeat.o(87322);
            return;
        }
        AppMethodBeat.o(87322);
    }

    public final View getWrapperView() {
        return this;
    }

    public final View getContentView() {
        return this;
    }

    public final boolean g(Canvas canvas) {
        AppMethodBeat.i(87323);
        draw(canvas);
        AppMethodBeat.o(87323);
        return true;
    }

    public final void H(Runnable runnable) {
        AppMethodBeat.i(87324);
        postOnAnimation(runnable);
        AppMethodBeat.o(87324);
    }

    public final boolean aAP() {
        return true;
    }

    public final void bU(String str, String str2) {
        AppMethodBeat.i(87325);
        super.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", null);
        AppMethodBeat.o(87325);
    }

    public final String getUserAgentString() {
        return this.ium;
    }

    public final int getWebScrollX() {
        AppMethodBeat.i(87326);
        int scrollX = getScrollX();
        AppMethodBeat.o(87326);
        return scrollX;
    }

    public final int getWebScrollY() {
        AppMethodBeat.i(87327);
        int scrollY = getScrollY();
        AppMethodBeat.o(87327);
        return scrollY;
    }

    public final void setTitle(String str) {
        AppMethodBeat.i(87328);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(87328);
            return;
        }
        evaluateJavascript("document.title=\"" + str + "\"", null);
        AppMethodBeat.o(87328);
    }

    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(87329);
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(87314);
                ag.a(ag.this, str, valueCallback);
                AppMethodBeat.o(87314);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass1.run();
            AppMethodBeat.o(87329);
            return;
        }
        al.d(anonymousClass1);
        AppMethodBeat.o(87329);
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(87330);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(87330);
    }

    public final void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(87331);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(87331);
    }

    public final void setJsExceptionHandler(h hVar) {
    }

    public final void destroy() {
        AppMethodBeat.i(87332);
        super.destroy();
        AppMethodBeat.o(87332);
    }

    public final <T extends j> T af(Class<T> cls) {
        return null;
    }

    public final void wU() {
        AppMethodBeat.i(87333);
        super.onResume();
        AppMethodBeat.o(87333);
    }

    public final void wW() {
        AppMethodBeat.i(87334);
        super.onPause();
        AppMethodBeat.o(87334);
    }

    public final void setOnScrollChangedListener(af afVar) {
        this.iuQ = afVar;
    }

    public final void setWebViewLayoutListener(ad adVar) {
        this.iuR = adVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(87335);
        super.onLayout(z, i, i2, i3, i4);
        if (this.iuR != null) {
            this.iuR.c(z, i, i2, i3, i4);
        }
        AppMethodBeat.o(87335);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(87336);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.iuQ != null) {
            this.iuQ.onScrollChanged(i, i2, i3, i4, this);
        }
        AppMethodBeat.o(87336);
    }

    public final void setOnTrimListener(ae aeVar) {
    }

    public final void aAM() {
        AppMethodBeat.i(87337);
        super.scrollTo(getScrollX(), 0);
        AppMethodBeat.o(87337);
    }

    public final void z(int i, long j) {
        AppMethodBeat.i(87338);
        if (this.iuk != null) {
            this.iuk.cancel();
            this.iuk = null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{getContentView().getScrollY(), i});
        ofInt.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(87315);
                ag.this.getContentView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AppMethodBeat.o(87315);
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j);
        ofInt.start();
        this.iuk = ofInt;
        AppMethodBeat.o(87338);
    }

    public final void setFullscreenImpl(c cVar) {
    }

    public final boolean aAN() {
        return false;
    }

    public final boolean aAO() {
        AppMethodBeat.i(87339);
        if (getWebScrollY() == 0) {
            AppMethodBeat.o(87339);
            return true;
        }
        AppMethodBeat.o(87339);
        return false;
    }
}

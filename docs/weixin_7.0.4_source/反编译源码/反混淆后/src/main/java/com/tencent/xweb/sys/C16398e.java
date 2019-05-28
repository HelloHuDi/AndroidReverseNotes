package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C36589p;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C41128i;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.C6035t;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C41116b;
import com.tencent.xweb.WebView.C46827a;
import com.tencent.xweb.extension.video.C24528b;
import com.tencent.xweb.extension.video.C44584d;
import com.tencent.xweb.extension.video.C44589e;
import com.tencent.xweb.p1115c.C24524e;
import com.tencent.xweb.p1115c.C44579j;
import com.tencent.xweb.p1115c.C46832h;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import com.tencent.xweb.sys.C36594c.C31148a;
import com.tencent.xweb.sys.C36594c.C36596e;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C6038e;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
/* renamed from: com.tencent.xweb.sys.e */
public final class C16398e implements C46832h {
    WebView APS;
    C16400a APT;
    C36592s APU;
    C6031l APV;
    C6034d APW;
    C16402f APX;
    long APY = 0;
    C24528b APZ;
    C16401b AQa;
    final String AQb = "xwalkTempCallBack";
    private WebViewClient bOQ = new C163991();
    private WebChromeClient bOR = new SysWebView$1(this);

    /* renamed from: com.tencent.xweb.sys.e$1 */
    class C163991 extends WebViewClient {
        C163991() {
        }

        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
            AppMethodBeat.m2504i(84686);
            Log.m81049i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(str)));
            boolean a;
            if (C16398e.this.APU != null) {
                a = C16398e.this.APU.mo4762a(C16398e.this.APS, str);
                AppMethodBeat.m2505o(84686);
                return a;
            }
            a = super.shouldOverrideUrlLoading(webView, str);
            AppMethodBeat.m2505o(84686);
            return a;
        }

        public final void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(84687);
            Log.m81049i("SysWebView", "onPageStarted ".concat(String.valueOf(str)));
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo7562b(C16398e.this.APS, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            C16398e.this.APY = System.currentTimeMillis();
            C24532f.avo(str);
            C24532f.dUO();
            if (C16398e.this.APZ != null) {
                C16398e.this.APZ.mo30114am(true, C16398e.this.APS.getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS);
            }
            AppMethodBeat.m2505o(84687);
        }

        public final void onPageFinished(android.webkit.WebView webView, String str) {
            AppMethodBeat.m2504i(84688);
            Log.m81049i("SysWebView", "onPageFinished ".concat(String.valueOf(str)));
            if (C16398e.this.APZ != null) {
                C16398e.this.APZ.mo30114am(false, C16398e.this.APS.getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS);
            }
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo5992b(C16398e.this.APS, str);
            } else {
                super.onPageFinished(webView, str);
            }
            C24532f.m38182nJ(System.currentTimeMillis() - C16398e.this.APY);
            C24532f.m38183nK(System.currentTimeMillis() - C16398e.this.APY);
            C44579j.dUB().dUH();
            AppMethodBeat.m2505o(84688);
        }

        public final void onLoadResource(android.webkit.WebView webView, String str) {
            AppMethodBeat.m2504i(84689);
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo7563h(C16398e.this.APS, str);
                AppMethodBeat.m2505o(84689);
                return;
            }
            super.onLoadResource(webView, str);
            AppMethodBeat.m2505o(84689);
        }

        public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
            AppMethodBeat.m2504i(84690);
            WebResourceResponse a;
            if (C16398e.this.APU != null) {
                a = C36594c.m60684a(C16398e.this.APU.mo5993c(C16398e.this.APS, str));
                AppMethodBeat.m2505o(84690);
                return a;
            }
            a = super.shouldInterceptRequest(webView, str);
            AppMethodBeat.m2505o(84690);
            return a;
        }

        public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
            C31147o c31147o = null;
            AppMethodBeat.m2504i(84691);
            WebResourceResponse a;
            if (C16398e.this.APU != null) {
                Bundle bundle;
                C24530n c36596e = new C36596e(webResourceRequest);
                if (c36596e.APN == null) {
                    bundle = null;
                } else {
                    bundle = c36596e.APN.getBundle();
                }
                if (bundle != null) {
                    c31147o = C16398e.this.APU.mo5991a(C16398e.this.APS, c36596e, bundle);
                }
                if (c31147o == null) {
                    c31147o = C16398e.this.APU.mo5990a(C16398e.this.APS, c36596e);
                }
                a = C36594c.m60684a(c31147o);
                AppMethodBeat.m2505o(84691);
                return a;
            }
            a = super.shouldInterceptRequest(webView, webResourceRequest);
            AppMethodBeat.m2505o(84691);
            return a;
        }

        public final void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
            AppMethodBeat.m2504i(84692);
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo37025a(C16398e.this.APS, f, f2);
                AppMethodBeat.m2505o(84692);
                return;
            }
            super.onScaleChanged(webView, f, f2);
            AppMethodBeat.m2505o(84692);
        }

        public final void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
            AppMethodBeat.m2504i(84693);
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo26819a(C16398e.this.APS, str, z);
                AppMethodBeat.m2505o(84693);
                return;
            }
            super.doUpdateVisitedHistory(webView, str, z);
            AppMethodBeat.m2505o(84693);
        }

        public final void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(84694);
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo7559a(C16398e.this.APS, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            C24532f.dUN();
            C24532f.dUP();
            C44579j.dUB().dUI();
            AppMethodBeat.m2505o(84694);
        }

        public final void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.m2504i(84695);
            Log.m81049i("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (C16398e.this.APU != null) {
                C16398e.this.APU.mo7560a(C16398e.this.APS, new C31148a(sslErrorHandler), sslError);
                AppMethodBeat.m2505o(84695);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AppMethodBeat.m2505o(84695);
        }

        public final void onReceivedHttpError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AppMethodBeat.m2504i(84696);
            Log.m81049i("SysWebView", "onReceivedHttpError code:".concat(String.valueOf(VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : "Invalid")));
            if (C16398e.this.APU != null) {
                C31147o c31147o;
                C36592s c36592s = C16398e.this.APU;
                WebView webView2 = C16398e.this.APS;
                C24530n c36596e = new C36596e(webResourceRequest);
                if (webResourceResponse == null) {
                    c31147o = null;
                } else if (VERSION.SDK_INT >= 21) {
                    c31147o = new C31147o(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
                } else {
                    c31147o = new C31147o(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
                }
                c36592s.mo7561a(webView2, c36596e, c31147o);
                AppMethodBeat.m2505o(84696);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            AppMethodBeat.m2505o(84696);
        }
    }

    /* renamed from: com.tencent.xweb.sys.e$a */
    class C16400a extends android.webkit.WebView {
        public C36591r icr;

        public C16400a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(84697);
            super.onScrollChanged(i, i2, i3, i4);
            if (C16398e.this.APS != null) {
                C16398e.this.APS.onWebViewScrollChanged(i, i2, i3, i4);
            }
            if (this.icr != null) {
                this.icr.onScrollChanged(i, i2, i3, i4, this);
            }
            AppMethodBeat.m2505o(84697);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AppMethodBeat.m2504i(84698);
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && C16398e.this.hasEnteredFullscreen()) {
                C16398e.this.leaveFullscreen();
                AppMethodBeat.m2505o(84698);
                return true;
            }
            AppMethodBeat.m2505o(84698);
            return false;
        }
    }

    /* renamed from: com.tencent.xweb.sys.e$b */
    public static class C16401b {
        HashMap<String, ValueCallback<String>> AQd = new HashMap();
        int AQe = 0;

        public C16401b() {
            AppMethodBeat.m2504i(84699);
            AppMethodBeat.m2505o(84699);
        }

        @JavascriptInterface
        public final void notifyJava(String str, String str2) {
            AppMethodBeat.m2504i(84700);
            ValueCallback valueCallback = (ValueCallback) this.AQd.get(str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str2);
                this.AQd.remove(str);
            }
            AppMethodBeat.m2505o(84700);
        }
    }

    public C16398e(WebView webView) {
        AppMethodBeat.m2504i(84701);
        this.APS = webView;
        this.APT = new C16400a(webView.getContext());
        this.APT.setBackgroundColor(0);
        getSettings();
        this.APW = new C6034d(this.APT);
        this.APT.setWebChromeClient(this.bOR);
        this.APT.setWebViewClient(this.bOQ);
        if (VERSION.SDK_INT < 19) {
            this.AQa = new C16401b();
            this.APT.addJavascriptInterface(this.AQa, "xwalkTempCallBack");
        }
        if (webView.getContext() instanceof Activity) {
            m25216aH((Activity) webView.getContext());
            AppMethodBeat.m2505o(84701);
            return;
        }
        m25216aH(null);
        AppMethodBeat.m2505o(84701);
    }

    /* renamed from: aH */
    private void m25216aH(Activity activity) {
        AppMethodBeat.m2504i(84702);
        Log.m81049i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + activity);
        if (getFullscreenVideoKind() == C46827a.NOT_HOOK) {
            AppMethodBeat.m2505o(84702);
            return;
        }
        this.APZ = C44589e.m81001a(activity, this.APS, this.APT, C44584d.dUq());
        if (getFullscreenVideoKind() == C46827a.HOOK_EVALUTE_JS) {
            this.APZ.mo30115dh(this.APT);
        }
        AppMethodBeat.m2505o(84702);
    }

    public final C36589p getSettings() {
        AppMethodBeat.m2504i(84703);
        if (this.APX != null) {
            C16402f c16402f = this.APX;
            AppMethodBeat.m2505o(84703);
            return c16402f;
        } else if (this.APT == null) {
            AppMethodBeat.m2505o(84703);
            return null;
        } else {
            this.APX = new C16402f(this.APT);
            C36589p c36589p = this.APX;
            AppMethodBeat.m2505o(84703);
            return c36589p;
        }
    }

    public final View getWebViewUI() {
        return this.APT;
    }

    public final ViewGroup getTopView() {
        return this.APT;
    }

    public final void setWebViewClient(C36592s c36592s) {
        this.APU = c36592s;
    }

    public final void setWebChromeClient(C6031l c6031l) {
        this.APV = c6031l;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.m2504i(84704);
        this.APT.setDownloadListener(downloadListener);
        AppMethodBeat.m2505o(84704);
    }

    public final void setFindListener(FindListener findListener) {
        AppMethodBeat.m2504i(84705);
        this.APT.setFindListener(findListener);
        AppMethodBeat.m2505o(84705);
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(84706);
        this.APT.loadUrl(str);
        AppMethodBeat.m2505o(84706);
    }

    public final boolean canGoBack() {
        AppMethodBeat.m2504i(84707);
        boolean canGoBack = this.APT.canGoBack();
        AppMethodBeat.m2505o(84707);
        return canGoBack;
    }

    public final void goBack() {
        AppMethodBeat.m2504i(84708);
        this.APT.goBack();
        AppMethodBeat.m2505o(84708);
    }

    public final boolean hasEnteredFullscreen() {
        AppMethodBeat.m2504i(84709);
        if (this.APZ == null) {
            AppMethodBeat.m2505o(84709);
            return false;
        }
        boolean hasEnteredFullscreen = this.APZ.hasEnteredFullscreen();
        AppMethodBeat.m2505o(84709);
        return hasEnteredFullscreen;
    }

    public final void leaveFullscreen() {
        AppMethodBeat.m2504i(84710);
        if (this.bOR != null) {
            this.bOR.onHideCustomView();
        }
        AppMethodBeat.m2505o(84710);
    }

    public final void clearView() {
        AppMethodBeat.m2504i(84711);
        this.APT.clearView();
        AppMethodBeat.m2505o(84711);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(84712);
        this.APT.destroy();
        AppMethodBeat.m2505o(84712);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(84713);
        if (str == null) {
            AppMethodBeat.m2505o(84713);
        } else if (VERSION.SDK_INT >= 19) {
            this.APT.evaluateJavascript(str, valueCallback);
            AppMethodBeat.m2505o(84713);
        } else if (valueCallback == null) {
            this.APT.loadUrl(str);
            AppMethodBeat.m2505o(84713);
        } else {
            String stringBuilder;
            if (str.trim().startsWith("javascript:")) {
                str = str.replaceFirst("javascript:", "");
            }
            if (this.AQa == null) {
                this.AQa = new C16401b();
                this.APT.addJavascriptInterface(this.AQa, "xwalkTempCallBack");
            }
            C16401b c16401b = this.AQa;
            if (valueCallback != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                int i = c16401b.AQe;
                c16401b.AQe = i + 1;
                stringBuilder = stringBuilder2.append(i).toString();
                c16401b.AQd.put(stringBuilder, valueCallback);
            } else {
                stringBuilder = "";
            }
            this.APT.loadUrl("javascript:xwalkTempCallBack.notifyJava(" + stringBuilder + ", " + str + ")");
            AppMethodBeat.m2505o(84713);
        }
    }

    public final C24524e getDefalutOpProvider() {
        return this.APW;
    }

    public final void reload() {
        AppMethodBeat.m2504i(84714);
        this.APT.reload();
        AppMethodBeat.m2505o(84714);
    }

    public final void clearSslPreferences() {
        AppMethodBeat.m2504i(84715);
        this.APT.clearSslPreferences();
        AppMethodBeat.m2505o(84715);
    }

    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(84716);
        this.APT.loadData(str, str2, str3);
        AppMethodBeat.m2505o(84716);
    }

    public final int getContentHeight() {
        AppMethodBeat.m2504i(84717);
        int contentHeight = this.APT.getContentHeight();
        AppMethodBeat.m2505o(84717);
        return contentHeight;
    }

    public final float getScale() {
        AppMethodBeat.m2504i(84718);
        float scale = this.APT.getScale();
        AppMethodBeat.m2505o(84718);
        return scale;
    }

    public final int getVisibleTitleHeight() {
        AppMethodBeat.m2504i(84719);
        Object n = C6038e.m9510n(this.APT, "getVisibleTitleHeight");
        if (n == null) {
            AppMethodBeat.m2505o(84719);
            return 0;
        }
        int intValue = ((Integer) n).intValue();
        AppMethodBeat.m2505o(84719);
        return intValue;
    }

    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.m2504i(84720);
        boolean overlayHorizontalScrollbar = this.APT.overlayHorizontalScrollbar();
        AppMethodBeat.m2505o(84720);
        return overlayHorizontalScrollbar;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(84721);
        this.APT.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(84721);
    }

    public final boolean zoomOut() {
        AppMethodBeat.m2504i(84722);
        boolean zoomOut = this.APT.zoomOut();
        AppMethodBeat.m2505o(84722);
        return zoomOut;
    }

    public final boolean zoomIn() {
        AppMethodBeat.m2504i(84723);
        boolean zoomIn = this.APT.zoomIn();
        AppMethodBeat.m2505o(84723);
        return zoomIn;
    }

    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(84724);
        this.APT.loadUrl(str, map);
        AppMethodBeat.m2505o(84724);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(84725);
        this.APT.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(84725);
    }

    public final View getView() {
        return this.APT;
    }

    public final String getUrl() {
        AppMethodBeat.m2504i(84726);
        String url = this.APT.getUrl();
        AppMethodBeat.m2505o(84726);
        return url;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(84727);
        this.APT.removeJavascriptInterface(str);
        AppMethodBeat.m2505o(84727);
    }

    public final void stopLoading() {
        AppMethodBeat.m2504i(84728);
        this.APT.stopLoading();
        AppMethodBeat.m2505o(84728);
    }

    public final void setWebViewCallbackClient(C36591r c36591r) {
        if (this.APT != null) {
            this.APT.icr = c36591r;
        }
    }

    public final C41116b getHitTestResult() {
        AppMethodBeat.m2504i(84729);
        HitTestResult hitTestResult = this.APT.getHitTestResult();
        C41116b c41116b = new C41116b();
        c41116b.mType = hitTestResult.getType();
        c41116b.mExtra = hitTestResult.getExtra();
        AppMethodBeat.m2505o(84729);
        return c41116b;
    }

    public final String getTitle() {
        AppMethodBeat.m2504i(84730);
        String title = this.APT.getTitle();
        AppMethodBeat.m2505o(84730);
        return title;
    }

    public final void clearMatches() {
        AppMethodBeat.m2504i(84731);
        this.APT.clearMatches();
        AppMethodBeat.m2505o(84731);
    }

    public final void findNext(boolean z) {
        AppMethodBeat.m2504i(84732);
        this.APT.findNext(z);
        AppMethodBeat.m2505o(84732);
    }

    public final void findAllAsync(String str) {
        AppMethodBeat.m2504i(84733);
        this.APT.findAllAsync(str);
        AppMethodBeat.m2505o(84733);
    }

    public final String getVersionInfo() {
        AppMethodBeat.m2504i(84734);
        String str = "webviewtype = WV_KIND_SYS, version = " + XWalkEnvironment.getChromiunVersion() + ", V8 type=" + C41128i.dTV();
        AppMethodBeat.m2505o(84734);
        return str;
    }

    public final String getAbstractInfo() {
        AppMethodBeat.m2504i(84735);
        String versionInfo = getVersionInfo();
        AppMethodBeat.m2505o(84735);
        return versionInfo;
    }

    public final boolean isSupportExtendPluginForAppbrand() {
        return false;
    }

    public final C36592s getCurWebviewClient() {
        return this.APU;
    }

    public final C6031l getCurWebChromeClient() {
        return this.APV;
    }

    public final int getWebScrollY() {
        AppMethodBeat.m2504i(84736);
        int scrollY = this.APT.getScrollY();
        AppMethodBeat.m2505o(84736);
        return scrollY;
    }

    public final int getWebScrollX() {
        AppMethodBeat.m2504i(84737);
        int scrollX = getWebViewUI().getScrollX();
        AppMethodBeat.m2505o(84737);
        return scrollX;
    }

    public final boolean isOverScrollStart() {
        AppMethodBeat.m2504i(84738);
        if (getWebViewUI().getScrollY() == 0) {
            AppMethodBeat.m2505o(84738);
            return true;
        }
        AppMethodBeat.m2505o(84738);
        return false;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(C16404b c16404b) {
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_computeScroll() {
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(84739);
        this.APT.onResume();
        AppMethodBeat.m2505o(84739);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(84740);
        this.APT.onPause();
        AppMethodBeat.m2505o(84740);
    }

    public final C46827a getFullscreenVideoKind() {
        AppMethodBeat.m2504i(84741);
        C46827a auW = C44572a.auW(WebView.getCurStrModule());
        AppMethodBeat.m2505o(84741);
        return auW;
    }

    public final void setJSExceptionListener(C6035t c6035t) {
    }

    public final boolean savePage(String str, String str2, int i) {
        return false;
    }

    public final void clearHistory() {
        AppMethodBeat.m2504i(84742);
        this.APT.clearHistory();
        AppMethodBeat.m2505o(84742);
    }

    public final boolean canGoForward() {
        AppMethodBeat.m2504i(84743);
        boolean canGoForward = this.APT.canGoForward();
        AppMethodBeat.m2505o(84743);
        return canGoForward;
    }

    public final boolean supportFeature(int i) {
        return false;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(84744);
        this.APT.setVerticalScrollBarEnabled(z);
        AppMethodBeat.m2505o(84744);
    }

    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(84745);
        this.APT.setHorizontalScrollBarEnabled(z);
        AppMethodBeat.m2505o(84745);
    }
}

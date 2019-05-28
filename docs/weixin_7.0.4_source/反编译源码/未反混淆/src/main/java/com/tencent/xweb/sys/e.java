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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.j;
import com.tencent.xweb.extension.video.d;
import com.tencent.xweb.i;
import com.tencent.xweb.l;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import com.tencent.xweb.util.f;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class e implements h {
    WebView APS;
    a APT;
    s APU;
    l APV;
    d APW;
    f APX;
    long APY = 0;
    com.tencent.xweb.extension.video.b APZ;
    b AQa;
    final String AQb = "xwalkTempCallBack";
    private WebViewClient bOQ = new WebViewClient() {
        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(84686);
            Log.i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(str)));
            boolean a;
            if (e.this.APU != null) {
                a = e.this.APU.a(e.this.APS, str);
                AppMethodBeat.o(84686);
                return a;
            }
            a = super.shouldOverrideUrlLoading(webView, str);
            AppMethodBeat.o(84686);
            return a;
        }

        public final void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(84687);
            Log.i("SysWebView", "onPageStarted ".concat(String.valueOf(str)));
            if (e.this.APU != null) {
                e.this.APU.b(e.this.APS, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            e.this.APY = System.currentTimeMillis();
            f.avo(str);
            f.dUO();
            if (e.this.APZ != null) {
                e.this.APZ.am(true, e.this.APS.getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS);
            }
            AppMethodBeat.o(84687);
        }

        public final void onPageFinished(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(84688);
            Log.i("SysWebView", "onPageFinished ".concat(String.valueOf(str)));
            if (e.this.APZ != null) {
                e.this.APZ.am(false, e.this.APS.getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS);
            }
            if (e.this.APU != null) {
                e.this.APU.b(e.this.APS, str);
            } else {
                super.onPageFinished(webView, str);
            }
            f.nJ(System.currentTimeMillis() - e.this.APY);
            f.nK(System.currentTimeMillis() - e.this.APY);
            j.dUB().dUH();
            AppMethodBeat.o(84688);
        }

        public final void onLoadResource(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(84689);
            if (e.this.APU != null) {
                e.this.APU.h(e.this.APS, str);
                AppMethodBeat.o(84689);
                return;
            }
            super.onLoadResource(webView, str);
            AppMethodBeat.o(84689);
        }

        public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(84690);
            WebResourceResponse a;
            if (e.this.APU != null) {
                a = c.a(e.this.APU.c(e.this.APS, str));
                AppMethodBeat.o(84690);
                return a;
            }
            a = super.shouldInterceptRequest(webView, str);
            AppMethodBeat.o(84690);
            return a;
        }

        public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
            o oVar = null;
            AppMethodBeat.i(84691);
            WebResourceResponse a;
            if (e.this.APU != null) {
                Bundle bundle;
                n eVar = new com.tencent.xweb.sys.c.e(webResourceRequest);
                if (eVar.APN == null) {
                    bundle = null;
                } else {
                    bundle = eVar.APN.getBundle();
                }
                if (bundle != null) {
                    oVar = e.this.APU.a(e.this.APS, eVar, bundle);
                }
                if (oVar == null) {
                    oVar = e.this.APU.a(e.this.APS, eVar);
                }
                a = c.a(oVar);
                AppMethodBeat.o(84691);
                return a;
            }
            a = super.shouldInterceptRequest(webView, webResourceRequest);
            AppMethodBeat.o(84691);
            return a;
        }

        public final void onScaleChanged(android.webkit.WebView webView, float f, float f2) {
            AppMethodBeat.i(84692);
            if (e.this.APU != null) {
                e.this.APU.a(e.this.APS, f, f2);
                AppMethodBeat.o(84692);
                return;
            }
            super.onScaleChanged(webView, f, f2);
            AppMethodBeat.o(84692);
        }

        public final void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
            AppMethodBeat.i(84693);
            if (e.this.APU != null) {
                e.this.APU.a(e.this.APS, str, z);
                AppMethodBeat.o(84693);
                return;
            }
            super.doUpdateVisitedHistory(webView, str, z);
            AppMethodBeat.o(84693);
        }

        public final void onReceivedError(android.webkit.WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(84694);
            if (e.this.APU != null) {
                e.this.APU.a(e.this.APS, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            f.dUN();
            f.dUP();
            j.dUB().dUI();
            AppMethodBeat.o(84694);
        }

        public final void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.i(84695);
            Log.i("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (e.this.APU != null) {
                e.this.APU.a(e.this.APS, new com.tencent.xweb.sys.c.a(sslErrorHandler), sslError);
                AppMethodBeat.o(84695);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AppMethodBeat.o(84695);
        }

        public final void onReceivedHttpError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AppMethodBeat.i(84696);
            Log.i("SysWebView", "onReceivedHttpError code:".concat(String.valueOf(VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : "Invalid")));
            if (e.this.APU != null) {
                o oVar;
                s sVar = e.this.APU;
                WebView webView2 = e.this.APS;
                n eVar = new com.tencent.xweb.sys.c.e(webResourceRequest);
                if (webResourceResponse == null) {
                    oVar = null;
                } else if (VERSION.SDK_INT >= 21) {
                    oVar = new o(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
                } else {
                    oVar = new o(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
                }
                sVar.a(webView2, eVar, oVar);
                AppMethodBeat.o(84696);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            AppMethodBeat.o(84696);
        }
    };
    private WebChromeClient bOR = new SysWebView$1(this);

    class a extends android.webkit.WebView {
        public r icr;

        public a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(84697);
            super.onScrollChanged(i, i2, i3, i4);
            if (e.this.APS != null) {
                e.this.APS.onWebViewScrollChanged(i, i2, i3, i4);
            }
            if (this.icr != null) {
                this.icr.onScrollChanged(i, i2, i3, i4, this);
            }
            AppMethodBeat.o(84697);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AppMethodBeat.i(84698);
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && e.this.hasEnteredFullscreen()) {
                e.this.leaveFullscreen();
                AppMethodBeat.o(84698);
                return true;
            }
            AppMethodBeat.o(84698);
            return false;
        }
    }

    public static class b {
        HashMap<String, ValueCallback<String>> AQd = new HashMap();
        int AQe = 0;

        public b() {
            AppMethodBeat.i(84699);
            AppMethodBeat.o(84699);
        }

        @JavascriptInterface
        public final void notifyJava(String str, String str2) {
            AppMethodBeat.i(84700);
            ValueCallback valueCallback = (ValueCallback) this.AQd.get(str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str2);
                this.AQd.remove(str);
            }
            AppMethodBeat.o(84700);
        }
    }

    public e(WebView webView) {
        AppMethodBeat.i(84701);
        this.APS = webView;
        this.APT = new a(webView.getContext());
        this.APT.setBackgroundColor(0);
        getSettings();
        this.APW = new d(this.APT);
        this.APT.setWebChromeClient(this.bOR);
        this.APT.setWebViewClient(this.bOQ);
        if (VERSION.SDK_INT < 19) {
            this.AQa = new b();
            this.APT.addJavascriptInterface(this.AQa, "xwalkTempCallBack");
        }
        if (webView.getContext() instanceof Activity) {
            aH((Activity) webView.getContext());
            AppMethodBeat.o(84701);
            return;
        }
        aH(null);
        AppMethodBeat.o(84701);
    }

    private void aH(Activity activity) {
        AppMethodBeat.i(84702);
        Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + activity);
        if (getFullscreenVideoKind() == com.tencent.xweb.WebView.a.NOT_HOOK) {
            AppMethodBeat.o(84702);
            return;
        }
        this.APZ = com.tencent.xweb.extension.video.e.a(activity, this.APS, this.APT, d.dUq());
        if (getFullscreenVideoKind() == com.tencent.xweb.WebView.a.HOOK_EVALUTE_JS) {
            this.APZ.dh(this.APT);
        }
        AppMethodBeat.o(84702);
    }

    public final p getSettings() {
        AppMethodBeat.i(84703);
        if (this.APX != null) {
            f fVar = this.APX;
            AppMethodBeat.o(84703);
            return fVar;
        } else if (this.APT == null) {
            AppMethodBeat.o(84703);
            return null;
        } else {
            this.APX = new f(this.APT);
            p pVar = this.APX;
            AppMethodBeat.o(84703);
            return pVar;
        }
    }

    public final View getWebViewUI() {
        return this.APT;
    }

    public final ViewGroup getTopView() {
        return this.APT;
    }

    public final void setWebViewClient(s sVar) {
        this.APU = sVar;
    }

    public final void setWebChromeClient(l lVar) {
        this.APV = lVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(84704);
        this.APT.setDownloadListener(downloadListener);
        AppMethodBeat.o(84704);
    }

    public final void setFindListener(FindListener findListener) {
        AppMethodBeat.i(84705);
        this.APT.setFindListener(findListener);
        AppMethodBeat.o(84705);
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(84706);
        this.APT.loadUrl(str);
        AppMethodBeat.o(84706);
    }

    public final boolean canGoBack() {
        AppMethodBeat.i(84707);
        boolean canGoBack = this.APT.canGoBack();
        AppMethodBeat.o(84707);
        return canGoBack;
    }

    public final void goBack() {
        AppMethodBeat.i(84708);
        this.APT.goBack();
        AppMethodBeat.o(84708);
    }

    public final boolean hasEnteredFullscreen() {
        AppMethodBeat.i(84709);
        if (this.APZ == null) {
            AppMethodBeat.o(84709);
            return false;
        }
        boolean hasEnteredFullscreen = this.APZ.hasEnteredFullscreen();
        AppMethodBeat.o(84709);
        return hasEnteredFullscreen;
    }

    public final void leaveFullscreen() {
        AppMethodBeat.i(84710);
        if (this.bOR != null) {
            this.bOR.onHideCustomView();
        }
        AppMethodBeat.o(84710);
    }

    public final void clearView() {
        AppMethodBeat.i(84711);
        this.APT.clearView();
        AppMethodBeat.o(84711);
    }

    public final void destroy() {
        AppMethodBeat.i(84712);
        this.APT.destroy();
        AppMethodBeat.o(84712);
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(84713);
        if (str == null) {
            AppMethodBeat.o(84713);
        } else if (VERSION.SDK_INT >= 19) {
            this.APT.evaluateJavascript(str, valueCallback);
            AppMethodBeat.o(84713);
        } else if (valueCallback == null) {
            this.APT.loadUrl(str);
            AppMethodBeat.o(84713);
        } else {
            String stringBuilder;
            if (str.trim().startsWith("javascript:")) {
                str = str.replaceFirst("javascript:", "");
            }
            if (this.AQa == null) {
                this.AQa = new b();
                this.APT.addJavascriptInterface(this.AQa, "xwalkTempCallBack");
            }
            b bVar = this.AQa;
            if (valueCallback != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                int i = bVar.AQe;
                bVar.AQe = i + 1;
                stringBuilder = stringBuilder2.append(i).toString();
                bVar.AQd.put(stringBuilder, valueCallback);
            } else {
                stringBuilder = "";
            }
            this.APT.loadUrl("javascript:xwalkTempCallBack.notifyJava(" + stringBuilder + ", " + str + ")");
            AppMethodBeat.o(84713);
        }
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.APW;
    }

    public final void reload() {
        AppMethodBeat.i(84714);
        this.APT.reload();
        AppMethodBeat.o(84714);
    }

    public final void clearSslPreferences() {
        AppMethodBeat.i(84715);
        this.APT.clearSslPreferences();
        AppMethodBeat.o(84715);
    }

    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(84716);
        this.APT.loadData(str, str2, str3);
        AppMethodBeat.o(84716);
    }

    public final int getContentHeight() {
        AppMethodBeat.i(84717);
        int contentHeight = this.APT.getContentHeight();
        AppMethodBeat.o(84717);
        return contentHeight;
    }

    public final float getScale() {
        AppMethodBeat.i(84718);
        float scale = this.APT.getScale();
        AppMethodBeat.o(84718);
        return scale;
    }

    public final int getVisibleTitleHeight() {
        AppMethodBeat.i(84719);
        Object n = com.tencent.xweb.util.e.n(this.APT, "getVisibleTitleHeight");
        if (n == null) {
            AppMethodBeat.o(84719);
            return 0;
        }
        int intValue = ((Integer) n).intValue();
        AppMethodBeat.o(84719);
        return intValue;
    }

    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(84720);
        boolean overlayHorizontalScrollbar = this.APT.overlayHorizontalScrollbar();
        AppMethodBeat.o(84720);
        return overlayHorizontalScrollbar;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(84721);
        this.APT.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(84721);
    }

    public final boolean zoomOut() {
        AppMethodBeat.i(84722);
        boolean zoomOut = this.APT.zoomOut();
        AppMethodBeat.o(84722);
        return zoomOut;
    }

    public final boolean zoomIn() {
        AppMethodBeat.i(84723);
        boolean zoomIn = this.APT.zoomIn();
        AppMethodBeat.o(84723);
        return zoomIn;
    }

    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(84724);
        this.APT.loadUrl(str, map);
        AppMethodBeat.o(84724);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(84725);
        this.APT.addJavascriptInterface(obj, str);
        AppMethodBeat.o(84725);
    }

    public final View getView() {
        return this.APT;
    }

    public final String getUrl() {
        AppMethodBeat.i(84726);
        String url = this.APT.getUrl();
        AppMethodBeat.o(84726);
        return url;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(84727);
        this.APT.removeJavascriptInterface(str);
        AppMethodBeat.o(84727);
    }

    public final void stopLoading() {
        AppMethodBeat.i(84728);
        this.APT.stopLoading();
        AppMethodBeat.o(84728);
    }

    public final void setWebViewCallbackClient(r rVar) {
        if (this.APT != null) {
            this.APT.icr = rVar;
        }
    }

    public final com.tencent.xweb.WebView.b getHitTestResult() {
        AppMethodBeat.i(84729);
        HitTestResult hitTestResult = this.APT.getHitTestResult();
        com.tencent.xweb.WebView.b bVar = new com.tencent.xweb.WebView.b();
        bVar.mType = hitTestResult.getType();
        bVar.mExtra = hitTestResult.getExtra();
        AppMethodBeat.o(84729);
        return bVar;
    }

    public final String getTitle() {
        AppMethodBeat.i(84730);
        String title = this.APT.getTitle();
        AppMethodBeat.o(84730);
        return title;
    }

    public final void clearMatches() {
        AppMethodBeat.i(84731);
        this.APT.clearMatches();
        AppMethodBeat.o(84731);
    }

    public final void findNext(boolean z) {
        AppMethodBeat.i(84732);
        this.APT.findNext(z);
        AppMethodBeat.o(84732);
    }

    public final void findAllAsync(String str) {
        AppMethodBeat.i(84733);
        this.APT.findAllAsync(str);
        AppMethodBeat.o(84733);
    }

    public final String getVersionInfo() {
        AppMethodBeat.i(84734);
        String str = "webviewtype = WV_KIND_SYS, version = " + XWalkEnvironment.getChromiunVersion() + ", V8 type=" + i.dTV();
        AppMethodBeat.o(84734);
        return str;
    }

    public final String getAbstractInfo() {
        AppMethodBeat.i(84735);
        String versionInfo = getVersionInfo();
        AppMethodBeat.o(84735);
        return versionInfo;
    }

    public final boolean isSupportExtendPluginForAppbrand() {
        return false;
    }

    public final s getCurWebviewClient() {
        return this.APU;
    }

    public final l getCurWebChromeClient() {
        return this.APV;
    }

    public final int getWebScrollY() {
        AppMethodBeat.i(84736);
        int scrollY = this.APT.getScrollY();
        AppMethodBeat.o(84736);
        return scrollY;
    }

    public final int getWebScrollX() {
        AppMethodBeat.i(84737);
        int scrollX = getWebViewUI().getScrollX();
        AppMethodBeat.o(84737);
        return scrollX;
    }

    public final boolean isOverScrollStart() {
        AppMethodBeat.i(84738);
        if (getWebViewUI().getScrollY() == 0) {
            AppMethodBeat.o(84738);
            return true;
        }
        AppMethodBeat.o(84738);
        return false;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
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
        AppMethodBeat.i(84739);
        this.APT.onResume();
        AppMethodBeat.o(84739);
    }

    public final void onPause() {
        AppMethodBeat.i(84740);
        this.APT.onPause();
        AppMethodBeat.o(84740);
    }

    public final com.tencent.xweb.WebView.a getFullscreenVideoKind() {
        AppMethodBeat.i(84741);
        com.tencent.xweb.WebView.a auW = com.tencent.xweb.a.auW(WebView.getCurStrModule());
        AppMethodBeat.o(84741);
        return auW;
    }

    public final void setJSExceptionListener(t tVar) {
    }

    public final boolean savePage(String str, String str2, int i) {
        return false;
    }

    public final void clearHistory() {
        AppMethodBeat.i(84742);
        this.APT.clearHistory();
        AppMethodBeat.o(84742);
    }

    public final boolean canGoForward() {
        AppMethodBeat.i(84743);
        boolean canGoForward = this.APT.canGoForward();
        AppMethodBeat.o(84743);
        return canGoForward;
    }

    public final boolean supportFeature(int i) {
        return false;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(84744);
        this.APT.setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(84744);
    }

    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(84745);
        this.APT.setHorizontalScrollBarEnabled(z);
        AppMethodBeat.o(84745);
    }
}

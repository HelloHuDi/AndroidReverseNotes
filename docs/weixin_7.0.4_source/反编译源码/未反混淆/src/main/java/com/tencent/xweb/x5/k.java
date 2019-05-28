package com.tencent.xweb.x5;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.WebView.FindListener;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.h;
import com.tencent.xweb.c.j;
import com.tencent.xweb.i;
import com.tencent.xweb.l;
import com.tencent.xweb.p;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import com.tencent.xweb.x5.g.b;
import com.tencent.xweb.x5.g.c;
import com.tencent.xweb.x5.g.d;
import com.tencent.xweb.x5.g.e;
import com.tencent.xweb.x5.g.f;
import com.tencent.xweb.x5.g.g;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class k implements h {
    WebView APS;
    s APU;
    l APV;
    long APY = 0;
    com.tencent.smtt.sdk.WebView AQH;
    i AQN;
    l AQO;
    String AQP = "";
    private b AQQ = new b() {
        public final void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {
            AppMethodBeat.i(84883);
            if (k.this.APV != null) {
                k.this.APV.a(k.this.APS, i);
                AppMethodBeat.o(84883);
                return;
            }
            super.onProgressChanged(webView, i);
            AppMethodBeat.o(84883);
        }

        public final void onReceivedTitle(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(84884);
            Log.i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(str)));
            if (k.this.APV != null) {
                k.this.APV.d(k.this.APS, str);
                AppMethodBeat.o(84884);
                return;
            }
            super.onReceivedTitle(webView, str);
            AppMethodBeat.o(84884);
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.i(84885);
            Log.i("X5WebView", "onShowCustomView");
            if (k.this.APV != null) {
                k.this.APV.onShowCustomView(view, new c(customViewCallback));
                AppMethodBeat.o(84885);
                return;
            }
            super.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(84885);
        }

        public final void onHideCustomView() {
            AppMethodBeat.i(84886);
            Log.i("X5WebView", "onHideCustomView");
            if (k.this.APV != null) {
                k.this.APV.onHideCustomView();
                AppMethodBeat.o(84886);
                return;
            }
            super.onHideCustomView();
            AppMethodBeat.o(84886);
        }

        public final boolean onJsAlert(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(84887);
            Log.i("X5WebView", "onJsAlert");
            boolean a;
            if (k.this.APV != null) {
                a = k.this.APV.a(k.this.APS, str, str2, new f(jsResult));
                AppMethodBeat.o(84887);
                return a;
            }
            a = super.onJsAlert(webView, str, str2, jsResult);
            AppMethodBeat.o(84887);
            return a;
        }

        public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(84888);
            Log.i("X5WebView", "onJsConfirm");
            boolean b;
            if (k.this.APV != null) {
                b = k.this.APV.b(k.this.APS, str, str2, new f(jsResult));
                AppMethodBeat.o(84888);
                return b;
            }
            b = super.onJsConfirm(webView, str, str2, jsResult);
            AppMethodBeat.o(84888);
            return b;
        }

        public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AppMethodBeat.i(84889);
            Log.i("X5WebView", "onJsPrompt");
            boolean a;
            if (k.this.APV != null) {
                a = k.this.APV.a(k.this.APS, str, str2, str3, new g(jsPromptResult));
                AppMethodBeat.o(84889);
                return a;
            }
            a = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            AppMethodBeat.o(84889);
            return a;
        }

        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            AppMethodBeat.i(84890);
            Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
            if (k.this.APV != null) {
                k.this.APV.onGeolocationPermissionsShowPrompt(str, new e(geolocationPermissionsCallback));
                AppMethodBeat.o(84890);
                return;
            }
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            AppMethodBeat.o(84890);
        }

        public final void onGeolocationPermissionsHidePrompt() {
            AppMethodBeat.i(84891);
            Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
            if (k.this.APV == null) {
                super.onGeolocationPermissionsHidePrompt();
            }
            AppMethodBeat.o(84891);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(84892);
            Log.i("X5WebView", "onConsoleMessage " + consoleMessage.message());
            boolean onConsoleMessage;
            if (k.this.APV != null) {
                android.webkit.ConsoleMessage consoleMessage2;
                l lVar = k.this.APV;
                if (consoleMessage == null) {
                    consoleMessage2 = null;
                } else {
                    MessageLevel messageLevel = MessageLevel.DEBUG;
                    switch (com.tencent.xweb.x5.g.AnonymousClass1.AQu[consoleMessage.messageLevel().ordinal()]) {
                        case 1:
                            messageLevel = MessageLevel.DEBUG;
                            break;
                        case 2:
                            messageLevel = MessageLevel.ERROR;
                            break;
                        case 3:
                            messageLevel = MessageLevel.LOG;
                            break;
                        case 4:
                            messageLevel = MessageLevel.TIP;
                            break;
                        case 5:
                            messageLevel = MessageLevel.WARNING;
                            break;
                    }
                    consoleMessage2 = new android.webkit.ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), messageLevel);
                }
                onConsoleMessage = lVar.onConsoleMessage(consoleMessage2);
                AppMethodBeat.o(84892);
                return onConsoleMessage;
            }
            onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(84892);
            return onConsoleMessage;
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.i(84893);
            Log.i("X5WebView", "openFileChooser with three param");
            if (k.this.APV != null) {
                k.this.APV.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.o(84893);
                return;
            }
            valueCallback.onReceiveValue(null);
            AppMethodBeat.o(84893);
        }

        public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            AppMethodBeat.i(84894);
            Log.i("X5WebView", "onShowFileChooser last method");
            boolean a;
            if (k.this.APV != null) {
                a = k.this.APV.a(k.this.APS, valueCallback, new d(fileChooserParams));
                AppMethodBeat.o(84894);
                return a;
            }
            a = super.onShowFileChooser(webView, new a.d(valueCallback), fileChooserParams);
            AppMethodBeat.o(84894);
            return a;
        }

        public final View getVideoLoadingProgressView() {
            AppMethodBeat.i(84895);
            View videoLoadingProgressView;
            if (k.this.APV != null) {
                videoLoadingProgressView = k.this.APV.getVideoLoadingProgressView();
                AppMethodBeat.o(84895);
                return videoLoadingProgressView;
            }
            videoLoadingProgressView = super.getVideoLoadingProgressView();
            AppMethodBeat.o(84895);
            return videoLoadingProgressView;
        }
    };
    private c AQR = new c() {
        public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(84896);
            Log.i("X5WebView", "shouldOverrideUrlLoading ".concat(String.valueOf(str)));
            boolean a;
            if (k.this.APU != null) {
                a = k.this.APU.a(k.this.APS, str);
                AppMethodBeat.o(84896);
                return a;
            }
            a = super.shouldOverrideUrlLoading(webView, str);
            AppMethodBeat.o(84896);
            return a;
        }

        public final void onPageStarted(com.tencent.smtt.sdk.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(84897);
            Log.i("X5WebView", "onPageStarted ".concat(String.valueOf(str)));
            if (k.this.APU != null) {
                k.this.APU.b(k.this.APS, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            k.this.AQP = "";
            k.this.APY = System.currentTimeMillis();
            com.tencent.xweb.util.f.avo(str);
            com.tencent.xweb.util.f.dUQ();
            j.dUB().dUx();
            AppMethodBeat.o(84897);
        }

        public final void onPageFinished(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(84898);
            Log.i("X5WebView", "onPageFinished ".concat(String.valueOf(str)));
            if (k.this.APU != null) {
                k.this.APU.b(k.this.APS, str);
            } else {
                super.onPageFinished(webView, str);
            }
            if (k.this.AQP == null || !k.this.AQP.equals(str)) {
                j.dUB().dUy();
            }
            com.tencent.xweb.util.f.nJ(System.currentTimeMillis() - k.this.APY);
            com.tencent.xweb.util.f.nL(System.currentTimeMillis() - k.this.APY);
            AppMethodBeat.o(84898);
        }

        public final void onLoadResource(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(84899);
            if (k.this.APU != null) {
                k.this.APU.h(k.this.APS, str);
                AppMethodBeat.o(84899);
                return;
            }
            super.onLoadResource(webView, str);
            AppMethodBeat.o(84899);
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.i(84900);
            WebResourceResponse b;
            if (k.this.APU != null) {
                b = a.b(k.this.APU.c(k.this.APS, str));
                AppMethodBeat.o(84900);
                return b;
            }
            b = super.shouldInterceptRequest(webView, str);
            AppMethodBeat.o(84900);
            return b;
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(84901);
            WebResourceResponse b;
            if (k.this.APU != null) {
                b = a.b(k.this.APU.a(k.this.APS, new b(webResourceRequest)));
                AppMethodBeat.o(84901);
                return b;
            }
            b = super.shouldInterceptRequest(webView, webResourceRequest);
            AppMethodBeat.o(84901);
            return b;
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(84902);
            WebResourceResponse b;
            if (k.this.APU != null) {
                b = a.b(k.this.APU.a(k.this.APS, new b(webResourceRequest), bundle));
                AppMethodBeat.o(84902);
                return b;
            }
            b = super.shouldInterceptRequest(webView, webResourceRequest, bundle);
            AppMethodBeat.o(84902);
            return b;
        }

        public final void onScaleChanged(com.tencent.smtt.sdk.WebView webView, float f, float f2) {
            AppMethodBeat.i(84903);
            if (k.this.APU != null) {
                k.this.APU.a(k.this.APS, f, f2);
                AppMethodBeat.o(84903);
                return;
            }
            super.onScaleChanged(webView, f, f2);
            AppMethodBeat.o(84903);
        }

        public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView webView, String str, boolean z) {
            AppMethodBeat.i(84904);
            if (k.this.APU != null) {
                k.this.APU.a(k.this.APS, str, z);
                AppMethodBeat.o(84904);
                return;
            }
            super.doUpdateVisitedHistory(webView, str, z);
            AppMethodBeat.o(84904);
        }

        public final void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(84905);
            if (k.this.APU != null) {
                k.this.APU.a(k.this.APS, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            k.this.AQP = str2;
            com.tencent.xweb.util.f.dUN();
            j.dUB().dUC();
            com.tencent.xweb.util.f.dUR();
            AppMethodBeat.o(84905);
        }

        public final void onReceivedSslError(com.tencent.smtt.sdk.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.i(84906);
            Log.i("X5WebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (k.this.APU != null) {
                android.net.http.SslError sslError2;
                s sVar = k.this.APU;
                WebView webView2 = k.this.APS;
                com.tencent.xweb.j aVar = new com.tencent.xweb.x5.g.a(sslErrorHandler);
                if (sslError != null) {
                    sslError2 = new android.net.http.SslError(sslError.getPrimaryError(), sslError.getCertificate());
                } else {
                    sslError2 = null;
                }
                sVar.a(webView2, aVar, sslError2);
                AppMethodBeat.o(84906);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AppMethodBeat.o(84906);
        }

        public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AppMethodBeat.i(84907);
            Log.i("X5WebView", "onReceivedHttpError code:" + webResourceResponse.getStatusCode());
            if (k.this.APU != null) {
                k.this.APU.a(k.this.APS, new b(webResourceRequest), g.a(webResourceResponse));
                AppMethodBeat.o(84907);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            AppMethodBeat.o(84907);
        }
    };

    class a extends com.tencent.smtt.sdk.WebView {
        public a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.i(84908);
            super.onScrollChanged(i, i2, i3, i4);
            if (k.this.APS != null) {
                k.this.APS.onWebViewScrollChanged(i, i2, i3, i4);
            }
            AppMethodBeat.o(84908);
        }
    }

    public k(WebView webView) {
        AppMethodBeat.i(84909);
        this.APS = webView;
        this.AQH = new a(webView.getContext());
        this.AQH.setBackgroundColor(0);
        this.AQN = new i(this.AQH);
        this.AQH.setWebChromeClient(this.AQQ);
        this.AQH.setWebViewClient(this.AQR);
        this.AQN.AQF = this.AQR;
        this.AQN.AQG = this.AQQ;
        AppMethodBeat.o(84909);
    }

    public final Object getX5WebViewExtension() {
        AppMethodBeat.i(84910);
        IX5WebViewExtension x5WebViewExtension = this.AQH.getX5WebViewExtension();
        AppMethodBeat.o(84910);
        return x5WebViewExtension;
    }

    public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
        AppMethodBeat.i(84911);
        if (bVar == null) {
            this.AQH.setWebViewClientExtension(null);
            AppMethodBeat.o(84911);
            return;
        }
        this.AQH.setWebViewClientExtension(new ProxyWebViewSuperWrapper(bVar));
        AppMethodBeat.o(84911);
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(84912);
        boolean super_onTouchEvent = this.AQH.super_onTouchEvent(motionEvent);
        AppMethodBeat.o(84912);
        return super_onTouchEvent;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(84913);
        boolean super_onInterceptTouchEvent = this.AQH.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(84913);
        return super_onInterceptTouchEvent;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(84914);
        this.AQH.super_onOverScrolled(i, i2, z, z2);
        AppMethodBeat.o(84914);
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(84915);
        boolean super_dispatchTouchEvent = this.AQH.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(84915);
        return super_dispatchTouchEvent;
    }

    public final void super_computeScroll() {
        AppMethodBeat.i(84916);
        this.AQH.super_computeScroll();
        AppMethodBeat.o(84916);
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(84917);
        this.AQH.super_onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.o(84917);
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.i(84918);
        boolean super_overScrollBy = this.AQH.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.o(84918);
        return super_overScrollBy;
    }

    public final void onResume() {
        AppMethodBeat.i(84919);
        this.AQH.onResume();
        AppMethodBeat.o(84919);
    }

    public final void onPause() {
        AppMethodBeat.i(84920);
        this.AQH.onPause();
        AppMethodBeat.o(84920);
    }

    public final p getSettings() {
        AppMethodBeat.i(84921);
        if (this.AQO != null) {
            l lVar = this.AQO;
            AppMethodBeat.o(84921);
            return lVar;
        } else if (this.AQH == null) {
            AppMethodBeat.o(84921);
            return null;
        } else {
            this.AQO = new l(this.AQH);
            p pVar = this.AQO;
            AppMethodBeat.o(84921);
            return pVar;
        }
    }

    public final View getView() {
        AppMethodBeat.i(84922);
        View view = this.AQH.getView();
        AppMethodBeat.o(84922);
        return view;
    }

    public final ViewGroup getTopView() {
        AppMethodBeat.i(84923);
        ViewGroup viewGroup = (ViewGroup) this.AQH.getView();
        AppMethodBeat.o(84923);
        return viewGroup;
    }

    public final View getWebViewUI() {
        return this.AQH;
    }

    public final void setWebViewClient(s sVar) {
        this.APU = sVar;
    }

    public final void setWebChromeClient(l lVar) {
        this.APV = lVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(84924);
        this.AQH.setDownloadListener(new com.tencent.xweb.x5.a.a(downloadListener));
        AppMethodBeat.o(84924);
    }

    public final void setFindListener(FindListener findListener) {
        AppMethodBeat.i(84925);
        this.AQH.setFindListener(new a.b(findListener));
        AppMethodBeat.o(84925);
    }

    public final void loadUrl(String str) {
        AppMethodBeat.i(84926);
        this.AQH.loadUrl(str);
        AppMethodBeat.o(84926);
    }

    public final boolean canGoBack() {
        AppMethodBeat.i(84927);
        boolean canGoBack = this.AQH.canGoBack();
        AppMethodBeat.o(84927);
        return canGoBack;
    }

    public final void goBack() {
        AppMethodBeat.i(84928);
        this.AQH.goBack();
        AppMethodBeat.o(84928);
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        AppMethodBeat.i(84929);
        this.AQH.clearView();
        AppMethodBeat.o(84929);
    }

    public final void destroy() {
        AppMethodBeat.i(84930);
        this.AQH.destroy();
        AppMethodBeat.o(84930);
    }

    public final void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        AppMethodBeat.i(84931);
        this.AQH.evaluateJavascript(str, new a.d(valueCallback));
        AppMethodBeat.o(84931);
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.AQN;
    }

    public final void reload() {
        AppMethodBeat.i(84932);
        this.AQH.reload();
        AppMethodBeat.o(84932);
    }

    public final void clearSslPreferences() {
        AppMethodBeat.i(84933);
        this.AQH.clearSslPreferences();
        AppMethodBeat.o(84933);
    }

    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(84934);
        this.AQH.loadData(str, str2, str3);
        AppMethodBeat.o(84934);
    }

    public final int getContentHeight() {
        AppMethodBeat.i(84935);
        int contentHeight = this.AQH.getContentHeight();
        AppMethodBeat.o(84935);
        return contentHeight;
    }

    public final float getScale() {
        AppMethodBeat.i(84936);
        float scale = this.AQH.getScale();
        AppMethodBeat.o(84936);
        return scale;
    }

    public final int getVisibleTitleHeight() {
        AppMethodBeat.i(84937);
        int visibleTitleHeight = this.AQH.getVisibleTitleHeight();
        AppMethodBeat.o(84937);
        return visibleTitleHeight;
    }

    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(84938);
        boolean overlayHorizontalScrollbar = this.AQH.overlayHorizontalScrollbar();
        AppMethodBeat.o(84938);
        return overlayHorizontalScrollbar;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(84939);
        this.AQH.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(84939);
    }

    public final boolean zoomOut() {
        AppMethodBeat.i(84940);
        boolean zoomOut = this.AQH.zoomOut();
        AppMethodBeat.o(84940);
        return zoomOut;
    }

    public final boolean zoomIn() {
        AppMethodBeat.i(84941);
        boolean zoomIn = this.AQH.zoomIn();
        AppMethodBeat.o(84941);
        return zoomIn;
    }

    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(84942);
        this.AQH.loadUrl(str, map);
        AppMethodBeat.o(84942);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(84943);
        this.AQH.addJavascriptInterface(obj, str);
        AppMethodBeat.o(84943);
    }

    public final String getUrl() {
        AppMethodBeat.i(84944);
        String url = this.AQH.getUrl();
        AppMethodBeat.o(84944);
        return url;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(84945);
        this.AQH.removeJavascriptInterface(str);
        AppMethodBeat.o(84945);
    }

    public final void stopLoading() {
        AppMethodBeat.i(84946);
        this.AQH.stopLoading();
        AppMethodBeat.o(84946);
    }

    public final void setWebViewCallbackClient(r rVar) {
        AppMethodBeat.i(84947);
        this.AQH.setWebViewCallbackClient(new a.f(rVar));
        AppMethodBeat.o(84947);
    }

    public final WebView.b getHitTestResult() {
        AppMethodBeat.i(84948);
        HitTestResult hitTestResult = this.AQH.getHitTestResult();
        WebView.b bVar = new WebView.b();
        bVar.mType = hitTestResult.getType();
        bVar.mExtra = hitTestResult.getExtra();
        AppMethodBeat.o(84948);
        return bVar;
    }

    public final String getTitle() {
        AppMethodBeat.i(84949);
        String title = this.AQH.getTitle();
        AppMethodBeat.o(84949);
        return title;
    }

    public final void clearMatches() {
        AppMethodBeat.i(84950);
        this.AQH.clearMatches();
        AppMethodBeat.o(84950);
    }

    public final void findNext(boolean z) {
        AppMethodBeat.i(84951);
        this.AQH.findNext(z);
        AppMethodBeat.o(84951);
    }

    public final void findAllAsync(String str) {
        AppMethodBeat.i(84952);
        this.AQH.findAllAsync(str);
        AppMethodBeat.o(84952);
    }

    public final String getVersionInfo() {
        AppMethodBeat.i(84953);
        String str;
        if ((this.AQH.getX5WebViewExtension() != null ? 1 : null) != null) {
            str = "use x5 and x5 kernel, sdk ver = " + WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + i.dTV();
            AppMethodBeat.o(84953);
            return str;
        }
        str = "use x5 wrapped sys kernel, sdk ver = " + WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + i.dTV();
        AppMethodBeat.o(84953);
        return str;
    }

    public final boolean isSupportExtendPluginForAppbrand() {
        return false;
    }

    public final String getAbstractInfo() {
        AppMethodBeat.i(84954);
        String str = "webviewtype = x5, is using x5 core = " + (this.AQH.getX5WebViewExtension() != null) + "\n core version = " + QbSdk.getTbsVersion(this.APS.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.APS.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.APS.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.APS.getContext());
        AppMethodBeat.o(84954);
        return str;
    }

    public final s getCurWebviewClient() {
        return this.APU;
    }

    public final l getCurWebChromeClient() {
        return this.APV;
    }

    public final int getWebScrollY() {
        AppMethodBeat.i(84955);
        int webScrollY = this.AQH.getWebScrollY();
        AppMethodBeat.o(84955);
        return webScrollY;
    }

    public final int getWebScrollX() {
        AppMethodBeat.i(84956);
        int scrollX = getWebViewUI().getScrollX();
        AppMethodBeat.o(84956);
        return scrollX;
    }

    public final boolean isOverScrollStart() {
        AppMethodBeat.i(84957);
        if (getView().getScrollY() == 0) {
            AppMethodBeat.o(84957);
            return true;
        }
        AppMethodBeat.o(84957);
        return false;
    }

    public final com.tencent.xweb.WebView.a getFullscreenVideoKind() {
        return com.tencent.xweb.WebView.a.NOT_HOOK;
    }

    public final void setJSExceptionListener(t tVar) {
    }

    public final boolean savePage(String str, String str2, int i) {
        return false;
    }

    public final void clearHistory() {
        AppMethodBeat.i(84958);
        this.AQH.clearHistory();
        AppMethodBeat.o(84958);
    }

    public final boolean canGoForward() {
        AppMethodBeat.i(84959);
        boolean canGoForward = this.AQH.canGoForward();
        AppMethodBeat.o(84959);
        return canGoForward;
    }

    public final boolean supportFeature(int i) {
        return false;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(84960);
        this.AQH.getView().setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(84960);
    }

    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(84961);
        this.AQH.getView().setHorizontalScrollBarEnabled(z);
        AppMethodBeat.o(84961);
    }
}

package com.tencent.xweb.p685x5;

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
import com.p802jg.EType;
import com.p802jg.JgClassChecked;
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
import com.tencent.xweb.C36588j;
import com.tencent.xweb.C36589p;
import com.tencent.xweb.C36591r;
import com.tencent.xweb.C36592s;
import com.tencent.xweb.C41128i;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.C6035t;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C41116b;
import com.tencent.xweb.WebView.C46827a;
import com.tencent.xweb.p1115c.C24524e;
import com.tencent.xweb.p1115c.C44579j;
import com.tencent.xweb.p1115c.C46832h;
import com.tencent.xweb.p685x5.C24535a.C24534f;
import com.tencent.xweb.p685x5.C24535a.C24537b;
import com.tencent.xweb.p685x5.C24535a.C24538d;
import com.tencent.xweb.p685x5.C24535a.C24539a;
import com.tencent.xweb.p685x5.C46836g.C164051;
import com.tencent.xweb.p685x5.C46836g.C24541c;
import com.tencent.xweb.p685x5.C46836g.C24542f;
import com.tencent.xweb.p685x5.C46836g.C25017d;
import com.tencent.xweb.p685x5.C46836g.C31151b;
import com.tencent.xweb.p685x5.C46836g.C36597e;
import com.tencent.xweb.p685x5.C46836g.C44591a;
import com.tencent.xweb.p685x5.C46836g.C44592g;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import com.tencent.xweb.p685x5.sdk.ProxyWebViewSuperWrapper;
import com.tencent.xweb.util.C24532f;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
/* renamed from: com.tencent.xweb.x5.k */
public final class C6042k implements C46832h {
    WebView APS;
    C36592s APU;
    C6031l APV;
    long APY = 0;
    com.tencent.smtt.sdk.WebView AQH;
    C36598i AQN;
    C36907l AQO;
    String AQP = "";
    private C31150b AQQ = new C60431();
    private C41133c AQR = new C60442();

    /* renamed from: com.tencent.xweb.x5.k$1 */
    class C60431 extends C31150b {
        C60431() {
        }

        public final void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {
            AppMethodBeat.m2504i(84883);
            if (C6042k.this.APV != null) {
                C6042k.this.APV.mo13205a(C6042k.this.APS, i);
                AppMethodBeat.m2505o(84883);
                return;
            }
            super.onProgressChanged(webView, i);
            AppMethodBeat.m2505o(84883);
        }

        public final void onReceivedTitle(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.m2504i(84884);
            Log.m81049i("X5WebView", "onReceivedTitle: ".concat(String.valueOf(str)));
            if (C6042k.this.APV != null) {
                C6042k.this.APV.mo7557d(C6042k.this.APS, str);
                AppMethodBeat.m2505o(84884);
                return;
            }
            super.onReceivedTitle(webView, str);
            AppMethodBeat.m2505o(84884);
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            AppMethodBeat.m2504i(84885);
            Log.m81049i("X5WebView", "onShowCustomView");
            if (C6042k.this.APV != null) {
                C6042k.this.APV.onShowCustomView(view, new C24541c(customViewCallback));
                AppMethodBeat.m2505o(84885);
                return;
            }
            super.onShowCustomView(view, customViewCallback);
            AppMethodBeat.m2505o(84885);
        }

        public final void onHideCustomView() {
            AppMethodBeat.m2504i(84886);
            Log.m81049i("X5WebView", "onHideCustomView");
            if (C6042k.this.APV != null) {
                C6042k.this.APV.onHideCustomView();
                AppMethodBeat.m2505o(84886);
                return;
            }
            super.onHideCustomView();
            AppMethodBeat.m2505o(84886);
        }

        public final boolean onJsAlert(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.m2504i(84887);
            Log.m81049i("X5WebView", "onJsAlert");
            boolean a;
            if (C6042k.this.APV != null) {
                a = C6042k.this.APV.mo13207a(C6042k.this.APS, str, str2, new C24542f(jsResult));
                AppMethodBeat.m2505o(84887);
                return a;
            }
            a = super.onJsAlert(webView, str, str2, jsResult);
            AppMethodBeat.m2505o(84887);
            return a;
        }

        public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.m2504i(84888);
            Log.m81049i("X5WebView", "onJsConfirm");
            boolean b;
            if (C6042k.this.APV != null) {
                b = C6042k.this.APV.mo13211b(C6042k.this.APS, str, str2, new C24542f(jsResult));
                AppMethodBeat.m2505o(84888);
                return b;
            }
            b = super.onJsConfirm(webView, str, str2, jsResult);
            AppMethodBeat.m2505o(84888);
            return b;
        }

        public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AppMethodBeat.m2504i(84889);
            Log.m81049i("X5WebView", "onJsPrompt");
            boolean a;
            if (C6042k.this.APV != null) {
                a = C6042k.this.APV.mo13208a(C6042k.this.APS, str, str2, str3, new C44592g(jsPromptResult));
                AppMethodBeat.m2505o(84889);
                return a;
            }
            a = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            AppMethodBeat.m2505o(84889);
            return a;
        }

        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            AppMethodBeat.m2504i(84890);
            Log.m81049i("X5WebView", "onGeolocationPermissionsShowPrompt");
            if (C6042k.this.APV != null) {
                C6042k.this.APV.onGeolocationPermissionsShowPrompt(str, new C36597e(geolocationPermissionsCallback));
                AppMethodBeat.m2505o(84890);
                return;
            }
            super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            AppMethodBeat.m2505o(84890);
        }

        public final void onGeolocationPermissionsHidePrompt() {
            AppMethodBeat.m2504i(84891);
            Log.m81049i("X5WebView", "onGeolocationPermissionsHidePrompt");
            if (C6042k.this.APV == null) {
                super.onGeolocationPermissionsHidePrompt();
            }
            AppMethodBeat.m2505o(84891);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(84892);
            Log.m81049i("X5WebView", "onConsoleMessage " + consoleMessage.message());
            boolean onConsoleMessage;
            if (C6042k.this.APV != null) {
                android.webkit.ConsoleMessage consoleMessage2;
                C6031l c6031l = C6042k.this.APV;
                if (consoleMessage == null) {
                    consoleMessage2 = null;
                } else {
                    MessageLevel messageLevel = MessageLevel.DEBUG;
                    switch (C164051.AQu[consoleMessage.messageLevel().ordinal()]) {
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
                onConsoleMessage = c6031l.onConsoleMessage(consoleMessage2);
                AppMethodBeat.m2505o(84892);
                return onConsoleMessage;
            }
            onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(84892);
            return onConsoleMessage;
        }

        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.m2504i(84893);
            Log.m81049i("X5WebView", "openFileChooser with three param");
            if (C6042k.this.APV != null) {
                C6042k.this.APV.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.m2505o(84893);
                return;
            }
            valueCallback.onReceiveValue(null);
            AppMethodBeat.m2505o(84893);
        }

        public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
            AppMethodBeat.m2504i(84894);
            Log.m81049i("X5WebView", "onShowFileChooser last method");
            boolean a;
            if (C6042k.this.APV != null) {
                a = C6042k.this.APV.mo13206a(C6042k.this.APS, valueCallback, new C25017d(fileChooserParams));
                AppMethodBeat.m2505o(84894);
                return a;
            }
            a = super.onShowFileChooser(webView, new C24538d(valueCallback), fileChooserParams);
            AppMethodBeat.m2505o(84894);
            return a;
        }

        public final View getVideoLoadingProgressView() {
            AppMethodBeat.m2504i(84895);
            View videoLoadingProgressView;
            if (C6042k.this.APV != null) {
                videoLoadingProgressView = C6042k.this.APV.getVideoLoadingProgressView();
                AppMethodBeat.m2505o(84895);
                return videoLoadingProgressView;
            }
            videoLoadingProgressView = super.getVideoLoadingProgressView();
            AppMethodBeat.m2505o(84895);
            return videoLoadingProgressView;
        }
    }

    /* renamed from: com.tencent.xweb.x5.k$2 */
    class C60442 extends C41133c {
        C60442() {
        }

        public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.m2504i(84896);
            Log.m81049i("X5WebView", "shouldOverrideUrlLoading ".concat(String.valueOf(str)));
            boolean a;
            if (C6042k.this.APU != null) {
                a = C6042k.this.APU.mo4762a(C6042k.this.APS, str);
                AppMethodBeat.m2505o(84896);
                return a;
            }
            a = super.shouldOverrideUrlLoading(webView, str);
            AppMethodBeat.m2505o(84896);
            return a;
        }

        public final void onPageStarted(com.tencent.smtt.sdk.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(84897);
            Log.m81049i("X5WebView", "onPageStarted ".concat(String.valueOf(str)));
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo7562b(C6042k.this.APS, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            C6042k.this.AQP = "";
            C6042k.this.APY = System.currentTimeMillis();
            C24532f.avo(str);
            C24532f.dUQ();
            C44579j.dUB().dUx();
            AppMethodBeat.m2505o(84897);
        }

        public final void onPageFinished(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.m2504i(84898);
            Log.m81049i("X5WebView", "onPageFinished ".concat(String.valueOf(str)));
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo5992b(C6042k.this.APS, str);
            } else {
                super.onPageFinished(webView, str);
            }
            if (C6042k.this.AQP == null || !C6042k.this.AQP.equals(str)) {
                C44579j.dUB().dUy();
            }
            C24532f.m38182nJ(System.currentTimeMillis() - C6042k.this.APY);
            C24532f.m38184nL(System.currentTimeMillis() - C6042k.this.APY);
            AppMethodBeat.m2505o(84898);
        }

        public final void onLoadResource(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.m2504i(84899);
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo7563h(C6042k.this.APS, str);
                AppMethodBeat.m2505o(84899);
                return;
            }
            super.onLoadResource(webView, str);
            AppMethodBeat.m2505o(84899);
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, String str) {
            AppMethodBeat.m2504i(84900);
            WebResourceResponse b;
            if (C6042k.this.APU != null) {
                b = C24535a.m38191b(C6042k.this.APU.mo5993c(C6042k.this.APS, str));
                AppMethodBeat.m2505o(84900);
                return b;
            }
            b = super.shouldInterceptRequest(webView, str);
            AppMethodBeat.m2505o(84900);
            return b;
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.m2504i(84901);
            WebResourceResponse b;
            if (C6042k.this.APU != null) {
                b = C24535a.m38191b(C6042k.this.APU.mo5990a(C6042k.this.APS, new C31151b(webResourceRequest)));
                AppMethodBeat.m2505o(84901);
                return b;
            }
            b = super.shouldInterceptRequest(webView, webResourceRequest);
            AppMethodBeat.m2505o(84901);
            return b;
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.m2504i(84902);
            WebResourceResponse b;
            if (C6042k.this.APU != null) {
                b = C24535a.m38191b(C6042k.this.APU.mo5991a(C6042k.this.APS, new C31151b(webResourceRequest), bundle));
                AppMethodBeat.m2505o(84902);
                return b;
            }
            b = super.shouldInterceptRequest(webView, webResourceRequest, bundle);
            AppMethodBeat.m2505o(84902);
            return b;
        }

        public final void onScaleChanged(com.tencent.smtt.sdk.WebView webView, float f, float f2) {
            AppMethodBeat.m2504i(84903);
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo37025a(C6042k.this.APS, f, f2);
                AppMethodBeat.m2505o(84903);
                return;
            }
            super.onScaleChanged(webView, f, f2);
            AppMethodBeat.m2505o(84903);
        }

        public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView webView, String str, boolean z) {
            AppMethodBeat.m2504i(84904);
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo26819a(C6042k.this.APS, str, z);
                AppMethodBeat.m2505o(84904);
                return;
            }
            super.doUpdateVisitedHistory(webView, str, z);
            AppMethodBeat.m2505o(84904);
        }

        public final void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(84905);
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo7559a(C6042k.this.APS, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            C6042k.this.AQP = str2;
            C24532f.dUN();
            C44579j.dUB().dUC();
            C24532f.dUR();
            AppMethodBeat.m2505o(84905);
        }

        public final void onReceivedSslError(com.tencent.smtt.sdk.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.m2504i(84906);
            Log.m81049i("X5WebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (C6042k.this.APU != null) {
                android.net.http.SslError sslError2;
                C36592s c36592s = C6042k.this.APU;
                WebView webView2 = C6042k.this.APS;
                C36588j c44591a = new C44591a(sslErrorHandler);
                if (sslError != null) {
                    sslError2 = new android.net.http.SslError(sslError.getPrimaryError(), sslError.getCertificate());
                } else {
                    sslError2 = null;
                }
                c36592s.mo7560a(webView2, c44591a, sslError2);
                AppMethodBeat.m2505o(84906);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AppMethodBeat.m2505o(84906);
        }

        public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AppMethodBeat.m2504i(84907);
            Log.m81049i("X5WebView", "onReceivedHttpError code:" + webResourceResponse.getStatusCode());
            if (C6042k.this.APU != null) {
                C6042k.this.APU.mo7561a(C6042k.this.APS, new C31151b(webResourceRequest), C46836g.m89071a(webResourceResponse));
                AppMethodBeat.m2505o(84907);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            AppMethodBeat.m2505o(84907);
        }
    }

    /* renamed from: com.tencent.xweb.x5.k$a */
    class C6045a extends com.tencent.smtt.sdk.WebView {
        public C6045a(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onScrollChanged(int i, int i2, int i3, int i4) {
            AppMethodBeat.m2504i(84908);
            super.onScrollChanged(i, i2, i3, i4);
            if (C6042k.this.APS != null) {
                C6042k.this.APS.onWebViewScrollChanged(i, i2, i3, i4);
            }
            AppMethodBeat.m2505o(84908);
        }
    }

    public C6042k(WebView webView) {
        AppMethodBeat.m2504i(84909);
        this.APS = webView;
        this.AQH = new C6045a(webView.getContext());
        this.AQH.setBackgroundColor(0);
        this.AQN = new C36598i(this.AQH);
        this.AQH.setWebChromeClient(this.AQQ);
        this.AQH.setWebViewClient(this.AQR);
        this.AQN.AQF = this.AQR;
        this.AQN.AQG = this.AQQ;
        AppMethodBeat.m2505o(84909);
    }

    public final Object getX5WebViewExtension() {
        AppMethodBeat.m2504i(84910);
        IX5WebViewExtension x5WebViewExtension = this.AQH.getX5WebViewExtension();
        AppMethodBeat.m2505o(84910);
        return x5WebViewExtension;
    }

    public final void setWebViewClientExtension(C16404b c16404b) {
        AppMethodBeat.m2504i(84911);
        if (c16404b == null) {
            this.AQH.setWebViewClientExtension(null);
            AppMethodBeat.m2505o(84911);
            return;
        }
        this.AQH.setWebViewClientExtension(new ProxyWebViewSuperWrapper(c16404b));
        AppMethodBeat.m2505o(84911);
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(84912);
        boolean super_onTouchEvent = this.AQH.super_onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(84912);
        return super_onTouchEvent;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(84913);
        boolean super_onInterceptTouchEvent = this.AQH.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(84913);
        return super_onInterceptTouchEvent;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        AppMethodBeat.m2504i(84914);
        this.AQH.super_onOverScrolled(i, i2, z, z2);
        AppMethodBeat.m2505o(84914);
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(84915);
        boolean super_dispatchTouchEvent = this.AQH.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(84915);
        return super_dispatchTouchEvent;
    }

    public final void super_computeScroll() {
        AppMethodBeat.m2504i(84916);
        this.AQH.super_computeScroll();
        AppMethodBeat.m2505o(84916);
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(84917);
        this.AQH.super_onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(84917);
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        AppMethodBeat.m2504i(84918);
        boolean super_overScrollBy = this.AQH.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        AppMethodBeat.m2505o(84918);
        return super_overScrollBy;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(84919);
        this.AQH.onResume();
        AppMethodBeat.m2505o(84919);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(84920);
        this.AQH.onPause();
        AppMethodBeat.m2505o(84920);
    }

    public final C36589p getSettings() {
        AppMethodBeat.m2504i(84921);
        if (this.AQO != null) {
            C36907l c36907l = this.AQO;
            AppMethodBeat.m2505o(84921);
            return c36907l;
        } else if (this.AQH == null) {
            AppMethodBeat.m2505o(84921);
            return null;
        } else {
            this.AQO = new C36907l(this.AQH);
            C36589p c36589p = this.AQO;
            AppMethodBeat.m2505o(84921);
            return c36589p;
        }
    }

    public final View getView() {
        AppMethodBeat.m2504i(84922);
        View view = this.AQH.getView();
        AppMethodBeat.m2505o(84922);
        return view;
    }

    public final ViewGroup getTopView() {
        AppMethodBeat.m2504i(84923);
        ViewGroup viewGroup = (ViewGroup) this.AQH.getView();
        AppMethodBeat.m2505o(84923);
        return viewGroup;
    }

    public final View getWebViewUI() {
        return this.AQH;
    }

    public final void setWebViewClient(C36592s c36592s) {
        this.APU = c36592s;
    }

    public final void setWebChromeClient(C6031l c6031l) {
        this.APV = c6031l;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.m2504i(84924);
        this.AQH.setDownloadListener(new C24539a(downloadListener));
        AppMethodBeat.m2505o(84924);
    }

    public final void setFindListener(FindListener findListener) {
        AppMethodBeat.m2504i(84925);
        this.AQH.setFindListener(new C24537b(findListener));
        AppMethodBeat.m2505o(84925);
    }

    public final void loadUrl(String str) {
        AppMethodBeat.m2504i(84926);
        this.AQH.loadUrl(str);
        AppMethodBeat.m2505o(84926);
    }

    public final boolean canGoBack() {
        AppMethodBeat.m2504i(84927);
        boolean canGoBack = this.AQH.canGoBack();
        AppMethodBeat.m2505o(84927);
        return canGoBack;
    }

    public final void goBack() {
        AppMethodBeat.m2504i(84928);
        this.AQH.goBack();
        AppMethodBeat.m2505o(84928);
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        AppMethodBeat.m2504i(84929);
        this.AQH.clearView();
        AppMethodBeat.m2505o(84929);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(84930);
        this.AQH.destroy();
        AppMethodBeat.m2505o(84930);
    }

    public final void evaluateJavascript(String str, android.webkit.ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(84931);
        this.AQH.evaluateJavascript(str, new C24538d(valueCallback));
        AppMethodBeat.m2505o(84931);
    }

    public final C24524e getDefalutOpProvider() {
        return this.AQN;
    }

    public final void reload() {
        AppMethodBeat.m2504i(84932);
        this.AQH.reload();
        AppMethodBeat.m2505o(84932);
    }

    public final void clearSslPreferences() {
        AppMethodBeat.m2504i(84933);
        this.AQH.clearSslPreferences();
        AppMethodBeat.m2505o(84933);
    }

    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(84934);
        this.AQH.loadData(str, str2, str3);
        AppMethodBeat.m2505o(84934);
    }

    public final int getContentHeight() {
        AppMethodBeat.m2504i(84935);
        int contentHeight = this.AQH.getContentHeight();
        AppMethodBeat.m2505o(84935);
        return contentHeight;
    }

    public final float getScale() {
        AppMethodBeat.m2504i(84936);
        float scale = this.AQH.getScale();
        AppMethodBeat.m2505o(84936);
        return scale;
    }

    public final int getVisibleTitleHeight() {
        AppMethodBeat.m2504i(84937);
        int visibleTitleHeight = this.AQH.getVisibleTitleHeight();
        AppMethodBeat.m2505o(84937);
        return visibleTitleHeight;
    }

    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.m2504i(84938);
        boolean overlayHorizontalScrollbar = this.AQH.overlayHorizontalScrollbar();
        AppMethodBeat.m2505o(84938);
        return overlayHorizontalScrollbar;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(84939);
        this.AQH.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(84939);
    }

    public final boolean zoomOut() {
        AppMethodBeat.m2504i(84940);
        boolean zoomOut = this.AQH.zoomOut();
        AppMethodBeat.m2505o(84940);
        return zoomOut;
    }

    public final boolean zoomIn() {
        AppMethodBeat.m2504i(84941);
        boolean zoomIn = this.AQH.zoomIn();
        AppMethodBeat.m2505o(84941);
        return zoomIn;
    }

    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.m2504i(84942);
        this.AQH.loadUrl(str, map);
        AppMethodBeat.m2505o(84942);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(84943);
        this.AQH.addJavascriptInterface(obj, str);
        AppMethodBeat.m2505o(84943);
    }

    public final String getUrl() {
        AppMethodBeat.m2504i(84944);
        String url = this.AQH.getUrl();
        AppMethodBeat.m2505o(84944);
        return url;
    }

    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.m2504i(84945);
        this.AQH.removeJavascriptInterface(str);
        AppMethodBeat.m2505o(84945);
    }

    public final void stopLoading() {
        AppMethodBeat.m2504i(84946);
        this.AQH.stopLoading();
        AppMethodBeat.m2505o(84946);
    }

    public final void setWebViewCallbackClient(C36591r c36591r) {
        AppMethodBeat.m2504i(84947);
        this.AQH.setWebViewCallbackClient(new C24534f(c36591r));
        AppMethodBeat.m2505o(84947);
    }

    public final C41116b getHitTestResult() {
        AppMethodBeat.m2504i(84948);
        HitTestResult hitTestResult = this.AQH.getHitTestResult();
        C41116b c41116b = new C41116b();
        c41116b.mType = hitTestResult.getType();
        c41116b.mExtra = hitTestResult.getExtra();
        AppMethodBeat.m2505o(84948);
        return c41116b;
    }

    public final String getTitle() {
        AppMethodBeat.m2504i(84949);
        String title = this.AQH.getTitle();
        AppMethodBeat.m2505o(84949);
        return title;
    }

    public final void clearMatches() {
        AppMethodBeat.m2504i(84950);
        this.AQH.clearMatches();
        AppMethodBeat.m2505o(84950);
    }

    public final void findNext(boolean z) {
        AppMethodBeat.m2504i(84951);
        this.AQH.findNext(z);
        AppMethodBeat.m2505o(84951);
    }

    public final void findAllAsync(String str) {
        AppMethodBeat.m2504i(84952);
        this.AQH.findAllAsync(str);
        AppMethodBeat.m2505o(84952);
    }

    public final String getVersionInfo() {
        AppMethodBeat.m2504i(84953);
        String str;
        if ((this.AQH.getX5WebViewExtension() != null ? 1 : null) != null) {
            str = "use x5 and x5 kernel, sdk ver = " + WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + C41128i.dTV();
            AppMethodBeat.m2505o(84953);
            return str;
        }
        str = "use x5 wrapped sys kernel, sdk ver = " + WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext()) + ", core ver = " + WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext()) + ", V8 type=" + C41128i.dTV();
        AppMethodBeat.m2505o(84953);
        return str;
    }

    public final boolean isSupportExtendPluginForAppbrand() {
        return false;
    }

    public final String getAbstractInfo() {
        AppMethodBeat.m2504i(84954);
        String str = "webviewtype = x5, is using x5 core = " + (this.AQH.getX5WebViewExtension() != null) + "\n core version = " + QbSdk.getTbsVersion(this.APS.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.APS.getContext()) + "\n canUseX5JsCore = " + X5JsCore.canUseX5JsCore(this.APS.getContext()) + "\n canUseNativeBuffer = " + X5JsCore.canX5JsCoreUseNativeBuffer(this.APS.getContext());
        AppMethodBeat.m2505o(84954);
        return str;
    }

    public final C36592s getCurWebviewClient() {
        return this.APU;
    }

    public final C6031l getCurWebChromeClient() {
        return this.APV;
    }

    public final int getWebScrollY() {
        AppMethodBeat.m2504i(84955);
        int webScrollY = this.AQH.getWebScrollY();
        AppMethodBeat.m2505o(84955);
        return webScrollY;
    }

    public final int getWebScrollX() {
        AppMethodBeat.m2504i(84956);
        int scrollX = getWebViewUI().getScrollX();
        AppMethodBeat.m2505o(84956);
        return scrollX;
    }

    public final boolean isOverScrollStart() {
        AppMethodBeat.m2504i(84957);
        if (getView().getScrollY() == 0) {
            AppMethodBeat.m2505o(84957);
            return true;
        }
        AppMethodBeat.m2505o(84957);
        return false;
    }

    public final C46827a getFullscreenVideoKind() {
        return C46827a.NOT_HOOK;
    }

    public final void setJSExceptionListener(C6035t c6035t) {
    }

    public final boolean savePage(String str, String str2, int i) {
        return false;
    }

    public final void clearHistory() {
        AppMethodBeat.m2504i(84958);
        this.AQH.clearHistory();
        AppMethodBeat.m2505o(84958);
    }

    public final boolean canGoForward() {
        AppMethodBeat.m2504i(84959);
        boolean canGoForward = this.AQH.canGoForward();
        AppMethodBeat.m2505o(84959);
        return canGoForward;
    }

    public final boolean supportFeature(int i) {
        return false;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(84960);
        this.AQH.getView().setVerticalScrollBarEnabled(z);
        AppMethodBeat.m2505o(84960);
    }

    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.m2504i(84961);
        this.AQH.getView().setHorizontalScrollBarEnabled(z);
        AppMethodBeat.m2505o(84961);
    }
}

package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.w;

class v extends X5ProxyWebViewClient {
    private static String c = null;
    private WebViewClient a;
    private WebView b;

    public v(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.b = webView;
        this.a = webViewClient;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(64138);
        super.onPageStarted(this.b.c(), 0, 0, str, bitmap);
        AppMethodBeat.o(64138);
    }

    public void a(String str) {
        AppMethodBeat.i(64130);
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.b.getContext() != null) {
                this.b.getContext().startActivity(intent);
            }
            AppMethodBeat.o(64130);
        } catch (Exception e) {
            AppMethodBeat.o(64130);
        }
    }

    public void countPVContentCacheCallBack(String str) {
        WebView webView = this.b;
        webView.a++;
    }

    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.i(64116);
        this.b.a(iX5WebViewBase);
        this.a.doUpdateVisitedHistory(this.b, str, z);
        AppMethodBeat.o(64116);
    }

    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        AppMethodBeat.i(64139);
        this.b.a(iX5WebViewBase);
        this.a.onDetectedBlankScreen(str, i);
        AppMethodBeat.o(64139);
    }

    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        AppMethodBeat.i(64117);
        this.b.a(iX5WebViewBase);
        this.a.onFormResubmission(this.b, message, message2);
        AppMethodBeat.o(64117);
    }

    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(64118);
        this.b.a(iX5WebViewBase);
        this.a.onLoadResource(this.b, str);
        AppMethodBeat.o(64118);
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        AppMethodBeat.i(64119);
        if (c == null) {
            w a = w.a();
            if (a != null) {
                a.a(false);
                c = Boolean.toString(false);
            }
        }
        this.b.a(iX5WebViewBase);
        WebView webView = this.b;
        webView.a++;
        this.a.onPageFinished(this.b, str);
        if (TbsConfig.APP_QZONE.equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            this.b.a(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
        WebView.d();
        if (!(TbsShareManager.mHasQueryed || this.b.getContext() == null || !TbsShareManager.isThirdPartyApp(this.b.getContext()))) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new w(this)).start();
        }
        if (!(this.b.getContext() == null || TbsLogReport.getInstance(this.b.getContext()).getShouldUploadEventReport())) {
            TbsLogReport.getInstance(this.b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.b.getContext()).dailyReport();
        }
        AppMethodBeat.o(64119);
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(64140);
        onPageFinished(iX5WebViewBase, 0, 0, str);
        AppMethodBeat.o(64140);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        AppMethodBeat.i(64120);
        this.b.a(iX5WebViewBase);
        this.a.onPageStarted(this.b, str, bitmap);
        AppMethodBeat.o(64120);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        AppMethodBeat.i(64141);
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
        AppMethodBeat.o(64141);
    }

    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(64126);
        this.b.a(iX5WebViewBase);
        this.a.onReceivedClientCertRequest(this.b, clientCertRequest);
        AppMethodBeat.o(64126);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        AppMethodBeat.i(64122);
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                AppMethodBeat.o(64122);
                return;
            }
        }
        this.b.a(iX5WebViewBase);
        this.a.onReceivedError(this.b, i, str, str2);
        AppMethodBeat.o(64122);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AppMethodBeat.i(64121);
        this.b.a(iX5WebViewBase);
        this.a.onReceivedError(this.b, webResourceRequest, webResourceError);
        AppMethodBeat.o(64121);
    }

    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.i(64124);
        this.b.a(iX5WebViewBase);
        this.a.onReceivedHttpAuthRequest(this.b, httpAuthHandler, str, str2);
        AppMethodBeat.o(64124);
    }

    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(64123);
        this.b.a(iX5WebViewBase);
        this.a.onReceivedHttpError(this.b, webResourceRequest, webResourceResponse);
        AppMethodBeat.o(64123);
    }

    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        AppMethodBeat.i(64137);
        this.b.a(iX5WebViewBase);
        this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        AppMethodBeat.o(64137);
    }

    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        AppMethodBeat.i(64125);
        this.b.a(iX5WebViewBase);
        this.a.onReceivedSslError(this.b, sslErrorHandler, sslError);
        AppMethodBeat.o(64125);
    }

    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        AppMethodBeat.i(64127);
        this.b.a(iX5WebViewBase);
        this.a.onScaleChanged(this.b, f, f2);
        AppMethodBeat.o(64127);
    }

    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        AppMethodBeat.i(64132);
        this.b.a(iX5WebViewBase);
        this.a.onTooManyRedirects(this.b, message, message2);
        AppMethodBeat.o(64132);
    }

    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        AppMethodBeat.i(64128);
        this.b.a(iX5WebViewBase);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
        AppMethodBeat.o(64128);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(64135);
        this.b.a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, webResourceRequest);
        AppMethodBeat.o(64135);
        return shouldInterceptRequest;
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(64136);
        this.b.a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, webResourceRequest, bundle);
        AppMethodBeat.o(64136);
        return shouldInterceptRequest;
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(64134);
        this.b.a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str);
        AppMethodBeat.o(64134);
        return shouldInterceptRequest;
    }

    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        AppMethodBeat.i(64129);
        this.b.a(iX5WebViewBase);
        boolean shouldOverrideKeyEvent = this.a.shouldOverrideKeyEvent(this.b, keyEvent);
        AppMethodBeat.o(64129);
        return shouldOverrideKeyEvent;
    }

    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(64133);
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.b.showDebugView(uri)) {
            AppMethodBeat.o(64133);
            return true;
        }
        this.b.a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.a.shouldOverrideUrlLoading(this.b, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (uri.startsWith("wtai://wp/mc;")) {
                this.b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(uri.substring(13)).toString())));
                AppMethodBeat.o(64133);
                return true;
            } else if (uri.startsWith(WebView.SCHEME_TEL)) {
                a(uri);
                AppMethodBeat.o(64133);
                return true;
            }
        }
        AppMethodBeat.o(64133);
        return shouldOverrideUrlLoading;
    }

    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(64131);
        if (str == null || this.b.showDebugView(str)) {
            AppMethodBeat.o(64131);
            return true;
        }
        this.b.a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.a.shouldOverrideUrlLoading(this.b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str.substring(13)).toString())));
                AppMethodBeat.o(64131);
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                a(str);
                AppMethodBeat.o(64131);
                return true;
            }
        }
        AppMethodBeat.o(64131);
        return shouldOverrideUrlLoading;
    }
}

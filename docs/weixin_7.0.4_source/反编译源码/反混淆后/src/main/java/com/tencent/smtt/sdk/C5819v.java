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
import com.tencent.smtt.utils.C36447w;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.v */
class C5819v extends X5ProxyWebViewClient {
    /* renamed from: c */
    private static String f1430c = null;
    /* renamed from: a */
    private WebViewClient f1431a;
    /* renamed from: b */
    private WebView f1432b;

    public C5819v(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.f1432b = webView;
        this.f1431a = webViewClient;
    }

    /* renamed from: a */
    public void mo12205a(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(64138);
        super.onPageStarted(this.f1432b.mo49876c(), 0, 0, str, bitmap);
        AppMethodBeat.m2505o(64138);
    }

    /* renamed from: a */
    public void mo12206a(String str) {
        AppMethodBeat.m2504i(64130);
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.f1432b.getContext() != null) {
                this.f1432b.getContext().startActivity(intent);
            }
            AppMethodBeat.m2505o(64130);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64130);
        }
    }

    public void countPVContentCacheCallBack(String str) {
        WebView webView = this.f1432b;
        webView.f13877a++;
    }

    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.m2504i(64116);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.doUpdateVisitedHistory(this.f1432b, str, z);
        AppMethodBeat.m2505o(64116);
    }

    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        AppMethodBeat.m2504i(64139);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onDetectedBlankScreen(str, i);
        AppMethodBeat.m2505o(64139);
    }

    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        AppMethodBeat.m2504i(64117);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onFormResubmission(this.f1432b, message, message2);
        AppMethodBeat.m2505o(64117);
    }

    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.m2504i(64118);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onLoadResource(this.f1432b, str);
        AppMethodBeat.m2505o(64118);
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        AppMethodBeat.m2504i(64119);
        if (f1430c == null) {
            C36447w a = C36447w.m60203a();
            if (a != null) {
                a.mo57637a(false);
                f1430c = Boolean.toString(false);
            }
        }
        this.f1432b.mo49872a(iX5WebViewBase);
        WebView webView = this.f1432b;
        webView.f13877a++;
        this.f1431a.onPageFinished(this.f1432b, str);
        if (TbsConfig.APP_QZONE.equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            this.f1432b.mo49870a(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
        WebView.m49491d();
        if (!(TbsShareManager.mHasQueryed || this.f1432b.getContext() == null || !TbsShareManager.isThirdPartyApp(this.f1432b.getContext()))) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new C5820w(this)).start();
        }
        if (!(this.f1432b.getContext() == null || TbsLogReport.getInstance(this.f1432b.getContext()).getShouldUploadEventReport())) {
            TbsLogReport.getInstance(this.f1432b.getContext()).setShouldUploadEventReport(true);
            TbsLogReport.getInstance(this.f1432b.getContext()).dailyReport();
        }
        AppMethodBeat.m2505o(64119);
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.m2504i(64140);
        onPageFinished(iX5WebViewBase, 0, 0, str);
        AppMethodBeat.m2505o(64140);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(64120);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onPageStarted(this.f1432b, str, bitmap);
        AppMethodBeat.m2505o(64120);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(64141);
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
        AppMethodBeat.m2505o(64141);
    }

    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        AppMethodBeat.m2504i(64126);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedClientCertRequest(this.f1432b, clientCertRequest);
        AppMethodBeat.m2505o(64126);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        AppMethodBeat.m2504i(64122);
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                AppMethodBeat.m2505o(64122);
                return;
            }
        }
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedError(this.f1432b, i, str, str2);
        AppMethodBeat.m2505o(64122);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AppMethodBeat.m2504i(64121);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedError(this.f1432b, webResourceRequest, webResourceError);
        AppMethodBeat.m2505o(64121);
    }

    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.m2504i(64124);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedHttpAuthRequest(this.f1432b, httpAuthHandler, str, str2);
        AppMethodBeat.m2505o(64124);
    }

    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AppMethodBeat.m2504i(64123);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedHttpError(this.f1432b, webResourceRequest, webResourceResponse);
        AppMethodBeat.m2505o(64123);
    }

    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        AppMethodBeat.m2504i(64137);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedLoginRequest(this.f1432b, str, str2, str3);
        AppMethodBeat.m2505o(64137);
    }

    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        AppMethodBeat.m2504i(64125);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onReceivedSslError(this.f1432b, sslErrorHandler, sslError);
        AppMethodBeat.m2505o(64125);
    }

    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        AppMethodBeat.m2504i(64127);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onScaleChanged(this.f1432b, f, f2);
        AppMethodBeat.m2505o(64127);
    }

    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        AppMethodBeat.m2504i(64132);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onTooManyRedirects(this.f1432b, message, message2);
        AppMethodBeat.m2505o(64132);
    }

    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(64128);
        this.f1432b.mo49872a(iX5WebViewBase);
        this.f1431a.onUnhandledKeyEvent(this.f1432b, keyEvent);
        AppMethodBeat.m2505o(64128);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        AppMethodBeat.m2504i(64135);
        this.f1432b.mo49872a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.f1431a.shouldInterceptRequest(this.f1432b, webResourceRequest);
        AppMethodBeat.m2505o(64135);
        return shouldInterceptRequest;
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.m2504i(64136);
        this.f1432b.mo49872a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.f1431a.shouldInterceptRequest(this.f1432b, webResourceRequest, bundle);
        AppMethodBeat.m2505o(64136);
        return shouldInterceptRequest;
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.m2504i(64134);
        this.f1432b.mo49872a(iX5WebViewBase);
        WebResourceResponse shouldInterceptRequest = this.f1431a.shouldInterceptRequest(this.f1432b, str);
        AppMethodBeat.m2505o(64134);
        return shouldInterceptRequest;
    }

    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(64129);
        this.f1432b.mo49872a(iX5WebViewBase);
        boolean shouldOverrideKeyEvent = this.f1431a.shouldOverrideKeyEvent(this.f1432b, keyEvent);
        AppMethodBeat.m2505o(64129);
        return shouldOverrideKeyEvent;
    }

    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        AppMethodBeat.m2504i(64133);
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.f1432b.showDebugView(uri)) {
            AppMethodBeat.m2505o(64133);
            return true;
        }
        this.f1432b.mo49872a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f1431a.shouldOverrideUrlLoading(this.f1432b, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (uri.startsWith("wtai://wp/mc;")) {
                this.f1432b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(uri.substring(13)).toString())));
                AppMethodBeat.m2505o(64133);
                return true;
            } else if (uri.startsWith(WebView.SCHEME_TEL)) {
                mo12206a(uri);
                AppMethodBeat.m2505o(64133);
                return true;
            }
        }
        AppMethodBeat.m2505o(64133);
        return shouldOverrideUrlLoading;
    }

    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.m2504i(64131);
        if (str == null || this.f1432b.showDebugView(str)) {
            AppMethodBeat.m2505o(64131);
            return true;
        }
        this.f1432b.mo49872a(iX5WebViewBase);
        boolean shouldOverrideUrlLoading = this.f1431a.shouldOverrideUrlLoading(this.f1432b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.f1432b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str.substring(13)).toString())));
                AppMethodBeat.m2505o(64131);
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                mo12206a(str);
                AppMethodBeat.m2505o(64131);
                return true;
            }
        }
        AppMethodBeat.m2505o(64131);
        return shouldOverrideUrlLoading;
    }
}

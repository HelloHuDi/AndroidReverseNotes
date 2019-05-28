package com.tencent.smtt.sdk;

import android.os.Message;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* renamed from: com.tencent.smtt.sdk.z */
class C40983z implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WebViewTransport f16311a;
    /* renamed from: b */
    final /* synthetic */ Message f16312b;
    /* renamed from: c */
    final /* synthetic */ SystemWebChromeClient f16313c;

    C40983z(SystemWebChromeClient systemWebChromeClient, WebViewTransport webViewTransport, Message message) {
        this.f16313c = systemWebChromeClient;
        this.f16311a = webViewTransport;
        this.f16312b = message;
    }

    public void run() {
        AppMethodBeat.m2504i(64151);
        WebView webView = this.f16311a.getWebView();
        if (webView != null) {
            ((WebView.WebViewTransport) this.f16312b.obj).setWebView(webView.mo49875b());
        }
        this.f16312b.sendToTarget();
        AppMethodBeat.m2505o(64151);
    }
}

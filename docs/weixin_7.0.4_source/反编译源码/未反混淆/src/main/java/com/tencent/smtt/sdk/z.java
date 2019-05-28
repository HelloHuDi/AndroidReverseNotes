package com.tencent.smtt.sdk;

import android.os.Message;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class z implements Runnable {
    final /* synthetic */ WebViewTransport a;
    final /* synthetic */ Message b;
    final /* synthetic */ SystemWebChromeClient c;

    z(SystemWebChromeClient systemWebChromeClient, WebViewTransport webViewTransport, Message message) {
        this.c = systemWebChromeClient;
        this.a = webViewTransport;
        this.b = message;
    }

    public void run() {
        AppMethodBeat.i(64151);
        WebView webView = this.a.getWebView();
        if (webView != null) {
            ((WebView.WebViewTransport) this.b.obj).setWebView(webView.b());
        }
        this.b.sendToTarget();
        AppMethodBeat.o(64151);
    }
}

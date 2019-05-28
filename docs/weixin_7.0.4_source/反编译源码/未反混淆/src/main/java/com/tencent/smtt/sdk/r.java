package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

class r implements Runnable {
    final /* synthetic */ WebViewTransport a;
    final /* synthetic */ Message b;
    final /* synthetic */ q c;

    r(q qVar, WebViewTransport webViewTransport, Message message) {
        this.c = qVar;
        this.a = webViewTransport;
        this.b = message;
    }

    public void run() {
        AppMethodBeat.i(64080);
        WebView webView = this.a.getWebView();
        if (webView != null) {
            ((IX5WebViewBase.WebViewTransport) this.b.obj).setWebView(webView.c());
        }
        this.b.sendToTarget();
        AppMethodBeat.o(64080);
    }
}

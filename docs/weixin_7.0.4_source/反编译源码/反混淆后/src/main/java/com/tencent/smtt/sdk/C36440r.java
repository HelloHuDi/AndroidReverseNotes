package com.tencent.smtt.sdk;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.WebView.WebViewTransport;

/* renamed from: com.tencent.smtt.sdk.r */
class C36440r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ WebViewTransport f15172a;
    /* renamed from: b */
    final /* synthetic */ Message f15173b;
    /* renamed from: c */
    final /* synthetic */ C40981q f15174c;

    C36440r(C40981q c40981q, WebViewTransport webViewTransport, Message message) {
        this.f15174c = c40981q;
        this.f15172a = webViewTransport;
        this.f15173b = message;
    }

    public void run() {
        AppMethodBeat.m2504i(64080);
        WebView webView = this.f15172a.getWebView();
        if (webView != null) {
            ((IX5WebViewBase.WebViewTransport) this.f15173b.obj).setWebView(webView.mo49876c());
        }
        this.f15173b.sendToTarget();
        AppMethodBeat.m2505o(64080);
    }
}

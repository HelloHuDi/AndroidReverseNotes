package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;

/* renamed from: com.tencent.smtt.sdk.bm */
class C40977bm extends X5ProxyWebViewClientExtension {
    /* renamed from: a */
    final /* synthetic */ WebView f16296a;

    C40977bm(WebView webView, IX5WebViewClientExtension iX5WebViewClientExtension) {
        this.f16296a = webView;
        super(iX5WebViewClientExtension);
    }

    public void invalidate() {
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(64831);
        super.onScrollChanged(i, i2, i3, i4);
        WebView.m49485a(this.f16296a, i3, i4, i, i2);
        AppMethodBeat.m2505o(64831);
    }
}

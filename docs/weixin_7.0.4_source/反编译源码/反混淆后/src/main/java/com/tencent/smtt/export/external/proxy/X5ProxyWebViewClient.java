package com.tencent.smtt.export.external.proxy;

import com.tencent.smtt.export.external.WebViewWizardBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public abstract class X5ProxyWebViewClient extends ProxyWebViewClient {
    public X5ProxyWebViewClient(WebViewWizardBase webViewWizardBase) {
        this.mWebViewClient = (IX5WebViewClient) webViewWizardBase.newInstance("com.tencent.smtt.webkit.WebViewClient");
    }

    public X5ProxyWebViewClient(IX5WebViewClient iX5WebViewClient) {
        this.mWebViewClient = iX5WebViewClient;
    }
}

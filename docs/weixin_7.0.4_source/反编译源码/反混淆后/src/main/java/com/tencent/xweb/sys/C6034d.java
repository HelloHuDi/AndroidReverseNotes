package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.p1115c.C24524e;

/* renamed from: com.tencent.xweb.sys.d */
public final class C6034d implements C24524e {
    WebViewClient APO = new WebViewClient();
    WebChromeClient APP = new WebChromeClient();
    WebView APQ;

    public C6034d(WebView webView) {
        AppMethodBeat.m2504i(84660);
        this.APQ = webView;
        AppMethodBeat.m2505o(84660);
    }

    /* renamed from: w */
    public final void mo13225w(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(84661);
        this.APO.onPageStarted(this.APQ, str, bitmap);
        AppMethodBeat.m2505o(84661);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
    }

    /* renamed from: a */
    public final boolean mo13220a(String str, String str2, C46945h c46945h) {
        return false;
    }

    /* renamed from: b */
    public final boolean mo13222b(String str, String str2, C46945h c46945h) {
        return false;
    }

    /* renamed from: a */
    public final boolean mo13221a(String str, String str2, String str3, C41127g c41127g) {
        return false;
    }
}

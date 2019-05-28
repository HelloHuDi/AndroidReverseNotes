package com.tencent.xweb.sys;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.e;
import com.tencent.xweb.g;
import com.tencent.xweb.h;

public final class d implements e {
    WebViewClient APO = new WebViewClient();
    WebChromeClient APP = new WebChromeClient();
    WebView APQ;

    public d(WebView webView) {
        AppMethodBeat.i(84660);
        this.APQ = webView;
        AppMethodBeat.o(84660);
    }

    public final void w(String str, Bitmap bitmap) {
        AppMethodBeat.i(84661);
        this.APO.onPageStarted(this.APQ, str, bitmap);
        AppMethodBeat.o(84661);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public final void onHideCustomView() {
    }

    public final boolean a(String str, String str2, h hVar) {
        return false;
    }

    public final boolean b(String str, String str2, h hVar) {
        return false;
    }

    public final boolean a(String str, String str2, String str3, g gVar) {
        return false;
    }
}

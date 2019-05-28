package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.Log;

public final class d implements a {
    CookieManager AQr = CookieManager.getInstance();

    public d() {
        AppMethodBeat.i(84799);
        AppMethodBeat.o(84799);
    }

    public final void dTS() {
        AppMethodBeat.i(84800);
        this.AQr.setAcceptCookie(true);
        AppMethodBeat.o(84800);
    }

    public final void f(WebView webView) {
        AppMethodBeat.i(84801);
        if (webView == null) {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
            AppMethodBeat.o(84801);
            return;
        }
        View webViewUI = webView.getWebViewUI();
        if (webViewUI instanceof com.tencent.smtt.sdk.WebView) {
            this.AQr.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView) webViewUI, true);
            AppMethodBeat.o(84801);
            return;
        }
        Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
        AppMethodBeat.o(84801);
    }

    public final void removeAllCookie() {
        AppMethodBeat.i(84802);
        this.AQr.removeAllCookie();
        AppMethodBeat.o(84802);
    }

    public final String getCookie(String str) {
        AppMethodBeat.i(84803);
        String cookie = this.AQr.getCookie(str);
        AppMethodBeat.o(84803);
        return cookie;
    }

    public final void setCookie(String str, String str2) {
        AppMethodBeat.i(84804);
        this.AQr.setCookie(str, str2);
        AppMethodBeat.o(84804);
    }

    public final void removeSessionCookie() {
        AppMethodBeat.i(84805);
        this.AQr.removeSessionCookie();
        AppMethodBeat.o(84805);
    }
}

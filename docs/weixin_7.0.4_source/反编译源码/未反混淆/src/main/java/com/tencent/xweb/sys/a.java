package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import org.xwalk.core.Log;

public final class a implements com.tencent.xweb.c.b.a {
    CookieManager APD = CookieManager.getInstance();

    public a() {
        AppMethodBeat.i(84640);
        AppMethodBeat.o(84640);
    }

    public final void dTS() {
        AppMethodBeat.i(84641);
        this.APD.setAcceptCookie(true);
        AppMethodBeat.o(84641);
    }

    public final void f(WebView webView) {
        AppMethodBeat.i(84642);
        if (VERSION.SDK_INT >= 21) {
            if (webView == null || webView.getWebViewUI() == null || !(webView.getWebViewUI() instanceof android.webkit.WebView)) {
                Log.e("SysCookieManagerWrapper", "webview kind not match");
            } else {
                this.APD.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI(), true);
                AppMethodBeat.o(84642);
                return;
            }
        }
        AppMethodBeat.o(84642);
    }

    public final void removeAllCookie() {
        AppMethodBeat.i(84643);
        this.APD.removeAllCookie();
        AppMethodBeat.o(84643);
    }

    public final String getCookie(String str) {
        AppMethodBeat.i(84644);
        String cookie = this.APD.getCookie(str);
        AppMethodBeat.o(84644);
        return cookie;
    }

    public final void setCookie(String str, String str2) {
        AppMethodBeat.i(84645);
        this.APD.setCookie(str, str2);
        AppMethodBeat.o(84645);
    }

    public final void removeSessionCookie() {
        AppMethodBeat.i(84646);
        this.APD.removeSessionCookie();
        AppMethodBeat.o(84646);
    }
}

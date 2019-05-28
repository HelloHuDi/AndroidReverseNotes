package com.tencent.xweb.p685x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.x5.d */
public final class C46835d implements C36584a {
    CookieManager AQr = CookieManager.getInstance();

    public C46835d() {
        AppMethodBeat.m2504i(84799);
        AppMethodBeat.m2505o(84799);
    }

    public final void dTS() {
        AppMethodBeat.m2504i(84800);
        this.AQr.setAcceptCookie(true);
        AppMethodBeat.m2505o(84800);
    }

    /* renamed from: f */
    public final void mo41325f(WebView webView) {
        AppMethodBeat.m2504i(84801);
        if (webView == null) {
            Log.m81046e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
            AppMethodBeat.m2505o(84801);
            return;
        }
        View webViewUI = webView.getWebViewUI();
        if (webViewUI instanceof com.tencent.smtt.sdk.WebView) {
            this.AQr.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView) webViewUI, true);
            AppMethodBeat.m2505o(84801);
            return;
        }
        Log.m81046e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
        AppMethodBeat.m2505o(84801);
    }

    public final void removeAllCookie() {
        AppMethodBeat.m2504i(84802);
        this.AQr.removeAllCookie();
        AppMethodBeat.m2505o(84802);
    }

    public final String getCookie(String str) {
        AppMethodBeat.m2504i(84803);
        String cookie = this.AQr.getCookie(str);
        AppMethodBeat.m2505o(84803);
        return cookie;
    }

    public final void setCookie(String str, String str2) {
        AppMethodBeat.m2504i(84804);
        this.AQr.setCookie(str, str2);
        AppMethodBeat.m2505o(84804);
    }

    public final void removeSessionCookie() {
        AppMethodBeat.m2504i(84805);
        this.AQr.removeSessionCookie();
        AppMethodBeat.m2505o(84805);
    }
}

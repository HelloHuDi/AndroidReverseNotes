package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import org.xwalk.core.Log;

/* renamed from: com.tencent.xweb.sys.a */
public final class C46833a implements C36584a {
    CookieManager APD = CookieManager.getInstance();

    public C46833a() {
        AppMethodBeat.m2504i(84640);
        AppMethodBeat.m2505o(84640);
    }

    public final void dTS() {
        AppMethodBeat.m2504i(84641);
        this.APD.setAcceptCookie(true);
        AppMethodBeat.m2505o(84641);
    }

    /* renamed from: f */
    public final void mo41325f(WebView webView) {
        AppMethodBeat.m2504i(84642);
        if (VERSION.SDK_INT >= 21) {
            if (webView == null || webView.getWebViewUI() == null || !(webView.getWebViewUI() instanceof android.webkit.WebView)) {
                Log.m81046e("SysCookieManagerWrapper", "webview kind not match");
            } else {
                this.APD.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI(), true);
                AppMethodBeat.m2505o(84642);
                return;
            }
        }
        AppMethodBeat.m2505o(84642);
    }

    public final void removeAllCookie() {
        AppMethodBeat.m2504i(84643);
        this.APD.removeAllCookie();
        AppMethodBeat.m2505o(84643);
    }

    public final String getCookie(String str) {
        AppMethodBeat.m2504i(84644);
        String cookie = this.APD.getCookie(str);
        AppMethodBeat.m2505o(84644);
        return cookie;
    }

    public final void setCookie(String str, String str2) {
        AppMethodBeat.m2504i(84645);
        this.APD.setCookie(str, str2);
        AppMethodBeat.m2505o(84645);
    }

    public final void removeSessionCookie() {
        AppMethodBeat.m2504i(84646);
        this.APD.removeSessionCookie();
        AppMethodBeat.m2505o(84646);
    }
}

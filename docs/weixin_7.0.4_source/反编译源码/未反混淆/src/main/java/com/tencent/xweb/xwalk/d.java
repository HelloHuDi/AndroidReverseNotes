package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.b.a;
import org.xwalk.core.XWalkCookieManager;

public final class d implements a {
    XWalkCookieManager ARR = new XWalkCookieManager();

    public d() {
        AppMethodBeat.i(85208);
        AppMethodBeat.o(85208);
    }

    public final void dTS() {
        AppMethodBeat.i(85209);
        this.ARR.setAcceptCookie(true);
        AppMethodBeat.o(85209);
    }

    public final void f(WebView webView) {
    }

    public final void removeAllCookie() {
        AppMethodBeat.i(85210);
        this.ARR.removeAllCookie();
        AppMethodBeat.o(85210);
    }

    public final String getCookie(String str) {
        AppMethodBeat.i(85211);
        String cookie = this.ARR.getCookie(str);
        AppMethodBeat.o(85211);
        return cookie;
    }

    public final void setCookie(String str, String str2) {
        AppMethodBeat.i(85212);
        this.ARR.setCookie(str, str2);
        AppMethodBeat.o(85212);
    }

    public final void removeSessionCookie() {
        AppMethodBeat.i(85213);
        this.ARR.removeSessionCookie();
        AppMethodBeat.o(85213);
    }
}

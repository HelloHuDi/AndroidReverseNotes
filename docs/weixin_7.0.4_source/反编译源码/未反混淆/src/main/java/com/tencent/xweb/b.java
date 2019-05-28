package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.b.a;

public final class b {
    private static b ALR;
    public a ALS;

    private b() {
    }

    public static synchronized b dTR() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(3795);
            if (ALR == null) {
                ALR = new b();
            }
            bVar = ALR;
            AppMethodBeat.o(3795);
        }
        return bVar;
    }

    public final void removeAllCookie() {
        AppMethodBeat.i(3796);
        this.ALS.removeAllCookie();
        AppMethodBeat.o(3796);
    }

    public final String getCookie(String str) {
        AppMethodBeat.i(3797);
        String cookie = this.ALS.getCookie(str);
        AppMethodBeat.o(3797);
        return cookie;
    }

    public final synchronized void setCookie(String str, String str2) {
        AppMethodBeat.i(3798);
        this.ALS.setCookie(str, str2);
        AppMethodBeat.o(3798);
    }

    public final synchronized void dTS() {
        AppMethodBeat.i(3799);
        if (this.ALS != null) {
            this.ALS.dTS();
        }
        AppMethodBeat.o(3799);
    }

    public final synchronized void f(WebView webView) {
        AppMethodBeat.i(3800);
        if (this.ALS != null) {
            this.ALS.f(webView);
        }
        AppMethodBeat.o(3800);
    }
}

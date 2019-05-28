package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p1115c.C44577b.C36584a;

/* renamed from: com.tencent.xweb.b */
public final class C44576b {
    private static C44576b ALR;
    public C36584a ALS;

    private C44576b() {
    }

    public static synchronized C44576b dTR() {
        C44576b c44576b;
        synchronized (C44576b.class) {
            AppMethodBeat.m2504i(3795);
            if (ALR == null) {
                ALR = new C44576b();
            }
            c44576b = ALR;
            AppMethodBeat.m2505o(3795);
        }
        return c44576b;
    }

    public final void removeAllCookie() {
        AppMethodBeat.m2504i(3796);
        this.ALS.removeAllCookie();
        AppMethodBeat.m2505o(3796);
    }

    public final String getCookie(String str) {
        AppMethodBeat.m2504i(3797);
        String cookie = this.ALS.getCookie(str);
        AppMethodBeat.m2505o(3797);
        return cookie;
    }

    public final synchronized void setCookie(String str, String str2) {
        AppMethodBeat.m2504i(3798);
        this.ALS.setCookie(str, str2);
        AppMethodBeat.m2505o(3798);
    }

    public final synchronized void dTS() {
        AppMethodBeat.m2504i(3799);
        if (this.ALS != null) {
            this.ALS.dTS();
        }
        AppMethodBeat.m2505o(3799);
    }

    /* renamed from: f */
    public final synchronized void mo71378f(WebView webView) {
        AppMethodBeat.m2504i(3800);
        if (this.ALS != null) {
            this.ALS.mo41325f(webView);
        }
        AppMethodBeat.m2505o(3800);
    }
}

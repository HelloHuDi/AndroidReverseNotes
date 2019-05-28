package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p1115c.C44577b.C36584a;
import org.xwalk.core.XWalkCookieManager;

/* renamed from: com.tencent.xweb.xwalk.d */
public final class C24565d implements C36584a {
    XWalkCookieManager ARR = new XWalkCookieManager();

    public C24565d() {
        AppMethodBeat.m2504i(85208);
        AppMethodBeat.m2505o(85208);
    }

    public final void dTS() {
        AppMethodBeat.m2504i(85209);
        this.ARR.setAcceptCookie(true);
        AppMethodBeat.m2505o(85209);
    }

    /* renamed from: f */
    public final void mo41325f(WebView webView) {
    }

    public final void removeAllCookie() {
        AppMethodBeat.m2504i(85210);
        this.ARR.removeAllCookie();
        AppMethodBeat.m2505o(85210);
    }

    public final String getCookie(String str) {
        AppMethodBeat.m2504i(85211);
        String cookie = this.ARR.getCookie(str);
        AppMethodBeat.m2505o(85211);
        return cookie;
    }

    public final void setCookie(String str, String str2) {
        AppMethodBeat.m2504i(85212);
        this.ARR.setCookie(str, str2);
        AppMethodBeat.m2505o(85212);
    }

    public final void removeSessionCookie() {
        AppMethodBeat.m2504i(85213);
        this.ARR.removeSessionCookie();
        AppMethodBeat.m2505o(85213);
    }
}

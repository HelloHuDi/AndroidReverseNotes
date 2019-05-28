package com.tencent.p177mm.plugin.webview.p580ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.a */
public class C35640a {
    private final WeakReference<WebViewUI> uqV;

    public C35640a(WebViewUI webViewUI) {
        AppMethodBeat.m2504i(7340);
        this.uqV = new WeakReference(webViewUI);
        AppMethodBeat.m2505o(7340);
    }

    public final boolean cZu() {
        AppMethodBeat.m2504i(7341);
        if (cZv() == null || cZv().isFinishing()) {
            AppMethodBeat.m2505o(7341);
            return true;
        }
        AppMethodBeat.m2505o(7341);
        return false;
    }

    public final WebViewUI cZv() {
        AppMethodBeat.m2504i(7342);
        WebViewUI webViewUI = (WebViewUI) this.uqV.get();
        AppMethodBeat.m2505o(7342);
        return webViewUI;
    }
}

package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public class a {
    private final WeakReference<WebViewUI> uqV;

    public a(WebViewUI webViewUI) {
        AppMethodBeat.i(7340);
        this.uqV = new WeakReference(webViewUI);
        AppMethodBeat.o(7340);
    }

    public final boolean cZu() {
        AppMethodBeat.i(7341);
        if (cZv() == null || cZv().isFinishing()) {
            AppMethodBeat.o(7341);
            return true;
        }
        AppMethodBeat.o(7341);
        return false;
    }

    public final WebViewUI cZv() {
        AppMethodBeat.i(7342);
        WebViewUI webViewUI = (WebViewUI) this.uqV.get();
        AppMethodBeat.o(7342);
        return webViewUI;
    }
}

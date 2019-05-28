package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class j extends i {
    private final b uJl;

    public j(MMWebView mMWebView, b bVar) {
        super((MMWebViewWithJsApi) mMWebView);
        AppMethodBeat.i(9919);
        this.uJl = bVar;
        AppMethodBeat.o(9919);
    }

    public final void d(WebView webView, String str) {
        AppMethodBeat.i(9920);
        if (this.uJl != null) {
            this.uJl.pa(str);
            AppMethodBeat.o(9920);
            return;
        }
        super.d(webView, str);
        AppMethodBeat.o(9920);
    }
}

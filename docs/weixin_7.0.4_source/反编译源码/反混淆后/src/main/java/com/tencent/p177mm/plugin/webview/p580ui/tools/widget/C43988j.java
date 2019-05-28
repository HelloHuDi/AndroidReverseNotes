package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.j */
public final class C43988j extends C14672i {
    private final C35725b uJl;

    public C43988j(MMWebView mMWebView, C35725b c35725b) {
        super((MMWebViewWithJsApi) mMWebView);
        AppMethodBeat.m2504i(9919);
        this.uJl = c35725b;
        AppMethodBeat.m2505o(9919);
    }

    /* renamed from: d */
    public final void mo7557d(WebView webView, String str) {
        AppMethodBeat.m2504i(9920);
        if (this.uJl != null) {
            this.uJl.mo20989pa(str);
            AppMethodBeat.m2505o(9920);
            return;
        }
        super.mo7557d(webView, str);
        AppMethodBeat.m2505o(9920);
    }
}

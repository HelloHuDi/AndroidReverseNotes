package com.tencent.p177mm.plugin.topstory.p541ui.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.topstory.ui.webview.b */
public final class C13994b extends C6031l {
    /* renamed from: a */
    public final void mo13205a(WebView webView, int i) {
    }

    /* renamed from: b */
    public final boolean mo13211b(WebView webView, String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(2144);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", str, str2);
        boolean b = super.mo13211b(webView, str, str2, c46945h);
        AppMethodBeat.m2505o(2144);
        return b;
    }

    /* renamed from: a */
    public final boolean mo13208a(WebView webView, String str, String str2, String str3, C41127g c41127g) {
        AppMethodBeat.m2504i(2145);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", str, str2);
        boolean a = super.mo13208a(webView, str, str2, str3, c41127g);
        AppMethodBeat.m2505o(2145);
        return a;
    }

    /* renamed from: a */
    public final boolean mo13207a(WebView webView, String str, String str2, C46945h c46945h) {
        AppMethodBeat.m2504i(2146);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", str, str2);
        boolean a = super.mo13207a(webView, str, str2, c46945h);
        AppMethodBeat.m2505o(2146);
        return a;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.m2504i(2147);
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.messageLevel().name(), consoleMessage.message(), consoleMessage.sourceId());
        if (consoleMessage.messageLevel() == MessageLevel.ERROR && !C5046bo.isNullOrNil(consoleMessage.message()) && consoleMessage.message().contains("SyntaxError")) {
            C14423an.m22640Il(22);
        }
        boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.m2505o(2147);
        return onConsoleMessage;
    }
}

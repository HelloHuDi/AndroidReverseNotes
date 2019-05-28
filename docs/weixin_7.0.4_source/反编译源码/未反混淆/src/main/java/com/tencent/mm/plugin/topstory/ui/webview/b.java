package com.tencent.mm.plugin.topstory.ui.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.g;
import com.tencent.xweb.h;
import com.tencent.xweb.l;

public final class b extends l {
    public final void a(WebView webView, int i) {
    }

    public final boolean b(WebView webView, String str, String str2, h hVar) {
        AppMethodBeat.i(2144);
        ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", str, str2);
        boolean b = super.b(webView, str, str2, hVar);
        AppMethodBeat.o(2144);
        return b;
    }

    public final boolean a(WebView webView, String str, String str2, String str3, g gVar) {
        AppMethodBeat.i(2145);
        ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", str, str2);
        boolean a = super.a(webView, str, str2, str3, gVar);
        AppMethodBeat.o(2145);
        return a;
    }

    public final boolean a(WebView webView, String str, String str2, h hVar) {
        AppMethodBeat.i(2146);
        ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", str, str2);
        boolean a = super.a(webView, str, str2, hVar);
        AppMethodBeat.o(2146);
        return a;
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(2147);
        ab.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.messageLevel().name(), consoleMessage.message(), consoleMessage.sourceId());
        if (consoleMessage.messageLevel() == MessageLevel.ERROR && !bo.isNullOrNil(consoleMessage.message()) && consoleMessage.message().contains("SyntaxError")) {
            an.Il(22);
        }
        boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(2147);
        return onConsoleMessage;
    }
}

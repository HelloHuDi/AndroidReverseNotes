package com.tencent.luggage.webview.default_impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.webview.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DefaultWebCore$6 extends WebChromeClient {
    final /* synthetic */ a bRL;
    final /* synthetic */ a bRM;

    DefaultWebCore$6(a aVar, a aVar2) {
        this.bRM = aVar;
        this.bRL = aVar2;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(90929);
        String bH = this.bRL.bH(str2);
        if (bH == null) {
            AppMethodBeat.o(90929);
            return false;
        }
        jsPromptResult.confirm(bH);
        AppMethodBeat.o(90929);
        return true;
    }
}

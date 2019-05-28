package com.tencent.luggage.webview.default_impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.webview.C37407a.C32193a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class DefaultWebCore$6 extends WebChromeClient {
    final /* synthetic */ C32193a bRL;
    final /* synthetic */ C25703a bRM;

    DefaultWebCore$6(C25703a c25703a, C32193a c32193a) {
        this.bRM = c25703a;
        this.bRL = c32193a;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.m2504i(90929);
        String bH = this.bRL.mo52843bH(str2);
        if (bH == null) {
            AppMethodBeat.m2505o(90929);
            return false;
        }
        jsPromptResult.confirm(bH);
        AppMethodBeat.m2505o(90929);
        return true;
    }
}

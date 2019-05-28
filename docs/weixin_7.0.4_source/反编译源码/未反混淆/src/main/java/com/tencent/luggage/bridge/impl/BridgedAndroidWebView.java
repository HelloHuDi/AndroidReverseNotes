package com.tencent.luggage.bridge.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BridgedAndroidWebView extends BridgedAndroidWebViewBase {
    private o bOA;
    private WebViewClient bOQ;
    private WebChromeClient bOR;

    public BridgedAndroidWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BridgedAndroidWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(90752);
        this.bOQ = new WebViewClient() {
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(90749);
                BridgedAndroidWebView.this.bOA.bOI.wO();
                AppMethodBeat.o(90749);
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.i(90750);
                BridgedAndroidWebView.this.bOA.bOI.onReady();
                AppMethodBeat.o(90750);
            }
        };
        this.bOR = new WebChromeClient() {
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                AppMethodBeat.i(90751);
                String bx = BridgedAndroidWebView.this.bOA.bOI.bx(str2);
                if (bx != null) {
                    jsPromptResult.confirm(bx);
                    AppMethodBeat.o(90751);
                    return true;
                }
                AppMethodBeat.o(90751);
                return false;
            }
        };
        this.bOA = new o(this);
        setWebViewClient(this.bOQ);
        setWebChromeClient(this.bOR);
        AppMethodBeat.o(90752);
    }

    public o getBridge() {
        return this.bOA;
    }
}

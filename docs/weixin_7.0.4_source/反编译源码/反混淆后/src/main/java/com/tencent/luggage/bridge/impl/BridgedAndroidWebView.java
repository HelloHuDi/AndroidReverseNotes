package com.tencent.luggage.bridge.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.C37392o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BridgedAndroidWebView extends BridgedAndroidWebViewBase {
    private C37392o bOA;
    private WebViewClient bOQ;
    private WebChromeClient bOR;

    /* renamed from: com.tencent.luggage.bridge.impl.BridgedAndroidWebView$1 */
    class C373881 extends WebViewClient {
        C373881() {
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(90749);
            BridgedAndroidWebView.this.bOA.bOI.mo20032wO();
            AppMethodBeat.m2505o(90749);
        }

        public final void onPageFinished(WebView webView, String str) {
            AppMethodBeat.m2504i(90750);
            BridgedAndroidWebView.this.bOA.bOI.onReady();
            AppMethodBeat.m2505o(90750);
        }
    }

    /* renamed from: com.tencent.luggage.bridge.impl.BridgedAndroidWebView$2 */
    class C373892 extends WebChromeClient {
        C373892() {
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            AppMethodBeat.m2504i(90751);
            String bx = BridgedAndroidWebView.this.bOA.bOI.mo20030bx(str2);
            if (bx != null) {
                jsPromptResult.confirm(bx);
                AppMethodBeat.m2505o(90751);
                return true;
            }
            AppMethodBeat.m2505o(90751);
            return false;
        }
    }

    public BridgedAndroidWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BridgedAndroidWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(90752);
        this.bOQ = new C373881();
        this.bOR = new C373892();
        this.bOA = new C37392o(this);
        setWebViewClient(this.bOQ);
        setWebChromeClient(this.bOR);
        AppMethodBeat.m2505o(90752);
    }

    public C37392o getBridge() {
        return this.bOA;
    }
}

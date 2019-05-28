package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class c extends WebViewClient {
    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(84798);
        super.onPageStarted(webView, str, bitmap);
        AppMethodBeat.o(84798);
    }
}

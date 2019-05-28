package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

class bp implements FindListener {
    final /* synthetic */ IX5WebViewBase.FindListener a;
    final /* synthetic */ WebView b;

    bp(WebView webView, IX5WebViewBase.FindListener findListener) {
        this.b = webView;
        this.a = findListener;
    }

    public void onFindResultReceived(int i, int i2, boolean z) {
        AppMethodBeat.i(64834);
        this.a.onFindResultReceived(i, i2, z);
        AppMethodBeat.o(64834);
    }
}

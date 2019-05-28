package com.tencent.smtt.sdk;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;

/* renamed from: com.tencent.smtt.sdk.bp */
class C5815bp implements FindListener {
    /* renamed from: a */
    final /* synthetic */ IX5WebViewBase.FindListener f1415a;
    /* renamed from: b */
    final /* synthetic */ WebView f1416b;

    C5815bp(WebView webView, IX5WebViewBase.FindListener findListener) {
        this.f1416b = webView;
        this.f1415a = findListener;
    }

    public void onFindResultReceived(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(64834);
        this.f1415a.onFindResultReceived(i, i2, z);
        AppMethodBeat.m2505o(64834);
    }
}

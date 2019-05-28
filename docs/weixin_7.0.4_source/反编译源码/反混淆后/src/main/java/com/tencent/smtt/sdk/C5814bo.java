package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.bo */
class C5814bo extends Thread {
    /* renamed from: a */
    final /* synthetic */ WebView f1414a;

    C5814bo(WebView webView, String str) {
        this.f1414a = webView;
        super(str);
    }

    public void run() {
        AppMethodBeat.m2504i(64833);
        this.f1414a.tbsWebviewDestroy(false);
        AppMethodBeat.m2505o(64833);
    }
}

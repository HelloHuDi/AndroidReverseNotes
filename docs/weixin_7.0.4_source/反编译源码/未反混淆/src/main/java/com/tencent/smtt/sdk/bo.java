package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class bo extends Thread {
    final /* synthetic */ WebView a;

    bo(WebView webView, String str) {
        this.a = webView;
        super(str);
    }

    public void run() {
        AppMethodBeat.i(64833);
        this.a.tbsWebviewDestroy(false);
        AppMethodBeat.o(64833);
    }
}

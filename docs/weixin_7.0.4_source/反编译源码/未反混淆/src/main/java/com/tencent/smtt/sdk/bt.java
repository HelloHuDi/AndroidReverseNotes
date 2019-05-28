package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

class bt extends Thread {
    final /* synthetic */ WebView a;

    bt(WebView webView, String str) {
        this.a = webView;
        super(str);
    }

    public void run() {
        AppMethodBeat.i(64838);
        try {
            this.a.a();
            AppMethodBeat.o(64838);
        } catch (Exception e) {
            AppMethodBeat.o(64838);
        }
    }
}

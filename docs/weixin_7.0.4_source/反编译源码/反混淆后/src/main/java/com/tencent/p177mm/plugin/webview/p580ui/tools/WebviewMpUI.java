package com.tencent.p177mm.plugin.webview.p580ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebviewMpUI */
public class WebviewMpUI extends WebViewUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aYc() {
        return true;
    }
}

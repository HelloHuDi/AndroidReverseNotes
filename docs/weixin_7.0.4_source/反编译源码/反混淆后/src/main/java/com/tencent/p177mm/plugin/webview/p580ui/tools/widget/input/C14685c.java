package com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.input.WebViewSmileyPanel.C4658a;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.input.c */
public final class C14685c {
    boolean jiH = false;
    int jiL;
    int jiM;
    Context jiq;
    C35730b uKF;
    C4658a uKG;

    public final C40349a ddb() {
        AppMethodBeat.m2504i(10119);
        if (this.uKF == null) {
            this.uKF = new C35730b();
            this.uKF.jiq = this.jiq;
            this.uKF.setPanelManager(this);
        }
        C35730b c35730b = this.uKF;
        AppMethodBeat.m2505o(10119);
        return c35730b;
    }
}

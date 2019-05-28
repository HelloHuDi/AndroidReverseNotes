package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyPanel.a;

public final class c {
    boolean jiH = false;
    int jiL;
    int jiM;
    Context jiq;
    b uKF;
    a uKG;

    public final a ddb() {
        AppMethodBeat.i(10119);
        if (this.uKF == null) {
            this.uKF = new b();
            this.uKF.jiq = this.jiq;
            this.uKF.setPanelManager(this);
        }
        b bVar = this.uKF;
        AppMethodBeat.o(10119);
        return bVar;
    }
}

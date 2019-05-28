package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.ui.widget.d;

public class n {
    d uiI;
    l ujb;
    d ujs = new d(this.uiI.mContext, 0, false);

    public n(d dVar, l lVar) {
        AppMethodBeat.i(6221);
        this.uiI = dVar;
        this.ujb = lVar;
        this.ujs.cpD();
        AppMethodBeat.o(6221);
    }

    public final void cXg() {
        AppMethodBeat.i(6222);
        if (this.ujs != null) {
            this.ujs.cpE();
        }
        AppMethodBeat.o(6222);
    }
}

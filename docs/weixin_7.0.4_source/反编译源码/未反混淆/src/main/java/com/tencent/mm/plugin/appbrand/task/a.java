package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;

final class a extends j {
    final long iEd;
    private String iEe;

    a(long j) {
        super(AppBrandEmbedUI.class, null, null);
        this.iEd = j;
    }

    /* Access modifiers changed, original: final */
    public final void DI(String str) {
        AppMethodBeat.i(132778);
        if (this.iEe.equals(str)) {
            this.iFt.clear();
            this.iFu.clear();
            this.iFv = g.NIL;
            AppMethodBeat.o(132778);
            return;
        }
        super.DI(str);
        AppMethodBeat.o(132778);
    }

    /* Access modifiers changed, original: final */
    public final void a(String str, int i, AppBrandRemoteTaskController appBrandRemoteTaskController) {
        AppMethodBeat.i(132777);
        if (this.iFt.keySet().isEmpty()) {
            this.iEe = str;
        }
        super.a(str, i, appBrandRemoteTaskController);
        AppMethodBeat.o(132777);
    }
}

package com.tencent.mm.plugin.emojicapture.ui;

import a.f.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13})
final class c implements Runnable {
    private final /* synthetic */ a eOs;

    c(a aVar) {
        this.eOs = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(2899);
        j.o(this.eOs.invoke(), "invoke(...)");
        AppMethodBeat.o(2899);
    }
}

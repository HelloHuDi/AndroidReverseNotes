package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13})
public final class a implements Runnable {
    private final /* synthetic */ a.f.a.a eOs;

    public a(a.f.a.a aVar) {
        this.eOs = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(89229);
        j.o(this.eOs.invoke(), "invoke(...)");
        AppMethodBeat.o(89229);
    }
}

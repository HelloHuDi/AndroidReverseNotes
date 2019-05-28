package com.tencent.mm.media.g;

import a.f.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(dWo = {1, 1, 13})
final class b implements Runnable {
    private final /* synthetic */ a eOs;

    b(a aVar) {
        this.eOs = aVar;
    }

    public final /* synthetic */ void run() {
        AppMethodBeat.i(13015);
        j.o(this.eOs.invoke(), "invoke(...)");
        AppMethodBeat.o(13015);
    }
}

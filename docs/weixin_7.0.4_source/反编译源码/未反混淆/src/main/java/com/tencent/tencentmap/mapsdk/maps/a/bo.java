package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class bo implements Runnable {
    private /* synthetic */ br a;
    private /* synthetic */ bp b;

    bo(bn bnVar, br brVar, bp bpVar) {
        this.a = brVar;
        this.b = bpVar;
    }

    public final void run() {
        AppMethodBeat.i(98569);
        this.b.a(this.a.a());
        this.b.b();
        AppMethodBeat.o(98569);
    }
}

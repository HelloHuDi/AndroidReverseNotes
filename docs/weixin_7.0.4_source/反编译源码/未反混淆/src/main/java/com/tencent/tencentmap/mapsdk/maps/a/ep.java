package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ep implements Runnable {
    private /* synthetic */ en a;

    ep(en enVar) {
        this.a = enVar;
    }

    public final void run() {
        AppMethodBeat.i(98810);
        this.a.b();
        AppMethodBeat.o(98810);
    }
}

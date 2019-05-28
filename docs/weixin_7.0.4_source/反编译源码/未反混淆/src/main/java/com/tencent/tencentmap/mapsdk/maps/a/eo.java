package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class eo implements Runnable {
    private /* synthetic */ int a;
    private /* synthetic */ en b;

    eo(en enVar, int i) {
        this.b = enVar;
        this.a = i;
    }

    public final void run() {
        AppMethodBeat.i(98809);
        this.b.c.a(this.a);
        AppMethodBeat.o(98809);
    }
}

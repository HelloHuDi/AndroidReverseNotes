package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class dd implements Runnable {
    private /* synthetic */ cx a;

    dd(cx cxVar) {
        this.a = cxVar;
    }

    public final void run() {
        AppMethodBeat.i(98698);
        this.a.a(false, true);
        AppMethodBeat.o(98698);
    }
}

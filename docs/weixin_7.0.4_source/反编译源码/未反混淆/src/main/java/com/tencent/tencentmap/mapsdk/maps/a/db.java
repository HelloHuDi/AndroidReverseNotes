package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class db implements Runnable {
    private /* synthetic */ cx a;

    db(cx cxVar) {
        this.a = cxVar;
    }

    public final void run() {
        AppMethodBeat.i(98696);
        this.a.d();
        AppMethodBeat.o(98696);
    }
}

package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class dc implements Runnable {
    private /* synthetic */ cx a;

    dc(cx cxVar) {
        this.a = cxVar;
    }

    public final void run() {
        AppMethodBeat.i(98697);
        if (this.a.g.size() == 0) {
            this.a.n.incrementAndGet();
            this.a.b(false, true);
            AppMethodBeat.o(98697);
            return;
        }
        this.a.a(true, true);
        AppMethodBeat.o(98697);
    }
}

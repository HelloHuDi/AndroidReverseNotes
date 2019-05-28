package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class dm implements Runnable {
    private /* synthetic */ dl a;

    dm(dl dlVar) {
        this.a = dlVar;
    }

    public final void run() {
        AppMethodBeat.i(98723);
        String b = ce.b();
        dl.a(this.a, this.a.a.a(b), b);
        AppMethodBeat.o(98723);
    }
}

package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ca implements Runnable {
    ca() {
    }

    public final void run() {
        AppMethodBeat.i(98613);
        try {
            bw.d();
            ce.a(bw.b, bw.e);
            AppMethodBeat.o(98613);
        } catch (Throwable th) {
            AppMethodBeat.o(98613);
        }
    }
}

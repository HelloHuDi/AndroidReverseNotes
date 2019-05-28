package com.tencent.mm.ci;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.d;

public final class e extends d {
    public final void o(Runnable runnable) {
        AppMethodBeat.i(123367);
        runnable.run();
        AppMethodBeat.o(123367);
    }

    public final void l(Runnable runnable, long j) {
        AppMethodBeat.i(123368);
        runnable.run();
        AppMethodBeat.o(123368);
    }

    public final String getType() {
        return "WxNoLooperScheduler";
    }

    public final void cancel() {
    }
}

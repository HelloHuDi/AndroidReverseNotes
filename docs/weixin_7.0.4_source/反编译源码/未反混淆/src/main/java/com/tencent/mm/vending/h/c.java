package com.tencent.mm.vending.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;

public final class c extends d {
    public c() {
        AppMethodBeat.i(126127);
        a.printErrStackTrace("Vending.NoLooperScheduler", new Exception("This is not a handler thread!"), "This is not a handler thread!", new Object[0]);
        AppMethodBeat.o(126127);
    }

    public final void o(Runnable runnable) {
        AppMethodBeat.i(126128);
        a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
        AppMethodBeat.o(126128);
    }

    public final void l(Runnable runnable, long j) {
        AppMethodBeat.i(126129);
        a.w("Vending.NoLooperScheduler", "This is not a handler thread!", new Object[0]);
        runnable.run();
        AppMethodBeat.o(126129);
    }

    public final String getType() {
        AppMethodBeat.i(126130);
        String thread = Thread.currentThread().toString();
        AppMethodBeat.o(126130);
        return thread;
    }

    public final void cancel() {
    }
}

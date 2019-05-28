package com.tencent.mm.ci;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.h.a;

public final class d implements a {
    private ak mHandler;

    public d(ak akVar) {
        this.mHandler = akVar;
    }

    public static d c(ak akVar) {
        AppMethodBeat.i(59210);
        d dVar = new d(akVar);
        AppMethodBeat.o(59210);
        return dVar;
    }

    public final void f(Runnable runnable) {
        AppMethodBeat.i(59211);
        this.mHandler.post(runnable);
        AppMethodBeat.o(59211);
    }

    public final void d(Runnable runnable, long j) {
        AppMethodBeat.i(59212);
        this.mHandler.postDelayed(runnable, j);
        AppMethodBeat.o(59212);
    }

    public final Looper getLooper() {
        AppMethodBeat.i(59213);
        Looper looper = this.mHandler.getLooper();
        AppMethodBeat.o(59213);
        return looper;
    }

    public final void eD() {
        AppMethodBeat.i(59214);
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(59214);
    }
}

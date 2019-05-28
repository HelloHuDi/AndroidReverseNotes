package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements a {
    public Handler a;

    public b(Handler handler) {
        this.a = handler;
    }

    public final void f(Runnable runnable) {
        AppMethodBeat.i(126114);
        this.a.post(runnable);
        AppMethodBeat.o(126114);
    }

    public final void d(Runnable runnable, long j) {
        AppMethodBeat.i(126115);
        this.a.postDelayed(runnable, j);
        AppMethodBeat.o(126115);
    }

    public final Looper getLooper() {
        AppMethodBeat.i(126116);
        Looper looper = this.a.getLooper();
        AppMethodBeat.o(126116);
        return looper;
    }

    public final void eD() {
        AppMethodBeat.i(126117);
        this.a.removeCallbacksAndMessages(null);
        AppMethodBeat.o(126117);
    }
}

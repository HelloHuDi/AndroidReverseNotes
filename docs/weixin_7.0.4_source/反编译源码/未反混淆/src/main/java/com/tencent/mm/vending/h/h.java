package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends d {
    Looper b;
    public String c;
    public a zYv;

    private h(Looper looper, a aVar, String str) {
        this.b = looper;
        this.zYv = aVar;
        this.c = str;
    }

    public h(Handler handler, String str) {
        this(new b(handler), str);
        AppMethodBeat.i(126118);
        AppMethodBeat.o(126118);
    }

    public h(a aVar, String str) {
        this(aVar.getLooper(), aVar, str);
        AppMethodBeat.i(126119);
        AppMethodBeat.o(126119);
    }

    public h(Looper looper, String str) {
        this(new Handler(looper), str);
        AppMethodBeat.i(126120);
        AppMethodBeat.o(126120);
    }

    public final String getType() {
        return this.c;
    }

    public final void cancel() {
        AppMethodBeat.i(126121);
        this.zYv.eD();
        AppMethodBeat.o(126121);
    }

    public final void o(Runnable runnable) {
        AppMethodBeat.i(126122);
        this.zYv.f(runnable);
        AppMethodBeat.o(126122);
    }

    public final void l(Runnable runnable, long j) {
        AppMethodBeat.i(126123);
        if (j >= 0) {
            this.zYv.d(runnable, j);
            AppMethodBeat.o(126123);
            return;
        }
        this.zYv.f(runnable);
        AppMethodBeat.o(126123);
    }
}

package com.tencent.mm.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.c.a;
import com.tencent.mm.sdk.g.a.e;

public final class c implements com.tencent.mm.sdk.g.a.c {
    private a xDA;
    private e xDz;

    public final void a(a aVar) {
        this.xDA = aVar;
    }

    public c(e eVar) {
        this.xDz = eVar;
    }

    public final void ak(Runnable runnable) {
        AppMethodBeat.i(52530);
        o(runnable, 0);
        AppMethodBeat.o(52530);
    }

    public final void o(Runnable runnable, long j) {
        AppMethodBeat.i(52531);
        if (0 >= j) {
            this.xDz.execute(runnable);
            AppMethodBeat.o(52531);
            return;
        }
        this.xDz.p(runnable, j);
        AppMethodBeat.o(52531);
    }

    public final void a(Runnable runnable, String str) {
        AppMethodBeat.i(52532);
        a(runnable, str, 0);
        AppMethodBeat.o(52532);
    }

    public final void a(Runnable runnable, String str, long j) {
        AppMethodBeat.i(52533);
        if (0 >= j) {
            this.xDz.b(runnable, str);
            AppMethodBeat.o(52533);
            return;
        }
        this.xDz.b(runnable, str, j);
        AppMethodBeat.o(52533);
    }

    public final void al(Runnable runnable) {
        AppMethodBeat.i(52534);
        this.xDz.remove(runnable);
        AppMethodBeat.o(52534);
    }
}

package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.c;

public final class f {
    private static f fSQ = null;
    public com.tencent.mm.a.f<String, Long> fSR = new c(10);
    public String fSS;

    public static f akh() {
        AppMethodBeat.i(78731);
        if (fSQ == null) {
            fSQ = new f();
        }
        f fVar = fSQ;
        AppMethodBeat.o(78731);
        return fVar;
    }

    private f() {
        AppMethodBeat.i(78732);
        AppMethodBeat.o(78732);
    }

    public final void u(String str, long j) {
        AppMethodBeat.i(78733);
        if (this.fSR != null) {
            this.fSS = str;
            this.fSR.put(str, Long.valueOf(j));
        }
        AppMethodBeat.o(78733);
    }
}

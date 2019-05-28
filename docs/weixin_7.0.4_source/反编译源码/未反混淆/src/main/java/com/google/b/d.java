package com.google.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends f {
    private static final d byf;

    static {
        AppMethodBeat.i(57218);
        d dVar = new d();
        byf = dVar;
        dVar.setStackTrace(byi);
        AppMethodBeat.o(57218);
    }

    private d() {
    }

    public static d vs() {
        AppMethodBeat.i(57217);
        d dVar;
        if (byh) {
            dVar = new d();
            AppMethodBeat.o(57217);
            return dVar;
        }
        dVar = byf;
        AppMethodBeat.o(57217);
        return dVar;
    }
}

package com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static volatile b lMM;
    public a lMN = new c();

    public static b bqC() {
        AppMethodBeat.i(73427);
        if (lMM == null) {
            synchronized (b.class) {
                try {
                    if (lMM == null) {
                        lMM = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(73427);
                    }
                }
            }
        }
        b bVar = lMM;
        AppMethodBeat.o(73427);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(73428);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.bqo()) {
            this.lMN.reset();
        }
        AppMethodBeat.o(73428);
    }
}

package com.tencent.mm.plugin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b implements c {
    private static b ops;

    private b() {
    }

    public static synchronized b bOh() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(79105);
            if (ops == null) {
                ops = new b();
            }
            bVar = ops;
            AppMethodBeat.o(79105);
        }
        return bVar;
    }
}

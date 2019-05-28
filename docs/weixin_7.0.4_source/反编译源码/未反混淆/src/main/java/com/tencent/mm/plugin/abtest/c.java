package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.q;

public final class c extends q {
    private static c gpO;

    private c() {
        super(com.tencent.mm.model.c.c.class);
    }

    public static synchronized c aoN() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(118192);
            if (gpO == null) {
                gpO = new c();
            }
            cVar = gpO;
            AppMethodBeat.o(118192);
        }
        return cVar;
    }

    public final void lM(String str) {
        AppMethodBeat.i(118193);
        super.lM(str);
        AppMethodBeat.o(118193);
    }
}

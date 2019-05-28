package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.q;

public final class a extends q {
    private static a gkD;

    public static synchronized a aob() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(79046);
            if (gkD == null) {
                gkD = new a();
            }
            aVar = gkD;
            AppMethodBeat.o(79046);
        }
        return aVar;
    }

    private a() {
        super(com.tencent.mm.modelstat.q.class);
    }
}

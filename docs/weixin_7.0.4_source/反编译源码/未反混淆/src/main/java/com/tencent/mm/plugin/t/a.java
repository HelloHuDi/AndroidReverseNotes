package com.tencent.mm.plugin.t;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcontrol.c;

public final class a extends q {
    private static a pfY;

    public static synchronized a bZt() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(79145);
            if (pfY == null) {
                pfY = new a();
            }
            aVar = pfY;
            AppMethodBeat.o(79145);
        }
        return aVar;
    }

    private a() {
        super(c.class);
    }
}

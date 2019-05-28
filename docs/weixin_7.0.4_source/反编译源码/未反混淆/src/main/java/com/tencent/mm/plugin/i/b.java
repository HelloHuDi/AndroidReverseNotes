package com.tencent.mm.plugin.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.storage.bh;

public final class b extends q {
    private static b nuE;

    private b() {
        super(o.class);
    }

    public static synchronized b bGD() {
        b bVar;
        synchronized (b.class) {
            AppMethodBeat.i(79095);
            if (nuE == null) {
                nuE = new b();
            }
            bVar = nuE;
            AppMethodBeat.o(79095);
        }
        return bVar;
    }

    public static bh XT() {
        AppMethodBeat.i(79096);
        g.RN().QU();
        bh XT = ((a) g.K(a.class)).XT();
        AppMethodBeat.o(79096);
        return XT;
    }
}

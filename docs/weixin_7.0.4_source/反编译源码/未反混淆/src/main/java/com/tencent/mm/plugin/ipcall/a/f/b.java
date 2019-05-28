package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.d.g;

public final class b {
    private static b nzn;
    private g nzo;

    public static b bHU() {
        AppMethodBeat.i(21898);
        if (nzn == null) {
            nzn = new b();
        }
        b bVar = nzn;
        AppMethodBeat.o(21898);
        return bVar;
    }

    public final void it(boolean z) {
        AppMethodBeat.i(21899);
        aw.Rg().c(this.nzo);
        this.nzo = null;
        if (z) {
            this.nzo = new g(1);
        } else {
            this.nzo = new g(0);
        }
        aw.Rg().a(this.nzo, 0);
        AppMethodBeat.o(21899);
    }
}

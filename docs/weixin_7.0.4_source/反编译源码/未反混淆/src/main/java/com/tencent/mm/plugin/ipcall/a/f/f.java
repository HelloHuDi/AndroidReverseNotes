package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.k;

public final class f extends a {
    public final int[] bHC() {
        return new int[]{726};
    }

    public final int getServiceType() {
        return 6;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        AppMethodBeat.i(21908);
        if (cVar != null) {
            aw.Rg().a(new k(cVar.nwu, cVar.nwv, cVar.nww), 0);
        }
        AppMethodBeat.o(21908);
    }
}

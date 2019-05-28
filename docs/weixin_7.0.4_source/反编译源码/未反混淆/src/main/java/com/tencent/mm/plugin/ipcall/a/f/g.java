package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends a {
    public final int[] bHC() {
        return new int[]{227};
    }

    public final int getServiceType() {
        return 7;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        AppMethodBeat.i(21909);
        if (cVar != null) {
            aw.Rg().a(new l(cVar.nwu, cVar.nww, cVar.nwZ), 0);
            ab.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", Integer.valueOf(cVar.nwu), Long.valueOf(cVar.nww), Boolean.valueOf(cVar.nwZ));
        }
        AppMethodBeat.o(21909);
    }
}

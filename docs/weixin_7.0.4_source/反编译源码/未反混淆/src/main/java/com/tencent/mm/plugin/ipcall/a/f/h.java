package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends a {
    public int nzr = 1;
    public boolean nzs = false;

    public final int[] bHC() {
        return new int[]{723};
    }

    public final int getServiceType() {
        return 4;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        AppMethodBeat.i(21910);
        if (cVar != null) {
            ab.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", Integer.valueOf(cVar.nwu), Integer.valueOf(cVar.nwx));
            aw.Rg().a(new n(cVar.nwu, cVar.nwv, cVar.nww, this.nzr), 0);
        }
        AppMethodBeat.o(21910);
    }
}

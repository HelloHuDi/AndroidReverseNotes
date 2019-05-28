package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.plugin.ipcall.a.a.a {
    public final int[] bHC() {
        return new int[]{843};
    }

    public final int getServiceType() {
        return 3;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        AppMethodBeat.i(21897);
        if (cVar != null) {
            ab.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", Integer.valueOf(cVar.nwu), Integer.valueOf(cVar.nwx));
            aw.Rg().a(new com.tencent.mm.plugin.ipcall.a.d.a(cVar.nwu, cVar.nwv, cVar.cMr, cVar.nwW, cVar.nwx, cVar.nww), 0);
        }
        AppMethodBeat.o(21897);
    }
}

package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends a {
    public final int[] bHC() {
        return new int[]{991};
    }

    public final int getServiceType() {
        return 1;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        AppMethodBeat.i(21904);
        if (cVar != null) {
            if (cVar.nwx == 0) {
                cVar.nwx = (int) System.currentTimeMillis();
            }
            aw.Rg().a(new i(cVar.cMr, cVar.nwW, cVar.nwx, cVar.nwy, cVar.nwz), 0);
            ab.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", cVar.cMr, cVar.nwW, Integer.valueOf(cVar.nwx));
        }
        AppMethodBeat.o(21904);
    }
}

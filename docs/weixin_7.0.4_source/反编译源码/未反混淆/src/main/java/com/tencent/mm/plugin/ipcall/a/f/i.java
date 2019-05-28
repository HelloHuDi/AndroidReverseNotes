package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends b {
    private o nzt = null;
    private int nzu = 0;

    public final int[] bHC() {
        return new int[]{819};
    }

    public final void onStop() {
        AppMethodBeat.i(21911);
        if (this.nzt != null) {
            aw.Rg().c(this.nzt);
        }
        AppMethodBeat.o(21911);
    }

    public final int getServiceType() {
        return 2;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        boolean z = true;
        AppMethodBeat.i(21912);
        String str = "MicroMsg.IPCallSyncService";
        String str2 = "serviceImpl, info==null: %b";
        Object[] objArr = new Object[1];
        if (cVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        if (this.nvN != null) {
            this.nzu = this.nvN.nwE;
            this.nzt = new o(this.nvN.nwu, this.nvN.nwv, this.nvN.bHG(), this.nvN.nww, false);
            aw.Rg().a(this.nzt, 0);
        }
        AppMethodBeat.o(21912);
    }

    public final int bHD() {
        return this.nzu;
    }

    public final void bHE() {
        AppMethodBeat.i(21913);
        ab.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
        AppMethodBeat.o(21913);
    }

    public final void bHF() {
        AppMethodBeat.i(21914);
        ab.d("MicroMsg.IPCallSyncService", "onLoopFailed");
        AppMethodBeat.o(21914);
    }
}

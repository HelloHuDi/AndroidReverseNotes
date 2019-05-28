package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c extends b {
    private h nzp;

    public final int[] bHC() {
        return new int[]{824};
    }

    public final void onStop() {
        AppMethodBeat.i(21900);
        if (this.nzp != null) {
            aw.Rg().c(this.nzp);
        }
        AppMethodBeat.o(21900);
    }

    public final int getServiceType() {
        return 5;
    }

    public final void wO() {
    }

    public final void onDestroy() {
    }

    public final void b(com.tencent.mm.plugin.ipcall.a.a.c cVar) {
        AppMethodBeat.i(21901);
        if (this.nvN != null) {
            this.nzp = new h(this.nvN.nwu, this.nvN.nwv, this.nvN.nww);
            aw.Rg().a(this.nzp, 0);
        }
        AppMethodBeat.o(21901);
    }

    public final int bHD() {
        return SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
    }

    public final void bHE() {
        AppMethodBeat.i(21902);
        ab.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
        AppMethodBeat.o(21902);
    }

    public final void bHF() {
        AppMethodBeat.i(21903);
        ab.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
        AppMethodBeat.o(21903);
    }
}

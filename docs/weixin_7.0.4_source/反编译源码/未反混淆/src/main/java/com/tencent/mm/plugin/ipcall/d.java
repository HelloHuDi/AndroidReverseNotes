package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ac.a;

public final class d {
    public static boolean bGW() {
        AppMethodBeat.i(21702);
        if (!aw.RK()) {
            AppMethodBeat.o(21702);
            return false;
        } else if (g.Nu().getInt("WCOEntranceSwitch", 0) > 0) {
            aw.ZK();
            c.Ry().set(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.TRUE);
            AppMethodBeat.o(21702);
            return true;
        } else {
            aw.ZK();
            c.Ry().set(a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.FALSE);
            AppMethodBeat.o(21702);
            return false;
        }
    }
}

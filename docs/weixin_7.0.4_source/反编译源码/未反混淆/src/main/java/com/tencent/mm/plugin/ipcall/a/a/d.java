package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public int eIV;
    public int kyZ;
    public int nwD;

    public final String toString() {
        AppMethodBeat.i(21797);
        String format = String.format("IPCallUserInfo, userStatus: %d, syncKey: %d, memberId: %d", new Object[]{Integer.valueOf(this.eIV), Integer.valueOf(this.nwD), Integer.valueOf(this.kyZ)});
        AppMethodBeat.o(21797);
        return format;
    }
}

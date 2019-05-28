package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends ae {
    private a lxD;
    private g lxF;

    public i(int i) {
        AppMethodBeat.i(19739);
        this.lxF = new g(i);
        AppMethodBeat.o(19739);
    }

    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(19740);
        if (u.bpx().hX(this.lxF.jJa)) {
            this.lxD = new a(this.lxF, dVar);
            boolean b = this.lxD.b(mVar);
            AppMethodBeat.o(19740);
            return b;
        }
        ab.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", Long.valueOf(this.lxF.jJa));
        AppMethodBeat.o(19740);
        return true;
    }
}

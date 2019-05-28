package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends ae {
    private a lxG;
    private h lxH;

    public j(int i, int i2, long j) {
        AppMethodBeat.i(19741);
        this.lxH = new h(i, i2, j);
        AppMethodBeat.o(19741);
    }

    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(19742);
        if (u.bpx().hX(this.lxH.jJa)) {
            this.lxG = new b(this.lxH, dVar);
            boolean b = this.lxG.b(mVar);
            AppMethodBeat.o(19742);
            return b;
        }
        ab.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", Long.valueOf(this.lxH.jJa));
        AppMethodBeat.o(19742);
        return true;
    }
}

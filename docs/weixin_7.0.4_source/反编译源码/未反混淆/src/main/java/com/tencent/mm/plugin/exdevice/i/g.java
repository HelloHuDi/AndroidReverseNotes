package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends ae {
    private c lxC;
    private a lxD;

    public g(byte[] bArr, int i, long j) {
        AppMethodBeat.i(19736);
        this.lxC = new i(bArr, i, j);
        AppMethodBeat.o(19736);
    }

    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(19737);
        if (u.bpx().hX(this.lxC.jJa)) {
            this.lxD = new a(this.lxC, dVar);
            boolean b = this.lxD.b(mVar);
            AppMethodBeat.o(19737);
            return b;
        }
        ab.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", Long.valueOf(this.lxC.jJa));
        AppMethodBeat.o(19737);
        return true;
    }
}

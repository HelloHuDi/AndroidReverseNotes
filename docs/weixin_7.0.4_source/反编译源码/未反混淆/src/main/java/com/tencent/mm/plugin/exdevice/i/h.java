package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.f;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends ae {
    private f lqO;
    private a lxE;

    public h(f fVar) {
        this.lqO = fVar;
    }

    public final boolean a(m mVar, d dVar) {
        AppMethodBeat.i(19738);
        this.lxE = new a(this.lqO, dVar);
        ab.i("MicroMsg.exdevice.MMSendDataToDeviceExcuter", "send data to devide : %b", Boolean.valueOf(this.lxE.b(mVar)));
        AppMethodBeat.o(19738);
        return this.lxE.b(mVar);
    }
}

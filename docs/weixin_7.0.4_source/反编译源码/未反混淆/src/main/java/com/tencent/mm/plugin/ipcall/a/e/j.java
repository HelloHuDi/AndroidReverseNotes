package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class j extends a {
    private long nyK;
    public long nyL;
    public long nzk = 0;
    public long nzl = 0;
    public long nzm = 0;

    public final void start() {
        AppMethodBeat.i(21895);
        super.start();
        this.nyK = bo.anU();
        AppMethodBeat.o(21895);
    }

    public final void reset() {
        this.nyK = 0;
        this.nyL = 0;
        this.nzk = 0;
        this.nzl = 0;
        this.nzm = 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bHT() {
        AppMethodBeat.i(21896);
        h.pYm.e(12934, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nzk), Long.valueOf(this.nzl), Long.valueOf(this.nzm));
        AppMethodBeat.o(21896);
    }
}

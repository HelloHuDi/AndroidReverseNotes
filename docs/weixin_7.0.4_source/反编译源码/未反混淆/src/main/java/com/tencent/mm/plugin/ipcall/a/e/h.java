package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends a {
    private long nyK;
    public long nyL;
    private long nzg = 0;
    public long nzh = 0;
    public long nzi = 0;
    public long nzj = 0;

    public final void start() {
        AppMethodBeat.i(21892);
        super.start();
        this.nyK = bo.anU();
        AppMethodBeat.o(21892);
    }

    public final void reset() {
        this.nyK = 0;
        this.nyL = 0;
        this.nzg = 0;
        this.nzh = 0;
        this.nzi = 0;
        this.nzj = 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bHT() {
        AppMethodBeat.i(21893);
        com.tencent.mm.plugin.report.service.h.pYm.e(12931, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nzg), Long.valueOf(this.nzh), Long.valueOf(this.nzi), Long.valueOf(this.nzj));
        AppMethodBeat.o(21893);
    }
}

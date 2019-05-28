package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class b extends a {
    private long nyK;
    public long nyL;
    public long nyM = 0;
    public long nyN = 0;
    public long nyO = 0;

    public final void start() {
        AppMethodBeat.i(21883);
        super.start();
        this.nyK = bo.anU();
        AppMethodBeat.o(21883);
    }

    public final void reset() {
        this.nyK = 0;
        this.nyL = 0;
        this.nyM = 0;
        this.nyN = 0;
        this.nyO = 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bHT() {
        AppMethodBeat.i(21884);
        h.pYm.e(12930, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nyM), Long.valueOf(this.nyN), Long.valueOf(this.nyO));
        AppMethodBeat.o(21884);
    }
}

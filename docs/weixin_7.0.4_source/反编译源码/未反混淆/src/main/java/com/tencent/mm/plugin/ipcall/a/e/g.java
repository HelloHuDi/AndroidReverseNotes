package com.tencent.mm.plugin.ipcall.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends a {
    private long nyK;
    public long nyL;
    public long nyZ = 0;
    public String nza = "";
    public String nzb = "";
    public long nzc = 0;
    public long nzd = 0;
    public long nze = 0;
    public String nzf = "";

    public final void start() {
        AppMethodBeat.i(21890);
        super.start();
        this.nyK = bo.anU();
        AppMethodBeat.o(21890);
    }

    public final void reset() {
        this.nyK = 0;
        this.nyL = 0;
        this.nyZ = 0;
        this.nza = "";
        this.nzb = "";
        this.nzc = 0;
        this.nzd = 0;
        this.nze = 0;
        this.nzf = "";
    }

    /* Access modifiers changed, original: protected|final */
    public final void bHT() {
        AppMethodBeat.i(21891);
        h.pYm.e(12933, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nyZ), this.nza, this.nzb, Long.valueOf(this.nzc), Long.valueOf(this.nzd), Long.valueOf(this.nze), this.nzf);
        AppMethodBeat.o(21891);
    }
}

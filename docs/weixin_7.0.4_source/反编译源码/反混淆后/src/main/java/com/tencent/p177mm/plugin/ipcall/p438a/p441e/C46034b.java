package com.tencent.p177mm.plugin.ipcall.p438a.p441e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.a.e.b */
public final class C46034b extends C39258a {
    private long nyK;
    public long nyL;
    public long nyM = 0;
    public long nyN = 0;
    public long nyO = 0;

    public final void start() {
        AppMethodBeat.m2504i(21883);
        super.start();
        this.nyK = C5046bo.anU();
        AppMethodBeat.m2505o(21883);
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
        AppMethodBeat.m2504i(21884);
        C7060h.pYm.mo8381e(12930, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nyM), Long.valueOf(this.nyN), Long.valueOf(this.nyO));
        AppMethodBeat.m2505o(21884);
    }
}

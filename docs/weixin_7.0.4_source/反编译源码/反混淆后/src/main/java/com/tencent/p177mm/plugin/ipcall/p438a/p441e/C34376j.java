package com.tencent.p177mm.plugin.ipcall.p438a.p441e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.a.e.j */
public final class C34376j extends C39258a {
    private long nyK;
    public long nyL;
    public long nzk = 0;
    public long nzl = 0;
    public long nzm = 0;

    public final void start() {
        AppMethodBeat.m2504i(21895);
        super.start();
        this.nyK = C5046bo.anU();
        AppMethodBeat.m2505o(21895);
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
        AppMethodBeat.m2504i(21896);
        C7060h.pYm.mo8381e(12934, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nzk), Long.valueOf(this.nzl), Long.valueOf(this.nzm));
        AppMethodBeat.m2505o(21896);
    }
}

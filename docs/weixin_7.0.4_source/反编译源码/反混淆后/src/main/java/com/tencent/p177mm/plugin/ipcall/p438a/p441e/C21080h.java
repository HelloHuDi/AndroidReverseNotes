package com.tencent.p177mm.plugin.ipcall.p438a.p441e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.a.e.h */
public final class C21080h extends C39258a {
    private long nyK;
    public long nyL;
    private long nzg = 0;
    public long nzh = 0;
    public long nzi = 0;
    public long nzj = 0;

    public final void start() {
        AppMethodBeat.m2504i(21892);
        super.start();
        this.nyK = C5046bo.anU();
        AppMethodBeat.m2505o(21892);
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
        AppMethodBeat.m2504i(21893);
        C7060h.pYm.mo8381e(12931, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nzg), Long.valueOf(this.nzh), Long.valueOf(this.nzi), Long.valueOf(this.nzj));
        AppMethodBeat.m2505o(21893);
    }
}

package com.tencent.p177mm.plugin.ipcall.p438a.p441e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.a.e.g */
public final class C34375g extends C39258a {
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
        AppMethodBeat.m2504i(21890);
        super.start();
        this.nyK = C5046bo.anU();
        AppMethodBeat.m2505o(21890);
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
        AppMethodBeat.m2504i(21891);
        C7060h.pYm.mo8381e(12933, Long.valueOf(this.nyK), Long.valueOf(this.nyL), Long.valueOf(this.nyZ), this.nza, this.nzb, Long.valueOf(this.nzc), Long.valueOf(this.nzd), Long.valueOf(this.nze), this.nzf);
        AppMethodBeat.m2505o(21891);
    }
}

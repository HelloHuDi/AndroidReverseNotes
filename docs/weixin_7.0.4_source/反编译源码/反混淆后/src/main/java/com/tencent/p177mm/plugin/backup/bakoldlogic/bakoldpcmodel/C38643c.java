package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c */
public final class C38643c {
    public int flQ;
    public int jzj;
    public int jzk;
    private int jzl;
    int jzm;
    int jzn;
    int jzo;
    public int jzp;

    private void reset() {
        this.jzj = 0;
        this.jzk = 0;
        this.flQ = 0;
        this.jzl = 0;
        this.jzm = 0;
        this.jzn = 0;
        this.jzo = 0;
        this.jzp = 0;
    }

    public final void aar() {
        AppMethodBeat.m2504i(17826);
        if (this.jzj == 0) {
            reset();
            AppMethodBeat.m2505o(17826);
            return;
        }
        C4990ab.m7417i("MicroMsg.BakPCReportor", "report: %s", getString());
        C7060h.pYm.mo8374X(11103, r0);
        reset();
        AppMethodBeat.m2505o(17826);
    }

    private String getString() {
        AppMethodBeat.m2504i(17827);
        String format = String.format("%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.jzj), Integer.valueOf(this.jzk), Integer.valueOf(this.flQ), Integer.valueOf(this.jzl), Integer.valueOf(this.jzm), Integer.valueOf(this.jzn), Integer.valueOf(this.jzo), Integer.valueOf(this.jzp)});
        AppMethodBeat.m2505o(17827);
        return format;
    }
}

package com.tencent.p177mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.bakoldlogic.p918d.C11124b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c */
public final class C27454c {
    public long eRt = 0;
    private long jsG = -1;
    boolean jsH = false;

    public final void begin() {
        AppMethodBeat.m2504i(17760);
        C4990ab.m7410d("MicroMsg.Recoverfaster", "begin");
        if (C11124b.aUY().aUZ().eJN != null) {
            this.jsG = C11124b.aUY().aUZ().eJN.mo15639iV(Thread.currentThread().getId());
            this.jsH = true;
        }
        this.eRt = C5046bo.anU();
        AppMethodBeat.m2505o(17760);
    }

    public final void end() {
        AppMethodBeat.m2504i(17761);
        if (this.jsH && C11124b.aUY().aUZ().eJN != null) {
            C11124b.aUY().aUZ().eJN.mo15640mB(this.jsG);
            this.jsH = false;
        }
        AppMethodBeat.m2505o(17761);
    }
}

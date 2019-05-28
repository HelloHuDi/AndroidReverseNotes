package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C30284ar.C30290a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.booter.l */
public final class C45271l {
    public static void run() {
        AppMethodBeat.m2504i(15861);
        int i = C26373g.m41964Nu().getInt("EnableFlockMultiProcSPProb", 0);
        C9638aw.m17190ZK();
        int bL = C1179i.m2593bL(C18628c.m29064QF(), 101);
        boolean z = C4872b.dnO() || (i > 0 && bL >= 0 && bL <= i);
        C30290a.setValue(C30290a.xAa, z);
        C4990ab.m7417i("MicroMsg.PostTaskUpdateMultiProcSPSwitchListener", "Update MMImgDecSwitch, userHash:%d, prob:%d, enabled: %b", Integer.valueOf(bL), Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.m2505o(15861);
    }
}

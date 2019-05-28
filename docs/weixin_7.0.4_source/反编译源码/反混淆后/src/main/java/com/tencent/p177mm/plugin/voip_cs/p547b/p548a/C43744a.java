package com.tencent.p177mm.plugin.voip_cs.p547b.p548a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.voip.video.C22470i;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.a.a */
public final class C43744a {
    private static C43744a tdT;
    public C22470i sTj = new C22470i(C4996ah.getContext());

    private C43744a() {
        AppMethodBeat.m2504i(135312);
        AppMethodBeat.m2505o(135312);
    }

    public static C43744a cMm() {
        AppMethodBeat.m2504i(135313);
        if (tdT == null) {
            tdT = new C43744a();
        }
        C43744a c43744a = tdT;
        AppMethodBeat.m2505o(135313);
        return c43744a;
    }

    public static C43744a cMn() {
        AppMethodBeat.m2504i(135314);
        if (tdT == null) {
            tdT = C43744a.cMm();
        }
        C43744a c43744a = tdT;
        AppMethodBeat.m2505o(135314);
        return c43744a;
    }

    public final void cMo() {
        AppMethodBeat.m2504i(135315);
        if (this.sTj != null) {
            this.sTj.mo38022ao(0, true);
        }
        AppMethodBeat.m2505o(135315);
    }

    public final void stopRing() {
        AppMethodBeat.m2504i(135316);
        if (this.sTj != null) {
            this.sTj.stop();
        }
        AppMethodBeat.m2505o(135316);
    }

    public final boolean cKq() {
        AppMethodBeat.m2504i(135317);
        if (this.sTj != null) {
            boolean DB = this.sTj.mo38019DB();
            AppMethodBeat.m2505o(135317);
            return DB;
        }
        AppMethodBeat.m2505o(135317);
        return true;
    }
}

package com.tencent.p177mm.plugin.boots.p923b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.boots.p348a.C2678a;
import com.tencent.p177mm.plugin.boots.p348a.C33719e;
import com.tencent.p177mm.plugin.boots.p923b.p1240a.C20016a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.boots.b.a */
public final class C11183a implements C33719e {
    public static C11183a jJA;
    public C20016a jJB;

    /* renamed from: rT */
    public final void mo22869rT(int i) {
        AppMethodBeat.m2504i(90530);
        m18887e(i, false, 0);
        AppMethodBeat.m2505o(90530);
    }

    /* renamed from: dC */
    public final void mo22868dC(int i, int i2) {
        AppMethodBeat.m2504i(90531);
        m18887e(i, true, i2);
        AppMethodBeat.m2505o(90531);
    }

    /* renamed from: e */
    private void m18887e(int i, boolean z, int i2) {
        int i3 = 255;
        AppMethodBeat.m2504i(90532);
        if (this.jJB != null) {
            C2678a rV = this.jJB.mo35256rV(i);
            int rU = this.jJB.mo35255rU(i);
            if (z && rV.field_dau != rU) {
                if (rU <= 255) {
                    i3 = rU;
                }
                C7060h.pYm.mo8378a((long) i2, (long) i3, 1, false);
            }
            AppMethodBeat.m2505o(90532);
            return;
        }
        C4990ab.m7420w("MicroMsg.Boots.TinkerLogic", "storage is null.");
        AppMethodBeat.m2505o(90532);
    }

    public final List<C2678a> aVJ() {
        AppMethodBeat.m2504i(90533);
        if (this.jJB != null) {
            List aVJ = this.jJB.aVJ();
            AppMethodBeat.m2505o(90533);
            return aVJ;
        }
        AppMethodBeat.m2505o(90533);
        return null;
    }
}

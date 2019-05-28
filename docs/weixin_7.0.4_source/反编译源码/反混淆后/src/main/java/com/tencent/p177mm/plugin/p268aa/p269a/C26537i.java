package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C18770e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23385e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;

/* renamed from: com.tencent.mm.plugin.aa.a.i */
public final class C26537i implements C1202f {
    long cvx = -1;
    C5688b fsC;

    public final void init() {
        AppMethodBeat.m2504i(40625);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1530, (C1202f) this);
        AppMethodBeat.m2505o(40625);
    }

    public final void aon() {
        AppMethodBeat.m2504i(40626);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1530, (C1202f) this);
        AppMethodBeat.m2505o(40626);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(40627);
        C4990ab.m7417i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            C23385e c23385e = ((C18770e) c1207m).gmg;
            C4990ab.m7417i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", Integer.valueOf(c23385e.kCl));
            C4990ab.m7411d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", c23385e.vzN);
            if (c23385e.kCl == 0) {
                C5698f.m8556a(this.fsC, Boolean.TRUE);
                if (!C5046bo.isNullOrNil(c23385e.vzN) && this.cvx > 0 && ((C18770e) c1207m).scene == C1954a.glp) {
                    C9797h.m17460h(this.cvx, c23385e.vzN);
                }
                C7060h.pYm.mo8378a(407, 21, 1, false);
                AppMethodBeat.m2505o(40627);
                return;
            } else if (c23385e.kCl <= 0 || C5046bo.isNullOrNil(c23385e.kCm)) {
                this.fsC.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(407, 23, 1, false);
                AppMethodBeat.m2505o(40627);
                return;
            } else {
                this.fsC.mo11582cR(c23385e.kCm);
                C7060h.pYm.mo8378a(407, 11, 1, false);
                AppMethodBeat.m2505o(40627);
                return;
            }
        }
        this.fsC.mo11582cR(Boolean.FALSE);
        C7060h.pYm.mo8378a(407, 22, 1, false);
        AppMethodBeat.m2505o(40627);
    }
}

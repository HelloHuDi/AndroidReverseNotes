package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;

public final class i implements f {
    long cvx = -1;
    b fsC;

    public final void init() {
        AppMethodBeat.i(40625);
        g.RQ();
        g.RO().eJo.a(1530, (f) this);
        AppMethodBeat.o(40625);
    }

    public final void aon() {
        AppMethodBeat.i(40626);
        g.RQ();
        g.RO().eJo.b(1530, (f) this);
        AppMethodBeat.o(40626);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40627);
        ab.i("MicroMsg.CloseAALogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            e eVar = ((com.tencent.mm.plugin.aa.a.a.e) mVar).gmg;
            ab.i("MicroMsg.CloseAALogic", "closeAA, response.retcode: %s", Integer.valueOf(eVar.kCl));
            ab.d("MicroMsg.CloseAALogic", "closeAA, response.msgxml: %s", eVar.vzN);
            if (eVar.kCl == 0) {
                com.tencent.mm.vending.g.f.a(this.fsC, Boolean.TRUE);
                if (!bo.isNullOrNil(eVar.vzN) && this.cvx > 0 && ((com.tencent.mm.plugin.aa.a.a.e) mVar).scene == a.glp) {
                    h.h(this.cvx, eVar.vzN);
                }
                h.pYm.a(407, 21, 1, false);
                AppMethodBeat.o(40627);
                return;
            } else if (eVar.kCl <= 0 || bo.isNullOrNil(eVar.kCm)) {
                this.fsC.cR(Boolean.FALSE);
                h.pYm.a(407, 23, 1, false);
                AppMethodBeat.o(40627);
                return;
            } else {
                this.fsC.cR(eVar.kCm);
                h.pYm.a(407, 11, 1, false);
                AppMethodBeat.o(40627);
                return;
            }
        }
        this.fsC.cR(Boolean.FALSE);
        h.pYm.a(407, 22, 1, false);
        AppMethodBeat.o(40627);
    }
}

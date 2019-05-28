package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.b;

public final class f implements com.tencent.mm.ai.f {
    boolean glH = false;
    b glt;

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40605);
        ab.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.glH = false;
        if (i == 0 && i2 == 0) {
            o oVar = ((i) mVar).gmo;
            ab.i("MicroMsg.AAPayLogic", "AAPayLogic, onSceneEnd, retcode: %s, retmsg: %s", Integer.valueOf(oVar.kCl), oVar.kCm);
            if (oVar.kCl == 0) {
                com.tencent.mm.vending.g.f.a(this.glt, oVar);
                h.pYm.a(407, 9, 1, false);
                AppMethodBeat.o(40605);
                return;
            }
            if (this.glt != null) {
                if (oVar.vAf != null && oVar.vAf.bJt == 1 && !bo.isNullOrNil(oVar.vAf.kCs) && !bo.isNullOrNil(oVar.vAf.nZb) && !bo.isNullOrNil(oVar.vAf.nZc) && !bo.isNullOrNil(oVar.vAf.cEh)) {
                    this.glt.cR(oVar.vAf);
                } else if (oVar.kCl <= 0 || bo.isNullOrNil(oVar.kCm)) {
                    this.glt.cR(Boolean.FALSE);
                } else {
                    this.glt.cR(oVar.kCm);
                }
            }
            h.pYm.a(407, 11, 1, false);
            AppMethodBeat.o(40605);
            return;
        }
        if (this.glt != null) {
            this.glt.cR(Boolean.FALSE);
        }
        h.pYm.a(407, 10, 1, false);
        AppMethodBeat.o(40605);
    }
}

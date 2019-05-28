package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.plugin.aa.a.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b implements f {
    com.tencent.mm.vending.g.b glt;

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(40594);
        ab.i("MicroMsg.AAGetPaylistDetailLogic", "onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            v vVar = ((j) mVar).gmq;
            ab.i("MicroMsg.AAGetPaylistDetailLogic", "AAQueryDetailRes, onSceneEnd, retCode: %s", Integer.valueOf(vVar.kCl));
            if (vVar.kCl == 0) {
                com.tencent.mm.vending.g.f.a(this.glt, vVar);
                h.pYm.a(407, 6, 1, false);
                c vH = com.tencent.mm.plugin.aa.b.aod().vH(vVar.vzL);
                if (vH != null) {
                    vH.field_status = vVar.state;
                    com.tencent.mm.plugin.aa.b.aod().b(vH);
                }
                AppMethodBeat.o(40594);
                return;
            }
            if (vVar.kCl <= 0 || bo.isNullOrNil(vVar.kCm)) {
                this.glt.cR(Boolean.FALSE);
            } else {
                this.glt.cR(vVar.kCm);
            }
            h.pYm.a(407, 8, 1, false);
            AppMethodBeat.o(40594);
            return;
        }
        if (this.glt != null) {
            this.glt.cR(Boolean.FALSE);
        }
        h.pYm.a(407, 7, 1, false);
        AppMethodBeat.o(40594);
    }
}

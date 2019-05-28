package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bjx;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class c extends u {
    private b ehh;
    private f ehi;
    public bjn tTC = null;

    public c(String str) {
        AppMethodBeat.i(48421);
        a aVar = new a();
        aVar.fsJ = new bjx();
        aVar.fsK = new bjy();
        aVar.uri = "/cgi-bin/mmpay-bin/payuqueryuserroll";
        aVar.fsI = 1520;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bjx bjx = (bjx) this.ehh.fsG.fsP;
        if (!bo.isNullOrNil(str)) {
            bjx.pcU = str;
        }
        AppMethodBeat.o(48421);
    }

    public final int getType() {
        return 1520;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48422);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48422);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48423);
        ab.w("MicroMsg.NetScenePayUQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            bjy bjy = (bjy) ((b) qVar).fsH.fsP;
            this.tTC = bjy.wNc;
            if (bjy.wNc != null) {
                ab.d("MicroMsg.NetScenePayUQueryUserRoll", "rr" + bjy.wNc.pcU);
                AppMethodBeat.o(48423);
                return;
            }
            ab.e("MicroMsg.NetScenePayUQueryUserRoll", "hy: user roll is null!!!");
        }
        AppMethodBeat.o(48423);
    }
}

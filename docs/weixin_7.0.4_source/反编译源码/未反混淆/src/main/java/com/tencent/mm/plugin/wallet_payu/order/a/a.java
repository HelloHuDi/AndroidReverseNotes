package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class a extends u {
    public b ehh;
    private f ehi;

    public a(int i) {
        AppMethodBeat.i(48415);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bjq();
        aVar.fsK = new bjr();
        aVar.uri = "/cgi-bin/mmpay-bin/payubatchuserroll";
        this.ehh = aVar.acD();
        bjq bjq = (bjq) this.ehh.fsG.fsP;
        bjq.nco = 10;
        bjq.vOq = i;
        ab.d("MicroMsg.NetScenePayUPayQueryUserRoll", "limit:10,offset:".concat(String.valueOf(i)));
        AppMethodBeat.o(48415);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48416);
        ab.w("MicroMsg.NetScenePayUPayQueryUserRoll", "errType = " + i + " errCode " + i2 + " errMsg " + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetScenePayUPayQueryUserRoll", "rr" + ((bjr) ((b) qVar).fsH.fsP).wMZ);
        }
        AppMethodBeat.o(48416);
    }

    public final int cTg() {
        return ((bjr) this.ehh.fsH.fsP).wMZ;
    }

    public final int getType() {
        return 1519;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48417);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48417);
        return a;
    }
}

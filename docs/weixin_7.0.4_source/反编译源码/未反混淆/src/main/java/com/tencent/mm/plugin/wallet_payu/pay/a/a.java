package com.tencent.mm.plugin.wallet_payu.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class a extends u {
    private b ehh;
    private f ehi;

    public final int getType() {
        return 1554;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48438);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48438);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48439);
        ab.d("MicroMsg.NetScenePayUCheckJsApi", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        bjs bjs = (bjs) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetScenePayUCheckJsApi", "rr " + bjs.luT);
        }
        this.ehi.onSceneEnd(i, i2, bjs.luU, this);
        AppMethodBeat.o(48439);
    }
}

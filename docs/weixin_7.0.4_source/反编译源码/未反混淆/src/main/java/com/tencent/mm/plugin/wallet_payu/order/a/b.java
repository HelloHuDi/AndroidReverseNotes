package com.tencent.mm.plugin.wallet_payu.order.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class b extends u {
    private com.tencent.mm.ai.b ehh;
    private f ehi;

    public b(String str) {
        AppMethodBeat.i(48418);
        a aVar = new a();
        aVar.fsJ = new bjt();
        aVar.fsK = new bju();
        aVar.uri = "/cgi-bin/mmpay-bin/payudeluserroll";
        this.ehh = aVar.acD();
        bjt bjt = (bjt) this.ehh.fsG.fsP;
        if (!bo.isNullOrNil(str)) {
            bjt.pcU = str;
        }
        AppMethodBeat.o(48418);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48419);
        ab.d("MicroMsg.NetScenePayUDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(48419);
    }

    public final int getType() {
        return 1544;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48420);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48420);
        return a;
    }
}

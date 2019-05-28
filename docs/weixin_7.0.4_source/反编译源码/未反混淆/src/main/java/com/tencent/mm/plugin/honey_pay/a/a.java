package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class a extends p {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyPayer";
    public rb nqx;

    public a() {
        AppMethodBeat.i(41717);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new ra();
        aVar.fsK = new rb();
        aVar.fsI = 2618;
        aVar.uri = "/cgi-bin/mmpay-bin/checkhoneypayer";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(41717);
    }

    public final int getType() {
        return 2618;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41718);
        ab.i("MicroMsg.NetSceneCheckHoneyPayer", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqx = (rb) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneCheckHoneyPayer", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqx.kdT), this.nqx.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41718);
    }

    public final void f(q qVar) {
        rb rbVar = (rb) ((b) qVar).fsH.fsP;
        this.AfC = rbVar.kdT;
        this.AfD = rbVar.kdU;
    }
}

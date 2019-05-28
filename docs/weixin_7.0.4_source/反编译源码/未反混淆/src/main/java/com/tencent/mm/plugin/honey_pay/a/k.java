package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.protocal.protobuf.bnj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class k extends p {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    public bnj nqI;

    public k(String str) {
        AppMethodBeat.i(41737);
        a aVar = new a();
        aVar.fsJ = new bni();
        aVar.fsK = new bnj();
        aVar.fsI = 2851;
        aVar.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bni) this.ehh.fsG.fsP).wpp = str;
        AppMethodBeat.o(41737);
    }

    public final int getType() {
        return 2851;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41738);
        ab.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqI = (bnj) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqI.kdT), this.nqI.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41738);
    }

    public final void f(q qVar) {
        bnj bnj = (bnj) ((b) qVar).fsH.fsP;
        this.AfC = bnj.kdT;
        this.AfD = bnj.kdU;
    }
}

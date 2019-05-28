package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class m extends p {
    private final String TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    public bnn nqK;

    public m(String str) {
        AppMethodBeat.i(41741);
        a aVar = new a();
        aVar.fsJ = new bnm();
        aVar.fsK = new bnn();
        aVar.fsI = 2613;
        aVar.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bnm) this.ehh.fsG.fsP).wpp = str;
        ab.i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", str);
        AppMethodBeat.o(41741);
    }

    public final int getType() {
        return 2613;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41742);
        ab.i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqK = (bnn) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqK.kdT), this.nqK.kdU);
        if (this.nqK.wpq != null) {
            c.U(this.nqK.wpq.cJF, this.nqK.wpq.vQO, this.nqK.wpq.ubv);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41742);
    }

    public final void f(q qVar) {
        bnn bnn = (bnn) ((b) qVar).fsH.fsP;
        this.AfC = bnn.kdT;
        this.AfD = bnn.kdU;
    }
}

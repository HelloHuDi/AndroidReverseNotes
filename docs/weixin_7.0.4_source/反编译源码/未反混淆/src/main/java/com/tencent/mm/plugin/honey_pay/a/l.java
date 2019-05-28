package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class l extends p {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    public bnl nqJ;

    public l(String str) {
        AppMethodBeat.i(41739);
        a aVar = new a();
        aVar.fsJ = new bnk();
        aVar.fsK = new bnl();
        aVar.fsI = 2876;
        aVar.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bnk) this.ehh.fsG.fsP).wpp = str;
        ab.i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", str);
        AppMethodBeat.o(41739);
    }

    public final int getType() {
        return 2876;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41740);
        ab.i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqJ = (bnl) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqJ.kdT), this.nqJ.kdU);
        if (this.nqJ.wpq != null) {
            c.U(this.nqJ.wpq.cJF, this.nqJ.wpq.vQO, this.nqJ.wpq.ubv);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41740);
    }

    public final void f(q qVar) {
        bnl bnl = (bnl) ((b) qVar).fsH.fsP;
        this.AfC = bnl.kdT;
        this.AfD = bnl.kdU;
    }
}

package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cjf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class n extends p {
    private final String TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    public cjf nqL;

    public n(String str, String str2) {
        AppMethodBeat.i(41743);
        a aVar = new a();
        aVar.fsJ = new cje();
        aVar.fsK = new cjf();
        aVar.fsI = 2659;
        aVar.uri = "/cgi-bin/mmpay-bin/unbindhpcard";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cje cje = (cje) this.ehh.fsG.fsP;
        cje.wpp = str;
        cje.wcg = str2;
        AppMethodBeat.o(41743);
    }

    public final int getType() {
        return 2659;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41744);
        ab.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqL = (cjf) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqL.kdT), this.nqL.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41744);
    }

    public final void f(q qVar) {
        cjf cjf = (cjf) ((b) qVar).fsH.fsP;
        this.AfC = cjf.kdT;
        this.AfD = cjf.kdU;
    }
}

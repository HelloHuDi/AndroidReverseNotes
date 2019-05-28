package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class g extends p {
    private final String TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    public ako nqD;

    public g(String str, long j) {
        AppMethodBeat.i(41729);
        a aVar = new a();
        aVar.fsJ = new akn();
        aVar.fsK = new ako();
        aVar.fsI = 2815;
        aVar.uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        akn akn = (akn) this.ehh.fsG.fsP;
        akn.wpp = str;
        akn.wch = j;
        ab.i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", str, Long.valueOf(j));
        AppMethodBeat.o(41729);
    }

    public final int getType() {
        return 2815;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41730);
        ab.i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqD = (ako) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqD.kdT), this.nqD.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41730);
    }

    public final void f(q qVar) {
        ako ako = (ako) ((b) qVar).fsH.fsP;
        this.AfC = ako.kdT;
        this.AfD = ako.kdU;
    }
}

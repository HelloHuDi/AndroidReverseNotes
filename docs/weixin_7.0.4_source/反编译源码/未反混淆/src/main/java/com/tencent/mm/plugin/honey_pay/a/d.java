package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ahv;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class d extends p {
    private final String TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    public ahw nqA;

    public d(String str, long j) {
        AppMethodBeat.i(41723);
        a aVar = new a();
        aVar.fsJ = new ahv();
        aVar.fsK = new ahw();
        aVar.fsI = 2630;
        aVar.uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ahv ahv = (ahv) this.ehh.fsG.fsP;
        ahv.vYl = str;
        ahv.wch = j;
        ahv.woh = k.bQO();
        ab.i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", str, Long.valueOf(j));
        AppMethodBeat.o(41723);
    }

    public final int getType() {
        return 2630;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41724);
        ab.i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqA = (ahw) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqA.kdT), this.nqA.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41724);
    }

    public final void f(q qVar) {
        ahw ahw = (ahw) ((b) qVar).fsH.fsP;
        this.AfC = ahw.kdT;
        this.AfD = ahw.kdU;
    }
}

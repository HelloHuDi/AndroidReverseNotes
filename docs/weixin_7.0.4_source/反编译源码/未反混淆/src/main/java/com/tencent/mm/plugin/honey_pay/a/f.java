package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.ath;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class f extends p {
    private final String TAG = "MicroMsg.NetSceneHoneyPayerList";
    public ath nqC;

    public f() {
        AppMethodBeat.i(41727);
        a aVar = new a();
        aVar.fsJ = new atg();
        aVar.fsK = new ath();
        aVar.fsI = 2725;
        aVar.uri = "/cgi-bin/mmpay-bin/honeypayerlist";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(41727);
    }

    public final int getType() {
        return 2725;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41728);
        ab.i("MicroMsg.NetSceneHoneyPayerList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqC = (ath) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneHoneyPayerList", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqC.kdT), this.nqC.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41728);
    }

    public final void f(q qVar) {
        ath ath = (ath) ((b) qVar).fsH.fsP;
        this.AfC = ath.kdT;
        this.AfD = ath.kdU;
    }
}

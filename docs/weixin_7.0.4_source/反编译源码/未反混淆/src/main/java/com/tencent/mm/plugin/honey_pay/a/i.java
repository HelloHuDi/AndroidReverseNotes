package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class i extends p {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    public int bJt;
    private bcz nqG;

    public i(int i) {
        AppMethodBeat.i(41733);
        a aVar = new a();
        aVar.fsJ = new bcy();
        aVar.fsK = new bcz();
        aVar.fsI = 2742;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bcy) this.ehh.fsG.fsP).tob = i;
        this.bJt = i;
        ab.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", Integer.valueOf(i));
        AppMethodBeat.o(41733);
    }

    public final int getType() {
        return 2742;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41734);
        ab.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqG = (bcz) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqG.kdT), this.nqG.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41734);
    }

    public final void f(q qVar) {
        bcz bcz = (bcz) ((b) qVar).fsH.fsP;
        this.AfC = bcz.kdT;
        this.AfD = bcz.kdU;
    }
}

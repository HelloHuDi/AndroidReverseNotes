package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class b extends p {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyUser";
    public rd nqy;
    public String username;

    public b(String str, int i) {
        AppMethodBeat.i(41719);
        a aVar = new a();
        aVar.fsJ = new rc();
        aVar.fsK = new rd();
        aVar.fsI = 2926;
        aVar.uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        rc rcVar = (rc) this.ehh.fsG.fsP;
        rcVar.vYh = str;
        rcVar.iAd = i;
        this.username = str;
        AppMethodBeat.o(41719);
    }

    public final int getType() {
        return 2926;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41720);
        ab.i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqy = (rd) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqy.kdT), this.nqy.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41720);
    }

    public final void f(q qVar) {
        rd rdVar = (rd) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        this.AfC = rdVar.kdT;
        this.AfD = rdVar.kdU;
    }
}

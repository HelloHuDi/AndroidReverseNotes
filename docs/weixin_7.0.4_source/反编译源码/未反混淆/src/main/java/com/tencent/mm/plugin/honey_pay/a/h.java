package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class h extends p {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    public bcx nqE;
    public long nqF;

    public h(long j, String str, String str2) {
        AppMethodBeat.i(41731);
        a aVar = new a();
        aVar.fsJ = new bcw();
        aVar.fsK = new bcx();
        aVar.fsI = 2865;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bcw bcw = (bcw) this.ehh.fsG.fsP;
        bcw.wch = j;
        bcw.wcg = str;
        bcw.wpp = str2;
        this.nqF = j;
        ab.d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", str2, str);
        ab.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", Long.valueOf(j));
        AppMethodBeat.o(41731);
    }

    public final int getType() {
        return 2865;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41732);
        ab.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqE = (bcx) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqE.kdT), this.nqE.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41732);
    }

    public final void f(q qVar) {
        bcx bcx = (bcx) ((b) qVar).fsH.fsP;
        this.AfC = bcx.kdT;
        this.AfD = bcx.kdU;
    }
}

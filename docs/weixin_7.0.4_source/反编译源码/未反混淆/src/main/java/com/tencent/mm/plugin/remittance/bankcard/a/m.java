package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.boe;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.sdk.platformtools.ab;

public final class m extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryTransferList";
    private b ehh;
    private f ehi;
    public bof pLE;

    public m() {
        AppMethodBeat.i(44476);
        a aVar = new a();
        aVar.fsJ = new boe();
        aVar.fsK = new bof();
        aVar.fsI = 1378;
        aVar.uri = "/cgi-bin/mmpay-bin/tsrecordlist_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(44476);
    }

    public final int getType() {
        return 1378;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44477);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44477);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44478);
        ab.i("MicroMsg.NetSceneBankRemitQueryTransferList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLE = (bof) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitQueryTransferList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLE.kCl), this.pLE.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44478);
    }

    public final void f(q qVar) {
        bof bof = (bof) ((b) qVar).fsH.fsP;
        this.AfC = bof.kCl;
        this.AfD = bof.kCm;
    }
}

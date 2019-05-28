package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public String pLt;
    public wu pLx;

    public f(String str) {
        AppMethodBeat.i(44455);
        a aVar = new a();
        aVar.fsJ = new wt();
        aVar.fsK = new wu();
        aVar.fsI = 1395;
        aVar.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((wt) this.ehh.fsG.fsP).pMd = str;
        this.pLt = str;
        AppMethodBeat.o(44455);
    }

    public final int getType() {
        return 1395;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(44456);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44456);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44457);
        ab.i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLx = (wu) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLx.kCl), this.pLx.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44457);
    }

    public final void f(q qVar) {
        wu wuVar = (wu) ((b) qVar).fsH.fsP;
        this.AfC = wuVar.kCl;
        this.AfD = wuVar.kCm;
    }
}

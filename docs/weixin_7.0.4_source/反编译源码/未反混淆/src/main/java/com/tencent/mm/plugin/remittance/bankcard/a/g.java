package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankInfo";
    public String cvZ;
    private b ehh;
    private f ehi;
    public afa pLy;

    public g(String str, String str2) {
        AppMethodBeat.i(44458);
        a aVar = new a();
        aVar.fsJ = new aez();
        aVar.fsK = new afa();
        aVar.fsI = 1542;
        aVar.uri = "/cgi-bin/mmpay-bin/getbankinfo_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((aez) this.ehh.fsG.fsP).vXu = str;
        this.cvZ = str2;
        AppMethodBeat.o(44458);
    }

    public final int getType() {
        return 1542;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44459);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44459);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44460);
        ab.i("MicroMsg.NetSceneBankRemitGetBankInfo", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLy = (afa) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitGetBankInfo", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLy.kCl), this.pLy.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44460);
    }

    public final void f(q qVar) {
        afa afa = (afa) ((b) qVar).fsH.fsP;
        this.AfC = afa.kCl;
        this.AfD = afa.kCm;
    }
}

package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.qi;
import com.tencent.mm.protocal.protobuf.qj;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    private b ehh;
    private f ehi;
    public qj pLv;

    public d(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(44449);
        a aVar = new a();
        aVar.fsJ = new qi();
        aVar.fsK = new qj();
        aVar.fsI = 1349;
        aVar.uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        qi qiVar = (qi) this.ehh.fsG.fsP;
        qiVar.vXt = str;
        qiVar.vXu = str2;
        qiVar.nuL = str3;
        qiVar.pbn = str4;
        AppMethodBeat.o(44449);
    }

    public final int getType() {
        return 1349;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44450);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44450);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44451);
        ab.i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLv = (qj) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLv.kCl), this.pLv.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44451);
    }

    public final void f(q qVar) {
        qj qjVar = (qj) ((b) qVar).fsH.fsP;
        this.AfC = qjVar.kCl;
        this.AfD = qjVar.kCm;
    }
}

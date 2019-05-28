package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    private b ehh;
    private f ehi;
    public afc pLz;

    public h() {
        AppMethodBeat.i(44461);
        a aVar = new a();
        aVar.fsJ = new afb();
        aVar.fsK = new afc();
        aVar.fsI = 1399;
        aVar.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(44461);
    }

    public final int getType() {
        return 1399;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44462);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44462);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44463);
        ab.i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLz = (afc) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLz.kCl), this.pLz.kCm);
        if (!(this.kDr || this.pLz.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44463);
    }

    public final void f(q qVar) {
        afc afc = (afc) ((b) qVar).fsH.fsP;
        this.AfC = afc.kCl;
        this.AfD = afc.kCm;
    }
}

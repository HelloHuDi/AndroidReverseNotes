package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnz;
import com.tencent.mm.protocal.protobuf.boa;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends b {
    private b ehh;
    private f ehi;
    public int limit;
    public boa pLA;

    public i(int i, int i2) {
        AppMethodBeat.i(44464);
        a aVar = new a();
        aVar.fsJ = new bnz();
        aVar.fsK = new boa();
        aVar.uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bnz bnz = (bnz) this.ehh.fsG.fsP;
        bnz.limit = i;
        bnz.offset = i2;
        this.limit = i;
        ab.i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(44464);
    }

    public final int getType() {
        return 1511;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44465);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44465);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44466);
        ab.i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLA = (boa) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLA.kCl), this.pLA.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44466);
    }

    public final void f(q qVar) {
        boa boa = (boa) ((b) qVar).fsH.fsP;
        this.AfC = boa.kCl;
        this.AfD = boa.kCm;
    }
}

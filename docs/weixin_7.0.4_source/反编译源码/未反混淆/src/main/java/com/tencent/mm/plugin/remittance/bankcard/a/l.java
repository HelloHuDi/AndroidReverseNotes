package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.bnw;
import com.tencent.mm.sdk.platformtools.ab;

public final class l extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    private b ehh;
    private f ehi;
    public bnw pLD;

    public l(String str) {
        AppMethodBeat.i(44473);
        a aVar = new a();
        aVar.fsJ = new bnv();
        aVar.fsK = new bnw();
        aVar.fsI = 1579;
        aVar.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bnv) this.ehh.fsG.fsP).vPX = str;
        ab.i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", str);
        AppMethodBeat.o(44473);
    }

    public final int getType() {
        return 1579;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44474);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44474);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44475);
        ab.i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLD = (bnw) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44475);
    }

    public final void f(q qVar) {
        bnw bnw = (bnw) ((b) qVar).fsH.fsP;
        this.AfC = bnw.kCl;
        this.AfD = bnw.kCm;
    }
}

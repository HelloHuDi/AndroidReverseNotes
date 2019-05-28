package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.ly;
import com.tencent.mm.protocal.protobuf.lz;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends m implements com.tencent.mm.network.k {
    private f ehi;
    private b gme;
    public lz pOX;

    public k(cz czVar, String str) {
        AppMethodBeat.i(44744);
        a aVar = new a();
        aVar.fsJ = new ly();
        aVar.fsK = new lz();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        ly lyVar = (ly) this.gme.fsG.fsP;
        lyVar.vPn = czVar;
        lyVar.vPD = str;
        h.pYm.k(886, 0, 1);
        ab.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", czVar.vFb, czVar.vFc, Integer.valueOf(czVar.vFg));
        AppMethodBeat.o(44744);
    }

    public final int getType() {
        return 2702;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44745);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44745);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44746);
        ab.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOX = (lz) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOX.kdT), this.pOX.kdU);
        h.pYm.k(886, 1, 1);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44746);
    }
}

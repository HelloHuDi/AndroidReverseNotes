package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bnq;
import com.tencent.mm.protocal.protobuf.bnr;

public final class l extends a<bnr> {
    private b gme;
    private bnq tfh = null;

    public l() {
        AppMethodBeat.i(45238);
        b.a aVar = new b.a();
        aVar.fsJ = new bnq();
        aVar.fsK = new bnr();
        aVar.fsI = 1211;
        aVar.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.tfh = (bnq) this.gme.fsG.fsP;
        this.tfh.time_stamp = (int) System.currentTimeMillis();
        this.tfh.tgu = ab.cMM();
        this.ehh = aVar.acD();
        AppMethodBeat.o(45238);
    }
}

package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bfg;

public final class e extends a<bfg> {
    public e(int i, int i2) {
        AppMethodBeat.i(45231);
        b.a aVar = new b.a();
        aVar.fsJ = new bff();
        aVar.fsK = new bfg();
        aVar.uri = "/cgi-bin/mmpay-bin/onclickpurchase";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bff bff = (bff) acD.fsG.fsP;
        bff.wao = i;
        bff.tyc = i2;
        bff.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45231);
    }
}

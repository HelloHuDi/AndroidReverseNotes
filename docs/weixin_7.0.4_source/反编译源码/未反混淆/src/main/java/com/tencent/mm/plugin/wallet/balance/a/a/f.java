package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.bfi;

public final class f extends a<bfi> {
    public f(int i) {
        AppMethodBeat.i(45232);
        b.a aVar = new b.a();
        aVar.fsJ = new bfh();
        aVar.fsK = new bfi();
        aVar.uri = "/cgi-bin/mmpay-bin/onclickredeem";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bfh bfh = (bfh) acD.fsG.fsP;
        bfh.wao = i;
        bfh.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45232);
    }
}

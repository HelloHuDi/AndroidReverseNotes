package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.protocal.protobuf.sw;

public final class b extends a<sw> {
    public b(String str, int i) {
        AppMethodBeat.i(45228);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new sv();
        aVar.fsK = new sw();
        aVar.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        aVar.fsL = 0;
        aVar.fsM = 0;
        com.tencent.mm.ai.b acD = aVar.acD();
        sv svVar = (sv) acD.fsG.fsP;
        svVar.wan = str;
        svVar.wao = i;
        svVar.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45228);
    }
}

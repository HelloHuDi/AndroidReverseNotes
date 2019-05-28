package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.protocal.protobuf.bnp;

public final class k extends a<bnp> {
    public k(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.i(45237);
        b.a aVar = new b.a();
        aVar.fsJ = new bno();
        aVar.fsK = new bnp();
        aVar.uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bno bno = (bno) acD.fsG.fsP;
        bno.wQm = str;
        bno.pQe = str2;
        bno.wPw = i;
        bno.wao = i2;
        bno.wOm = str3;
        bno.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45237);
    }
}

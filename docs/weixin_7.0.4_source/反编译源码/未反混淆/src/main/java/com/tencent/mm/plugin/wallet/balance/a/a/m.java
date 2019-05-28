package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bqp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.wallet_core.c.i;

public final class m extends a<bqq> implements i {
    public m(int i, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(45239);
        b.a aVar = new b.a();
        aVar.fsJ = new bqp();
        aVar.fsK = new bqq();
        aVar.uri = "/cgi-bin/mmpay-bin/redeemfund";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bqp bqp = (bqp) acD.fsG.fsP;
        bqp.wOi = i;
        bqp.wan = str;
        bqp.wOn = str2;
        bqp.wao = i2;
        bqp.wOm = str3;
        bqp.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45239);
    }
}

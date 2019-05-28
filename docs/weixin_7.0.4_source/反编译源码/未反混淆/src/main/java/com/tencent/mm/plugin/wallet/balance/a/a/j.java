package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.wallet_core.c.i;

public final class j extends a<bmo> implements i {
    public j(String str, String str2, int i, int i2, String str3) {
        AppMethodBeat.i(45236);
        b.a aVar = new b.a();
        aVar.fsJ = new bmn();
        aVar.fsK = new bmo();
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefund";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bmn bmn = (bmn) acD.fsG.fsP;
        bmn.wPv = str;
        bmn.wPw = i;
        bmn.wao = i2;
        bmn.wPx = str2;
        bmn.wOm = str3;
        bmn.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45236);
    }
}

package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.ha;

public final class i extends a<blh> {
    public i(int i, ha haVar, int i2, int i3, String str) {
        AppMethodBeat.i(45235);
        b.a aVar = new b.a();
        aVar.fsJ = new blg();
        aVar.fsK = new blh();
        aVar.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        blg blg = (blg) acD.fsG.fsP;
        blg.wOi = i;
        if (haVar != null) {
            blg.wOj = 1;
            blg.wOk = haVar;
        } else {
            blg.wOj = 0;
            blg.wOk = null;
        }
        blg.wao = i2;
        blg.wOl = i3;
        blg.wOm = str;
        blg.tgu = ab.cMM();
        this.ehh = acD;
        AppMethodBeat.o(45235);
    }
}

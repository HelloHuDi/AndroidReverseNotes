package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bad;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends a<bae> {
    public c(int i, int i2, String str) {
        AppMethodBeat.i(45229);
        b.a aVar = new b.a();
        aVar.fsJ = new bad();
        aVar.fsK = new bae();
        aVar.uri = "/cgi-bin/mmpay-bin/manageplan";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bad bad = (bad) acD.fsG.fsP;
        bad.type = i;
        bad.vES = i2;
        bad.vER = str;
        this.ehh = acD;
        ab.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(45229);
    }
}

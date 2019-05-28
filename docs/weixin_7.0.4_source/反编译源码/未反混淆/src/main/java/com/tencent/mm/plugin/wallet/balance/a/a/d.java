package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bdc;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends a<bdd> {
    public d(int i, String str, String str2, String str3, long j, int i2, String str4) {
        AppMethodBeat.i(45230);
        b.a aVar = new b.a();
        aVar.fsJ = new bdc();
        aVar.fsK = new bdd();
        aVar.uri = "/cgi-bin/mmpay-bin/modifyplan";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        bdc bdc = (bdc) acD.fsG.fsP;
        bdc.vES = i;
        bdc.pbn = str;
        bdc.pck = str2;
        bdc.vEQ = str3;
        bdc.cSh = j;
        bdc.ehf = i2;
        bdc.vER = str4;
        this.ehh = acD;
        ab.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2));
        AppMethodBeat.o(45230);
    }
}

package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.ai.a<ct> {
    public a(String str, String str2, String str3, String str4, long j, int i, int i2) {
        AppMethodBeat.i(45227);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cs();
        aVar.fsK = new ct();
        aVar.uri = "/cgi-bin/mmpay-bin/addplan";
        aVar.fsL = 0;
        aVar.fsM = 0;
        b acD = aVar.acD();
        cs csVar = (cs) acD.fsG.fsP;
        csVar.vER = str;
        csVar.pbn = str2;
        csVar.pck = str3;
        csVar.vEQ = str4;
        csVar.cSh = j;
        csVar.ehf = i;
        csVar.vES = i2;
        this.ehh = acD;
        ab.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", str3, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(45227);
    }
}

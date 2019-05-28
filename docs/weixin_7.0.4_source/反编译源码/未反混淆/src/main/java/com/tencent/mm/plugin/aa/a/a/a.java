package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.p;
import com.tencent.mm.protocal.protobuf.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.ai.a<q> {
    public a(String str, long j, int i, String str2, String str3, String str4) {
        AppMethodBeat.i(40639);
        p pVar = new p();
        pVar.vzL = str;
        pVar.vAe = j;
        pVar.scene = i;
        pVar.vzM = str2;
        pVar.vAg = str3;
        pVar.pQe = str4;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = pVar;
        aVar.fsK = new q();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", pVar.vzL, Long.valueOf(pVar.vAe), Integer.valueOf(pVar.scene), pVar.vzM, pVar.vAg, pVar.pQe);
        AppMethodBeat.o(40639);
    }
}

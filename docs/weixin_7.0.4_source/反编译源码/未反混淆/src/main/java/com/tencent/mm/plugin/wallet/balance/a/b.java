package com.tencent.mm.plugin.wallet.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a<pc> {
    public b(long j, String str, String str2) {
        AppMethodBeat.i(45220);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        pb pbVar = new pb();
        pbVar.vWl = j;
        pbVar.vWm = str;
        pbVar.vWn = str2;
        aVar.fsJ = pbVar;
        aVar.fsK = new pc();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", Long.valueOf(j), str, str2);
        AppMethodBeat.o(45220);
    }
}

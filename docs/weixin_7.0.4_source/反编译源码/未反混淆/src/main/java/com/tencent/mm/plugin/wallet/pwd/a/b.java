package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a<bhi> {
    public b() {
        AppMethodBeat.i(46167);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bhh();
        aVar.fsK = new bhi();
        aVar.uri = "/cgi-bin/mmpay-bin/openunipayorder";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
        AppMethodBeat.o(46167);
    }
}

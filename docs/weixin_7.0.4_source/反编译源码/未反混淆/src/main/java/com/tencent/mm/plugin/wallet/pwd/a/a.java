package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends com.tencent.mm.ai.a<sy> {
    public a() {
        AppMethodBeat.i(46166);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new sx();
        aVar.fsK = new sy();
        aVar.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
        AppMethodBeat.o(46166);
    }
}

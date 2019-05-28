package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends a<boh> {
    public c() {
        AppMethodBeat.i(46168);
        b.a aVar = new b.a();
        aVar.fsJ = new bog();
        aVar.fsK = new boh();
        aVar.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
        AppMethodBeat.o(46168);
    }
}

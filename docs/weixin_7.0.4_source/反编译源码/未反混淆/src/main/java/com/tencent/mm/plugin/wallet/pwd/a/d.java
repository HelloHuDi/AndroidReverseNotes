package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.cjg;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class d extends a<ckf> {
    public d(LinkedList<cjg> linkedList) {
        AppMethodBeat.i(46169);
        cke cke = new cke();
        cke.vBz = linkedList;
        b.a aVar = new b.a();
        aVar.fsJ = cke;
        aVar.fsK = new ckf();
        aVar.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
        AppMethodBeat.o(46169);
    }
}

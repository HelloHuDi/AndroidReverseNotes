package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends a<bkl> {
    public g() {
        AppMethodBeat.i(45233);
        b.a aVar = new b.a();
        aVar.fsJ = new bkk();
        aVar.fsK = new bkl();
        aVar.uri = "/cgi-bin/mmpay-bin/planindex";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiLqtPlanIndex", "isfirstclick: %s");
        AppMethodBeat.o(45233);
    }
}

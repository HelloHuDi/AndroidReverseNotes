package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.byc;

public final class l extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20798);
        a aVar = new a();
        aVar.fsJ = new byb();
        aVar.fsK = new byc();
        aVar.uri = "/cgi-bin/mmo2o-bin/setpcloginuserInfo";
        aVar.fsI = 1761;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20798);
    }

    public final int getType() {
        return 1761;
    }

    public l(String str, int i, String str2) {
        AppMethodBeat.i(20799);
        bzd();
        byb byb = (byb) this.ehh.fsG.fsP;
        byb.appId = str;
        byb.mzT = i;
        byb.cxb = str2;
        AppMethodBeat.o(20799);
    }
}

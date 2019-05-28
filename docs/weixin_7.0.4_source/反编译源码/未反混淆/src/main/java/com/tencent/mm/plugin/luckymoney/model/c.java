package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aoj;

public final class c extends a<aoj> {
    public c(String str) {
        AppMethodBeat.i(42272);
        aoi aoi = new aoi();
        b.a aVar = new b.a();
        aVar.fsJ = aoi;
        aVar.fsK = new aoj();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/getshowsource";
        aoi.wsz = str;
        this.ehh = aVar.acD();
        AppMethodBeat.o(42272);
    }
}

package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.protocal.protobuf.ty;

public final class a extends com.tencent.mm.ai.a<ty> {
    public a(String str) {
        AppMethodBeat.i(42270);
        tx txVar = new tx();
        txVar.materialId = str;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = txVar;
        aVar.fsK = new ty();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource";
        this.ehh = aVar.acD();
        AppMethodBeat.o(42270);
    }
}

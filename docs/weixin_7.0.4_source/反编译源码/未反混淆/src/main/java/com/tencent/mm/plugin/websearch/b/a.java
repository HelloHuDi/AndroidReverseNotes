package com.tencent.mm.plugin.websearch.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;

public final class a extends com.tencent.mm.ai.a<bvj> {
    b ehh;

    public a(String str) {
        AppMethodBeat.i(91363);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
        aVar.fsJ = new bvi();
        aVar.fsK = new bvj();
        this.ehh = aVar.acD();
        this.ehh = this.ehh;
        bvi bvi = (bvi) this.ehh.fsG.fsP;
        bvi.wWv = str;
        bvi.Scene = 25;
        bvi.luQ = aa.gw(ah.getContext());
        bvi.wDI = com.tencent.mm.plugin.websearch.api.aa.abJ();
        AppMethodBeat.o(91363);
    }
}

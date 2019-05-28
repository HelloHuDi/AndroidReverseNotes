package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class a extends com.tencent.mm.ai.a<hx> {
    public List<biu> okJ;

    public a(LinkedList<biu> linkedList, int i) {
        AppMethodBeat.i(43092);
        hw hwVar = new hw();
        hwVar.vKm = linkedList;
        hwVar.vKn = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = hwVar;
        aVar.fsK = new hx();
        aVar.fsI = 2938;
        aVar.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.okJ = linkedList;
        ab.i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", Integer.valueOf(i));
        AppMethodBeat.o(43092);
    }
}

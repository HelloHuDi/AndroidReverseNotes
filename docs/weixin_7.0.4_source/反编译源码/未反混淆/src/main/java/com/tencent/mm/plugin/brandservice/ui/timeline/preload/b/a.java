package com.tencent.mm.plugin.brandservice.ui.timeline.preload.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.protocal.protobuf.ry;
import java.util.LinkedList;

public final class a extends com.tencent.mm.ai.a<ry> {
    public a(LinkedList<rw> linkedList, int i, String str) {
        AppMethodBeat.i(14407);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/checktmplver";
        aVar.fsL = 0;
        aVar.fsM = 0;
        rx rxVar = new rx();
        rxVar.Scene = i;
        rxVar.vKt = str;
        rxVar.vZl = linkedList;
        aVar.fsJ = rxVar;
        aVar.fsK = new ry();
        this.ehh = aVar.acD();
        AppMethodBeat.o(14407);
    }
}

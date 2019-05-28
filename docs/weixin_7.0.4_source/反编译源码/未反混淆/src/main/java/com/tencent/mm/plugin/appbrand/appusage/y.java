package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.b;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;

class y extends a<ark> {
    y(int i, int i2, int i3) {
        this(4, 0, i, i2, i3);
    }

    y(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(129706);
        b.a aVar = new b.a();
        arj arj = new arj();
        arj.boZ = i;
        arj.wvu = i2;
        arj.condition = i3;
        arj.wvs = i4;
        arj.wvt = i5;
        aVar.fsJ = arj;
        aVar.fsK = new ark();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getwxausagerecord";
        aVar.fsI = 1148;
        this.ehh = aVar.acD();
        AppMethodBeat.o(129706);
    }
}

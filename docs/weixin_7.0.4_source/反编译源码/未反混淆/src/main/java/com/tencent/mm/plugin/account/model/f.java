package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.wxmm.v2helper;

public final class f extends m implements k {
    private final b ehh;
    private com.tencent.mm.ai.f ehi = null;

    public f(bwp bwp) {
        AppMethodBeat.i(124682);
        a aVar = new a();
        aVar.fsJ = bwp;
        aVar.fsK = new bwq();
        aVar.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
        aVar.fsI = v2helper.EMethodSetSendToNetworkOff;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(124682);
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(124683);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(124683);
        return a;
    }

    public final int getType() {
        return v2helper.EMethodSetSendToNetworkOff;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124684);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(124684);
    }
}

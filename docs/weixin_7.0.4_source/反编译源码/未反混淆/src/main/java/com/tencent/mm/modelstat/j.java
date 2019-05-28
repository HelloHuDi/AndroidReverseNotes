package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ain;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private f eIc;
    final b fSY;

    public j(com.tencent.mm.bt.b bVar) {
        AppMethodBeat.i(78737);
        a aVar = new a();
        ain ain = new ain();
        ain.woy = bVar;
        aVar.fsJ = ain;
        aVar.fsK = new aio();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.fsI = 1126;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fSY = aVar.acD();
        AppMethodBeat.o(78737);
    }

    public final int getType() {
        return 1126;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78738);
        ab.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        this.ftk = true;
        this.eIc = fVar;
        int a = a(eVar, this.fSY, this);
        AppMethodBeat.o(78738);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78739);
        ab.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar.toString());
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78739);
    }
}

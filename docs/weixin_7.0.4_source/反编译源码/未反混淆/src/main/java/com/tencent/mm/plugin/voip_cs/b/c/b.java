package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cor;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    private f ehi;

    public b(long j, long j2) {
        AppMethodBeat.i(135374);
        a aVar = new a();
        aVar.fsJ = new cor();
        aVar.fsK = new cos();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        this.ehh = aVar.acD();
        cor cor = (cor) this.ehh.fsG.fsP;
        cor.xeF = j;
        cor.wen = j2;
        cor.wOP = System.currentTimeMillis();
        AppMethodBeat.o(135374);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135375);
        ab.i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135375);
    }

    public final int getType() {
        return 795;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(135376);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135376);
        return a;
    }
}

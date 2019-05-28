package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    public com.tencent.mm.ai.b ehh;
    private f ehi;

    public b(int i) {
        AppMethodBeat.i(23060);
        a aVar = new a();
        aVar.fsJ = new uj();
        aVar.fsK = new uk();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        this.ehh = aVar.acD();
        ((uj) this.ehh.fsG.fsP).version = i;
        AppMethodBeat.o(23060);
    }

    public final int getType() {
        return 1561;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(23061);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(23061);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(23062);
        ab.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(23062);
    }
}

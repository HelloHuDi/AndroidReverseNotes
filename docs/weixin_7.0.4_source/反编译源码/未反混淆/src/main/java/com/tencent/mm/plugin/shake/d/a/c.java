package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bfr;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private b ehh;
    private f ehi;

    public c(int i, String str) {
        AppMethodBeat.i(24607);
        a aVar = new a();
        aVar.fsJ = new bfq();
        aVar.fsK = new bfr();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        this.ehh = aVar.acD();
        bfq bfq = (bfq) this.ehh.fsG.fsP;
        bfq.nbk = i;
        bfq.wJx = str;
        AppMethodBeat.o(24607);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24608);
        ab.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24608);
    }

    public final int getType() {
        return 1740;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24609);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24609);
        return a;
    }
}

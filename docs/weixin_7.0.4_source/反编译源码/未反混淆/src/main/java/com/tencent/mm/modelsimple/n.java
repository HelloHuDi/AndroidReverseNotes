package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.anq;

public final class n extends m implements k {
    private f ehi;
    public final b fAT;

    public n() {
        AppMethodBeat.i(16591);
        a aVar = new a();
        aVar.fsJ = new anp();
        aVar.fsK = new anq();
        aVar.uri = "/cgi-bin/micromsg-bin/getremind";
        this.fAT = aVar.acD();
        AppMethodBeat.o(16591);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16592);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(16592);
        return a;
    }

    public final int getType() {
        return 866;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16593);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16593);
    }
}

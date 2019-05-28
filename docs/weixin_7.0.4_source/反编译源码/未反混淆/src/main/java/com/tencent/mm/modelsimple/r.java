package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnx;
import com.tencent.mm.protocal.protobuf.bny;

public final class r extends m implements k {
    private b ehh;
    private f ehi;
    public int fPr = 1;
    public int fPs;

    public r(int i) {
        AppMethodBeat.i(123457);
        a aVar = new a();
        aVar.fsJ = new bnx();
        aVar.fsK = new bny();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.fsI = 255;
        aVar.fsL = 132;
        aVar.fsM = 1000000132;
        this.ehh = aVar.acD();
        ((bnx) this.ehh.fsG.fsP).Scene = i;
        this.fPs = i;
        AppMethodBeat.o(123457);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(123458);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(123458);
        return a;
    }

    public final int getType() {
        return 255;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(123459);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(123459);
    }
}

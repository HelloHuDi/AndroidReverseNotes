package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.protocal.protobuf.nk;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private final b ehh;
    private f ehi;

    public a(String str, String str2) {
        AppMethodBeat.i(24508);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new nj();
        aVar.fsK = new nk();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        this.ehh = aVar.acD();
        nj njVar = (nj) this.ehh.fsG.fsP;
        njVar.kbU = str;
        njVar.cMD = str2;
        AppMethodBeat.o(24508);
    }

    public final int getType() {
        return 1252;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(24509);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(24509);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(24510);
        ab.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252 errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(24510);
    }
}

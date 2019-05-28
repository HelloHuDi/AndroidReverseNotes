package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wj;
import com.tencent.mm.protocal.protobuf.wk;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private final b ehh;
    private f ehi;

    public a(String str) {
        AppMethodBeat.i(136855);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new wj();
        aVar.fsK = new wk();
        aVar.uri = "/cgi-bin/micromsg-bin/deletecardimg";
        this.ehh = aVar.acD();
        ((wj) this.ehh.fsG.fsP).wcP = str;
        AppMethodBeat.o(136855);
    }

    public final int getType() {
        return 576;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(136856);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(136856);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(136857);
        ab.d("MicroMsg.NetSceneDeleteCardImg", "onGYNetEnd:%s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(136857);
    }
}

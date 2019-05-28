package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.anv;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    public anw gzh;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(69829);
        if (!(i2 == 0 && i3 == 0)) {
            ab.e("MicroMsg.NetSceneGetSafetyInfo", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.gzh = (anw) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(69829);
    }

    public final int getType() {
        return 850;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(69830);
        a aVar = new a();
        aVar.fsJ = new anv();
        aVar.fsK = new anw();
        aVar.uri = "/cgi-bin/micromsg-bin/getsafetyinfo";
        aVar.fsI = 850;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(69830);
        return a;
    }
}

package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private f ehi;

    public final int getType() {
        return 869;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(126848);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new apc();
        aVar.fsK = new apd();
        aVar.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        aVar.fsI = 869;
        aVar.fsL = 0;
        aVar.fsM = 0;
        int a = a(eVar, aVar.acD(), this);
        AppMethodBeat.o(126848);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(126847);
        this.fth = i;
        if (!(i2 == 0 && i3 == 0)) {
            ab.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(126847);
    }
}

package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    public String country;
    public String duc;
    public String dud;
    private b ehh;
    private f ehi;

    public j(double d, double d2) {
        AppMethodBeat.i(16575);
        a aVar = new a();
        aVar.fsJ = new ahx();
        aVar.fsK = new ahy();
        aVar.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        this.ehh = aVar.acD();
        ahx ahx = (ahx) this.ehh.fsG.fsP;
        ahx.vNI = d;
        ahx.vNH = d2;
        ab.d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
        AppMethodBeat.o(16575);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16576);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16576);
        return a;
    }

    public final int getType() {
        return 665;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16577);
        ab.d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ahy ahy = (ahy) this.ehh.fsH.fsP;
            this.dud = ahy.guP;
            this.country = ahy.guW;
            this.duc = ahy.guO;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16577);
    }
}

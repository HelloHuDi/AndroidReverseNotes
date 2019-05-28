package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private f ehi;
    private b gme;
    private zt nTX;
    private zu nTY;

    public a(String str) {
        AppMethodBeat.i(42145);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new zt();
        aVar.fsK = new zu();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.gme = aVar.acD();
        this.nTX = (zt) this.gme.fsG.fsP;
        this.nTX.nSX = str;
        AppMethodBeat.o(42145);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42146);
        this.nTY = (zu) ((b) qVar).fsH.fsP;
        ab.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(this.nTY.kCl), this.nTY.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nTY.kCl, this.nTY.kCm, this);
        }
        AppMethodBeat.o(42146);
    }

    public final int getType() {
        return 1987;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(42147);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(42147);
        return a;
    }
}

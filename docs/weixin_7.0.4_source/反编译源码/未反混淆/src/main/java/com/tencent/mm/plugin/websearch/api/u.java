package com.tencent.mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class u extends m implements k {
    private f ehi;
    private b fAT;
    cvg tZR = new cvg();
    cvh tZS;

    public u(int i) {
        AppMethodBeat.i(124066);
        a aVar = new a();
        aVar.fsI = 1948;
        aVar.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        aVar.fsJ = new cvg();
        aVar.fsK = new cvh();
        this.fAT = aVar.acD();
        this.tZR = (cvg) this.fAT.fsG.fsP;
        this.tZR.wDH = aa.HV(0);
        this.tZR.luQ = aa.gw(ah.getContext());
        this.tZR.vKt = aa.bVP();
        this.tZR.wDI = aa.abJ();
        this.tZR.Scene = i;
        this.tZR.vQd = 0;
        AppMethodBeat.o(124066);
    }

    public final int getType() {
        return 1948;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(124067);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(124067);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(124068);
        ab.i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tZS = (cvh) this.fAT.fsH.fsP;
            if (this.tZS != null) {
                ab.v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", this.tZS.vOy);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(124068);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(124068);
    }
}

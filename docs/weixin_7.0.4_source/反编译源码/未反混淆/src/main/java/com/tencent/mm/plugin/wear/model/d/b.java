package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private f ehi;
    private com.tencent.mm.ai.b fAT;

    public b(String str) {
        AppMethodBeat.i(26375);
        a aVar = new a();
        aVar.uri = "/cgi-bin/micromsg-bin/sendyo";
        aVar.fsJ = new cut();
        aVar.fsK = new cuu();
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fAT = aVar.acD();
        cut cut = (cut) this.fAT.fsG.fsP;
        cut.ndF = str;
        cut.wFW = cut.pcX;
        cut.pcX = (int) bf.oC(str);
        cut.jCt = 63;
        cut.xqR = 1;
        cut.jBv = 1;
        AppMethodBeat.o(26375);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(26376);
        ab.i("MicroMsg.Wear.NetSceneSendYo", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(26376);
    }

    public final int getType() {
        return 976;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(26377);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(26377);
        return a;
    }
}

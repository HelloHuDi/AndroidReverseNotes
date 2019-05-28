package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.we;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;

    public e(String str) {
        AppMethodBeat.i(16564);
        ab.i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", str);
        a aVar = new a();
        aVar.fsJ = new wd();
        aVar.fsK = new we();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_SHIZI;
        this.ehh = aVar.acD();
        wd wdVar = (wd) this.ehh.fsG.fsP;
        wdVar.vMR = str;
        wdVar.wcJ = com.tencent.mm.bt.b.bI(new byte[0]);
        AppMethodBeat.o(16564);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_SHIZI;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(16565);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16565);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16566);
        ab.i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16566);
    }
}

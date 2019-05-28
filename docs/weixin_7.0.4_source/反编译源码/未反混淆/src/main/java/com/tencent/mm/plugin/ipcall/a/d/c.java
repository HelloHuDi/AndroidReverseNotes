package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqh;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private b ehh = null;
    private f ehi = null;
    private aqh nyj = null;
    public aqi nyk = null;

    public c() {
        AppMethodBeat.i(21842);
        a aVar = new a();
        aVar.fsJ = new aqh();
        aVar.fsK = new aqi();
        aVar.fsI = 746;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcocallinfo";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyj = (aqh) this.ehh.fsG.fsP;
        ab.i("MicroMsg.NetSceneIPCallGetCallInfo", "NetSceneIPCallGetCallInfo");
        AppMethodBeat.o(21842);
    }

    public final int getType() {
        return 746;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21843);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21843);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21844);
        ab.i("MicroMsg.NetSceneIPCallGetCallInfo", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyk = (aqi) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21844);
    }
}

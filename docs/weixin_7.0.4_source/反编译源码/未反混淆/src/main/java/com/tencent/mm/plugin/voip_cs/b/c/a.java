package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    public b ehh;
    private f ehi;

    public a(int i, long j, long j2, String str, int i2) {
        AppMethodBeat.i(135371);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cop();
        aVar.fsK = new coq();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        this.ehh = aVar.acD();
        cop cop = (cop) this.ehh.fsG.fsP;
        cop.wOQ = i;
        cop.xeF = j;
        cop.wen = j2;
        cop.xmv = str;
        cop.vIw = i2;
        cop.wOP = System.currentTimeMillis();
        AppMethodBeat.o(135371);
    }

    public final int getType() {
        return 880;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(135372);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135372);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135373);
        ab.i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135373);
    }
}

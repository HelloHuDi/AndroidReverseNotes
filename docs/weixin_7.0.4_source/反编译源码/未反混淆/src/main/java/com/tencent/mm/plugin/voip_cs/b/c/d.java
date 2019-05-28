package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cow;
import com.tencent.mm.protocal.protobuf.cox;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    public b ehh;
    private f ehi;

    public d(long j, long j2) {
        AppMethodBeat.i(135380);
        a aVar = new a();
        aVar.fsJ = new cow();
        aVar.fsK = new cox();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        this.ehh = aVar.acD();
        cow cow = (cow) this.ehh.fsG.fsP;
        cow.xeF = j;
        cow.wen = j2;
        cow.wOP = System.currentTimeMillis();
        AppMethodBeat.o(135380);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135381);
        ab.i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135381);
    }

    public final int getType() {
        return 285;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(135382);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135382);
        return a;
    }
}

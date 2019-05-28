package com.tencent.mm.plugin.voip_cs.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.cpc;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    public b ehh;
    private com.tencent.mm.ai.f ehi;

    public f(long j, long j2, int i) {
        AppMethodBeat.i(135386);
        a aVar = new a();
        aVar.fsJ = new cpb();
        aVar.fsK = new cpc();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        this.ehh = aVar.acD();
        cpb cpb = (cpb) this.ehh.fsG.fsP;
        cpb.xeF = j;
        cpb.wen = j2;
        cpb.xmD = i;
        cpb.wOP = System.currentTimeMillis();
        AppMethodBeat.o(135386);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135387);
        ab.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(135387);
    }

    public final int getType() {
        return 818;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(135388);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135388);
        return a;
    }
}

package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    private b ehh;
    private f ehi;

    public g(int i) {
        AppMethodBeat.i(16740);
        a aVar = new a();
        aVar.fsJ = new bpp();
        aVar.fsK = new bpq();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfotouch";
        this.ehh = aVar.acD();
        ((bpp) this.ehh.fsG.fsP).id = i;
        AppMethodBeat.o(16740);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16741);
        ab.d("MicroMsg.NetSceneRcptInfoTouch", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpq bpq = (bpq) ((b) qVar).fsH.fsP;
            if (bpq.wRK.wRN != null) {
                ab.d("MicroMsg.NetSceneRcptInfoTouch", "resp.rImpl.rcptinfolist.rcptinfolist " + bpq.wRK.wRN.size());
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().s(bpq.wRK.wRN);
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16741);
    }

    public final int getType() {
        return 419;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16742);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16742);
        return a;
    }
}

package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpr;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends m implements k {
    private b ehh;
    private f ehi;

    public h(com.tencent.mm.plugin.address.d.b bVar) {
        AppMethodBeat.i(16743);
        a aVar = new a();
        aVar.fsJ = new bpr();
        aVar.fsK = new bps();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        this.ehh = aVar.acD();
        bpr bpr = (bpr) this.ehh.fsG.fsP;
        bpr.wRJ = new bpk();
        bpr.wRJ.id = bVar.id;
        bpr.wRJ.wRQ = new bts().alV(bo.bc(bVar.gJb, ""));
        bpr.wRJ.wRO = new bts().alV(bo.bc(bVar.gIZ, ""));
        bpr.wRJ.wRT = new bts().alV(bo.bc(bVar.gJe, ""));
        bpr.wRJ.wRR = new bts().alV(bo.bc(bVar.gJc, ""));
        bpr.wRJ.wRU = new bts().alV(bo.bc(bVar.gJf, ""));
        bpr.wRJ.wRV = new bts().alV(bo.bc(bVar.gJg, ""));
        bpr.wRJ.wRP = new bts().alV(bo.bc(bVar.gJa, ""));
        bpr.wRJ.wRS = new bts().alV(bo.bc(bVar.gJd, ""));
        bpr.wRJ.wRW = new bts().alV(bo.bc(bVar.gJh, ""));
        AppMethodBeat.o(16743);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16744);
        ab.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bps bps = (bps) ((b) qVar).fsH.fsP;
            if (bps.wRK.wRN != null) {
                ab.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + bps.wRK.wRN.size());
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().s(bps.wRK.wRN);
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16744);
    }

    public final int getType() {
        return 418;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16745);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16745);
        return a;
    }
}

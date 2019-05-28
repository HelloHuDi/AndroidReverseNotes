package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c extends m implements k {
    private b ehh;
    private f ehi;

    public c(com.tencent.mm.plugin.address.d.b bVar) {
        AppMethodBeat.i(16728);
        a aVar = new a();
        aVar.fsJ = new bpf();
        aVar.fsK = new bpg();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        this.ehh = aVar.acD();
        bpf bpf = (bpf) this.ehh.fsG.fsP;
        bpf.wRJ = new bpk();
        bpf.wRJ.wRQ = new bts().alV(bo.bc(bVar.gJb, ""));
        bpf.wRJ.wRO = new bts().alV(bo.bc(bVar.gIZ, ""));
        bpf.wRJ.wRT = new bts().alV(bo.bc(bVar.gJe, ""));
        bpf.wRJ.wRR = new bts().alV(bo.bc(bVar.gJc, ""));
        bpf.wRJ.wRU = new bts().alV(bo.bc(bVar.gJf, ""));
        bpf.wRJ.wRV = new bts().alV(bo.bc(bVar.gJg, ""));
        bpf.wRJ.wRP = new bts().alV(bo.bc(bVar.gJa, ""));
        bpf.wRJ.wRS = new bts().alV(bo.bc(bVar.gJd, ""));
        bpf.wRJ.wRW = new bts().alV(bo.bc(bVar.gJh, ""));
        AppMethodBeat.o(16728);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16729);
        ab.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpg bpg = (bpg) ((b) qVar).fsH.fsP;
            if (bpg.wRK.wRN != null) {
                ab.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + bpg.wRK.wRN.size());
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().s(bpg.wRK.wRN);
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16729);
    }

    public final int getType() {
        return 415;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16730);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16730);
        return a;
    }
}

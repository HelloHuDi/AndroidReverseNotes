package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.protocal.protobuf.bpo;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public int gIK = 0;

    public f(int i) {
        AppMethodBeat.i(16737);
        a aVar = new a();
        aVar.fsJ = new bpn();
        aVar.fsK = new bpo();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.fsI = 416;
        aVar.fsL = 201;
        aVar.fsM = 1000000201;
        this.ehh = aVar.acD();
        this.gIK = i;
        ab.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(i)));
        ((bpn) this.ehh.fsG.fsP).id = i;
        AppMethodBeat.o(16737);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16738);
        ab.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpo bpo = (bpo) ((b) qVar).fsH.fsP;
            if (bpo.wRK.wRN != null) {
                ab.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + bpo.wRK.wRN.size());
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().s(bpo.wRK.wRN);
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16738);
    }

    public final int getType() {
        return 416;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(16739);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16739);
        return a;
    }
}

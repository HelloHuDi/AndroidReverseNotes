package com.tencent.mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class k extends p {
    public bub kCj;

    public k(String str, int i) {
        AppMethodBeat.i(40973);
        a aVar = new a();
        aVar.fsJ = new bua();
        aVar.fsK = new bub();
        aVar.uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bua bua = (bua) this.ehh.fsG.fsP;
        bua.wVT = str;
        bua.scene = i;
        ab.i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", str, Integer.valueOf(i));
        AppMethodBeat.o(40973);
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(40974);
        this.kCj = (bub) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.kCj.kCl), this.kCj.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(40974);
    }

    public final void f(q qVar) {
        bub bub = (bub) ((b) qVar).fsH.fsP;
        this.AfC = bub.kCl;
        this.AfD = bub.kCm;
    }

    public final int getType() {
        return 1800;
    }
}

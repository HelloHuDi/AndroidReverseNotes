package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.cfn;
import com.tencent.mm.protocal.protobuf.cfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class l extends u implements k {
    private b ehh;
    private f ehi;
    public String phn;

    public l(cad cad, String str) {
        AppMethodBeat.i(44000);
        a aVar = new a();
        aVar.fsJ = new cfn();
        aVar.fsK = new cfo();
        aVar.uri = "/cgi-bin/micromsg-bin/submitmallorder";
        this.ehh = aVar.acD();
        cfn cfn = (cfn) this.ehh.fsG.fsP;
        cfn.xeP = cad;
        cfn.xeR = str;
        AppMethodBeat.o(44000);
    }

    public final int getType() {
        return 556;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44001);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44001);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44002);
        cfo cfo = (cfo) ((b) qVar).fsH.fsP;
        if (i == 0 && i2 == 0) {
            ab.d("MicroMsg.NetSceneMallSubmitMallOrder", "resp.ReqKey " + cfo.xeQ);
            this.phn = cfo.xeQ;
        }
        ab.d("MicroMsg.NetSceneMallSubmitMallOrder", "errCode " + i2 + ", errMsg " + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(44002);
    }
}

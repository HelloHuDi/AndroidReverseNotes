package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class f extends u {
    private b ehh;
    private com.tencent.mm.ai.f ehi;

    public f(String str, String str2, int i) {
        AppMethodBeat.i(43775);
        a aVar = new a();
        aVar.fsJ = new ys();
        aVar.fsK = new yt();
        aVar.uri = "/cgi-bin/micromsg-bin/evaluateorder";
        this.ehh = aVar.acD();
        ys ysVar = (ys) this.ehh.fsG.fsP;
        ysVar.wes = str;
        ysVar.fKh = str2;
        ysVar.pXD = i;
        ysVar.vRP = k.cPy();
        AppMethodBeat.o(43775);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(43776);
        ab.d("MicroMsg.NetSceneEvaluateOrder", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(43776);
    }

    public final int getType() {
        return 583;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(43777);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43777);
        return a;
    }
}

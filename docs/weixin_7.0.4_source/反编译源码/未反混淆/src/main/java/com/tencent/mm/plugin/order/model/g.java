package com.tencent.mm.plugin.order.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class g extends u {
    private b ehh;
    private f ehi;

    public g(String str, String str2) {
        AppMethodBeat.i(43778);
        a aVar = new a();
        aVar.fsJ = new bis();
        aVar.fsK = new bit();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.fsI = t.CTRL_INDEX;
        this.ehh = aVar.acD();
        bis bis = (bis) this.ehh.fsG.fsP;
        bis.wMd = 1;
        if (!bo.isNullOrNil(str)) {
            bis.pcU = str;
        }
        if (!bo.isNullOrNil(str2)) {
            bis.pdn = str2;
        }
        bis.vRP = k.cPy();
        AppMethodBeat.o(43778);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(43779);
        ab.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(43779);
    }

    public final int bZa() {
        return ((bis) this.ehh.fsG.fsP).wMd;
    }

    public final String bZb() {
        return ((bis) this.ehh.fsG.fsP).pcU;
    }

    public final int getType() {
        return t.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(43780);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(43780);
        return a;
    }
}

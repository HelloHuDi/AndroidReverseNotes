package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.u;

public final class i extends u {
    private b ehh;
    private f ehi;

    public i(String str, String str2) {
        AppMethodBeat.i(48668);
        a aVar = new a();
        aVar.fsJ = new brg();
        aVar.fsK = new brh();
        aVar.uri = "/cgi-bin/micromsg-bin/removevirtualbankcard";
        this.ehh = aVar.acD();
        brg brg = (brg) this.ehh.fsG.fsP;
        brg.wTF = str;
        brg.wTE = bo.getInt(str2, 0);
        brg.vRP = k.cPy();
        AppMethodBeat.o(48668);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48669);
        ab.d("MicroMsg.NetSceneRemoveVirtualBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(48669);
    }

    public final int getType() {
        return 600;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48670);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48670);
        return a;
    }
}

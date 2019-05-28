package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class b extends u {
    private com.tencent.mm.ai.b ehh;
    private f ehi;
    private String tlg;

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(45726);
        ab.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            s.cNC();
            s.cND();
            ak.acD(this.tlg);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(45726);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.weishi.f.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(45727);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(45727);
        return a;
    }
}

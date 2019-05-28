package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class y extends m implements k {
    private b ehh;
    private f ehi;

    public final int getType() {
        return 980;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(42387);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(42387);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42388);
        ab.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(42388);
    }
}

package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.l;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    private f ehi;
    private final q ftU = new l();

    public i() {
        AppMethodBeat.i(123430);
        AppMethodBeat.o(123430);
    }

    public final int getType() {
        return 381;
    }

    public final boolean acM() {
        return false;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(123431);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(123431);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(123432);
        ab.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(123432);
    }
}

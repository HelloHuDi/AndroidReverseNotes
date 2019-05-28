package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends m implements k {
    public b ehh;
    private f ehi;
    public String fwO;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11453);
        ab.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11453);
    }

    public final int getType() {
        return 672;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11454);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11454);
        return a;
    }

    public final awv aeN() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (awv) this.ehh.fsH.fsP;
    }
}

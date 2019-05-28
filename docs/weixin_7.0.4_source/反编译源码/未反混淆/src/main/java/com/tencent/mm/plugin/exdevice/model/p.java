package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;

public final class p extends m implements k {
    public b ehh;
    private f ehi;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19325);
        ab.i("MicroMsg.exdevice.NetSceneGetHardDeviceHelpUrl", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19325);
    }

    public final int getType() {
        return 1719;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19326);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19326);
        return a;
    }
}

package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends m implements k {
    public b ehh = null;
    private f ehi = null;

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(19327);
        ab.i("MicroMsg.exdevice.NetSceneGetSportDeviceList", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19327);
    }

    public final int getType() {
        return 1267;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19328);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new aok();
        aVar.fsK = new aol();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/getsportdevicelist";
        aVar.fsI = 1267;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19328);
        return a;
    }
}

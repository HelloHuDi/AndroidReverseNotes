package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    b ehh = null;
    private f ehi = null;

    public o() {
        AppMethodBeat.i(19322);
        a aVar = new a();
        aVar.fsJ = new afz();
        aVar.fsK = new aga();
        aVar.uri = "/cgi-bin/micromsg-bin/getboundharddevices";
        aVar.fsI = 539;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((afz) this.ehh.fsG.fsP).Version = 1;
        AppMethodBeat.o(19322);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19323);
        ab.i("MicroMsg.exdevice.NetSceneGetBoundHardDevices", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19323);
    }

    public final int getType() {
        return 539;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19324);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19324);
        return a;
    }
}

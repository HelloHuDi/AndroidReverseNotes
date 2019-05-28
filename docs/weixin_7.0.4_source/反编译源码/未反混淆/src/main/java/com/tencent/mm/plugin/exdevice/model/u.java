package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.sdk.platformtools.ab;

public final class u extends m implements k {
    b ehh = null;
    private f ehi = null;

    public u(String str) {
        AppMethodBeat.i(19341);
        a aVar = new a();
        aVar.fsJ = new bvc();
        aVar.fsK = new bvd();
        aVar.uri = "/cgi-bin/micromsg-bin/searchharddevice";
        aVar.fsI = 540;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bvc) this.ehh.fsG.fsP).wWs = str;
        AppMethodBeat.o(19341);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(19342);
        ab.i("MicroMsg.exdevice.NetSceneSearchHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(19342);
    }

    public final int getType() {
        return 540;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(19343);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(19343);
        return a;
    }
}

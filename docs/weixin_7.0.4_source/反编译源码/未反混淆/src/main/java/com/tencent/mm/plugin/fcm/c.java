package com.tencent.mm.plugin.fcm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dd;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private final b ehh;
    private f ehi;

    public c(String str) {
        AppMethodBeat.i(56438);
        a aVar = new a();
        aVar.fsJ = new dd();
        aVar.fsK = new de();
        aVar.uri = "/cgi-bin/micromsg-bin/androidfcmunreg";
        this.ehh = aVar.acD();
        ((dd) this.ehh.fsG.fsP).vAK = str;
        AppMethodBeat.o(56438);
    }

    public final int getType() {
        return 643;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(56439);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(56439);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(56440);
        ab.i("MicroMsg.FCM.NetSceneFcmUnreg", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(56440);
    }
}

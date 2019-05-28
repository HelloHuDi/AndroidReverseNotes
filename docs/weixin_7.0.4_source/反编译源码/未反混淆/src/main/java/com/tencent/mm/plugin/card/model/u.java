package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ab;

public final class u extends m implements k {
    private final b ehh;
    private f ehi;

    public u(float f, float f2, String str, String str2, int i) {
        AppMethodBeat.i(87876);
        a aVar = new a();
        aVar.fsJ = new brx();
        aVar.fsK = new bry();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        this.ehh = aVar.acD();
        brx brx = (brx) this.ehh.fsG.fsP;
        brx.latitude = (double) f;
        brx.longitude = (double) f2;
        brx.cMC = str;
        brx.kbU = str2;
        brx.wTZ = i;
        AppMethodBeat.o(87876);
    }

    public final int getType() {
        return 1253;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87877);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87877);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87878);
        ab.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87878);
    }
}

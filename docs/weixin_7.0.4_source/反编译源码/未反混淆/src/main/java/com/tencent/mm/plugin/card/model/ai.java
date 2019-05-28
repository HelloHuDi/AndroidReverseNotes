package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.protocal.protobuf.bsa;
import com.tencent.mm.sdk.platformtools.ab;

public final class ai extends m implements k {
    private final b ehh;
    private f ehi;

    public ai(String str, byte[] bArr, float f, float f2, float f3, boolean z, boolean z2) {
        AppMethodBeat.i(87919);
        a aVar = new a();
        aVar.fsJ = new brz();
        aVar.fsK = new bsa();
        aVar.uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
        this.ehh = aVar.acD();
        brz brz = (brz) this.ehh.fsG.fsP;
        brz.cMC = str;
        brz.wUb = com.tencent.mm.bt.b.bI(bArr);
        brz.cGm = f;
        brz.cEB = f2;
        brz.wUa = f3;
        brz.wUc = z;
        brz.wUd = z2;
        AppMethodBeat.o(87919);
    }

    public final int getType() {
        return 2574;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87920);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87920);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87921);
        ab.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87921);
    }
}

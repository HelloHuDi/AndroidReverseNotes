package com.tencent.mm.bx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.bsc;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private f ehi;
    private final com.tencent.mm.ai.b fsB;

    public b(bsb bsb) {
        AppMethodBeat.i(116353);
        a aVar = new a();
        aVar.fsJ = new bsb();
        aVar.fsK = new bsc();
        aVar.uri = "/cgi-bin/micromsg-bin/reportmediainfo";
        this.fsB = aVar.acD();
        bsb bsb2 = (bsb) this.fsB.fsG.fsP;
        bsb2.wUf = bsb.wUf;
        bsb2.wUe = bsb.wUe;
        bsb2.wdK = bsb.wdK;
        bsb2.EmotionList.addAll(bsb.EmotionList);
        bsb2.jCt = bsb.jCt;
        AppMethodBeat.o(116353);
    }

    public final int getType() {
        return 809;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(116354);
        this.ehi = fVar;
        int a = a(eVar, this.fsB, this);
        AppMethodBeat.o(116354);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(116355);
        ab.i("MicroMsg.NetSceneReportMediaInfo", "netId :%d errType: %d, errCode: %d, errMsg:%s, hashcode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(hashCode()));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(116355);
    }
}

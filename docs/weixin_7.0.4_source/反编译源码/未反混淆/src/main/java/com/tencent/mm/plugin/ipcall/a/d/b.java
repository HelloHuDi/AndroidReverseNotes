package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private com.tencent.mm.ai.b ehh = null;
    private f ehi;
    private blw nyh = null;
    public blx nyi = null;

    public b(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.i(21839);
        a aVar = new a();
        aVar.fsJ = new blw();
        aVar.fsK = new blx();
        aVar.fsI = 807;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnchecknumber";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyh = (blw) this.ehh.fsG.fsP;
        this.nyh.wOT = str;
        this.nyh.wOV = str2;
        this.nyh.wOX = str3;
        this.nyh.wOW = str4;
        this.nyh.wOY = i;
        ab.i("MicroMsg.NetSceneIPCallCheckNumber", "NetSceneIPCallCheckNumber pureNumber:%s,lastCountry:%s,osCountry:%s,simCountry:%s,dialScene:%d", str, str2, str3, str4, Integer.valueOf(i));
        AppMethodBeat.o(21839);
    }

    public final int getType() {
        return 807;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21840);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21840);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21841);
        ab.i("MicroMsg.NetSceneIPCallCheckNumber", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyi = (blx) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21841);
    }
}

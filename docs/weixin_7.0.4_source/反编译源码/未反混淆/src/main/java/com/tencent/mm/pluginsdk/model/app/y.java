package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.ab;

public final class y extends m implements k {
    private b ehh;
    private f ehi;
    int vco;
    x vcp;

    public y(int i, x xVar) {
        AppMethodBeat.i(79366);
        this.vco = i;
        a aVar = new a();
        aVar.fsJ = new dl();
        aVar.fsK = new dm();
        aVar.uri = "/cgi-bin/micromsg-bin/appcenter";
        this.ehh = aVar.acD();
        dl dlVar = (dl) this.ehh.fsG.fsP;
        byte[] dhj = xVar.dhj();
        if (dhj != null) {
            dlVar.ReqBuf = new SKBuiltinBuffer_t().setBuffer(dhj);
        }
        dlVar.jCt = i;
        this.vcp = xVar;
        AppMethodBeat.o(79366);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(79367);
        ab.d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.vcp.bG(aa.a(((dm) this.ehh.fsH.fsP).vFq));
            this.vcp.a(i, i2, i3, str, this.ehh, bArr);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(79367);
            return;
        }
        ab.e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(79367);
    }

    public final int getType() {
        return 452;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(79368);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(79368);
        return a;
    }
}

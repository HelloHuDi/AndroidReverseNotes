package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.sdk.platformtools.ab;

public final class y extends m implements k {
    Object data;
    public b ehh;
    private f ehi;

    public y(km kmVar, Object obj) {
        AppMethodBeat.i(11461);
        a aVar = new a();
        aVar.fsJ = new bxp();
        aVar.fsK = new bxq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        this.ehh = aVar.acD();
        bxp bxp = (bxp) this.ehh.fsG.fsP;
        bxp.wmX = kmVar;
        bxp.mask = 1;
        bxp.wmV = 1;
        this.data = obj;
        AppMethodBeat.o(11461);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11462);
        ab.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11462);
    }

    public final int getType() {
        return 1228;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11463);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11463);
        return a;
    }
}

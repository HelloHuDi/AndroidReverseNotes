package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aql;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private b ehh = null;
    private f ehi = null;
    private aql nyn = null;
    public aqm nyo = null;

    public e() {
        AppMethodBeat.i(21848);
        a aVar = new a();
        aVar.fsJ = new aql();
        aVar.fsK = new aqm();
        aVar.fsI = 831;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcopackageproductlist";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyn = (aql) this.ehh.fsG.fsP;
        ab.i("MicroMsg.NetSceneIPCallGetPackageProductList", "NetSceneIPCallGetPackageProductList");
        AppMethodBeat.o(21848);
    }

    public final int getType() {
        return 831;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(21849);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21849);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21850);
        ab.i("MicroMsg.NetSceneIPCallGetPackageProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyo = (aqm) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21850);
    }
}

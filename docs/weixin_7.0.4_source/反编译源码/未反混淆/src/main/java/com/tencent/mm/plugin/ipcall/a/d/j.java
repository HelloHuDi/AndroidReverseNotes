package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    private b ehh = null;
    private f ehi = null;
    public crz nyy = null;
    public csa nyz = null;

    public j(String str) {
        AppMethodBeat.i(21863);
        a aVar = new a();
        aVar.fsJ = new crz();
        aVar.fsK = new csa();
        aVar.fsI = 277;
        aVar.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyy = (crz) this.ehh.fsG.fsP;
        this.nyy.ProductID = str;
        ab.i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", this.nyy.ProductID);
        AppMethodBeat.o(21863);
    }

    public final int getType() {
        return 277;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21864);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21864);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21865);
        ab.i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyz = (csa) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21865);
    }
}

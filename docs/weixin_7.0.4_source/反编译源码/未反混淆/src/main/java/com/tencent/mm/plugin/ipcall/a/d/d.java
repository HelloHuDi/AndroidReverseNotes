package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    private b ehh = null;
    private f ehi;
    private aqj nyl = null;
    public aqk nym = null;

    public d() {
        AppMethodBeat.i(21845);
        a aVar = new a();
        aVar.fsJ = new aqj();
        aVar.fsK = new aqk();
        aVar.fsI = com.tencent.view.d.MIC_PTU_YOUJIALI;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcogiftcardlist";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyl = (aqj) this.ehh.fsG.fsP;
        ab.i("MicroMsg.NetSceneIPCallGetGiftCardList", "NetSceneIPCallGetGiftCardList");
        AppMethodBeat.o(21845);
    }

    public final int getType() {
        return com.tencent.view.d.MIC_PTU_YOUJIALI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(21846);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21846);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21847);
        ab.i("MicroMsg.NetSceneIPCallGetGiftCardList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nym = (aqk) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21847);
    }
}

package com.tencent.mm.ax;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh;
    private f ehi;
    int fKA = 0;
    boolean fKz = false;

    public a(int i, String str) {
        AppMethodBeat.i(78417);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bmp();
        aVar.fsK = new bmq();
        aVar.uri = "/cgi-bin/micromsg-bin/pushnewtips";
        aVar.fsI = 597;
        this.ehh = aVar.acD();
        bmp bmp = (bmp) this.ehh.fsG.fsP;
        bmp.wPz = i;
        bmp.wPA = 1;
        bmp.vMU = str;
        this.fKA = i;
        AppMethodBeat.o(78417);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78418);
        if (i2 == 0 && i3 == 0) {
            this.fKz = ((bmq) ((b) qVar).fsH.fsP).wPB;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78418);
            return;
        }
        ab.e("MicroMsg.NetScenePushNewTips", "errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78418);
    }

    public final int getType() {
        return 597;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78419);
        ab.d("MicroMsg.NetScenePushNewTips", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78419);
        return a;
    }
}

package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.ayz;
import com.tencent.view.d;

public final class ab extends m implements k {
    private final b ehh;
    private f ehi;

    public ab(int i) {
        AppMethodBeat.i(78612);
        a aVar = new a();
        aVar.fsJ = new ayy();
        aVar.fsK = new ayz();
        aVar.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        aVar.fsI = d.MIC_PTU_TRANS_KONGCHENG;
        this.ehh = aVar.acD();
        ((ayy) this.ehh.fsG.fsP).OpCode = i;
        AppMethodBeat.o(78612);
    }

    public final int getType() {
        return d.MIC_PTU_TRANS_KONGCHENG;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78613);
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78613);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78614);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78614);
    }
}

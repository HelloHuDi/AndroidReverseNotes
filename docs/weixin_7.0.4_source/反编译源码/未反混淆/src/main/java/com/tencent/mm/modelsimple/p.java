package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.ayx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public final class p extends m implements k {
    public final b ehh;
    private f ehi;

    public p() {
        AppMethodBeat.i(78584);
        a aVar = new a();
        aVar.fsJ = new ayw();
        aVar.fsK = new ayx();
        aVar.uri = "/cgi-bin/micromsg-bin/logout";
        aVar.fsI = d.MIC_PTU_BAIXI;
        this.ehh = aVar.acD();
        ((ayw) this.ehh.fsG.fsP).Scene = 0;
        AppMethodBeat.o(78584);
    }

    public final int getType() {
        return d.MIC_PTU_BAIXI;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78585);
        ab.d("MicroMsg.NetSceneLogout", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78585);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78586);
        if (!(i2 == 0 && i3 == 0)) {
            ab.d("MicroMsg.NetSceneLogout", "logout Error. ");
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(78586);
    }
}

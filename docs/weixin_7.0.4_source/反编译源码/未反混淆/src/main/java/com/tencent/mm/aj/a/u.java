package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.sdk.platformtools.ab;

public final class u extends m implements k {
    public b ehh;
    private f ehi;

    public u(String str, String str2) {
        AppMethodBeat.i(11633);
        a aVar = new a();
        aVar.fsJ = new bop();
        aVar.fsK = new boq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        this.ehh = aVar.acD();
        bop bop = (bop) this.ehh.fsG.fsP;
        bop.vNb = str;
        bop.vMV = str2;
        AppMethodBeat.o(11633);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11634);
        ab.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11634);
    }

    public final int getType() {
        return 1358;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11635);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11635);
        return a;
    }
}

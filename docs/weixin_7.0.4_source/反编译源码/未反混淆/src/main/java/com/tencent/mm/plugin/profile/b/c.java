package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxr;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    public b ehh;
    private f ehi;

    public c(String str, int i) {
        AppMethodBeat.i(23287);
        a aVar = new a();
        aVar.fsJ = new bxr();
        aVar.fsK = new bxs();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        this.ehh = aVar.acD();
        bxr bxr = (bxr) this.ehh.fsG.fsP;
        bxr.vNb = str;
        bxr.wXA = i;
        bxr.wXB = 4;
        AppMethodBeat.o(23287);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(23288);
        ab.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(23288);
    }

    public final int getType() {
        return 1363;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(23289);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(23289);
        return a;
    }
}

package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.alq;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends m implements k {
    public String cHN;
    private final b ehh;
    private f ehi;

    public j(String str) {
        AppMethodBeat.i(78862);
        a aVar = new a();
        aVar.fsJ = new alq();
        aVar.fsK = new alr();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenurl";
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", str);
        ((alq) this.ehh.fsG.fsP).userName = str;
        AppMethodBeat.o(78862);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78863);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78863);
        return a;
    }

    public final int getType() {
        return 913;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78864);
        ab.i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.cHN = ((alr) this.ehh.fsH.fsP).cHN;
            ab.i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", this.cHN);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78864);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78864);
    }
}

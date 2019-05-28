package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    public b ehh;
    private f ehi;
    boolean fyf = false;

    public o(String str, String str2) {
        AppMethodBeat.i(11615);
        a aVar = new a();
        aVar.fsJ = new afn();
        aVar.fsK = new afo();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.fsI = 1352;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        afn afn = (afn) this.ehh.fsG.fsP;
        afn.vMV = str;
        afn.vNb = str2;
        this.fyf = true;
        AppMethodBeat.o(11615);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11616);
        ab.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11616);
    }

    public final int getType() {
        return 1352;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11617);
        this.ehi = fVar;
        ab.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11617);
        return a;
    }
}

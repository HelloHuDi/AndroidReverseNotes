package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.an;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends m implements k {
    private final b ehh;
    private f ehi;
    public CardGiftInfo kdV;

    public q(int i, String str, String str2, Boolean bool) {
        AppMethodBeat.i(87863);
        a aVar = new a();
        aVar.fsJ = new an();
        aVar.fsK = new ao();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptgiftcard";
        this.ehh = aVar.acD();
        an anVar = (an) this.ehh.fsG.fsP;
        anVar.vBA = i;
        anVar.vBB = str;
        anVar.vBC = str2;
        anVar.vBD = bool.booleanValue();
        AppMethodBeat.o(87863);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(87864);
        ab.i("MicroMsg.NetSceneAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.kdV = CardGiftInfo.a((ao) this.ehh.fsH.fsP);
            ab.d("MicroMsg.NetSceneAcceptGiftCard", "%s", this.kdV.toString());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87864);
    }

    public final int getType() {
        return 1136;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87865);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87865);
        return a;
    }
}

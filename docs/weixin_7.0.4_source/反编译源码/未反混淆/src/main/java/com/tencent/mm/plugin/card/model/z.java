package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.sdk.platformtools.ab;

public final class z extends m implements k {
    private final b ehh;
    private f ehi;
    public CardGiftInfo kdV;

    public z(int i, String str) {
        AppMethodBeat.i(87892);
        a aVar = new a();
        aVar.fsJ = new agj();
        aVar.fsK = new agk();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
        this.ehh = aVar.acD();
        agj agj = (agj) this.ehh.fsG.fsP;
        agj.vBA = i;
        agj.vBB = str;
        AppMethodBeat.o(87892);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87893);
        ab.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.kdV = CardGiftInfo.a((agk) this.ehh.fsH.fsP);
            ab.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", this.kdV.toString());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87893);
    }

    public final int getType() {
        return 1165;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87894);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87894);
        return a;
    }
}

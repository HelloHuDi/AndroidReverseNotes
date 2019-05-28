package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkv;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class g extends m implements k {
    private b ehh;
    private f ehi;
    private int fHT = 0;

    public g(int i, String str) {
        AppMethodBeat.i(16500);
        a aVar = new a();
        aVar.fsJ = new bkv();
        aVar.fsK = new bkw();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.fsI = 1804;
        this.ehh = aVar.acD();
        bkv bkv = (bkv) this.ehh.fsG.fsP;
        bkv.wpw = i;
        bkv.wpy = str;
        if ((i & 16) > 0) {
            com.tencent.mm.ui.i.a aVar2 = new com.tencent.mm.ui.i.a();
            civ civ = new civ();
            if (aVar2.zKU == null) {
                civ = null;
            } else if (!bo.isNullOrNil(aVar2.zKU.token)) {
                civ.xhJ = aVar2.zKU.token;
                civ.xhK = aVar2.zKU.wFn;
            }
            bkv.wNQ = civ;
        }
        this.fHT = i;
        AppMethodBeat.o(16500);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16501);
        ab.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(16501);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16501);
    }

    public final int getType() {
        return 1804;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16502);
        ab.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16502);
        return a;
    }
}

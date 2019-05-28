package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    public String content = "";
    private b ehh;
    private f ehi;
    public int fHT = 0;
    public String title = "";

    public d(int i) {
        AppMethodBeat.i(16497);
        a aVar = new a();
        aVar.fsJ = new ajx();
        aVar.fsK = new ajy();
        aVar.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        aVar.fsI = 1803;
        this.ehh = aVar.acD();
        ((ajx) this.ehh.fsG.fsP).wpw = i;
        this.fHT = i;
        AppMethodBeat.o(16497);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16498);
        ab.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ajy ajy = (ajy) this.ehh.fsH.fsP;
            this.title = ajy.wpx;
            this.content = ajy.wpy;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(16498);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16498);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16499);
        ab.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16499);
        return a;
    }
}

package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public final class b extends m implements k {
    private final com.tencent.mm.ai.b ehh;
    private f ehi;
    public String kdS;
    public String kfA = "";

    public b(double d, double d2, String str) {
        AppMethodBeat.i(88018);
        a aVar = new a();
        aVar.fsJ = new agt();
        aVar.fsK = new agu();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getcardshomepage";
        aVar.fsI = 1164;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        agt agt = (agt) this.ehh.fsG.fsP;
        agt.latitude = d;
        agt.longitude = d2;
        agt.kfA = str;
        agt.wnm = (String) g.RP().Ry().get(ac.a.USERINFO_CARD_REDOT_BUFF_STRING_SYNC, (Object) "");
        ab.d("MicroMsg.NetSceneGetCardsHomePageLayout", "red_buff:" + agt.wnm);
        AppMethodBeat.o(88018);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88019);
        ab.i("MicroMsg.NetSceneGetCardsHomePageLayout", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(1164), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            agu agu = (agu) this.ehh.fsH.fsP;
            ab.v("MicroMsg.NetSceneGetCardsHomePageLayout", "json:" + agu.kdS);
            this.kdS = agu.kdS;
            this.kfA = agu.kfA;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88019);
    }

    public final int getType() {
        return 1164;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(88020);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88020);
        return a;
    }
}

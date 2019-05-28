package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private String cMC = "";
    private final b ehh;
    private f ehi;
    public int kdT;

    public a(String str) {
        AppMethodBeat.i(88015);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new wb();
        aVar.fsK = new wc();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.fsI = 1163;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((wb) this.ehh.fsG.fsP).cMC = str;
        this.cMC = str;
        AppMethodBeat.o(88015);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88016);
        ab.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            wc wcVar = (wc) this.ehh.fsH.fsP;
            ab.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + wcVar.kdT);
            this.kdT = wcVar.kdT;
            if (this.kdT == 0) {
                am.bbe().GJ(this.cMC);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88016);
    }

    public final int getType() {
        return 1163;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(88017);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88017);
        return a;
    }
}

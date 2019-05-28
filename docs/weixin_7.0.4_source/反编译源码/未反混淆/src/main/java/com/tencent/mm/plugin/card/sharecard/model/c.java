package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aog;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;

    public c(String str) {
        AppMethodBeat.i(88021);
        a aVar = new a();
        aVar.fsJ = new aog();
        aVar.fsK = new aoh();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecard";
        this.ehh = aVar.acD();
        ((aog) this.ehh.fsG.fsP).cMC = str;
        AppMethodBeat.o(88021);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88022);
        ab.i("MicroMsg.NetSceneGetShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(904), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aoh aoh = (aoh) this.ehh.fsH.fsP;
            ab.v("MicroMsg.NetSceneGetShareCard", "json:" + aoh.kdS);
            this.kdS = aoh.kdS;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88022);
    }

    public final int getType() {
        return 904;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(88023);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88023);
        return a;
    }
}

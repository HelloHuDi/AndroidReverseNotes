package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aod;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public d(String str, String str2, String str3) {
        AppMethodBeat.i(88024);
        a aVar = new a();
        aVar.fsJ = new aoc();
        aVar.fsK = new aod();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        this.ehh = aVar.acD();
        aoc aoc = (aoc) this.ehh.fsG.fsP;
        aoc.cMC = str;
        aoc.scene = 20;
        aoc.kbU = str2;
        aoc.code = str3;
        AppMethodBeat.o(88024);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(88025);
        ab.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(910), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            aod aod = (aod) this.ehh.fsH.fsP;
            ab.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + aod.kdS);
            this.kdS = aod.kdS;
            this.kdU = aod.kdU;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(88025);
    }

    public final int getType() {
        return 910;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(88026);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(88026);
        return a;
    }
}

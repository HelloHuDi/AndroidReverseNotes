package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ai;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.cdc;
import com.tencent.mm.sdk.platformtools.ab;

public final class o extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public o(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, cdc cdc) {
        AppMethodBeat.i(87857);
        a aVar = new a();
        aVar.fsJ = new ai();
        aVar.fsK = new aj();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        this.ehh = aVar.acD();
        ai aiVar = (ai) this.ehh.fsG.fsP;
        aiVar.cMC = str;
        aiVar.kde = str2;
        aiVar.cME = i;
        aiVar.cMD = str3;
        aiVar.vBv = str4;
        aiVar.vBu = str5;
        aiVar.vBw = i2;
        aiVar.vBx = i3;
        aiVar.vBy = cdc;
        AppMethodBeat.o(87857);
    }

    public final int getType() {
        return 651;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87858);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87858);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87859);
        ab.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        aj ajVar;
        if (i2 == 0 && i3 == 0) {
            ajVar = (aj) this.ehh.fsH.fsP;
            if (ajVar != null) {
                this.kdS = ajVar.kdS;
                this.kdT = ajVar.kdT;
                this.kdU = ajVar.kdU;
            }
        } else {
            ajVar = (aj) this.ehh.fsH.fsP;
            if (ajVar != null) {
                this.kdS = ajVar.kdS;
                this.kdT = ajVar.kdT;
                this.kdU = ajVar.kdU;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87859);
    }
}

package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class p extends m implements k {
    private final b ehh;
    private f ehi;
    public String kdS;
    public int kdT;
    public String kdU;

    public p(LinkedList<nx> linkedList, int i, String str, String str2, int i2) {
        AppMethodBeat.i(87860);
        a aVar = new a();
        aVar.fsJ = new ak();
        aVar.fsK = new al();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        this.ehh = aVar.acD();
        ak akVar = (ak) this.ehh.fsG.fsP;
        akVar.vBz = linkedList;
        akVar.cME = i;
        akVar.vBv = str;
        akVar.vBu = str2;
        akVar.vBw = i2;
        AppMethodBeat.o(87860);
    }

    public final int getType() {
        return 687;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(87861);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(87861);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(87862);
        ab.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            al alVar = (al) this.ehh.fsH.fsP;
            this.kdS = alVar.kdS;
            this.kdT = alVar.kdT;
            this.kdU = alVar.kdU;
            ab.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.kdT + " ret_msg = " + this.kdU);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(87862);
    }
}

package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pk;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends m implements k {
    private f ehi;
    private b gme;
    private pk pPc;

    public n(String str, String str2, String str3, String str4, int i) {
        AppMethodBeat.i(44752);
        a aVar = new a();
        aVar.fsJ = new pk();
        aVar.fsK = new pl();
        aVar.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.pPc = (pk) this.gme.fsG.fsP;
        this.pPc.vFb = str;
        this.pPc.vFc = str2;
        this.pPc.vWF = str3;
        this.pPc.vWG = str4;
        this.pPc.nUf = i;
        ab.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", str, str2, str3, Integer.valueOf(i));
        AppMethodBeat.o(44752);
    }

    public final int getType() {
        return 1273;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44753);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44753);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44754);
        ab.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44754);
    }
}

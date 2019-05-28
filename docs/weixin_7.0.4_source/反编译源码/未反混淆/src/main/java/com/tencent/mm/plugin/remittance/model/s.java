package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.py;
import com.tencent.mm.protocal.protobuf.pz;
import com.tencent.mm.sdk.platformtools.ab;

public final class s extends m implements k {
    private f ehi;
    private b gme;
    public pz pPj;

    public s(String str, String str2, String str3, String str4, long j, String str5) {
        AppMethodBeat.i(44764);
        a aVar = new a();
        aVar.fsJ = new py();
        aVar.fsK = new pz();
        aVar.uri = "/cgi-bin/mmpay-bin/transferoldpaycheck";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        py pyVar = (py) this.gme.fsG.fsP;
        pyVar.cBT = str;
        pyVar.vWY = str2;
        pyVar.pQe = str3;
        pyVar.pPZ = str4;
        pyVar.pSg = j;
        pyVar.vWF = str5;
        ab.i("MicroMsg.NetSceneRemittancePayCheck", "reqKey: %s, transfer: %s, fee: %s", str, str2, Long.valueOf(j));
        AppMethodBeat.o(44764);
    }

    public final int getType() {
        return 1779;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44765);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44765);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44766);
        ab.i("MicroMsg.NetSceneRemittancePayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pPj = (pz) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneRemittancePayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pPj.kCl), this.pPj.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44766);
    }
}

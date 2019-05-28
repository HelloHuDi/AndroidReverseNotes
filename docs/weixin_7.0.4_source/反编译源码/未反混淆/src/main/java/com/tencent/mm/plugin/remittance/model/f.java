package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private com.tencent.mm.ai.f ehi;
    private b gme;
    public lo pOJ;

    public f(String str, String str2, String str3, int i, com.tencent.mm.bt.b bVar, String str4) {
        AppMethodBeat.i(44729);
        a aVar = new a();
        aVar.fsJ = new ln();
        aVar.fsK = new lo();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2factqry";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        ln lnVar = (ln) this.gme.fsG.fsP;
        lnVar.pPZ = str3;
        lnVar.vFb = str;
        lnVar.vFc = str2;
        lnVar.vFg = i;
        lnVar.vPe = bVar;
        lnVar.vFd = str4;
        ab.i("MicroMsg.NetSceneBusiF2fActQry", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s", str, str2, Integer.valueOf(i));
        AppMethodBeat.o(44729);
    }

    public final int getType() {
        return 1680;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(44730);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44730);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44731);
        ab.i("MicroMsg.NetSceneBusiF2fActQry", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOJ = (lo) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBusiF2fActQry", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOJ.kdT), this.pOJ.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44731);
    }
}

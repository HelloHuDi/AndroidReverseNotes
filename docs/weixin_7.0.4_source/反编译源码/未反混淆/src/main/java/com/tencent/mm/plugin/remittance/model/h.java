package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cz;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.protocal.protobuf.lt;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends m implements k {
    private f ehi;
    private b gme;
    public lt pOS;

    public h(cz czVar, String str) {
        AppMethodBeat.i(44735);
        a aVar = new a();
        aVar.fsJ = new ls();
        aVar.fsK = new lt();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        ls lsVar = (ls) this.gme.fsG.fsP;
        lsVar.vPn = czVar;
        lsVar.vPo = str;
        ab.i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", czVar.vFb, czVar.vFc, Integer.valueOf(czVar.vFg), a.a(czVar));
        AppMethodBeat.o(44735);
    }

    public final int getType() {
        return 1241;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44736);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(44736);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44737);
        ab.i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOS = (lt) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOS.kdT), this.pOS.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(44737);
    }
}

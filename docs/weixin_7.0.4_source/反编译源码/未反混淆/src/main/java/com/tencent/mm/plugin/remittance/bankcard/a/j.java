package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.sdk.platformtools.ab;

public final class j extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    private b ehh;
    private f ehi;
    public String hHV;
    public bcv pLB;
    public String pLt;

    public j(String str, String str2) {
        AppMethodBeat.i(44467);
        a aVar = new a();
        aVar.fsJ = new bcu();
        aVar.fsK = new bcv();
        aVar.fsI = 1590;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bcu bcu = (bcu) this.ehh.fsG.fsP;
        bcu.pMd = str;
        bcu.pMg = str2;
        this.pLt = str;
        this.hHV = str2;
        AppMethodBeat.o(44467);
    }

    public final int getType() {
        return 1590;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44468);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44468);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44469);
        ab.i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLB = (bcv) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLB.kCl), this.pLB.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44469);
    }

    public final void f(q qVar) {
        bcv bcv = (bcv) ((b) qVar).fsH.fsP;
        this.AfC = bcv.kCl;
        this.AfD = bcv.kCm;
    }
}

package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.protocal.protobuf.wq;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    private b ehh;
    private f ehi;
    public String kBD;
    public wq pLw;

    public e(String str) {
        AppMethodBeat.i(44452);
        a aVar = new a();
        aVar.fsJ = new wp();
        aVar.fsK = new wq();
        aVar.fsI = 1737;
        aVar.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((wp) this.ehh.fsG.fsP).vPX = str;
        this.kBD = str;
        AppMethodBeat.o(44452);
    }

    public final int getType() {
        return 1737;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(44453);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44453);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44454);
        ab.i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLw = (wq) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLw.kCl), this.pLw.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44454);
    }

    public final void f(q qVar) {
        wq wqVar = (wq) ((b) qVar).fsH.fsP;
        this.AfC = wqVar.kCl;
        this.AfD = wqVar.kCm;
    }
}

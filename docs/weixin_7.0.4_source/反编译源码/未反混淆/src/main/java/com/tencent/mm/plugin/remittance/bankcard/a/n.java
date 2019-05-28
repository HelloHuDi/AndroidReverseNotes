package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bsd;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    private b ehh;
    private f ehi;
    private bse pLF;

    public n(String str, String str2, int i) {
        AppMethodBeat.i(44479);
        ab.i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", str, str2, Integer.valueOf(i));
        a aVar = new a();
        bsd bsd = new bsd();
        bsd.wUg = new com.tencent.mm.bt.b(String.valueOf(str).getBytes());
        bsd.wKQ = str2;
        bsd.vPy = i;
        aVar.fsJ = bsd;
        aVar.fsK = new bse();
        aVar.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
        aVar.fsI = 2739;
        this.ehh = aVar.acD();
        AppMethodBeat.o(44479);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44480);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44480);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44481);
        ab.i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLF = (bse) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44481);
    }

    public final void f(q qVar) {
        bse bse = (bse) ((b) qVar).fsH.fsP;
        this.AfC = bse.kCl;
        this.AfD = bse.kCm;
    }

    public final int getType() {
        return 2739;
    }
}

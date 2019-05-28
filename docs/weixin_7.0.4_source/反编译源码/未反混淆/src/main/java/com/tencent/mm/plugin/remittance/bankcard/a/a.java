package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.fk;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    private b ehh;
    private f ehi;
    public fl pLs;
    public String pLt;

    public a(String str, String str2, String str3) {
        AppMethodBeat.i(44443);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new fk();
        aVar.fsK = new fl();
        aVar.fsI = 1348;
        aVar.uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        fk fkVar = (fk) this.ehh.fsG.fsP;
        fkVar.pMd = str;
        fkVar.vHs = str2;
        fkVar.pbn = str3;
        this.pLt = str;
        ab.i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", str, str2, str3);
        AppMethodBeat.o(44443);
    }

    public final int getType() {
        return 1348;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44444);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44444);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44445);
        ab.i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLs = (fl) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLs.kCl), this.pLs.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44445);
    }

    public final void f(q qVar) {
        fl flVar = (fl) ((b) qVar).fsH.fsP;
        this.AfC = flVar.kCl;
        this.AfD = flVar.kCm;
    }
}

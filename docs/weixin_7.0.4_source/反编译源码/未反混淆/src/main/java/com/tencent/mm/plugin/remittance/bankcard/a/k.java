package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.ttpic.util.ActUtil;

public final class k extends b {
    private b ehh;
    private f ehi;
    public bho pLC;

    public k() {
        AppMethodBeat.i(44470);
        a aVar = new a();
        aVar.fsJ = new bhn();
        aVar.fsK = new bho();
        aVar.fsI = ActUtil.HEIGHT;
        aVar.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
        this.ehh = aVar.acD();
        AppMethodBeat.o(44470);
    }

    public final int getType() {
        return ActUtil.HEIGHT;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44471);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44471);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44472);
        ab.i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLC = (bho) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLC.kCl), this.pLC.kCm);
        if (!(this.kDr || this.kDs)) {
            ab.i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", Integer.valueOf(this.pLC.wKN), Integer.valueOf(this.pLC.wKO));
            if (this.pLC.wKN >= 0) {
                g.RP().Ry().set(ac.a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, Integer.valueOf(this.pLC.wKN));
            }
            if (this.pLC.wKO > 0) {
                g.RP().Ry().set(ac.a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf(this.pLC.wKO));
            }
            if (!bo.isNullOrNil(this.pLC.wKP)) {
                g.RP().Ry().set(ac.a.USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC, this.pLC.wKP);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44472);
    }

    public final void f(q qVar) {
        bho bho = (bho) ((b) qVar).fsH.fsP;
        this.AfC = bho.kCl;
        this.AfD = bho.kCm;
    }
}

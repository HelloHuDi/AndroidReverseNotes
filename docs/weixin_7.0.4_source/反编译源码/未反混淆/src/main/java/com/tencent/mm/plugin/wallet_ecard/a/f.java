package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends m implements k {
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public bnf tQn;

    public f(String str, int i) {
        AppMethodBeat.i(48065);
        a aVar = new a();
        aVar.fsJ = new bne();
        aVar.fsK = new bnf();
        aVar.uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bne bne = (bne) this.ehh.fsG.fsP;
        bne.vKZ = str;
        bne.cHF = i;
        ab.i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", str, Integer.valueOf(i));
        AppMethodBeat.o(48065);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(48066);
        ab.i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQn = (bnf) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tQn.kdT), this.tQn.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(48066);
    }

    public final int getType() {
        return 1988;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(48067);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48067);
        return a;
    }
}

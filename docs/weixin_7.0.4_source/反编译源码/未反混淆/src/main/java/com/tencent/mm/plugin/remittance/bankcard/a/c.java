package com.tencent.mm.plugin.remittance.bankcard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends b {
    private final String TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    private b ehh;
    private f ehi;
    public me pLu;

    public c(String str, String str2) {
        AppMethodBeat.i(44446);
        a aVar = new a();
        aVar.fsJ = new md();
        aVar.fsK = new me();
        aVar.fsI = 1340;
        aVar.uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        md mdVar = (md) this.ehh.fsG.fsP;
        mdVar.vPX = str;
        mdVar.pQe = str2;
        AppMethodBeat.o(44446);
    }

    public final int getType() {
        return 1340;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44447);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44447);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(44448);
        ab.i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLu = (me) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLu.kCl), this.pLu.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(44448);
    }

    public final void f(q qVar) {
        me meVar = (me) ((b) qVar).fsH.fsP;
        this.AfC = meVar.kCl;
        this.AfD = meVar.kCm;
    }
}

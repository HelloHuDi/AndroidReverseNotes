package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bng;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class g extends p {
    private b ehh;
    private f ehi;
    public bnh tQo;

    public g() {
        AppMethodBeat.i(48068);
        a aVar = new a();
        aVar.fsJ = new bng();
        aVar.fsK = new bnh();
        aVar.uri = "/cgi-bin/mmpay-bin/qrycancelecarddesc";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((bng) this.ehh.fsG.fsP).wQe = 1;
        AppMethodBeat.o(48068);
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(48069);
        ab.i("MicroMsg.NetSceneQryECardLogout", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.tQo = (bnh) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQryECardLogout", "retcode: %s, retmsg: %s", Integer.valueOf(this.tQo.kdT), this.tQo.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(48069);
    }

    public final void f(q qVar) {
        bnh bnh = (bnh) ((b) qVar).fsH.fsP;
        this.AfC = bnh.kdT;
        this.AfD = bnh.kdU;
    }

    public final int getType() {
        return 2931;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(48070);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(48070);
        return a;
    }
}

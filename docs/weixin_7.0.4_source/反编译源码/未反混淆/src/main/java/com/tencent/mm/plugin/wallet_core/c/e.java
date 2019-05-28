package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private b ehh;
    private f ehi;
    public aey ttO;

    public e(String str) {
        AppMethodBeat.i(46500);
        a aVar = new a();
        aVar.fsJ = new aex();
        aVar.fsK = new aey();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        aVar.fsO = com.tencent.mm.wallet_core.ui.e.atB(str);
        this.ehh = aVar.acD();
        aex aex = (aex) this.ehh.fsG.fsP;
        ab.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", str);
        aex.cBT = str;
        AppMethodBeat.o(46500);
    }

    public final int getType() {
        return 1667;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(46501);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46501);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46502);
        ab.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.ttO = (aey) this.ehh.fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(46502);
    }
}

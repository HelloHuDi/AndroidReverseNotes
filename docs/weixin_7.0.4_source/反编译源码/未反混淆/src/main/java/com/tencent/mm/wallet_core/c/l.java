package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.e;

public final class l extends u {
    private b ehh;
    private f ehi;

    public l(String str, String str2) {
        AppMethodBeat.i(49058);
        a aVar = new a();
        aVar.fsJ = new nh();
        aVar.fsK = new ni();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.fsL = o.CTRL_INDEX;
        aVar.fsM = 1000000198;
        aVar.fsO = e.atB(str2);
        this.ehh = aVar.acD();
        nh nhVar = (nh) this.ehh.fsG.fsP;
        nhVar.vRO = str;
        nhVar.vHD = str2;
        nhVar.vRP = k.cPy();
        AppMethodBeat.o(49058);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(49059);
        ab.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(49059);
    }

    public final int getType() {
        return 410;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(49060);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(49060);
        return a;
    }
}

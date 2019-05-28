package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.wxmm.v2helper;

public final class r extends u {
    private b ehh;
    private f ehi;

    public r(String str) {
        this(str, null, null, -1, -1, -1);
    }

    public r(String str, String str2, String str3, int i, int i2, int i3) {
        AppMethodBeat.i(49074);
        a aVar = new a();
        aVar.fsJ = new bjo();
        aVar.fsK = new bjp();
        aVar.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        aVar.fsI = v2helper.EMethodSetPlayerPreCorrectCofOff;
        aVar.fsL = 0;
        aVar.fsM = 0;
        aVar.fsO = e.atB(str2);
        this.ehh = aVar.acD();
        bjo bjo = (bjo) this.ehh.fsG.fsP;
        bjo.wMV = str;
        bjo.vRP = k.cPy();
        bjo.wMW = str3;
        if (!bo.isNullOrNil(str2)) {
            bjo.wMX = new com.tencent.mm.bt.b(str2.getBytes());
        }
        if (i >= 0) {
            bjo.vRK = i;
        }
        if (i2 >= 0) {
            bjo.vAM = i2;
        }
        if (i3 >= 0) {
            bjo.wMY = i3;
        }
        AppMethodBeat.o(49074);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(49075);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(49075);
        return a;
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(49076);
        ab.d("MicroMsg.NetScenePaySubscribe", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(49076);
    }

    public final int getType() {
        return v2helper.EMethodSetPlayerPreCorrectCofOff;
    }
}

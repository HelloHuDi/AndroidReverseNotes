package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends m implements k {
    private f ehi;
    private b gme;
    private aep ttU;
    public aeq ttV;
    public long ttW;

    public h(String str, long j) {
        AppMethodBeat.i(46509);
        a aVar = new a();
        aVar.fsJ = new aep();
        aVar.fsK = new aeq();
        aVar.uri = "/cgi-bin/mmpay-bin/mktgetaward";
        this.gme = aVar.acD();
        this.ttU = (aep) this.gme.fsG.fsP;
        this.ttU.wmr = str;
        this.ttW = j;
        ab.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", str, Long.valueOf(j));
        AppMethodBeat.o(46509);
    }

    public final int getType() {
        return 2948;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46510);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(46510);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46511);
        ab.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ttV = (aeq) ((b) qVar).fsH.fsP;
        if (i2 == 0 || i3 == 0) {
            ab.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", Integer.valueOf(this.ttV.kdT), this.ttV.kdU, Integer.valueOf(this.ttV.wms), this.ttV.wmt, this.ttV.wmu);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(46511);
    }
}

package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.xp;
import com.tencent.mm.protocal.protobuf.xq;
import com.tencent.mm.sdk.platformtools.ab;

public final class g extends m implements k {
    private f ehi;
    private b gme;
    private xp ttR;
    public xq ttS;
    private boolean ttT;

    public g(String str, int i, boolean z) {
        AppMethodBeat.i(46506);
        this.ttT = z;
        a aVar = new a();
        aVar.fsJ = new xp();
        aVar.fsK = new xq();
        if (z) {
            aVar.fsI = 1859;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawf2flottery";
        } else {
            aVar.fsI = 2547;
            aVar.uri = "/cgi-bin/mmpay-bin/mktdrawlottery";
        }
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.ttR = (xp) this.gme.fsG.fsP;
        this.ttR.wdr = str;
        this.ttR.wds = i;
        ab.i("MicroMsg.NetSceneMktDrawLottery", "NetSceneMktDrawLottery, drawLotteryParams: %s, drawLotteryType: %s, isF2f: %s", str, Integer.valueOf(i), Boolean.valueOf(z));
        AppMethodBeat.o(46506);
    }

    public final int getType() {
        if (this.ttT) {
            return 1859;
        }
        return 2547;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46507);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(46507);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46508);
        ab.i("MicroMsg.NetSceneMktDrawLottery", "onGYNetEnd netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ttS = (xq) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(46508);
    }
}

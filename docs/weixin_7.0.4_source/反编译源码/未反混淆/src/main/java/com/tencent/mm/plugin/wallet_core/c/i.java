package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends m implements k {
    private f ehi;
    private b gme;
    private boolean ttT;
    private akl ttX;
    public akm ttY;

    public i(String str, boolean z) {
        AppMethodBeat.i(46512);
        this.ttT = z;
        a aVar = new a();
        aVar.fsJ = new akl();
        aVar.fsK = new akm();
        if (z) {
            aVar.fsI = 2803;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetf2flottery";
        } else {
            aVar.fsI = 2508;
            aVar.uri = "/cgi-bin/mmpay-bin/mktgetlottery";
        }
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.ttX = (akl) this.gme.fsG.fsP;
        this.ttX.wqf = str;
        ab.i("MicroMsg.NetSceneMktGetLottery", "NetSceneMktGetLottery, getLotteryParams: %s, isF2f: %s", str, Boolean.valueOf(z));
        AppMethodBeat.o(46512);
    }

    public final int getType() {
        if (this.ttT) {
            return 2803;
        }
        return 2508;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46513);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(46513);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46514);
        ab.i("MicroMsg.NetSceneMktGetLottery", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ttY = (akm) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(46514);
    }
}

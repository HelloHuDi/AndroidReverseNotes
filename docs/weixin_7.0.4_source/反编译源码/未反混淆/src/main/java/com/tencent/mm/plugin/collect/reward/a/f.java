package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pq;
import com.tencent.mm.protocal.protobuf.pr;
import com.tencent.mm.sdk.platformtools.ab;

public final class f extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardScanCode";
    private b ehh;
    private com.tencent.mm.ai.f ehi;
    public pr kDz;

    public f(String str, int i, String str2) {
        AppMethodBeat.i(41045);
        a aVar = new a();
        aVar.fsJ = new pq();
        aVar.fsK = new pr();
        aVar.fsI = 1516;
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        pq pqVar = (pq) this.ehh.fsG.fsP;
        pqVar.kCn = str;
        pqVar.cIb = i;
        pqVar.vWN = str2;
        AppMethodBeat.o(41045);
    }

    public final int getType() {
        return 1516;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(41046);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41046);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41047);
        ab.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDz = (pr) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDz.kCl), this.kDz.kCm);
        if (!(this.kDr || this.kDz.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41047);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bgQ() {
        return false;
    }
}

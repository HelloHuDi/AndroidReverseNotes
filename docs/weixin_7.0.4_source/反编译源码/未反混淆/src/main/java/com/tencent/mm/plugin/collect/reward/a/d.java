package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.pm;
import com.tencent.mm.protocal.protobuf.pn;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    private b ehh;
    private f ehi;
    private pn kDx;

    public d(String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.i(41039);
        a aVar = new a();
        aVar.fsJ = new pm();
        aVar.fsK = new pn();
        aVar.fsI = 1960;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        pm pmVar = (pm) this.ehh.fsG.fsP;
        pmVar.cBT = str;
        pmVar.vWI = str2;
        pmVar.vFc = str3;
        pmVar.nUf = i;
        pmVar.vWG = str4;
        pmVar.vWF = str5;
        ab.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", str2, Integer.valueOf(i));
        AppMethodBeat.o(41039);
    }

    public final int getType() {
        return 1960;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(41040);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41040);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41041);
        ab.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDx = (pn) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDx.kCl), this.kDx.kCm);
        if (!(this.kDr || this.kDx.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41041);
    }
}

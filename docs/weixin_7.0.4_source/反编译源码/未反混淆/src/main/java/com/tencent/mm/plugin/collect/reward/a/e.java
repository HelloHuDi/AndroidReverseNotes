package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    private b ehh;
    private f ehi;
    public pp kDy;

    public e(int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8, int i4) {
        AppMethodBeat.i(41042);
        a aVar = new a();
        aVar.fsJ = new po();
        aVar.fsK = new pp();
        aVar.fsI = 1336;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        po poVar = (po) this.ehh.fsG.fsP;
        poVar.nUf = i;
        poVar.vWL = i2;
        poVar.vWJ = str;
        poVar.vWK = str2;
        poVar.pPT = str3;
        poVar.cIb = i3;
        poVar.vWM = str4;
        poVar.vWG = str5;
        poVar.vWN = str6;
        poVar.vWO = str7;
        poVar.vWP = str8;
        poVar.vWQ = i4;
        AppMethodBeat.o(41042);
    }

    public final int getType() {
        return 1336;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(41043);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41043);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41044);
        ab.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDy = (pp) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDy.kCl), this.kDy.kCm);
        if (!(this.kDr || this.kDy.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41044);
    }
}

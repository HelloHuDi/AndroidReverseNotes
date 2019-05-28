package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    private b ehh;
    private f ehi;
    public String jMS;
    public pt kDB;

    public h(String str) {
        AppMethodBeat.i(41051);
        a aVar = new a();
        aVar.fsJ = new ps();
        aVar.fsK = new pt();
        aVar.fsI = 1649;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ((ps) this.ehh.fsG.fsP).jMS = str;
        this.jMS = str;
        if (str.length() <= 0 || str.length() > 3) {
            if (str.length() > 3) {
                com.tencent.mm.plugin.report.service.h.pYm.a(724, 1, 1, false);
            }
            AppMethodBeat.o(41051);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(724, 0, 1, false);
        AppMethodBeat.o(41051);
    }

    public final int getType() {
        return 1649;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(41052);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41052);
        return a;
    }

    public final void b(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41053);
        ab.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDB = (pt) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDB.kCl), this.kDB.kCm);
        if (!(this.kDr || this.kDB.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.o(41053);
    }
}

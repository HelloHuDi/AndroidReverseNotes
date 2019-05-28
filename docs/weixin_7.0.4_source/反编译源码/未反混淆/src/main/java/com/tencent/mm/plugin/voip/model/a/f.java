package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.cpo;

public final class f extends n<cpn, cpo> {
    String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    public f(int i, long j, int i2) {
        AppMethodBeat.i(4714);
        a aVar = new a();
        aVar.fsJ = new cpn();
        aVar.fsK = new cpo();
        aVar.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        aVar.fsI = 178;
        aVar.fsL = 81;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        cpn cpn = (cpn) this.ehh.fsG.fsP;
        cpn.wem = i;
        cpn.wen = j;
        cpn.xlQ = System.currentTimeMillis();
        cpn.xmV = i2;
        AppMethodBeat.o(4714);
    }

    public final int getType() {
        return 178;
    }

    public final com.tencent.mm.ai.f cKt() {
        AppMethodBeat.i(4715);
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4713);
                if (i == 0 || i2 != 231) {
                    AppMethodBeat.o(4713);
                    return;
                }
                com.tencent.mm.plugin.voip.a.a.Loge(f.this.TAG, "Voip heartbeat Failed, type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                f.this.sPK.sPp.sVH.sQe = 111;
                f.this.sPK.sPp.sVH.sQf = i2;
                f.this.sPK.sPp.sVH.sQw = 2;
                f.this.sPK.v(1, -9004, "");
                AppMethodBeat.o(4713);
            }
        };
        AppMethodBeat.o(4715);
        return anonymousClass1;
    }
}

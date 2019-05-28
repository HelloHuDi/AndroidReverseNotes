package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.b;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.view.d;

public final class e extends n<cpl, cpm> {
    public e(int i, long j, String str) {
        AppMethodBeat.i(4710);
        a aVar = new a();
        aVar.fsJ = new cpl();
        aVar.fsK = new cpm();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        aVar.fsL = d.MIC_AVROUND_BLUR;
        aVar.fsM = 1000000119;
        this.ehh = aVar.acD();
        cpl cpl = (cpl) this.ehh.fsG.fsP;
        cpl.wem = i;
        cpl.wen = j;
        cpl.xmT = str;
        cpl.jCt = 1;
        cpl.xlQ = System.currentTimeMillis();
        AppMethodBeat.o(4710);
    }

    public final int getType() {
        return 303;
    }

    public final void fW(int i, int i2) {
        AppMethodBeat.i(4711);
        if (i == 0 && i2 == 0) {
            if (((cpm) cKx()) != null) {
                ab.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", Integer.valueOf(((cpm) cKx()).wem), Long.valueOf(((cpm) cKx()).wen), Integer.valueOf(((cpm) cKx()).ehB), Integer.valueOf(((cpm) cKx()).xmL));
            }
            AppMethodBeat.o(4711);
            return;
        }
        ab.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
        AppMethodBeat.o(4711);
    }

    public final f cKt() {
        AppMethodBeat.i(4712);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4709);
                com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                if (i == 0 && i2 == 0 && mVar != null) {
                    cpm cpm = (cpm) e.this.cKx();
                    if (cpm.BaseResponse.Ret == 0 && !b.cIj().sSP.cKg()) {
                        b.cIj().b(cpm);
                    }
                }
                AppMethodBeat.o(4709);
            }
        };
        AppMethodBeat.o(4712);
        return anonymousClass1;
    }
}

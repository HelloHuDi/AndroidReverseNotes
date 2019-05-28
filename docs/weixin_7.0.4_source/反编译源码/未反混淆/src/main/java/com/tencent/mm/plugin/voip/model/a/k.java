package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.protocal.protobuf.cqe;

public final class k extends n<cqd, cqe> {
    public k(ccx ccx) {
        AppMethodBeat.i(4730);
        a aVar = new a();
        aVar.fsJ = new cqd();
        aVar.fsK = new cqe();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        this.ehh = aVar.acD();
        cqd cqd = (cqd) this.ehh.fsG.fsP;
        cqd.wem = ccx.wem;
        cqd.xcr = ccx.xcr;
        cqd.vZF = ccx.vZF;
        cqd.xcs = ccx.xcs;
        cqd.xct = ccx.xct;
        cqd.xcu = ccx.xcu;
        cqd.xcv = ccx.xcv;
        cqd.xcw = ccx.xcw;
        cqd.xcx = ccx.xcx;
        cqd.xcy = ccx.xcy;
        cqd.xcz = ccx.xcz;
        cqd.xcA = ccx.xcA;
        cqd.xcB = ccx.xcB;
        AppMethodBeat.o(4730);
    }

    public final int getType() {
        return 765;
    }

    public final f cKt() {
        AppMethodBeat.i(4731);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4729);
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    cqe cqe = (cqe) k.this.cKx();
                    if (cqe.xoh == 0 || cqe.xoi == 0) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + cqe.xoi);
                        AppMethodBeat.o(4729);
                    } else if (k.this.sPK.sOU != 1) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + k.this.sPK.sOU);
                        AppMethodBeat.o(4729);
                    } else {
                        k.this.sPK.sOU = 2;
                        k.this.sPK.sOW = cqe.xod;
                        v2protocal v2protocal = k.this.sPK.sPp;
                        if (v2protocal.sVp != 0) {
                            com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                            AppMethodBeat.o(4729);
                            return;
                        }
                        v2protocal.sVp = cqe.xod;
                        v2protocal.field_SpeedTestSvrParaArray = com.tencent.mm.plugin.voip.a.a.a(cqe);
                        v2protocal.StartSpeedTest(cqe.xod, cqe.xoi);
                        AppMethodBeat.o(4729);
                    }
                } catch (Exception e) {
                    k.this.sPK.sOU = 0;
                    AppMethodBeat.o(4729);
                }
            }
        };
        AppMethodBeat.o(4731);
        return anonymousClass1;
    }
}

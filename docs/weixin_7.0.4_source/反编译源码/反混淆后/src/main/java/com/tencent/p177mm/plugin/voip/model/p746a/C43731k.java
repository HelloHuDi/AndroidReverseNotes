package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.ccx;
import com.tencent.p177mm.protocal.protobuf.cqd;
import com.tencent.p177mm.protocal.protobuf.cqe;

/* renamed from: com.tencent.mm.plugin.voip.model.a.k */
public final class C43731k extends C22456n<cqd, cqe> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.k$1 */
    class C294941 implements C1202f {
        C294941() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4729);
            C46317a.Logd("MicroMsg.NetSceneVoipSpeedTest", "onSceneEnd type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            try {
                cqe cqe = (cqe) C43731k.this.cKx();
                if (cqe.xoh == 0 || cqe.xoi == 0) {
                    C46317a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, svrCount = " + cqe.xoi);
                    AppMethodBeat.m2505o(4729);
                } else if (C43731k.this.sPK.sOU != 1) {
                    C46317a.Loge("MicroMsg.NetSceneVoipSpeedTest", "onVoipSpeedTestResp: no need to do speed test, for mSpeedTestStatus = " + C43731k.this.sPK.sOU);
                    AppMethodBeat.m2505o(4729);
                } else {
                    C43731k.this.sPK.sOU = 2;
                    C43731k.this.sPK.sOW = cqe.xod;
                    v2protocal v2protocal = C43731k.this.sPK.sPp;
                    if (v2protocal.sVp != 0) {
                        C46317a.Logi("MicroMsg.Voip", "v2protocal StartVoipSpeedTest fail: a speedtest is doing");
                        AppMethodBeat.m2505o(4729);
                        return;
                    }
                    v2protocal.sVp = cqe.xod;
                    v2protocal.field_SpeedTestSvrParaArray = C46317a.m86988a(cqe);
                    v2protocal.StartSpeedTest(cqe.xod, cqe.xoi);
                    AppMethodBeat.m2505o(4729);
                }
            } catch (Exception e) {
                C43731k.this.sPK.sOU = 0;
                AppMethodBeat.m2505o(4729);
            }
        }
    }

    public C43731k(ccx ccx) {
        AppMethodBeat.m2504i(4730);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cqd();
        c1196a.fsK = new cqe();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipspeedtest";
        this.ehh = c1196a.acD();
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
        AppMethodBeat.m2505o(4730);
    }

    public final int getType() {
        return 765;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4731);
        C294941 c294941 = new C294941();
        AppMethodBeat.m2505o(4731);
        return c294941;
    }
}

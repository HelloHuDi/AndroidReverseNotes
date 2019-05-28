package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.cqc;

public final class j extends n<cqb, cqc> {
    public j(long j, long j2, int i, String str, String str2, int i2, int i3, int[] iArr) {
        AppMethodBeat.i(4727);
        a aVar = new a();
        aVar.fsJ = new cqb();
        aVar.fsK = new cqc();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        this.ehh = aVar.acD();
        cqb cqb = (cqb) this.ehh.fsG.fsP;
        cqb.xod = j;
        cqb.wen = j2;
        cqb.vZF = i;
        cqb.xoe = new bts().alV(str);
        cqb.xof = new bts().alV(str2);
        cqb.vNH = 0.0d;
        cqb.vNI = 0.0d;
        cqb.wem = i2;
        cqb.xog = i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < i3) {
                ccw ccw = new ccw();
                i5 = i4 + 1;
                ccw.xce = iArr[i4];
                i4 = i5 + 1;
                ccw.xcf = iArr[i5];
                i5 = i4 + 1;
                ccw.xcg = iArr[i4];
                ccw.xch = new coj();
                int i7 = i5 + 1;
                ccw.xch.xfs = iArr[i5];
                i4 = i7 + 1;
                ccw.xch.wOO = iArr[i7];
                i5 = i4 + 1;
                ccw.xci = iArr[i4];
                i4 = i5 + 1;
                ccw.xcj = iArr[i5];
                i5 = i4 + 1;
                ccw.xck = iArr[i4];
                i4 = i5 + 1;
                ccw.xcl = iArr[i5];
                for (i5 = 0; i5 < ccw.xcl; i5++) {
                    if (i4 < iArr.length) {
                        i7 = i4 + 1;
                        ccw.xcm.add(Integer.valueOf(iArr[i4]));
                        i4 = i7;
                    }
                }
                if (i4 < iArr.length) {
                    i5 = i4 + 1;
                    ccw.xcn = iArr[i4];
                    i4 = i5;
                }
                for (i5 = 0; i5 < ccw.xcn; i5++) {
                    if (i4 < iArr.length) {
                        i7 = i4 + 1;
                        ccw.xco.add(Integer.valueOf(iArr[i4]));
                        i4 = i7;
                    }
                }
                if (i4 < iArr.length) {
                    i5 = i4 + 1;
                    ccw.xcp = iArr[i4];
                    i4 = i5;
                }
                for (i5 = 0; i5 < ccw.xcp; i5++) {
                    if (i4 < iArr.length) {
                        i7 = i4 + 1;
                        ccw.xcq.add(Integer.valueOf(iArr[i4]));
                        i4 = i7;
                    }
                }
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipSpeedResult", "SpeedResult: pkt_size[" + ccw.xcf + "], pkt_count[" + ccw.xcg + "], svr_ip[" + ccw.xch.xfs + "], avg_rtt[" + ccw.xci + "], min_rtt[" + ccw.xcj + "], max_rtt[" + ccw.xck + "], rtt_count[" + ccw.xcl + "], down_seq_count[" + ccw.xcn + "], up_seq_count[" + ccw.xcp + "]");
                cqb.wpo.add(ccw);
                i5 = i6 + 1;
            } else {
                AppMethodBeat.o(4727);
                return;
            }
        }
    }

    public final int getType() {
        return 901;
    }

    public final f cKt() {
        AppMethodBeat.i(4728);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4726);
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i + " errCode=" + i2 + " errMsg=" + str);
                j.this.sPK.cIF();
                AppMethodBeat.o(4726);
            }
        };
        AppMethodBeat.o(4728);
        return anonymousClass1;
    }
}

package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.ccw;
import com.tencent.p177mm.protocal.protobuf.coj;
import com.tencent.p177mm.protocal.protobuf.cqb;
import com.tencent.p177mm.protocal.protobuf.cqc;

/* renamed from: com.tencent.mm.plugin.voip.model.a.j */
public final class C46320j extends C22456n<cqb, cqc> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.j$1 */
    class C437301 implements C1202f {
        C437301() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4726);
            C46317a.Logi("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i + " errCode=" + i2 + " errMsg=" + str);
            C46320j.this.sPK.cIF();
            AppMethodBeat.m2505o(4726);
        }
    }

    public C46320j(long j, long j2, int i, String str, String str2, int i2, int i3, int[] iArr) {
        AppMethodBeat.m2504i(4727);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cqb();
        c1196a.fsK = new cqc();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        this.ehh = c1196a.acD();
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
                C46317a.Logi("MicroMsg.NetSceneVoipSpeedResult", "SpeedResult: pkt_size[" + ccw.xcf + "], pkt_count[" + ccw.xcg + "], svr_ip[" + ccw.xch.xfs + "], avg_rtt[" + ccw.xci + "], min_rtt[" + ccw.xcj + "], max_rtt[" + ccw.xck + "], rtt_count[" + ccw.xcl + "], down_seq_count[" + ccw.xcn + "], up_seq_count[" + ccw.xcp + "]");
                cqb.wpo.add(ccw);
                i5 = i6 + 1;
            } else {
                AppMethodBeat.m2505o(4727);
                return;
            }
        }
    }

    public final int getType() {
        return 901;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4728);
        C437301 c437301 = new C437301();
        AppMethodBeat.m2505o(4728);
        return c437301;
    }
}

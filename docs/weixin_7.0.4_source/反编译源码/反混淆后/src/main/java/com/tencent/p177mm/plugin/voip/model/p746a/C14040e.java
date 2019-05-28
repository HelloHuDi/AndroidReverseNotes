package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.cpl;
import com.tencent.p177mm.protocal.protobuf.cpm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.voip.model.a.e */
public final class C14040e extends C22456n<cpl, cpm> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.e$1 */
    class C140411 implements C1202f {
        C140411() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4709);
            C46317a.Loge("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            if (i == 0 && i2 == 0 && c1207m != null) {
                cpm cpm = (cpm) C14040e.this.cKx();
                if (cpm.BaseResponse.Ret == 0 && !C43727b.cIj().sSP.cKg()) {
                    C43727b.cIj().mo26349b(cpm);
                }
            }
            AppMethodBeat.m2505o(4709);
        }
    }

    public C14040e(int i, long j, String str) {
        AppMethodBeat.m2504i(4710);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpl();
        c1196a.fsK = new cpm();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        c1196a.fsL = C31128d.MIC_AVROUND_BLUR;
        c1196a.fsM = 1000000119;
        this.ehh = c1196a.acD();
        cpl cpl = (cpl) this.ehh.fsG.fsP;
        cpl.wem = i;
        cpl.wen = j;
        cpl.xmT = str;
        cpl.jCt = 1;
        cpl.xlQ = System.currentTimeMillis();
        AppMethodBeat.m2505o(4710);
    }

    public final int getType() {
        return 303;
    }

    /* renamed from: fW */
    public final void mo26283fW(int i, int i2) {
        AppMethodBeat.m2504i(4711);
        if (i == 0 && i2 == 0) {
            if (((cpm) cKx()) != null) {
                C4990ab.m7417i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", Integer.valueOf(((cpm) cKx()).wem), Long.valueOf(((cpm) cKx()).wen), Integer.valueOf(((cpm) cKx()).ehB), Integer.valueOf(((cpm) cKx()).xmL));
            }
            AppMethodBeat.m2505o(4711);
            return;
        }
        C4990ab.m7416i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
        AppMethodBeat.m2505o(4711);
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4712);
        C140411 c140411 = new C140411();
        AppMethodBeat.m2505o(4712);
        return c140411;
    }
}

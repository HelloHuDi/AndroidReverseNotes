package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.model.v2protocal;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cpj;
import com.tencent.p177mm.protocal.protobuf.cpk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip.model.a.d */
public final class C14038d extends C22456n<cpj, cpk> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.d$1 */
    class C140391 implements C1202f {
        C140391() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4705);
            C46317a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + C14038d.this.sPK.mStatus);
            if (i2 != 0) {
                C46317a.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(i2)));
                AppMethodBeat.m2505o(4705);
                return;
            }
            cpk cpk = (cpk) C14038d.this.cKx();
            C14038d.this.sPK.sPc = cpk.wIr;
            if (C14038d.this.sPK.sPc == 0) {
                AppMethodBeat.m2505o(4705);
                return;
            }
            if (C14038d.this.sPK.sPp.doubleLinkSwitch(cpk.xmS) == 0) {
                v2protocal v2protocal;
                if (1 == cpk.xmS) {
                    v2protocal = C14038d.this.sPK.sPp;
                    v2protocal.sUW++;
                } else if (2 == cpk.xmS) {
                    v2protocal = C14038d.this.sPK.sPp;
                    v2protocal.sUX++;
                }
            }
            C46317a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + cpk.wem + " member " + cpk.wPb + " key " + cpk.wen + "report flag " + cpk.wIr + "switch to link type " + cpk.xmS + "doubleLinkSwitchReportStatus " + C14038d.this.sPK.sPc + "mDoubleLinkSwitchSucToDirectCnt" + C14038d.this.sPK.sPp.sUW + "mDoubleLinkSwitchSucToRelayCnt" + C14038d.this.sPK.sPp.sUX);
            AppMethodBeat.m2505o(4705);
        }
    }

    public C14038d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        AppMethodBeat.m2504i(4706);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpj();
        c1196a.fsK = new cpk();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        this.ehh = c1196a.acD();
        cpj cpj = (cpj) this.ehh.fsG.fsP;
        cpj.wem = i;
        cpj.wen = j;
        cpj.wPb = i2;
        cpj.xmN = i3;
        cpj.xmO = i4;
        cpj.xmP = i5;
        cpj.xmQ = i6;
        cpj.xmR = 1;
        cpj.vJd = new SKBuiltinBuffer_t().setBuffer(bArr, 0, i7);
        AppMethodBeat.m2505o(4706);
    }

    public final int getType() {
        return 249;
    }

    /* renamed from: fW */
    public final void mo26283fW(int i, int i2) {
        AppMethodBeat.m2504i(4707);
        if (i == 0 && i2 == 0) {
            if (((cpk) cKx()) != null) {
                C4990ab.m7417i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(((cpk) cKx()).wem), Long.valueOf(((cpk) cKx()).wen), Integer.valueOf(((cpk) cKx()).wPb));
            }
            AppMethodBeat.m2505o(4707);
            return;
        }
        C4990ab.m7416i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
        AppMethodBeat.m2505o(4707);
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4708);
        C140391 c140391 = new C140391();
        AppMethodBeat.m2505o(4708);
        return c140391;
    }
}

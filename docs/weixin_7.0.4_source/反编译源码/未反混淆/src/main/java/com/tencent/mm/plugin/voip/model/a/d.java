package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpj;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends n<cpj, cpk> {
    public d(int i, long j, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        AppMethodBeat.i(4706);
        a aVar = new a();
        aVar.fsJ = new cpj();
        aVar.fsK = new cpk();
        aVar.uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
        this.ehh = aVar.acD();
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
        AppMethodBeat.o(4706);
    }

    public final int getType() {
        return 249;
    }

    public final void fW(int i, int i2) {
        AppMethodBeat.i(4707);
        if (i == 0 && i2 == 0) {
            if (((cpk) cKx()) != null) {
                ab.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(((cpk) cKx()).wem), Long.valueOf(((cpk) cKx()).wen), Integer.valueOf(((cpk) cKx()).wPb));
            }
            AppMethodBeat.o(4707);
            return;
        }
        ab.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
        AppMethodBeat.o(4707);
    }

    public final f cKt() {
        AppMethodBeat.i(4708);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4705);
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "double link switch response:" + i + " errCode:" + i2 + " status:" + d.this.sPK.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.DoubleLinkSwitch", " double link switch  response with error code:".concat(String.valueOf(i2)));
                    AppMethodBeat.o(4705);
                    return;
                }
                cpk cpk = (cpk) d.this.cKx();
                d.this.sPK.sPc = cpk.wIr;
                if (d.this.sPK.sPc == 0) {
                    AppMethodBeat.o(4705);
                    return;
                }
                if (d.this.sPK.sPp.doubleLinkSwitch(cpk.xmS) == 0) {
                    v2protocal v2protocal;
                    if (1 == cpk.xmS) {
                        v2protocal = d.this.sPK.sPp;
                        v2protocal.sUW++;
                    } else if (2 == cpk.xmS) {
                        v2protocal = d.this.sPK.sPp;
                        v2protocal.sUX++;
                    }
                }
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.DoubleLinkSwitch", "zhengxue[DOUBLELINK]room " + cpk.wem + " member " + cpk.wPb + " key " + cpk.wen + "report flag " + cpk.wIr + "switch to link type " + cpk.xmS + "doubleLinkSwitchReportStatus " + d.this.sPK.sPc + "mDoubleLinkSwitchSucToDirectCnt" + d.this.sPK.sPp.sUW + "mDoubleLinkSwitchSucToRelayCnt" + d.this.sPK.sPp.sUX);
                AppMethodBeat.o(4705);
            }
        };
        AppMethodBeat.o(4708);
        return anonymousClass1;
    }
}

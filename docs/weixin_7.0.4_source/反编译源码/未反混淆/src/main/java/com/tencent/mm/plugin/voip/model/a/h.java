package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.protocal.protobuf.cpw;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.sdk.platformtools.ab;

public final class h extends n<cpv, cpw> {
    public h(int i, long j, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        AppMethodBeat.i(4720);
        a aVar = new a();
        aVar.fsJ = new cpv();
        aVar.fsK = new cpw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        this.ehh = aVar.acD();
        cpv cpv = (cpv) this.ehh.fsG.fsP;
        cpv.wem = i;
        cpv.wen = j;
        cpv.wPb = i2;
        cpv.xnN = i3;
        cpv.xnO = i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            cpy cpy = new cpy();
            int i8 = i6 + 1;
            cpy.xnY = iArr[i6];
            i6 = i8 + 1;
            cpy.xnZ = iArr[i8];
            i8 = i6 + 1;
            cpy.xoa = iArr[i6];
            int i9 = i8 + 1;
            cpy.xob = iArr[i8];
            i6 = i9 + 1;
            cpy.xoc = iArr[i9];
            cpv.xnP.add(cpy);
        }
        if (this.sPK.sPp.sVH.sQF != 0) {
            i5 = (int) ((System.currentTimeMillis() - this.sPK.sPp.sVH.sQF) / 1000);
        }
        cpv.xnQ = i5;
        AppMethodBeat.o(4720);
    }

    public final int getType() {
        return 678;
    }

    public final void fW(int i, int i2) {
        AppMethodBeat.i(4721);
        if (i == 0 && i2 == 0) {
            if (((cpw) this.ehh.fsH.fsP) != null) {
                ab.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(((cpw) this.ehh.fsH.fsP).wem), Long.valueOf(((cpw) this.ehh.fsH.fsP).wen), Integer.valueOf(((cpw) this.ehh.fsH.fsP).wPb));
            }
            AppMethodBeat.o(4721);
            return;
        }
        ab.i("MicroMsg.Voip.Redirect", "Redirect error");
        AppMethodBeat.o(4721);
    }

    public final f cKt() {
        AppMethodBeat.i(4722);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4719);
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + h.this.sPK.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.Voip.Redirect", " redirect response with error code:".concat(String.valueOf(i2)));
                    AppMethodBeat.o(4719);
                    return;
                }
                cpw cpw = (cpw) h.this.cKx();
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.Voip.Redirect", "room " + cpw.wem + " member " + cpw.wPb + " key " + cpw.wen + " relay addr cnt " + cpw.xnR + " RedirectThreshold " + cpw.xnW + " RedirectDecision " + cpw.xnX);
                cok cok = new cok();
                cok cok2 = new cok();
                cok cok3 = new cok();
                cok.xlZ = cpw.xnR;
                cok.xma = cpw.xnS;
                cok2.xlZ = cpw.xnT;
                cok2.xma = cpw.xnU;
                cok3.xlZ = cpw.xnV;
                cok3.xma = cpw.xmC;
                h.this.sPK.sPp.a(cok, cok2, cok3, cpw.xnW, cpw.xnX);
                AppMethodBeat.o(4719);
            }
        };
        AppMethodBeat.o(4722);
        return anonymousClass1;
    }
}

package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.cpe;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class c extends n<cpd, cpe> {
    public c(int i, long j, String str, String str2, int i2) {
        AppMethodBeat.i(4702);
        a aVar = new a();
        aVar.fsJ = new cpd();
        aVar.fsK = new cpe();
        aVar.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_1;
        this.ehh = aVar.acD();
        cpd cpd = (cpd) this.ehh.fsG.fsP;
        cpd.wem = i;
        cpd.wen = j;
        cpd.ndF = str;
        cpd.wOQ = i2;
        cqf cqf = new cqf();
        bts bts = new bts();
        bts.alV(str2);
        cqf.xfu = bts;
        cpd.xmK = cqf;
        cpd.xlQ = System.currentTimeMillis();
        AppMethodBeat.o(4702);
    }

    public final int cKu() {
        AppMethodBeat.i(4703);
        cpd cpd = (cpd) cKy();
        if (cpd.wem == 0 && cpd.wOQ == 0) {
            AppMethodBeat.o(4703);
            return -1;
        }
        AppMethodBeat.o(4703);
        return 0;
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_1;
    }

    public final f cKt() {
        AppMethodBeat.i(4704);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4701);
                com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                AppMethodBeat.o(4701);
            }
        };
        AppMethodBeat.o(4704);
        return anonymousClass1;
    }
}

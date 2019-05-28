package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class i extends n<cpz, cqa> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i, long j, String str) {
        AppMethodBeat.i(4724);
        a aVar = new a();
        aVar.fsJ = new cpz();
        aVar.fsK = new cqa();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_3;
        aVar.fsL = 66;
        aVar.fsM = 1000000066;
        this.ehh = aVar.acD();
        cpz cpz = (cpz) this.ehh.fsG.fsP;
        cpz.wem = i;
        cpz.wen = j;
        cqf cqf = new cqf();
        bts bts = new bts();
        bts.alV(str);
        cqf.xfu = bts;
        cpz.xmK = cqf;
        cpz.xlQ = System.currentTimeMillis();
        AppMethodBeat.o(4724);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_3;
    }

    public final f cKt() {
        AppMethodBeat.i(4725);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(4723);
                com.tencent.mm.plugin.voip.a.a.Logd(i.this.TAG, "onSceneEnd type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                AppMethodBeat.o(4723);
            }
        };
        AppMethodBeat.o(4725);
        return anonymousClass1;
    }
}

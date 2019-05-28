package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class m extends n<cqj, cqk> {
    public m(int i, cpg cpg, byte[] bArr, long j, int i2) {
        AppMethodBeat.i(4736);
        a aVar = new a();
        aVar.fsJ = new cqj();
        aVar.fsK = new cqk();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_4;
        this.ehh = aVar.acD();
        cqj cqj = (cqj) this.ehh.fsG.fsP;
        cqj.wem = i;
        cqj.xoq = cpg;
        cqj.wen = j;
        cqj.wPm = r.Yz();
        cqj.vTN = i2;
        cqj.vTO = new SKBuiltinBuffer_t().setBuffer(bArr);
        cqj.xlQ = System.currentTimeMillis();
        ab.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + cqj.xlQ);
        AppMethodBeat.o(4736);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_4;
    }

    public final int cKv() {
        return ((cqj) this.ehh.fsG.fsP).vTN;
    }

    public final f cKt() {
        AppMethodBeat.i(4737);
        AnonymousClass1 anonymousClass1 = new f() {
            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(4735);
                com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    if (((cqk) m.this.cKx()).wem != m.this.sPK.sPp.nwu) {
                        com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                        AppMethodBeat.o(4735);
                        return;
                    }
                } catch (Exception e) {
                }
                if (i != 0) {
                    com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + mVar.getType() + " errType:" + i + " errCode:" + i2);
                    m.this.sPK.sPp.sVH.sQe = 11;
                    m.this.sPK.sPp.sVH.sQg = i2;
                    m.this.sPK.sPp.sVH.sQf = i2;
                    m.this.sPK.sPp.sVH.sQw = 3;
                    if (i == 1) {
                        m.this.sPK.sPp.sVH.sQq = 8;
                    } else {
                        m.this.sPK.sPp.sVH.sQq = 99;
                    }
                    m.this.sPK.v(1, -9004, "");
                    AppMethodBeat.o(4735);
                    return;
                }
                m.this.sPK.sPs.q(mVar);
                AppMethodBeat.o(4735);
            }
        };
        AppMethodBeat.o(4737);
        return anonymousClass1;
    }
}

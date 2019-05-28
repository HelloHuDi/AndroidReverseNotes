package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cpg;
import com.tencent.p177mm.protocal.protobuf.cqj;
import com.tencent.p177mm.protocal.protobuf.cqk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.voip.model.a.m */
public final class C24846m extends C22456n<cqj, cqk> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.m$1 */
    class C71711 implements C1202f {
        C71711() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4735);
            C46317a.Logi("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            try {
                if (((cqk) C24846m.this.cKx()).wem != C24846m.this.sPK.sPp.nwu) {
                    C46317a.Loge("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                    AppMethodBeat.m2505o(4735);
                    return;
                }
            } catch (Exception e) {
            }
            if (i != 0) {
                C46317a.Loge("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
                C24846m.this.sPK.sPp.sVH.sQe = 11;
                C24846m.this.sPK.sPp.sVH.sQg = i2;
                C24846m.this.sPK.sPp.sVH.sQf = i2;
                C24846m.this.sPK.sPp.sVH.sQw = 3;
                if (i == 1) {
                    C24846m.this.sPK.sPp.sVH.sQq = 8;
                } else {
                    C24846m.this.sPK.sPp.sVH.sQq = 99;
                }
                C24846m.this.sPK.mo26330v(1, -9004, "");
                AppMethodBeat.m2505o(4735);
                return;
            }
            C24846m.this.sPK.sPs.mo9308q(c1207m);
            AppMethodBeat.m2505o(4735);
        }
    }

    public C24846m(int i, cpg cpg, byte[] bArr, long j, int i2) {
        AppMethodBeat.m2504i(4736);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cqj();
        c1196a.fsK = new cqk();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipsync";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_4;
        this.ehh = c1196a.acD();
        cqj cqj = (cqj) this.ehh.fsG.fsP;
        cqj.wem = i;
        cqj.xoq = cpg;
        cqj.wen = j;
        cqj.wPm = C1853r.m3846Yz();
        cqj.vTN = i2;
        cqj.vTO = new SKBuiltinBuffer_t().setBuffer(bArr);
        cqj.xlQ = System.currentTimeMillis();
        C4990ab.m7416i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + cqj.xlQ);
        AppMethodBeat.m2505o(4736);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_4;
    }

    public final int cKv() {
        return ((cqj) this.ehh.fsG.fsP).vTN;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4737);
        C71711 c71711 = new C71711();
        AppMethodBeat.m2505o(4737);
        return c71711;
    }
}

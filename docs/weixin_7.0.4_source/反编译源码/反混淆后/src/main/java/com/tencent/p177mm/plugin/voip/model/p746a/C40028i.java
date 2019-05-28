package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cpz;
import com.tencent.p177mm.protocal.protobuf.cqa;
import com.tencent.p177mm.protocal.protobuf.cqf;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.voip.model.a.i */
public final class C40028i extends C22456n<cpz, cqa> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    /* renamed from: com.tencent.mm.plugin.voip.model.a.i$1 */
    class C400291 implements C1202f {
        C400291() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4723);
            C46317a.Logd(C40028i.this.TAG, "onSceneEnd type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            AppMethodBeat.m2505o(4723);
        }
    }

    public C40028i(int i, long j, String str) {
        AppMethodBeat.m2504i(4724);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpz();
        c1196a.fsK = new cqa();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_3;
        c1196a.fsL = 66;
        c1196a.fsM = 1000000066;
        this.ehh = c1196a.acD();
        cpz cpz = (cpz) this.ehh.fsG.fsP;
        cpz.wem = i;
        cpz.wen = j;
        cqf cqf = new cqf();
        bts bts = new bts();
        bts.alV(str);
        cqf.xfu = bts;
        cpz.xmK = cqf;
        cpz.xlQ = System.currentTimeMillis();
        AppMethodBeat.m2505o(4724);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_3;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4725);
        C400291 c400291 = new C400291();
        AppMethodBeat.m2505o(4725);
        return c400291;
    }
}

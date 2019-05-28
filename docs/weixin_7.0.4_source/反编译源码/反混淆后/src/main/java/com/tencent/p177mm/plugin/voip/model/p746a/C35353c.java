package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cpd;
import com.tencent.p177mm.protocal.protobuf.cpe;
import com.tencent.p177mm.protocal.protobuf.cqf;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.voip.model.a.c */
public final class C35353c extends C22456n<cpd, cpe> {

    /* renamed from: com.tencent.mm.plugin.voip.model.a.c$1 */
    class C294901 implements C1202f {
        C294901() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4701);
            C46317a.Logd("MicroMsg.NetSceneVoipCancelInvite", "onSceneEnd type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            AppMethodBeat.m2505o(4701);
        }
    }

    public C35353c(int i, long j, String str, String str2, int i2) {
        AppMethodBeat.m2504i(4702);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpd();
        c1196a.fsK = new cpe();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_1;
        this.ehh = c1196a.acD();
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
        AppMethodBeat.m2505o(4702);
    }

    public final int cKu() {
        AppMethodBeat.m2504i(4703);
        cpd cpd = (cpd) cKy();
        if (cpd.wem == 0 && cpd.wOQ == 0) {
            AppMethodBeat.m2505o(4703);
            return -1;
        }
        AppMethodBeat.m2505o(4703);
        return 0;
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_1;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4704);
        C294901 c294901 = new C294901();
        AppMethodBeat.m2505o(4704);
        return c294901;
    }
}

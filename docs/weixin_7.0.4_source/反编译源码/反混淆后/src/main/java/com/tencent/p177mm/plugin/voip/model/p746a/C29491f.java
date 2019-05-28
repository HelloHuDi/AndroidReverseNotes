package com.tencent.p177mm.plugin.voip.model.p746a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.voip.p1417a.C46317a;
import com.tencent.p177mm.protocal.protobuf.cpn;
import com.tencent.p177mm.protocal.protobuf.cpo;

/* renamed from: com.tencent.mm.plugin.voip.model.a.f */
public final class C29491f extends C22456n<cpn, cpo> {
    String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    /* renamed from: com.tencent.mm.plugin.voip.model.a.f$1 */
    class C294921 implements C1202f {
        C294921() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(4713);
            if (i == 0 || i2 != 231) {
                AppMethodBeat.m2505o(4713);
                return;
            }
            C46317a.Loge(C29491f.this.TAG, "Voip heartbeat Failed, type:" + c1207m.getType() + " errType:" + i + " errCode:" + i2);
            C29491f.this.sPK.sPp.sVH.sQe = 111;
            C29491f.this.sPK.sPp.sVH.sQf = i2;
            C29491f.this.sPK.sPp.sVH.sQw = 2;
            C29491f.this.sPK.mo26330v(1, -9004, "");
            AppMethodBeat.m2505o(4713);
        }
    }

    public C29491f(int i, long j, int i2) {
        AppMethodBeat.m2504i(4714);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpn();
        c1196a.fsK = new cpo();
        c1196a.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        c1196a.fsI = 178;
        c1196a.fsL = 81;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cpn cpn = (cpn) this.ehh.fsG.fsP;
        cpn.wem = i;
        cpn.wen = j;
        cpn.xlQ = System.currentTimeMillis();
        cpn.xmV = i2;
        AppMethodBeat.m2505o(4714);
    }

    public final int getType() {
        return 178;
    }

    public final C1202f cKt() {
        AppMethodBeat.m2504i(4715);
        C294921 c294921 = new C294921();
        AppMethodBeat.m2505o(4715);
        return c294921;
    }
}

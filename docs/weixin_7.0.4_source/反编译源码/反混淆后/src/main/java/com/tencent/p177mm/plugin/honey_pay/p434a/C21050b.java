package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15379rd;
import com.tencent.p177mm.protocal.protobuf.C46581rc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.b */
public final class C21050b extends C44428p {
    private final String TAG = "MicroMsg.NetSceneCheckHoneyUser";
    public C15379rd nqy;
    public String username;

    public C21050b(String str, int i) {
        AppMethodBeat.m2504i(41719);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46581rc();
        c1196a.fsK = new C15379rd();
        c1196a.fsI = 2926;
        c1196a.uri = "/cgi-bin/mmpay-bin/checkhoneyuser";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C46581rc c46581rc = (C46581rc) this.ehh.fsG.fsP;
        c46581rc.vYh = str;
        c46581rc.iAd = i;
        this.username = str;
        AppMethodBeat.m2505o(41719);
    }

    public final int getType() {
        return 2926;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41720);
        C4990ab.m7417i("MicroMsg.NetSceneCheckHoneyUser", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqy = (C15379rd) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneCheckHoneyUser", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqy.kdT), this.nqy.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41720);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C15379rd c15379rd = (C15379rd) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c15379rd.kdT;
        this.AfD = c15379rd.kdU;
    }
}

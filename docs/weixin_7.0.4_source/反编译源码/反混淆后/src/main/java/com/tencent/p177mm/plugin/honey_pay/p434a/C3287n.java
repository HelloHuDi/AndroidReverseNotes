package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cje;
import com.tencent.p177mm.protocal.protobuf.cjf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.n */
public final class C3287n extends C44428p {
    private final String TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    public cjf nqL;

    public C3287n(String str, String str2) {
        AppMethodBeat.m2504i(41743);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cje();
        c1196a.fsK = new cjf();
        c1196a.fsI = 2659;
        c1196a.uri = "/cgi-bin/mmpay-bin/unbindhpcard";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cje cje = (cje) this.ehh.fsG.fsP;
        cje.wpp = str;
        cje.wcg = str2;
        AppMethodBeat.m2505o(41743);
    }

    public final int getType() {
        return 2659;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41744);
        C4990ab.m7417i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqL = (cjf) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqL.kdT), this.nqL.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41744);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        cjf cjf = (cjf) ((C7472b) c1929q).fsH.fsP;
        this.AfC = cjf.kdT;
        this.AfD = cjf.kdU;
    }
}

package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.akn;
import com.tencent.p177mm.protocal.protobuf.ako;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.g */
public final class C39245g extends C44428p {
    private final String TAG = "MicroMsg.NetSceneMCreditLineTokenSign";
    public ako nqD;

    public C39245g(String str, long j) {
        AppMethodBeat.m2504i(41729);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new akn();
        c1196a.fsK = new ako();
        c1196a.fsI = 2815;
        c1196a.uri = "/cgi-bin/mmpay-bin/gmcreditlinetoken";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        akn akn = (akn) this.ehh.fsG.fsP;
        akn.wpp = str;
        akn.wch = j;
        C4990ab.m7417i("MicroMsg.NetSceneMCreditLineTokenSign", "card_no: %s, credit_line: %s", str, Long.valueOf(j));
        AppMethodBeat.m2505o(41729);
    }

    public final int getType() {
        return 2815;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41730);
        C4990ab.m7417i("MicroMsg.NetSceneMCreditLineTokenSign", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqD = (ako) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneMCreditLineTokenSign", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqD.kdT), this.nqD.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41730);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        ako ako = (ako) ((C7472b) c1929q).fsH.fsP;
        this.AfC = ako.kdT;
        this.AfD = ako.kdU;
    }
}

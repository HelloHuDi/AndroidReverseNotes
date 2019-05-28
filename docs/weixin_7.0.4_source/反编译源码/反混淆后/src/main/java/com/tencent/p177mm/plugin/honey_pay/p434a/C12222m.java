package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.protocal.protobuf.bnm;
import com.tencent.p177mm.protocal.protobuf.bnn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.m */
public final class C12222m extends C44428p {
    private final String TAG = "MicroMsg.NetSceneQryHoneyUserDetail";
    public bnn nqK;

    public C12222m(String str) {
        AppMethodBeat.m2504i(41741);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnm();
        c1196a.fsK = new bnn();
        c1196a.fsI = 2613;
        c1196a.uri = "/cgi-bin/mmpay-bin/qryhpusererdetail";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bnm) this.ehh.fsG.fsP).wpp = str;
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyUserDetail", "card no: %s", str);
        AppMethodBeat.m2505o(41741);
    }

    public final int getType() {
        return 2613;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41742);
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyUserDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqK = (bnn) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyUserDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqK.kdT), this.nqK.kdU);
        if (this.nqK.wpq != null) {
            C28289c.m44879U(this.nqK.wpq.cJF, this.nqK.wpq.vQO, this.nqK.wpq.ubv);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41742);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bnn bnn = (bnn) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bnn.kdT;
        this.AfD = bnn.kdU;
    }
}

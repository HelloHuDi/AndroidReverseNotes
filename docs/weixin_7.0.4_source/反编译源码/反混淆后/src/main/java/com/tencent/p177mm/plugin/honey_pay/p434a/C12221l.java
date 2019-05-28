package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.protocal.protobuf.bnk;
import com.tencent.p177mm.protocal.protobuf.bnl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.l */
public final class C12221l extends C44428p {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayerDetail";
    public bnl nqJ;

    public C12221l(String str) {
        AppMethodBeat.m2504i(41739);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnk();
        c1196a.fsK = new bnl();
        c1196a.fsI = 2876;
        c1196a.uri = "/cgi-bin/mmpay-bin/qryhppayerdetail";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bnk) this.ehh.fsG.fsP).wpp = str;
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyPayerDetail", "card no: %s", str);
        AppMethodBeat.m2505o(41739);
    }

    public final int getType() {
        return 2876;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41740);
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyPayerDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqJ = (bnl) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyPayerDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqJ.kdT), this.nqJ.kdU);
        if (this.nqJ.wpq != null) {
            C28289c.m44879U(this.nqJ.wpq.cJF, this.nqJ.wpq.vQO, this.nqJ.wpq.ubv);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41740);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bnl bnl = (bnl) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bnl.kdT;
        this.AfD = bnl.kdU;
    }
}

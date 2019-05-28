package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bcy;
import com.tencent.p177mm.protocal.protobuf.bcz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.i */
public final class C44746i extends C44428p {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerNotify";
    public int bJt;
    private bcz nqG;

    public C44746i(int i) {
        AppMethodBeat.m2504i(41733);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bcy();
        c1196a.fsK = new bcz();
        c1196a.fsI = 2742;
        c1196a.uri = "/cgi-bin/mmpay-bin/modifyhppayernotify";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bcy) this.ehh.fsG.fsP).tob = i;
        this.bJt = i;
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerNotify", "notify flag: %s", Integer.valueOf(i));
        AppMethodBeat.m2505o(41733);
    }

    public final int getType() {
        return 2742;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41734);
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerNotify", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqG = (bcz) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerNotify", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqG.kdT), this.nqG.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41734);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bcz bcz = (bcz) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bcz.kdT;
        this.AfD = bcz.kdU;
    }
}

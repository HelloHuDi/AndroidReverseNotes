package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bni;
import com.tencent.p177mm.protocal.protobuf.bnj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.k */
public final class C3286k extends C44428p {
    private final String TAG = "MicroMsg.NetSceneQryHoneyPayCardDetail";
    public bnj nqI;

    public C3286k(String str) {
        AppMethodBeat.m2504i(41737);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bni();
        c1196a.fsK = new bnj();
        c1196a.fsI = 2851;
        c1196a.uri = "/cgi-bin/mmpay-bin/qryhpcarddetail";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bni) this.ehh.fsG.fsP).wpp = str;
        AppMethodBeat.m2505o(41737);
    }

    public final int getType() {
        return 2851;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41738);
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyPayCardDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqI = (bnj) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQryHoneyPayCardDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqI.kdT), this.nqI.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41738);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bnj bnj = (bnj) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bnj.kdT;
        this.AfD = bnj.kdU;
    }
}

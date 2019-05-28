package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bcw;
import com.tencent.p177mm.protocal.protobuf.bcx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.h */
public final class C46021h extends C44428p {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerCreditLine";
    public bcx nqE;
    public long nqF;

    public C46021h(long j, String str, String str2) {
        AppMethodBeat.m2504i(41731);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bcw();
        c1196a.fsK = new bcx();
        c1196a.fsI = 2865;
        c1196a.uri = "/cgi-bin/mmpay-bin/modifyhppayercreditline";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bcw bcw = (bcw) this.ehh.fsG.fsP;
        bcw.wch = j;
        bcw.wcg = str;
        bcw.wpp = str2;
        this.nqF = j;
        C4990ab.m7411d("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "cardNo: %s, authToken: %s", str2, str);
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "credit line: %s", Long.valueOf(j));
        AppMethodBeat.m2505o(41731);
    }

    public final int getType() {
        return 2865;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41732);
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqE = (bcx) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerCreditLine", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqE.kdT), this.nqE.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41732);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bcx bcx = (bcx) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bcx.kdT;
        this.AfD = bcx.kdU;
    }
}

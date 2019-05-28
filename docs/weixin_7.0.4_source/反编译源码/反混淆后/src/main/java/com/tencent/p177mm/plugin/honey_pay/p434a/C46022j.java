package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bda;
import com.tencent.p177mm.protocal.protobuf.bdb;
import com.tencent.p177mm.protocal.protobuf.bkc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.j */
public final class C46022j extends C44428p {
    private final String TAG = "MicroMsg.NetSceneModifyHoneyPayerPayWay";
    public bdb nqH;

    public C46022j(bkc bkc, String str) {
        AppMethodBeat.m2504i(41735);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bda();
        c1196a.fsK = new bdb();
        c1196a.fsI = 2941;
        c1196a.uri = "/cgi-bin/mmpay-bin/modifyhppayerpayway";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bda bda = (bda) this.ehh.fsG.fsP;
        bda.wxt = bkc;
        bda.wpp = str;
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "cardNo: %s, suffix: %s, bankType: %s", str, bkc.wNl, bkc.pbn);
        AppMethodBeat.m2505o(41735);
    }

    public final int getType() {
        return 2941;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41736);
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqH = (bdb) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneModifyHoneyPayerPayWay", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqH.kdT), this.nqH.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41736);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bdb bdb = (bdb) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bdb.kdT;
        this.AfD = bdb.kdU;
    }
}

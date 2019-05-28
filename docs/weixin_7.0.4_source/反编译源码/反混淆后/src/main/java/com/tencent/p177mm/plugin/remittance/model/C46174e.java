package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.protocal.protobuf.C23431pw;
import com.tencent.p177mm.protocal.protobuf.C30215px;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.remittance.model.e */
public final class C46174e extends C44428p {
    private final String TAG = "MicroMsg.NetSceneBeforeTransfer";
    public C30215px pOI;

    public C46174e(String str) {
        AppMethodBeat.m2504i(44727);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23431pw();
        c1196a.fsK = new C30215px();
        c1196a.fsI = 2783;
        c1196a.uri = "/cgi-bin/mmpay-bin/beforetransfer";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23431pw c23431pw = (C23431pw) this.ehh.fsG.fsP;
        c23431pw.vFf = str;
        if (!C46512f.dlH()) {
            c23431pw.vWV = C46512f.dlI();
        }
        C4990ab.m7411d("MicroMsg.NetSceneBeforeTransfer", "rcver name: %s", str);
        AppMethodBeat.m2505o(44727);
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44728);
        C4990ab.m7417i("MicroMsg.NetSceneBeforeTransfer", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pOI = (C30215px) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBeforeTransfer", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOI.kCl), this.pOI.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44728);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C30215px c30215px = (C30215px) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c30215px.kCl;
        this.AfD = c30215px.kCm;
    }

    public final int getType() {
        return 2783;
    }
}

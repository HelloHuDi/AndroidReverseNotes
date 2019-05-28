package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23458wp;
import com.tencent.p177mm.protocal.protobuf.C7557wq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.e */
public final class C13020e extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteHistory";
    private C7472b ehh;
    private C1202f ehi;
    public String kBD;
    public C7557wq pLw;

    public C13020e(String str) {
        AppMethodBeat.m2504i(44452);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23458wp();
        c1196a.fsK = new C7557wq();
        c1196a.fsI = 1737;
        c1196a.uri = "/cgi-bin/mmpay-bin/deletehistoryrecord_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C23458wp) this.ehh.fsG.fsP).vPX = str;
        this.kBD = str;
        AppMethodBeat.m2505o(44452);
    }

    public final int getType() {
        return 1737;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44453);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44453);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44454);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitDeleteHistory", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLw = (C7557wq) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitDeleteHistory", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLw.kCl), this.pLw.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44454);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C7557wq c7557wq = (C7557wq) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c7557wq.kCl;
        this.AfD = c7557wq.kCm;
    }
}

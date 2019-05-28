package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bcu;
import com.tencent.p177mm.protocal.protobuf.bcv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.j */
public final class C39585j extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitModifyExplain";
    private C7472b ehh;
    private C1202f ehi;
    public String hHV;
    public bcv pLB;
    public String pLt;

    public C39585j(String str, String str2) {
        AppMethodBeat.m2504i(44467);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bcu();
        c1196a.fsK = new bcv();
        c1196a.fsI = 1590;
        c1196a.uri = "/cgi-bin/mmpay-bin/modifyexplain_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bcu bcu = (bcu) this.ehh.fsG.fsP;
        bcu.pMd = str;
        bcu.pMg = str2;
        this.pLt = str;
        this.hHV = str2;
        AppMethodBeat.m2505o(44467);
    }

    public final int getType() {
        return 1590;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44468);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44468);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44469);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitModifyExplain", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLB = (bcv) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitModifyExplain", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLB.kCl), this.pLB.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44469);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bcv bcv = (bcv) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bcv.kCl;
        this.AfD = bcv.kCm;
    }
}

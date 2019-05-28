package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bnz;
import com.tencent.p177mm.protocal.protobuf.boa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.i */
public final class C46916i extends C46169b {
    private C7472b ehh;
    private C1202f ehi;
    public int limit;
    public boa pLA;

    public C46916i(int i, int i2) {
        AppMethodBeat.m2504i(44464);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnz();
        c1196a.fsK = new boa();
        c1196a.uri = "/cgi-bin/mmpay-bin/historylist_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bnz bnz = (bnz) this.ehh.fsG.fsP;
        bnz.limit = i;
        bnz.offset = i2;
        this.limit = i;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitHistoryList", "limit: %s, offset: %s", Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(44464);
    }

    public final int getType() {
        return 1511;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44465);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44465);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44466);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitHistoryList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLA = (boa) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitHistoryList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLA.kCl), this.pLA.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44466);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        boa boa = (boa) ((C7472b) c1929q).fsH.fsP;
        this.AfC = boa.kCl;
        this.AfD = boa.kCm;
    }
}

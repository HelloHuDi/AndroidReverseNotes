package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bnv;
import com.tencent.p177mm.protocal.protobuf.bnw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.l */
public final class C3714l extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitQueryDetail";
    private C7472b ehh;
    private C1202f ehi;
    public bnw pLD;

    public C3714l(String str) {
        AppMethodBeat.m2504i(44473);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bnv();
        c1196a.fsK = new bnw();
        c1196a.fsI = 1579;
        c1196a.uri = "/cgi-bin/mmpay-bin/querydetail_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bnv) this.ehh.fsG.fsP).vPX = str;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitQueryDetail", "bill id: %s", str);
        AppMethodBeat.m2505o(44473);
    }

    public final int getType() {
        return 1579;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44474);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44474);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44475);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitQueryDetail", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLD = (bnw) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44475);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bnw bnw = (bnw) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bnw.kCl;
        this.AfD = bnw.kCm;
    }
}

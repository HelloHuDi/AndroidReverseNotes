package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35965wt;
import com.tencent.p177mm.protocal.protobuf.C35966wu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.f */
public final class C13021f extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitDeleteRecord";
    private C7472b ehh;
    private C1202f ehi;
    public String pLt;
    public C35966wu pLx;

    public C13021f(String str) {
        AppMethodBeat.m2504i(44455);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35965wt();
        c1196a.fsK = new C35966wu();
        c1196a.fsI = 1395;
        c1196a.uri = "/cgi-bin/mmpay-bin/deleterecord_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C35965wt) this.ehh.fsG.fsP).pMd = str;
        this.pLt = str;
        AppMethodBeat.m2505o(44455);
    }

    public final int getType() {
        return 1395;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44456);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44456);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44457);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitDeleteRecord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLx = (C35966wu) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitDeleteRecord", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLx.kCl), this.pLx.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44457);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C35966wu c35966wu = (C35966wu) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c35966wu.kCl;
        this.AfD = c35966wu.kCm;
    }
}

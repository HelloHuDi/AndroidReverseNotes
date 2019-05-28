package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.afb;
import com.tencent.p177mm.protocal.protobuf.afc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.h */
public final class C34804h extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitGetBankList";
    private C7472b ehh;
    private C1202f ehi;
    public afc pLz;

    public C34804h() {
        AppMethodBeat.m2504i(44461);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afb();
        c1196a.fsK = new afc();
        c1196a.fsI = 1399;
        c1196a.uri = "/cgi-bin/mmpay-bin/getbanklist_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(44461);
    }

    public final int getType() {
        return 1399;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44462);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44462);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44463);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitGetBankList", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLz = (afc) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitGetBankList", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLz.kCl), this.pLz.kCm);
        if (!(this.kDr || this.pLz.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44463);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        afc afc = (afc) ((C7472b) c1929q).fsH.fsP;
        this.AfC = afc.kCl;
        this.AfD = afc.kCm;
    }
}

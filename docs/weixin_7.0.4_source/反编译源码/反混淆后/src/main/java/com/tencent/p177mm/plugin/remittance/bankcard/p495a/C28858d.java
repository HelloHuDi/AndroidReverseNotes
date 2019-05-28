package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15375qj;
import com.tencent.p177mm.protocal.protobuf.C30217qi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.d */
public final class C28858d extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitCheckBankBind";
    private C7472b ehh;
    private C1202f ehi;
    public C15375qj pLv;

    public C28858d(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(44449);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30217qi();
        c1196a.fsK = new C15375qj();
        c1196a.fsI = 1349;
        c1196a.uri = "/cgi-bin/mmpay-bin/checkbankbind_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C30217qi c30217qi = (C30217qi) this.ehh.fsG.fsP;
        c30217qi.vXt = str;
        c30217qi.vXu = str2;
        c30217qi.nuL = str3;
        c30217qi.pbn = str4;
        AppMethodBeat.m2505o(44449);
    }

    public final int getType() {
        return 1349;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44450);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44450);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44451);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitCheckBankBind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLv = (C15375qj) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitCheckBankBind", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLv.kCl), this.pLv.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44451);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C15375qj c15375qj = (C15375qj) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c15375qj.kCl;
        this.AfD = c15375qj.kCm;
    }
}

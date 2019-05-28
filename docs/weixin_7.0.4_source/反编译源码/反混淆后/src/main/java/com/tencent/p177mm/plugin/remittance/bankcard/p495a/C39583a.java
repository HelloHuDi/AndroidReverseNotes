package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40520fk;
import com.tencent.p177mm.protocal.protobuf.C46542fl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.a */
public final class C39583a extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitAppointBank";
    private C7472b ehh;
    private C1202f ehi;
    public C46542fl pLs;
    public String pLt;

    public C39583a(String str, String str2, String str3) {
        AppMethodBeat.m2504i(44443);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40520fk();
        c1196a.fsK = new C46542fl();
        c1196a.fsI = 1348;
        c1196a.uri = "/cgi-bin/mmpay-bin/appointbank_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C40520fk c40520fk = (C40520fk) this.ehh.fsG.fsP;
        c40520fk.pMd = str;
        c40520fk.vHs = str2;
        c40520fk.pbn = str3;
        this.pLt = str;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitAppointBank", "seqno: %s, timing_id: %s, bankType: %s", str, str2, str3);
        AppMethodBeat.m2505o(44443);
    }

    public final int getType() {
        return 1348;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44444);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44444);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44445);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitAppointBank", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLs = (C46542fl) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitAppointBank", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLs.kCl), this.pLs.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44445);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C46542fl c46542fl = (C46542fl) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c46542fl.kCl;
        this.AfD = c46542fl.kCm;
    }
}

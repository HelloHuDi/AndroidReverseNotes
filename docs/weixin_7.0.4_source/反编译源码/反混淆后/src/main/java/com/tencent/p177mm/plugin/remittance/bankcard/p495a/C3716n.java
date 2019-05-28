package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.bsd;
import com.tencent.p177mm.protocal.protobuf.bse;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.n */
public final class C3716n extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitReportPayRes";
    private C7472b ehh;
    private C1202f ehi;
    private bse pLF;

    public C3716n(String str, String str2, int i) {
        AppMethodBeat.m2504i(44479);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitReportPayRes", "NetSceneBankRemitReportPayRes() transfer_bill_id:%s unique_id:%s unpay_type:%s", str, str2, Integer.valueOf(i));
        C1196a c1196a = new C1196a();
        bsd bsd = new bsd();
        bsd.wUg = new C1332b(String.valueOf(str).getBytes());
        bsd.wKQ = str2;
        bsd.vPy = i;
        c1196a.fsJ = bsd;
        c1196a.fsK = new bse();
        c1196a.uri = "/cgi-bin/mmpay-bin/reportpayres_tsbc";
        c1196a.fsI = 2739;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(44479);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44480);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44480);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44481);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitReportPayRes", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLF = (bse) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44481);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bse bse = (bse) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bse.kCl;
        this.AfD = bse.kCm;
    }

    public final int getType() {
        return 2739;
    }
}

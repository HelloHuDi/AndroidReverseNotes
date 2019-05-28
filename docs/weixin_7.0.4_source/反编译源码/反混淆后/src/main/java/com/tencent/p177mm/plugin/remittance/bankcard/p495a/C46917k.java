package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bhn;
import com.tencent.p177mm.protocal.protobuf.bho;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.ttpic.util.ActUtil;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.k */
public final class C46917k extends C46169b {
    private C7472b ehh;
    private C1202f ehi;
    public bho pLC;

    public C46917k() {
        AppMethodBeat.m2504i(44470);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bhn();
        c1196a.fsK = new bho();
        c1196a.fsI = ActUtil.HEIGHT;
        c1196a.uri = "/cgi-bin/mmpay-bin/operation_tsbc";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(44470);
    }

    public final int getType() {
        return ActUtil.HEIGHT;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44471);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44471);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44472);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitOperation", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLC = (bho) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitOperation", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLC.kCl), this.pLC.kCm);
        if (!(this.kDr || this.kDs)) {
            C4990ab.m7417i("MicroMsg.NetSceneBankRemitOperation", "min_poundage: %s, max_amount: %s", Integer.valueOf(this.pLC.wKN), Integer.valueOf(this.pLC.wKO));
            if (this.pLC.wKN >= 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANK_REMIT_MIN_POUNDAGE_INT_SYNC, Integer.valueOf(this.pLC.wKN));
            }
            if (this.pLC.wKO > 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANK_REMIT_MAX_TRANSFER_AMOUNT_INT_SYNC, Integer.valueOf(this.pLC.wKO));
            }
            if (!C5046bo.isNullOrNil(this.pLC.wKP)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_BANK_REMIT_PAYLIST_STRING_SYNC, this.pLC.wKP);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44472);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bho bho = (bho) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bho.kCl;
        this.AfD = bho.kCm;
    }
}

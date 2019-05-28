package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.bss;
import com.tencent.p177mm.protocal.protobuf.bst;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44426i;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.o */
public final class C13022o extends C46169b implements C44426i {
    private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    private C7472b ehh;
    private C1202f ehi;
    public bst pLG;

    public C13022o(String str, String str2, String str3, int i, int i2, String str4, int i3, int i4, String str5, String str6, C1332b c1332b, int i5) {
        AppMethodBeat.m2504i(44482);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", C5046bo.nullAsNil(str6), Base64.encodeToString(c1332b.toByteArray(), 2), Integer.valueOf(i5));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bss();
        c1196a.fsK = new bst();
        c1196a.fsI = 1380;
        c1196a.uri = "/cgi-bin/mmpay-bin/request_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bss bss = (bss) this.ehh.fsG.fsP;
        bss.pMd = str;
        bss.pMe = str2;
        bss.pbn = str3;
        bss.pLQ = i;
        bss.wUL = i2;
        bss.wUM = str4;
        bss.wUN = i3;
        bss.wUO = i4;
        bss.vHu = str5;
        bss.wKQ = str6;
        bss.wUP = c1332b;
        bss.vPy = i5;
        AppMethodBeat.m2505o(44482);
    }

    public final int getType() {
        return 1380;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44483);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44483);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44484);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLG = (bst) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLG.kCl), this.pLG.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44484);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bst bst = (bst) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bst.kCl;
        this.AfD = bst.kCm;
    }

    public final boolean bgR() {
        if (this.pLG.wUQ == null || this.pLG.wUQ.bJt != 1) {
            return true;
        }
        return false;
    }
}

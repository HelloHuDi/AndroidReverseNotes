package com.tencent.p177mm.plugin.wallet_ecard.p1315a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bne;
import com.tencent.p177mm.protocal.protobuf.bnf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.a.f */
public final class C40149f extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public bnf tQn;

    public C40149f(String str, int i) {
        AppMethodBeat.m2504i(48065);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bne();
        c1196a.fsK = new bnf();
        c1196a.uri = "/cgi-bin/mmpay-bin/qryecardbanklist4bind";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bne bne = (bne) this.ehh.fsG.fsP;
        bne.vKZ = str;
        bne.cHF = i;
        C4990ab.m7417i("MicroMsg.NetSceneQryBankList4Bind", "cardType: %s, openScene: %s", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(48065);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(48066);
        C4990ab.m7417i("MicroMsg.NetSceneQryBankList4Bind", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tQn = (bnf) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQryBankList4Bind", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tQn.kdT), this.tQn.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(48066);
    }

    public final int getType() {
        return 1988;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(48067);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(48067);
        return a;
    }
}

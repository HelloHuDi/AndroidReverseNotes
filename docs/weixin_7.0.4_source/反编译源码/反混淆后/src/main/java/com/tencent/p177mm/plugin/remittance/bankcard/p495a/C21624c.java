package com.tencent.p177mm.plugin.remittance.bankcard.p495a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C7547md;
import com.tencent.p177mm.protocal.protobuf.C7548me;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.a.c */
public final class C21624c extends C46169b {
    private final String TAG = "MicroMsg.NetSceneBankRemitBusinessCallback";
    private C7472b ehh;
    private C1202f ehi;
    public C7548me pLu;

    public C21624c(String str, String str2) {
        AppMethodBeat.m2504i(44446);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7547md();
        c1196a.fsK = new C7548me();
        c1196a.fsI = 1340;
        c1196a.uri = "/cgi-bin/mmpay-bin/busscb_tsbc";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C7547md c7547md = (C7547md) this.ehh.fsG.fsP;
        c7547md.vPX = str;
        c7547md.pQe = str2;
        AppMethodBeat.m2505o(44446);
    }

    public final int getType() {
        return 1340;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44447);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44447);
        return a;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(44448);
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitBusinessCallback", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.pLu = (C7548me) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBankRemitBusinessCallback", "retcode: %s, retmsg: %s", Integer.valueOf(this.pLu.kCl), this.pLu.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(44448);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C7548me c7548me = (C7548me) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c7548me.kCl;
        this.AfD = c7548me.kCm;
    }
}

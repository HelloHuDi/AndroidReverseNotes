package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23416lz;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.protocal.protobuf.C46562ly;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.k */
public final class C43456k extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public C23416lz pOX;

    public C43456k(C46532cz c46532cz, String str) {
        AppMethodBeat.m2504i(44744);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46562ly();
        c1196a.fsK = new C23416lz();
        c1196a.uri = "/cgi-bin/mmpay-bin/busif2funlockfavor";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        C46562ly c46562ly = (C46562ly) this.gme.fsG.fsP;
        c46562ly.vPn = c46532cz;
        c46562ly.vPD = str;
        C7060h.pYm.mo15419k(886, 0, 1);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fUnlockFavor", "NetSceneBusiF2fUnlockFavor, f2fId: %s, transId: %s, amount: %s", c46532cz.vFb, c46532cz.vFc, Integer.valueOf(c46532cz.vFg));
        AppMethodBeat.m2505o(44744);
    }

    public final int getType() {
        return 2702;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44745);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44745);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44746);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fUnlockFavor", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOX = (C23416lz) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fUnlockFavor", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOX.kdT), this.pOX.kdU);
        C7060h.pYm.mo15419k(886, 1, 1);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44746);
    }
}

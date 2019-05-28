package com.tencent.p177mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23414ls;
import com.tencent.p177mm.protocal.protobuf.C23415lt;
import com.tencent.p177mm.protocal.protobuf.C46532cz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.remittance.model.h */
public final class C21645h extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    public C23415lt pOS;

    public C21645h(C46532cz c46532cz, String str) {
        AppMethodBeat.m2504i(44735);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23414ls();
        c1196a.fsK = new C23415lt();
        c1196a.uri = "/cgi-bin/mmpay-bin/busif2fpaycheck";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        C23414ls c23414ls = (C23414ls) this.gme.fsG.fsP;
        c23414ls.vPn = c46532cz;
        c23414ls.vPo = str;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPayCheck", "NetSceneBusiF2fPayCheck, f2fId: %s, transId: %s, amount: %s req: %s", c46532cz.vFb, c46532cz.vFc, Integer.valueOf(c46532cz.vFg), C28868a.m45886a(c46532cz));
        AppMethodBeat.m2505o(44735);
    }

    public final int getType() {
        return 1241;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44736);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(44736);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44737);
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pOS = (C23415lt) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneBusiF2fPayCheck", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.pOS.kdT), this.pOS.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(44737);
    }
}

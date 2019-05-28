package com.tencent.p177mm.plugin.websearch.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cvg;
import com.tencent.p177mm.protocal.protobuf.cvh;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.websearch.api.u */
public final class C46404u extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    cvg tZR = new cvg();
    cvh tZS;

    public C46404u(int i) {
        AppMethodBeat.m2504i(124066);
        C1196a c1196a = new C1196a();
        c1196a.fsI = 1948;
        c1196a.uri = "/cgi-bin/mmsearch-bin/websearchconfig";
        c1196a.fsJ = new cvg();
        c1196a.fsK = new cvh();
        this.fAT = c1196a.acD();
        this.tZR = (cvg) this.fAT.fsG.fsP;
        this.tZR.wDH = C46400aa.m87305HV(0);
        this.tZR.luQ = C4988aa.m7403gw(C4996ah.getContext());
        this.tZR.vKt = C46400aa.bVP();
        this.tZR.wDI = C46400aa.abJ();
        this.tZR.Scene = i;
        this.tZR.vQd = 0;
        AppMethodBeat.m2505o(124066);
    }

    public final int getType() {
        return 1948;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124067);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(124067);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124068);
        C4990ab.m7417i("MicroMsg.WebSearch.NetSceneWebSearchConfig", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.tZS = (cvh) this.fAT.fsH.fsP;
            if (this.tZS != null) {
                C4990ab.m7419v("MicroMsg.WebSearch.NetSceneWebSearchConfig", "return data\n%s", this.tZS.vOy);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(124068);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(124068);
    }
}

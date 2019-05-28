package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.ant;
import com.tencent.p177mm.protocal.protobuf.anu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelsimple.o */
public final class C37948o extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b fmP;

    public C37948o() {
        AppMethodBeat.m2504i(16594);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ant();
        c1196a.fsK = new anu();
        c1196a.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        this.fmP = c1196a.acD();
        ((ant) this.fmP.fsG.fsP).jCt = 0;
        C4990ab.m7417i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", Integer.valueOf(0), C5046bo.dpG());
        AppMethodBeat.m2505o(16594);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16595);
        C4990ab.m7417i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            C7060h.pYm.mo8378a(405, 2, 1, true);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16595);
    }

    public final int getType() {
        return 725;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16596);
        this.ehi = c1202f;
        C7060h.pYm.mo8378a(405, 1, 1, true);
        int a = mo4457a(c1902e, this.fmP, this);
        AppMethodBeat.m2505o(16596);
        return a;
    }
}

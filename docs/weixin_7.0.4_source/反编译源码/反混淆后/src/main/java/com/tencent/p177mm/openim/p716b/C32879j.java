package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.alq;
import com.tencent.p177mm.protocal.protobuf.alr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.openim.b.j */
public final class C32879j extends C1207m implements C1918k {
    public String cHN;
    private final C7472b ehh;
    private C1202f ehi;

    public C32879j(String str) {
        AppMethodBeat.m2504i(78862);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new alq();
        c1196a.fsK = new alr();
        c1196a.uri = "/cgi-bin/micromsg-bin/getopenurl";
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneGetOpenIMUrl", "NetSceneGetOpenIMUrl username: %s", str);
        ((alq) this.ehh.fsG.fsP).userName = str;
        AppMethodBeat.m2505o(78862);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78863);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78863);
        return a;
    }

    public final int getType() {
        return 913;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78864);
        C4990ab.m7417i("MicroMsg.NetSceneGetOpenIMUrl", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.cHN = ((alr) this.ehh.fsH.fsP).cHN;
            C4990ab.m7417i("MicroMsg.NetSceneGetOpenIMUrl", "openUrl %s", this.cHN);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78864);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78864);
    }
}

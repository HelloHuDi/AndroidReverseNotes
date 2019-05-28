package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.crz;
import com.tencent.p177mm.protocal.protobuf.csa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.j */
public final class C12252j extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public crz nyy = null;
    public csa nyz = null;

    public C12252j(String str) {
        AppMethodBeat.m2504i(21863);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new crz();
        c1196a.fsK = new csa();
        c1196a.fsI = 277;
        c1196a.uri = "/cgi-bin/micromsg-bin/wcopurchasepackage";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyy = (crz) this.ehh.fsG.fsP;
        this.nyy.ProductID = str;
        C4990ab.m7417i("MicroMsg.NetSceneIPCallPurchasePackage", "NetSceneIPCallPurchasePackage ProductID:%s", this.nyy.ProductID);
        AppMethodBeat.m2505o(21863);
    }

    public final int getType() {
        return 277;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21864);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21864);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21865);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallPurchasePackage", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyz = (csa) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21865);
    }
}

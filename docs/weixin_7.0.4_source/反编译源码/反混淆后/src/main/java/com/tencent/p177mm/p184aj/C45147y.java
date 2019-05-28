package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44137km;
import com.tencent.p177mm.protocal.protobuf.bxp;
import com.tencent.p177mm.protocal.protobuf.bxq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.y */
public final class C45147y extends C1207m implements C1918k {
    Object data;
    public C7472b ehh;
    private C1202f ehi;

    public C45147y(C44137km c44137km, Object obj) {
        AppMethodBeat.m2504i(11461);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxp();
        c1196a.fsK = new bxq();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        this.ehh = c1196a.acD();
        bxp bxp = (bxp) this.ehh.fsG.fsP;
        bxp.wmX = c44137km;
        bxp.mask = 1;
        bxp.wmV = 1;
        this.data = obj;
        AppMethodBeat.m2505o(11461);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11462);
        C4990ab.m7411d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11462);
    }

    public final int getType() {
        return 1228;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11463);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11463);
        return a;
    }
}

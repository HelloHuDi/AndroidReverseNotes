package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bop;
import com.tencent.p177mm.protocal.protobuf.boq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.u */
public final class C41741u extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C41741u(String str, String str2) {
        AppMethodBeat.m2504i(11633);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bop();
        c1196a.fsK = new boq();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        this.ehh = c1196a.acD();
        bop bop = (bop) this.ehh.fsG.fsP;
        bop.vNb = str;
        bop.vMV = str2;
        AppMethodBeat.m2505o(11633);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11634);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11634);
    }

    public final int getType() {
        return 1358;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11635);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11635);
        return a;
    }
}

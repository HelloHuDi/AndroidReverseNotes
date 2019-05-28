package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ahx;
import com.tencent.p177mm.protocal.protobuf.ahy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelsimple.j */
public final class C32825j extends C1207m implements C1918k {
    public String country;
    public String duc;
    public String dud;
    private C7472b ehh;
    private C1202f ehi;

    public C32825j(double d, double d2) {
        AppMethodBeat.m2504i(16575);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahx();
        c1196a.fsK = new ahy();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcurlocation";
        this.ehh = c1196a.acD();
        ahx ahx = (ahx) this.ehh.fsG.fsP;
        ahx.vNI = d;
        ahx.vNH = d2;
        C4990ab.m7410d("MicroMsg.NetSceneGetCurLocation", "latitude:" + d + ", longitude:" + d2);
        AppMethodBeat.m2505o(16575);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16576);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16576);
        return a;
    }

    public final int getType() {
        return 665;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16577);
        C4990ab.m7410d("MicroMsg.NetSceneGetCurLocation", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ahy ahy = (ahy) this.ehh.fsH.fsP;
            this.dud = ahy.guP;
            this.country = ahy.guW;
            this.duc = ahy.guO;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16577);
    }
}

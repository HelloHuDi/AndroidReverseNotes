package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.brx;
import com.tencent.p177mm.protocal.protobuf.bry;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.u */
public final class C11293u extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C11293u(float f, float f2, String str, String str2, int i) {
        AppMethodBeat.m2504i(87876);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new brx();
        c1196a.fsK = new bry();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
        this.ehh = c1196a.acD();
        brx brx = (brx) this.ehh.fsG.fsP;
        brx.latitude = (double) f;
        brx.longitude = (double) f2;
        brx.cMC = str;
        brx.kbU = str2;
        brx.wTZ = i;
        AppMethodBeat.m2505o(87876);
    }

    public final int getType() {
        return 1253;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87877);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87877);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87878);
        C4990ab.m7416i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87878);
    }
}

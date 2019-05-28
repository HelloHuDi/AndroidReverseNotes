package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C40512dl;
import com.tencent.p177mm.protocal.protobuf.C46533dm;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.model.app.y */
public final class C44061y extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    int vco;
    C40442x vcp;

    public C44061y(int i, C40442x c40442x) {
        AppMethodBeat.m2504i(79366);
        this.vco = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40512dl();
        c1196a.fsK = new C46533dm();
        c1196a.uri = "/cgi-bin/micromsg-bin/appcenter";
        this.ehh = c1196a.acD();
        C40512dl c40512dl = (C40512dl) this.ehh.fsG.fsP;
        byte[] dhj = c40442x.dhj();
        if (dhj != null) {
            c40512dl.ReqBuf = new SKBuiltinBuffer_t().setBuffer(dhj);
        }
        c40512dl.jCt = i;
        this.vcp = c40442x;
        AppMethodBeat.m2505o(79366);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79367);
        C4990ab.m7410d("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            this.vcp.mo9871bG(C1946aa.m4150a(((C46533dm) this.ehh.fsH.fsP).vFq));
            this.vcp.mo4498a(i, i2, i3, str, this.ehh, bArr);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(79367);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneAppCenter", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(79367);
    }

    public final int getType() {
        return 452;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(79368);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(79368);
        return a;
    }
}

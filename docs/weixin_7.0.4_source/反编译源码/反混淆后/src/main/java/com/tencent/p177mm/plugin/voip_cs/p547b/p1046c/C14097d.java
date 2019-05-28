package com.tencent.p177mm.plugin.voip_cs.p547b.p1046c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cow;
import com.tencent.p177mm.protocal.protobuf.cox;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c.d */
public final class C14097d extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C14097d(long j, long j2) {
        AppMethodBeat.m2504i(135380);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cow();
        c1196a.fsK = new cox();
        c1196a.uri = "/cgi-bin/micromsg-bin/csvoipredirect";
        this.ehh = c1196a.acD();
        cow cow = (cow) this.ehh.fsG.fsP;
        cow.xeF = j;
        cow.wen = j2;
        cow.wOP = System.currentTimeMillis();
        AppMethodBeat.m2505o(135380);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135381);
        C4990ab.m7417i("MicroMsg.NetSceneVoipCSRedirect", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135381);
    }

    public final int getType() {
        return 285;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135382);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135382);
        return a;
    }
}

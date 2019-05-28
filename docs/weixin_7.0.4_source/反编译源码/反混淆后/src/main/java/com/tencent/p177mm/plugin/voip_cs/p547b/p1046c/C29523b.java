package com.tencent.p177mm.plugin.voip_cs.p547b.p1046c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cor;
import com.tencent.p177mm.protocal.protobuf.cos;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c.b */
public final class C29523b extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C29523b(long j, long j2) {
        AppMethodBeat.m2504i(135374);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cor();
        c1196a.fsK = new cos();
        c1196a.uri = "/cgi-bin/micromsg-bin/csvoipheartbeat";
        this.ehh = c1196a.acD();
        cor cor = (cor) this.ehh.fsG.fsP;
        cor.xeF = j;
        cor.wen = j2;
        cor.wOP = System.currentTimeMillis();
        AppMethodBeat.m2505o(135374);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135375);
        C4990ab.m7417i("MicroMsg.NetSceneVoipCSHeartBeat", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135375);
    }

    public final int getType() {
        return 795;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135376);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135376);
        return a;
    }
}

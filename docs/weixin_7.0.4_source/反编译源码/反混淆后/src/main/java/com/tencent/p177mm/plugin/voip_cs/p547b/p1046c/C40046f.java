package com.tencent.p177mm.plugin.voip_cs.p547b.p1046c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cpb;
import com.tencent.p177mm.protocal.protobuf.cpc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c.f */
public final class C40046f extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C40046f(long j, long j2, int i) {
        AppMethodBeat.m2504i(135386);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cpb();
        c1196a.fsK = new cpc();
        c1196a.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        this.ehh = c1196a.acD();
        cpb cpb = (cpb) this.ehh.fsG.fsP;
        cpb.xeF = j;
        cpb.wen = j2;
        cpb.xmD = i;
        cpb.wOP = System.currentTimeMillis();
        AppMethodBeat.m2505o(135386);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135387);
        C4990ab.m7417i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135387);
    }

    public final int getType() {
        return 818;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135388);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135388);
        return a;
    }
}

package com.tencent.p177mm.plugin.voip_cs.p547b.p1046c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cop;
import com.tencent.p177mm.protocal.protobuf.coq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.voip_cs.b.c.a */
public final class C14096a extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C14096a(int i, long j, long j2, String str, int i2) {
        AppMethodBeat.m2504i(135371);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cop();
        c1196a.fsK = new coq();
        c1196a.uri = "/cgi-bin/micromsg-bin/csvoiphangup";
        this.ehh = c1196a.acD();
        cop cop = (cop) this.ehh.fsG.fsP;
        cop.wOQ = i;
        cop.xeF = j;
        cop.wen = j2;
        cop.xmv = str;
        cop.vIw = i2;
        cop.wOP = System.currentTimeMillis();
        AppMethodBeat.m2505o(135371);
    }

    public final int getType() {
        return 880;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135372);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135372);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135373);
        C4990ab.m7417i("MicroMsg.NetSceneVoipCSHangUp", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(135373);
    }
}
